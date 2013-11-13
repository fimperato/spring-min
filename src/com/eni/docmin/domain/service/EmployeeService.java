package com.eni.docmin.domain.service;

import java.util.List;

import com.eni.docmin.domain.EmployeeEntity;

/**
 * Servizio di accesso dati per la gestione degli employee.
 * 
 * @author fimperato
 */
public interface EmployeeService {
	
	/**
	 * Inserisce lo employee passato come parametro.
	 * @param employeeEntity L'oggetto da rendere persistente.
	 */
	public void saveEmployee(EmployeeEntity employeeEntity) throws Exception;

	/**
	 * Aggiorna lo employee passato come parametro.
	 * @param employeeEntity L'oggetto da rendere persistente.
	 */
	public void updateEmployee(EmployeeEntity employeeEntity) throws Exception;
	
	/**
	 * Elimina lo employee passato come parametro.
	 * @param employeeEntity lo employee da eliminare.
	 */
	public void deleteEmployee(EmployeeEntity employeeEntity) throws Exception;
	
	/**
	 * Get product by id.
	 * @param id the id
	 * @return the employee associated with the id
	 * @throws EmployeeException
	 */
	public EmployeeEntity getEmployee(Integer id) throws Exception;
	
	/**
	 * Restituisce l'elenco di tutte gli employee dei messaggi.
	 * @return L'elenco degli employee.
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> getAllEmployee() throws Exception;
	
	/**
	 * Restituisce l'elenco degli employee in base ai parametri
	 * passati come argomento.
	 * @param startPeriod L'inizio del periodo.
	 * @param endPeriod La fine del periodo.
	 * @param status Lo stato.
	 * @return La lista filtrata.
	 
	public List<EmployeeEntity> findByParameter(String startPeriod, String endPeriod, String status)throws Exception;
	*/
	
}
