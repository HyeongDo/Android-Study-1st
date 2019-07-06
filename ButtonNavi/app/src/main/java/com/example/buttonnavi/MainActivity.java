package com.example.buttonnavi;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {



    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    private Menu1Fragment menu1Fragment = new Menu1Fragment();
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    private Menu3Fragment menu3Fragment = new Menu3Fragment();
    private Menu4Fragment menu4Fragment = new Menu4Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();

      //  final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
     //   transaction1.replace(R.id.frameView, fragment1).commitAllowingStateLoss();


        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            FragmentTransaction transaction1 = fragmentManager.beginTransaction();
            transaction1.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
            switch (item.getItemId()) {
                case R.id.navigation_menu1: {
                    transaction1.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
                  //  transaction1.replace(R.id.frameView, fragment1).commitAllowingStateLoss();
                    break;
                }
                case R.id.navigation_menu2: {
                    transaction1.replace(R.id.frame_layout, menu2Fragment).commitAllowingStateLoss();
                //    transaction1.replace(R.id.frameView,fragment2).commitAllowingStateLoss();

                    break;
                }
                case R.id.navigation_menu3: {
                    transaction1.replace(R.id.frame_layout, menu3Fragment).commitAllowingStateLoss();
                    break;
                }
                case R.id.navigation_menu4: {
                    transaction1.replace(R.id.frame_layout, menu4Fragment).commitAllowingStateLoss();
                    break;
                }
            }

            return true;
        });
    }
}