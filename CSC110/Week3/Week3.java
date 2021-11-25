public class Week3 
{
		public static void main(String[] args) 
		{
			//testIntegerLimits1();
			//testIntegerLimits2();
			//testIntegerLimits3();
			//testIntegerLimitsLoop4();
			//testIntegerLimitsLoop5();
			testIntegerLimitsLoop6();
		}

		public static void testIntegerLimits1() 
		{
			Integer a;
			a = 100;
			Print(a);
		}

		public static void testIntegerLimits2() 
		{ 
			Integer a;
			a = 100;
			Print("Before:");
			Print(a);
			a += 10;
			Print("After:");
			Print(a);
		}

		public static void testIntegerLimits3() 
		{
			Integer a;
			a = 100;
			a = a +10;

			Print("Before my Code:");
			Print(a);
			Print("After my Code:");

			//Write your solution code here
			//  **Required: write Java code to increase the value of a by 100
			//  **then write the code to print the value of "a" again in lines 76 through 80

			a += 100;
			System.out.println(a);

			// now to run the program go to line number and click on the "Run" label on the segment **"Run|Debug"
			// observe the output
		}

		public static void testIntegerLimitsLoop4() 
		{
			Integer a;
			a = 100;
			Print("Before a is less than 1000:");

			while( a < 1001)
			{
				a = a + 10;
				Print("Before my Code:");
				Print(a);
			}

			Print("After a is greater than 1000:");
			Print(a);
			Print(" --------- Cool I am done:");
		}

		public static void testIntegerLimitsLoop5() 
		{
			Integer a; 
			a = 100;

			for( Integer i = 0; i < Integer.MAX_VALUE;i = i + 1000)
			{
				a = a + 1000;
				Print(a);

				if( a < 0)
				{
					Print("Exiting the program as a < 0.");
					a = a - 10000;
					break;
				}
			}

			
			Print("After a is greater than MAX Value of the data type:");
			Print(a);
			Print(" --------- Cool I am done:");
		}

		//STUDENT ASSIGNMENT c
		//Step 1: copy the complete code segment "testIntegerLimitsLoop5" and paste it below in line 156	
		//Step 2:Then change the name "testIntegerLimitsLoop5" to  "testIntegerLimitsLoop6" and paste it below in line 156
		//Step 2:Then change the code in the method/function "testIntegerLimitsLoop5" to find the MINIMUM value the Integer variable "a"

		public static void testIntegerLimitsLoop6() 
		{
			Integer a; 
			a = 100;
			
			for( Integer i = 0; i > Integer.MIN_VALUE; i = i - 1000)
			{
				a = a - 1000;
				Print(a);

				if(a > 0)
				{
					Print("Exiting the program as a > 0.");
					a = a + 10000;
					break;
				}
			}

			
			Print("After a is less than MIN  Value of the data type:");
			Print(a);
			Print(" --------- Cool I am done:");
		}

		// What is the range of the Integer Data Type Variable in Java. NOTE: The same is true for many programming languages as well.
		// The range of the Integer data type is -2147483648 to 2147483647
		
		public static void Print(Object something) 
		{
			System.out.println(something);
		}
}