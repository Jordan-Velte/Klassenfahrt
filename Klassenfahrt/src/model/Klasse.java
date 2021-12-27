package model;

public class Klasse {
    String _name;
    int _schueleranzahl;
    double _schuelerdurchschnittsalter;
    double _maxschuelerbudget;

    public Klasse(String name, int schueleranzahl, double schuelerdurchschnittsalter, double maxschuelerbudget){
        setMaxschuelerbudget(maxschuelerbudget);
        setName(name);
        setSchueleranzahl(schueleranzahl);
        setSchuelerdurchschnittsalter(schuelerdurchschnittsalter);
    }

    public void setMaxschuelerbudget(double maxschuelerbudget) {
        this._maxschuelerbudget = maxschuelerbudget;
    }
    public void setName(String name) {
        this._name = name;
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
    public String getName() {
        return _name;
    }
    public int getSchueleranzahl() {
        return _schueleranzahl;
    }
    public double getSchuelerdurchschnittsalter() {
        return _schuelerdurchschnittsalter;
    }

}
