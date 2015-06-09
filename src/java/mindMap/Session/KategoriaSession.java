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
import mindMap.encje.Kategoria;

/**
 *
 * @author marekszymanski
 */
@Stateless
public class KategoriaSession {

    @PersistenceContext
    EntityManager manager;
    
    public void zapisz(Kategoria kategoria)
    {
        if(poNazwa(kategoria.getNazwa()).isEmpty())
            manager.persist(kategoria);
        
    }
    
    public void edytuj(Kategoria kategoria)
    {
        
            manager.merge(kategoria);
    }
    
    public List<Kategoria> wszystkie() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Kategoria.class));
        return manager.createQuery(cq).getResultList();
    }
    
    public Kategoria poID(int id)
    {
        return manager.find(Kategoria.class, id);
    }
    
    public List<Kategoria> poNazwa(String nazwa)
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Kategoria.class);
        cq.multiselect(e);
        cq.where(cb.equal(e.get("nazwa"), nazwa));
        Query query = manager.createQuery(cq);
        List<Kategoria> result = query.getResultList();
        return result;
    }
}
