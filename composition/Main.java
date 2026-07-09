package com.oops.composition;

import java.util.ArrayList;
import java.util.List;

// House Class (Owner)
class House {
    private String houseNumber;
    private List<Room> rooms;

    public House(String houseNumber) {
        this.houseNumber = houseNumber;
        this.rooms = new ArrayList<>();
    }

    // Room is created INSIDE House (Composition)
    public void addRoom(String roomType) {
        rooms.add(new Room(roomType));
    }

    public void displayHouseDetails() {
        System.out.println("House Number: " + houseNumber);
        System.out.println("Rooms:");
        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    // Inner Class (Strong ownership)
    private class Room {
        private String roomType;

        public Room(String roomType) {
            this.roomType = roomType;
        }

        public void displayRoom() {
            System.out.println("Room Type : " + roomType);
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        House house = new House("H-101");

        house.addRoom("Bedroom");
        house.addRoom("Kitchen");
        house.addRoom("Hall");

        house.displayHouseDetails();

        // When house is removed, rooms are automatically gone
        house = null;

        System.out.println("House not exist");
    }
}