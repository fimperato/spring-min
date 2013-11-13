package com.eni.web.context;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

/**
 * Offre strumenti per l'accesso al contesto dell'applicazione web.
 * @author a.menegaz
 */
public class Context {
	
	/**
	 * Restituisce la sessione Hibernate.
	 * @return La sessione Hibernate.
	 */
	public static Session getHibernateSession() {
		return (Session) ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getAttribute("session");
	}

	/**
	 * Restituisce la sessione Http.
	 * @param create Se <code>true</code> viene restituita 
	 * 				una nuova sessione nel caso non ne esista
	 * 				una attuale.
	 * @return La sessione Http.
	 */
	public static HttpSession getSession(boolean create) {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(create);

	}

	/**
	 * Restituisce la sessione Http.
	 * Nel caso non ne esista una attuale, ne viene restituita 
	 * una nuova.
	 * @return La sessione Http.
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
	}

	/**
	 * Restituisce il FacesContext.
	 * @return Il FacesContext.
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Retituisce un bean configurato in base al nome
	 * passato come parametro.
	 * @param name Il nome del bean configurato.
	 * @return Il bean richiesto.
	 */
	@SuppressWarnings("deprecation")
	public static Object getBean(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Object bean = fc.getApplication().getVariableResolver()
				.resolveVariable(fc, name);
		return bean;
	}

	/**
	 * Carica un parametro dalla richiesta Http.
	 * @param name Il nome del parametro.
	 * @return Il valore del parametro come stringa.
	 */
	public static String getRequestParameter(String name) {
		return (String) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(name);
	}

	/**
	 * Carica un parametro dalla richiesta Http.
	 * @param name Il nome del parametro.
	 * @return Il valore del parametro.
	 */
	public static Object getRequestParameterValues(String name) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(name);
	}

	/**
	 * Carica un parametro dalla sessione Http.
	 * @param name Il nome del parametro.
	 * @return Il valore del parametro.
	 */
	public static Object getSessionAttribute(String name) {
		return getSession().getAttribute(name);
	}

	/**
	 * Carica un parametro nella sessione Http.
	 * @param name Il nome del parametro.
	 * @param obj L'oggetto da salvare.
	 */
	public static void setSessionAttribute(String name, Object obj) {
		getSession().setAttribute(name, obj);
	}

	/**
	 * Restiruisce il contesto delle servlet.
	 * @return Il ServletContext.
	 */
	public static ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

}
