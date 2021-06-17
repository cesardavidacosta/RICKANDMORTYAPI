package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private TextView txtWelcome;
    private ImageButton imgBNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWelcome = findViewById(R.id.txtWelcome);
        imgBNext = findViewById(R.id.imgBNext);
        imgBNext.setOnClickListener(this);

        ImageSlider imageSlider = findViewById(R.id.Slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/ba/a6/8d/baa68d48d3ee20cd07343b4908810593.jpg"));
        slideModels.add(new SlideModel("https://pm1.narvii.com/6710/053df2271cff689824789f6598882f2c2bf526b3_hq.jpg"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/f2/9c/1a/f29c1af13241091e3070f907bd01121d.jpg"));
        slideModels.add(new SlideModel("https://steamuserimages-a.akamaihd.net/ugc/1770453485893246977/FA4026EBB255ACE569504E4EB81645214FDF1CE7/?imw=637&imh=358&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true"));

        slideModels.add(new SlideModel("https://steamuserimages-a.akamaihd.net/ugc/949579682286505245/6242A808B370C5CA12E142AE1541C8F2ADB1D4C6/?imw=268&imh=268&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/03/e1/21/03e1211b80e4d7426e235a16c8836a4b.jpg"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/51/ea/5a/51ea5ab9adeedc9e5f7eec5ea7086e60.png"));
        imageSlider.setImageList(slideModels, true);

    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imgBNext){
            Intent myIntent = new Intent(this, InterfazPrincipalBotones.class);
            startActivity(myIntent);
        }
    }
}