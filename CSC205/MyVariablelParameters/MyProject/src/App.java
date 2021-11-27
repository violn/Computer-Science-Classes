public class App {
    public static void main(String[] args) throws Exception {

        testOverLoadedFunctions();
        // testCurring();
        // testCurringFail();

    }

    // private static void testCurring() {
    // var schedule = new WeeklySchedule();
    // schedule.wakeUp()
    // .haveBreakFast()
    // .goAndPlay()
    // .gotoWork()
    // .goToSchool()
    // .goToSleep();
    // }
    // private static void testCurringFail() {
    // var schedule = new WeeklySchedule();
    // schedule.wakeUp()
    // .haveBreakFast()
    // .goToSchool()
    // .goToSleep()
    // .goAndPlay()
    // .gotoWork();
    // }

    private static void testOverLoadedFunctions() {
        var math = new Math();
        System.out.println(math.sum(10, 20));
        System.out.println(math.sum(10, 20, 30));
        System.out.println(math.sum(10.5, 20.5));

        System.out.println(math.sum(100));
        // how does this work

        System.out.println(math.sum(100, 200, 300, 400, 500, 600, 700));
        // how does this work

        System.out.println(math.sum(13.3, 26.55, 27.65, 59.69, 420.52));
    }

}

// Overloading in Java
// Overloading allows different methods to have the same name, but different
// signatures where the signature can differ by the number of input parameters
// or type of input parameters or both. Overloading is related to compile-time
// (or static) polymorphism.

// Attention reader! Don’t stop learning now. Get hold of all the important Java
// Foundation and Collections concepts with the Fundamentals of Java and Java
// Collections Course at a student-friendly price and become industry ready. To
// complete your preparation from learning a language to DS Algo and many more,
// please refer Complete Interview Preparation Course.

// Java program to demonstrate working of method
// overloading in Java.
