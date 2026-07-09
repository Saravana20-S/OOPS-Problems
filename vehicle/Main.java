package com.oops.vehicle;

//Base Class
class Vehicle {
 protected String registrationNumber;
 protected String brand;
 protected String fuelType;

 public Vehicle(String registrationNumber, String brand, String fuelType) {
     this.registrationNumber = registrationNumber;
     this.brand = brand;
     this.fuelType = fuelType;
 }

 public void start() {
     System.out.println(brand + " vehicle is starting");
 }

 public void stop() {
     System.out.println(brand + " vehicle is stopping");
 }

 public void displayDetails() {
     System.out.println("Registration Number: " + registrationNumber);
     System.out.println("Brand              : " + brand);
     System.out.println("Fuel Type          : " + fuelType);
 }
}

//Car Class
class Car extends Vehicle {
 private int seatingCapacity;

 public Car(String regNo, String brand, String fuelType, int seatingCapacity) {
     super(regNo, brand, fuelType);
     this.seatingCapacity = seatingCapacity;
 }
 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Seating Capacity : " + seatingCapacity);
 }
 

}

//Bike Class
class Bike extends Vehicle {
 private int engineCapacity;

 public Bike(String regNo, String brand, String fuelType, int engineCapacity) {
     super(regNo, brand, fuelType);
     this.engineCapacity = engineCapacity;
 }

 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Engine Capacity    : " + engineCapacity + " cc");
 }
}

//Truck Class
class Truck extends Vehicle {
 private double loadCapacity;

 public Truck(String regNo, String brand, String fuelType, double loadCapacity) {
     super(regNo, brand, fuelType);
     this.loadCapacity = loadCapacity;
 }

 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Load Capacity      : " + loadCapacity + " tons");
 }
}

//Main Class
public class Main {
 public static void main(String[] args) {

     Vehicle car = new Car("TN01AB1234", "Toyota", "Petrol", 5);
     Vehicle bike = new Bike("KA02XY5678", "Yamaha", "Petrol", 150);
     Vehicle truck = new Truck("MH03TR9999", "Tata", "Diesel", 10.5);

     car.start();
     car.displayDetails();
     car.stop();

     bike.start();
     bike.displayDetails();
     bike.stop();

     truck.start();
     truck.displayDetails();
     truck.stop();
 }
}