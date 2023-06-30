import java.util.Scanner;

public class MainSMSEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SMSList smses = new SMSList();
        smses.loadSMS();
        int option;
        do {
            smses.readMenuEn();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    smses.add();
                    break;
                case 2:
                    smses.viewDetail();
                    break;
                case 3:
                    smses.show();
                    break;
                case 4:
                    smses.remove();
                    break;
                case 5:
                    smses.writeInFile();
                    System.out.println("Good luck!!!");
                    break;
                default:
                    break;
            }
        } while (option != 5);

    }
}