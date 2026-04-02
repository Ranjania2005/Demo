package com.flightinfo.model;

import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private String airlineName;
    private String departureAirport;
    private String arrivalAirport;
    private String flightDate;
    private String status;
    private LocalDateTime lastUpdated;

    public Flight() {
    }

    public Flight(String flightNumber, String airlineName, String departureAirport, String arrivalAirport,
                  String flightDate, String status, LocalDateTime lastUpdated) {
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDate = flightDate;
        this.status = status;
        this.lastUpdated = lastUpdated;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getStorageKey() {
        return safe(flightNumber) + "|" + safe(flightDate) + "|" + safe(departureAirport) + "|" + safe(arrivalAirport);
    }

    private String safe(String value) {
        return value == null ? "" : value.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + System.lineSeparator()
                + "Airline: " + airlineName + System.lineSeparator()
                + "Route: " + departureAirport + " -> " + arrivalAirport + System.lineSeparator()
                + "Date: " + flightDate + System.lineSeparator()
                + "Status: " + status + System.lineSeparator()
                + "Last Updated: " + lastUpdated;
    }
}
