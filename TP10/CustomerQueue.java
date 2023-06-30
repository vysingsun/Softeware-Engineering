import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerQueue {
    private Deque<Customer> customers = new LinkedList<>();

    public Deque<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(Deque<Customer> customers) {
        this.customers = customers;
    }

    public int getCustomersCount() {
        return customers.size();
    }

    public void addNewCustomer() throws Exception {
        if (getCustomersCount() <= 100) {
            Customer customer = new Customer();
            customer.inputData();
            customers.add(customer);
        } else {
            System.out.println("There're 100 customers already can't be add to queue!");
        }
    }

    public void removeCustomer() {
        CustomerOrder customerO = new CustomerOrder();
        Customer customer = customers.getFirst();
        OrderStatus Waiting_for_food = OrderStatus.valueOf("Waiting_for_food");
        customer.setStatus(Waiting_for_food);
        customerO.setCustomer(customer);
        customers.removeFirst();
    }

    public void serveCustomer(CustomerOrder customerO) {
        Customer customer = customerO.getCustomer();
        OrderStatus Waiting_for_food = OrderStatus.valueOf("Waiting_for_food");
        customer.setStatus(Waiting_for_food);
    }

    public void displayCustomerInQueue() {
        for (Customer customer : customers) {
            System.out.println("Customer_NO: " + customer.getNumber() +
                    "\nDate: " + customer.getDate_enter().getTime() +
                    "\nStatus: " + customer.getStatus().toString());
        }
    }
}
