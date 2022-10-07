package org.example.controller;

import org.example.entities.Client;
import org.example.service.ClientService;
import org.example.service.ClientServiceImpl;
import java.time.LocalDate;
import java.util.Scanner;

public class Controller {
    private final ClientService service = new ClientServiceImpl();

    public void startController(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean isRunning = true;
            while (isRunning) {
                showMenu();
                String selected = scanner.nextLine();
                switch (selected) {
                    case "1" -> {
                        service.showAllClients().forEach(System.out::println);
                    }
                    case "2" -> {
                        Client client = createNewClientByTypingValues(scanner);
                        System.out.println("New client in DB created!" + service.createClient(client));
                    }
                    case "3" -> {
                        System.out.println("Enter id:");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println(service.readClient(id));
                    }
                    case "4" -> {
                        System.out.println("Enter id:");
                        int id = Integer.parseInt(scanner.nextLine());
                        Client client = createNewClientByTypingValues(scanner);
                        System.out.println("UPDATED " +  service.updateClient(id, client));;
                    }
                    case "5" -> {
                        System.out.println("Enter id:");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("DELETED - "+service.deleteClient(id));
                    }
                    default -> isRunning = false;
                }
            }
        }
    }

    private Client createNewClientByTypingValues(Scanner scanner) {
        System.out.println("Enter: Name, Year, Month, Day");
        String name = scanner.nextLine();
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        return new Client(name,
                LocalDate.of(year, month, day));
    }

    private void showMenu(){
        System.out.println();
        System.out.println("1 - Show all DB");
        System.out.println("---------------------");
        System.out.println("2 - Create row in DB");
        System.out.println("3 - Read row by id");
        System.out.println("4 - Update row by id");
        System.out.println("5 - Delete row by id");
        System.out.println("---------------------");
        System.out.println("6+ - EXIT");
        System.out.println("Enter number below:");
    }
}
