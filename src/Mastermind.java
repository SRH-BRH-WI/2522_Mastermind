import java.util.Scanner;

public class Mastermind {

    // Einführung von Methoden (aka Funktionen, Prozeduren, Unterprogramme, ...)
    public static void ausgabeVersuche(int anzahlVersuche) {
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht.");
    }

    // Das ist unser "Hauptprogramm"
    public static void main(String[] args) {

        int geheimeZahl = 473;

        // TODO
        // Der Anwender soll eine Zahl eingeben,
        // wenn die Zahl der geheimen Zahl entspricht,
        // hat er gewonnen, ansonsten soll er weiter
        // raten. Falls er keine Lust mehr zu raten hat,
        // kann er das Programm mit der Eingabe von 0
        // beenden.

        Scanner eingabe = new Scanner(System.in);
        int versuchsZähler = 0;

        // Wir bauen eine Endlosschleife
        while ( true ) {
            System.out.print("Bitte Tipp abgeben: ");
            int zahl = eingabe.nextInt();
            versuchsZähler++;

            // Fall 1
            if (zahl == geheimeZahl) {
                System.out.println("Herzlichen Glückwunsch, das war die geheime Zahl!");
                ausgabeVersuche( versuchsZähler );
                break;
            }

            // Fall 2
            if (zahl == 0) {
                System.out.println("Schade, viel Glück beim nächsten Mal");
                ausgabeVersuche( versuchsZähler );
                break;
            }

            // Etwas bessere Hilfestellung beim Erraten der Zahl
            if (zahl - 200 > geheimeZahl )
                System.out.println("Die Zahl ist viel zu groß");
            else if (zahl - 50 > geheimeZahl)
                System.out.println("Die Zahl ist zu groß");
            else if (zahl > geheimeZahl)
                System.out.println("Die Zahl ist etwas zu groß");
            else if (zahl + 200 < geheimeZahl)
                System.out.println("Die Zahl ist viel zu klein");
            else if (zahl + 50 < geheimeZahl)
                System.out.println("Die Zahl ist zu klein");
            else // if (zahl < geheimeZahl)
                System.out.println("Die Zahl ist etwas zu klein");
        }
        System.out.println("Auf Wiedersehen!");
    }
}
