package com.example.fragmentcompilation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BirthstoneAdapter extends RecyclerView.Adapter<BirthstoneAdapter.BirthstoneViewHolder> {

    private List<BirthstoneObj> birthstoneObjs;
    private Context context;
    private AdapterCommunicator adapterCommunicator;

    public BirthstoneAdapter(List<BirthstoneObj> birthstoneObjs, AdapterCommunicator adapterCommunicator) {
        this.birthstoneObjs = birthstoneObjs;
        this.adapterCommunicator = adapterCommunicator;
    }

    @NonNull
    @Override
    public BirthstoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.birthstones_item, parent, false);

        return new BirthstoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BirthstoneViewHolder holder, int position) {
        final BirthstoneObj birthstone = birthstoneObjs.get(position);

        holder.ivBirthstoneImage.setImageResource(birthstone.getStoneImage());
        holder.tvBirthstoneName.setText(birthstone.getStoneName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapterCommunicator.gemstoneSelected(birthstone);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.birthstoneObjs.size();
    }

    class BirthstoneViewHolder extends RecyclerView.ViewHolder {
        private TextView tvBirthstoneName;
        private ImageView ivBirthstoneImage;
        private ConstraintLayout parentLayout;

        public BirthstoneViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBirthstoneName = itemView.findViewById(R.id.tvStoneName);
            ivBirthstoneImage = itemView.findViewById(R.id.ivStoneImage);
            parentLayout = itemView.findViewById(R.id.layoutBirthstonesItem);
        }
    }

    public interface AdapterCommunicator {
        void gemstoneSelected(BirthstoneObj birthstoneObject);
    }
}
