import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Property {
	private int baseValue;
	private boolean inCity;
	private int age;
	private int builtUpArea;
	private double propertyTax;
	// Constructor
	public Property(int baseValue, boolean inCity, int age, int builtUpArea,
			double propertyTax) {
		this.baseValue = baseValue;
		this.inCity = inCity;
		this.age = age;
		this.builtUpArea = builtUpArea;
		this.propertyTax = propertyTax;
	}
	// Getter methods
	public int getBaseValue() {
		return baseValue;
	}
	public boolean isInCity() {
		return inCity;
	}
	public int getAge() {
		return age;
	}
	public int getBuiltUpArea() {
		return builtUpArea;
	}
	public double getPropertyTax() {
		return propertyTax;
	}
}
class Vehicle {
	private String registrationNumber;
	private String brand;
	private int purchaseCost;
	private int maximumVelocity;
	private int capacity;
	private String type;
	private double vehicleTax;
	// Constructor
	public Vehicle(String registrationNumber, String brand, int purchaseCost,
			int maximumVelocity, int capacity, String type, double vehicleTax) {
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.purchaseCost = purchaseCost;
		this.maximumVelocity = maximumVelocity;
		this.capacity = capacity;
		this.type = type;
		this.vehicleTax = vehicleTax;
	}
	// Getter methods
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getBrand() {
		return brand;
	}
	public int getPurchaseCost() {
		return purchaseCost;
	}
	public int getMaximumVelocity() {
		return maximumVelocity;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getType() {
		return type;
	}
	public double getVehicleTax() {
		return vehicleTax;
	}
}
public class TaxCalculator {
	private static final Scanner scanner = new Scanner(System.in);
	private static String username;
	private static String password;



	private static ArrayList<Property> properties = new ArrayList<>();
	private static ArrayList<Vehicle> vehicles = new ArrayList<>();
	public static void main(String[] args) {

		displayWelcomeScreen();
		inputUsernameAndPassword();
		displayMainMenu();
	}
	private static void displayWelcomeScreen() {
		System.out.println("Welcome to the Property and Vehicle Tax Calculator");
				System.out.println("Developed by Sachin");
				System.out.println("-------------------------------------------------");
	}

