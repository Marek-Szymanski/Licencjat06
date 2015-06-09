/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.kontroler;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import kurs.encje.Lekcja;
import kurs.encje.Pytanie;
import mindMap.encje.Kategoria;
import mindMap.encje.Kurs;
import mindMap.kontroler.MindMap;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.MindmapNode;
import projekt.kontrolaWidoku.KontrolerWidoku;
import projekt.kontroleryBazy.KategoriaKontroler;
import projekt.kontroleryBazy.KursKontroler;
import projekt.kontroleryBazy.KursOsobyKontroler;
import projekt.kontroleryBazy.LekcjaKontroler;
import projekt.kontroleryBazy.OsobaKontroler;
import uzytkownik.encje.Osoba;

/**
 *
 * @author marekszymanski
 */
@ManagedBean (name = "kontroler")
@SessionScoped
public class Kontroler implements Serializable{
    
    @ManagedProperty(value="#{osobakontroler}")
    private OsobaKontroler osobaKontroler;
    
    @ManagedProperty(value="#{kategoriakontroler}")
    private KategoriaKontroler kategoriaKontroler;
    
    @ManagedProperty(value="#{kurskontroler}")
    private KursKontroler kursKontroler;
    
    @ManagedProperty(value="#{lekcjakontroler}")
    private LekcjaKontroler lekcjaKontroler;
    
    @ManagedProperty(value="#{kursosobykontroler}")
    private KursOsobyKontroler kursOsobyKontroler;
    
    private KontrolerWidoku widok;
    private MindMap mapa;

    public Kontroler() {
        widok = new KontrolerWidoku();
        this.mapa = new MindMap();
    }
    
    public void uaktualnikMape()
    {
        kategoriaKontroler.setKategoriaList(kategoriaKontroler.kategoriaManager.wszystkie());
        mapa.uaktualnij(kategoriaKontroler.getKategoriaList());
    }    
    
    public void edytujOsobe()
    {
        osobaKontroler.edytujOsobe();
        widok.setFalse();
    }
    
    public void wybierzKategorie()
    {
        widok.wybranoKategorie();
        kategoriaKontroler.setKategoria(kategoriaKontroler.kategoriaManager.poID(kategoriaKontroler.getTempID()));
        System.out.println("Wybrano kategorie: "+kategoriaKontroler.getKategoria().getNazwa());
    }
    
    public void zapiszKategorie()
    {
        kategoriaKontroler.zapiszKategorie();
        widok.setFalse();
    }
    
    public void edytujKategorie()
    {
        kategoriaKontroler.edytujKategorie();
        widok.setFalse();
    }
    
    public void pobierzWszystkieKursyZKategorii()
    {
        kursKontroler.setKursList(kategoriaKontroler.getKategoria().getKursy());
    }   
    
    public void pobierzWszystkieLecjeZKursu()
    {
        System.out.println("Edycyjne wybranie lekcji z kursu");
        if(kursKontroler.getKurs().getLekcje().isEmpty())
            System.out.println("Nie ma z czego brać");
        else
            System.out.println("Damy rade");
        lekcjaKontroler.setLekcje(kursKontroler.getKurs().getLekcje());
    }   
    
    public void wybierzKurs()
    {
        widok.wybranoKurs();
        kursKontroler.setKurs(kursKontroler.kursManager.poID(kursKontroler.getTempID()));
    }
    
    public void zapiszKurs()
    {
        kursKontroler.zapiszKurs();
        kategoriaKontroler.getKategoria().getKursy().add(kursKontroler.getKurs());
        kategoriaKontroler.kategoriaManager.edytuj(kategoriaKontroler.getKategoria());
    }
    
    public void edytujKurs()
    {
        kursKontroler.edytujKurs();
        widok.setFalse();
    }
    
    public String zapiszLekcje()
    {
        //lekcjaKontroler.dodajLekcje();
        System.out.println("Do kursu "+kursKontroler.getKurs().getNazwa()+" dodaje lekcje "+lekcjaKontroler.getLekcja().getNazwa());
        kursKontroler.getKurs().getLekcje().add(lekcjaKontroler.getLekcja());
        kursKontroler.edytujKurs();
        widok.setFalse();
        System.out.println("Zapisano lekcje");
        lekcjaKontroler.setTempID(-1);
        lekcjaKontroler.setLekcja(new Lekcja());
        return  "edycjaBazy";
    }
    
    public String idzDoDodaniaLekcji()
    {
        widok.setFalse();
        widok.setDodaj(true);
        return "kreatorLekcji.xhtml";
    }
    
    public String idzDoEdycjiLekcji()
    {
        widok.setFalse();
        widok.setEdytuj(true);
        return "kreatorLekcji.xhtml";
    }
    
    public String edytujLekcje()
    {
        lekcjaKontroler.edytujLekcje();
        lekcjaKontroler.setLekcja(new Lekcja());
        lekcjaKontroler.setTempID(-1);
        return "edycjaBazy";
    }
    
