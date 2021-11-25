package Geometry;

class TestGeometricalShapes
{
	public static void main(String[] args)
	{
		while (true)
		{
			clearScreen();
			displayShapesChoice();
		}
	}

	private static void displayShapesChoice()
	{
		displayChoices("Please select from the shape choices", new String[]
		{ "1 - for Point", "2 - for Line", "3 - for Rectangle", "4 - for Square", "5 - for Triangle",  "6 - for Cube", "exit - to Exit" });
		System.out.print("Enter the number corresponing with your geometircal shape: ");
		String selectedChoice = System.console().readLine();

		switch (selectedChoice)
		{
			case "1":
				processChoicePoint();
				break;
			case "2":
				processChoiceLine();
				break;
			case "3":
				proccessChoiceRectangle();
				break;
			case "4":
				proccessChoiceSquare();
				break;
			case "5":
				proccessChoiceTriangle();
				break;
			case "6":
				proccessChoiceCube();
				break;
			case "exit":
				System.out.println("Goodbye.");
				System.exit(0);
				break;
			default:
				clearScreen();
				System.out.print("Please enter a correct input.\n");
				break;

		}
	}

	private static void processChoiceLine()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Line");

		System.out.print("Enter its slope: ");
		double m = Double.parseDouble(System.console().readLine());

		System.out.print("\nEnter its y-intercept: ");
		double b = Double.parseDouble(System.console().readLine());

		Line line = new Line(m, b);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your line", new String[]
			{ "1 - Display General Info", "2 - Check if it hits a certain point", "3 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println(line);
					break;

				case "2":
					clearScreen();
					System.out.print("Enter the x-coordinate of the point: ");
					double x = Double.parseDouble(System.console().readLine());

					System.out.print("\nEnter the y-coordinate of the point: ");
					double y = Double.parseDouble(System.console().readLine());

					Point point = new Point(x, y);

					clearScreen();
					System.out.println(line.hitsPoint(point) ? "The line " + line.getEquation() + " hits the point" + point.getCoordinates() : "The line " + line.getEquation() + " does not hit the point" + point.getCoordinates());
					break;

				case "3":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void processChoicePoint()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Point");

		System.out.print("Enter its x-coordinate: ");
		double x = Double.parseDouble(System.console().readLine());

		System.out.print("\nEnter its y-coordinate: ");
		double y = Double.parseDouble(System.console().readLine());

		Point point = new Point(x, y);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your point", new String[]
			{ "1 - Display General Info", "2 - Find distance from another point", "3 - Check if it hits a line", "4 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println(point);
					break;

				case "2":
					clearScreen();
					System.out.print("Enter the x-coordinate of the point you want to find the distance from: ");
					double x2 = Double.parseDouble(System.console().readLine());

					System.out.print("\nEnter the y-coordinate of the point you want to find the distance from: ");
					double y2 = Double.parseDouble(System.console().readLine());

					Point point2 = new Point(x2, y2);

					clearScreen();
					System.out.println("The distance between the two points is: " + point.distanceFrom(point2));
					break;

				case "3":
					clearScreen();
					System.out.print("Enter the slope of the line: ");
					double m = Double.parseDouble(System.console().readLine());

					System.out.print("\nEnter the y-intercept of the line: ");
					double b = Double.parseDouble(System.console().readLine());

					Line line = new Line(m, b);

					clearScreen();
					System.out.println(line.hitsPoint(point) ? "The point " + point.getCoordinates() + " hits the line" + line.getEquation() : "The point " + point.getCoordinates() + " does not hit the line" + line.getEquation());
					break;

				case "4":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void proccessChoiceRectangle()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Rectangle");

		System.out.print("Enter its width: ");
		double width = Double.parseDouble(System.console().readLine());

		System.out.print("\nEnter its height: ");
		double height = Double.parseDouble(System.console().readLine());

		Rectangle rectangle = new Rectangle(width, height);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your rectangle", new String[]
			{ "1 - Find Area", "2 - Find Perimeter", "3 - Display General Info", "4 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println("The area of this rectangle is " + rectangle.getArea());
					break;
				case "2":
					clearScreen();
					System.out.println("Permiter of this rectangle is " + rectangle.getPerimeter());
					break;
				case "3":
					clearScreen();
					System.out.println(rectangle);
					break;
				case "4":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void proccessChoiceSquare()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Square");
		System.out.print("Enter its side lengths: ");
		double length = Double.parseDouble(System.console().readLine());
		Square square = new Square(length);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your square", new String[]
			{ "1 - Find Area", "2 - Find Perimeter", "3 - Display General Info", "4 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println("The area of this square is " + square.getArea());
					break;
				case "2":
					clearScreen();
					System.out.println("Permiter of this square is " + square.getPerimeter());
					break;
				case "3":
					clearScreen();
					System.out.println(square);
					break;
				case "4":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void proccessChoiceCube()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Cube");
		System.out.print("Enter its side lengths: ");
		double length = Double.parseDouble(System.console().readLine());
		Cube cube = new Cube(length);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your cube", new String[]
			{ "1 - Find Volume", "2 - Find Surface Area", "3 - Display General Info", "4 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println("The Volume of this cube is " + cube.getVolume());
					break;
				case "2":
					clearScreen();
					System.out.println("Surface Area of this cube is " + cube.getSurfaceArea());
					break;
				case "3":
					clearScreen();
					System.out.println(cube);
					break;
				case "4":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void proccessChoiceTriangle()
	{
		clearScreen();
		System.out.println("Great Choice, you selected : Triangle");

		System.out.print("Enter its first side length: ");
		double length1 = Double.parseDouble(System.console().readLine());

		System.out.print("\nEnter its second side length: ");
		double length2 = Double.parseDouble(System.console().readLine());

		System.out.print("\nEnter its third side length: ");
		double length3 = Double.parseDouble(System.console().readLine());

		Triangle triangle = new Triangle(length1, length2, length3);

		clearScreen();
		while (true)
		{
			displayChoices("What do you want to do with your triangle", new String[]
			{ "1 - Find Area", "2 - Find Perimeter", "3 - Display General Info", "4 - Choose another shape" });
			System.out.print("Enter your choice here: ");
			String selectedChoice = System.console().readLine().toLowerCase();
			switch (selectedChoice)
			{
				case "1":
					clearScreen();
					System.out.println("The area of this triangle is " + triangle.getArea());
					break;
				case "2":
					clearScreen();
					System.out.println("Permiter of this triangle is " + triangle.getPerimeter());
					break;
				case "3":
					clearScreen();
					System.out.println(triangle);
					break;
				case "4":
					clearScreen();
					return;
				default:
					clearScreen();
					System.out.print("Please enter a correct input.\n");
					break;
			}
		}
	}

	private static void displayChoices(String message, String[] choices)
	{
		final String txtart = "------------------------------------------------------";
		System.out.println(String.format("%s%n%s%n%s", txtart, message, txtart));

		for (String choice : choices)
		{

			System.out.println("" + choice);
		}

		System.out.println(String.format("%s%n%s%n%s", txtart, txtart, txtart));
	}

	private static void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}