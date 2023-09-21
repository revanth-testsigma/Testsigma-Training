package com.ordersystem.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Boolean;
import java.lang.reflect.Field;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;

import com.ordersystem.app.dto.Searchreq;
import com.ordersystem.app.Model.Customer;
import com.ordersystem.app.Model.Orders;
import com.ordersystem.app.dto.Req;

@Service
public class FiltersSpecification<T> {

     public Specification<T> getSearchSpecification(List<Searchreq> searchreqs, Req.Operators globalOperator) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            List<String> cols = getColumnNames(root);
            for(Searchreq requestDto : searchreqs){
                Expression<String> roots;
                
                if ((requestDto.getColumn()).contains("@")){
                    String[] splits = (requestDto.getColumn()).split("@");
                    requestDto.setColumn(splits[1]);
                    roots = root.join(splits[0], JoinType.INNER).get(requestDto.getColumn());
                    
                }else if(cols.indexOf(requestDto.getColumn()) == -1){
                    roots = root.join("customer", JoinType.INNER).get(requestDto.getColumn());
                }
                else{
                    roots = root.get(requestDto.getColumn());
                }
                switch (requestDto.getOperation()){

                    case EQUAL:
                        Predicate equal;
                        if (roots.getJavaType().equals(Boolean.class)){
                            equal = criteriaBuilder.equal(roots, Boolean.parseBoolean(requestDto.getValue()));

                        }else if(roots.getJavaType().isEnum()){
                            Class<?> c = ((Path<?>)roots).getModel().getBindableJavaType();
                            Object val = Enum.valueOf((Class<Enum>) c, requestDto.getValue());
                            equal = criteriaBuilder.equal(roots, val);
                        }
                        else{
                            equal = criteriaBuilder.equal(roots, requestDto.getValue());
                        }
                        predicates.add(equal);
                        
                        break;

                    case LIKE:
                        Predicate like = criteriaBuilder.like(roots, "%"+requestDto.getValue()+"%");
                        predicates.add(like);
                        break;
                    case STARTS:
                        Predicate starts = criteriaBuilder.like(roots, requestDto.getValue()+"%");
                        predicates.add(starts);
                        break;
                    case ENDS:
                        Predicate ends = criteriaBuilder.like(roots, "%"+requestDto.getValue());
                        predicates.add(ends);
                        break;

                    case IN:
                        String[] split = requestDto.getValue().split(",");
                        Predicate in = roots.in(Arrays.asList(split));
                        predicates.add(in);
                        break;

                    case GREATER_THAN:
                        Predicate greaterThan = criteriaBuilder.greaterThan(roots, requestDto.getValue());
                        predicates.add(greaterThan);
                        break;

                    case LESS_THAN:
                        Predicate lessThan = criteriaBuilder.lessThan(roots, requestDto.getValue());
                        predicates.add(lessThan);
                        break;
                    case ASC:
                        query.orderBy(criteriaBuilder.asc(roots)); 
                        predicates.add(criteriaBuilder.conjunction());
                        break;
                    case DESC:
                        query.orderBy(criteriaBuilder.desc(roots)); 
                        predicates.add(criteriaBuilder.conjunction());
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + requestDto.getOperation());
                }

            }

            if(globalOperator.equals(Req.Operators.AND)) {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }else if(globalOperator.equals(Req.Operators.OR)){
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }else{
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
    private <T> List<String> getColumnNames(Root <T> root) {
        EntityType<T> entityType = root.getModel();
        List<String> columnNames = new ArrayList<>();
        for (Attribute<T, ?> attribute : entityType.getDeclaredAttributes()) {
            columnNames.add(attribute.getName());
        }
        return columnNames;
    }
}