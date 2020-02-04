package com.example.fragmentcompilation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder> {
    private List<AlphabetObj> alphabetObjs;
    private Context context;


    public AlphabetAdapter(List<AlphabetObj> alphabetObjs) {
        this.alphabetObjs = alphabetObjs;
    }

    @NonNull
    @Override
    public AlphabetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alphabet_item, parent, false);
        context = parent.getContext();
        return new AlphabetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetViewHolder holder, int position) {
        final AlphabetObj alphabet = alphabetObjs.get(position);

        holder.tvAlphabetLetter.setText(alphabet.getAlphabet());
    }

    @Override
    public int getItemCount() {
        return this.alphabetObjs.size();
    }

    class AlphabetViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAlphabetLetter;
//        private ConstraintLayout alphabetParentLayout;

        public AlphabetViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAlphabetLetter = itemView.findViewById(R.id.tvAlphabetLetter);
//            alphabetParentLayout = itemView.findViewById(R.id.layoutAlphabetItem);
        }
    }
}
