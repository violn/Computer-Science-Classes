	class Week3 
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
			int a;
			a = 100;
			Print(a);
		}

		public static void testIntegerLimits2() 
		{ 
			int a;
			a = 100;
			Print("Before:");
			Print(a);
			a += 10;
			Print("After:");
			Print(a);
		}

		public static void testIntegerLimits3() 
		{
			int a;
			a = 100;
			a += 10;
			Print("Before my Code:");
			Print(a);
			Print("After my Code:");
			a += 100;
			System.out.println(a);
		}

		public static void testIntegerLimitsLoop4() 
		{
			int a;
			a = 100;
			Print("Before a is less than 1000:");

			while( a < 1001)
			{
				a += 10;
				Print("Before my Code:");
				Print(a);
			}
			
			Print("After a is greater than 1000:");
			Print(a);
			Print(" --------- Cool I am done:");
		}

		public static void testIntegerLimitsLoop5() 
		{
			int a; 
			a = 100;
			for(int i = 0; i < Integer.MAX_VALUE; i += 1000)
			{
				a += 1000;
				Print(a);

				if(a < 0)
				{
					Print("Exiting the program as a < 0.");
					a -= 10000;
					break;
				}
			}

			Print("After a is greater than MAX Value of the data type:");
			Print(a);
			Print(" --------- Cool I am done:");

			//The last few lines of the console tells me that the max number for the integer data type is either 214747100 or close to that number
			//Then after it becomes greater than that number it will loop back to it's min value which is close to -2147483196
		}

		public static void testIntegerLimitsLoop6() 
		{
			int a; 
			a = 100;
			for(int i = 0; i > Integer.MIN_VALUE; i -= 1000)
			{
				a -= 1000;
				Print(a);

				if(a > 0)
				{
					Print("Exiting the program as a > 0.");
					a += 10000;
					break;
				}
			}

			Print("After a is less than Min Value of the data type:");
			Print(a);
			Print(" --------- Cool I am done:");

			//The last few lines of the console tells me that the min number for the integer data type is either -2147482900 or close to that number
			//Then after it becomes greater than that number it will loop back to it's min value which is close to 2147483396
		}

		//The range of the integer data type in java is -2147483648 to 2147483647
		//Also hovering MIN_VALUE and MAX_VALUE can tell you this

		public static void Print(Object something) 
		{
			System.out.println(something);
		}
	}