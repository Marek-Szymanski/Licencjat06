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
import mindMap.Session.KategoriaSession;
import mindMap.encje.Kategoria;

/**
 *
 * @author marekszymanski
 */
@ManagedBean (name = "kategoriakontroler")
@SessionScoped
public class KategoriaKontroler implements Serializable{
    @EJB
    public KategoriaSession kategoriaManager;
    
    
    private Kategoria kategoria = new Kategoria();
    private List <Kategoria> kategoriaList = new ArrayList <>();
    
    private int tempID;
    
    
    public void zapiszKategorie()
    {
        kategoriaManager.zapisz(kategoria);
    }
    
    public void edytujKategorie()
    {
        kategoriaManager.edytuj(kategoria);
    }
    
    public void pobierzWszystkieKategorie()
    {
        kategoriaList = kategoriaManager.wszystkie();
    }
    
    
    
    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public List<Kategoria> getKategoriaList() {
        return kategoriaList;
    }

    public void setKategoriaList(List<Kategoria> kategoriaList) {
        this.kategoriaList = kategoriaList;
    }

    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }

}
