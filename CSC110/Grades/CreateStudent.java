package Grades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateStudent 
{
    private static final Random ran = new Random();
    private static List<String> courses = new ArrayList<>();

    public static void main(String[] args) 
    {
        makeStudentFile();
    }

    public static void makeStudentFile() 
    {
        try 
        {
            courses = Files.readAllLines(Paths.get("Grades/Courses.txt"));
        } 
        catch (IOException e) 
        {
            System.out.println("Couldn't find the courses file. Generating made up courses.");
            
            for(int x = 0; x < 100; x++)
            {
                courses.add(generateName());
            }
        }

        try 
        {
            Files.write(Paths.get("Grades/Students.txt"), (generateStudent().format() + "\n").getBytes());

            for (int x = 0; x < 999; x++) 
            {
                Files.write(Paths.get("Grades/Students.txt"), (generateStudent().format() + "\n").getBytes(), StandardOpenOption.APPEND);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
    }

    private static StudentGrade generateStudent() 
    {
        String first_name = generateName();
        String last_name = generateName();
        LocalDate dob = getRandomDate();
        String course = getRandomCourse();
        int grade = ran.nextInt(101);

        return new StudentGrade(first_name, last_name, dob, course, grade);
    }

    private static String generateName() 
    {
        List<Character> consonants = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();
        List<Character> capitals = new ArrayList<>();
        String name = "";

        for(char x = 'A'; x <= 'Z'; x++)
        {
            capitals.add(x);
        }

        for(char x = 'a'; x <= 'z'; x++)
        {
            if(Arrays.asList('a', 'e', 'i', 'o', 'u').contains(x))
            {
                vowels.add(x);
            }

            else consonants.add(x);
        }

        for(int x = 0; x < 8; x++)
        {
            if(x > 3 && ran.nextInt(100) < 50)
            {
                return name;
            }

            switch(x)
            {
                case 0:
                    name += capitals.get(ran.nextInt(capitals.size()));
                    break;

                case 1:
                    name += vowels.get(ran.nextInt(vowels.size()));
                    break;

                default:
                    if(consonants.contains(name.toCharArray()[x - 1]))
                    {
                        name += vowels.get(ran.nextInt(vowels.size()));
                    }
                    else if(vowels.contains(name.toCharArray()[x - 2]) || Arrays.asList('A', 'E', 'I', 'O', 'U').contains(name.toCharArray()[x - 2]))
                    {
                        name += consonants.get(ran.nextInt(consonants.size()));
                    }
                    else name += vowels.get(ran.nextInt(vowels.size()));
            }
        }

        return name;
    }

    private static LocalDate getRandomDate() 
    {
        int minDay = (int) LocalDate.of(1996, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2003, 12, 31).toEpochDay();
        long randomDay = minDay + ran.nextInt(maxDay - minDay);

        LocalDate random_date = LocalDate.ofEpochDay(randomDay);

        return random_date;   
    }

    private static String getRandomCourse() 
    {
        return courses.get(ran.nextInt(courses.size()));
    }
}
