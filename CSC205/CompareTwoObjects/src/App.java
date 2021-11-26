import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        testPrimitiveDataTypeCompare();
        testObjectDataTypeCompare();
        testObjectDataTypeCompareUsingHash();
        testObjectDataTypeCompareUsingComparable();
    }

    public static void testPrimitiveDataTypeCompare() {
        long a = 20;
        int b = 10;
        if (a > b) {
            System.out.println("a is greater than b");
        } else {
            System.out.println("a is less than b");
        }
    }

    public static void testObjectDataTypeCompare() {
        var car1 = new Car("GM", 6778678.00D);
        var car2 = new Car("GM", 898990.00D);

        // README: if you uncomment the code below and see that you cannot do what the
        // code is trying to do
        // So the questions is how you want to compare two objects. This concept is very
        // important
        // if( car1 > car2){
        // System.out.println("car1 is greater than car2");
        // }
        // else{
        // System.out.println("car1 is less than car2");
        // }
    }

    public static void testObjectDataTypeCompareUsingHash() {
        var car1 = new CarHash("GM", 6778678.00D);
        var car2 = new CarHash("Xenon", 898990.00D);

        if (car1.equals(car2)) {
            System.out.println("car1 is equal than car2");
        } else {
            System.out.println("car1 is not equal than car2");
        }

        // this is still as issue
        // if(car1>car2)){
        // System.out.println("car1 is equal than car2");
        // }
        // else{
        // System.out.println("car1 is not equal than car2");
        // }
    }

    public static void testObjectDataTypeCompareUsingComparable() {
        var car1 = new CarEnhanced("GM", 6778678.00D);
        var car2 = new CarEnhanced("Xenon", 898990.00D);

        var car3 = new CarEnhanced("Toyota", 112345.00D);
        var car4 = new CarEnhanced("AlphaRomeo", 334323.00D);

        var carList = new ArrayList<CarEnhanced>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        if (car1.equals(car2)) {
            System.out.println("car1 is equal than car2");
        } else {
            System.out.println("car1 is not equal than car2");
        }

        System.out.println("Un-Sorted List of Cars");
        for (CarEnhanced carEnhanced : carList) {
            System.out.println(carEnhanced);
        }
        Collections.sort(carList);
        System.out.println("-------------------------");
        System.out.println("Sorted List of Cars");
        for (CarEnhanced carEnhanced : carList) {
            System.out.println(carEnhanced);
        }
    }
}
