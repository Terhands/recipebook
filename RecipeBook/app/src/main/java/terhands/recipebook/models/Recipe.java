package terhands.recipebook.models;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import terhands.recipebook.R;

public class Recipe {

    private String name;
    private Category category;
    private String photoLocation;

    private String instructions;
    private List<RecipeIngredient> ingredientsList = new ArrayList<RecipeIngredient>();

    public Recipe(String name, Category category, String instructions, List<RecipeIngredient> ingredients) {
        this.name = name;
        this.category = category;
        this.instructions = instructions;
        this.ingredientsList.addAll(ingredients);
    }

    public void setRecipePhoto(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Bitmap getPhoto(Context context) {
        // TODO: implement this
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
    }

    public static List<Recipe> hook_createSampleRecipes() {

        List<Recipe> samples = new ArrayList<Recipe>();

        List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(new Ingredient("sugar", "it's sugar"), 1, Unit.tsp));
        ingredients.add(new RecipeIngredient(new Ingredient("flour", "all purpose"), 4, Unit.cup));

        for(Category c : Category.values()) {
            for (int i = 0; i < 5; i++) {
                Recipe r = new Recipe("Recipe Name", c, "Step 1: cook some stuff...", ingredients);
                samples.add(r);
            }
        }

        return samples;
    }

}
