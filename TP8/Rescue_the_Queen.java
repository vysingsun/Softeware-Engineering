import java.util.Scanner;

public class Rescue_the_Queen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Q1.You are on a horse in the way to rescue the princess, you face the first trial, here it is a small river. Next to it there are boat and a raft. Which one willyou take?\n(A. Boat, B. Raft)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("B")) {
                System.out.println(
                        "You took the raft, and it breaks in the middle of river because of the sharp rocks. Game over!!");
            } else if (input.equalsIgnoreCase("A")) {
                System.out.println("You took the boat and successfully crossed the rive");
                System.out.println(
                        " You pass into a dark jungle. In the jungle, you face the second trial, the road is broken into two 2 ways: Rocky Road and Muddy Road.Which road will you take?\n(A. Rocky Road, B. Muddy Road)");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("B")) {
                    System.out.println("The Muddy Road absorbed both the horse and you. Game over!!");
                } else if (input.equalsIgnoreCase("A")) {
                    System.out.println("The Rocky Road is a little hard to travel but you successfully crossed it");
                    System.out.println(
                            " You reach temple, you enterthe temple. A    person is attacking by a dragon! To move further, not paying to them of attention?\n(A. Yes, B. No) ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("A")) {
                        System.out.println(
                                "You try to pass past, but the dragonnoticesyour presence and transforms you into ashes. You are dead!!! GAME is over!!!");
                    } else if (input.equalsIgnoreCase("B")) {
                        System.out.println(
                                "Congratulation, you have passed all tests of honor. Princess gets to you!!!(Hero becomes the future king)");
                        System.out.println("You Win!");
                        break;
                    } else {
                        System.out.println("There is no that operation. Please try again");
                    }
                } else {
                    System.out.println("There is no that operation. Please try again");
                }
            } else {
                System.out.println("There is no that operation. Please try again");
            }
        }
    }

}
