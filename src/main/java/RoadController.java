import java.util.Scanner;

public class RoadController {
    private static int passengersCarMaxWeight = 3500;
    private static int passengersCarMaxHeight = 2000;
    private static int controllerMaxHeight = 4000;
    private static  int passengerCarPrice = 1000;
    private static int cargoCarPrice = 2000;
    private static int vehicleAdditionPrice = 3000;

    public static void main(String[] args) {
        System.out.println("How cars much generated");
        int carsCount = new Scanner(System.in).nextInt();
        for (int i = 0; i < carsCount; i++) {
            Car car = Camera.getNextCar();
            System.out.println(car);

            int priceCurrentCar = calculatePrise(car);
            if(priceCurrentCar == -1){
                System.out.println("this parameters TC don't get it !");
                continue;
            }
            System.out.println("Price this TC equals" + priceCurrentCar + "Rub");

        }
    }
    public static int calculatePrise(Car car) {
        int prise = -1;
        if (car.getHeight() >= controllerMaxHeight) {
            return prise;
        } else if (car.getWeight() > passengersCarMaxWeight && car.getWeight() <= passengersCarMaxWeight) {
            prise = cargoCarPrice;
            if (car.isHasVehicle()) {
                prise += vehicleAdditionPrice;
            } else if (car.getHeight() >= 600 && car.getWeight() <= passengersCarMaxWeight) {
                prise += passengerCarPrice;
                if (car.isHasVehicle()) {
                    prise += vehicleAdditionPrice;
                }

            }

        }
        return prise;
    }
}
