/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindMap.Session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mindMap.encje.Kurs;

/**
 *
 * @author marekszymanski
 */
@Stateless
public class KursSession {

    @PersistenceContext
    EntityManager manager;
    
    public void nowyKurs(Kurs kurs) 
    {
        
        if(poNazwa(kurs.getNazwa()).isEmpty())
            manager.persist(kurs);
        //else
            //ERROR
    }
    
    public List<Kurs> wszystkie() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Kurs.class));
        return manager.createQuery(cq).getResultList();
    }
    
    public Kurs poID(int id)
    {
        return manager.find(Kurs.class, id);
    }
    
    public void edytuj(Kurs kurs)
    {
        manager.merge(kurs);
    }
    
    public List<Kurs> poNazwa(String nazwa)
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Kurs.class);
        cq.multiselect(e);
        cq.where(cb.equal(e.get("nazwa"), nazwa));
        Query query = manager.createQuery(cq);
        List<Kurs> result = query.getResultList();
        return result;
    }
}
