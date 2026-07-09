package com.oops.notification;

// Interface
interface Notification {
    void send(String message);
}

// Email Notification
class EmailNotification implements Notification {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending Email to " + emailAddress + ": " + message);
    }
}

// SMS Notification
class SMSNotification implements Notification {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}

// Push Notification
class PushNotification implements Notification {
    private String deviceId;

    public PushNotification(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification to Device " + deviceId + ": " + message);
    }
}

// Service Class
class NotificationService {
    private Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(String message) {
        notification.send(message);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Notification email = new EmailNotification("user@gmail.com");
        Notification sms = new SMSNotification("9876543210");
        Notification push = new PushNotification("DEVICE123");

        NotificationService service;

        service = new NotificationService(email);
        service.notifyUser("Welcome via Email!");

        service = new NotificationService(sms);
        service.notifyUser("OTP via SMS");

        service = new NotificationService(push);
        service.notifyUser("New App Alert!");
    }
}