package com.flightinfo.service;

import com.flightinfo.model.Flight;
import com.flightinfo.repository.FlightRepository;

import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
        loadSampleFlights();
    }

    public void addFlight(Flight flight) {
        repository.add(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.getAll();
    }

    public List<Flight> searchByNumber(String flightNumber) {
        return repository.getByFlightNumber(flightNumber);
    }

    public List<Flight> searchByRoute(String departureAirport, String arrivalAirport) {
        return repository.getByRoute(departureAirport, arrivalAirport);
    }

    public List<Flight> searchByDate(String date) {
        return repository.getByDate(date);
    }

    private void loadSampleFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AO1812", "Air India", "KAR", "PAN", "2026-04-02", "Scheduled", null));
        flights.add(new Flight("DE0309", "IndiGo", "PON", "PAN", "2026-04-02", "Active", null));
        flights.add(new Flight("SK0609", "Vistara", "PAN", "PON", "2026-04-03", "Scheduled", null));
        flights.add(new Flight("AC1074", "Mumbai", "PAN","KAR","2026-04-04","Scheduled",null));
        repository.addAll(flights);
    }
}
