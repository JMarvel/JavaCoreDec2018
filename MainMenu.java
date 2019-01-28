import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        School school = new School();
        MainMenu mainMenu = new MainMenu();

        mainMenu = mainMenu.display(mainMenu, school);
    }

    MainMenu display(MainMenu mainMenu, School school) {

        int selection;

        System.out.println("Hi, I'm an application that enables you to add courses to\n" +
                "a curriculum from a pre-defined list of courses, fill in students list for\n" +
                "the courses, grade all students for a specified course and show grades across\n" +
                "all courses taken by a specified student.");

        // What are some best practices when implementing a console menu? Does one do it
        // through an infinite do-while(true) loop and a switch-case construct? Or are there
        // better, more elegant solutions?

        do {
            System.out.println("\nWhat do you want to do next?");
            System.out.println("1. Add a course to the curriculum.");
            System.out.println("2. Show a listing of students / grades for a specific course");
            System.out.println("3. Enroll students in a course.");
            System.out.println("4. Grade all students in a course.");
            System.out.println("5. Display a student's grades across all courses.");
            System.out.println("6. Show a listing of available courses.");
            System.out.println("7. Exit the application.\n");

            System.out.print("Enter your selection: ");

            selection = Integer.parseInt(sc.nextLine());

            switch (selection) {
                case 1: {
                    school.listOfCourses.add(school.addCourseToCurriculum());
                    break;
                }
                case 2: {
                    if (school.listOfCourses.size() == 0) {
                        System.out.println("There are no courses in the curriculum. Add a course first.");
                    } else {
                        int selectedCourseNumber = school.selectionFrom(school.listOfCourses);
                        school.listOfCourses.get(selectedCourseNumber - 1).displayGrades();
                    }
                    break;
                }
                case 3: {
                    if (school.listOfCourses.size() == 0) {
                        System.out.println("There are no courses in the curriculum. Add a course first.");
                    } else {
                        int selectedCourseNumber = school.selectionFrom(school.listOfCourses);
                        school.listOfCourses.get(selectedCourseNumber - 1).fillStudents(school);
                    }
                    break;
                }
                case 4: {
                    if (school.listOfCourses.size() != 0) {
                        int selectedCourseNumber = school.selectionFrom(school.listOfCourses);
                        school.listOfCourses.get(selectedCourseNumber - 1).gradeAllStudents();
                    } else
                        System.out.println("There are no courses in the curriculum. Add a course first.");
                    break;
                }
                case 5: {
                    if (school.listOfStudents.size() == 0) {
                        System.out.println("There are no students yet. Add a course first and fill it.");
                    } else {
                        int selectedStudentNumber = school.selectionFrom(school.listOfStudents);
                        school.listOfStudents.get(selectedStudentNumber - 1).displayGrades();
                    }
                    break;
                }
                case 6: {
                    school.showAvailableCourses();
                    break;
                }
                case 7: {
                    System.out.println("Exiting the application...");
                    break;
                }
                default: {
                    System.out.println("Your input is invalid. Please enter a number, from 1 to 7.");
                }
            }
        } while (selection != 7);

        return mainMenu;
    }
}

