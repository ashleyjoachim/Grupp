package com.example.c4q.capstone.database.privateuserdata;


import java.util.List;

public class PrivateUser {
    private UserPreferences preferences;
    private PrivateUserLocation current_location;
    private String first_name;
    private String last_name;
    private boolean over_18;
    private boolean over_21;
    private int radius;
//    private List<String> user_preferences;

    public PrivateUser() {
    }

    public PrivateUser(UserPreferences preferences) {
        this.preferences = preferences;
    }

    public PrivateUser(String first_name, String last_name, boolean over_18, boolean over_21, int radius) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.over_18 = over_18;
        this.over_21 = over_21;
        this.radius = radius;
    }

    public PrivateUserLocation getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(PrivateUserLocation current_location) {
        this.current_location = current_location;
    }

    public UserPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isOver_18() {
        return over_18;
    }

    public void setOver_18(boolean over_18) {
        this.over_18 = over_18;
    }

    public boolean isOver_21() {
        return over_21;
    }

    public void setOver_21(boolean over_21) {
        this.over_21 = over_21;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
