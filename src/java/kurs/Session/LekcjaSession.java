/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs.Session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import kurs.encje.Lekcja;

/**
 *
 * @author marekszymanski
 */
@Stateless
public class LekcjaSession {

    @PersistenceContext
    EntityManager manager;
    
    public void nowaLekcja(Lekcja lekcja) 
    {
        
        manager.persist(lekcja);
    }
    
    public void edytuj(Lekcja lekcja)
    {
        manager.merge(lekcja);
    }
    
    public List<Lekcja> wszystkie() {
        return (List<Lekcja>) manager.createQuery("select l from Lekcja l").getResultList();
    }
    
    public Lekcja poID(int id)
    {
        return manager.find(Lekcja.class, id);
    }
    
    
}
