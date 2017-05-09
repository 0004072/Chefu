package com.hsenidmobile.romeosierra.chefu;

import com.hsenidmobile.romeosierra.chefu.utils.FoodItemFetchClient;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private FoodItemFetchClient dfc;
    private String url;
    @Before
    public void init(){
        this.dfc = new FoodItemFetchClient();
    }


    @Test
    public void fetchFavourites() throws Exception {
        this.url = "http://demo7836701.mockable.io/food/favorite";
        System.out.println(dfc.fetchData(url).toString());
    }
}