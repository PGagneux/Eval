package fr.univ_orleans.iut45.menus;

import java.util.Collection;
import java.util.List;
import java.io.Reader;

import com.google.gson.Gson;

class Menu {
    protected List<Plat> entrees;
    protected List<Plat> plats_principaux;
    protected List<Plat> desserts;

    public Menu(List<Plat> entrees,
                List<Plat> plats_principaux,
                List<Plat> desserts) {
        this.entrees = entrees;
        this.plats_principaux = plats_principaux;
        this.desserts = desserts;
    }

    public List<Plat> getEntrees() {
        return this.entrees;
    }

    public List<Plat> getPlatsPrincipaux() {
        return this.plats_principaux;
    }

    public List<Plat> getDesserts() {
        return this.desserts;
    }

    public static Menu fromJson(Reader r) {
        Gson gson = new Gson();
        return gson.fromJson(r, Menu.class);
    }

    public Plat platMoinCher(List<Plat> liste){
        if (liste.size()>0){
            Plat plat = liste.get(0);
            double prix = plat.prixDeRevient();
            for (int i=1; i<liste.size();++i){
                if (liste.get(i).prixDeRevient() < prix){
                    plat = liste.get(i);
                    prix = plat.prixDeRevient();
                }
            }
            return plat;
        }
        return null;
    }
    public double couMinimum(){
        Plat entreeMCher = platMoinCher(this.entrees);
        Plat platMCher = platMoinCher(this.plats_principaux);
        Plat dessertsMCher = platMoinCher(this.desserts);
        return entreeMCher.prixDeRevient() + platMCher.prixDeRevient() + dessertsMCher.prixDeRevient(); 
    }

}
