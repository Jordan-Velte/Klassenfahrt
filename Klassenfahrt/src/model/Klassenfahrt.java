package model;
import java.util.ArrayList;

public class Klassenfahrt {
    Reiseziel _reiseziel;
    Klasse _klasse;
    ArrayList<Lehrer> zweilehrer = new ArrayList<Lehrer>();

    public Klassenfahrt (Reiseziel reiseziel, , Klasse klasse){
        setKlasse(klasse);
        setZweilehrer(zweilehrer);
        setReiseziel(reiseziel);
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
    public Klasse getKlasse() {
        return _klasse;
    }
    public ArrayList<Lehrer> getZweilehrer() {
        return zweilehrer;
    }
    public Reiseziel getReiseziel() {
        return _reiseziel;
    }



}
