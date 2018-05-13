package com.example.entropy.tabsandfragments;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static QuotesDb quotesDb;
    Toolbar toolbar;
    TextView toolbarTitle;
    ImageButton btnRefresh;

    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create db here
        quotesDb = Room.databaseBuilder
                (MainActivity.this,QuotesDb.class, "quotes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        toolbarTitle=(TextView) findViewById(R.id.toolbar_title);
        vp = (ViewPager) findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        btnRefresh=(ImageButton)findViewById(R.id.btn_refresh);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        tabLayout.addTab(tabLayout.newTab().setText("DAILY QUOTE"));
        tabLayout.addTab(tabLayout.newTab().setText("MY QUOTES"));

        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());

        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==1){
                     btnRefresh.setVisibility(View.INVISIBLE);
                     } else {
                    btnRefresh.setVisibility(View.VISIBLE);
                }

            }




            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuotationAsyncTask refreshQuote = new QuotationAsyncTask();
                refreshQuote.execute();
            }
        });
    }
}
