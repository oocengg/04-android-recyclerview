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
        data = new RecipeData(getString(R.string.nasi_goreng), getString(R.string.nasi_goreng_description), R.drawable.nasigoreng, getString(R.string.nasi_goreng_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.semur_ayam_name), getString(R.string.semur_ayam_description), R.drawable.semurayam, getString(R.string.semur_ayam_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.orek_tempe_name), getString(R.string.orek_tempe_description), R.drawable.orektempe, getString(R.string.orek_tempe_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.semur_bandeng_name), getString(R.string.semur_bandeng_description), R.drawable.semurbandeng, getString(R.string.semur_bandeng_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.udang_saos_name), getString(R.string.udang_saos_description), R.drawable.udangsaos, getString(R.string.udang_saos_details));
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