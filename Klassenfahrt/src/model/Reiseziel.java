package model;

public class Reiseziel {
    String _reisezielname;
    String _hotelname;
    double _preisperschueler;
    double _preisperlehrer;
    double _minschueleralter;

    public Reiseziel(String reisezielname, String hotelname, double preisperschueler, double preisperlehrer, double minschueleralter){
        setHotelname(hotelname);
        setMinschueleralter(minschueleralter);
        setPreisperlehrer(preisperlehrer);
        setPreisperschueler(preisperschueler);
        setReisezielname(reisezielname);
    }

    public void setHotelname(String hotelname) {
        this._hotelname = hotelname;
    }
    public void setMinschueleralter(double minschueleralter) {
        this._minschueleralter = minschueleralter;
    }
    public void setPreisperlehrer(double preisperlehrer) {
        this._preisperlehrer = preisperlehrer;
    }
    public void setPreisperschueler(double preisperschueler) {
        this._preisperschueler = preisperschueler;
    }
    public void setReisezielname(String reisezielname) {
        this._reisezielname = reisezielname;
    }
    public String getHotelname() {
        return _hotelname;
    }
    public double getMinschueleralter() {
        return _minschueleralter;
    }
    public double getPreisperlehrer() {
        return _preisperlehrer;
    }
    public double getPreisperschueler() {
        return _preisperschueler;
    }
    public String getReisezielname() {
        return _reisezielname;
    }


}
