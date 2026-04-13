class Car {
    void move() {
        System.out.println("Car is moving");
    }
}

class ElectricCar extends Car {
    void move() {
        System.out.println("Electric car is moving silently");
    }
}

class PetrolCar extends Car {
    void move() {
        System.out.println("Petrol car is moving with engine sound");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c1 = new ElectricCar();
        Car c2 = new PetrolCar();

        c1.move();
        c2.move();
    }
}
