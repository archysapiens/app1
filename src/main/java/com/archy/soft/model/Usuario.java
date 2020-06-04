package com.archy.soft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String direccion;
	
	private int edad;
	
	public Usuario(String pname, String pdireccion,int pedad ) {
		// TODO Auto-generated constructor stub
		
		this.name =pname;
		this.direccion=pdireccion;
		this.edad=pedad;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

	
}
