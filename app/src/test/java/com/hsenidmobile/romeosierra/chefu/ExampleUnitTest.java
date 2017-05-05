package com.hsenidmobile.romeosierra.chefu;

import com.hsenidmobile.romeosierra.chefu.utils.DataFetchClient;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private DataFetchClient dfc;
    private String url;
    @Before
    public void init(){
        this.dfc = new DataFetchClient();
    }


    @Test
    public void fetchFavourites() throws Exception {
        this.url = "http://demo7836701.mockable.io/food/favorite";
        System.out.println(dfc.fetchData(url).toString());
    }
}