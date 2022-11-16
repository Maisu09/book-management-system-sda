package com.sda.mihai.bookmanagement;

import com.sda.mihai.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();

        Scanner scanner = new Scanner(System.in);
        UserOption.printAllOptions();


        UserOption userOption;

        do {
            UserOption.printAllOptions();

            System.out.println("Please select an option: ");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);

            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    System.out.println("Not implemented");
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown");
                    break;
                default:
                    System.out.println("User option " + userOption + "is not implemented");
                    break;
            }

        } while(userOption != UserOption.EXIT);


        SessionManager.shutDown();
    }
}
