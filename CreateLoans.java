/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author BN
 */
public class CreateLoans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Loan> list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter prime intrest rate(as decimal): ");
        double primeInterestRate = scan.nextDouble();

        for (int i = 0; i < 5; i++) {
            //prompt user for loan type
            int selection = userSelection();
            //create and add objects based on selected input
            switch (selection) {
                //Business Loan
                case 1:
                    ArrayList bLoanInfo = getInfo();
                    list.add(new BusinessLoan(i + 1, (String) bLoanInfo.get(0),
                            (double) bLoanInfo.get(1), (int) bLoanInfo.get(2), primeInterestRate));
                    break;

                //Personal Loan
                case 2:
                    ArrayList pLoanInfo = getInfo();
                    list.add(new PersonalLoan(i + 1, (String) pLoanInfo.get(0),
                            (double) pLoanInfo.get(1), (int) pLoanInfo.get(2), primeInterestRate));
                    break;

                default:
                    System.out.println("Invalid Selection");
                    selection = userSelection();
                    break;
            }
        }
        System.out.println("");
        output(list);

    }

    public static int userSelection() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nMake selection \n"
                + "\"1\" Business Loan "
                + "\n\"2\" Personal Loan"
                + "\nEnter Selection: ");
        int selection = scan.nextInt();
        System.out.println("");
        return selection;
    }

    public static ArrayList<Object> getInfo() {
        ArrayList<Object> info = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter last name: ");
        String lastName = scan.next();
        info.add(lastName);

        System.out.print("Enter loan amount: ");
        double amount = scan.nextDouble();
        info.add(amount);

        System.out.print("Enter loan term: ");
        int term = scan.nextInt();
        info.add(term);

        return info;
    }

    public static void output(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            System.out.println("");
        }
    }
}
