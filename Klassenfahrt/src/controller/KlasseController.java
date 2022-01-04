//MVC-Struktur: Import von Model UND View nötig --> Controller = Schnittstelle!
package controller;
//Import model für Zugriff auf Model-Klassen
import model.*;
//Import für ArrayList
import java.util.ArrayList;

public class KlasseController{
    //Instanz mc der Klasse MainController
    MainController mc;
    //ArrayList für mehrere Instanzen der Klasse Klasse
    ArrayList<Klasse> klasse = new ArrayList<Klasse>();

    //Constructor --> Übergabe der MainController-Instanz!
    public KlasseController(MainController mc){
        setKlasse(klasse);
        setMc(mc);
    }

    //Methode, um Demodaten im Klasse-Controller zu erstellen
    public void createKlasseData(){
        //Erstellung der Instanzen der Klasse Klassse
        Klasse k1 = new Klasse("10b",20, 16.39, 350.39);
        Klasse k2 = new Klasse("11c", 15, 17.09, 400);
        Klasse k3 = new Klasse("8b", 19, 14.39, 300.30);
        Klasse k4 = new Klasse("9d", 20, 15, 300.30);
        Klasse k5 = new Klasse("6b", 22, 12.5, 300.30);
        //Hinzufügen der Instanzen zu einer entsprechenden ArrayList über Punktnotation (siehe add-Methode)
        klasse.add(k1);
        klasse.add(k2);
        klasse.add(k3);
        klasse.add(k4);
        klasse.add(k5);
    }

    //Setter & Getter
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
