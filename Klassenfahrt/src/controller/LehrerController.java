package controller;
//Import model --> Für Zugriff auf Model-Klassen
import model.*;
//Import für ArrayList
import java.util.ArrayList;

public class LehrerController {
    //Instanz mc der Klasse MainController
    MainController mc;
    //ArrayList für mehrere Instanzen der Klasse Lehrer
    ArrayList<Lehrer> lehrer = new ArrayList<Lehrer>();

    public LehrerController(MainController mc){
        setLehrer(lehrer);
        setMc(mc);
    }

    //Methode, um Demodaten im Lehrer-Controller zu erstellen
    public void createLehrerData(){
        //Erstellung der Instanzen der Klasse Lehrer
        Lehrer l1 = new Lehrer("Marten", "Odens", "ja");
        Lehrer l2 = new Lehrer("Holger", "Trampe", "ja");
        Lehrer l3 = new Lehrer("Joerg", "Simsky", "nein");
        //Hinzufügen der Instanzen zu einer entsprechenden ArrayList über Punktnotation (siehe add-Methode)
        lehrer.add(l1);
        lehrer.add(l2);
        lehrer.add(l3);
    }

    //Setter & Getter
    public void setLehrer(ArrayList<Lehrer> lehrer) {
        this.lehrer = lehrer;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public ArrayList<Lehrer> getLehrer() {
        return lehrer;
    }
    public MainController getMc() {
        return mc;
    }
}
