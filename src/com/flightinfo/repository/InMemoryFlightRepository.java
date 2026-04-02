package com.flightinfo.repository;

import com.flightinfo.model.Flight;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFlightRepository implements FlightRepository {
    private final Map<String, Flight> flightStore = new LinkedHashMap<>();

    @Override
    public void add(Flight flight) {
        if (flight == null) {
            return;
        }
        flightStore.putIfAbsent(flight.getStorageKey(), flight);
    }

    @Override
    public void addAll(List<Flight> flights) {
        for (Flight flight : flights) {
            add(flight);
        }
    }

    @Override
    public void update(Flight flight) {
        if (flight == null) {
            return;
        }
        flightStore.put(flight.getStorageKey(), flight);
    }

    @Override
    public List<Flight> getAll() {
        return new ArrayList<>(flightStore.values());
    }

    @Override
    public List<Flight> getByFlightNumber(String flightNumber) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flightStore.values()) {
            if (flight.getFlightNumber() != null && flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                result.add(flight);
            }
        }
        return result;
    }

    @Override
    public List<Flight> getByRoute(String departureAirport, String arrivalAirport) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flightStore.values()) {
            boolean sameDeparture = flight.getDepartureAirport() != null
                    && flight.getDepartureAirport().equalsIgnoreCase(departureAirport);
            boolean sameArrival = flight.getArrivalAirport() != null
                    && flight.getArrivalAirport().equalsIgnoreCase(arrivalAirport);

            if (sameDeparture && sameArrival) {
                result.add(flight);
            }
        }
        return result;
    }

    @Override
    public List<Flight> getByDate(String date) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flightStore.values()) {
            if (flight.getFlightDate() != null && flight.getFlightDate().equalsIgnoreCase(date)) {
                result.add(flight);
            }
        }
        return result;
    }
}
