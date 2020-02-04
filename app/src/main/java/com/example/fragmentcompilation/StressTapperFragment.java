package com.example.fragmentcompilation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class StressTapperFragment extends Fragment {
    private static final String TAG = "StressTapperFragment";
    private View stressView;
    private int counter = 0;


    public StressTapperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        stressView = inflater.inflate(R.layout.fragment_stress_tapper, container, false);

        return stressView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button stressButton = stressView.findViewById(R.id.btnBottomStressFragment);
        final TextView textDisplay = stressView.findViewById(R.id.tvTopStressFragment);

        stressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDisplay.setText(String.valueOf(++counter));
                Log.d(TAG, "Stress Counter " + counter);
            }
        });

        stressButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counter = -1;
                return false;
            }
        });

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Stress Tapper Fragment");
    }

    static StressTapperFragment newInstance() {

        Bundle args = new Bundle();

        StressTapperFragment fragment = new StressTapperFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
