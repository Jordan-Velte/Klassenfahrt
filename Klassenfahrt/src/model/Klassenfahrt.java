package model;
import java.util.ArrayList;
import java.util.Date;

public class Klassenfahrt {
    Reiseziel _reiseziel;
    Klasse _klasse;
    ArrayList<Lehrer> zweilehrer = new ArrayList<Lehrer>();
    Date _startdatum;
    Date _endedatum;

    public Klassenfahrt(Reiseziel reiseziel, ArrayList<Lehrer> zweilehrer, Klasse klasse, Date startdatum, Date endedatum){
        setKlasse(klasse);
        setZweilehrer(zweilehrer);
        setReiseziel(reiseziel);
        setEndedatum(endedatum);
        setStartdatum(startdatum);
    }

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
