/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.kontrolaWidoku;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marekszymanski
 */
public class KontrolerWidoku {
    
    private Boolean kategoria;
    private Boolean kurs;
    private Boolean lekcja;
    private Boolean pytanie;
    
    private Boolean celKategoria;
    private Boolean celKurs;
    private Boolean celLekcja;
    private Boolean celPytanie;
    
    private Boolean celWyswietl;
    private Boolean celWybierz;
    private Boolean celDodaj;
    private Boolean celEdytuj;
    
    private Boolean wyswietl;
    private Boolean wybierz;
    private Boolean dodaj;
    private Boolean edytuj;
    
    private Boolean administratorEdytujProfil;
    private Boolean wyswietlOpis;
    
    private Boolean panelLekcji1;
    private Boolean panelLekcji2;
    private Boolean panelLekcji3;
    private Boolean panelLekcji4;
    private Boolean panelLekcji5;
    
    private Boolean obrazek1;
    private Boolean obrazek2;
    private Boolean obrazek3;
    private Boolean obrazek4;
    private Boolean obrazek5;
    
    
    public KontrolerWidoku() {
        setFalse();
    }
    
    public void setFalse()
    {
        kategoria = false;
        kurs = false;
        lekcja = false;
        pytanie = false;
        
        wyswietl = false;
        wybierz = false;
        dodaj = false;
        edytuj = false;
        
        celWyswietl = false;
        celWybierz = false;
        celDodaj = false;
        celEdytuj = false;
        
        celKategoria = false;
        celKurs = false;
        celLekcja = false;
        celPytanie = false;
        
        administratorEdytujProfil = false;
        wyswietlOpis = false;
        
        panelLekcji1 = false;
        panelLekcji2 = false;
        panelLekcji3 = false;
        panelLekcji4 = false;
        panelLekcji5 = false;
        
        obrazek1 = false;
        obrazek2 = false;
        obrazek3 = false;
        obrazek4 = false;
        obrazek5 = false;
        
    }

//akcje przyciskkow
    
    
    //Wyświetl wszystkie
    public void wyswietlKategorie()
    {
        setFalse();
        wyswietl = true;
        kategoria = true;
    }
    
    public void wyswietlKursy()
    {
        setFalse();
        //celWyswietl = true;
        wyswietl = true;
        kurs = true;
    }
    
    public void wyswietlLekcje()
    {
        setFalse();
        //celWyswietl = true;
        wyswietl = true;
        lekcja = true;
    }
    
    public void wyswietlPytania()
    {
        setFalse();
        //celWyswietl = true;
        wyswietl = true;
        pytanie = true;
    }
    
    //Wybierz
    public void wybierzKategorie()
    {
        zachowajCel();
        wybierz = true;
        kategoria = true;
    }
    
    public void wybranoKategorie()
    {
        if(celKategoria)
        {
            setFalse();
            kategoria = true;
            edytuj = true;
            wyswietl = true;
        }
        else if(celKurs && celDodaj)
        {
            setFalse();
            kurs = true;
            dodaj = true;
            wyswietl = true;
        }
        else
        {
            zachowajCel();
            wybierzKursy();
        }
    }
    
    public void wybierzKursy()
    {
        zachowajCel();
        wybierz = true;
        kurs = true;
    }
    
    public void wybranoKurs()
    {
        if(celKurs)
        {
            if(celDodaj)
            {
                setFalse();
                kurs = true;
                dodaj = true;
                wyswietl = true;
            }
            else if(celEdytuj)
            {
                setFalse();
                kurs = true;
                edytuj = true;
                wyswietl = true;
            }
        }
        else if(celKategoria)
        {
            zachowajCel();
            if(celEdytuj)
            {
                setFalse();
                edytuj = true;
                kategoria = true;
            }
            else if(celDodaj)
            {
                setFalse();
                dodaj = true;
                wyswietl = true;
                kategoria = true;
            }
        }
        else if(celLekcja)
        {
            zachowajCel();
            if(celDodaj)
            {
                setFalse();
                dodaj = true;
                wyswietl = true;
                lekcja = true;
            }
            else if(celEdytuj)
            {
                zachowajCel();
                wybierzLekcje();
            }   
        }
        else
        {
            zachowajCel();
            wybierzLekcje();
        }
    }
    
    public void wybierzLekcje()
    {
        zachowajCel();
        wybierz = true;
        lekcja = true;
    }
    
    public void wybranoLekcje()
    {
        if(celLekcja)
        {
            if(celDodaj)
            {
                setFalse();
                dodaj = true;
                wyswietl = true;
                lekcja = true;
            }
            else if(celEdytuj)
            {
                setFalse();
                edytuj = true;
                wyswietl = true;
                lekcja = true;
            }
        }
        else if(celPytanie)
        {
            if(celDodaj)
            {
                setFalse();
                dodaj = true;
                wyswietl = true;
                pytanie = true;
            }
            else if(celEdytuj)
            {
                wybierzPytania();
            }
        }
    }
    
    public void wybierzPytania()
    {
        setFalse();
        wybierz = true;
        pytanie = true;
    }
    
    public void wybranoPytanie()
    {
        setFalse();
        edytuj = true;
        wyswietl = true;
        pytanie = true;
    }
    
    //Dodaj
    public void dodajKategorie()
    {
        setFalse();
        celKategoria = true;
        celDodaj = true;
        
        dodaj = true;
        wyswietl = true;
        kategoria = true;
    }
    
    public void dodajKursy()
    {
        setFalse();
        celDodaj = true;
        celKurs = true;
        wybierzKategorie();
        
    }
    
