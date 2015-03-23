package terhands.recipebook.models;

public class Ingredient {

    private String name;
    private String description;

    public Ingredient(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

}
