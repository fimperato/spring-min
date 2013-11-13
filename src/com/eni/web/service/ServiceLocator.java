package com.eni.web.service;

import com.eni.docmin.domain.service.EmployeeService;

/**
 * Interfaccia per l'accesso ai servizi business del layer web.
 * 
 * @author fimperato
 */
public interface ServiceLocator {

	/**
	 * Restituisce il servizio per la gestione degli employee.
	 * @return Il servizio di gestione.
	 */
	public EmployeeService getEmployeeService();
}
