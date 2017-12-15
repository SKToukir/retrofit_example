package bd.scanner.com.myapplication;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import bd.scanner.com.myapplication.model.Hero;
import bd.scanner.com.myapplication.remote.Api;
import bd.scanner.com.myapplication.remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api api = RetrofitClient.getRetrofitClient().create(Api.class);

        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                Log.d("Response",response.body().toString());

                List<Hero> heroes = response.body();

                for (Hero h:heroes){
                    Log.d("Response",h.getRealname());
                    Log.d("Response",h.getBio());
                    Log.d("Response",h.getCreatedby());
                    Log.d("Response",h.getFirstappearance());
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.d("Response",t.getMessage());
            }
        });
    }
}