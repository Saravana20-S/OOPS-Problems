package com.oops.payment;


//Payment Interface (Abstraction)
interface PaymentMethod {
 void processPayment(double amount);
}

//UPI Payment
class UPIPayment implements PaymentMethod {
 private String upiId;

 public UPIPayment(String upiId) {
     this.upiId = upiId;
 }

 @Override
 public void processPayment(double amount) {
     System.out.println("Processing UPI payment of " + amount + " using UPI ID: " + upiId);
 }
}

//Credit Card Payment
class CreditCardPayment implements PaymentMethod {
 private String cardNumber;

 public CreditCardPayment(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 public void processPayment(double amount) {
     System.out.println("Processing Credit Card payment of " + amount + " using Card: " + cardNumber);
 }
}

//Debit Card Payment
class DebitCardPayment implements PaymentMethod {
 private String cardNumber;

 public DebitCardPayment(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 public void processPayment(double amount) {
     System.out.println("Processing Debit Card payment of " + amount + " using Card: " + cardNumber);
 }
}

//Net Banking Payment
class NetBankingPayment implements PaymentMethod {
 private String bankName;

 public NetBankingPayment(String bankName) {
     this.bankName = bankName;
 }

 @Override
 public void processPayment(double amount) {
     System.out.println("Processing Net Banking payment of " + amount + " using Bank: " + bankName);
 }
}

//Checkout Class (Uses Abstraction)
class Checkout {
 private PaymentMethod paymentMethod;

 public Checkout(PaymentMethod paymentMethod) {
     this.paymentMethod = paymentMethod;
 }

 public void process(double amount) {
     paymentMethod.processPayment(amount);
 }
}

//Main Class
public class Main {
 public static void main(String[] args) {

     PaymentMethod upi = new UPIPayment("user@upi");
     PaymentMethod creditCard = new CreditCardPayment("1234-5678-9012");
     PaymentMethod debitCard = new DebitCardPayment("9876-5432-1098");
     PaymentMethod netBanking = new NetBankingPayment("HDFC");

     Checkout checkout1 = new Checkout(upi);
     checkout1.process(1000);

     Checkout checkout2 = new Checkout(creditCard);
     checkout2.process(2000);

     Checkout checkout3 = new Checkout(debitCard);
     checkout3.process(1500);

     Checkout checkout4 = new Checkout(netBanking);
     checkout4.process(3000);
 }
}