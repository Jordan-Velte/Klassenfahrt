package controller;
//Import model --> Für Zugriff auf Model-Klassen
import model.*;
//Import für ArrayList
import java.util.ArrayList;

public class ReisezielController {
    //Instanz mc der Klasse MainController
    MainController mc;
    //ArrayList für mehrere Instanzen der Klasse Reiseziel
    ArrayList<Reiseziel> reiseziel = new ArrayList<Reiseziel>();

    //Constructor
    public ReisezielController(MainController mc){
        setMc(mc);
        setReiseziel(reiseziel);
    }

    //Methode, um Demodaten im Reiseziel-Controller zu erstellen
    public void createReisezielData(){
        //Erstellung der Instanzen der Klasse Reiseziel
        Reiseziel r1 = new Reiseziel("Stuttgart", "Holiday-Inn", 250, 350, 12);
        Reiseziel r2 = new Reiseziel("Sylt", "Puan Klent", 250, 300, 12);
        Reiseziel r3 = new Reiseziel("München", "Schlossgarten-Residenz",  1000, 1200, 12);
        Reiseziel r4 = new Reiseziel("Frankfurt", "Bahnhofsviertel Crackhostel", 150, 150, 18);
        Reiseziel r5 = new Reiseziel("Berlin", "Stadthostel Berlin", 250, 350, 12);
        //Hinzufügen der Instanzen zu einer entsprechenden ArrayList über Punktnotation (siehe add-Methode)
        reiseziel.add(r1);
        reiseziel.add(r2);
        reiseziel.add(r3);
        reiseziel.add(r4);
        reiseziel.add(r5);

    }

    //Setter & Getter
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setReiseziel(ArrayList<Reiseziel> reiseziel) {
        this.reiseziel = reiseziel;
    }
    public MainController getMc() {
        return mc;
    }
    public ArrayList<Reiseziel> getReiseziel() {
        return reiseziel;
    }


}
