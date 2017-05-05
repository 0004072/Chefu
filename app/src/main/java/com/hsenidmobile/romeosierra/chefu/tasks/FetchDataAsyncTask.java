package com.hsenidmobile.romeosierra.chefu.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.chefu.adapters.ImageAdapter;
import com.hsenidmobile.romeosierra.chefu.model.Food;
import com.hsenidmobile.romeosierra.chefu.model.FoodItem;
import com.hsenidmobile.romeosierra.chefu.utils.DataFetchClient;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kanchana on 5/2/17.
 */

public class FetchDataAsyncTask extends AsyncTask<Object, Object, ArrayList<FoodItem>> {
    private ProgressDialog progressDialog;
    private Context context;
    private GridView gridView;
    private String url;

    public FetchDataAsyncTask(Context context, GridView gridView, String url) {
        this.context = context;
        this.gridView = gridView;
        this.url = url;
    }

    @Override
    protected ArrayList<FoodItem> doInBackground(Object ... params) {
        ArrayList<FoodItem> response = new ArrayList<>();
        DataFetchClient req = new DataFetchClient();
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

        ImageAdapter ia = new ImageAdapter(context, result);
        gridView.setAdapter(ia);
    }
}