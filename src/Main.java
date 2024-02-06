import java.util.ArrayList;
import java.util.List;

class City {
    private String name;
    private List<Building> buildings;

    public City() {
        buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    // Method to search for a building by street name and house number
    public Building findBuilding(String streetName, String houseNumber) {
        for (Building building : buildings) {
            if (building.getStreetName().equals(streetName) && building.getHouseNumber().equals(houseNumber)) {
                return building;
            }
        }
        return null; // If no matching building found
    }
}

class Building {
    private String streetName;
    private String houseNumber;
    private double basicMonthlyPaymentPerSqM;
    private List<Room> rooms;

    public Building() {
        rooms = new ArrayList<>();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public double getBasicMonthlyPaymentPerSqM() {
        return basicMonthlyPaymentPerSqM;
    }

    public void setBasicMonthlyPaymentPerSqM(double basicMonthlyPaymentPerSqM) {
        this.basicMonthlyPaymentPerSqM = basicMonthlyPaymentPerSqM;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // Method to calculate total area of all rooms in the building
    public double getTotalArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
}

class Room {
    private String number;
    private double area;
    private Building building; // Reference to the building the room belongs to

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a city object
        City city = new City();
        city.setName("Astana");

        // Create two buildings
        Building building1 = new Building();
        building1.setStreetName("Kabanbay  Avenue");
        building1.setHouseNumber("123");
        building1.setBasicMonthlyPaymentPerSqM(100);

        Building building2 = new Building();
        building2.setStreetName("Turar Ryskulov Avenue");
        building2.setHouseNumber("456");
        building2.setBasicMonthlyPaymentPerSqM(120);

        // Create three rooms
        Room room1 = new Room();
        room1.setNumber("101");
        room1.setArea(50);
        room1.setBuilding(building1);

        Room room2 = new Room();
        room2.setNumber("102");
        room2.setArea(40);
        room2.setBuilding(building1);

        Room room3 = new Room();
        room3.setNumber("201");
        room3.setArea(60);
        room3.setBuilding(building2);

        // Add rooms to buildings
        building1.addRoom(room1);
        building1.addRoom(room2);
        building2.addRoom(room3);

        // Add buildings to the city
        city.addBuilding(building1);
        city.addBuilding(building2);

        // Display information about the first building and its rooms
        System.out.println("Information about the first building:");
        System.out.println("Street: " + building1.getStreetName());
        System.out.println("House Number: " + building1.getHouseNumber());
        System.out.println("Basic monthly payment per sq.m.: " + building1.getBasicMonthlyPaymentPerSqM());
        System.out.println("Total area of the building: " + building1.getTotalArea() + " sq.m.");

        System.out.println("\nRooms in the first building:");
        for (Room room : building1.getRooms()) {
            System.out.println("Room " + room.getNumber() + ", area: " + room.getArea() + " sq.m.");
        }

        // Search for a building by street name and house number
        Building foundBuilding = city.findBuilding("Nur-Sultan Avenue", "123");
        if (foundBuilding != null) {
            System.out.println("\nFound building:");
            System.out.println("Street: " + foundBuilding.getStreetName());
            System.out.println("House Number: " + foundBuilding.getHouseNumber());
            System.out.println("Basic monthly payment per sq.m.: " + foundBuilding.getBasicMonthlyPaymentPerSqM());
            System.out.println("Total area of the building: " + foundBuilding.getTotalArea() + " sq.m.");
        } else {
            System.out.println("\nBuilding not found.");
        }
    }
}
