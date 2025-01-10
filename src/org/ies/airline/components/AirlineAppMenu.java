package org.ies.airline.components;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;

import java.util.Scanner;

public class AirlineAppMenu {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineAppMenu(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }
    public void run() {
        var airline = airlineReader.read();
        int option;
        do {
            option = getOption();
            if (option == 1) {
                showFlights(airline);
            } else if (option == 2) {
                showFlightsFromOrigin(airline);
            } else if (option == 3) {
                showPassengersFlight(airline);
            } else if (option == 4) {
                System.out.println("EScribe el numero de vuelo");
                int flightNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Escribe le NIF");
                String nif = scanner.nextLine();

                airline.getPassengerSeat(flightNumber, nif);

            }

        } while (option != 6);
    }

    private void showPassengersFlight(Airline airline) {
        System.out.println("dime el NIF");
        String nif = scanner.nextLine();
        airline.showPassengerFlights(nif);
    }

    private void showFlightsFromOrigin(Airline airline) {
        System.out.println("Escribe el origen");
        String origin = scanner.nextLine();

        airline.showFlightsFromOrigin(origin);
    }

    private int getOption() {
        int option;
        System.out.println("Elija una opcion");
        System.out.println("1.Mostrar todos los vuelos:");
        System.out.println("2.Mostrar vuelos con origen:");
        System.out.println("3.Mostrar vuelos de pasajero:");
        System.out.println("4.Mostar asiento de pasajero:");
        System.out.println("5.Cambiar asiento de pasajero:");
        System.out.println("6.Salir");

        option = scanner.nextInt();
        return option;
    }
    private void showFlights(Airline airline) {
        airline.showInfo();
    }


}
