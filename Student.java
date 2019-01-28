import java.util.HashMap;
import java.util.Map;

public class Student <T extends Number> implements Comparable<Student> {

    private static final Integer ZERO = 0;

    private String firstName;
    private String lastName;
    private Map<Course, T> courseAndGradeList;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        courseAndGradeList = new HashMap<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    Map<Course, T> getCourseAndGradeList() {
        return courseAndGradeList;
    }

    void displayGrades() {
        if (courseAndGradeList.isEmpty())
            System.out.println("\nThe listing is empty.");
        else {
            System.out.println("Here's a course / grade listing for " + this.toString() + ":");
            for (var entry : courseAndGradeList.entrySet()) {
                System.out.println(entry.getKey().toString() + ": " + entry.getValue());
            }
        }
    }

    @Override
    public int compareTo(Student otherStudent) {
        int result = this.lastName.compareTo(otherStudent.lastName);
        if (result == 0)
            result = this.firstName.compareTo(otherStudent.firstName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student))
            return false;
        Student otherStudent = (Student) o;
        return this.firstName.equals(otherStudent.firstName)
                && this.lastName.equals(otherStudent.lastName);
    }

    @Override
    public int hashCode() {
        int result = this.firstName.hashCode();
        result = 31 * result + this.lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
