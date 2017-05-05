package com.hsenidmobile.romeosierra.chefu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.hsenidmobile.romeosierra.chefu.R;
import com.hsenidmobile.romeosierra.chefu.tasks.FetchDataAsyncTask;

/**
 * Created by kanchana on 5/3/17.
 */

public class TabFragment extends Fragment {
    private String url;

    public TabFragment() {

    }

    public TabFragment setContent(String url) {
        this.url = url;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_fragment, container, false);
        GridView gridView = (GridView)view.findViewById(R.id.gridView1);
        Context context = view.getContext();
        FetchDataAsyncTask fda = new FetchDataAsyncTask(context, gridView, this.url);
        fda.execute();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}