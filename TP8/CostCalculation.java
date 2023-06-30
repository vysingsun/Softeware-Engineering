import java.util.Scanner;

public class CostCalculation {

    boolean isNumber(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    boolean isPositive(double price) {
        if (price > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CostCalculation c = new CostCalculation();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nInput total buying cost: ");
            String price = sc.nextLine();
            if (c.isNumber(price)) {
                double p = Double.valueOf(price);
                if (c.isPositive(p)) {
                    if (p < 10) {

                        double dis = 0.0;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Total discount: " + dis + " $");

                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + p + " $");
                    } else if (p >= 10 && p < 30) {
                        Double dis = 5.0;
                        Double total_dis;
                        Double total_pay;

                        total_dis = (p * dis) / 100;
                        total_pay = p - total_dis;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Discount: " + dis + " %");
                        System.out.println("Total discount: " + total_dis + " $");
                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + total_pay + " $");
                    } else if (p >= 30 && p < 80) {
                        Double dis = 10.0;
                        Double total_dis;
                        Double total_pay;

                        total_dis = (p * dis) / 100;
                        total_pay = p - total_dis;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Discount: " + dis + " %");
                        System.out.println("Total discount: " + total_dis + " $");
                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + total_pay + " $");
                    } else if (p >= 80 && p < 150) {
                        Double dis = 15.0;
                        Double total_dis;
                        Double total_pay;

                        total_dis = (p * dis) / 100;
                        total_pay = p - total_dis;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Discount: " + dis + " %");
                        System.out.println("Total discount: " + total_dis + " $");
                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + total_pay + " $");
                    } else if (p >= 150 && p < 300) {
                        Double dis = 20.0;
                        Double total_dis;
                        Double total_pay;

                        total_dis = (p * dis) / 100;
                        total_pay = p - total_dis;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Discount: " + dis + " %");
                        System.out.println("Total discount: " + total_dis + " $");
                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + total_pay + " $");
                    } else if (p >= 300) {
                        Double dis = 25.0;
                        Double total_dis;
                        Double total_pay;

                        total_dis = (p * dis) / 100;
                        total_pay = p - total_dis;
                        System.out.println("\nTotal cost: " + p + " $");
                        System.out.println("Discount: " + dis + " %");
                        System.out.println("Total discount: " + total_dis + " $");
                        System.out.println("-------------------------");
                        System.out.println("Total patment: " + total_pay + " $");
                    }
                }
            } else {
                System.out.println("\nCost must be positive.");
                System.out.print("\nInput total buying cost: ");
                price = sc.nextLine();
                if (c.isNumber(price)) {
                    double p = Double.valueOf(price);
                    if (c.isPositive(p)) {
                        if (p < 10) {

                            double dis = 0.0;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Total discount: " + dis + " $");

                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + p + " $");
                        } else if (p >= 10 && p < 30) {
                            Double dis = 5.0;
                            Double total_dis;
                            Double total_pay;

                            total_dis = (p * dis) / 100;
                            total_pay = p - total_dis;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Discount: " + dis + " %");
                            System.out.println("Total discount: " + total_dis + " $");
                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + total_pay + " $");
                        } else if (p >= 30 && p < 80) {
                            Double dis = 10.0;
                            Double total_dis;
                            Double total_pay;

                            total_dis = (p * dis) / 100;
                            total_pay = p - total_dis;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Discount: " + dis + " %");
                            System.out.println("Total discount: " + total_dis + " $");
                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + total_pay + " $");
                        } else if (p >= 80 && p < 150) {
                            Double dis = 15.0;
                            Double total_dis;
                            Double total_pay;

                            total_dis = (p * dis) / 100;
                            total_pay = p - total_dis;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Discount: " + dis + " %");
                            System.out.println("Total discount: " + total_dis + " $");
                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + total_pay + " $");
                        } else if (p >= 150 && p < 300) {
                            Double dis = 20.0;
                            Double total_dis;
                            Double total_pay;

                            total_dis = (p * dis) / 100;
                            total_pay = p - total_dis;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Discount: " + dis + " %");
                            System.out.println("Total discount: " + total_dis + " $");
                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + total_pay + " $");
                        } else if (p >= 300) {
                            Double dis = 25.0;
                            Double total_dis;
                            Double total_pay;

                            total_dis = (p * dis) / 100;
                            total_pay = p - total_dis;
                            System.out.println("\nTotal cost: " + p + " $");
                            System.out.println("Discount: " + dis + " %");
                            System.out.println("Total discount: " + total_dis + " $");
                            System.out.println("-------------------------");
                            System.out.println("Total patment: " + total_pay + " $");
                        }
                    }
                }
            }
        }
    }
}
// all is correct
