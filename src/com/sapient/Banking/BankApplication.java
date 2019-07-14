package com.sapient.Banking;

import java.util.*;

public class BankApplication {
      public static void main(String[] args){
         Map<Integer, BankAccount> accounts = new HashMap<>();
         Bank bank = new Bank();
         Scanner scanner = new Scanner(System.in);
         BankClient client = new BankClient(scanner, bank);
         client.run();
        }
  }