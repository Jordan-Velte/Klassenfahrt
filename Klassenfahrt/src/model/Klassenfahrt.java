package model;
//Import für ArrayList
import java.util.ArrayList;
//Import für Datumwerte
import java.util.Date;

public class Klassenfahrt {
    //Variablendeklaration
    Reiseziel _reiseziel;
    Klasse _klasse;
    ArrayList<Lehrer> zweilehrer = new ArrayList<Lehrer>();
    Date _startdatum;
    Date _endedatum;

    //Constructor
    public Klassenfahrt(Reiseziel reiseziel, ArrayList<Lehrer> zweilehrer, Klasse klasse, Date startdatum, Date endedatum){
        setKlasse(klasse);
        setZweilehrer(zweilehrer);
        setReiseziel(reiseziel);
        setEndedatum(endedatum);
        setStartdatum(startdatum);
    }

    //Setter & Getter
    public void setKlasse(Klasse klasse) {
        this._klasse = klasse;
    }
    public void setZweilehrer(ArrayList<Lehrer> zweilehrer) {
        this.zweilehrer = zweilehrer;
    }
    public void setReiseziel(Reiseziel reiseziel) {
        this._reiseziel = reiseziel;
    }
    public void setEndedatum(Date endedatum) {
        this._endedatum = endedatum;
    }
    public void setStartdatum(Date startdatum) {
        this._startdatum = startdatum;
    }
    public Klasse getKlasse() {
        return _klasse;
    }
    public ArrayList<Lehrer> getZweilehrer() {
        return zweilehrer;
    }
    public Reiseziel getReiseziel() {
        return _reiseziel;
    }
    public Date getStartdatum() {
        return _startdatum;
    }
    public Date getEndedatum() {
        return _endedatum;
    }




}
