package com.example.vocaapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class StudyFoodMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_food_main);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setOffscreenPageLimit(11);

        StudyFoodPagerAdapter adapter = new StudyFoodPagerAdapter(getSupportFragmentManager());
        StudyFood1 studyFood1 = new StudyFood1();
        adapter.addItem(studyFood1);

        StudyFood2 studyFood2 = new StudyFood2();
        adapter.addItem(studyFood2);

        StudyFood3 studyFood3 = new StudyFood3();
        adapter.addItem(studyFood3);

        StudyFood4 studyFood4 = new StudyFood4();
        adapter.addItem(studyFood4);

        StudyFood5 studyFood5 = new StudyFood5();
        adapter.addItem(studyFood5);

        StudyFood6 studyFood6 = new StudyFood6();
        adapter.addItem(studyFood6);

        StudyFood7 studyFood7 = new StudyFood7();
        adapter.addItem(studyFood7);

        StudyFood8 studyFood8 = new StudyFood8();
        adapter.addItem(studyFood8);

        StudyFood9 studyFood9 = new StudyFood9();
        adapter.addItem(studyFood9);

        StudyFood10 studyFood10 = new StudyFood10();
        adapter.addItem(studyFood10);

        pager.setAdapter(adapter);
    }

    class StudyFoodPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public StudyFoodPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}


