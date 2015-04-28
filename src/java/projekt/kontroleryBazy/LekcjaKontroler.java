/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.kontroleryBazy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import kurs.Session.LekcjaSession;
import kurs.encje.Lekcja;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author marekszymanski
 */
@ManagedBean(name = "lekcjakontroler")
@SessionScoped
public class LekcjaKontroler implements Serializable{
    
    @EJB 
    public LekcjaSession lekcjaManager;
    
    private Lekcja lekcja = new Lekcja();
    private List<Lekcja> lekcje = new ArrayList<>();
    
    private String sciezka;
    private File targetFolder;
    
    private int tempID;

    public LekcjaKontroler() {
         ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
            .getExternalContext().getContext();
            sciezka = ctx.getRealPath("/");
            sciezka = sciezka.substring(0, sciezka.length()-10);
            sciezka += "web/resources/pobraneObrazki/";
            targetFolder = new File(sciezka);
            System.out.println("!!!!!!");
            System.out.println(sciezka);
    }
    
    public void handleFileUpload(FileUploadEvent event) 
    { 
        try 
        {
            InputStream inputStream = event.getFile().getInputstream(); 
            OutputStream out = new FileOutputStream(new File(targetFolder,
            event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            
            RequestContext.getCurrentInstance().update("panelUpload");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }    
    }
    
    public void dodajLekcje()
    {
        
        lekcjaManager.nowaLekcja(lekcja);
        lekcja = new Lekcja();
    }
    
    public void edytujLekcje()
    {
        lekcjaManager.edytuj(lekcja);
    }
    
    public void wszystkieLekcje()
    {
        lekcje = lekcjaManager.wszystkie();
    }
    
    public void przejdzDoLekcji(int id)
    {
        lekcja = lekcjaManager.poID(id);
    }

    public Lekcja getLekcja() {
        return lekcja;
    }

    public void setLekcja(Lekcja lekcja) {
        this.lekcja = lekcja;
    }

    public List<Lekcja> getLekcje() {
        return lekcje;
    }

    public void setLekcje(List<Lekcja> lekcje) {
        this.lekcje = lekcje;
    }

    public String getSciezka() {
        return sciezka;
    }

    public void setSciezka(String sciezka) {
        this.sciezka = sciezka;
    }

    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }
    
    
    
}
