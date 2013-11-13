package com.eni.web.component;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.eni.docmin.domain.service.EmployeeService;
import com.eni.web.context.Context;
import com.eni.web.service.ServiceLocator;

/**
 * Implementazione dell'interfaccia per l'accesso ai servizi business
 * del layer web.
 * @author fimperato
 */ 
public class ServiceLocatorImpl implements ServiceLocator, Serializable {
	/**	Compliance interfaccia serializable.	*/
	private static final long serialVersionUID = 1L;
	
	/**	Logger di sistema.	*/
	private Logger log = Logger.getLogger(this.getClass());
	
	/**	Contesto dell'applicazione	*/
	transient private ApplicationContext appContext;
	
	/**	Nome configurato del servizio per la gestione delle 
	 * view della parte italia.	*/
	private static final String PROXY_SERVICE_EMPLOYEE = "employeeService";
	/**	Variabile del servizio	*/
	private EmployeeService employeeService;
	
	/**	Nome configurato del servizio 'test'.	*/
	private static final String PROXY_SERVICE_TEST = "testService";
	
	/**	Nome configurato del servizio per la gestione JMS.	*/
	/**	private static final String PROXY_SERVICE_JMS = "jmsService"; */
	/**	Variabile del servizio	*/
	/**	private JmsService jmsService; */
	
	/**
	 * Costruttore del service locator.
	 * Carica il contesto spring dal contesto dell'applicazione ed
	 * effettua il lookup dei servizi in base ai loro nomi configurati.
	 */
	public ServiceLocatorImpl() {
		javax.servlet.ServletContext context = Context.getServletContext();
		this.appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		employeeService=(EmployeeService)
			lookupService(PROXY_SERVICE_EMPLOYEE);
		/*testService=(TestService)
			lookupService(PROXY_SERVICE_TEST);*/
		
		log.debug("Service locator bean is initialized");
		log.debug("Service locator "+ employeeService +" | "+ employeeService +" | "+ employeeService);
	}
	
	/**
	 * Effettua il lookup di un servizio basandosi sul
	 * nome configurato
	 */
	private Object lookupService(String serviceBeanName) {
		return appContext.getBean(serviceBeanName);
	}

	/**
	 * Restituisce il servizio per la gestione degli employee
	 * @return Il servizio di gestione.
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	
	

	/**
	 * Restituisce il servizio per la gestione JMS.
	 * @return Il servizio di gestione.
	 
	public JmsService getJmsService() {
		return jmsService;
	}
	*/

}
