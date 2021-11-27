public class CreateCar {
    Process current = Process.START;

    public CreateCar createFrame() {
        if (current == Process.START) {
            current = Process.CREATE_FRAME;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.CREATE_FRAME + " but received task: " + current);
        }
        return this;
    }

    public CreateCar attachDoors() {
        if (current == Process.CREATE_FRAME) {
            current = Process.ATTACH_DOORS;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.ATTACH_DOORS + " but received task: " + current);
        }
        return this;
    }

    public CreateCar galvanizeFrame() {
        if (current == Process.ATTACH_DOORS) {
            current = Process.GALVANIZE_FRAME;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.GALVANIZE_FRAME + " but received task: " + current);
        }
        return this;
    }

    public CreateCar dustOff() {
        if (current == Process.GALVANIZE_FRAME) {
            current = Process.DUST_OFF;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.DUST_OFF + " but received task: " + current);
        }
        return this;
    }

    public CreateCar sprawyPaint() {
        if (current == Process.DUST_OFF) {
            current = Process.SPRAY_PAINT;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.SPRAY_PAINT + " but received task: " + current);
        }
        return this;
    }

    public CreateCar applyVarnish() {
        if (current == Process.SPRAY_PAINT) {
            current = Process.APPLY_VARNISH;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.APPLY_VARNISH + " but received task: " + current);
        }
        return this;
    }

    public CreateCar handWax() {
        if (current == Process.APPLY_VARNISH) {
            current = Process.HAND_WAX;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.HAND_WAX + " but received task: " + current);
        }
        return this;
    }

    public CreateCar fashionEngine() {
        if (current == Process.HAND_WAX) {
            current = Process.FASHION_ENGINE;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.FASHION_ENGINE + " but received task: " + current);
        }
        return this;
    }

    public CreateCar lowerToPowerTrain() {
        if (current == Process.FASHION_ENGINE) {
            current = Process.LOWER_TO_POWER_TRAIN;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println("Task out of order. Expected task: " + Process.LOWER_TO_POWER_TRAIN
                    + " but received task: " + current);
        }
        return this;
    }

    public CreateCar installWheels() {
        if (current == Process.LOWER_TO_POWER_TRAIN) {
            current = Process.INSTALL_WHEELS;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.INSTALL_WHEELS + " but received task: " + current);
        }
        return this;
    }

    public CreateCar installDashboard() {
        if (current == Process.INSTALL_WHEELS) {
            current = Process.INSTALL_DASHBOARD;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println("Task out of order. Expected task: " + Process.INSTALL_DASHBOARD + " but received task: "
                    + current);
        }
        return this;
    }

    public CreateCar installSteeringWheel() {
        if (current == Process.INSTALL_DASHBOARD) {
            current = Process.INSTALL_STEERING_WHEEL;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println("Task out of order. Expected task: " + Process.INSTALL_STEERING_WHEEL
                    + " but received task: " + current);
        }
        return this;
    }

    public CreateCar installTrunk() {
        if (current == Process.INSTALL_STEERING_WHEEL) {
            current = Process.INSTALL_TRUNK;
            System.out.println("Task done successrfully: " + current);
        } else {
            System.out.println(
                    "Task out of order. Expected task: " + Process.INSTALL_TRUNK + " but received task: " + current);
        }
        return this;
    }

    public CreateCar release() {
        if (current == Process.INSTALL_TRUNK) {
            current = Process.RELEASE;
            System.out.println("Car released to the public successfully.\n");
        } else {
            System.out
                    .println("Task out of order. Expected task: " + Process.RELEASE + " but received task: " + current);
        }
        return this;
    }
}
