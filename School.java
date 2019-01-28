import java.util.ArrayList;

class School {

    static CourseList courseList;

    ArrayList<Student> listOfStudents;
    ArrayList<Course> listOfCourses;

    School() {
        listOfCourses = new ArrayList<>();
        listOfStudents  = new ArrayList<>();
    }

    Course addCourseToCurriculum() {

        int selectedCourseNumber;
        String gradeType;

        System.out.println("\nChoose which course to add to the curriculum:");
        for (int i = 0; i < CourseList.values().length; i++)
            System.out.println(i + 1 + ". " + CourseList.values()[i]);
        System.out.print("\nEnter your selection: ");
        do {
            selectedCourseNumber = Integer.parseInt(MainMenu.sc.nextLine());
            if (selectedCourseNumber < 1 || selectedCourseNumber > CourseList.values().length)
                System.out.print("\nYour input is invalid, enter a number from 1 to " + CourseList.values().length + ": ");
            else if (isCourseInCurriculum(selectedCourseNumber)) {
                System.out.print("\nThe selected course is already in the curriculum. Please choose another one: ");
            } else
                break;
        } while (true);

        System.out.print("\nDo you want the grades for the course to be [1] Integer or [2] Floating point? ");
        do {
            int selection = Integer.parseInt(MainMenu.sc.nextLine());
            if (selection == 1) {
                return new Course(CourseList.values()[selectedCourseNumber - 1],"integer");
            } else if (selection == 2) {
                return new Course(CourseList.values()[selectedCourseNumber - 1], "floating point");
            } else
                System.out.print("\nYour input is invalid. Please enter 1 or 2: ");
        } while (true);
    }

    boolean isCourseInCurriculum(int selectedCourseNumber) {
        for (var course : listOfCourses)
            if (course.getName().equals(CourseList.values()[selectedCourseNumber - 1]))
                return true;
        return false;
    }

    int selectionFrom(ArrayList list) {

        int selectedNumber;

        System.out.println("\nHere's the listing for the desired action:");
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + 1 + ". " + list.get(i));

        do {
            System.out.print("\nMake your selection: ");
            selectedNumber = Integer.parseInt(MainMenu.sc.nextLine());
            if (selectedNumber < 1 || selectedNumber > list.size())
                System.out.print("Your selection is invalid. Please enter a number from 1 to " + list.size() + ": ");
            else break;
        } while (true);

        return selectedNumber;
    }

    void showAvailableCourses () {
        System.out.println("\nHere's a list of available courses in the curriculum:");
        for (int i = 0; i < this.listOfCourses.size(); i++)
            System.out.println(this.listOfCourses.get(i).toString());
    }
}
