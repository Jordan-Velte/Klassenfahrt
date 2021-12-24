package model;

public class Lehrer {
    String _vorname;
    String _nachname;
    String _klassenfahrterlaubnis;

    public Lehrer(String vorname, String nachname, String klassenfahrterlaubnis){
        setNachname(nachname);
        setVorname(vorname);
        setKlassenfahrterlaubnis(klassenfahrterlaubnis);
    }

    public void setNachname(String nachname) {
        this._nachname = nachname;
    }
    public void setVorname(String vorname) {
        this._vorname = vorname;
    }
    public void setKlassenfahrterlaubnis(String klassenfahrterlaubnis) {
        this._klassenfahrterlaubnis = klassenfahrterlaubnis;
    }
    public String getNachname() {
        return _nachname;
    }
    public String getVorname() {
        return _vorname;
    }
    public String getKlassenfahrterlaubnis() {
        return _klassenfahrterlaubnis;
    }

}
