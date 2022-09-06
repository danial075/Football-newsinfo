/**
 * Author:    Danial Sheikh
 * The UI Class is used to interact with the user to see which data they want to access
 **/

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public UI() {

    }

    public void Startup() {
        try {
            System.out.println("Welcome to Danial's random football facts and news");
            System.out.println("\n Enter the one number to see the current transfer news");
            System.out.println("\n Enter the two number to see the Premier League top 100 scorers");
            System.out.println("\n Enter the three number to see the Premier League table");
            System.out.println("\n Enter the four number to see your teams transfer information ");
            System.out.println("\n Enter any other number to exit to quit the program ");

            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();

            if (option == 1) {
                Transferupdates t = new Transferupdates();
                t.establishConnection();

            }
            if (option == 2) {
                Topscorer t = new Topscorer();
                t.establishConnection();
            }
            if (option == 3) {
                Leaguetable l = new Leaguetable();
                l.establishConnection();
            }

                if (option == 4) {

                    Transferupdates t = new Transferupdates();
                    t.establishConnection();
                    t.favouriteTeam("Manchester United");
                }



            else {
            }
        } catch (InputMismatchException e) {
            System.out.println("Type in a relevant number");

        }
    }


}
