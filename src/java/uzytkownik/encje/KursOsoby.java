/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzytkownik.encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import kurs.encje.Pytanie;
import mindMap.encje.Kurs;

/**
 *
 * @author marekszymanski
 */
@Entity
public class KursOsoby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Kurs kurs;
    private List <Float> wynikiLekcji;
    @OneToMany
    private List <Pytanie> pytaniaTestowe;
    private float wynik;

    public KursOsoby() {
        wynikiLekcji = new ArrayList<>();
        pytaniaTestowe = new ArrayList<>();
        wynik = 0f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public List<Float> getWynikiLekcji() {
        return wynikiLekcji;
    }

    public void setWynikiLekcji(List<Float> wynikiLekcji) {
        this.wynikiLekcji = wynikiLekcji;
    }

    public List<Pytanie> getPytaniaTestowe() {
        return pytaniaTestowe;
    }

    public void setPytaniaTestowe(List<Pytanie> pytaniaTestowe) {
        this.pytaniaTestowe = pytaniaTestowe;
    }

    public float getWynik() {
        return wynik;
    }

    public void setWynik(float wynik) {
        this.wynik = wynik;
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
        if (!(object instanceof KursOsoby)) {
            return false;
        }
        KursOsoby other = (KursOsoby) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uzytkownik.encje.kursOsoby[ id=" + id + " ]";
    }
    
}
