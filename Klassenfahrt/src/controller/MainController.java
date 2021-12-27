package controller;
import java.text.ParseException;

import view.Output;

public class MainController {
    KlassenfahrtController kfc;
    KlasseController klc;
    LehrerController lec;
    ReisezielController rec;
    Output o = new Output();

    public MainController(){
        setKlc(new KlasseController(this));
        setLec(new LehrerController(this));
        setRec(new ReisezielController(this));
        setKfc(new KlassenfahrtController(this));
        
    }

    public void createDemoData() throws ParseException{
        getKlc().createKlasseData();
        getLec().createLehrerData();
        getRec().createReisezielData();
        getKfc().createKlassenfahrtData();
    }

    public void evaluateBedingungen(){
        getKfc().checkNotwendigeBedingungen();
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