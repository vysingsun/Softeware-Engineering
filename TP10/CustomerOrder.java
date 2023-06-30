import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;

public class CustomerOrder {
    private Customer customer;
    private String food;
    private double price;
    private Date durationServe;
    private Date startServe;
    private Date servDate;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDurationServe() {
        return durationServe;
    }

    public void setDurationServe(Date durationServe) {
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.setTime(startServe);
        d2.setTime(servDate);
        int min = (int) ChronoUnit.MINUTES.between(d1.toInstant(), d2.toInstant());
        this.durationServe = durationServe;
    }

    public Date getStartServe() {
        return startServe;
    }

    public void setStartServe(Date startServe) {
        this.startServe = startServe;
    }

    public Date getServDate() {
        return this.servDate;
    }

    public void setServDate(Date servDate) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(getStartServe());
        } catch (Exception e) {
        }
        cal.add(Calendar.MILLISECOND, -((int) servDate.getTime()));
        this.servDate = cal.getTime();
    }

    public void recordData() throws Exception {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        c.inputData();
        System.out.print("What do you like? :");
        String food = sc.nextLine();
        System.out.println("Amount to pay ($): ");
        double price = sc.nextDouble();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:m:s");
        System.out.print("Enter a date(dd/MM/yyyy H:m:s): ");
        try {
            setServDate(dateFormat.parse(sc.nextLine()));
        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println("You have been input wrong format!");
        }
        setDurationServe(durationServe);

    }

    public String toString() {
        return "Customer_NO:" + getCustomer().getNumber() +
                "\nStartServe:" + getStartServe() +
                "\nEnd Serve:" + getServDate() +
                "\nStatus" + customer.getStatus().toString() +
                "\nFood:" + getFood() +
                "\nPice:" + getPrice() +
                "\nDuration Serve:" + getDurationServe() + "\n";
    }
}
