package com.suft.bank;

/**
 * 
 * 
 * @author Sufien Tout
 * @version 1.0
 *
 */
public class App {

    public static void main(String[] args) {
    	Bank bank = new Bank();
    	String balance = bank.fetchBalance("1234567");
    	System.out.printf("Bank Account #1234567 has a balance of $%s", balance);
    }
}
