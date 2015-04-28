/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzytkownik.Session;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import uzytkownik.encje.Osoba;

/**
 *
 * @author marekszymanski
 */
@Stateless
public class OsobaSession implements Serializable{

    @PersistenceContext
    EntityManager manager;
    
    public void nowaOsoba(Osoba osoba) 
    {
        List <Osoba> temp = wszystkie();
        if(temp.size() == 0||temp.size() == 1)
            osoba.setStatus("Administrator");
        else
            osoba.setStatus("Uczeń");
        if(poLogin(osoba.getLogin()).isEmpty() && poMail(osoba.getMail()).isEmpty())
            manager.persist(osoba);
        //else
            //ERROR
    }
    
    public List<Osoba> wszystkie() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Osoba.class));
        return manager.createQuery(cq).getResultList();
    }
    
    public Osoba poID(int id)
    {
        return manager.find(Osoba.class, id);
    }
    
    public void edytuj(Osoba osoba)
    {
        manager.merge(osoba);
    }
    
    public List<Osoba> poLogin(String login)
    {
        // Select the employees and the mailing addresses that have the same address.
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Osoba.class);
        cq.multiselect(e);
        cq.where(cb.equal(e.get("login"), login));
        Query query = manager.createQuery(cq);
        List<Osoba> result = query.getResultList();
        //named query
        return result;
    }
    
    public List<Osoba> poMail(String mail)
    {
        // Select the employees and the mailing addresses that have the same address.
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Osoba.class);
        cq.multiselect(e);
        cq.where(cb.equal(e.get("mail"), mail));
        Query query = manager.createQuery(cq);
        List<Osoba> result = query.getResultList();
        return result;
    }
}
