import java.util.Date;

public class computer {
    private String serilNumber;
    public Date purchasedDate;
    protected boolean isGood = true;
    Room room;

    public computer(String serilNumber, Date purchased, Room room) {
        this.serilNumber = serilNumber;
        this.purchasedDate = purchased;
        this.room = room;
    }

    public void updateStatus(boolean b) {
        isGood = b;
    }

    public boolean checkCondition() {
        return isGood;
    }
}
