package com.nikolayfrolov.testtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nikolayfrolov.testtask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    MenuFragment menuFragment = new MenuFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    BasketFragment basketFragment = new BasketFragment();


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // FragmentManager для перехода между фрагментами
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment, new MenuFragment());
        fragmentTransaction.commit();
        //

        bottomNavigationView = findViewById(R.id.tab_bar); // Инициализация bottomNavigationView

        bottomNavigationView.setSelectedItemId(R.id.action_menu); // При запуске активна 1 кнопка нижней панели навигации

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit(); // Задан фрагмент, видимый по умолчанию, при запуске приложения


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // Установка нужного фрагмента по нажанию кнопки панели навигации
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (R.id.action_menu == item.getItemId()) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
                        return true;
                    } else if (R.id.action_profile == item.getItemId()) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, profileFragment).commit();
                        return true;
                    } else if (R.id.action_basket == item.getItemId()) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, basketFragment).commit();
                        return true;
                    }

//                switch (item.getItemId())   {
//                    case R.id.action_menu:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
//                        return true;
//                    case R.id.action_profile:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, profileFragment).commit();
//                        return true;
//                    case R.id.action_basket:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, basketFragment).commit();
//                        return true;
//                }
                return false;
            }
        });

    }
}