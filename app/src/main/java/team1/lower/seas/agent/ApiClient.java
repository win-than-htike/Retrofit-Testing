package team1.lower.seas.agent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import team1.lower.seas.utils.Constances;

/**
 * Created by winthanhtike on 10/17/16.
 */
public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constances.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;

    }

}
