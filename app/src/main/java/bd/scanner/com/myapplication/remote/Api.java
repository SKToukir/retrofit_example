package bd.scanner.com.myapplication.remote;

import java.util.List;

import bd.scanner.com.myapplication.model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by toukir on 12/15/17.
 */

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
