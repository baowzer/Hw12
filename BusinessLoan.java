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
public class BusinessLoan extends Loan {

    public BusinessLoan() {
    }

    public BusinessLoan(int loanNumber, String lastName, double ammount, int term, double primeInterestRate) {
        super(loanNumber, lastName, ammount, term);
        super.interestRate = primeInterestRate + .01;

    }

}
