package model;

public class Klasse {
    int _schueleranzahl;
    double _schuelerdurchschnittsalter;
    double _maxschuelerbudget;

    public Klasse(int schueleranzahl, double schuelerdurchschnittsalter, double maxschuelerbudget){
        setMaxschuelerbudget(maxschuelerbudget);
        setSchueleranzahl(schueleranzahl);
        setSchuelerdurchschnittsalter(schuelerdurchschnittsalter);
    }

    public void setMaxschuelerbudget(double maxschuelerbudget) {
        this._maxschuelerbudget = maxschuelerbudget;
    }
    public void setSchueleranzahl(int schueleranzahl) {
        this._schueleranzahl = schueleranzahl;
    }
    public void setSchuelerdurchschnittsalter(double schuelerdurchschnittsalter) {
        this._schuelerdurchschnittsalter = schuelerdurchschnittsalter;
    }
    public double getMaxschuelerbudget() {
        return _maxschuelerbudget;
    }
    public int getSchueleranzahl() {
        return _schueleranzahl;
    }
    public double getSchuelerdurchschnittsalter() {
        return _schuelerdurchschnittsalter;
    }

}
