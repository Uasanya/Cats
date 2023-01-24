package com.example.srez.ui.cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srez.R;
import com.example.srez.ui.model.Cat;
import com.example.srez.ui.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<Cat> cats = new ArrayList<>();
    private final CatListener listener;
    private final LayoutInflater inflater;

    CatAdapter(Context context, CatListener listener) {
        this.listener = listener;
        this.inflater = LayoutInflater.from(context);
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    public void onBindViewHolder(CatViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCatHolderId;
        private final ImageView ivCatHolder;

        public CatViewHolder(View itemView) {
            super(itemView);
            tvCatHolderId = itemView.findViewById(R.id.tv_cat_holder_id);
            ivCatHolder = itemView.findViewById(R.id.iv_cat_holder);
        }

        public void bind(int position) {
            Cat cat = cats.get(position);
            String id = cat.getId() + "";
            tvCatHolderId.setText(id);
            GlideUtils.loadImage(ivCatHolder, cat.getImage());
            itemView.setOnClickListener(view ->
                listener.onCatClick(cat)
            );
        }
    }
}
