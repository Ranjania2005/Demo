package com.flightinfo.controller;

import com.flightinfo.model.Flight;
import com.flightinfo.service.FlightService;

import java.util.List;
import java.util.Scanner;

public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean process = true;

        printWelcome();

        while (process) {
            System.out.print("flight-cli> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "help" -> printHelp();
                    case "add" -> addFlight(parts);
                    case "search-number" -> printFlights(flightService.searchByNumber(getArgument(parts, 1)));
                    case "search-route" -> printFlights(flightService.searchByRoute(getArgument(parts, 1), getArgument(parts, 2)));
                    case "search-date" -> printFlights(flightService.searchByDate(getArgument(parts, 1)));
                    case "list" -> printFlights(flightService.getAllFlights());
                    case "exit" -> process = false;
                    default -> System.out.println("Unknown command. Type 'help' to see available commands.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }

        System.out.println("Application closed.");
    }

    private String getArgument(String[] parts, int index) {
        if (index >= parts.length) {
            throw new IllegalArgumentException("Missing required argument.");
        }
        return parts[index];
    }

    private void addFlight(String[] parts) {
        if (parts.length < 7) {
            throw new IllegalArgumentException("Use: add <number> <airline> <from> <to> <date> <status>");
        }

        Flight flight = new Flight();
        flight.setFlightNumber(parts[1]);
        flight.setAirlineName(parts[2]);
        flight.setDepartureAirport(parts[3]);
        flight.setArrivalAirport(parts[4]);
        flight.setFlightDate(parts[5]);
        flight.setStatus(parts[6]);

        flightService.addFlight(flight);
        System.out.println("Flight added.");
    }

    private void printFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        for (Flight flight : flights) {
            System.out.println("----------------------------------");
            System.out.println(flight);
        }
        System.out.println("----------------------------------");
    }

    private void printWelcome() {
        System.out.println("Flight Information Console Application");
        System.out.println("Type 'help' to see available commands.");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("help");
        System.out.println("add <number> <airline> <from> <to> <date> <status>");
        System.out.println("search-number <flight-number>");
        System.out.println("search-route <departure-airport> <arrival-airport>");
        System.out.println("search-date <yyyy-mm-dd>");
        System.out.println("list");
        System.out.println("exit");
    }
}
