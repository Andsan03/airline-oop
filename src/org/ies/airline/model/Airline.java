package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    public void showFlightsFromOrigin(String origin) {
        for (var flight: flights) {
            if (flight.getOrigin().equals(origin)) {
                System.out.println(flight);
            }else {
                System.out.println("No hay ningun vuelo desde ese origen");
            }
        }
    }

    public Flight findFlight(int flightNumber) {
        for (var flight: flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void showPassengerFlights(String nif) {
        for (var flight:flights) {
            if (flight.hasPassenger(nif)) {
                System.out.println(flight);
            }else {
                System.out.println("Pasajero sin vuelo");
            }
        }
    }

    public int getPassengerSeat(int flightNumber, String nif) {
        var flight = findFlight(flightNumber);
        var passenger = flight.findPassenger(nif);
        if (passenger != null) {
            return passenger.getSeatNumber();
        } else if (passenger == null) {
            System.out.println("Pasajero no encontrado");
        } else if (flight == null) {
            System.out.println("Vuelo no encontrado");
        }
        return null;
    }

    public void showInfo() {
        System.out.println("Nombre:" + name);
        System.out.println("Vuelos: " + flights);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Objects.deepEquals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(flights));
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
