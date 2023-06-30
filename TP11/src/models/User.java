public class User extends Model {
    private String username;
    private String pass;
    private String email;

    private Role role;
    private short discount;
    private String avatar;

    public User(int id, String username, String pass, String email, Role role, short discount, String avatar) {
        super(id);
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.avatar = avatar;
        this.discount = discount;
        this.role = role;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

}
