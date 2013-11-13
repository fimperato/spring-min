package com.eni.docmin.domain.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;

import com.eni.docmin.domain.EmployeeEntity;
import com.eni.docmin.domain.dao.EmployeeDaoImpl;

/**
 * Implementazione del servizio di accesso dati per la gestione degli employee.
 * 
 * @author fimperato
 */
public class EmployeeServiceImpl implements EmployeeService {
	/**	Logger di sistema.	*/
	private Logger log = Logger.getLogger(this.getClass());
	
	/**	Modulo di accesso dati.	*/
	private EmployeeDaoImpl employeeDao;
	
	/**
	 * Setta il modulo di accesso dati. 
	 * Utilizzato dall' IOC container di Spring.
	 * @param employeeDaoImpl Il modulo di accesso.
	 */
	public void setEmployeeDao(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDao = employeeDaoImpl;
	}

	/**
	 * Inserisce lo employee passato come parametro.
	 * @param employeeEntity L'oggetto da rendere persistenete.
	 */
	public void saveEmployee(EmployeeEntity employeeEntity) throws Exception {
			log.debug(("entering method saveEmployee"));
		try {
			this.employeeDao.saveOrUpdate(employeeEntity);
		} catch (DataIntegrityViolationException de) {
			String msg = "Could not save employeeEntity, duplicate employeeEntity id";
			log.error(msg, de);
			throw new Exception(msg, de);
		} catch (Exception e) {
			String msg = "Could not save employeeEntity " + e.toString();
			log.error(msg, e);
			throw new Exception(msg, e);
		}
	}

	/**
	 * Aggiorna lo employee passato come parametro.
	 * @param employeeEntity L'oggetto da rendere persistenete.
	 */
	public void updateEmployee(EmployeeEntity employeeEntity) throws Exception {
		employeeDao.saveOrUpdate(employeeEntity);
	}
	
	/**
	 * Elimina lo employee passata come parametro.
	 * @param employeeEntity Lo employee da eliminare.
	 */
	public void deleteEmployee(EmployeeEntity employeeEntity) throws Exception {
		employeeDao.delete(employeeEntity);
	}

	/**
	 * Restituisce l'elenco di tutti gli employee.
	 * @return L'elenco degli employee.
	 */
	@SuppressWarnings("unchecked")
	public List getAllEmployee() throws Exception {
		try {
			return employeeDao.findAll();
		} catch (Exception e) {
			String msg = "Could not get all employee";
			log.error(msg, e);
			throw new Exception(msg, e);
		}
	} 

	/**
	 * Restituisce un employee il cui identificativo è
	 * passato come parametro.
	 * @param id L'identificativo dell'employee
	 * @return Lo employee selezionata.
	 */
	public EmployeeEntity getEmployee(Integer id) throws Exception {
		try {
			return this.employeeDao.find(id);
		} catch (Exception e) {
			String msg = "Could not get employee for id of " + id;
			log.error(msg, e);
			throw new Exception(msg, e);
		}
	}

	/**
	 * Restituisce l'elenco degli employee in base ai parametri
	 * passati come argomento.
	 * @param startPeriod L'inizio del periodo.
	 * @param endPeriod La fine del periodo.
	 * @param status Lo stato.
	 * @return La lista filtrata.
	 * 
	public List<EmployeeEntity> findByParameter(String startPeriod, String endPeriod, String status) 
			throws Exception {
			try {
				return this.employeeDao.findByParameter(startPeriod, endPeriod, status);
			} catch (Exception e) {
				String msg = "Could not get acquisitionlog for id of ";
				log.error(msg, e);
				throw new Exception(msg, e);
			}
		}
	 */
}
