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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import mindMap.Session.KursSession;
import mindMap.encje.Kurs;


/**
 *
 * @author marekszymanski
 */
@ManagedBean (name = "kurskontroler")
@SessionScoped
public class KursKontroler implements Serializable{
    @EJB
    public KursSession kursManager;
    
    Kurs kurs = new Kurs();
    List <Kurs> kursList = new ArrayList<>();
    
    private int tempID;
    
    public void zapiszKurs()
    {
        kursManager.nowyKurs(kurs);
    }
    
    public void edytujKurs()
    {
        kursManager.edytuj(kurs);
    }
    
    public void pobierzWszystkieKursy()
    {
        kursList = kursManager.wszystkie();
    }
    
    
    
    

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }

    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }
    
}
