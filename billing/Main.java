package com.oops.billing;

// Utility Class
class BillingUtility {

    // Two integers
    public void calculateTotal(int a, int b) {
        int total = a + b;
        System.out.println("Total (2 integers): " + total);
    }

    // Three integers
    public void calculateTotal(int a, int b, int c) {
        int total = a + b + c;
        System.out.println("Total (3 integers): " + total);
    }

    // Two doubles
    public void calculateTotal(double a, double b) {
        double total = a + b;
        System.out.println("Total (2 decimals): " + total);
    }

    // One int and one double
    public void calculateTotal(int a, double b) {
        double total = a + b;
        System.out.println("Total (int + decimal): " + total);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        BillingUtility bill = new BillingUtility();

        bill.calculateTotal(10, 20);
        bill.calculateTotal(5, 10, 15);
        bill.calculateTotal(10.5, 20.75);
        bill.calculateTotal(10, 5.5);
    }
}