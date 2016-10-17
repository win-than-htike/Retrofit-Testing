package team1.lower.seas.utils;

import com.google.gson.Gson;

/**
 * Created by winthanhtike on 9/3/16.
 */
public class CommonInstance {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance(){
        return gson;
    }

}
