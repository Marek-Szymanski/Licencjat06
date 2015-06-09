/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindMap.encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * 
 */
@Entity
public class Kategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nazwa;
    @OneToMany
    private List <Kurs> kursy;
    @OneToMany
    private List <Kategoria> podkategorie;
    
    public Kategoria() {
        kursy = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Kurs> getKursy() {
        return kursy;
    }

    public void setKursy(List<Kurs> kursy) {
        this.kursy = kursy;
    }

    public List<Kategoria> getPodkategorie() {
        return podkategorie;
    }

    public void setPodkategorie(List<Kategoria> podkategorie) {
        this.podkategorie = podkategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mindMap.encje.Kategoria[ id=" + id + " ]";
    }
    
}