    public void wybierzLekcje()
    {
        widok.wybranoLekcje();
        lekcjaKontroler.setLekcja(lekcjaKontroler.lekcjaManager.poID(lekcjaKontroler.getTempID()));
    }
    
    public String wyloguj()
    {
        osobaKontroler.setOsoba(new Osoba());
        kategoriaKontroler.setKategoria(new Kategoria());
        kursKontroler.setKurs(new Kurs());
        
        return "wyloguj";
    }
    
    public void zmienHaslo()
    {
        osobaKontroler.zmianaHasla();
        widok.setFalse();
    }
    
    public void onNodeSelect(SelectEvent event)
    {
        MindmapNode node = (MindmapNode) event.getObject();
        
        if(node.getChildren().isEmpty())
        {
            kursKontroler.setKurs(new Kurs());
            if(!node.getParent().getLabel().equals("Kategorie"))
            {
                widok.setWyswietlOpis(true);
                for(int i=0;i<kategoriaKontroler.getKategoriaList().size();i++)
                {
                    if(node.getParent().getLabel().equals(kategoriaKontroler.getKategoriaList().get(i).getNazwa()))
                    {
                        for(int j=0;j<kategoriaKontroler.getKategoriaList().get(i).getKursy().size();j++)
                        {
                            if(kategoriaKontroler.getKategoriaList().get(i).getKursy().get(j).getNazwa().equals(node.getLabel()))
                            {
                                kursKontroler.setKurs(kategoriaKontroler.getKategoriaList().get(i).getKursy().get(j));
                                break;
                            }
                            else
                                kursKontroler.setKurs(new Kurs());
                        }
                        break;
                    }
                }
            }
        }
        else
        {
            widok.setWyswietlOpis(false);
        }
    }
    
    public void onNodeDBSelect(SelectEvent event)
    {
        
    }
    
    public boolean sprawdzPanelLekcji(String panel)
    {
        System.out.println(lekcjaKontroler.getLekcja().getUklad());
        if(lekcjaKontroler.getLekcja().getUklad().contains(panel))
            return true;
        else
            return false;
    }
    
    public void wybranoPanelLekcji(int numer, boolean dodaj)
    {
        String uklad = lekcjaKontroler.getLekcja().getUklad();
        if(numer == 1)
        {
            widok.setPanelLekcji1(dodaj);
            if(dodaj)
            {
                if(!sprawdzPanelLekcji("A"))
                    uklad = uklad+"A";
                lekcjaKontroler.getLekcja().setUklad(uklad);
                
            }
            else
            {
                int index = uklad.indexOf("A");
                String nowyUklad = uklad.substring(0, index) + uklad.substring(index+1);
                lekcjaKontroler.getLekcja().setUklad(nowyUklad);
            }
        }
        else if(numer == 2)
        {
            widok.setPanelLekcji2(dodaj);
            if(dodaj)
            {
                if(!sprawdzPanelLekcji("B"))
                    uklad = uklad+"B";
                lekcjaKontroler.getLekcja().setUklad(uklad);
                
            }
            else
            {
                int index = uklad.indexOf("B");
                String nowyUklad = uklad.substring(0, index) + uklad.substring(index+1);
                lekcjaKontroler.getLekcja().setUklad(nowyUklad);
            }
        }
        else if(numer == 3)
        {
            widok.setPanelLekcji3(dodaj);
            if(dodaj)
            {
                if(!sprawdzPanelLekcji("C"))
                    uklad = uklad+"C";
                lekcjaKontroler.getLekcja().setUklad(uklad);
                
            }
            else
            {
                int index = uklad.indexOf("C");
                String nowyUklad = uklad.substring(0, index) + uklad.substring(index+1);
                lekcjaKontroler.getLekcja().setUklad(nowyUklad);
            }
        }
        else if(numer == 4)
        {
            widok.setPanelLekcji4(dodaj);
            if(dodaj)
            {
                if(!sprawdzPanelLekcji("D"))
                    uklad = uklad+"D";
                lekcjaKontroler.getLekcja().setUklad(uklad);
                
            }
            else
            {
                int index = uklad.indexOf("D");
                String nowyUklad = uklad.substring(0, index) + uklad.substring(index+1);
                lekcjaKontroler.getLekcja().setUklad(nowyUklad);
            }
        }
        else if(numer == 5)
        {
            widok.setPanelLekcji5(dodaj);
            if(dodaj)
            {
                if(!sprawdzPanelLekcji("E"))
                    uklad = uklad+"E";
                lekcjaKontroler.getLekcja().setUklad(uklad);
                
            }
            else
            {
                int index = uklad.indexOf("E");
                String nowyUklad = uklad.substring(0, index) + uklad.substring(index+1);
                lekcjaKontroler.getLekcja().setUklad(nowyUklad);
            }
        }
    }
    
