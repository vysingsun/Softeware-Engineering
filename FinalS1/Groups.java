public class Groups extends Model {
    private String groupname;

    public Groups(int id, String groupname) {
        super(id);
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

}
