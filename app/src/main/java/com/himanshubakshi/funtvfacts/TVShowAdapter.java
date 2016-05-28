package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/14/16.
 *
 *
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * The RecyclerView adapter that creates the TV show cards based on the orientation
 */
public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.MyViewHolder> {

    private List<TVShow> mShowList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView showName;
        public ImageView showImage;

        public MyViewHolder(View view) {
            super(view);
            showImage = (ImageView) view.findViewById(R.id.card_image);
            showName = (TextView) view.findViewById(R.id.card_show_name);
        }
    }

    public TVShowAdapter(List<TVShow> TVShowList) {
        this.mShowList = TVShowList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_card_row, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {

            /**
             * The click listener on the RecyclerView.
             * Once you tap a TV  Show card, this listener would be hit and will launch the Detail Activity with
             * the context for the TV Show to be shown
             * @param v
             */
            @Override
            public void onClick(View v) {
                TVShow TVShow = mShowList.get(myViewHolder.getAdapterPosition());
                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra(MainActivity.TV_SHOW_NAME, TVShow.getmShowNameId());
                parent.getContext().startActivity(intent);
            }
        });

        myViewHolder.getAdapterPosition();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TVShow show = mShowList.get(position);
        holder.showName.setText(holder.itemView.getContext().getText(show.getmShowNameId()));
        holder.showImage.setImageResource(show.getmShowImageId());
    }

    @Override
    public int getItemCount() {
        return mShowList.size();
    }
}
