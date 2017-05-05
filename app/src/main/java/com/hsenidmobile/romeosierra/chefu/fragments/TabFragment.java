package com.hsenidmobile.romeosierra.chefu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsenidmobile.romeosierra.chefu.R;
import com.hsenidmobile.romeosierra.chefu.adapters.ImageAdapter;

/**
 * Created by kanchana on 5/3/17.
 */

public class TabFragment extends Fragment {
    private String[] content;

    public TabFragment() {

    }

    public TabFragment setContent(String[] content) {
        this.content = content;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_fragment, container, false);
        GridView gridView = (GridView)view.findViewById(R.id.gridView1);
        Context ctx = view.getContext();
        gridView.setAdapter(new ImageAdapter(ctx, content));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //GridView gridView = (GridView)getView().findViewById(R.id.gridView1);
        //gridView.setAdapter(new ImageAdapter(getContext(), content));
    }
}