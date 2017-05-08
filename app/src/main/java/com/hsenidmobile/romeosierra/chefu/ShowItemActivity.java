package com.hsenidmobile.romeosierra.chefu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.chefu.model.FoodItem;
import com.hsenidmobile.romeosierra.chefu.tasks.FetchDataAsyncTask;

public class ShowItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.item_name);
        try {
            FoodItem foodItem = intent.getParcelableExtra(FetchDataAsyncTask.FOOD_ITEM_OBJECT);
            textView.setText("\"" + foodItem.getName() + "\"");
        } catch (Exception e) {
            Toast.makeText(null, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
