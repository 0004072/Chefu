package com.hsenidmobile.romeosierra.chefu.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.chefu.ShowItemActivity;
import com.hsenidmobile.romeosierra.chefu.adapters.FoodItemCardAdapter;
import com.hsenidmobile.romeosierra.chefu.model.Food;
import com.hsenidmobile.romeosierra.chefu.model.FoodItem;
import com.hsenidmobile.romeosierra.chefu.utils.FoodItemFetchClient;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kanchana on 5/2/17.
 */

public class FetchFoodItemsAsyncTask extends AsyncTask<Object, Object, ArrayList<FoodItem>> {
    private ProgressDialog progressDialog;
    private Context context;
    private GridView gridView;
    private String url;
    public static final String FOOD_ITEM_OBJECT = "selectedFoodItem";

    public FetchFoodItemsAsyncTask(Context context, GridView gridView, String url) {
        this.context = context;
        this.gridView = gridView;
        this.url = url;
    }

    @Override
    protected ArrayList<FoodItem> doInBackground(Object ... params) {
        ArrayList<FoodItem> response = new ArrayList<>();
        FoodItemFetchClient req = new FoodItemFetchClient();
        Object obj = req.fetchData(url);

        if(obj instanceof Food) {
            Food food = (Food)obj;
            response = food.getFood();
        }
        return response;
    }

    @Override
    protected void onPreExecute(){
        progressDialog = ProgressDialog.show(context, "Wait!", "Data fetching in progress...");
    }

    @Override
    protected void onPostExecute(ArrayList<FoodItem> result){
        String message = "Failed to fetch data. Unknown Error!";
        if(result.size() > 0)
            message = String.format(Locale.US, "Successfully fetched %d items!", result.size());
        progressDialog.dismiss();
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();

        FoodItemCardAdapter ia = new FoodItemCardAdapter(context, result);
        gridView.setAdapter(ia);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodItem item = (FoodItem) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(context, ShowItemActivity.class);
                intent.putExtra(FOOD_ITEM_OBJECT, item);
                context.startActivity(intent);
            }
        });
    }
}