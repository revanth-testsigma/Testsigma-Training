package com.authentication.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.app.dao.Tokenrepo;
import com.authentication.app.model.Accesstokens;
import com.authentication.app.model.User;

@Service
public class TokenService {
    
    @Autowired
    private Tokenrepo repo;
    
    public List<Accesstokens> findByUser(User user) {
        return repo.findByUser(user);
    }
     
    public void save(Accesstokens tok) {
        repo.save(tok);
    }
    public Accesstokens findByName(String name){
        return repo.findByName(name);
    }
    public Accesstokens get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }

}
