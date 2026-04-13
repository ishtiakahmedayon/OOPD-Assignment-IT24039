interface Vehicle {
    void start();
    void stop();
}

abstract class Car implements Vehicle {
    String brand;

    Car(String brand) {
        this.brand = brand;
    }

    abstract void fuelType();

    public void start() {
        System.out.println(brand + " is starting");
    }
}

class ElectricCar extends Car {
    ElectricCar(String brand) {
        super(brand);
    }

    void fuelType() {
        System.out.println("Electric");
    }

    public void stop() {
        System.out.println(brand + " is stopping");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricCar c1 = new ElectricCar("Tesla");
        c1.start();
        c1.fuelType();
        c1.stop();
    }
}
