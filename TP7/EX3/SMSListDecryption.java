import java.util.ArrayList;

public class SMSListDecryption extends SMSList {

    @Override
    public void viewDetail() {
        String password;
        int index;
        show();
        System.out.println("Use password to decrypt message:");
        System.out.print("Enter password:");
        password = sc.nextLine();
        System.out.print("index at:");
        index = sc.nextInt();
        String s = findByIndex(index);
        if (s != null) {
            DecryptionMessage message = new DecryptionMessage(s, password);
            if (message.decryptMessage() != null)
                System.out.println("index=" + index + "\t" + message.decryptMessage());
            else
                System.out.println("At index " + index + "bad password");
        } else
            System.out.println("at index " + index + " there is no file");
    }

    public void showDecryptionMessage() {
        String password;
        int index = 0;
        System.out.println("Using password to show all readable info");
        System.out.print("Enter password:");
        password = sc.nextLine();
        for (String sms : SMSes) {
            DecryptionMessage message = new DecryptionMessage(sms, password);
            if (message.decryptMessage() != null)
                System.out.println("index=" + index + "\t" + message.decryptMessage());
            else
                System.out.println("At index " + index + "bad password");
            index += 1;
        }
    }
}