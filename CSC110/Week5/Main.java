import java.util.Arrays;

class Main
{
        public static void main(String[] args)
        {
                final int length = 5;

                // integer array object from Generic_Array class
                Generic_Array<Integer> intArray = new Generic_Array(length);

                for (int i = 0; i < length; i++)
                {
                        intArray.set(i, i * 2);
                }

                System.out.println("Integer Array elements:" + intArray);

                // String array object from Generic_Array class
                Generic_Array<String> strArray = new Generic_Array(length);

                for (int i = 0; i < length; i++)
                {
                        strArray.set(i, String.valueOf((char) (i + 97)));
                }

                System.out.println("String Array Elements:" + strArray);
        }
}

class Diff
{
        public static void main(String[] args) 
        {
                System.out.println("Main");
        }
}