	private static void inputUsernameAndPassword() {
		System.out.print("Enter your username: ");
		username = scanner.nextLine();
		System.out.print("Enter your password: ");
		password = scanner.nextLine();
	}
	private static void calculatePropertyTax() {
		// Get property details from the user
		System.out.println("Enter the property details:");
		System.out.print("Base value of land: ");
		int baseValue = validatePositiveIntegerInput();
		System.out.print("Is the property in the city? (Y/N): ");
		boolean isInCity = validateYesOrNoInput();
		System.out.print("Age of construction: ");
		int age = validatePositiveIntegerInput();
		System.out.print("Built-up area: ");
		int builtUpArea = validatePositiveIntegerInput();
		// Calculate property tax
		double propertyTax = 0;
		if (isInCity) {
			propertyTax = (builtUpArea * age * baseValue) + (0.5 *
					builtUpArea);
		} else {
			propertyTax = builtUpArea * age * baseValue;
		}
		// Display property tax
		System.out.println("Property tax: " + String.format("%.2f",
				propertyTax));
		// Store property details for further operations
		Property property = new Property(baseValue, isInCity, age,
				builtUpArea, propertyTax);
		properties.add(property);
		// Save property details to temporary storage if the user chooses yes
		System.out.print("Do you want to save the property details to file? (Y/N): ");
					boolean savePropertyDetails = validateYesOrNoInput();
				if (savePropertyDetails) {
					savePropertyDetailsToFile(property);
				}
	}
	private static void calculateVehicleTax() {
		// Get vehicle details from the user
		System.out.println("Enter the vehicle details:");
		System.out.print("Registration number (4 digits): ");
		String registrationNumber = validateRegistrationNumber();
		System.out.print("Brand: ");
		String brand = scanner.next();
		System.out.print("Purchase cost (between 50000 and 1000000): ");
		int purchaseCost = validatePurchaseCost();
		System.out.print("Maximum velocity (between 120 and 300 kmph): ");
		int maximumVelocity = validateMaximumVelocity();
		System.out.print("Capacity (number of seats between 2 and 50): ");
		int capacity = validateCapacity();
		System.out.print("Type of vehicle (1 - Petrol, 2 - Diesel, 3 -CNG/LPG): ");
					String vehicleType = validateVehicleType();
		// Calculate vehicle tax
		double vehicleTax = 0;
		switch (vehicleType) {
		case "1":
			vehicleTax = maximumVelocity + capacity + (0.1 *
					purchaseCost);
			break;
		case "2":
			vehicleTax = maximumVelocity + capacity + (0.11 *
					purchaseCost);
			break;
		case "3":
			vehicleTax = maximumVelocity + capacity + (0.12 *
					purchaseCost);
			break;
		default:
			System.out.println("Invalid vehicle type!");
			return;
		}
		// Display vehicle tax
		System.out.println("Vehicle tax: " + String.format("%.2f",vehicleTax));
		// Store vehicle details for further operations
		Vehicle vehicle = new Vehicle(registrationNumber, brand,
				purchaseCost, maximumVelocity, capacity, vehicleType, vehicleTax);
		vehicles.add(vehicle);
		// Save vehicle details to temporary storage if the user chooses yes
		System.out.print("Do you want to save the vehicle details to file? (Y/N): ");
					boolean saveVehicleDetails = validateYesOrNoInput();
				if (saveVehicleDetails) {
					saveVehicleDetailsToFile(vehicle);
				}
	}
	private static void viewTaxSummary() {
		// Calculate total property tax and total vehicle tax
		double totalPropertyTax = 0;
		double totalVehicleTax = 0;
		for (Property property : properties) {
			totalPropertyTax += property.getPropertyTax();
		}
		for (Vehicle vehicle : vehicles) {
			totalVehicleTax += vehicle.getVehicleTax();
		}
		// Calculate total tax payable
		double totalTaxPayable = totalPropertyTax + totalVehicleTax;
		// Display tax summary
		System.out.println("Tax Summary");
		System.out.println("--------------------------------------------------");
				System.out.println("Total number of properties: " +
						properties.size());
				System.out.println("Total property tax: " + String.format("%.2f",
						totalPropertyTax));
				System.out.println("Total number of vehicles: " + vehicles.size());
				System.out.println("Total vehicle tax: " + String.format("%.2f",
						totalVehicleTax));
				System.out.println("Total tax payable: " + String.format("%.2f",
						totalTaxPayable));
				System.out.println("--------------------------------------------------");
						// Display stored properties
						System.out.println("Stored Properties:");
						for (Property property : properties) {
							System.out.println("Base Value: " + property.getBaseValue() +
									", In City: " + property.isInCity() +
									", Age: " + property.getAge() +
									", Built-up Area: " + property.getBuiltUpArea() +
									", Property Tax: " + property.getPropertyTax());
						}
						// Display stored vehicles
						System.out.println("\nStored Vehicles:");
						for (Vehicle vehicle : vehicles) {
							System.out.println("Registration Number: " +
									vehicle.getRegistrationNumber() +
									", Brand: " + vehicle.getBrand() +
									", Purchase Cost: " + vehicle.getPurchaseCost() +
									", Maximum Velocity: " + vehicle.getMaximumVelocity() +
									", Capacity: " + vehicle.getCapacity() +
									", Type: " + vehicle.getType() +
									", Vehicle Tax: " + vehicle.getVehicleTax());
						}
						// Display an option to navigate back to the main context
						System.out.print("Press 0 to return to the main menu: ");
						int option = scanner.nextInt();
						if (option == 0) {
							displayMainMenu();
						}
	}
	private static void savePropertyDetailsToFile(Property property) {
		try {
			// Create a new file writer object
			FileWriter fileWriter = new FileWriter("property_details.csv",
					true); // Append mode
			// Write the property details to the file
			fileWriter.write("Property," + property.getBaseValue() + "," +
					property.isInCity() + "," + property.getAge() + "," +
					property.getBuiltUpArea() + "," + property.getPropertyTax());
			fileWriter.write("\n");
			// Close the file writer
			fileWriter.close();
			// Display a success message to the user
			System.out.println("Property details saved successfully!");
		} catch (IOException e) {
			// Handle the exception
			System.err.println("Error saving property details to file: " +
					e.getMessage());
		}
	}
	private static void saveVehicleDetailsToFile(Vehicle vehicle) {
		try {
			// Create a new file writer object
			FileWriter fileWriter = new FileWriter("vehicle_details.csv",
					true); // Append mode
			// Write the vehicle details to the file
			fileWriter.write("Vehicle," + vehicle.getRegistrationNumber() +
					"," + vehicle.getBrand() + "," + vehicle.getPurchaseCost() + "," +
					vehicle.getMaximumVelocity() + "," + vehicle.getCapacity() + "," +
					vehicle.getType() + "," + vehicle.getVehicleTax());
			fileWriter.write("\n");
			// Close the file writer
			fileWriter.close();
			// Display a success message to the user
			System.out.println("Vehicle details saved successfully!");
		} catch (IOException e) {
			// Handle the exception
			System.err.println("Error saving vehicle details to file: " +
					e.getMessage());
		}
	}

