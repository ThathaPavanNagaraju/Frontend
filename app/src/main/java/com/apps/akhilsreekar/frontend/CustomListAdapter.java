package com.apps.akhilsreekar.frontend;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AKHIL on 27-09-2016.
 */
public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflator;
    static int previousPosition = -1;
    ViewHolder staticHolder;
    public static CustomListAdapter myCustomAdapter;
    public static final int GRID = 0;
    public static final int LIST = 1;
    public CustomListAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
        inflator = LayoutInflater.from(context);
        staticHolder= null;
        MainActivity.mMainActivity.first_time = true;
        myCustomAdapter = this;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewList;
        View viewGrid = inflator.inflate(R.layout.list_item_row, parent, false);
        ViewHolder holder = new ViewHolder(viewGrid);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvGameName.setText(data.get(position).title);
        holder.imgGame.setImageResource(data.get(position).imageId);
        holder.imgGame.setBackgroundColor(Data.getBackGroundColor(position));
        holder.card.setBackgroundColor(ContextCompat.getColor(MainActivity.mMainActivity,R.color.transparent));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(staticHolder!= null){
                    staticHolder.card.setBackgroundColor(ContextCompat.getColor(MainActivity.mMainActivity,R.color.transparent));
                    holder.card.setBackgroundColor(ContextCompat.getColor(MainActivity.mMainActivity,R.color.selected_card));
                }
                staticHolder = holder;
                previousPosition = position;
                MainActivity.mMainActivity.callBackShowDetails(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static void notifyDataSetchanged(){
        notifyDataSetchanged();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView tvGameCount;
        TextView tvGameName;
        ImageView imgGame;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGameName = (TextView) itemView.findViewById(R.id.tvGameName);
            imgGame = (ImageView) itemView.findViewById(R.id.imgGame);
            tvGameCount = (TextView) itemView.findViewById(R.id.tvGamesCount);
            card = (CardView) itemView.findViewById(R.id.card);
        }
    }
}
