import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GradeSplit
{
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
            students.add(new StudentGrade("Colton", "Juma", new SimpleDateFormat("MM/dd/yyyy").parse("8/23/2003"), "French 1", 'C'));
            students.add(new StudentGrade("Toomie", "Gunao", new SimpleDateFormat("MM/dd/yyyy").parse("4/15/1998"), "Communication", 'B'));
            students.add(new StudentGrade("Cherryl", "Tellerman", new SimpleDateFormat("MM/dd/yyyy").parse("2/29/2000"), "Calculus AB", 'F'));
            students.add(new StudentGrade("Vincent", "Geruno", new SimpleDateFormat("MM/dd/yyyy").parse("10/31/2001"), "German", 'B'));
            students.add(new StudentGrade("Maximillion", "Franklin", new SimpleDateFormat("MM/dd/yyyy").parse("11/5/2001"), "Calculus AB", 'A'));
            students.add(new StudentGrade("Emaud", "Leatherman", new SimpleDateFormat("MM/dd/yyyy").parse("7/5/2000"), "Calculus BC", 'D'));
            students.add(new StudentGrade("Jamie", "Turing", new SimpleDateFormat("MM/dd/yyyy").parse("6/12/1999"), "Intro to Java", 'D'));

            splitByGrade(students);

            System.out.println("These students are excelling in their courses.");
            excelling.forEach(std -> System.out.println(std));
    
            System.out.println("\nThese students need help in their courses");
            needs_help.forEach(std -> System.out.println(std));
        }

        catch(Exception e)
        {
            System.out.println("Couldn't parse date.");
        }
    }
}
