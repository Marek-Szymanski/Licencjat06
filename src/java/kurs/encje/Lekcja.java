/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs.encje;

import com.sun.mail.handlers.image_jpeg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    
    private String tytul1;
    @Column(length = 4000)
    private String tresc1;
    private String obrazek1;
    
    private String tytul2;
    @Column(length = 4000)
    private String tresc2;
    private String obrazek2;
    
    private String tytul3;
    @Column(length = 4000)
    private String tresc3;
    private String obrazek3;
    
    private String tytul4;
    @Column(length = 4000)
    private String tresc4;
    private String obrazek4;
    
    private String tytul5;
    @Column(length = 4000)
    private String tresc5;
    private String obrazek5;
    
    
    private String uklad;

    public Lekcja() {
        obrazek1 = "brak";
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

    public String getTytul1() {
        return tytul1;
    }

    public void setTytul1(String tytul1) {
        this.tytul1 = tytul1;
    }

    public String getTresc1() {
        return tresc1;
    }

    public void setTresc1(String tresc1) {
        this.tresc1 = tresc1;
    }

    public String getObrazek1() {
        return obrazek1;
    }

    public void setObrazek1(String obrazek1) {
        this.obrazek1 = obrazek1;
    }

    public String getUklad() {
        return uklad;
    }

    public void setUklad(String uklad) {
        this.uklad = uklad;
    }

    public String getTytul2() {
        return tytul2;
    }

    public void setTytul2(String tytul2) {
        this.tytul2 = tytul2;
    }

    public String getTresc2() {
        return tresc2;
    }

    public void setTresc2(String tresc2) {
        this.tresc2 = tresc2;
    }

    public String getObrazek2() {
        return obrazek2;
    }

    public void setObrazek2(String obrazek2) {
        this.obrazek2 = obrazek2;
    }

    public String getTytul3() {
        return tytul3;
    }

    public void setTytul3(String tytul3) {
        this.tytul3 = tytul3;
    }

    public String getTresc3() {
        return tresc3;
    }

    public void setTresc3(String tresc3) {
        this.tresc3 = tresc3;
    }

    public String getObrazek3() {
        return obrazek3;
    }

    public void setObrazek3(String obrazek3) {
        this.obrazek3 = obrazek3;
    }

    public String getTytul4() {
        return tytul4;
    }

    public void setTytul4(String tytul4) {
        this.tytul4 = tytul4;
    }

    public String getTresc4() {
        return tresc4;
    }

    public void setTresc4(String tresc4) {
        this.tresc4 = tresc4;
    }

    public String getObrazek4() {
        return obrazek4;
    }

    public void setObrazek4(String obrazek4) {
        this.obrazek4 = obrazek4;
    }

    public String getTytul5() {
        return tytul5;
    }

    public void setTytul5(String tytul5) {
        this.tytul5 = tytul5;
    }

    public String getTresc5() {
        return tresc5;
    }

    public void setTresc5(String tresc5) {
        this.tresc5 = tresc5;
    }

    public String getObrazek5() {
        return obrazek5;
    }

    public void setObrazek5(String obrazek5) {
        this.obrazek5 = obrazek5;
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
