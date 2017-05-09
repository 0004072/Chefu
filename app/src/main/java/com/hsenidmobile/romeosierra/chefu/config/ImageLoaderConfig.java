package com.hsenidmobile.romeosierra.chefu.config;

import com.hsenidmobile.romeosierra.chefu.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by kanchana on 5/9/17.
 */

public class ImageLoaderConfig {
    private static DisplayImageOptions c;

    static {
        c = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.pizza)
                .showImageOnFail(R.drawable.pizza)
                .showImageOnLoading(R.drawable.pizza).build();
    }

    public static DisplayImageOptions getOptions(){
        return c;
    }
}
