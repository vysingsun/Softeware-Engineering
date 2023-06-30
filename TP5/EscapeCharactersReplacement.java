import java.util.Scanner;

public class EscapeCharactersReplacement {
    Scanner sc = new Scanner(System.in);
    private String sentence;

    public void readString() {
        System.out.print("Please enter a sentence: ");
        sentence = sc.nextLine();
    }

    public void checkAndDisplayResult() {
        if (sentence.indexOf(":)") > -1)
            sentence = sentence.replace(":)", "(smile)");
        if (sentence.indexOf("\\n") > -1)
            sentence = sentence.replace("\\n", "(new_line)");
        if (sentence.indexOf("\\t") > -1)
            sentence = sentence.replace("\\t", "(tab)");
        if (sentence.indexOf("\\") > -1)
            sentence = sentence.replace("\\\\", "(slash)");
        if (sentence.indexOf("//") > -1)
            sentence = sentence.replace("//", "(command_line)");
        System.out.printf("\n%s", sentence);
    }
}

class SymbolReplaceText {
    public static void main(String[] args) {
        EscapeCharactersReplacement replace = new EscapeCharactersReplacement();
        replace.readString();
        replace.checkAndDisplayResult();
    }
}
