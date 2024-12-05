package se.edu.spelet;

import se.edu.spelet.model.Burglar;
import se.edu.spelet.model.Resident;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What ya wanna do: ");
        String command = scanner.nextLine();
        System.out.println();
        while(!"q".equalsIgnoreCase(command)){
            game.execute(command);
            System.out.print("What ya wanna do: ");
            command = scanner.nextLine();
            System.out.println();
        }
        game.end();
        scanner.close();
    }
}
