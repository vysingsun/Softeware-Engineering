public class Users extends Model {
    private String name;
    private String password;
    private String confirm_password;
    private String profile;

    public Users(int id, String name, String password, String confirm_password, String profile) {
        super(id);
        this.name = name;
        this.password = password;
        this.confirm_password = confirm_password;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
