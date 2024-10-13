package com.example.restaurantapp;

import android.os.Bundle;
import android.widget.AbsListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.adapter.FoodAdapter;
import com.example.restaurantapp.databinding.ActivityMainBinding;
import com.example.restaurantapp.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FoodAdapter foodAdapter;
    private ArrayList<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);
        foodAdapter = new FoodAdapter(foodList, this);
        recyclerViewFood.setAdapter(foodAdapter);
        getFood();
    }

    private void getFood(){

        Food food1 = new Food(
                R.drawable.food1,
                "Food 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "$ 120.00"
        );
        foodList.add(food1);

        Food food2 = new Food(
                R.drawable.food2,
                "Food 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "$ 80.00"
        );
        foodList.add(food2);

        Food food3 = new Food(
                R.drawable.food3,
                "Food 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "$ 70.00"
        );
        foodList.add(food3);

        Food food4 = new Food(
                R.drawable.food4,
                "Food 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "$ 45.00"
        );
        foodList.add(food4);

        Food food5 = new Food(
                R.drawable.food5,
                "Food 5",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "$ 50.00"
        );
        foodList.add(food5);
    }
}