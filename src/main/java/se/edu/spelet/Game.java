package se.edu.spelet;

import se.edu.spelet.model.Burglar;
import se.edu.spelet.model.Resident;
import java.util.Scanner;

public class Game {

    private Room currentRoom;
    private Room livingRoom;
    private Resident resident;
    private Burglar burglar;
    private boolean firstTimeInKitchen = true;

    public Game(){
        burglar = new Burglar("Burglar", 10, 4);
        resident = new Resident("Resident", 10, 3);

        livingRoom = new Room("Vardagsrummet", "The central living room where you start.");
        Room kitchen = new Room("Köket", "The kitchen with a delicious smell.");
        Room office = new Room("Kontoret", "The office with a big wooden desk.");
        Room bedRoom = new Room("Sovrummet", "A cozy bedroom with a large bed.");
        Room hall = new Room("Hall", "A large hall with a grand staircase.");

//        livingRoom.setEast(bedRoom);
//        bedRoom.setWest(livingRoom);
//
//        livingRoom.setWest(kitchen);
//        kitchen.setEast(livingRoom);
//
//        livingRoom.setNorth(office);
//        office.setSouth(livingRoom);
//
//        livingRoom.setSouth(hall);
//        hall.setNorth(livingRoom);

        livingRoom.setNorth(office);
        livingRoom.setEast(bedRoom);
        livingRoom.setWest(kitchen);
        livingRoom.setSouth(hall);

        kitchen.setCentral(livingRoom);
        office.setCentral(livingRoom);
        bedRoom.setCentral(livingRoom);
        hall.setCentral(livingRoom);

        currentRoom = livingRoom;
    }

    public void start(){
        System.out.println("Vällkomen till äventyrsspelet!\n");
        System.out.println("Du är i ditt boende och har somant på soffan i vardagsrummet och vaknar av ett ljud...");
        showCurrentRoom();
    }

    public void end(){
        System.out.println("Thank you for playing professor falken!");
    }


    public void execute(String command){
        Room nextRoom = null;
        switch (command.toLowerCase()) {
            case "n":
            case "north": //North (office);
                if (currentRoom == livingRoom) {
                    nextRoom = currentRoom.getNorth();
                } else {
//                    nextRoom = currentRoom.getSouth();
//                    nextRoom = currentRoom.getNorth();
                }
                break;
            case "e":
            case "east": //East (bedRoom);
                if (currentRoom == livingRoom) {
                    nextRoom = currentRoom.getEast();
                } else {
//                    nextRoom = currentRoom.getSouth();
                }
                break;
            case "s":
            case "south": //South (hall);
                if (currentRoom == livingRoom) {
                    nextRoom = currentRoom.getSouth();
                } else {
//                    nextRoom = currentRoom.getSouth();
                }
                break;
            case "w":
            case "west": //West (kitchen);
                if (currentRoom == livingRoom) {
                    nextRoom = currentRoom.getWest();
                } else {
//                    nextRoom = currentRoom.getSouth();
                }
                break;
            case "livingroom":
            case "vardagsrummet":
                nextRoom = livingRoom;
                break;
            default:
                System.out.println("Invalid direction.");
                return;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            showCurrentRoom();
            if (currentRoom.getName().equals("Köket")) {
                kitchenEvents();
            } else if (currentRoom.getName().equals("Hall")) {
                hallEvents();
            } else if (currentRoom.getName().equals("Kontoret")) {
                officeEvents();
            }
        } else {
            System.out.println("Du kan inte gå åt det hållet.");
        }
    }

    private void showCurrentRoom() {
        System.out.println("Du är nu i " + currentRoom.getName() + ".");
        System.out.println(currentRoom.getDescription());
    }

    private void kitchenEvents() {
        if (currentRoom.getName().equals("Köket")) {
            if (firstTimeInKitchen && !currentRoom.isFryingPanFound()) {
                firstTimeInKitchen = false; // första besöket
                System.out.println("Du hittade en stekpanna! Vill du ta den? (ja/nej)");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("ja")) {
                    resident.setDamage(3);
                    System.out.println("Du tog stekpannan! Din skada har ökat.");
                    currentRoom.setFryingPanFound(true);
                } else {
                    System.out.println("Du tog inte stekpannan, din skada är det samma ");
                }
            } else {
                System.out.println("Du är tillbaka i köket. Stekpannan är inte längre här.");
            }
        }
    }

    private void hallEvents() {
        System.out.println("Du möter en inbrottstjuv i hallen!");
        startCombat();
    }

    private void startCombat() {
        Scanner scanner = new Scanner(System.in);
        while (resident.isConscious() && burglar.isConscious()) {
            System.out.println("Vad vill du göra? (attack/flee)");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("attack")) {
                resident.punch(burglar);
                System.out.println("Du attackerade inbrottstjuven!");
                System.out.println("Inbrottstjuvens hälsa: " + burglar.getHealth());

                if (burglar.isConscious()) {
                    burglar.punch(resident);
                    System.out.println("Burglar attackerar dig tillbaka!");
                    System.out.println("Din hälsa: " + resident.getHealth());
                }
            } else if (action.equalsIgnoreCase("flee")) {
                System.out.println("Du flyr tillbaka till vardagsrummet.");
                currentRoom = livingRoom;
                showCurrentRoom();
                return;
            } else {
                System.out.println("Ogiltig handling.");
            }
        }

        if (resident.isConscious() && !burglar.isConscious()) {
            System.out.println("Du besegrade inbrottstjuven!");
        } else if (!resident.isConscious()) {
            System.out.println("Du blev besegrad av inbrottstjuven. Spelet är slut.");
            System.exit(0);
        }
    }


    private void officeEvents() {
        if (burglar.isKnockedOut()) {
            System.out.println("Tjuven är knockad. Vill du ringa polisen? (ja/nej)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("ja")) {
                System.out.println("Du ringer polisen. Spelet är över och du är säker.");
                System.exit(0);
            } else {
                System.out.println("Du väljer att inte ringa polisen just nu.");
            }
        } else {
            System.out.println("Du är i kontoret. Det verkar som om tjuven fortfarande är där ute.");
        }
    }


}

