package es.us.lsi.cgis.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import es.us.lsi.cgis.client.views.ViewDescription;
import es.us.lsi.cgis.client.views.ViewContact;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HaweightDietFinal implements EntryPoint {
	
	public void onModuleLoad() {
		
		go("init", new HashMap<String,String>());
	}
	
	public static void go(String token){
		HaweightDietFinal.go(token, new HashMap<String,String>());
	}
	
	// FLOW MANAGEMENT
	public static void go(String token, Map<String,String> params){
		Panel p = RootPanel.get();
		if (token=="list" || token=="init" ){
			p.clear();
			p.add(new ViewDescription());
		}else if (token=="contact" ){
			 p.clear();
			p.add(new ViewContact());
		}/*else if (token=="update"){
			//NEW WINDOW: p.clear();
			p.add(new ViewDescription(params));
		}*/
		
	}
	
}
