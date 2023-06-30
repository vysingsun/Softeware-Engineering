import java.util.*;

public class PC {
    String brand, status;
    ArrayList<PC> Pcs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public PC(String brand, String status) {
        this.brand = brand;
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PC() {
        for (int i = 0; i < 20; i++) {
            if (i >= 1 && i <= 5 || i > 10 && i < 15) {
                PC pc = new PC("computer" + i, "good");
                Pcs.add(pc);
            } else {
                PC pc = new PC("computer" + i, "damage");
                Pcs.add(pc);
            }
        }
    }
}