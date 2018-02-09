package es.us.lsi.cgis.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.us.lsi.cgis.client.ContactService;
import es.us.lsi.cgis.server.entities.ContactEntity;
import es.us.lsi.cgis.shared.NUHSAVerifier;
import es.us.lsi.cgis.shared.Contact;

public class ContactServiceImplJPA extends RemoteServiceServlet implements
		ContactService {

	private static final long serialVersionUID = -6759193213038377169L;

	public void init() {
		/*
		 * patients = new ArrayList<Patient>(); patients.add(new
		 * Patient("Gregorio Maranon", "111111111", "AN1234567890"));
		 * patients.add(new Patient("Alexander Fleming", "88888888",
		 * "AN0987654321")); patients.add(new Patient("Severo Ochoa",
		 * "XXXXXXXX", "AN0123456789"));
		 */
	}

	@Override
	public List<Contact> getContacts() {
		EntityManager em = getEm();
		List<ContactEntity> listaContactos = new ArrayList<>();
		List<Contact> listaContactosreturn = new ArrayList<>();
		try {
			 TypedQuery<ContactEntity> q =
				      em.createQuery("SELECT p FROM PatientEntity p", ContactEntity.class);
			
			listaContactos = q.getResultList();
			
		} finally {
			em.close();
		}
		
		for (ContactEntity pe:listaContactos){
			listaContactosreturn.add(toContact(pe));
		}

		return listaContactosreturn;
	}

	private EntityManager getEm() {
		return EMF.get().createEntityManager();

	}


	public void updateContacts(Integer i, Contact c) {
		// patients.set(i, c);
	}


	public Contact getContact(Integer i) {
		return null;
		// return contacts.get(i);
	}

	
	/*public void addPatient(Contact c) {
		if (!NUHSAVerifier.esNUHSAValido(c.getNUHSA())) {
			IllegalArgumentException exception = new IllegalArgumentException(
					"NUSHA not valid");
			throw exception;
		} else {
			EntityManager em = getEm();
			ContactEntity pe = new ContactEntity(c.getName(),c.getTelephone(),c.getNUHSA());
			try {
				em.getTransaction().begin();
				em.persist(pe);
				em.getTransaction().commit();
			} finally {
				em.close();
			}
		}
	}

	@Override
	public void deletePatient(Integer i) {
		//patients.remove(i.intValue());
	}*/
	
	private Contact toContact(ContactEntity p){
		return new Contact(p.getName(),p.getEmail(),p.getTitulacion(),p.getTelefono());
	}

}
