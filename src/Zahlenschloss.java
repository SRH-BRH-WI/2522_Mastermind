import java.util.Scanner;

public class Zahlenschloss {

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

        // Wir bauen eine Endlosschleife
        while ( true ) {
            System.out.print("Bitte Tipp abgeben: ");
            int zahl = eingabe.nextInt();

            // Fall 1
            if (zahl == geheimeZahl) {
                System.out.println("Herzlichen Glückwunsch, das war die geheime Zahl!");
                // Ende, oder?
                break;
            }

            // Fall 2
            if (zahl == 0) {
                System.out.println("Schade, viel Glück beim nächsten Mal");
                break;
            }

            System.out.println("Sorry, aber diese Zahl ist falsch");
        }
        System.out.println("Auf Wiedersehen!");
    }
}
