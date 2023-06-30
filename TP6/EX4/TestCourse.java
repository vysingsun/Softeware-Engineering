import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListCourse listCourse = new ListCourse();
        int option, i = 0;
        String id, name, teacher;
        while (true) {
            listCourse.displayMenu();
            option = sc.nextInt();
            if (option == 1) {
                listCourse.listAllCourse();
            } else if (option == 2) {
                System.out.print("Enter name course to search: ");
                sc.nextLine();
                name = sc.nextLine();
                listCourse.findCourseByName(name);
            } else if (option == 3) {
                System.out.println("3. Add a course");
                System.out.print("Enter a ID course: ");
                id = sc.nextLine();
                id = sc.nextLine();
                System.out.print("Enter a name course: ");
                name = sc.nextLine();
                System.out.print("Enter a teacher name of this course: ");
                teacher = sc.nextLine();
                Course course = new Course(id, name, teacher);
                i++;
                listCourse.addCourse(course);
            } else if (option == 4) {
                System.out.println("Chom Reab Lear!!!");
                break;
            }
        }
    }
}
