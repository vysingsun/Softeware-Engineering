public class Users extends Model {
    private String username;
    private String pwd;
    private Roles roles;
    private String token;
    private Groups groups;
    private String remote_addr;
    private String forward_addr;
    private String image;

    public Users(int id, String username, String pwd, Roles roles, String token, Groups groups, String remote_addr,
            String forward_addr, String image) {
        super(id);
        this.username = username;
        this.pwd = pwd;
        this.roles = roles;
        this.token = token;
        this.groups = groups;
        this.remote_addr = remote_addr;
        this.forward_addr = forward_addr;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getRemote_addr() {
        return remote_addr;
    }

    public void setRemote_addr(String remote_addr) {
        this.remote_addr = remote_addr;
    }

    public String getForward_addr() {
        return forward_addr;
    }

    public void setForward_addr(String forward_addr) {
        this.forward_addr = forward_addr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
