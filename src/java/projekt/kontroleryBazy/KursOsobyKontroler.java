/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.kontroleryBazy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import uzytkownik.Session.KursOsobySession;
import uzytkownik.encje.KursOsoby;

/**
 *
 * @author marekszymanski
 */
@ManagedBean (name = "kursosobykontroler")
@SessionScoped
public class KursOsobyKontroler implements Serializable
{
    @EJB
    KursOsobySession kursOsobyManager;
    
    KursOsoby kursOsoby = new KursOsoby();
    List<KursOsoby> kursyOsoby = new ArrayList<>();
    
    public void zapisz()
    {
        kursOsobyManager.nowyKursOsoby(kursOsoby);
    }

    public KursOsoby getKursOsoby() {
        return kursOsoby;
    }

    public void setKursOsoby(KursOsoby kursOsoby) {
        this.kursOsoby = kursOsoby;
    }

    public List<KursOsoby> getKursyOsoby() {
        return kursyOsoby;
    }

    public void setKursyOsoby(List<KursOsoby> kursyOsoby) {
        this.kursyOsoby = kursyOsoby;
    }
    
    
    
}
