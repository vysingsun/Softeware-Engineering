import java.util.Scanner;

public class Shipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter distance A to B in km: ");
        int aTob = sc.nextInt();
        System.out.printf("Enter distance B to C in km: ");
        int bToc = sc.nextInt();
        System.out.printf("Enter weight of ship in kg: ");
        int weight = sc.nextInt();

        int liter_used_aTob;
        int liter_used_bToc;
        int remaining_liter;
        int liter_refill;
        if (weight <= 5000) {
            if (aTob <= 500) {
                liter_used_aTob = aTob * 10;
                liter_used_bToc = bToc * 10;
                remaining_liter = 5000 - liter_used_aTob - liter_used_bToc;
                liter_refill = remaining_liter / (-1);
                if (liter_refill <= 0) {
                    System.out.println("The minimum number of liters needed to refill at point B are 0 liters");
                } else if (liter_refill > 0 && liter_refill <= 5000 && bToc <= 500) {
                    System.out.printf("The minimum number of liters needed to refill at point B are %d liters",
                            liter_refill);
                } else if (bToc > 500) {
                    System.out.println("Ship at point B can't reach to C");
                }
            } else if (aTob > 500) {
                System.out.println("Ship at point A can't reach to B");
            }
        } else if (weight > 5000 && weight <= 10000) {
            if (aTob <= 250) {
                liter_used_aTob = aTob * 20;
                liter_used_bToc = bToc * 20;
                remaining_liter = 5000 - liter_used_aTob - liter_used_bToc;
                liter_refill = remaining_liter / (-1);
                if (liter_refill <= 0) {
                    System.out.println("The minimum number of liters needed to refill at point B are 0 liters");
                } else if (liter_refill > 0 && liter_refill <= 5000 && bToc <= 250) {
                    System.out.printf("The minimum number of liters needed to refill at point B are %d liters",
                            liter_refill);
                } else if (bToc > 250) {
                    System.out.println("Ship at point B can't reach to C");
                }
            } else if (aTob > 250) {
                System.out.println("Ship at point A can't reach to B");
            }
        } else if (weight > 10000 && weight <= 20000) {
            if (aTob <= 200) {
                liter_used_aTob = aTob * 25;
                liter_used_bToc = bToc * 25;
                remaining_liter = 5000 - liter_used_aTob - liter_used_bToc;
                liter_refill = remaining_liter / (-1);
                if (liter_refill <= 0) {
                    System.out.println("The minimum number of liters needed to refill at point B are 0 liters");
                } else if (liter_refill > 0 && liter_refill <= 5000 && bToc <= 200) {
                    System.out.printf("The minimum number of liters needed to refill at point B are %d liters",
                            liter_refill);
                } else if (bToc > 200) {
                    System.out.println("Ship at point B can't reach to C");
                }
            } else if (aTob > 200) {
                System.out.println("Ship at point A can't reach to B");
            }
        } else if (weight > 20000 && weight <= 30000) {
            if (aTob <= 142) {
                liter_used_aTob = aTob * 35;
                liter_used_bToc = bToc * 35;
                remaining_liter = 5000 - liter_used_aTob - liter_used_bToc;
                liter_refill = remaining_liter / (-1);
                if (liter_refill <= 0) {
                    System.out.println("The minimum number of liters needed to refill at point B are 0 liters");
                } else if (liter_refill > 0 && liter_refill <= 5000 && bToc <= 142) {
                    System.out.printf("The minimum number of liters needed to refill at point B are %d liters",
                            liter_refill);
                } else if (bToc > 142) {
                    System.out.println("Ship at point B can't reach to C");
                }
            } else if (aTob > 142) {
                System.out.println("Ship at point A can't reach to B");
            }
        } else if (weight > 30000) {
            System.out.println("Cannot be loaded");
        }
    }
}
