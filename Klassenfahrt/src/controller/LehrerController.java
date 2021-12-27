package controller;
import model.*;
import java.util.ArrayList;

public class LehrerController {
    MainController mc;
    ArrayList<Lehrer> lehrer = new ArrayList<Lehrer>();

    public LehrerController(MainController mc){
        setLehrer(lehrer);
        setMc(mc);
    }

    public void createLehrerData(){
        Lehrer l1 = new Lehrer("Marten", "Odens", "ja");
        Lehrer l2 = new Lehrer("Holger", "Trampe", "ja");
        Lehrer l3 = new Lehrer("Joerg", "Simsky", "nein");
        lehrer.add(l1);
        lehrer.add(l2);
        lehrer.add(l3);
    }

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
