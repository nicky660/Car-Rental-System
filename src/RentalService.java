import java.util.*;

public class RentalService {
    private List<Car> carList = new ArrayList<>();
    private Map<Integer, Integer> rentedCars = new HashMap<>();
    // Key = Customer ID, Value = Car ID

    public void addCar(Car car) {
        carList.add(car);
    }

    public void showAvailableCars() {
        System.out.println("\n----- Available Cars -----");
        boolean found = false;
        for (Car car : carList) {
            if (car.isAvailable()) {
                car.showDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No cars available!");
    }

    public void rentCar(Customer customer, int carId, int days) {
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                if (car.isAvailable()) {
                    car.setAvailable(false);
                    rentedCars.put(customer.getCustomerId(), carId);

                    double bill = days * car.getRentPerDay();

                    System.out.println("\nCar rented successfully!");
                    System.out.println("Customer: " + customer.getName());
                    System.out.println("Car: " + car.getBrand() + " " + car.getModel());
                    System.out.println("Total Rent Amount = ₹" + bill);
                } else {
                    System.out.println("Car is not available right now!");
                }
                return;
            }
        }
        System.out.println("Invalid Car ID!");
    }

    public void returnCar(Customer customer) {
        if (!rentedCars.containsKey(customer.getCustomerId())) {
            System.out.println("You have not rented any car.");
            return;
        }

        int carId = rentedCars.get(customer.getCustomerId());
        for (Car car : carList) {
            if (car.getCarId() == carId) {
                car.setAvailable(true);
                rentedCars.remove(customer.getCustomerId());
                System.out.println("Car returned successfully!");
                return;
            }
        }
    }
}
