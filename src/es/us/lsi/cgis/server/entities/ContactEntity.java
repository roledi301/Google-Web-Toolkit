
package es.us.lsi.cgis.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class ContactEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6513053175246310572L;

	/**
	 * 
	 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	String name;
	String email;
	String titulacion;
	String telefono;
	
	public ContactEntity(){
		
	}
	
	public ContactEntity(String name, String email, String titulacion, String telefono) {
		
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

	public Key getKey() {
		return key;
	}

	
}
