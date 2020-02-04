package com.example.fragmentcompilation;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthstonesFragmentMain extends Fragment implements BirthstoneAdapter.AdapterCommunicator {
    private View birthstoneView;
    private BirthstoneFragmentMainListener mCallback;


    public BirthstonesFragmentMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        birthstoneView = inflater.inflate(R.layout.fragment_birthstones_fragment_main, container, false);

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Birthstone Fragment");
        initRecyclerView();
        return birthstoneView;
    }

    public static BirthstonesFragmentMain newInstance() {

        Bundle args = new Bundle();

        BirthstonesFragmentMain fragment = new BirthstonesFragmentMain();
        fragment.setArguments(args);
        return fragment;
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = birthstoneView.findViewById(R.id.rvBirthstonesMain);
        BirthstoneAdapter adapter = new BirthstoneAdapter(getBirthstones(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private List<BirthstoneObj> getBirthstones() {
        return Arrays.asList(
                new BirthstoneObj("Garnet", R.drawable.garnet, "The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January.The garnet is the birthstone of January."),
                new BirthstoneObj("Amethyst", R.drawable.amethyst, "The amethyst is the birthstone of February."),
                new BirthstoneObj("Aquamarine", R.drawable.aquamarine, "The aquamarine is the birthstone of March."),
                new BirthstoneObj("Diamond", R.drawable.diamond, "The diamond is the birthstone of April."),
                new BirthstoneObj("Emerald", R.drawable.emerald, "The emerald is the birthstone of May."),
                new BirthstoneObj("Alexandrite", R.drawable.alexandrite, "The alexandrite is the birthstone of June."),
                new BirthstoneObj("Ruby", R.drawable.ruby, "The ruby is the birthstone of July."),
                new BirthstoneObj("Peridot", R.drawable.peridot, "The peridot is the birthstone of August."),
                new BirthstoneObj("Sapphire", R.drawable.sapphire, "The sapphire is the birthstone of September."),
                new BirthstoneObj("Tourmaline", R.drawable.tourmaline, "The tourmaline is the birthstone of October."),
                new BirthstoneObj("Topaz", R.drawable.topaz, "The topaz is the birthstone of November."),
                new BirthstoneObj("Zircon", R.drawable.zircon, "The zircon is the birthstone of December.")
        );
    }

    @Override
    public void gemstoneSelected(BirthstoneObj birthstoneObject) {
        mCallback.onGemstoneSelected(birthstoneObject);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof BirthstoneFragmentMainListener) {
            mCallback = (BirthstoneFragmentMainListener)context;
        } else {
            throw new ClassCastException(context.toString() + getResources().getString(R.string.exception_message_birthstone_main));
        }
    }

    public interface BirthstoneFragmentMainListener {
        void onGemstoneSelected(BirthstoneObj birthstoneObj);
    }
}
