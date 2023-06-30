import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDateTime {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        Calendar cal = Calendar.getInstance();
        cal.set(2001, Calendar.MAY, 24);
        System.out.println(cal.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dateFormat.format(cal.getTime()));
    }
}
