package terhands.recipebook.browse;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

import terhands.recipebook.R;
import terhands.recipebook.models.Recipe;

public class BrowseRecipesActivity extends Activity {

    private ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_recipes);
        init();
    }

    private void init() {
        holder = new ViewHolder(this);
        holder.recipesList.setAdapter(new RecipesAdapter(this, Recipe.hook_createSampleRecipes()));

        // Adapter
        SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_dropdown_item_1line);

        // Callback
        ActionBar.OnNavigationListener callback = new ActionBar.OnNavigationListener() {

            String[] items = getResources().getStringArray(R.array.categories); // List items from res

            @Override
            public boolean onNavigationItemSelected(int position, long id) {
                // Do stuff when navigation item is selected
                Log.d("NavigationItemSelected", items[position]); // Debug
                return true;

            }

        };

        // Action Bar
        ActionBar actions = getActionBar();
        actions.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actions.setListNavigationCallbacks(adapter, callback);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.browse_recipes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ViewHolder {

        public final ListView recipesList;

        public ViewHolder(Activity a) {
            recipesList = (ListView) a.findViewById(R.id.abr_recipe_list);
        }
    }
}
