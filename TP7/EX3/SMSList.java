import java.util.ArrayList;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SMSList {
    int initialize = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> SMSes = new ArrayList<>();

    public void readMenuEn() {
        System.out.println("1. Send new SMS with Encrypted content using password method\n" +
                "2. View SMS detail\n" +
                "3. List SMSes\n" +
                "4. Remove SMSes by index\n" +
                "5. Quit\n");
        System.out.print("Enter the option: ");
    }

    public void add() {
        String subject, from_tel, recieve_tel, passwd, type, content, status;
        System.out.println("Add Information");
        System.out.print("Enter password to encryt ur message: ");
        passwd = sc.nextLine();
        System.out.print("Subject: ");
        subject = sc.nextLine();
        System.out.print("Phone number: ");
        from_tel = sc.nextLine();
        System.out.print("Recieve number: ");
        recieve_tel = sc.nextLine();

        System.out.print("Type message(text/mms): ");
        type = sc.nextLine();
        System.out.print("Content: ");
        content = sc.nextLine();
        System.out.print("Status(new/read): ");
        status = sc.nextLine();
        SMS sms = new SMS(subject, from_tel, recieve_tel, type, content, status);
        System.out.println(sms.toString());
        EncryptMessage encryptMessage = new EncryptMessage(sms.toString(), passwd);
        SMSes.add(encryptMessage.encryptMessage());
        System.out.println("SMS is sent");
    }

    public void show() {
        int i = 0;
        for (String sms : SMSes) {
            System.out.println("index =" + i + "\t" + sms + "\n\n");
            i += 1;
        }
        if (SMSes.isEmpty()) {
            System.out.println("No SMS");
        }
    }

    public String findByIndex(int index) {
        int i = 0;
        for (String sms : SMSes) {
            if (index == i) {
                return sms;
            }
            i++;
        }
        return null;
    }

    public void viewDetail() {
        int index;
        show();
        System.out.println("Find detail in Encryption");
        System.out.print("Please enter by index to find specific msg:");
        index = sc.nextInt();
        String s = findByIndex(index);
        if (s != null)
            System.out.println("Message content:" + s + "\n\n");
        else
            System.out.println("Message is not found at index " + index);
    }

    public void remove() {
        int index;
        show();
        System.out.println("Use index/order to remove");
        System.out.print("Index at:");
        index = sc.nextInt();
        String s = findByIndex(index);
        if (s != null) {
            System.out.println("SMS at index " + index + " is removed");
            deleteFile(index);
            SMSes.remove(s);
            initialize += 1;
        } else
            System.out.println("SMS at index " + index + " is not found");
    }

    public void deleteFile(int s) {
        try {

            File files = new File("./Data");
            System.out.println(files.list().length);
            for (int i = 0; i < files.list().length; i++) {
                File myFile = new File("./Data/SMS" + i + ".txt");
                Scanner reader = new Scanner(myFile);
                String data = reader.nextLine();
                if (i == s) {
                    System.out.println(s);
                    myFile.delete();
                }
            }
        } catch (Exception e) {
            // System.out.println("cant found the file");
            e.printStackTrace();
        }
    }

    public void loadSMS() {
        try {

            File files = new File("./Data");
            // System.out.println(files.list().length);
            for (int i = 0; i < files.list().length; i++) {
                File myFile = new File("./Data/SMS" + i + ".txt");
                Scanner reader = new Scanner(myFile);
                String data = reader.nextLine();
                SMSes.add(data);
            }
        } catch (Exception e) {
            System.out.println("Cant found the file");
            e.printStackTrace();
        }
    }

    public void writeInFile() {
        try {
            int i = 0;
            for (String myobj : SMSes) {
                FileWriter myWriter = new FileWriter("./Data/SMS" + i + ".txt");
                myWriter.write(myobj);
                i++;
                myWriter.close();
            }

        } catch (IOException e) {
            System.out.println("Error occured.");
            e.printStackTrace();
        }
    }
}
