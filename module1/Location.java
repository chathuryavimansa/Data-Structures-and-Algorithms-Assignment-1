package module1;

/**
 * Location class - represents a city location
 */
public class Location {
    private String name;
    private String description;
    
    public Location(String name) {
        this.name = name;
        this.description = "";
    }
    
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public String toString() {
        return name + (description.isEmpty() ? "" : " (" + description + ")");
    }
}
