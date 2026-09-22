public class Car {
    private int carId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean available;

    public Car(int carId, String brand, String model, double rentPerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    public int getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void showDetails() {
        System.out.println("Car ID: " + carId +
                " | " + brand + " " + model +
                " | Rent/day: ₹" + rentPerDay +
                " | Available: " + (available ? "Yes" : "No"));
    }
}

