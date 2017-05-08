package com.hsenidmobile.romeosierra.chefu.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.chefu.R;
import com.hsenidmobile.romeosierra.chefu.ShowItemActivity;
import com.hsenidmobile.romeosierra.chefu.model.Cart;
import com.hsenidmobile.romeosierra.chefu.model.Extra;
import com.hsenidmobile.romeosierra.chefu.model.Topping;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by kanchana on 5/8/17.
 */

public class ExtraListAdapter extends BaseAdapter {
    private Topping[] toppings;
    private LayoutInflater inflater;
    private Context context;
    private Cart cart;

    public ExtraListAdapter(Context context, Extra extra, Cart cart) {
        if (extra == null) {
            this.toppings = new Topping[0];
        } else {
            this.toppings = extra.getToppings();
        }
        this.context = context;
        this.cart = cart;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return toppings.length;
    }

    @Override
    public Object getItem(int i) {
        return toppings[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.list_show_extra, null);
            final int item = i;
            if (toppings.length != 0) {
                TextView textView_extra_name = (TextView)view.findViewById(R.id.extra_name);
                TextView textView_extra_price = (TextView)view.findViewById(R.id.extra_price);
                ImageView imageView_extra_img = (ImageView)view.findViewById(R.id.extra_thumbnail);
                CheckBox chk_choose = (CheckBox)view.findViewById(R.id.chk_choose);

                chk_choose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double price = 0;
                        try {
                            price = Double.parseDouble(toppings[item].getPrice().replace('$', '0'));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if ( ((CheckBox)view).isChecked() ) {
                            cart.incrementTotal(price);
                        }
                        else{
                            cart.decrementTotal(price);
                        }
                        ((ShowItemActivity)context).displayTotalChange();
                    }
                });

                textView_extra_name.setText(toppings[i].getName());
                textView_extra_price.setText(toppings[i].getPrice());
                ImageLoader loader = ImageLoader.getInstance();
                DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                        .cacheOnDisk(true).resetViewBeforeLoading(true)
                        .showImageForEmptyUri(R.drawable.pizza)
                        .showImageOnFail(R.drawable.pizza)
                        .showImageOnLoading(R.drawable.pizza).build();

                loader.displayImage(toppings[i].getImage(), imageView_extra_img, options);
            }
            else
                Toast.makeText(null, "No toppings available!", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}
