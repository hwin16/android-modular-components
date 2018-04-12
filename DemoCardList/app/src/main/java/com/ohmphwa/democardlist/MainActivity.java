package com.ohmphwa.democardlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private String[] data = {
            "Rosetta Chicken",
            "Skinny Egg Salad Sliders",
            "Open Face Egg Salad",
            "Tandori Chicken",
            "Reshmi Chicken",
            "Pasta Prima Vera",
            "Tuna sandwich",
            "Steak",
            "Pork chop",
            "Southwestern egg rolls",
            "Chicken Marsala",
            "Jamaican Chicken",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO(6): Reference RecyclerView;
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_cards_view);

        CardViewAdapter adapter = new CardViewAdapter(data);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
