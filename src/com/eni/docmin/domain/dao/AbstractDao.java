package com.eni.docmin.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * La classe AbstractDao offre metodi di utilità per l'accesso ai dati.
 * Wrappa alcuni dei metodi offerti dal supporto Hibernate di Spring.
 * 
 * @author fimperato
 */
public abstract class AbstractDao extends HibernateDaoSupport {
	
	/**
	 * Costruttore di default.
	 */
	public AbstractDao() {
		super();
	}

	/**
	 * Salva o aggiorna un oggetto all'interno della base dati.
	 * @param obj L'oggetto da salvare o aggiornare.
	 */
    protected void saveOrUpdate(Object obj) {
        getHibernateTemplate().saveOrUpdate(obj);
    }

    /**
     * Elimina un oggetto dalla base di dati sottostante.
     * @param obj L'oggetto da eliminare.
     */
    protected void delete(Object obj) {
        getHibernateTemplate().delete(obj);
    }

    /**
     * Restituisce l'oggetto del tipo specificato da 
     * <code>clazz</code> ed identificativo <code>id</code>.
     * @param clazz La classe di appartenenza dell'oggetto da
     * 				restituire.
     * @param id	L'identificativo dell'oggetto.
     * @return		L'oggetto ricercato.
     * 
     * @see HibernateTemplate#load(Object, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
	protected Object find(Class clazz, Integer id) {
        return getHibernateTemplate().load(clazz, id);
    }
    
    /**
     * Restituisce l'oggetto del tipo specificato da 
     * <code>clazz</code> ed identificativo <code>id</code>.
     * @param clazz La classe di appartenenza dell'oggetto da
     * 				restituire.
     * @param id	L'identificativo dell'oggetto.
     * @return		L'oggetto ricercato.
     * 
     * @see HibernateTemplate#load(Object, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
	protected Object find(Class clazz, Long id) {
        return getHibernateTemplate().load(clazz, id);
    }
    
    /**
     * Restituisce l'oggetto del tipo specificato da 
     * <code>clazz</code> ed identificativo <code>id</code>.
     * @param clazz La classe di appartenenza dell'oggetto da
     * 				restituire.
     * @param id	L'identificativo dell'oggetto.
     * @return		L'oggetto ricercato.
     * 
     * @see HibernateTemplate#load(Object, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
	protected Object find(Class clazz, BigDecimal id) {
        return getHibernateTemplate().load(clazz, id);
    }

    /**
     * Restituisce la lista degli oggetti del tipo specificato da 
     * <code>clazz</code>.
     * @param clazz La classe di appartenenza degli oggetti da
     * 				restituire.
     * @return		L'oggetto ricercato.
     * 
     * @see HibernateTemplate#find(String)
     */
    @SuppressWarnings("unchecked")
	protected List findAll(Class clazz) {
        return getHibernateTemplate().find("from " + clazz.getName());
    }
    
    /**
     * Restituisce la sessione hibernate corrente.
     * @return La sessione corrente.
     * @see org.hibernate.SessionFactory#getCurrentSession()
     */
    protected Session hibSess(){
    	return getHibernateTemplate().getSessionFactory()
		.getCurrentSession();
    }
}
