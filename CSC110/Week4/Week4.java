class Week4 
{
		public static void main(String[] args) 
		{

			// IMPORTANT NOTE as required only uncomment the line 7 through 12. 
			// Do not forget the put "//" to comment other Method/Functions names
			//testIntegerLimits1();
			//testIntegerLimits2();
			//testIntegerLimits3();
			//testIntegerLimitsLoop5();
			//testIntegerLimitsLoop7();
			//testIntegerLimitsLoop8();
			//testIntegerLimitsLoop9();
		}

		// sample code how you write a function
		public static void testIntegerLimits1() 
		{ //"testIntegerLimits1" is called a method
		
			// in order for you as a programmer to store data in computer
			// we need a data type
			// to store a numeric whole number value we use a data type called Integer
			// The forward two slashes in this code segment is a way to add human readable comments, that the computer will ignore as commands


			// Modern way to declare variables
			//Step 1: Declare the variable type and assign the value by using the key word "var" instead of Integer. However, you need to do this in one line
			var a = 100; // the magic here is that since the value assigned to "a" is 100.
			// nd 100 is an integer Java programming is able to infer the variable as Integer
			//Step 3: Use the following code to print the value in the variable a
			Print(a);

			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// observe the output
		}


		// you need to have an unique method name if your code is in the same segment. That makes commonsense right?
		public static void testIntegerLimits2() 
		{ 
			//Step 1: Declare the variable type
			Integer a; //   the line here declares the type Inter is a Data Type in Java and "a" is a variable. So that the computer can reserve some memory.
			// at this point the value stored in the variable is undertenant.
		
			//Step 2: You need to assign a value
			a = 100;
			Print("Before:");
			Print(a);
			//Step 2a: Increase the value of a by 10;
			a += 10; // this may seem odd
			// reasoning the computer will create a temp variable internally and store the value of "a +10"
			// then reuse the variable "a" to store the value of the result "a +10"

			//Step 3: Use the following code to print the value in the variable a
			Print("After:");
			Print(a);
		}

		//STUDENT ASSIGNMENT a
		//You need to complete the section that says "Write your solution code here"
		// make necessary changes in this segment to use the "var" way of declaring and assigning the variable
		public static void testIntegerLimits3() 
		{
			
			//Step 1: Declare the variable type using keyword "var"
			var a = 100;
			a = a + 10; // this may seem odd
		
			Print(a);

			Print("After my Code:");
			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"

		}

		
		//observe the code change from previous sections, Compare the difference	
		public static void testIntegerLimitsLoop5() 
		{
			var a = 100;
			// new code
			var increment = 10000; // declare a new variable for the incrementing the value
			// change in the code lay out
			for ( var i = 0; i < Integer.MAX_VALUE; i = i + increment)
			{ 
				// you business logic goes here
				a += increment;
				Print(a);

				if( a < 0)
				{ //new Java language construct "if"
					Print("Exiting the program as a < 0.");
					a = a - increment;
					break; // //new Java language construct "break". It will force to exit the loop
				}
			}
			
			Print("After a is greater than MAX Value of the data type:");
			// to print the type of the variable Java inferred 
			// read https://www.geeksforgeeks.org/variables-in-java/
			PrintDataType(a);
			Print(a);
			Print(" --------- Cool I am done:");
			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// note how compact and readable the code starts to be.
		}


		//STUDENT ASSIGNMENT c
		// Perform the following steps
		// assign the variable "a" the value 100.00 ( a decimal) number instead of just 100 in the section of code below
		public static void testIntegerLimitsLoop7() 
		{
			var a = 100.0; // change here
			// new code
			var increment = 10000; // declare a new variable for the incrementing the value
			// new code
			for ( var i = 0; i < Double.MAX_VALUE && a > 0; i = i + increment)
			{ // note the change in the code in this line
				// you business logic goes here
				a = a + increment;
				Print(a);				
			}

			// observe the code change here
			a = a < 0 ? a - increment: a; // explain this concise line of code
			Print("After a is greater than MAX Value of the data type:");
			PrintDataType(a);
			Print(a);
			Print(" --------- Cool I am done:");
			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// observe the difference. explain that in your own words. The difference in the output of the value a
			// note how compact and readable te code start to be.
			// There's is now scientific notation in the larger numbers. 
		}

		//STUDENT ASSIGNMENT D
		// Perform the following steps
		// assign the variable "a" the value 100L (note the L suffix at the end) instead of just 100 in the section of code below
		public static void testIntegerLimitsLoop8() {
			var a = 100L; // change here
			// new code
			var increment = 10000; // declare a new variable for the incrementing the value
			// new code
			for ( var i = 0; i < Double.MAX_VALUE && a > 0; i = i + increment){ // note the change in the code in this line
				// you business logic goes here
				a = a+ increment;
				Print(a);				
			}

			// observe the code change here
			a = a < 0 ? a - increment: a; 
			Print("After a is greater than MAX Value of the data type:");
			PrintDataType(a);
			Print(a);
			Print(" --------- Cool I am done:");
			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// observe the difference. explain that in your own words. The difference in the output of the value a
			//The value just looks like a regular in but the max value is higher than an int because longs have a higher max value
			// note how compact and readable te code start to be.
		}

		//STUDENT ASSIGNMENT E
		// Perform the following steps
		// assign the variable "a" unsigned Integer.toUnsignedLong(1000)in the section of code below
		public static void testIntegerLimitsLoop9() {
			var a = Integer.toUnsignedLong(1000); // change here
			// new code
			var increment = 100000000L; // declare a new variable for the incrementing the value
			// new code
			for ( var i = 0L; i < Integer.MAX_VALUE  && a > 0; i = i + increment){ // note the change in the code in this line
				// your business logic goes here
				a = a + increment;
				Print(a);				
			}

			// observe the code change here
			a = a < 0 ? a - increment: a; 
			Print("After a is greater than MAX Value of the data type:");
			PrintDataType(a);
			Print(a);
			Print(" --------- Cool I am done:");
			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// observe the difference. explain that in your own words. The difference in the output of the value a
			//The value still looks like an int but there is a higher max value because it's long instead of an int
			// note how compact and readable te code start to be.
		}





	    // ignore  this section of the code below this line
		public static void Print(Object something) {
			System.out.println(something);
		}

		public static void PrintDataType(Object something) {
			System.out.println("The Type of Variable a is " + something.getClass().getSimpleName());
		}
	}