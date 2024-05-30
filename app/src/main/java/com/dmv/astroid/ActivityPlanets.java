package com.dmv.astroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityPlanets  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_planets);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<PlanetOnList> planetList = new ArrayList<>();
        //imagenes
        planetList.add(new PlanetOnList("Mercurio", R.drawable.mercurio, "mercury"));
        planetList.add(new PlanetOnList("Venus", R.drawable.venus, "venus"));
        planetList.add(new PlanetOnList("Tierra", R.drawable.tierra, "earth"));
        planetList.add(new PlanetOnList("Marte", R.drawable.marte, "mars"));
        planetList.add(new PlanetOnList("Jupiter", R.drawable.jupiter, "jupiter"));
        planetList.add(new PlanetOnList("Saturno", R.drawable.saturno, "saturn"));
        planetList.add(new PlanetOnList("Urano", R.drawable.urano, "uranus"));
        planetList.add(new PlanetOnList("Neptuno", R.drawable.neptuno, "neptune"));
        planetList.add(new PlanetOnList("Plutón", R.drawable.pluton, "pluto"));
        planetList.add(new PlanetOnList("Sedna", R.drawable.sedna, "sedna"));
        planetList.add(new PlanetOnList("Eris", R.drawable.eris, "eris"));

        PlanetListAdapter adapter = new PlanetListAdapter(planetList, planet -> {
            Intent sendPlanet = new Intent(ActivityPlanets.this, DetailsActivity.class);
            sendPlanet.putExtra("name", planet.getENGName());
            startActivity(sendPlanet);
        });
        recyclerView.setAdapter(adapter);




    }

}
