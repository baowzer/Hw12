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
public class PersonalLoan extends Loan {

    public PersonalLoan() {
    }

    public PersonalLoan(int loanNumber, String lastName, double ammount, int term, double primeInterestRate) {
        super(loanNumber, lastName, ammount, term);
        super.interestRate = .02 + primeInterestRate;

    }

}
