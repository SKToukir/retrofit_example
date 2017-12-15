package bd.scanner.com.myapplication.remote;

import java.util.List;

import bd.scanner.com.myapplication.model.Hero;
import bd.scanner.com.myapplication.model.Score;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by toukir on 12/15/17.
 */

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/";
    String BASE_URL_SCORE = "http://cricapi.com/api/";

    @GET("demos/marvel")
    Call<List<Hero>> getHeroes();

    @POST("cricketScore")
    Call<Score> getScore(@Query("unique_id")String unique_id, @Query("apikey") String apikey);
}
