package Grades;

import java.time.LocalDate;
import java.util.Comparator;

public class StudentGrade
{
    private final String FirstName;
    private final String LastName;
    private final LocalDate DateofBirth;
    private final String CourseName;
    private int Grade;
    public static final Comparator<StudentGrade> BY_GRADE = Comparator.comparingInt(StudentGrade::getLetterGrade).reversed();

    StudentGrade(String FirstName, String LastName, LocalDate DateofBirth, String CourseName, int LetterGrade)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DateofBirth = DateofBirth;
        this.CourseName = CourseName;
        this.Grade = LetterGrade;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public LocalDate getDateofBirth()
    {
        return DateofBirth;
    }

    public String getCourseName()
    {
        return CourseName;
    }

    public int getLetterGrade()
    {
        return Grade;
    }

    public void increaseGrade(int amount) 
    {
        this.Grade += amount;
    }

    public String format()
    {
        return String.format
        (
            "%s, %s, %s, %s, %s", 
            FirstName, LastName, DateofBirth, CourseName, Grade
        );
    }

    @Override
    public String toString()
    {
        return String.format
        (
            "Student {First Name = %s, Last Name = %s, Date of Birth = %s, Course = %s, Grade = %s}",
            FirstName, LastName, DateofBirth, CourseName, Grade
        );
    }
}
