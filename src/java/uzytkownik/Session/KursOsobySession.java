/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzytkownik.Session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import uzytkownik.encje.KursOsoby;
import uzytkownik.encje.Osoba;

/**
 *
 * @author marekszymanski
 */
@Stateless
public class KursOsobySession {

    @PersistenceContext
    EntityManager manager;
    
    public void nowyKursOsoby(KursOsoby kurs)
    {
        manager.persist(kurs);
    }
    
    public void edytujPostep(KursOsoby kurs)
    {
        manager.merge(kurs);
    }
    
    public List<KursOsoby> poNazwa(String nazwa)
    {
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Osoba.class);
        cq.multiselect(e);
        cq.where(cb.equal(e.get("nazwa"), nazwa));
        Query query = manager.createQuery(cq);
        List<KursOsoby> result = query.getResultList();
        //named query
        return result;
    }
}
