package com.flightinfo.repository;

import com.flightinfo.model.Flight;

import java.util.List;

public interface FlightRepository {
    void add(Flight flight);

    void addAll(List<Flight> flights);

    void update(Flight flight);

    List<Flight> getAll();

    List<Flight> getByFlightNumber(String flightNumber);

    List<Flight> getByRoute(String departureAirport, String arrivalAirport);

    List<Flight> getByDate(String date);
}
