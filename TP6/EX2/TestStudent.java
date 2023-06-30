import java.util.*;

public class TestStudent {

    public static void main(String[] args) {
        ListStudents listStudent = new ListStudents();
        int choice, i = 0;
        String name, id;
        Scanner sc = new Scanner(System.in);
        while (true) {
            listStudent.createMenu();
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Input student's ID(e20230001): ");
                id = sc.nextLine();
                id = sc.nextLine();
                System.out.print("Input student's name: ");
                name = sc.nextLine();

                Students student = new Students(id, name);
                i++;
                listStudent.addStudents(student);
            } else if (choice == 2) {
                listStudent.displayListStudents();
            } else if (choice == 3) {
                listStudent.displayListStudents();
                System.out.print("Input student's name to delete:");
                name = sc.nextLine();
                name = sc.nextLine();
                listStudent.removeStudentsByName(name);
            } else if (choice == 4) {
                listStudent.displayListStudents();
                System.out.print("Input student's id to update:");
                id = sc.nextLine();
                id = sc.nextLine();
                listStudent.updateStudentsInfoByID(id);
            } else if (choice == 5) {
                System.out.println("Good luck!");
                break;
            }
        }
    }
}
