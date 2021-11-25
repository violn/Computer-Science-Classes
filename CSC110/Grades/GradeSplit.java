package Grades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GradeSplit 
{
    static List<StudentGrade> excelling = new ArrayList<>();
    static List<StudentGrade> needs_help = new ArrayList<>();

    public static void splitByGrade(List<StudentGrade> students) 
    {
        students.sort(StudentGrade.BY_GRADE);

        students.forEach(std ->
        {
            if (std.getLetterGrade() < 70) 
            {
                needs_help = students.subList(students.indexOf(std), students.size());
                excelling = students.subList(0, students.indexOf(std));
                return;
            }

            excelling = students;
        });
    }

    public static void main(String[] args) 
    {
        List<StudentGrade> students = new ArrayList<>();
        List<String> file_lines = new ArrayList<>();

        try 
        {
            file_lines = Files.readAllLines(Paths.get("Grades/Students.txt"));
        }

        catch (IOException e) 
        {
            System.out.println("The student file couldn't be found. A new one will be generated.");
            CreateStudent.makeStudentFile();

            try 
            {
                file_lines = Files.readAllLines(Paths.get("Grades/Students.txt"));
            } 
            
            catch (IOException e1) 
            {
                System.out.println("We're having trouble creating the student file. Please rerun this program.");
                System.exit(0);
            }
        }

        try
        {
            file_lines.forEach(l -> 
            {
                String[] student_info = l.split(", ");
                students.add
                (
                    new StudentGrade
                    (
                        student_info[0], student_info[1],
                        LocalDate.of(Integer.parseInt(student_info[2].substring(0, 4)),
                        Integer.parseInt(student_info[2].substring(5, 7)),
                        Integer.parseInt(student_info[2].substring(8, student_info[2].length()))),
                        student_info[3], Integer.parseInt(student_info[4])
                    )
                );
            });

            splitByGrade(students);

            Files.write(Paths.get("Grades/UpdateStudentGrades.txt"),
                    "These students got a 10 percent grade increase.\n".getBytes());

            needs_help.forEach(std -> 
            {
                std.increaseGrade(10);
                try 
                {
                    Files.write(Paths.get("Grades/UpdateStudentGrades.txt"), (std.format() + "\n").getBytes(), StandardOpenOption.APPEND);
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }

            });

            try 
            {
                Files.write(Paths.get("Grades/UpdateStudentGrades.txt"), "\nThese students did not get a 10 percent grade increase.\n".getBytes(), StandardOpenOption.APPEND);
            } 
            catch (IOException e1) 
            {
                e1.printStackTrace();
            }

            excelling.forEach(std -> 
            {
                try 
                {

                    Files.write(Paths.get("Grades/UpdateStudentGrades.txt"), (std.format() + "\n").getBytes(), StandardOpenOption.APPEND);
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            });
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
