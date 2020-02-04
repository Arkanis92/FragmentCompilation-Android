package com.example.fragmentcompilation;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ToBirthstoneFragmentListener birthstoneFragmentListener;
    private ToStressTapperFragmentListener stressTapperFragmentListener;
    private ToAlphabetFragmentListener alphabetFragmentListener;
    private ToAnimalHouseFragmentListener animalHouseFragmentListener;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Home Fragment");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button launchBirthstones = view.findViewById(R.id.btnHomeToBirthstones);
        Button launchStressTapper = view.findViewById(R.id.btnHomeToStress);
        Button launchAlphabet = view.findViewById(R.id.btnHomeToAlphabet);
        Button launchAnimalHouse = view.findViewById(R.id.btnHomeToAnimalHouse);

        launchBirthstones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birthstoneFragmentListener.onBirthstoneFragmentClicked();
            }
        });

        launchStressTapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stressTapperFragmentListener.onStressTapperFragmentClicked();
            }
        });

        launchAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphabetFragmentListener.onAlphabetFragmentClicked();
            }
        });

        launchAnimalHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalHouseFragmentListener.onAnimalHouseFragmentClicked();
            }
        });
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//    }

    public interface ToStressTapperFragmentListener {
        void onStressTapperFragmentClicked();
    }

    public interface ToBirthstoneFragmentListener {
        void onBirthstoneFragmentClicked();
    }

    public interface ToAlphabetFragmentListener {
        void onAlphabetFragmentClicked();
    }

    public interface ToAnimalHouseFragmentListener {
        void onAnimalHouseFragmentClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ToBirthstoneFragmentListener) {
            birthstoneFragmentListener = (ToBirthstoneFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + getResources().getString(R.string.exception_message_birthstone));
        }

        if (context instanceof ToStressTapperFragmentListener) {
            stressTapperFragmentListener = (ToStressTapperFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + getResources().getString(R.string.exception_message_stress_tapper));
        }

        if (context instanceof ToAlphabetFragmentListener) {
            alphabetFragmentListener = (ToAlphabetFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + getResources().getString(R.string.exception_message_alphabet));
        }

        if (context instanceof ToAnimalHouseFragmentListener) {
            animalHouseFragmentListener = (ToAnimalHouseFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + getResources().getString(R.string.exception_message_animal_house));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        birthstoneFragmentListener = null;
        stressTapperFragmentListener = null;
        alphabetFragmentListener = null;
        animalHouseFragmentListener = null;
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
