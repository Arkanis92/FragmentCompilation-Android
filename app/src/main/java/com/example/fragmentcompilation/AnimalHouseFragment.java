package com.example.fragmentcompilation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalHouseFragment extends Fragment {


    public AnimalHouseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_house, container, false);
    }

    public static AnimalHouseFragment newInstance() {

        Bundle args = new Bundle();

        AnimalHouseFragment fragment = new AnimalHouseFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
