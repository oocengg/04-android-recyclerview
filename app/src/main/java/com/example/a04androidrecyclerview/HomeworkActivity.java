package com.example.a04androidrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a04androidrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.LinkedList;

public class HomeworkActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private ArrayList<RecipeData> recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        prepareRecipeList();
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(HomeworkActivity.this, recipeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recipeListAdapter);
        recipeListAdapter.setOnItemClickListener(onItemClickListener);
    }

    private void prepareRecipeList() {
        recipeList = new ArrayList<>();
        RecipeData data;
        data = new RecipeData(getString(R.string.moo_shu_name), getString(R.string.moo_shu_description), R.drawable.moo_shu_img, getString(R.string.moo_shu_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.grilled_shrimp_name), getString(R.string.grilled_shrimp_description), R.drawable.grilled_shrimp_img, getString(R.string.grilled_shrimp_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.sirloin_tips_name), getString(R.string.sirloin_tips_description), R.drawable.sirloin_tips_img, getString(R.string.sirloin_tips_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.squash_casserole_name), getString(R.string.squash_casserole_description), R.drawable.squash_casserole_img, getString(R.string.squash_casserole_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.slow_casserole_name), getString(R.string.slow_casserole_description), R.drawable.slow_casserole_img, getString(R.string.slow_casserole_details));
        recipeList.add(data);

    }

    public void openDetailActivity(int imageId, String details){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("image", imageId);
        intent.putExtra("details", details);
        startActivity(intent);
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            RecipeData thisRecipe = recipeList.get(position);
            openDetailActivity(thisRecipe.getImage(), thisRecipe.getDetails());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}