    public void dodajPlik1(FileUploadEvent event)
    {
        lekcjaKontroler.handleFileUpload(event);
        String[] temp = lekcjaKontroler.getLekcja().getObrazek();
        temp[0] = event.getFile().getFileName();
        lekcjaKontroler.getLekcja().setObrazek(temp);
        widok.setObrazek1(true);
    }
    
    public void dodajPlik2(FileUploadEvent event)
    {
        lekcjaKontroler.handleFileUpload(event);
        String[] temp = lekcjaKontroler.getLekcja().getObrazek();
        temp[1] = event.getFile().getFileName();
        lekcjaKontroler.getLekcja().setObrazek(temp);
        widok.setObrazek2(true);
    }
    
    public void dodajPlik3(FileUploadEvent event)
    {
        lekcjaKontroler.handleFileUpload(event);
        String[] temp = lekcjaKontroler.getLekcja().getObrazek();
        temp[2] = event.getFile().getFileName();
        lekcjaKontroler.getLekcja().setObrazek(temp);
        widok.setObrazek3(true);
    }
    
    public void dodajPlik4(FileUploadEvent event)
    {
        lekcjaKontroler.handleFileUpload(event);
        String[] temp = lekcjaKontroler.getLekcja().getObrazek();
        temp[3] = event.getFile().getFileName();
        lekcjaKontroler.getLekcja().setObrazek(temp);
        widok.setObrazek4(true);
    }
    
    public void dodajPlik5(FileUploadEvent event)
    {
        lekcjaKontroler.handleFileUpload(event);
        String[] temp = lekcjaKontroler.getLekcja().getObrazek();
        temp[4] = event.getFile().getFileName();
        lekcjaKontroler.getLekcja().setObrazek(temp);
        widok.setObrazek5(true);
    }
    
    public String dodajKursOsoby()
    {
        int temp = osobaKontroler.getOsoba().getKursy().size();
        boolean zajetyKurs = false;
        for(int i = 0; i < temp; i++)
        {
            if(osobaKontroler.getOsoba().getKursy().get(i).getKurs().getNazwa().equals(kursKontroler.getKurs().getNazwa()))
            {
                zajetyKurs = true;
            }
        }
        
        if(zajetyKurs == false)
        {
            kursOsobyKontroler.getKursOsoby().setKurs(kursKontroler.getKurs());
            kursOsobyKontroler.getKursOsoby().getWynikiLekcji().add(-1f);
            for(int i = 0; i < kursKontroler.getKurs().getLekcje().size(); i++)
            {
                kursOsobyKontroler.getKursOsoby().getWynikiLekcji().add(0f);
            }
            osobaKontroler.getOsoba().getKursy().add(kursOsobyKontroler.getKursOsoby());
            osobaKontroler.edytujOsobe();
            
        }
        else
        {
            System.out.println("Zajete");
            
        }
        if(kursKontroler.getKurs().getLekcje().isEmpty())
        {
            System.out.println("ERROR - brak lekcji");
        }
        else
        {
            lekcjaKontroler.setLekcja(kursKontroler.getKurs().getLekcje().get(0));
            System.out.println(lekcjaKontroler.getLekcja().getNazwa()+" !!!");
        }
        return "doKursu";
    }
    
    
    public void wyzerujObiekty()
    {
        kategoriaKontroler.setKategoria(new Kategoria());
        kursKontroler.setKurs(new Kurs());
        lekcjaKontroler.setLekcja(new Lekcja());
       //pytanieKontroler.etPytanie(new Pytanie());
    }
    
    //GET && SET
    
    public OsobaKontroler getOsobaKontroler() {
        return osobaKontroler;
    }

    public void setOsobaKontroler(OsobaKontroler osobaKontroler) {
        this.osobaKontroler = osobaKontroler;
    }

    public KategoriaKontroler getKategoriaKontroler() {
        return kategoriaKontroler;
    }

    public void setKategoriaKontroler(KategoriaKontroler kategoriaKontroler) {
        this.kategoriaKontroler = kategoriaKontroler;
    }

    public KursKontroler getKursKontroler() {
        return kursKontroler;
    }

    public void setKursKontroler(KursKontroler kursKontroler) {
        this.kursKontroler = kursKontroler;
    }
    
    public KontrolerWidoku getWidok() {
        return widok;
    }

    public void setWidok(KontrolerWidoku edytorBazy) {
        this.widok = edytorBazy;
    }

    public MindMap getMapa() {
        return mapa;
    }

    public void setMapa(MindMap mapa) {
        this.mapa = mapa;
    }

    public LekcjaKontroler getLekcjaKontroler() {
        return lekcjaKontroler;
    }

    public void setLekcjaKontroler(LekcjaKontroler lekcjaKontroler) {
        this.lekcjaKontroler = lekcjaKontroler;
    }

    public KursOsobyKontroler getKursOsobyKontroler() {
        return kursOsobyKontroler;
    }

    public void setKursOsobyKontroler(KursOsobyKontroler kursOsobyKontroler) {
        this.kursOsobyKontroler = kursOsobyKontroler;
    }
 
}
