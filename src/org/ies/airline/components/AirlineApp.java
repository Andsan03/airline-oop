package org.ies.airline.components;

import java.util.Scanner;

public class AirlineApp {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run () {
        var airline = airlineReader.read();

        System.out.println("Que numero de vuelo deseas buscar?");
        var flightNumber = scanner.nextInt();
        scanner.nextLine();

        var flight = airline.findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Vuelo no encontrado");
        } else {
            System.out.println("Escribe el NIF del pasajero");
            var nif = scanner.nextLine();

            var passenger = flight.findPassenger(nif);

            if (passenger == null) {
                System.out.println("Pasajero no encontrado");
            } else {
                passenger.showInfo();
                System.out.println("Que numero de asiento deseas?");
                var seatNumber = scanner.nextInt();
                scanner.nextLine();

                passenger.setSeatNumber(seatNumber);
                var seat = passenger.getSeatNumber();
                scanner.nextLine();

                System.out.println(seat);
            }
        }
    }
}
