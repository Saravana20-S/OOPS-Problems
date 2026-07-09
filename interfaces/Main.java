package com.oops.interfaces;

// Capability 1: WiFi
interface WiFiCapable {
    void connectWiFi();
}

// Capability 2: Music
interface MusicPlayable {
    void playMusic();
}

// Capability 3: Video Streaming
interface VideoStreamable {
    void streamVideo();
}

// SmartTV implements ALL capabilities
class SmartTV implements WiFiCapable, MusicPlayable, VideoStreamable {

    private String brand;

    public SmartTV(String brand) {
        this.brand = brand;
    }

    @Override
    public void connectWiFi() {
        System.out.println(brand + " Smart TV connected to Wi-Fi.");
    }

    @Override
    public void playMusic() {
        System.out.println(brand + " Smart TV is playing music.");
    }

    @Override
    public void streamVideo() {
        System.out.println(brand + " Smart TV is streaming video.");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        SmartTV tv = new SmartTV("Samsung");

        // Demonstrating each feature independently
        WiFiCapable wifi = tv;
        wifi.connectWiFi();

        MusicPlayable music = tv;
        music.playMusic();

        VideoStreamable video = tv;
        video.streamVideo();
    }
}