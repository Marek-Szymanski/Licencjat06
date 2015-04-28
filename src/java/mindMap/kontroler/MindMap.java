/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindMap.kontroler;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import mindMap.encje.Kategoria;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
import projekt.kontroleryBazy.KursKontroler;

/**
 *
 * @author marekszymanski
 */
public class MindMap {
    private MindmapNode root;
    private boolean wyswietlOpis;
    private List <Kategoria> kategorie;
    
    

    public MindMap() {
        kategorie = new ArrayList();
        wyswietlOpis=false;
        root = new DefaultMindmapNode("Kategorie", "kategorie", "FFCC00", false);
        
    }

    public MindmapNode getRoot() {
        return root;
    }

    public void setRoot(MindmapNode root) {
        this.root = root;
    }

    public List<Kategoria> getKategorie() {
        return kategorie;
    }

    public void setKategorie(List<Kategoria> kategorie) {
        this.kategorie = kategorie;
    }
    
    
    public void uaktualnij(List <Kategoria> temp)
    {
        if(temp.size() != kategorie.size())
        {
            for(int i=kategorie.size();i<temp.size();i++)
            {
                kategorie.add(temp.get(i));
                MindmapNode nowaKategoria = new DefaultMindmapNode(temp.get(i).getNazwa(), "kategoria", "6e9ebf", true);
                root.addNode(nowaKategoria);
                for(int j = 0; j < temp.get(i).getKursy().size(); j++)
                {
                    MindmapNode nowyKurs = new DefaultMindmapNode(temp.get(i).getKursy().get(j).getNazwa(), "kurs", "6e9ebf", true);
                    nowaKategoria.addNode(nowyKurs);
                }
            }
        }
        else
        {
            for(int i = 0; i<temp.size(); i++)
            {
                if(temp.get(i).getKursy().size() != kategorie.get(i).getKursy().size())
                {
                    for(int j = kategorie.get(i).getKursy().size();j < temp.get(i).getKursy().size(); j++)
                    {
                        MindmapNode nowy = new DefaultMindmapNode(temp.get(i).getKursy().get(j).getNazwa(), "kurs", "6e9ebf", true);
                        wezelPoNazwie(kategorie.get(i).getNazwa()).addNode(nowy);
                    }
                }
            }
        }
        kategorie = temp;
    }
    
    private MindmapNode wezelPoNazwie(String nazwa)
    {
        for(int i = 0; i < root.getChildren().size(); i++)
        {
            if(root.getChildren().get(i).getLabel().equals(nazwa))
                return root.getChildren().get(i);
        }
        return null;
    }
    
}
