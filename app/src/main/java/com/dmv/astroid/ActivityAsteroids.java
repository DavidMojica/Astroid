package com.dmv.astroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ActivityAsteroids extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids);

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            List<PlanetOnList> planetList = new ArrayList<>();
            //imagenes
            planetList.add(new PlanetOnList("Astraea", R.drawable.astraea,"astraea"));
            planetList.add(new PlanetOnList("Castalia", R.drawable.castalia,"castalia"));
            planetList.add(new PlanetOnList("ceres", R.drawable.ceres,"ceres"));
            planetList.add(new PlanetOnList("Cruithne", R.drawable.cruithne,"cruithne"));
            planetList.add(new PlanetOnList("Eros", R.drawable.eros,"eros"));
            planetList.add(new PlanetOnList("Halley", R.drawable.halley,"halley"));
            planetList.add(new PlanetOnList("Hebe", R.drawable.hebe,"hebe"));
            planetList.add(new PlanetOnList("Hector", R.drawable.hector,"hector"));
            planetList.add(new PlanetOnList("Ida", R.drawable.ida,"ida"));
            planetList.add(new PlanetOnList("Lempo", R.drawable.lempo,"lempo"));
            planetList.add(new PlanetOnList("Pholus", R.drawable.pholus,"pholus"));
        planetList.add(new PlanetOnList("Quaoar", R.drawable.quaoar,"quaoar"));
        planetList.add(new PlanetOnList("Steins", R.drawable.steins,"steins"));
        planetList.add(new PlanetOnList("Toutatis", R.drawable.toutatis,"toutatis"));
        planetList.add(new PlanetOnList("Vesta", R.drawable.vesta,"vesta"));


            PlanetListAdapter adapter = new PlanetListAdapter(planetList);
            recyclerView.setAdapter(adapter);
        }
    }
