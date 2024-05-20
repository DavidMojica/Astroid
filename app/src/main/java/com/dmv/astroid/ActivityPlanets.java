package com.dmv.astroid;

import android.os.Bundle;

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
        planetList.add(new PlanetOnList("Mercurio", R.drawable.mercurio));
        planetList.add(new PlanetOnList("Venus", R.drawable.venus));
        planetList.add(new PlanetOnList("Tierra", R.drawable.tierra));
        planetList.add(new PlanetOnList("Marte", R.drawable.marte));
        planetList.add(new PlanetOnList("Jupiter", R.drawable.jupiter));
        planetList.add(new PlanetOnList("Saturno", R.drawable.saturno));
        planetList.add(new PlanetOnList("Urano", R.drawable.urano));
        planetList.add(new PlanetOnList("Neptuno", R.drawable.neptuno));
        planetList.add(new PlanetOnList("Plutón", R.drawable.pluton));
        planetList.add(new PlanetOnList("Sedna", R.drawable.sedna));
        planetList.add(new PlanetOnList("Eris", R.drawable.eris));

        PlanetListAdapter adapter = new PlanetListAdapter(planetList);
        recyclerView.setAdapter(adapter);
    }

}
