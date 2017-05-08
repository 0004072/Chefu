package com.hsenidmobile.romeosierra.chefu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.chefu.adapters.ExtraListAdapter;
import com.hsenidmobile.romeosierra.chefu.model.Cart;
import com.hsenidmobile.romeosierra.chefu.model.FoodItem;
import com.hsenidmobile.romeosierra.chefu.tasks.FetchDataAsyncTask;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ShowItemActivity extends AppCompatActivity {
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cart = new Cart();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        //Image loader configuration
        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.pizza)
                .showImageOnFail(R.drawable.pizza)
                .showImageOnLoading(R.drawable.pizza).build();

        //View extraction
        Intent intent = getIntent();
        TextView txt_item_name = (TextView)findViewById(R.id.txt_item_name);
        TextView txt_item_desc = (TextView)findViewById(R.id.txt_item_description);
        ImageView img_item_thumbnail = (ImageView)findViewById(R.id.img_item_thumbnail);
        final ImageView img_btn_add = (ImageView)findViewById(R.id.img_btn_add);
        ListView extra_list = (ListView)findViewById(R.id.extra_list);

        //Data population
        final FoodItem foodItem = intent.getParcelableExtra(FetchDataAsyncTask.FOOD_ITEM_OBJECT);
        txt_item_name.setText(foodItem.getName());
        SpannableStringBuilder desc = new SpannableStringBuilder(txt_item_desc.getText());
        desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, desc.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        desc.append(" - ").append(foodItem.getDescription());
        txt_item_desc.setText(desc);
        imageLoader.displayImage(foodItem.getImage(), img_item_thumbnail, options);

        ExtraListAdapter ela = new ExtraListAdapter(this, foodItem.getExtra(), cart);
        extra_list.setAdapter(ela);

        img_btn_add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    img_btn_add.setImageResource(R.drawable.plus_down);
                } else if (motionEvent.getAction() == android.view.MotionEvent.ACTION_UP) {
                    img_btn_add.setImageResource(R.drawable.plus);
                    cart.incrementTotal(Double.parseDouble(foodItem.getPrice().replace('$', '0')));
                    displayTotalChange();
                }
                return true;
            }
        });

        displayTotalChange();
    }

    public void displayTotalChange(){
        SpannableStringBuilder totalSpan = new SpannableStringBuilder("Total : $");
        totalSpan.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, totalSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        totalSpan.append(String.format(getResources().getConfiguration().locale, "%.2f", cart.getTotal()));
        TextView textView = (TextView)findViewById(R.id.txt_total);
        textView.setText(totalSpan);
    }
}
