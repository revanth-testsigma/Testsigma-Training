package com.authentication.app.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Accesstokens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String token;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
	private String valid;

    public Accesstokens(String name2, String token, User userDe, String valid) {
        this.name = name2;
        this.token = token;
        this.user = userDe;
        this.valid = valid;
    }
    public Accesstokens(){}
}
