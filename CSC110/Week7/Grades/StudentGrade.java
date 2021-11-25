package Grades;

import java.util.Comparator;
import java.util.Date;

public class StudentGrade
{
    private final String FirstName;
    private final String LastName;
    private final Date DateofBirth;
    private final String CourseName;
    private final char LetterGrade;
    public static final Comparator<StudentGrade> BY_GRADE = Comparator.comparingInt(StudentGrade::getLetterGrade);

    StudentGrade(String FirstName, String LastName, Date DateofBirth, String CourseName, char LetterGrade)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DateofBirth = DateofBirth;
        this.CourseName = CourseName;
        this.LetterGrade = LetterGrade;
    }

    String getFirstName()
    {
        return FirstName;
    }

    String getLastName()
    {
        return LastName;
    }

    Date getDateofBirth()
    {
        return DateofBirth;
    }

    String getCourseName()
    {
        return CourseName;
    }

    char getLetterGrade()
    {
        return LetterGrade;
    }

    String noTime()
    {
        return DateofBirth.toString().substring(4, 11) + DateofBirth.toString().substring(24, 28);
    }

    @Override
    public String toString()
    {
        return String.format(
                "Student {First Name = %s, Last Name = %s, Date of Birth = " + noTime() + ", Course = %s, Grade = %c}",
                FirstName, LastName, CourseName, LetterGrade);
    }
}
