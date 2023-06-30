public class Exercise2 {
    public static void main(String[] args) {
        // Name: SUN VYSING ID: e20191124
        String x = "\n";
        System.out.printf("\n%cn \t Line break.", 92);
        System.out.printf("\n%ct \t Tabulation.", 92);
        System.out.printf("\n%c%c \t Single Quote.", 92, 39);
        System.out.printf("\n%c%c \t Double Quote.", 92, 34);
        System.out.printf("\n%c%c \t %c Sign.", 92, 92, 92);
        System.out.printf("\n%c%c%c%c \t %c%c Sign.", 92, 92, 92, 92, 92, 92);
        System.out.printf("\n%c%c \t Line Comment.", 92, 92);
        System.out.printf("\n/* ... */ \t Block Comment.");
        System.out.printf("\n%c%c%c\n \t Text block.\n%c%c%c\n", 34, 34, 34, 34, 34, 34);
    }
}
