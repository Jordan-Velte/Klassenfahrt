//MainController-Klasse wird importiert, um auf die Klasse für den späteren Verlauf zugreifen zu können.
import controller.MainController;

public class App {
    public static void main(String[] args) throws Exception {
        //Erstellung einer Instanz der Klasse MainController
        MainController mcmain = new MainController();
        //Per Punktnotation an der Instanz werden die Methoden der MainController-Klasse aufgerufen.
        mcmain.createDemoData();
        mcmain.evaluateBedingungen();

    }
}
