package es.us.lsi.cgis.client.views;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DirectionalTextHelper;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import es.us.lsi.cgis.client.HaweightDietFinal;
import es.us.lsi.cgis.client.ContactService;
import es.us.lsi.cgis.client.ContactServiceAsync;
import es.us.lsi.cgis.shared.Contact;
import es.us.lsi.cgis.shared.NUHSAVerifier;

public class ViewDescription extends Composite{
 
	private final ContactServiceAsync contactService = GWT.create(ContactService.class);
//	final TextBox informacion = new TextBox();
	// TextBox informacion = new TextBox(); 
	 TextArea description = new TextArea();
	
	/*final TextBox telephone = new TextBox();
	final TextBox nuhsa = new TextBox();
	final Label errorLabel = new Label();*/
	
	public ViewDescription() {
		
		// Panel principal e inicializacion de la vista 
		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		
	//	final FlexTable formPanel = new FlexTable();
		//Button contactButton = new Button("Contacto");
		
		/*if (params.containsKey("patient")){ // Estamos editando un paciente
			final int index = Integer.parseInt(params.get("patient"));
			patientService.getPatient(index, new AsyncCallback<Contact>() {
	    		  public void onSuccess(Contact c){
	    			  onGet(c);
	    		  }
	    		  public void onFailure(Throwable e){
	    			  Window.alert("Error retrieving patient: " + e.getMessage());
	    		  }
	    		  
	    	  });
			
			contactButton.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  errorLabel.setText("");
			          String textToServer = nuhsa.getText();
			          if (!NUHSAVerifier.esNUHSAValido(textToServer)) {
			            errorLabel.setText("El NUSHA no es valido");
			            return;
			          }
			    	  Contact contact = new Contact(name.getValue(),telephone.getValue(), nuhsa.getValue());
			    	  patientService.updatePatients(index, contact, new AsyncCallback<Void>() {
			    		  public void onSuccess(Void v){
			    			  onSave();
			    		  }
			    		  public void onFailure(Throwable e){
			    			  Window.alert("Error updating patient: " + e.getMessage());
			    		  }
			    		  
			    	  });
			      }
			    });	
		}else{	// Estamos creando un nuevo paciente
			ContactButton.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  errorLabel.setText("");
			          if (!NUHSAVerifier.esNUHSAValido(nuhsa.getText())) {
			            errorLabel.setText("NUHSA Not Valid");
			            return;
			          }
			          else{			        	  
				    	  Contact contact = new Contact(name.getValue(),telephone.getValue(), nuhsa.getValue());
				    	  patientService.addPatient(contact, new AsyncCallback<Void>() {
				    		  public void onSuccess(Void v){
				    			  onSave();
				    		  }
				    		  public void onFailure(Throwable e){
				    			  Window.alert("Error adding patient: " + e.getMessage());
				    		  }
				    		  
				    	  });
			          }
			      }
			    });

		}*/
		
	/*	formPanel.setStylePrimaryName("updateTable");
		formPanel.setWidget(0,0, new Label("Name"));
		formPanel.setWidget(0,1, name);
		formPanel.setWidget(1,0, new Label("Telephone"));
		formPanel.setWidget(1,1, telephone);
		formPanel.setWidget(2,0, new Label("NUHSA"));
		formPanel.setWidget(2,1, nuhsa);
		mainPanel.add(formPanel);
		mainPanel.add(contactButton);
		errorLabel.setStylePrimaryName("serverResponseLabelError");
		mainPanel.add(errorLabel);*/
		
		Button contactButton = new Button("Desarrolladoras Contacto");
		contactButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {    	  
			    	// Activar la vista de creacion de pacientes
		    	 HaweightDietFinal.go("contact"); //create
		      }
		    });
		/*mainPanel.add(informacion);
		informacion.setText("HaweithgDiet es una aplicacion destinada al cuidado de la alimentacion \ndesde un punto de vista saludable. \n"
				+ "Para ello se propone dietas personalizadas para cada persona teniendo \nen cuenta su gasto calorico. \n"
				+ "El paciente estará controlado en todo momento por un médico \nque supervisará su conducta alimentaria. \n"
				+ "Esta aplicacion servira de intermediario para que ambos puedan intercambiar \n"
				+ "informacion estando en contacto en todo momento, en caso de que sea necesario. ");*/
		mainPanel.add(description);
		
		description.setText("Descripcion: \n"
				+ "\n"
				+ "HaweightDiet es una aplicacion destinada al cuidado de la alimentacion \ndesde un punto de vista saludable. \n"
				+ "Para ello se propone dietas personalizadas para cada persona teniendo \nen cuenta su gasto calorico. \n"
				+ "El paciente estara controlado en todo momento por un medico \nque supervisara su conducta alimentaria. \n"
				+ "Esta aplicacion servira de intermediario para que ambos puedan intercambiar \n"
				+ "informacion estando en contacto en todo momento, en caso de que sea necesario. \n"
				+ "\n"
				+ "Objetivos: \n"
				+ "\n"
				+ "1- Se pretende desarrollar una pagina web personalizada de dietas,\n"
				+ "de forma que mejore el estado de salud. Se disenara una\n"
				+ "dieta que presente los nutrientes necesarios para que dicha dieta\n"
				+ " se considere saludable.\n"
				+ "2- El programa contara con una serie de informacion de entrada,\n"
				+ "para poder calcular determinados factores que se tendran en\n"
				+ "cuenta en el diseno de la dieta (peso, altura, edad, ...).\n"
				+ "3- Se marcara un IMC (indice de masa corporal) a cumplir\n"
				+ "en un periodo fijado, teniendo en cuenta el IMC en\n"
				+ " el momento inicial.\n"
				+ "4- Como las dietas fallan porque no se adaptan facilmente a nuestros gustos,\n"
				+ "iremos confeccionando nuestra propia dieta con la supervision\n"
				+ "del medico.\n"
				+ "5- La web presentara un contador de caloria segun el objetivo marcado,\n"
				+ "el cual se ira reduciendo con la ingesta de alimentos a lo\n"
				+ "largo del dia.");
 
		description.setSize("500px", "600px");
		mainPanel.add(contactButton);
						
	}
	
/*	public void onGet(Contact c){
		name.setValue(c.getName());
		telephone.setValue(c.getEmail());
		nuhsa.setValue(c.getTitulacion());
	}
	*/
	public void onSave(){
		HaweightDietFinal.go("list");
	}
	
}
