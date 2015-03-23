package terhands.recipebook.models;

public class RecipeIngredient {

    private Ingredient ingredient;
    private int quantity;
    private Unit unitOfMeasurement;

    public RecipeIngredient(Ingredient ingredient, int quantity, Unit unitOfMeasurement) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
}
