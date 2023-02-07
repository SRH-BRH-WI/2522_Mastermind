import java.util.Scanner;

public class Mastermind {

    // Einführung von Methoden (aka Funktionen, Prozeduren, Unterprogramme, ...)
    // Warum brauchen wir Methoden:
    // 1. Vermeidung von doppeltem Code (DRY)
    // 2. Komplexe Aufgaben in kleinere (evtl. einfachere) Unteraufgaben
    //    aufzuteilen, die man später bearbeiten und lösen kann.
    // 3. Einführung einer domain-spezifischen Sprache, wenn alle Einzelschritte
    //    in klar benannte Prozeduren aufgeteilt werden.

    // Das ist unser "Hauptprogramm"
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        int anzahlZuErratenenZiffern = 0;
        do {
            System.out.print("Wieviele Ziffern sollen erraten werden: ");
            anzahlZuErratenenZiffern = eingabe.nextInt();
        } while (anzahlZuErratenenZiffern < 2 || anzahlZuErratenenZiffern > 8);

        int geheimeZahl = 0;
        do {
            double faktor = Math.pow(10, anzahlZuErratenenZiffern);
            geheimeZahl = (int) (Math.random() * faktor);  // explizite Typkonvertierung
        } while ( ! istGeeigneteGeheimzahl(geheimeZahl, anzahlZuErratenenZiffern) );

        // TODO
        // Der Anwender soll eine Zahl eingeben.
        // Hat er die Zahl erraten, ist das Spiel beendet.
        // Ansonsten wird ihm mitgeteilt,
        // - welche Ziffern sind korrekt, d.h. an der richtigen Stelle
        // - welche Ziffern sind vorhanden, d.h. nicht an der richtigen Stelle
        // z.B. geheimeZahl = 473
        //      rateZahl    = 123   Tipp: 1 Ziffer korrekt
        //      rateZahl    = 493   Tipp: 2 Ziffern korrekt
        //      rateZahl    = 321   Tipp: 1 Ziffer vorhanden
        //      rateZahl    = 689   Tipp: nix richtig

        int versuchsZähler = 0;

        // Wir bauen eine Endlosschleife
        while ( true ) {
            System.out.print("Bitte Tipp abgeben: ");
            int zahl = eingabe.nextInt();                   // lokale Variable
            versuchsZähler++;
            if (zahl == 0) {
                System.out.println("Schade, viel Glück beim nächsten Mal");
                System.out.println("Die Geheimzahl war " + geheimeZahl);
                break;
            }
            if (zahl == geheimeZahl) {
                System.out.println("Herzlichen Glückwunsch, das ist die korrekte Zahl");
                break;
            }
            prüfeAufKorrekteZiffern(zahl, geheimeZahl);
        }
        System.out.println("Sie haben " + versuchsZähler + " Versuche gebraucht.");
        System.out.println("Auf Wiedersehen!");
    }

    private static boolean istGeeigneteGeheimzahl(int geheimeZahl,
                                                  int anzahlGeforderterVerschiedeneZiffern) {

        int anzahlVerschiedenerZiffern = 0;
        for (int ziffer=0; ziffer < 10; ziffer++)
            if (prüfeObZifferVorhanden(ziffer, geheimeZahl))
                anzahlVerschiedenerZiffern++;
        return (anzahlVerschiedenerZiffern == anzahlGeforderterVerschiedeneZiffern);
    }

    // Aufbau einer Methode:
    // 1. Methodenkopf
    // 2. Methodenrumpf (aka Implementierung, Realisierung)

    // Der Methodenkopf ist aufgebaut:
    // . private: Sichtbarkeit
    // . static:  Modifikator
    // . Datentyp: void als Spezialdatentyp, um anzuzeigen, dass hier nichts berechnet wird
    // . Name
    // . Parameter (in Klammern): Datentyp und Parametername (beliebig viele)
    //         (Die Parameter nennt man auch "formale Variable")

    // "Definition": Prozedur (Unterprogramm): hat als Datentyp "void"
    //               Bearbeite ein Problem und kümmere dich um die Lösung.
    private static void prüfeAufKorrekteZiffern(int zahl, int geheimeZahl) {
        // beim Start der Methode erhalten die beiden Parameter den Wert, der
        // beim Aufruf in den Klammern steht

        int kopieDerGeheimenZahl = geheimeZahl;
        int anzahlKorrekteZiffern = 0;
        int anzahlVorhandenZiffern = 0;

        while (zahl > 0) {
            int zifferDerZahl = zahl % 10;
            int zifferDerGeheimenZahl = geheimeZahl % 10;
            if (zifferDerZahl == zifferDerGeheimenZahl)
                anzahlKorrekteZiffern++;
            else if ( prüfeObZifferVorhanden(zifferDerZahl, kopieDerGeheimenZahl) )
                anzahlVorhandenZiffern++;
            zahl = zahl / 10;
            geheimeZahl = geheimeZahl / 10;
        }

        System.out.println("Tipp: Es gibt " + anzahlKorrekteZiffern + " korrekte Ziffern");
        System.out.println("      Es gibt " + anzahlVorhandenZiffern + " vorhandene Ziffern");
    }

    // "Definition": Funktion: hat als Datentyp ungleich "void"
    //               Bearbeite ein Problem und liefere die Lösung
    private static boolean prüfeObZifferVorhanden(int zifferDerZahl, int geheimeZahl) {

        while (geheimeZahl > 0) {
            int zifferDerGeheimenZahl = geheimeZahl % 10;
            if (zifferDerZahl == zifferDerGeheimenZahl)
                return true;
            geheimeZahl /= 10; // Faulenzer, entspricht: geheimeZahl = geheimeZahl / 10
        }
        return false; // liefert das Ergebnis
    }
}
