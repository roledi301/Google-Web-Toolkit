
package es.us.lsi.cgis.shared;

import java.io.Serializable;

public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6513053175246310572L;

	/**
	 * 
	 */
	
	String name;
	String email;
	String titulacion;
	String telefono; 
	
	public Contact(){
		
	}

	public Contact(String name, String email, String titulacion, String telefono) {
		super();
		this.name = name;
		this.email = email;
		this.titulacion = titulacion;
		this.telefono = telefono;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
