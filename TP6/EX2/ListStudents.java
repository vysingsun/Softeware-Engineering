import java.util.*;

public class ListStudents {
    List<Students> students = new ArrayList<Students>();
    Scanner sc = new Scanner(System.in);

    public List<Students> listAllStudents() {
        return students;
    }

    public Students getAStudents(int i) {
        return listAllStudents().get(i);
    }

    public void addStudents(Students student) {
        students.add(student);
        System.out
                .println("Student's name: " + student.getName() + " which ID: " + student.getId() + " has been added.");
    }

    public void deleteAllStudents() {
        students.removeAll(students);
    }

    public void displayListStudents() {
        int i = 0;
        System.out.println("\nStudent List: ");
        System.out.println("NO\tID\t\tName");
        for (Students student : listAllStudents()) {
            System.out.println((i + 1) + "\t" + student.getId() + "\t" + student.getName());
            i++;
        }
        if (listAllStudents().isEmpty()) {
            System.out.println("Students didn't add to list.");
        } else {
            System.out.println();
        }
    }

    public void removeStudentsByName(String name) {
        int d = 0;
        Iterator<Students> itr = students.iterator();
        while (itr.hasNext()) {
            Students student = itr.next();
            if (name.equals(student.getName())) {
                System.out.println(
                        "Student ID: " + student.getId() + " Student Name: " + student.getName() + " has been delete.");
                itr.remove();
                d = 1;
            }
        }
        if (d == 0) {
            System.out.println("There is not a student name: " + name);
        }
    }

    public void updateStudentsInfoByID(String id) {
        int up = 0;
        Iterator<Students> itr = students.iterator();
        while (itr.hasNext()) {
            Students student = itr.next();
            if (id.equals(student.getId())) {
                System.out.println(
                        "Student ID: " + student.getId() + " Student Name: " + student.getName() + " is will update.");
                System.out.printf("Enter a new student name: ");
                String name = sc.next();
                student.setName(name);
                up = 1;
            }
        }
        if (up == 0) {
            System.out.println("There is not a student ID: " + id);
        }
    }

    public void createMenu() {
        System.out.println("Student List \n");
        System.out.println("1. Add new student\n" +
                "2. List students\n" +
                "3. Remove student by name\n" +
                "4. Update student information by id\n"
                + "5. Quit");
        System.out.print("Enter a choice[1-5]:");
    }
}
