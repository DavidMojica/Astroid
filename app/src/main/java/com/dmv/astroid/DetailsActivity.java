package com.dmv.astroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.dmv.astroid.modelos.Objeto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {
    String name;
    SolarSystemApi apiService;
    TextView detailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsTextView = findViewById(R.id.detailsTextView);

        // Obtener el Intent
        Intent getData = this.getIntent();
        if(getData != null){
            name = getData.getStringExtra("name");
        }

        // Configurar Retrofit
        Retrofit retrofit = RetrofitClient.getClient("https://api.le-systeme-solaire.net/");
        apiService = retrofit.create(SolarSystemApi.class);

        // Obtener y mostrar detalles del planeta
        getPlanetDetails(name);
    }

    private void getPlanetDetails(String planetId) {
        Call<Objeto> call = apiService.getBodyDetails(planetId);
        call.enqueue(new Callback<Objeto>() {
            @Override
            public void onResponse(Call<Objeto> call, Response<Objeto> response) {
                if (response.isSuccessful()) {
                    Objeto body = response.body();
                    if (body != null) {
                        String details = "Name: " + body.getEnglishName() + "\n" +
                                "Semimajor Axis: " + body.getSemimajorAxis() + "\n" +
                                "Perihelion: " + body.getPerihelion() + "\n" +
                                "Aphelion: " + body.getAphelion() + "\n" +
                                "Density: " + body.getDensity() + "\n" +
                                "Gravity: " + body.getGravity();
                        detailsTextView.setText(details);
                    }
                }
            }

            @Override
            public void onFailure(Call<Objeto> call, Throwable t) {
                detailsTextView.setText("Failed to load data");
            }
        });
    }
}
