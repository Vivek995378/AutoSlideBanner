package com.example.bannerusingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout ;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabLayoutPromotions);

        ArrayList<UserData> list = new ArrayList<>();
        list.add(new UserData(this.getResources().getDrawable(R.drawable.pic1)));
        list.add(new UserData(this.getResources().getDrawable(R.drawable.pic2)));
        list.add(new UserData(this.getResources().getDrawable(R.drawable.pic3)));
        list.add(new UserData(this.getResources().getDrawable(R.drawable.pic4)));
        list.add(new UserData(this.getResources().getDrawable(R.drawable.pic5)));

        CustomAdapter adapter = new CustomAdapter(this , list);

        viewPager2.setAdapter(adapter);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });

        new TabLayoutMediator(tabLayout , viewPager2 , (tab, position) -> {
        }).attach();
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

}