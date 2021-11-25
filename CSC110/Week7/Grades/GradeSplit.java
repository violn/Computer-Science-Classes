package Grades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GradeSplit {
    static List<StudentGrade> excelling = new ArrayList<>();
    static List<StudentGrade> needs_help = new ArrayList<>();

    public static void splitByGrade(ArrayList<StudentGrade> students) 
    {
        students.sort(StudentGrade.BY_GRADE);

        for (StudentGrade student : students) 
        {
            if (student.getLetterGrade() > 'B') 
            {
                needs_help = students.subList(students.indexOf(student), students.size());
                excelling = students.subList(0, students.indexOf(student));
                return;
            }

            excelling = students;
        }
    }

    public static void main(String[] args) 
    {
        ArrayList<StudentGrade> students = new ArrayList<StudentGrade>();

        try 
        {
            BufferedReader student_file = new BufferedReader(new FileReader("Grades/Students.txt"));
            String current_line = student_file.readLine();

            do
            {
                String[] student_info = current_line.split(", ");
                students.add(new StudentGrade(student_info[0], student_info[1], new SimpleDateFormat("MM/dd/yyyy").parse(student_info[2]), student_info[3], student_info[4].toCharArray()[0]));
                current_line = student_file.readLine();
            }
            while(current_line != null);

            splitByGrade(students);

            System.out.println("These students are excelling in their courses.");
            excelling.forEach(std -> System.out.println(std));

            System.out.println("\nThese students need help in their courses");
            needs_help.forEach(std -> System.out.println(std));

            student_file.close();
        }

        catch (IOException e) 
        {
            System.out.println("The file couldn't be found.");
        }

        catch (ParseException e)
        {
            System.out.println("Couldn't parse the date.");
        }
    }
}
