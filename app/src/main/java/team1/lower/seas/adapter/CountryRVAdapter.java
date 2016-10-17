package team1.lower.seas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import team1.lower.seas.Country;
import team1.lower.seas.CountryApp;
import team1.lower.seas.R;

/**
 * Created by winthanhtike on 10/17/16.
 */
public class CountryRVAdapter extends RecyclerView.Adapter<CountryRVAdapter.CountryViewHolder> {

    LayoutInflater inflater;
    List<Country> countryList;

    public CountryRVAdapter(List<Country> countryList) {
        this.countryList = countryList;
        inflater = LayoutInflater.from(CountryApp.getContext());
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cardview_item,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.tvCountryName.setText(country.getName());
        holder.tvPopulation.setText(country.getPopulation()+"");
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountryName;
        TextView tvPopulation;

        public CountryViewHolder(View itemView) {
            super(itemView);

            tvCountryName = (TextView)itemView.findViewById(R.id.tv_country_name);
            tvPopulation = (TextView)itemView.findViewById(R.id.tv_population);

        }


    }
}
