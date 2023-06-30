public class fieldUtil {
    public static void checkNull_Empty_blank(String field, String label) {
        if (field == null) {
            throw new NullPointerException(label + " shouldn't be null.");
        }
        if (field.isEmpty() || field.isBlank()) {
            throw new IllegalArgumentException(label + " shouldn't be empty or blank.");
        }
    }
}
