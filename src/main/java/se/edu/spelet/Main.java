package se.edu.spelet;

import se.edu.spelet.model.Burglar;
import se.edu.spelet.model.Resident;

import java.util.Scanner;

public class Main {

    private static final String Hall = "Hall";
    private static final String Sovrummet = "Sovrummet";
    private static final String Kitchen = "Kitchen";
    private static final String Kontoret = "Kontoret";
    private static final String Vardagsrummet = "Central plats";
    private static final String Start = "Start";

    private static String currentLocation = Start;
    private static final String WRONG_WAY = "You can't go that way right now.";
    Scanner scanner = new Scanner(System.in);
    boolean adventureMap = true;

    public static void main(String[] args) {

        Burglar burglar = new Burglar("Burglar", 10, 0);
        Resident resident = new Resident("Resident", 9, 0);

        //välkomstmeddelande
        System.out.println("Vällkomen till äventyrsspelet!\n");
        System.out.println("Du är en boende som har somant på soffan i vardagsrummet och vaknar av ett ljud...");

        while adventureMap(Scanner) {
            quest();
            String userInput = userInput();
            adventureInput(userInput);
        }
    }

//    private void adventureMap() {
//        vardagsrummet();
//        while (adventureMap) {
//            quest();
//            String userInput = userInput();
//            adventureInput(userInput);
//        }
//    }

    private static void hall() {
        if (currentLocation.equals(Vardagsrummet)) {
            System.out.println("Du är i hallen. Vad vill du göra nu?");
            currentLocation = Hall;
        } else {
            System.out.println(WRONG_WAY);
        }
    }

    private static void sovrummet() {
        if (currentLocation.equals(Vardagsrummet)) {
            System.out.println("Du är i sovrummet. Vad vill du göra nu?");
            currentLocation = Sovrummet;
        } else {
            System.out.println(WRONG_WAY);
        }
    }

    public static void vardagsrummet() {
        if (!currentLocation.equals(Vardagsrummet)) {
            System.out.println("Du är i vardagsrummet. Vad vill du göra nu?");
            currentLocation = Vardagsrummet;
        } else {
            System.out.println("Du är redan i vardagsrummet.");
        }
    }

    private static void kitchen() {
        if (currentLocation.equals(Vardagsrummet)) {
            System.out.println("Du är i köket. Vad vill du göra nu?");
            currentLocation = Kitchen;
        } else {
            System.out.println(WRONG_WAY);
        }
    }

    private static void kontoret() {
        if (currentLocation.equals(Vardagsrummet)) {
            System.out.println("Du är i kontoret. Vad vill du göra nu?");
            currentLocation = Kontoret;
        } else {
            System.out.println(WRONG_WAY);
        }
    }

    public String userInput() {
        String userInput = scanner.nextLine().toLowerCase();
        return userInput;
    }

    public void quest() {
        System.out.println("Hall");
        System.out.println("Sovrummet");
        System.out.println("Vardagsrummet");
        System.out.println("köket");
        System.out.println("Kontoret");
        System.out.println("quit");
    }

    public void adventureInput(String userInput) {
        switch (userInput) {
            case "Hall" -> {
                hall();
                //yield "Going North, whats next?";
            }
            case "Sovrummet" -> {
                sovrummet();
                //yield "Going South, whats next?";
            }
            case "Vardagsrummet" -> {
                vardagsrummet();
                //yield "Going to town, whats next?";
            }
            case "Köket" -> {
                kitchen();
                //yield "Going East, whats next?";
            }
            case "kontoret" -> {
                kontoret();
                //yield "Going West, whats next?";
            }
            case "quit" -> {
                adventureMap = false;
                System.out.println("Du valde att avsluta");
            }
            default -> System.out.println("invalid input");
        };
    }

}
