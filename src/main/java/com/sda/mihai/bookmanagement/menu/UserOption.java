package com.sda.mihai.bookmanagement.menu;


public enum UserOption {
    CREATE_AUTHOR(1, "Create author"),
    SHOW_ALL_AUTHORS(2, "Display all authors"),
    UPDATE_AUTHOR(3, "Update author"),
    DELETE_AUTHOR(4, "Delete author"),
    CREATE_BOOK(5, "Create book"),
    DELETE_BOOK(6, "Delete book"),
    UPDATE_BOOK(7, "Update book"),
    VIEW_ALL_BOOKS(8, "Display all books"),
    CREATE_REVIEW(9, "Write a review"),
    GET_REVIEW_BY_TITLE(10, "View all the reviews for a title"),
    EXIT(99, "Exit"),
    UNKNOWN(100, "Unknown option");


    private int numericOption;
    private String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static void printAllOptions() {
        for (UserOption value : values()) {
            if (value != UNKNOWN) {
                System.out.println(value.getNumericOption() + " - " + value.getDisplayValue());
            }
        }
    }

    public static UserOption findUserOption(int numericValue) {
        for (UserOption value : values()) {
            if (value.getNumericOption() == numericValue) {
                return value;
            }
        }
        return UNKNOWN;
    }
}