/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs.encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marekszymanski
 */
@Entity
public class Pytanie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pytanie;
    private String dobraOdpowiedz;
    private List <String> zleOdpowiedzi;
    private String typ;

    public Pytanie() {
        zleOdpowiedzi = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public String getDobraOdpowiedz() {
        return dobraOdpowiedz;
    }

    public void setDobraOdpowiedz(String dobraOdpowiedz) {
        this.dobraOdpowiedz = dobraOdpowiedz;
    }

    public List<String> getZleOdpowiedzi() {
        return zleOdpowiedzi;
    }

    public void setZleOdpowiedzi(List<String> zleOdpowiedzi) {
        this.zleOdpowiedzi = zleOdpowiedzi;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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
        if (!(object instanceof Pytanie)) {
            return false;
        }
        Pytanie other = (Pytanie) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kurs.encje.Pytanie[ id=" + id + " ]";
    }
    
}
