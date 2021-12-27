package controller;
import model.*;
//Darf man view importieren?
import view.*;

import java.util.ArrayList;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KlassenfahrtController {
    Output o = new Output();
    MainController mc;
    ArrayList<Klassenfahrt> klassenfahrt = new ArrayList<Klassenfahrt>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public KlassenfahrtController(MainController mc){
        setKlassenfahrt(klassenfahrt);
        setMc(mc);
    }

    public void createKlassenfahrtData() throws ParseException{
        //Herr Odens und Herr Trampe
        ArrayList<Lehrer> lehrer1 = new ArrayList<Lehrer>();
        lehrer1.add(getMc().getLec().getLehrer().get(0));
        lehrer1.add(getMc().getLec().getLehrer().get(1));

        //Herr Odens und Herr Simsky
        ArrayList<Lehrer> lehrer2 = new ArrayList<Lehrer>();
        lehrer2.add(getMc().getLec().getLehrer().get(0));
        lehrer2.add(getMc().getLec().getLehrer().get(2));

        //Herr Trampe und Herr Simsky
        ArrayList<Lehrer> lehrer3 = new ArrayList<Lehrer>();
        lehrer3.add(getMc().getLec().getLehrer().get(1));
        lehrer3.add(getMc().getLec().getLehrer().get(2));

        //Nur Herr Trampe
        ArrayList<Lehrer> lehrer4 = new ArrayList<Lehrer>();
        lehrer4.add(getMc().getLec().getLehrer().get(0));

        //Nur ein Lehrer --> fail
        Klassenfahrt kl1 = new Klassenfahrt(getMc().getRec().getReiseziel().get(0), lehrer4 ,getMc().getKlc().getKlasse().get(0), format.parse("17.01.2022"), format.parse("21.01.2022"));
        //Nicht beide Lehrer haben Erlaubnis --> fail
        Klassenfahrt kl2 = new Klassenfahrt(getMc().getRec().getReiseziel().get(1), lehrer2 ,getMc().getKlc().getKlasse().get(1), format.parse("06.06.2022"), format.parse("10.06.2022"));
        //Zu Teuer --> fail 
        Klassenfahrt kl3 = new Klassenfahrt(getMc().getRec().getReiseziel().get(2), lehrer1 ,getMc().getKlc().getKlasse().get(2), format.parse("07.02.2022"), format.parse("11.02.2022"));
        Klassenfahrt kl4 = new Klassenfahrt(getMc().getRec().getReiseziel().get(3), lehrer1 ,getMc().getKlc().getKlasse().get(3), format.parse("20.12.2021"), format.parse("24.12.2021"));
        Klassenfahrt kl5 = new Klassenfahrt(getMc().getRec().getReiseziel().get(4), lehrer1 ,getMc().getKlc().getKlasse().get(4), format.parse("27.12.2021"), format.parse("31.12.2021"));

        klassenfahrt.add(kl1);
        klassenfahrt.add(kl2);
        klassenfahrt.add(kl3);
        klassenfahrt.add(kl4);
        klassenfahrt.add(kl5);
    }

    public void checkNotwendigeBedingungen(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //checken ob Methode gibt um Anzahl von Elementen einer ArrayList anzugeben
            if(klassenfahrt.getZweilehrer().get(1) != null){
                o.printData("Die Lehrerbesetzung auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht vollständig.");
            }
            else if((klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja") || (klassenfahrt.getZweilehrer().get(1).getKlassenfahrterlaubnis() != "ja")){
                o.printData("Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht gewährleistet.");
            }
            else if(klassenfahrt.getKlasse().getMaxschuelerbudget() < klassenfahrt.getReiseziel().getPreisperschueler()){
                o.printData("Die Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht mit dem maximalen Budget der Schüler vereinbar.");
            }
            else if(klassenfahrt.getKlasse().getSchuelerdurchschnittsalter() < klassenfahrt.getReiseziel().getMinschueleralter()){
                o.printData("Die geplante Unterkunft für die Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " ist aufgrund der Altersbedingungen nicht für die Schüler geeignet.");
            }
            else{
                o.printData("Die geplante Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " kann wie geplant stattfinden.");
            }}
    }

    /*
    //Oder soll das in die Klasse von der Klassenfahrt?
    public void checkNotwendigeBedingungen(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            if((klassenfahrt.getZweilehrer().get(1) != null) ||  ((klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja") || (klassenfahrt.getZweilehrer().get(1).getKlassenfahrterlaubnis() != "ja")) || (klassenfahrt.getKlasse().getMaxschuelerbudget() < klassenfahrt.getReiseziel().getPreisperschueler()) || (klassenfahrt.getKlasse().getSchuelerdurchschnittsalter() < klassenfahrt.getReiseziel().getMinschueleralter())){
                o.printData("Die Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " nach " + klassenfahrt.getReiseziel().getReisezielname()+ " ist ungültig.");
            }
            else{
                o.printData("Die Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " nach " + klassenfahrt.getReiseziel().getReisezielname()+ " ist genehmigt.");
            }
        }
    }
    */

    public void setKlassenfahrt(ArrayList<Klassenfahrt> klassenfahrt) {
        this.klassenfahrt = klassenfahrt;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setO(Output o) {
        this.o = o;
    }
    public ArrayList<Klassenfahrt> getKlassenfahrt() {
        return klassenfahrt;
    }
    public MainController getMc() {
        return mc;
    }
    public Output getO() {
        return o;
    }

}
