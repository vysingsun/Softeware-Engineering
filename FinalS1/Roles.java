public class Roles extends Model {
    private String rolename;

    public Roles(int id, String rolename) {
        super(id);
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
