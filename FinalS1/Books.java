public class Books extends Model {
    private String title;
    private String path;
    private Users users;
    private Groups groups;
    private Publishers publishers;

    public Books(int id, String title, String path, Users users, Groups groups, Publishers publishers) {
        super(id);
        this.title = title;
        this.path = path;
        this.users = users;
        this.groups = groups;
        this.publishers = publishers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

}
