public class Students {
    private String id, name;
    static int students_count = 0;

    public Students(String id, String name) {
        this.id = id;
        this.name = name;
        students_count++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}