    public void dodajLekcje()
    {
        setFalse();
        celDodaj = true;
        celLekcja = true;
        wybierzKategorie();
    }
    
    public void dodajPytania()
    {
        setFalse();
        celDodaj = true;
        celPytanie = true;
        wybierzKategorie();
    }
    
    public void edytujKategorie()
    {
        setFalse();
        celEdytuj = true;
        celKategoria = true;
        wybierzKategorie();
    }
    
    public void edytujKursy()
    {
        setFalse();
        celEdytuj = true;
        celKurs = true;
        wybierzKategorie();
    }
    
    public void edytujLekcje()
    {
        setFalse();
        celEdytuj = true;
        celLekcja = true;
        wybierzKategorie();
    }
    
    public void edytujPytania()
    {
        setFalse();
        celEdytuj = true;
        celPytanie = true;
        wybierzKategorie();
    }
    
    private void zachowajCel()
    {
        if(celKurs)
        {
            if(celDodaj)
            {
                setFalse();
                celKurs = true;
                celDodaj = true;
            }
            else if(celEdytuj)
            {
                setFalse();
                celKurs = true;
                celEdytuj = true;
            }
        }
        else if(celLekcja)
        {
            if(celDodaj)
            {
                setFalse();
                celLekcja = true;
                celDodaj = true;
            }
            else if(celEdytuj)
            {
                setFalse();
                celLekcja = true;
                celEdytuj = true;
            }
        }
        else if(celPytanie)
        {
            if(celDodaj)
            {
                setFalse();
                celPytanie = true;
                celDodaj = true;
            }
            else if(celEdytuj)
            {
                setFalse();
                celPytanie = true;
                celEdytuj = true;
            }
        }
    }
    
    public void edytujProfil()
    {
        if(administratorEdytujProfil)
            administratorEdytujProfil = false;
        else
            administratorEdytujProfil = true;
    }
    
//GET && SET
    
    public Boolean getKategoria() {
        return kategoria;
    }

    public void setKategoria(Boolean kategoria) {
        this.kategoria = kategoria;
    }

    public Boolean getKurs() {
        return kurs;
    }

    public void setKurs(Boolean kurs) {
        this.kurs = kurs;
    }

    public Boolean getLekcja() {
        return lekcja;
    }

    public void setLekcja(Boolean lekcja) {
        this.lekcja = lekcja;
    }

    public Boolean getPytanie() {
        return pytanie;
    }

    public void setPytanie(Boolean pytanie) {
        this.pytanie = pytanie;
    }

    public Boolean getWyswietl() {
        return wyswietl;
    }

    public void setWyswietl(Boolean wyswietl) {
        this.wyswietl = wyswietl;
    }

    public Boolean getWybierz() {
        return wybierz;
    }

    public void setWybierz(Boolean wybierz) {
        this.wybierz = wybierz;
    }

    public Boolean getDodaj() {
        return dodaj;
    }

    public void setDodaj(Boolean dodaj) {
        this.dodaj = dodaj;
    }

    public Boolean getEdytuj() {
        return edytuj;
    }

    public void setEdytuj(Boolean edytuj) {
        this.edytuj = edytuj;
    }

    public Boolean getAdministratorEdytujProfil() {
        return administratorEdytujProfil;
    }

    public void setAdministratorEdytujProfil(Boolean administratorEdytujProfil) {
        this.administratorEdytujProfil = administratorEdytujProfil;
    }

    public Boolean getWyswietlOpis() {
        return wyswietlOpis;
    }

    public void setWyswietlOpis(Boolean wyswietlOpis) {
        this.wyswietlOpis = wyswietlOpis;
    }

    public Boolean getPanelLekcji1() {
        return panelLekcji1;
    }

    public void setPanelLekcji1(Boolean panelLekcji1) {
        this.panelLekcji1 = panelLekcji1;
    }

    public Boolean getPanelLekcji2() {
        return panelLekcji2;
    }

    public void setPanelLekcji2(Boolean panelLekcji2) {
        this.panelLekcji2 = panelLekcji2;
    }

    public Boolean getPanelLekcji3() {
        return panelLekcji3;
    }

    public void setPanelLekcji3(Boolean panelLekcji3) {
        this.panelLekcji3 = panelLekcji3;
    }

    public Boolean getPanelLekcji4() {
        return panelLekcji4;
    }

    public void setPanelLekcji4(Boolean panelLekcji4) {
        this.panelLekcji4 = panelLekcji4;
    }

    public Boolean getPanelLekcji5() {
        return panelLekcji5;
    }

    public void setPanelLekcji5(Boolean panelLekcji5) {
        this.panelLekcji5 = panelLekcji5;
    }

    public Boolean getObrazek1() {
        return obrazek1;
    }

    public void setObrazek1(Boolean obrazek1) {
        this.obrazek1 = obrazek1;
    }

    public Boolean getObrazek2() {
        return obrazek2;
    }

    public void setObrazek2(Boolean obrazek2) {
        this.obrazek2 = obrazek2;
    }

    public Boolean getObrazek3() {
        return obrazek3;
    }

    public void setObrazek3(Boolean obrazek3) {
        this.obrazek3 = obrazek3;
    }

    public Boolean getObrazek4() {
        return obrazek4;
    }

    public void setObrazek4(Boolean obrazek4) {
        this.obrazek4 = obrazek4;
    }

    public Boolean getObrazek5() {
        return obrazek5;
    }

    public void setObrazek5(Boolean obrazek5) {
        this.obrazek5 = obrazek5;
    }
}
