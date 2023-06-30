import java.util.Scanner;

public class CE2 {
    Scanner sc = new Scanner(System.in);
    private String sentence;

    public void getinput() {
        System.out.print("Input a sentence: ");
        sentence = sc.nextLine();
    }

    public void encoder() {
        String removeSpecialChars = sentence.replaceAll("[^a-zA-Z0-9]", " ");
        System.out.println("Text message:");
        System.out.printf("%s\n\n", removeSpecialChars);
    }

    public void decoderString() {
        System.out.println("The Original message:");
        System.out.println(sentence);
    }
}

class MessageCoder {

    public static void main(String[] args) {
        CE2 t1 = new CE2();
        t1.getinput();
        t1.encoder();
        t1.decoderString();
    }
}