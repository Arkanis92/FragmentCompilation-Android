package com.example.fragmentcompilation;


import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthstonesFragmentDetails extends Fragment {
    private View birthstoneDetailsView;
    private BirthstoneObj birthstoneObj;

    public BirthstonesFragmentDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        birthstoneDetailsView = inflater.inflate(R.layout.fragment_birthstones_fragment_details, container, false);

        return birthstoneDetailsView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Birthstone Details Fragment");
        ImageView stoneImage = birthstoneDetailsView.findViewById(R.id.ivStoneImageDetailFrag);
        TextView stoneName = birthstoneDetailsView.findViewById(R.id.tvStoneNameDetailFrag);
        TextView stoneDescription = birthstoneDetailsView.findViewById(R.id.tvStoneNameDescriptionDetailFrag);

        assert getArguments() != null;
        if (getArguments().containsKey("birthstone")) {
            birthstoneObj = getArguments().getParcelable("birthstone");

            assert birthstoneObj != null;
            stoneImage.setImageResource(birthstoneObj.getStoneImage());
            stoneName.setText(birthstoneObj.getStoneName());
            stoneDescription.setText(birthstoneObj.getStoneDescription());
        }
    }

    public static BirthstonesFragmentDetails newInstance(BirthstoneObj birthstone) {
        
        Bundle args = new Bundle();
        args.putParcelable("birthstone", birthstone);
        
        BirthstonesFragmentDetails fragment = new BirthstonesFragmentDetails();
        fragment.setArguments(args);
        return fragment;
    }

}
