package com.example.mycr2;

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

    public void setOnClickListener(ClickListener mListener){
        this.mListener = mListener;
    }

    public interface ClickListener{
        void OnItemClicked(int position);
        void OnAddClicked(int position);
        void OnDeleteClicked(int position);
    }

    public Adapter(List<CardItem> mDataList) {
        this.mDataList = mDataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView contents;
        Button add;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            contents = (TextView)itemView.findViewById(R.id.contents);
            add = (Button)itemView.findViewById(R.id.add);
            delete = (Button)itemView.findViewById(R.id.delete);

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
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        CardItem item = mDataList.get(position);
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());

        if(mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.OnItemClicked(pos);
                }
            });
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.OnAddClicked(pos);
                }
            });
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.OnDeleteClicked(pos);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void addItem(int position, CardItem item){
        mDataList.add(position,item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mDataList.size());
    }

    public void deleteItem(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDataList.size());
    }
}
