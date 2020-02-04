package com.example.fragmentcompilation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.ToBirthstoneFragmentListener,
        BirthstonesFragmentMain.BirthstoneFragmentMainListener,
        HomeFragment.ToStressTapperFragmentListener,
        HomeFragment.ToAlphabetFragmentListener,
        HomeFragment.ToAnimalHouseFragmentListener {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayHomeFragment();

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //region Back Button Management

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
//            Log.i("Prevent Back Press", "Prevent Back Press");
        /*}*/ if (getSupportFragmentManager().getBackStackEntryCount() == 2) {
            super.onBackPressed();
            getSupportActionBar().setTitle("Home Fragment");
        } else {
            super.onBackPressed();
            getSupportActionBar().setTitle("Birthstones Main Fragment");
        }
    }

    //endregion

    //region Fragment Listener Statements

    private void displayHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, homeFragment).commit();
    }

    @Override
    public void onBirthstoneFragmentClicked() {
        BirthstonesFragmentMain birthstonesFragmentMain = BirthstonesFragmentMain.newInstance();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, birthstonesFragmentMain).addToBackStack(null).commit();
    }

    @Override
    public void onGemstoneSelected(BirthstoneObj birthstoneObj) {
        BirthstonesFragmentDetails birthstonesFragmentDetails = BirthstonesFragmentDetails.newInstance(birthstoneObj);
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, birthstonesFragmentDetails).addToBackStack(null).commit();
    }

    @Override
    public void onStressTapperFragmentClicked() {
        StressTapperFragment stressTapperFragment = StressTapperFragment.newInstance();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, stressTapperFragment).addToBackStack(null).commit();
    }

    @Override
    public void onAlphabetFragmentClicked() {
        AlphabetFragment alphabetFragment = AlphabetFragment.newInstance();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, alphabetFragment).addToBackStack(null).commit();
    }

    @Override
    public void onAnimalHouseFragmentClicked() {
        AnimalHouseFragment animalHouse = AnimalHouseFragment.newInstance();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, animalHouse).addToBackStack(null).commit();
    }

    //endregion
}
