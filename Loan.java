/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

/**
 *
 * @author BN
 */
public abstract class Loan implements LoanConstants {

    int loanNumber;
    String lastName;
    double ammount;
    double primeinterestRate;
    double interestRate;
    int term;

    public Loan() {
    }

    public Loan(int loanNumber, String lastName, double ammount, int term) {
        this.loanNumber = loanNumber;
        this.lastName = lastName;

        //do not allow more than the max loan
        if (ammount > maxLoan) {
            throw new IllegalArgumentException("Maximum loan exceeded.");
        }
        //if term is not 3 or 5 force it to one
        this.ammount = ammount;
        if (term != 3 && term != 5) {
            this.term = 1;
        } else {
            this.term = term;
        }
    }

    @Override
    public String toString() {
        String output = "Loan type: " + this.getClass().getTypeName() + 
                "\nLoan number: " + this.loanNumber + "\nLast name: "
                + this.lastName + "\nTerm: " + this.term + "\nLoan amount: "
                + this.ammount + "\nTotal payment: "
                + (this.ammount + (this.ammount * this.interestRate));
        return output;
    }

}
