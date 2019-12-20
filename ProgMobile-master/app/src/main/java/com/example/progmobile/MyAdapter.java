package com.example.progmobile;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<LeagueOfLegends> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class Holder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imageView;
        public TextView txtHeader;
        public TextView txtSecond;
        public TextView txtThird;

        public Holder(View v) {
            super(v);
            txtHeader = v.findViewById(R.id.item_titre);
            txtSecond = v.findViewById(R.id.item_age);
            txtThird = v.findViewById(R.id.item_race);
            imageView = v.findViewById(R.id.item_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<LeagueOfLegends> myDataset) {
        this.values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        // create a new view
        /*LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Holder vh = new Holder(v);
        mContext = parent.getContext();
        return vh;*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final LeagueOfLegends lol = values.get(position);
        holder.txtHeader.setText(lol.getName());
        holder.txtSecond.setText(lol.getAge());
        holder.txtThird.setText(lol.getVille());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
