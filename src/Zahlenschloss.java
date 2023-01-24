import java.util.Scanner;

public class Zahlenschloss {

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

            System.out.println("Sorry, aber diese Zahl ist falsch");
        }
        System.out.println("Auf Wiedersehen!");
    }
}
