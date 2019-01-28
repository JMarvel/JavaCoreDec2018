import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course<T extends Number> {

    private static final Integer ZERO = 0;

    private CourseList name;
    private String gradeType;
    // The problem name features the word 'Generics', so a generic construct needs to be used.
    // Is this the right way to implement it or would you approach it differently and implement
    // it another way?
    private Map<Student, T> studentsAndGradeList;

    Course(CourseList name, String gradeType) {
        this.name = name;
        this.gradeType = gradeType;
        studentsAndGradeList = new HashMap<>();
        System.out.println("\nCourse " + name + " with " + gradeType + " grades added to the curriculum.");
    }

    // Getters
    public CourseList getName() { return this.name; }

    void fillStudents(School school) {

        int studentCount = this.studentsAndGradeList.size() + 1;
        String firstName = "";
        String lastName = "";

        do {

            System.out.println("Adding student #" + studentCount + "...");

            do {
                System.out.print("Enter first name (alphabetic chars only): ");
                firstName = MainMenu.sc.nextLine();
            } while (!firstName.matches("[a-zA-Z]+"));

            do {
                System.out.print("Enter last name (alphabetic chars only): ");
                lastName = MainMenu.sc.nextLine();
            } while (!lastName.matches("[a-zA-Z]+"));

            Student newStudent = new Student(firstName, lastName);
            if (this.studentsAndGradeList.containsKey(newStudent)) {
                System.out.println("This student has already been enrolled in this course.");
            } else if (school.listOfStudents.indexOf(newStudent) != -1) {
                newStudent = school.listOfStudents.get(school.listOfStudents.indexOf(newStudent));
                newStudent.getCourseAndGradeList().put(this, (T)ZERO);
                this.studentsAndGradeList.put(newStudent, (T)ZERO);
                System.out.println(firstName + " " + lastName + " added to the course " + this.name);
                studentCount++;
            } else {
                newStudent.getCourseAndGradeList().put(this, (T)ZERO);
                this.studentsAndGradeList.put(newStudent, (T)ZERO);
                school.listOfStudents.add(newStudent);
                System.out.println(firstName + " " + lastName + " added to the course " + this.name);
                studentCount++;
            }
            System.out.print("Enter S to stop or any other sequence to add another student: ");
            if (MainMenu.sc.nextLine().equalsIgnoreCase("S")) {
                System.out.println("Exiting to main menu...");
                break;
            }
        } while (true);
    }

    void gradeAllStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's grade all students for this course.\n" +
                "Grades for this course should be " + gradeType);
        for (var entry : studentsAndGradeList.entrySet()) {
            System.out.print("Enter the grade for " + entry.getKey().toString() + ": ");
            Number grade;
            do {
                try {
                    if (this.gradeType.equals("integer"))
                        grade = Integer.parseInt(sc.nextLine());
                    else
                        grade = Double.parseDouble(sc.nextLine());
                    if (grade.doubleValue() > 5 || grade.doubleValue() <= 0) {
                        System.out.print("Your input is invalid. Enter a single positive " + gradeType +
                                " from 1 to 5: ");
                    } else {
                        studentsAndGradeList.put(entry.getKey(), (T)grade);
                        entry.getKey().getCourseAndGradeList().put(this, grade);
                        break;
                    }
                } catch (NumberFormatException e1) {
                    System.out.print("Your input is invalid. Enter a single positive " + gradeType + ": ");
                }
            } while (true);
        }
    }

    void displayGrades() {
        if (studentsAndGradeList.isEmpty()) {
            System.out.println("\nThe listing is empty.");
        } else {
            System.out.println("\nHere's a student / grade listing for the " + name + " course:");
            for (var entry : studentsAndGradeList.entrySet()) {
                if (entry.getValue().doubleValue() == 0)
                    System.out.println(entry.getKey().toString() + ": Not yet rated.");
                else
                    System.out.println(entry.getKey().toString() + ": " + entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return this.name.toString() + ", grades are " + this.gradeType + " (" +
                this.studentsAndGradeList.size() + " students enrolled)";
    }
}
