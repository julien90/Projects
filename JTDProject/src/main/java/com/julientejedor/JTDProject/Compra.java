package com.julientejedor.JTDProject;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private String category;
	

	public int getId() {		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {		
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}
