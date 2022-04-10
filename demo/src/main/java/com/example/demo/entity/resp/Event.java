package com.example.demo.entity.resp;

import java.sql.Date;

import lombok.Data;

@Data
public class Event {
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStartTime24hr() {
        return eventStartTime24hr;
    }

    public void setEventStartTime24hr(String eventStartTime24hr) {
        this.eventStartTime24hr = eventStartTime24hr;
    }

    public String getEventEndTime24hr() {
        return eventEndTime24hr;
    }

    public void setEventEndTime24hr(String eventEndTime24hr) {
        this.eventEndTime24hr = eventEndTime24hr;
    }

    public String getEventImagePath() {
        return eventImagePath;
    }

    public void setEventImagePath(String eventImagePath) {
        this.eventImagePath = eventImagePath;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private Long eventId;
    private String eventName;
    private Date eventDate;
    private String eventStartTime24hr;
    private String eventEndTime24hr;
    private String eventImagePath;
    private String locationName;
    private String address1;
    private String street;
    private String suburb;
    private String city;
}
