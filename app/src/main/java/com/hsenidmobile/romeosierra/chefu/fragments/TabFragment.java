package com.hsenidmobile.romeosierra.chefu.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.chefu.R;

/**
 * Created by kanchana on 5/3/17.
 */

public class TabFragment extends Fragment {
    private String content;

    public TabFragment() {

    }

    public TabFragment setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView tv = (TextView)getView().findViewById(R.id.content);
        tv.setText(this.content);
    }
}