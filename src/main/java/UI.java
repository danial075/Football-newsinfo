import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public UI() {

    }

    public void Startup() {
        try {
            System.out.println("Welcome to Danial's random football facts and news");
            System.out.println("\n Enter one to see the current transfer news");
            System.out.println("\n Enter two to see the Premier League top 100 scorers");
            System.out.println("\n Enter three to see the Premier League table");
            System.out.println("\n Enter any other number to exit to quit the program ");

            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();

            if (option == 1) {

            }
            if (option == 2) {
                Topscorer t = new Topscorer();
                t.establishConnection();
            }
            if (option == 3) {

            } else {
                System.out.println("Application has quit");
            }
        }
        catch (InputMismatchException e) {
                System.out.println("Type in a relevant number");

        }
    }



}
