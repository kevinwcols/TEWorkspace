package com.techelevator;

public class Television {

    // define the attributes for the class
    private boolean isOn;
    private int currentChannel = 3;
    private int currentVolume = 2;

    // No constructor for the Television class although the instance variables need default values:
    //      a new TV is off by default. The channel is set to three and the volume level to two.

    // define getters, no setters are needed
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() { return currentChannel; }

    public int getCurrentVolume() { return currentVolume; }

    // methods

    // turns off the TV
    public void turnOff() {
        isOn = false;
    }

    // turns the TV on and also resets the channel to three and the volume level to two.
    public void turnOn() {
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    // changes the current channel—only if it's on—to the value of newChannel as long as it's between 3 and 18.
    public void changeChannel( int newChannel ) {
        if (isOn == true) {
            if (currentChannel >= 3 && currentChannel <= 18) {
                currentChannel = newChannel;
            }
        }
    }

    // increases the current channel by one, only if it's on. If the value goes past 18, then the current channel must be set to three.
    public void channelUp() {
        if ( isOn == true &&  currentChannel < 18 ) {
                currentChannel = currentChannel + 1;
        }
        else {
            currentChannel = 3;
        }
    }

    // decreases the current channel by one, only if it's on. If the value goes below three, then the current channel must be set to 18.
    public void channelDown() {
        if ( isOn == true && currentChannel > 3 ) {
                currentChannel = currentChannel - 1;
        }
        else if ( isOn == true && currentChannel <= 3 ) {
            currentChannel = 18;
        }
    }

    //  increases the volume by one, only if it's on. The limit is 10.
    public void raiseVolume() {
        if ( isOn == true ) {
                currentVolume = currentVolume + 1;
                if ( currentVolume > 10) {
                    currentVolume = 10;
                }
        }
    }
    //  decreases the volume by one, only if it's on. The limit is zero.
    public void lowerVolume() {
        if ( isOn == true ) {
                currentVolume = currentVolume - 1;
                if ( currentVolume < 0 ) {
                    currentVolume = 0;
                }
        }
    }
}
