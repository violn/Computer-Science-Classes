public class KnowStrings {
    public static void main(String[] args) {
        testAdvancedString(10000);
        testStandardString(1000);
        testStandardIntTest(1000000000000L);
    }

    private static void testStandardIntTest(long repeatCount)
    {
        long startTime = System.currentTimeMillis();
        long initialValue = 1000;
        long addValue = 10;
        for (long i = 0; i < 10000; i++) {
            initialValue += addValue;
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapse Time adding numbers = " + elapsedTime + " milli seconds");
    }

    private static void testStandardString(int repeatCount)
    {
        long startTime = System.currentTimeMillis();
        String initialString = "Hello";
        String addString = "Glad to Meet with you";
        for (long i = 0; i < 10000; i++) {
            initialString += addString;
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapse Time adding strings = " + elapsedTime + " milli seconds");
    }

    private static void testAdvancedString(int repeatCount)
    {
        long startTime = System.currentTimeMillis();
        String initialString = "Hello";
        String addString = "Glad to Meet with you";
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < 10000; i++) {
            sb.append(addString);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapse Time adding strings using String Builder = " + elapsedTime + " milli seconds");
    }
}