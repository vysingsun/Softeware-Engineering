
//import java.text.SimpleDateFormat;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.text.*;

public class Student {
    private String name;
    private Date dob;
    private String tel;
    private String city, country, group;

    // private Group group;
    public Student() {

    }

    public Student(String name, Date dob, String tel, String city, String country, String group)
            throws BirthDateException {
        setName(name);
        setCity(city);
        setCountry(country);
        setTel(tel);
        setGroup(group);
        setDob(dob);
    }

    public static Student dataInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        System.out.print("Enter a name: ");
        student.setName(sc.nextLine());

        System.out.print("Enter a phone number: ");
        student.setTel(sc.nextLine());

        System.out.print("Enter a city: ");
        student.setCity(sc.nextLine());

        System.out.print("Enter a country: ");
        student.setCountry(sc.nextLine());

        System.out.print("Enter a group's name: ");
        student.setGroup(sc.nextLine());

        System.out.print("Enter a date(dd/mm/yyyy): ");
        Date d = new SimpleDateFormat("dd/mm/yyyy").parse(sc.nextLine());
        student.setDob(d);

        return student;
    }

    public String toString() {
        return "Student Lists\nName\t\tCity\t\tCountry\t\tGroup\t\tDate\t\t\t\tPhone numbre\n"
                + name + "\t\t" + city + "\t" + country + "\t" + group + "\t\t" + dob + "\t" + tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        fieldUtil.checkNull_Empty_blank(name, "name");
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) throws BirthDateException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 12);
        Date twelveYearsOlD = cal.getTime();
        if (dob.compareTo(twelveYearsOlD) <= 0) {
            this.dob = dob;
        } else {
            throw new BirthDateException();
        }

    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        fieldUtil.checkNull_Empty_blank(tel, "Phone number");
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        fieldUtil.checkNull_Empty_blank(city, "city");
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        fieldUtil.checkNull_Empty_blank(country, "country");
        this.country = country;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}