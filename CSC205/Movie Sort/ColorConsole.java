public class ColorConsole
{
	private static final String ANSI_RESET = "\u001B[0m";

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_WHITE = "\u001B[37m";

	private static String foreGroundColor = ColorConsole.TEXT_BLUE;

	public static void setForeGroundColor(String foreGroundColor)
	{
		ColorConsole.foreGroundColor = foreGroundColor;
	}

	public static void println(Object val)
	{
		System.out.println(ColorConsole.foreGroundColor + val + ANSI_RESET);
	}

	public static void print(Object val)
	{
		System.out.println(ColorConsole.foreGroundColor + val + ANSI_RESET);
	}

	public static void clearConsole() 
	{
		try
		{
			String operatingSystem = System.getProperty("os.name");

			if (operatingSystem.contains("Windows"))
			{
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			}
			else
			{
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();

				startProcess.waitFor();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void printBanner(String banner)
	{
		ColorConsole.clearConsole();
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_YELLOW);

		banner = Utility.leftPadding(banner, ' ', 40);
		banner = Utility.rightPadding(banner, ' ', 40);

		String separator = "*";
		separator = Utility.leftPadding(separator, '*', banner.length() + 35);
		separator = Utility.rightPadding(separator, '*', banner.length() + 35);
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_YELLOW);
		ColorConsole.println(separator);
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_BLUE);
		ColorConsole.println(banner);
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_YELLOW);
		ColorConsole.println(separator);
	}

	public static String fill(char fillChar, int repeat)
	{
		return Utility.leftPadding(String.valueOf(fillChar), fillChar, repeat);
	}
}
