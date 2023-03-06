package Characterizations;

public abstract class Characterizations {
    private String type;
    private String name;
    private String description;

    public Characterizations(String type, String name, String description){
        this.type = type;
        this.name=name;
        this.description=description;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
