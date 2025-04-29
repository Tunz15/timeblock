package com.backend.timeblock.model;

// This is an enum class that defines the priority levels for events
// It is used to categorize events based on their importance or urgency
public enum Priority {
    PRIMARY(1,"High-priority, critical tasks"),
    SECONDARY(2,"Medium-priority, important but not urgent"),
    BRAINDUMP(3,"Low-priority, ideas or backlog items");

    private final int value;
    private final String description;

    // Constructor to set the value of the enum constant
    Priority(int value, String description) {
        this.value = value;
        this.description = description;
    }

    // Getter method to retrieve the value of the enum constant
    // This method is optional, but it can be useful for getting the value associated with the enum constant
    public int getValue() {
        return value;
    }
    public String getDescription(){
        return description;
    }

    // Static method to retrieve the enum constant based on its value
    // This method is optional, but it can be useful for converting from an integer value to the enum constant
    public static Priority fromValue(int value) {
        for (Priority priority : Priority.values()) {
            if (priority.getValue() == value) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid priority value: " + value);
    }
    // Static method to retrieve the enum constant based on its name
    // This method is optional, but it can be useful for converting from a string name to the enum constant
    public static Priority fromString(String name) {
        for (Priority priority : Priority.values()) {
            if (priority.name().equalsIgnoreCase(name)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid priority name: " + name);
    } 
}