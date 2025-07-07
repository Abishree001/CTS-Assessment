public class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }
    public String getGrade() { return grade; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setGrade(String grade) { this.grade = grade; }
}
