package com.nikolayfrolov.testtask;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nikolayfrolov.testtask.databinding.FragmentMenuBinding;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    private Spinner spinner;

    private ArrayList<ProductsList> productsLists = new ArrayList<>();

//    private ProductsListClass.productCategories productCategories;

    @SuppressLint("LongLogTag")
    private void initialiseFavoriteData()  {
        productsLists.clear();

        productsLists.add(new ProductsList(getResources().getIdentifier("pizza_1_photo", "drawable", getActivity().getPackageName()),
                "Ветчина и грибы",
                "Ветчина, шампиньоны, увеличенная порция моцареллы, томатный соус",
                "345"));

        productsLists.add(new ProductsList(getResources().getIdentifier("pizza_2_photo", "drawable", getActivity().getPackageName()),
                "Баварские колбаски",
                "Баварские колбаски, ветчина, пикантная пепперони, острая чоризо,томатный соус",
                "345"));

        productsLists.add(new ProductsList(getResources().getIdentifier("pizza_3_photo", "drawable", getActivity().getPackageName()),
                "Нежный лосось",
                "Лосось, томаты, оливки, соус песто, помидорки черри",
                "345"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater);
        View view = binding.getRoot();

        initialiseFavoriteData();

        ProductsListAdapter productsListAdapter = new ProductsListAdapter(this.getActivity(), productsLists);
        binding.recyclerviewPizzaList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.recyclerviewPizzaList.setAdapter(productsListAdapter);

        String[] citiesSelect = getResources().getStringArray(R.array.cities_select);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, citiesSelect);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCitiesSelect.setAdapter(arrayAdapter);

        return view;
    }
}