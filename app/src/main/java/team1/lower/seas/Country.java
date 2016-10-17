package team1.lower.seas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winthanhtike on 10/17/16.
 */
public class Country {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("population")
    @Expose
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
