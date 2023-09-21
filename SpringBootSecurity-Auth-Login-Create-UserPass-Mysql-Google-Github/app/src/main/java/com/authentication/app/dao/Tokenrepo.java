package com.authentication.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.authentication.app.model.Accesstokens;
import com.authentication.app.model.User;

import java.util.List;


@Repository
public interface Tokenrepo extends JpaRepository<Accesstokens, Integer>{
	List<Accesstokens> findByUser(User user);
	Accesstokens findByName(String name);
}
