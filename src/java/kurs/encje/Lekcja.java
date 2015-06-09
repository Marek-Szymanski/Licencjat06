/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs.encje;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marekszymanski
 */
@Entity
public class Lekcja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nazwa;
    
    
    private String[] tytul = new String[5];
    @Column(length = 4000)
    private String[] tresc = new String[5];
    private String[] obrazek = new String[5];
    
    private String uklad;

    public Lekcja() {
        uklad = "uklad";
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

    public String getUklad() {
        return uklad;
    }

    public void setUklad(String uklad) {
        this.uklad = uklad;
    }

    public String[] getTytul() {
        return tytul;
    }

    public void setTytul(String[] tytul) {
        this.tytul = tytul;
    }

    public String[] getTresc() {
        return tresc;
    }

    public void setTresc(String[] tresc) {
        this.tresc = tresc;
    }

    public String[] getObrazek() {
        return obrazek;
    }

    public void setObrazek(String[] obrazek) {
        this.obrazek = obrazek;
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
        if (!(object instanceof Lekcja)) {
            return false;
        }
        Lekcja other = (Lekcja) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kurs.encje.Lekcja[ id=" + id + " ]";
    }
    
}
