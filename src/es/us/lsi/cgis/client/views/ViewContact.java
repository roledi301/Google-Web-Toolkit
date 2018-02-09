package es.us.lsi.cgis.client.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import es.us.lsi.cgis.client.ContactService;
import es.us.lsi.cgis.client.ContactServiceAsync;
import es.us.lsi.cgis.client.HaweightDietFinal;
import es.us.lsi.cgis.shared.Contact;

public class ViewContact extends Composite {
	
	
	private final ContactServiceAsync contactService = GWT.create(ContactService.class);
	
	private final FlexTable agendaPanel;
	private final HorizontalPanel mainPanel;
	
	public ViewContact() {
		
		// Panel principal e inicializacion de la vista 
		mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		agendaPanel 	= new FlexTable();
		
		//Panel para la agenda
		agendaPanel.setStylePrimaryName("contactTable");
		agendaPanel.getRowFormatter().setStylePrimaryName(0,"firstRow");
		agendaPanel.setWidget(0,0, new Label("Nombre"));
		agendaPanel.setWidget(0,1, new Label("Email"));	
		agendaPanel.setWidget(0,2, new Label("Titulacion"));
		agendaPanel.setWidget(0,3, new Label("Telefono"));
		/*agendaPanel.setWidget(0,3, new Label("Delete"));
		agendaPanel.setWidget(0,4, new Label("Update"));
		*/
		
		//Consultamos todos los pacientes
		contactService.getContacts(new AsyncCallback<List<Contact>>(){
			public void onSuccess(List<Contact> a){
				//Rellenamos la tabla con los pacientes
				showContacts(a);
			}

			@Override
			public void onFailure(Throwable e) {
				Window.alert("Error loading patients: " + e.getMessage());
				
			}
		});			
			
	/*	Button addButton = new Button("New");
		addButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {    	  
			    	// Activar la vista de creacion de pacientes
		    	  GestionPacientes2.go("create");
		      }
		    });*/
		mainPanel.add(agendaPanel);
		//mainPanel.add(addButton);		
	}
	
	
	/** METODO QUE INSERTA LOS DATOS DE LOS PACIENTES OBTENIDOS DE SERVIDOR Y LOS INSERTA EN LA TABLA (PANEL FLEXTABLE) */
	public final void showContacts(List<Contact> 	contactsParam){
	 
		int i = 0;
		final List<Contact> contacts = contactsParam;
		for (Contact key: contactsParam){
			final Contact keySearch = key;
			agendaPanel.setWidget(i+1, 0, new Label(key.getName()));
			agendaPanel.setWidget(i+1, 1, new Label(key.getEmail()));
			agendaPanel.setWidget(i+1, 2, new Label(key.getTitulacion()));
			agendaPanel.setWidget(i+1, 3, new Label(key.getTelefono()));
			
 
		/*	Button deleteButton = new Button("Delete");
			deleteButton.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			        final int indexRemoved = contacts.indexOf(keySearch);
			        contactService.deletePatient(indexRemoved, new AsyncCallback<Void>() {
						public void onSuccess(Void a){
							agendaPanel.removeRow(indexRemoved+1);
						}

						@Override
						public void onFailure(Throwable e) {
							Window.alert("Error deleting patient: " + e.getMessage());
						}
			  		  }); 
			      }
			    });		
			agendaPanel.setWidget(i+1, 3, deleteButton);
			
			
			Button updateButton = new Button("Update");
			updateButton.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	//Activar la vista de edicion de paciente
			        int indexUpdated = contacts.indexOf(keySearch);
			        Map<String,String> map = new HashMap<String,String>();
			        map.put("patient", indexUpdated+"");
			        GestionPacientes2.go("update",map);
			      }
			    });		
			agendaPanel.setWidget(i+1, 4, updateButton);*/	
			i++;		 
		}

	}
}
