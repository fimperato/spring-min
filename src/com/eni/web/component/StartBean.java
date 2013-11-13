package com.eni.web.component;

import java.io.Serializable;

import com.eni.docmin.domain.EmployeeEntity;
import com.eni.web.context.Context;
import com.eni.web.service.ServiceLocator;

/**
 * Componente per la visualizzazione della pagina iniziale.
 * @author fimperato 
 */
public class StartBean implements Serializable {
	/**	Compliance interfaccia Serializable.	*/
	private static final long serialVersionUID = 1L;
	
	/**	Service locator.	*/
	private ServiceLocator serviceLocator;
	
	private String testConn;
	
	
	// -------------------------------------------------------------------
	//					Regole di navigazione
	// -------------------------------------------------------------------
	
	/**
	 * Regola di navigazione.
	 * @return La stringa "nav1".
	 */
	public String nav1() {
		Context.setSessionAttribute("valSearch", null);
		return "nav1";
	}

	/**
	 * Regola di navigazione.
	 * @return La stringa "nav2".
	 */
	public String nav2() {
		return "nav2";
	}

	/**
	 * Regola di navigazione.
	 * @return La stringa "nav3".
	 */
	public String nav3() {
		return "nav3";
	}
	
	public String getTestConn() {
		this.testConn = "-";
		try {
			EmployeeEntity e = serviceLocator.getEmployeeService().getEmployee(1);
			this.testConn = e.getFirstName();
			this.testConn = "Mr. "+this.testConn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.testConn;
	}

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	
}