	private static int validatePositiveIntegerInput() {
		int input = 0;
		while (true) {
			try {
				input = Integer.parseInt(scanner.next());
				if (input > 0) {
					return input;
				} else {
					System.out.println("Please enter a positive integer.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a positive integer.");
			}
		}
	}
	private static boolean validateYesOrNoInput() {
		while (true) {
			String input = scanner.next().toLowerCase();
			if (input.equals("y") || input.equals("n")) {
				return input.equals("y");
			} else {
				System.out.println("Invalid input. Please enter Y or N.");
			}
		}
	}
	private static String validateRegistrationNumber() {
		while (true) {
			String input = scanner.next();
			if (input.matches("\\d{4}")) {
				return input;
			} else {
				System.out.println("Invalid registration number. Please enter a 4-digit numeric value.");
			}
		}
	}
	private static int validatePurchaseCost() {
		int input = 0;
		while (true) {
			try {
				input = Integer.parseInt(scanner.next());
				if (input >= 50000 && input <= 1000000) {
					return input;
				} else {
					System.out.println("Please enter a purchase cost between 50000 and 1000000.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid purchase cost.");
			}
		}
	}
	private static int validateMaximumVelocity() {
		int input = 0;
		while (true) {
			try {
				input = Integer.parseInt(scanner.next());
				if (input >= 120 && input <= 300) {
					return input;
				} else {
					System.out.println("Please enter a maximum velocity between 120 and 300 kmph.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid maximum velocity.");
			}
		}
	}
	private static int validateCapacity() {
		int input = 0;
		while (true) {
			try {
				input = Integer.parseInt(scanner.next());
				if (input >= 2 && input <= 50) {
					return input;
				} else {
					System.out.println("Please enter a capacity between 2 and 50.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid capacity.\n");
						
			}
		}
	}
	private static String validateVehicleType() {
		while (true) {
			String input = scanner.next();
			if (input.equals("1") || input.equals("2") || input.equals("3"))
			{
				return input;
			} else {
				System.out.println("Invalid vehicle type. Please enter 1 for Petrol, 2 for Diesel, or 3 for CNG/LPG.");
			}
		}
	}
	private static void displayMainMenu() {
		while (true) {
			System.out.println("\nMain Menu");
			System.out.println("1. Calculate Property Tax");
			System.out.println("2. Calculate Vehicle Tax");
			System.out.println("3. View Tax Summary");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				calculatePropertyTax();
				break;
			case 2:
				calculateVehicleTax();
				break;
			case 3:
				viewTaxSummary();
				break;
			case 4:
				System.out.println("Exiting the program. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option (1-4).");
						break;
			}
		}
	}
}
