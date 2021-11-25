public class DataTypes
{
    public static void ex21()
    {
        // The difference between the literal 4, 4.0, '4', "4" is
        // 4 is any data type that holds whole numbers such as int, long, double, short,
        // and byte
        // 4.0 is a double as in order for it to be a float it needs to have an f after
        // 4.0 (ie. 4.0f)
        // '4' is a char as it has single quotes
        // "4" is a string as it has double quotes
    }

    public static void ex22()
    {
        // For this we are calling the System class and then telling it to
        // Create a print stream for out put to the console
        // And with that print stream we use the println method
        // To print I gotta be me! and then a new line
        System.out.println("I gotta be me!");
    }

    public static void ex23()
    {
        // The output of this message is Here we go!12345
        // Test this if you're not sure.Another.
        // All done.
        //
        System.out.print("Here we go!");
        System.out.println("12345");
        System.out.print("Test this if you're not sure.");
        System.out.print("Another.");
        System.out.println();
        System.out.println("All done.");
    }

    public static void ex24()
    {
        // Print statements can't be separated by new line unless there's a plus to
        // combine them
        System.out.print("To be or not to be, that" + "is the question.");

        // And because of how the original code was written there is no space between
        // that and is
    }

    public static void ex25()
    {
        // The output of this is 50 plus 25 is 5025 because the way this is setup would
        // cause the first string to
        // Concact with 25 and then because 25 is now apart of the string 50 will then
        // be concacted
        // If the output of 50 plus 25 is needed then there should be a parenthesis
        // isolating the operation
        System.out.print("50 plus 25 is " + 50 + 25);
    }

    public static void ex26()
    {
        // Ok what this supposed to do is create a new line at /r and /n
        // But for whatever reason it doesn't do that in VS Code
        // It still works in Eclipse (Look for the provided Eclipse Screenshot)
        System.out.println(
                "The class of 2021. Welcome \nand enjoy the course \read the output. It is something that \reacts to what you wanted to do.");
    }

    public static void ex27()
    {
        // We initialize a variable called size with a value of 18
        // Although it doesn't specify what the data type is
        var size = 18;
        size += 12;
        // Size is now 30
        size *= 2;
        // Size is now 60
        size /= 4;
        // Size is now 15

        System.out.print(size);
    }

    public static void ex28()
    {
        // We initialize a double called depth with a value of 2.4
        // It has to be a double as the only other variable that has decimal points is
        // float
        // But float is denoted with a f after the number
        double depth = 2.4;
        // Depth is now 10.4
        depth = 20 - depth * 4;
        // Depth is now 2.08
        depth /= 5;

        System.out.print(depth);
    }

    public static void ex29()
    {
        int iResult = 0;
        int num1 = 1, num2 = 2, num3 = 3, num4 = 4;
        double fResult = 0, val1 = 1.0, val2 = 2.0;

        //I expect 0 as ints will always round down when dealing with fractions
        iResult = num1 / num4;
        System.out.println(iResult);
        //The answer I got was 0

        //I expect 0 as ints still round down after the operation then results are passed to fResults
        fResult = num1 / num4;
        System.out.println(fResult);
        //I got 0

        //I expect 0
        iResult = num3 / num4;
        System.out.println(iResult);
        //The answer I got was 0

        //I expect 0
        fResult = num3 / num4;
        System.out.println(fResult);
        //I got 0

        //I expect .25 as the double converts the whole operation to a double
        fResult = val1 / num4;
        System.out.println(fResult);
        //I got .25

        //I expect .5 as the doubles divide normally
        fResult = val1 / val2; 
        System.out.println(fResult);
        //I got .5

        //I expect 0
        iResult = num1 / num2;
        System.out.println(iResult);
        //I got 0

        //I expect .5 as num1 now has the value of 1.0 due to  being casted into a double
        fResult = (double) num1 / num2;
        System.out.println(fResult);
        //I got .5

        //I expect .5 as num2 was casted to a double
        fResult = num1 / (double) num2;
        System.out.println(fResult);
        //I got .5

        //I expect 0 as the operation still rounds down and then is converted to a double
        fResult = (double) (num1 / num2);
        System.out.println(fResult);
        //I got 0

        //I expect 0 as the double is rounded down after being converted to an int
        iResult = (int) (val1 / num4);
        System.out.println(iResult);
        //I got 0

        //I expect 0 as the result is rounded down
        fResult = (int) (val1 / num4);
        System.out.println(fResult);
        //I got 0
        
        //I expect 0 as the number is rounded down in the end
        fResult = (int) ((double) num1 / num2);
        System.out.println(fResult);
        //I got 0

        //I expect 3 as that's the remainder
        iResult = num3 % num4;
        System.out.println(iResult);
        //I got 3

        //I expect 2
        iResult = num2 % num3;
        System.out.println(iResult);
        //I got 2
        
        //I expect 1
        iResult = num3 % num2;
        System.out.println(iResult);
        //I got 1

        //I expect 2
        iResult = num2 % num4;
        System.out.println(iResult);
        //I got 2
    }

    public static void ex210a()
    {
        //All math operations follow PEMDAS so it subtracts from left to right
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a - b - c - d);
    }

    public static void ex210b()
    {
        //The operation will go from left to right
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a - b + c - d);
    }

    public static void ex210c()
    {
        //The operation will start with b / c and then divided by d then added to a
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a + b / c / d);
    }

    public static void ex210d()
    {
        //The operation will start with division then multiplication and then addition
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a + b / c * d);
    }

    public static void ex210e()
    {
        //The operation will go from left to right 
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a / b * c * d);
    }

    public static void ex210f()
    {
        //The operation will still go from left to right as the percent is counted as division
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a % b / c * d);
    }

    public static void ex210g()
    {
        //The operation will go from left to right
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a % b % c % d);
    }

    public static void ex210h()
    {
        //Because of PEMDAS it will start with the variables in the parenthesis then go from left to right starting with a
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a - (b - c) - d);
    }

    public static void ex210i()
    {
        //The operation will start with b - c then a minus that then all that minus d
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println((a - (b - c)) - d);
    }

    public static void ex210j()
    {
        //The operation will again start with b - c then that subtracted with d then all of that subtracted with a
        int a = 0, b = 1, c = 2, d = 3;
        System.out.println(a - ((b - c) - d));
    }

    public static void ex210k()
    {
        //The operation will start with the inner most parenthesis then go from left to right
        int a = 0, b = 1, c = 2, d = 3, e = 4;
        System.out.println(a % (b % c) * d * e);
    }

    public static void ex210l()
    {
        //The operation will start with the inner most parenthesis then multiplied by d
        //Then the operation will go from left to right start back from a
        int a = 0, b = 1, c = 2, d = 3, e = 4;
        System.out.println(a + (b - c) * d - e);
    }

    public static void ex210m()
    {
        //The operation will start with a + b then all the multiplications is done with the sum of a and b multiplied with c 
        //Then d is multiplied with e and they're all added together
        int a = 0, b = 1, c = 2, d = 3, e = 4;
        System.out.println((a + b) * c + d * e);
    }

    public static void ex210n()
    {
        //The operation starts with the parenthesis going from left to right then they're multiplied and then find the modulus with e
        int a = 0, b = 1, c = 2, d = 3, e = 4;
        System.out.println((a + b) * (c / d) % e);
    }

    public static void main(String[] args)
    {
        // ex21();

        // ex22();

        // ex23();

        // ex24();

        // ex25();

        // ex26();

        // ex27();

        // ex28();

        //ex29();

        ex210a();
        ex210b();
        ex210c();
        ex210d();
        ex210e();
        ex210f();
        ex210g();
        ex210h();
        ex210i();
        ex210j();
        ex210k();
        ex210l();
        ex210m();
        ex210n();
    }
}
