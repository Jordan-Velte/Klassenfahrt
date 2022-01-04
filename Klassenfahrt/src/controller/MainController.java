package controller;
import java.text.ParseException;
//Import view --> Für Ausgabe
import view.*;

public class MainController {
    //Erstellen der Instanzen aller Controller-Klassen der jeweiligen Model-Klassen --> Variablendeklaration
    KlassenfahrtController kfc;
    KlasseController klc;
    LehrerController lec;
    ReisezielController rec;
    //Instanzerstellung der Klasse Output
    Output o = new Output();

    //Constructor
    public MainController(){
        //In den Settern werden jeweils neue Controller-Instanzen erstellt, welchen der MainController übergeben wird (siehe this-Parameterübergabe).
        setKlc(new KlasseController(this));
        setLec(new LehrerController(this));
        setRec(new ReisezielController(this));
        setKfc(new KlassenfahrtController(this));
        
    }

    //Demodatenerstellung --> Die hierfür benötigten Methoden der Klassen werden per Punktnotation an den Controllern aufgerufen.
    public void createDemoData() throws ParseException{
        getKlc().createKlasseData();
        getLec().createLehrerData();
        getRec().createReisezielData();
        getKfc().createKlassenfahrtData();
    }
    
    //Überprüfung der notwendigen Bedingungen für die Klassenfahrten --> Per Punknotation wird an dem Klassenfahrt-Controller die jeweilige Überprüfungsmethode aufgerufen.
    public void evaluateBedingungen(){
        getKfc().checkKfLehrerBesetzung();
        getKfc().checkKfLehrerQualifikation();
        getKfc().checkKfBudget();
        getKfc().checkKfAlter();
    }


    //Setter und Getter
    public void setKfc(KlassenfahrtController kfc) {
        this.kfc = kfc;
    }
    public void setKlc(KlasseController klc) {
        this.klc = klc;
    }
    public void setLec(LehrerController lec) {
        this.lec = lec;
    }
    public void setO(Output o) {
        this.o = o;
    }
    public void setRec(ReisezielController rec) {
        this.rec = rec;
    }
    public KlassenfahrtController getKfc() {
        return kfc;
    }
    public KlasseController getKlc() {
        return klc;
    }
    public LehrerController getLec() {
        return lec;
    }
    public Output getO() {
        return o;
    }
    public ReisezielController getRec() {
        return rec;
    }


}