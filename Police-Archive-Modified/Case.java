
public class Case {
    private int id;
    private String name;
    private String category;
    private int year;
    private String victim;
    private int createdBy;

    public Case(int id, String name, String category, int year, String victim, int createdBy) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.year = year;
        this.victim = victim;
        this.createdBy = createdBy;
    }

    public String getCategory() {
        return category;
    }
}
