package controller;
//Import model --> Für Zugriff auf Model-Klassen
import model.*;
//Import view --> Für Ausgabe
import view.*;
//Import für ArrayList
import java.util.ArrayList;
//Mehrere Imports für Datum/Standort!
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KlassenfahrtController {
    //Erstellung einer Instanz der Klasse Output, um an jenem per Punktnotation die Ausgabemethode (printData) aufrufen zu können
    Output o = new Output();
    //Instanz mc der Klasse MainController
    MainController mc;
    //ArrayList für mehrere Instanzen der Klasse Klassenfahrt
    ArrayList<Klassenfahrt> klassenfahrt = new ArrayList<Klassenfahrt>();
    //Formatfestlegung für die Datumsvariablen. Das Datum orientiert sich an dem deutschen Standard --> Per Punktnotation an jener Instanz können nun über die parse-Methode Strings übergeben werden, welche sich an diesem definierten Datumsformat orientieren.
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    //Constructor --> Übergabe der MainController-Instanz!
    public KlassenfahrtController(MainController mc){
        setKlassenfahrt(klassenfahrt);
        setMc(mc);
    }

    //Methode für die Erstellung der entsprechenden Lehrer-Arrays und Klassenfahrten
    public void createKlassenfahrtData() throws ParseException{
        //Zunächst werden ArrayLists erstellt, die unterschiedliche Kombination von Lehrern abbilden (siehe lehrer1, lehrer2, etc.). Folglich werden in diese Arrays die respektiven Lehrer Instanzen aus der Lehrer-ArrayLists (siehe Lehrer-Controller) jeweils hinzugefügt über einen Parameterübergabe bezogen auf die add-Methode. Hierbei ist zu beachten, dass per Punktnotation an dem MainController zunächst der Lehrer-Controller aufgerufen wird, der dann auf die einzelnen Lehrer-Instanzen zugreifen kann.
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

        //Erstellung der Klassenfahrt-Instanzen --> Hier wird erneut über die Punktnotation vorgegangen (siehe MainController und jeweils die Controller der benötigten Klassen)! Es sind alle Möglichkeiten an den jeweiligen Instanzen gegeben.
        //Nur ein Lehrer --> fail
        Klassenfahrt kl1 = new Klassenfahrt(getMc().getRec().getReiseziel().get(0), lehrer4,getMc().getKlc().getKlasse().get(0), format.parse("17.01.2022"), format.parse("21.01.2022"));
        //Nicht beide Lehrer haben Erlaubnis --> fail
        Klassenfahrt kl2 = new Klassenfahrt(getMc().getRec().getReiseziel().get(1), lehrer2,getMc().getKlc().getKlasse().get(1), format.parse("06.06.2022"), format.parse("10.06.2022"));
        //Zu Teuer für die Schüler --> fail 
        Klassenfahrt kl3 = new Klassenfahrt(getMc().getRec().getReiseziel().get(2), lehrer2,getMc().getKlc().getKlasse().get(2), format.parse("07.02.2022"), format.parse("11.02.2022"));
        //Schüler erfüllen nicht Mindestalter --> fail
        Klassenfahrt kl4 = new Klassenfahrt(getMc().getRec().getReiseziel().get(3), lehrer1,getMc().getKlc().getKlasse().get(3), format.parse("20.12.2021"), format.parse("24.12.2021"));
        //Alle Bedingungen sind erfüllt --> Klassenfahrt genehmigt!
        Klassenfahrt kl5 = new Klassenfahrt(getMc().getRec().getReiseziel().get(4), lehrer1,getMc().getKlc().getKlasse().get(4), format.parse("27.12.2021"), format.parse("31.12.2021"));

        //Hinzufügen der Instanzen zu einer entsprechenden ArrayList über Punktnotation (siehe add-Methode)
        klassenfahrt.add(kl1);
        klassenfahrt.add(kl2);
        klassenfahrt.add(kl3);
        klassenfahrt.add(kl4);
        klassenfahrt.add(kl5);
    }

    //Überprüfung, ob die Lehrer-ArrayLists der Klassenfahrt-Instanz hinreichend besetzt ist. 
    public void checkKfLehrerBesetzung(){
        //For-Each-Schleife durchläuft alle Instanzen der Klasse Klassenfahrt
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //Wenn die Anzahl der Elemente der Lehrer-ArrayLists kleiner als 2 ist (also keine Vollbesetzung erfolgt ist), wird eine Fehlermeldung ausgegeben!
            if(klassenfahrt.getZweilehrer().size() < 2){
                //Per Punktnotation an der Output-Instanz wird die Ausgabemethode aufgerufen. Als String wird jener Methode die Fehlermeldung übergeben. Neben den Strings, wird auch per Punktnoation der Name der jeweiligen Klasse an der Klassenfahrt-Instanz aufgerufen
                o.printData("ACHTUNG: Die Lehrerbesetzung auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht vollständig.");
            }
            else{
                //Gleiches Schema! Nur diesmal ist keine Fehlermeldung erfolgt, da die If-Bedingung nicht erfüllt ist, sofern die Anzahl der Lehrer nicht kleiner 2 ist.
                o.printData("Die Lehrerbesetzung auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist vollständig.");
            }
        }
    }

    //Überprüfung, ob beide Lehrer eine Klassenfahrterlaubnis besitzen.
    public void checkKfLehrerQualifikation(){
        //For-Each-Schleife durchläuft alle Instanzen der Klasse Klassenfahrt.
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //Wenn die Lehrer-ArrayLists eine Anzahl von 2 Elementen besitzt, wird eine weitere If-Bedingung überprüft.
            if(klassenfahrt.getZweilehrer().size() == 2){
                //Sofern eines der Elemente der Lehrer-ArrayLists keine Klassenfahrterlaubnis besitzt (Klassenfahrterlaubnis nicht mit dem String ja initialisiert), wird eine Fehlermeldung ausgegeben.
                if((klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja") || (klassenfahrt.getZweilehrer().get(1).getKlassenfahrterlaubnis() != "ja")){
                    //Per Punktnotation an der Output-Instanz wird die Ausgabemethode aufgerufen. Als String wird jener Methode die Fehlermeldung übergeben. Neben den Strings, wird auch per Punktnoation der Name der jeweiligen Klasse an der Klassenfahrt-Instanz aufgerufen.
                    o.printData("ACHTUNG: Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht gewährleistet.");
                }
                else{
                    //Ist die If-Bedingung nicht erfüllt, haben beide Lehrer offensichtlich eine Klassenfahrterlaubnis, welche durch einen Output angegeben wird.
                    o.printData("Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist gewährleistet.");
                }
            }
            //Sofern die Lehrer-ArrayLists nicht 2 Elemente besitzt, wird bricht die If-Bedingung ab.
            else{
                break;
            }
        }
    }


    
    //Überprüfung, ob das Budget der Schüler mit den Kosten des Hotels übereinstimmt
    public void checkKfBudget(){
        //For-Each-Schleife durchläuft alle Instanzen der Klasse Klassenfahrt
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //If-Bedingung: Per Punknotation wird die initialisierte Variable des maximalen Schuelerbudgets der Klasse Klasse mit den Kosten/Schüler der Klasse Reiseziel verglichen. Sind die Kosten größer als das Budget, wird eine Fehlermeldung ausgegebgen.
            if(klassenfahrt.getKlasse().getMaxschuelerbudget() < klassenfahrt.getReiseziel().getPreisperschueler()){
                //Per Punktnotation an der Output-Instanz wird die Ausgabemethode aufgerufen. Als String wird jener Methode die Fehlermeldung übergeben. Neben den Strings, wird auch per Punktnoation der Name der jeweiligen Klasse an der Klassenfahrt-Instanz aufgerufen
                o.printData("ACNTUNG: Die geplante Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht mit dem maximalen Budget der Schüler vereinbar.");
            } 
            else{
                //Ist die If-Bedingung nicht erfüllt, ist das Budget der Schüler mit den Kosten vereinbar, und wird durch einen Output von Strings und einer initialisierten Name-Variable ausgegeben.
                o.printData("Die geplante Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist mit dem maximalen Budget der Schüler vereinbar.");
            }
        }
    }

    //Überprüfung, ob das Durchschnittsalter der Schüler mit den Anforderungen des Hotels übereinstimmt.
    public void checkKfAlter(){
        //For-Each-Schleife durchläuft alle Instanzen der Klasse Klassenfahrt
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //Per Punktnotation wird die initialisierte Variable des Durchschnittsalter aller Schüler mit dem dem Mindestalter des Reiseziels vergleichen. Liegt das Alter der Schüler im Durchschnitt unter dem angeforderten Mindestalter, wird eine Fehlermeldung ausgegebgen. 
            if(klassenfahrt.getKlasse().getSchuelerdurchschnittsalter() < klassenfahrt.getReiseziel().getMinschueleralter()){
                //Per Punktnotation an der Output-Instanz wird die Ausgabemethode aufgerufen. Als String wird jener Methode die Fehlermeldung übergeben. Neben den Strings, wird auch per Punktnoation der Name der jeweiligen Klasse an der Klassenfahrt-Instanz aufgerufen
                o.printData("ACHTUNG: Die geplante Unterkunft für die Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " ist aufgrund der Altersbedingungen nicht für die Schüler geeignet.");
            }
            else{
                //Ist die If-Bedingung nicht erfüllt, sind die Schüler offensichtlich alt genug für das Hotel. Ein respektiver Output verdeutlicht dies für die jeweilige Klasse durch eine Ausgabe von Strings und initialisierter Namen-Variable der Klasse (siehe Punktnotation).
                o.printData("Die geplante Unterkunft für die Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " in Anbetracht der Altersbedingungen für die Schüler geeignet.");
            }
        }
    }

    

    //Setter & Getter
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


//CODE GRAVEYARD

    /*
    public void checkKfLehrerQualifikation(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            if(klassenfahrt.getZweilehrer().size() == 2){
                if((klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja") || (klassenfahrt.getZweilehrer().get(1).getKlassenfahrterlaubnis() != "ja")){
                    o.printData("ACHTUNG: Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht gewährleistet.");
                }
                else{
                    o.printData("Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist gewährleistet.");
                } 
            }
            else{
                break;
            }
        }
    }
    */

    /*
    public void checkKfLehrerQualifikation(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            if(klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja"){
                o.printData("Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht gewährleistet.");
            }
            else{
                klassenfahrt.setStatus(+1);
            }
        }
    }
    */
    /*
    public void checkKfStatus(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            if(klassenfahrt.getStatus() == true){
                o.printData("Die geplante Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " kann wie geplant stattfinden.");
            }
            else{
                break;
            }
        }
    }
    */

    /*
    public void checkNotwendigeBedingungen(){
        for(Klassenfahrt klassenfahrt : klassenfahrt){
            //checken ob Methode gibt um Anzahl von Elementen einer ArrayList anzugeben
            if(klassenfahrt.getZweilehrer().size() < 2){
                o.printData("Die Lehrerbesetzung auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht vollständig.");
            }
            else if((klassenfahrt.getZweilehrer().get(0).getKlassenfahrterlaubnis() != "ja") || (klassenfahrt.getZweilehrer().get(1).getKlassenfahrterlaubnis() != "ja")){
                o.printData("Die Qualifikation aller Lehrkräfte auf der Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht gewährleistet.");
            }
            else if(klassenfahrt.getKlasse().getMaxschuelerbudget() < klassenfahrt.getReiseziel().getPreisperschueler()){
                o.printData("Die geplante Klassenfahrt der Klasse " + klassenfahrt.getKlasse().getName() + " ist nicht mit dem maximalen Budget der Schüler vereinbar.");
            }
            else if(klassenfahrt.getKlasse().getSchuelerdurchschnittsalter() < klassenfahrt.getReiseziel().getMinschueleralter()){
                o.printData("Die geplante Unterkunft für die Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " ist aufgrund der Altersbedingungen nicht für die Schüler geeignet.");
            }
            else{
                o.printData("Die geplante Klassenreise der Klasse " + klassenfahrt.getKlasse().getName() + " kann wie geplant stattfinden.");
            }}
    }
    */
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