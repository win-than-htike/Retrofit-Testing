package team1.lower.seas;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team1.lower.seas.adapter.CountryRVAdapter;
import team1.lower.seas.agent.ApiClient;
import team1.lower.seas.agent.ApiInterface;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvCountry;
    CountryRVAdapter mAdapter;
    List<Country> mCountryList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(this);

        rvCountry = (RecyclerView)findViewById(R.id.rv_country);
        mLayoutManager = new LinearLayoutManager(this);
        rvCountry.setLayoutManager(mLayoutManager);
        rvCountry.setItemAnimator(new DefaultItemAnimator());

        fetchCountry();

    }

    private void fetchCountry(){

        pDialog.setMessage("Loading Country...");
        pDialog.show();

        ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);

        Call<List<Country>> call = apiInterface.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                Log.i("Response : ", response.body().get(0).getName());
                pDialog.hide();
                rvCountry.setAdapter(new CountryRVAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.i("Response : ", "Fail");
                pDialog.hide();
                Toast.makeText(CountryApp.getContext(),"Retry Connection",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
