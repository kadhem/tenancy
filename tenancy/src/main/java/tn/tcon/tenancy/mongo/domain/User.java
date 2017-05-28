package tn.tcon.tenancy.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class User {

	@Id
	private String id;

	private String name;

	private String password;

	private String schemaNom;


	public User(String id, String name, String password, String schemaNom) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.schemaNom = schemaNom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchemaNom() {
		return schemaNom;
	}

	public void setSchemaNom(String schemaNom) {
		this.schemaNom = schemaNom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
