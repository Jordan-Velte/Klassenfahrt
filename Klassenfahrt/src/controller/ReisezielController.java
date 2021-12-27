package controller;
import model.*;
import java.util.ArrayList;

public class ReisezielController {
    MainController mc;
    ArrayList<Reiseziel> reiseziel = new ArrayList<Reiseziel>();

    public ReisezielController(MainController mc){
        setMc(mc);
        setReiseziel(reiseziel);
    }

    public void createReisezielData(){
        Reiseziel r1 = new Reiseziel("Stuttgart", "Holiday-Inn", 250, 350, 12);
        Reiseziel r2 = new Reiseziel("Sylt", "Puan Klent", 250, 300, 12);
        Reiseziel r3 = new Reiseziel("München", "Schlossgarten-Residenz",  1000, 1200, 12);
        Reiseziel r4 = new Reiseziel("Frankfurt", "Bahnhofsviertel Crackhostel", 150, 150, 18);
        Reiseziel r5 = new Reiseziel("Berlin", "Stadthostel Berlin", 250, 350, 12);
        reiseziel.add(r1);
        reiseziel.add(r2);
        reiseziel.add(r3);
        reiseziel.add(r4);
        reiseziel.add(r5);

    }

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
