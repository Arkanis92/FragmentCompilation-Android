package com.example.fragmentcompilation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlphabetFragment extends Fragment {
    private View alphabetView;
    private boolean listView;

    public AlphabetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        alphabetView = inflater.inflate(R.layout.fragment_alphabet, container, false);

        initAlphabetRecyclerView();

        return alphabetView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Alphabet Fragment");
        Button swapLayout = alphabetView.findViewById(R.id.btnSwapLayout);

        swapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!listView) {
                    initAlphabetRecyclerView();
                } else {
                    initAlphabetGridRecyclerView();
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initAlphabetRecyclerView() {
        RecyclerView recyclerView = alphabetView.findViewById(R.id.rvAlphabet);
        AlphabetAdapter adapter = new AlphabetAdapter(getAlphabet());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView = true;
    }

    private void initAlphabetGridRecyclerView() {
        RecyclerView recyclerView = alphabetView.findViewById(R.id.rvAlphabet);
        AlphabetAdapter adapter = new AlphabetAdapter(getAlphabet());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        listView = false;
    }

    private List<AlphabetObj> getAlphabet() {
        return Arrays.asList(
                new AlphabetObj("A"),
                new AlphabetObj("B"),
                new AlphabetObj("C"),
                new AlphabetObj("D"),
                new AlphabetObj("E"),
                new AlphabetObj("F"),
                new AlphabetObj("G"),
                new AlphabetObj("H"),
                new AlphabetObj("I"),
                new AlphabetObj("J"),
                new AlphabetObj("K"),
                new AlphabetObj("L"),
                new AlphabetObj("M"),
                new AlphabetObj("N"),
                new AlphabetObj("O"),
                new AlphabetObj("P"),
                new AlphabetObj("Q"),
                new AlphabetObj("R"),
                new AlphabetObj("S"),
                new AlphabetObj("T"),
                new AlphabetObj("U"),
                new AlphabetObj("V"),
                new AlphabetObj("W"),
                new AlphabetObj("X"),
                new AlphabetObj("Y"),
                new AlphabetObj("Z")
        );
    }


    public static AlphabetFragment newInstance() {

        Bundle args = new Bundle();

        AlphabetFragment fragment = new AlphabetFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
