package controller;
import model.*;
import java.util.ArrayList;

public class KlasseController{
    MainController mc;
    ArrayList<Klasse> klasse = new ArrayList<Klasse>();

    public KlasseController(MainController mc){
        setKlasse(klasse);
        setMc(mc);
    }

    public void createKlasseData(){
        Klasse k1 = new Klasse("10b",20, 16.39, 350.39);
        Klasse k2 = new Klasse("11c", 15, 17.09, 400);
        Klasse k3 = new Klasse("8b", 19, 14.39, 300.30);
        Klasse k4 = new Klasse("9d", 20, 15, 300.30);
        Klasse k5 = new Klasse("6b", 22, 12.5, 300.30);
        klasse.add(k1);
        klasse.add(k2);
        klasse.add(k3);
        klasse.add(k4);
        klasse.add(k5);
    }

    public void setKlasse(ArrayList<Klasse> klasse) {
        this.klasse = klasse;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public ArrayList<Klasse> getKlasse() {
        return klasse;
    }
    public MainController getMc() {
        return mc;
    }


}
