package com.dmv.astroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenuActivity extends AppCompatActivity {
    CardView DayPictureCard;
    CardView PlanetCard;
    CardView AsteroidCard;
    CardView PeopleCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        DayPictureCard = findViewById(R.id.DayPictureCard);
        PlanetCard = findViewById(R.id.PlanetCard);
        AsteroidCard = findViewById(R.id.AsteroidCard);
        PeopleCard = findViewById(R.id.PeopleCard);

        DayPictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ActivityApod.class);
                startActivity(intent);
            }
        });

        PlanetCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ActivityPlanets.class);
                startActivity(intent);
            }
        });

        AsteroidCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ActivityAsteroids.class);
                startActivity(intent);
            }
        });

    }
}