import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListCourse {
    
    ArrayList<Course> courses = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // add a course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course has been added.");
    }

    public ArrayList<Course> getListCourse() {
        return courses;
    }

    // display all course
    public void listAllCourse() {
        int i = 0;
        if (getListCourse().isEmpty()) {
            System.out.println("\nThere is no course.");
        } else {
            System.out.println("\nrID\tID\tCourse\tTeacher");
            for (Course courses : getListCourse()) {
                System.out
                        .println((i + 1) + "\t" + courses.getId() + "\t" + courses.getName() + "\t"
                                + courses.getTeacher());
                i = i + 1;
            }
        }
    }

    // find a course by search name
    public void findCourseByName(String name) {
        int i = 0;
        int check = 0;
        Iterator<Course> itr = getListCourse().iterator();
        System.out.println("\nrID\tID\tCourse\tTeacher");
        System.out.println("");
        while (itr.hasNext()) {
            Course courses = itr.next();
            if (name.equals(courses.getName())) {

                System.out.println(
                        (i + 1) + "\t" + courses.getId() + "\t" + courses.getName() + "\t" + courses.getTeacher());
                i = i + 1;
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("There is no " + name + " in Course List.");
        }
    }

    // Create menu
    public void displayMenu() {
        System.out.println("\nProgram for all courses\n" +
                "1.List all courses\n" +
                "2.Find courses by name\n" +
                "3.Add new course\n" +
                "4.Quit");
        System.out.print("Enter choices:");
    }
}
