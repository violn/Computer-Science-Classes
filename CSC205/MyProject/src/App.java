public class App {
    public static void main(String[] args) throws Exception {

        testOptionalParameterFunctions();

    }

    private static void testOptionalParameterFunctions() {
        var math = new Math();
        System.out.println(math.sum(5000));

        System.out.println(math.sum(5000, 1, 2, 3, 4, 5, 6, 7));

        System.out.println(math.sum(250, 6, 3, 89, 907, 328));

        System.out.println(math.sum(3));
        // how does this work
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
