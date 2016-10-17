package team1.lower.seas.agent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import team1.lower.seas.Country;

/**
 * Created by winthanhtike on 10/17/16.
 */
public interface ApiInterface {

    @GET("rest/v1/subregion/south-eastern%20asia")
    Call<List<Country>> getCountries();

}
