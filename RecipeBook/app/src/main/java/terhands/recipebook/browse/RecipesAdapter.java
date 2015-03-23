package terhands.recipebook.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import terhands.recipebook.R;
import terhands.recipebook.models.Recipe;


public class RecipesAdapter extends BaseAdapter {

    private Context context;
    private List<Recipe> recipes;

    public RecipesAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return recipes != null ? recipes.size() : 0;
    }

    @Override
    public Recipe getItem(int i) {
        return isValidIndex(i) ? recipes.get(i) : null;
    }

    private boolean isValidIndex(int index) {
        return recipes != null && index >= 0 && index < recipes.size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.cell_recipe, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        populateCell(holder, i);
        return view;
    }

    private void populateCell(ViewHolder holder, int position) {
        Recipe r = getItem(position);

        holder.recipeName.setText(r.getName());
        holder.recipeCategory.setText(r.getCategory().name());
        holder.recipeThumbnail.setImageBitmap(r.getPhoto(context));
    }

    private class ViewHolder {

        public final TextView recipeName;
        public final TextView recipeCategory;
        public final ImageView recipeThumbnail;

        public ViewHolder(View v) {
            recipeName = (TextView) v.findViewById(R.id.cr_recipe_name);
            recipeCategory = (TextView) v.findViewById(R.id.cr_category);
            recipeThumbnail = (ImageView) v.findViewById(R.id.cr_recipe_picture);
        }
    }
}
