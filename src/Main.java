import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RentalService service = new RentalService();

        // Preloaded Cars
        service.addCar(new Car(1, "Toyota", "Fortuner", 2500));
        service.addCar(new Car(2, "Honda", "City", 1500));
        service.addCar(new Car(3, "Mahindra", "Thar", 3000));
        service.addCar(new Car(4, "Tata", "Nexon", 1800));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        Customer customer = new Customer(id, name);

        while (true) {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return Car");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.showAvailableCars();
                    break;

                case 2:
                    System.out.print("Enter Car ID: ");
                    int carId = sc.nextInt();
                    System.out.print("Enter No. of Days: ");
                    int days = sc.nextInt();
                    service.rentCar(customer, carId, days);
                    break;

                case 3:
                    service.returnCar(customer);
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
