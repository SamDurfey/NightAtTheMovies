package com.epicodus.findflix.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epicodus.findflix.R;
import com.epicodus.findflix.adapters.ShowPagerAdapter;
import com.epicodus.findflix.models.Show;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private ShowPagerAdapter adapterPager;
    ArrayList<Show> mShows = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        ButterKnife.bind(this);

        mShows = Parcels.unwrap(getIntent().getParcelableExtra("shows"));
        int startingPosition = getIntent().hasExtra("position") ? Integer.parseInt(getIntent().getStringExtra("position")) : 0;

        adapterPager = new ShowPagerAdapter(getSupportFragmentManager(), mShows);
        mViewPager.setAdapter(adapterPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}