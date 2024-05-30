package com.dmv.astroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dmv.astroid.modelos.Objeto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailsTextView;
    private SolarSystemApi apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsTextView = findViewById(R.id.detailsTextView);

        // Recupera el Intent que inició esta actividad
        Intent intent = getIntent();
        String planetName = intent.getStringExtra("name");

        // Configura Retrofit
        apiService = RetrofitClient.getClient().create(SolarSystemApi.class);

        // Hacer una llamada a la API si es necesario
        if (planetName != null) {
            // Actualiza el TextView con el nombre del planeta
            getPlanetDetails(planetName);
            // Puedes hacer una llamada a la API aquí si necesitas más detalles
            // getPlanetDetails(planetName);
        } else {
            detailsTextView.setText("No planet name provided");
        }
    }

    private void getPlanetDetails(String planetName) {
        Call<Objeto> call = apiService.getPlanetDetails(planetName);
        call.enqueue(new Callback<Objeto>() {
            @Override
            public void onResponse(Call<Objeto> call, Response<Objeto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Actualiza el TextView con los detalles del planeta


                    Objeto details = response.body();
                    StringBuilder detailsText = new StringBuilder();
                    detailsText.append("Name: ").append(details.getEnglishName()).append("\n")
                            .append("Density: ").append(details.getDensity()).append(" g/cm^3\n")
                            .append("Gravity: ").append(details.getGravity()).append(" m/s^2\n")
                            .append("Mean Radius: ").append(details.getMeanRadius()).append(" km\n")
                            .append("SemimajorAxis: ").append(details.getSemimajorAxis()).append("\n")
                            .append("EquaRadius: ").append(details.getEquaRadius()).append("\n")
                            .append("PolarRadius: ").append(details.getPolarRadius()).append("\n")
                            .append("AlternativeName: ").append(details.getAlternativeName()).append("\n")
                            .append("Inclination: ").append(details.getInclination()).append("\n");
                        detailsTextView.setText(detailsText.toString());

                }
                else if(response.isSuccessful() == false){
                    detailsTextView.setText("Error success");
                }
                else{
                    detailsTextView.setText("Error body");
                }
            }

            @Override
            public void onFailure(Call<Objeto> call, Throwable t) {
                detailsTextView.setText("Error retrieving planet details");
            }
        });
    }
}
