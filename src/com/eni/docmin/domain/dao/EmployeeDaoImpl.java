package com.eni.docmin.domain.dao;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.eni.docmin.domain.EmployeeEntity;

/**
 * Modulo di accesso dati
 * 
 * @author fimperato
 */
public class EmployeeDaoImpl extends AbstractDao {
	/**	Logger di sistema.	*/
	private Logger log = Logger.getLogger(this.getClass());

	/** Segnaposto statico.	*/
	final static String NOMINE_ITALIA = "nomineItalia";

	/**
	 * Restituisce un employee il cui identificativo è passato come parametro.
	 * @param id L'identificativo di employee
	 * @return Lo employee selezionato.
	 */
	public EmployeeEntity find(Integer id) {
		return (EmployeeEntity) super.find(EmployeeEntity.class, id);
	}

	/**
	 * Aggiorna o inserisce lo employee passato come parametro.
	 * @param employeeEntity L'oggetto da rendere persistenete.
	 */
	public void saveOrUpdate(EmployeeEntity employeeEntity) {
		super.saveOrUpdate(employeeEntity);
	}

	/**
	 * Elimina lo employee passato come parametro.
	 * @param employeeEntity Lo employee da eliminare.
	 */
	public void delete(EmployeeEntity employeeEntity) {
		super.delete(employeeEntity);
	}

	/**
	 * Restituisce l'elenco di tutte gli employee.
	 * @return L'elenco degli employee.
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> findAll() {
		return super.findAll(EmployeeEntity.class);
	}

	/**
	 * Restituisce l'elenco degli employee in base ai parametri
	 * passati come argomento.
	 * @param startPeriod
	 * @param endPeriod
	 * @param status.
	 * @return La lista filtrata.
	 
	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> findByParameter(String startPeriod,
			String endPeriod, String status) { }
	*/
}
