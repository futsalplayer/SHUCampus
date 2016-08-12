package me.stupideme.shucampus.notify;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.stupideme.shucampus.R;
import me.stupideme.shucampus.view.SlidingTabLayout;

public class NotifyActivity extends AppCompatActivity {

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.activity_notify);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifyActivity.super.onBackPressed();
            }
        });

        fragmentList = new ArrayList<>();
        fragmentList.add(ChatFragment.newInstance(null, null));
        fragmentList.add(ReferenceFragment.newInstance(null, null));
        fragmentList.add(CommitFragment.newInstance(null, null));

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        SlidingTabLayout slidingTabs = (SlidingTabLayout) findViewById(R.id.sliding_tab_layout);
        slidingTabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        slidingTabs.setSelectedIndicatorColors(Color.WHITE);
        slidingTabs.setCustomTabView(R.layout.item_sliding_tab,0);

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(adapter);
        slidingTabs.setViewPager(pager);
    }
}
