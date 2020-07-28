package com.tech_reeturaj.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.tech_reeturaj.viewpager2.adapter.TravelLocationAdapter;
import com.tech_reeturaj.viewpager2.model.TravelLocation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.locationViewPager);
        List<TravelLocation> locations = new ArrayList<>();

        TravelLocation travelLocationTaajMahal = new TravelLocation();
        travelLocationTaajMahal.setImageurl("https://cdn.pixabay.com/photo/2019/11/07/11/27/tajmahal-4608641_960_720.jpg");
        travelLocationTaajMahal.setTitle("Taj Mahal");
        travelLocationTaajMahal.setLocation("Agra");
        travelLocationTaajMahal.setStarrating(4.6f);
        locations.add(travelLocationTaajMahal);

        TravelLocation travelLocationIndiaGate = new TravelLocation();
        travelLocationIndiaGate.setImageurl("https://cdn.pixabay.com/photo/2020/02/02/17/24/travel-4813658_960_720.jpg");
        travelLocationIndiaGate.setTitle("India Gate");
        travelLocationIndiaGate.setLocation("Delhi");
        travelLocationIndiaGate.setStarrating(4.8f);
        locations.add(travelLocationIndiaGate);

        TravelLocation travelLocationRedfort = new TravelLocation();
        travelLocationRedfort.setImageurl("https://cdn.pixabay.com/photo/2013/07/25/12/07/red-fort-167070_960_720.jpg");
        travelLocationRedfort.setTitle("Red Fort");
        travelLocationRedfort.setLocation("Delhi");
        travelLocationRedfort.setStarrating(4.2f);
        locations.add(travelLocationRedfort);

        viewPager2.setAdapter(new TravelLocationAdapter(locations));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }
}