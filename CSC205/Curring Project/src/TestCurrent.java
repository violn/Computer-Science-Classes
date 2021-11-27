public class TestCurrent {
    public static void main(String[] args) {
        testInOrder();
        testOutOfOrder();
    }

    public static void testInOrder() {
        CreateCar car = new CreateCar();
        car.
        createFrame().
        attachDoors().
        galvanizeFrame().
        dustOff().
        sprawyPaint().
        applyVarnish().
        handWax().
        fashionEngine().
        lowerToPowerTrain().
        installWheels().
        installDashboard().
        installSteeringWheel().
        installTrunk().
        release();
    }

    public static void testOutOfOrder() {
        CreateCar car = new CreateCar();
        car.
        createFrame().
        attachDoors().
        galvanizeFrame().
        dustOff().
        sprawyPaint().
        applyVarnish().
        handWax().
        fashionEngine().
        lowerToPowerTrain().
        installDashboard().
        installSteeringWheel().
        installTrunk().
        release();
    }
}
