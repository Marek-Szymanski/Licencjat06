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
import uzytkownik.Session.OsobaSession;
import uzytkownik.encje.Osoba;

/**
 *
 * @author marekszymanski
 */
@SessionScoped
@ManagedBean (name = "osobakontroler")
public class OsobaKontroler implements Serializable{
    @EJB
    OsobaSession osobaManager;
    
    private Osoba osoba;
    private Osoba osobaTemp;
    private List <Osoba> osobaList;
    
    private String haslo0;
    private String haslo1;
    private String haslo2;

    public OsobaKontroler() {
        osoba = new Osoba();
        osobaTemp = new Osoba();
        osobaList = new ArrayList <>();
               
    }
    
    public String zaloguj()
    {
        if(osobaManager.poLogin(osoba.getLogin()).isEmpty())
        {
            System.out.println("brak osoby");
            return null;
        }
        Osoba temp = osobaManager.poLogin(osoba.getLogin()).get(0);
        if(osoba.getLogin().equals(temp.getLogin()) && osoba.getHaslo().equals(temp.getHaslo()))
        {
            System.out.println("!!!");
            osoba = temp;
            System.out.println("@@@");
            if(temp.getStatus().equals("Administrator"))
            {
                osoba = temp;
                return "administratorStart";
            }
            else
            {
                osoba = temp;
                return "uczenStart";
            }
                
        }
        else
        {
            System.out.println("ERROR logowania dla "+temp.getStatus());
           return "index.xhtml";
        }
    }
    
    public void dodajOsobe()
    {
        System.out.println("Zaczynam dodawanie osoby");
        osobaManager.nowaOsoba(osobaTemp);
        System.out.println("Dodano osobe "+osoba.getImie());
        osobaTemp = new Osoba();
       
    }
    
    public void edytujOsobe()
    {
        osobaManager.edytuj(osoba);
    }
    
    public void wszytkieOsoby()
    {
        osobaList = osobaManager.wszystkie();
    }
    
    public void nadajStatusAdministratora(Osoba temp)
    {
        temp.setStatus("Administrator");
        osobaManager.edytuj(temp);
    }
    
    public void nadajStatusUcznia(Osoba temp)
    {
        temp.setStatus("Uczeń");
        osobaManager.edytuj(temp);
    }
    
    public void nadajStatusZablokowany(Osoba temp)
    {
        temp.setStatus("Zablokowany");
        osobaManager.edytuj(temp);
    }
    
    public void zmianaHasla()
    {
        if(osoba.getHaslo().equals(haslo0))
        {
            if(haslo1.equals(haslo2))
            {
                osoba.setHaslo(haslo2);
                edytujOsobe();
            }
            else
            {
                //ERROR "Podane hasła nie są zgodne"
            }
        }
        else
        {
            //ERROR "Podane hasło jest niepoprawne"
        }
        haslo0 = null;
        haslo1 = null;
        haslo2 = null;
    }
    
    //GET && SET
    
    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public List<Osoba> getOsobaList() {
        return osobaList;
    }

    public void setOsobaList(List<Osoba> osobaList) {
        this.osobaList = osobaList;
    }

    public String getHaslo1() {
        return haslo1;
    }

    public String getHaslo0() {
        return haslo0;
    }

    public void setHaslo0(String haslo0) {
        this.haslo0 = haslo0;
    }

    public void setHaslo1(String haslo1) {
        this.haslo1 = haslo1;
    }

    public String getHaslo2() {
        return haslo2;
    }

    public void setHaslo2(String haslo2) {
        this.haslo2 = haslo2;
    }

    public Osoba getOsobaTemp() {
        return osobaTemp;
    }

    public void setOsobaTemp(Osoba osobaTemp) {
        this.osobaTemp = osobaTemp;
    }
    
}
