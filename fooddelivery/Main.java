package com.oops.fooddelivery;

import java.util.*;

// STATUS CLASS (ONLY 2 STATES)
class OrderStatus {
	public static final String PLACED = "PLACED";
	public static final String DELIVERED = "DELIVERED";
}

// MENU ITEM
class MenuItem {
	String name;
	double price;

	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

}

// RESTAURANT
class Restaurant {
	String name;
	List<MenuItem> menu = new ArrayList<>();

	public Restaurant(String name) {
		this.name = name;
	}

	public void addMenuItem(MenuItem item) {
		menu.add(item);
	}

	public void showMenu() {
		System.out.println("Menu of " + name);
		for (MenuItem item : menu) {
			System.out.println(item.name + " - ₹" + item.price);
		}
	}

}

// PAYMENT
interface PaymentMethod {
	void pay(double amount);
}

class UPIPayment implements PaymentMethod {
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " via UPI");
	}
}

// CUSTOMER
class Customer {
	String name;

	public Customer(String name) {
		this.name = name;
	}

	public double applyDiscount(double amount) {
		return amount;
	}

}

// PREMIUM CUSTOMER
class PremiumCustomer extends Customer {
	public PremiumCustomer(String name) {
		super(name);
	}

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.9;
	}

}

// DELIVERY PARTNER
class DeliveryPartner {
	String name;

	public DeliveryPartner(String name) {
		this.name = name;
	}

	public void deliver() {
		System.out.println(name + " is delivering the order");
	}

}

// ORDER
class Order {
	Customer customer;
	Restaurant restaurant;
	List<MenuItem> items = new ArrayList<>();
	String status;
	DeliveryPartner deliveryPartner;

	public Order(Customer customer, Restaurant restaurant) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.status = OrderStatus.PLACED;
	}

	public void addItem(MenuItem item) {
		items.add(item);
	}

	public double calculateTotal() {
		double total = 0;
		for (MenuItem item : items) {
			total += item.price;
		}
		return customer.applyDiscount(total);
	}

	public void makePayment(PaymentMethod payment) {
		double amount = calculateTotal();
		payment.pay(amount);
		System.out.println("Order Confirmed!");
	}

	public void assignDelivery(DeliveryPartner partner) {
		this.deliveryPartner = partner;
		partner.deliver();
	}

	public void deliverOrder() {
		status = OrderStatus.DELIVERED;
		System.out.println("Order Delivered!");
	}

	public void trackOrder() {
		System.out.println("Current Status: " + status);
	}


}

// MAIN
public class Main {
	public static void main(String[] args) {

		Restaurant r = new Restaurant("Dominos");
		MenuItem pizza = new MenuItem("Pizza", 300);
		MenuItem coke = new MenuItem("Coke", 50);

		r.addMenuItem(pizza);
		r.addMenuItem(coke);

		r.showMenu();

		Customer customer = new PremiumCustomer("Saravanan");

		Order order = new Order(customer, r);
		order.addItem(pizza);
		order.addItem(coke);

		order.trackOrder();

		order.makePayment(new UPIPayment());

		DeliveryPartner dp = new DeliveryPartner("Ravi");
		order.assignDelivery(dp);

		order.deliverOrder();

		order.trackOrder();
	}

}
