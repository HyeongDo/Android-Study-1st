package com.example.mycardrecycerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final List<CardItem> mDataList;
    private ClickListener mListener;
    public Adapter(List<CardItem> dataList){
        mDataList = dataList;

    }

    public void setOnClickListener(ClickListener listener){
        mListener = listener;
    }

    public interface ClickListener{
        void onItemClicked(int position);
        void onAddClicked(int position);
        void onDeleteClicked(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView contents;
        Button button;
        Button button2;


        public ViewHolder(View itemview){
            super(itemview);
            title = (TextView)itemview.findViewById(R.id.textView);
            contents = (TextView)itemview.findViewById(R.id.content);
            button = (Button)itemview.findViewById(R.id.button);
            button2 = (Button)itemview.findViewById(R.id.button2);
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        CardItem item = mDataList.get(position);
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());

        if(mListener != null){
            final int pos = position;
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onAddClicked(pos);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            holder.button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onDeleteClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void removeItem(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDataList.size());
    }
    public void addItem(int position,CardItem item){
        mDataList.add(position,item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mDataList.size());

    }

}
