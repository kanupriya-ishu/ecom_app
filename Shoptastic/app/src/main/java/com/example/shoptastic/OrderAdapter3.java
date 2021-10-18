package com.example.shoptastic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter3 extends RecyclerView.Adapter<OrderAdapter3.ViewHolder> {

    List<Model> modelList;
    Context context;

    public OrderAdapter3(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public OrderAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new OrderAdapter3.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(OrderAdapter3.ViewHolder holder, int position) {

        // here we will find the position and start setting the output on our views

        String nameofItem = modelList.get(position).getmItemName();
        String descriptionofItem = modelList.get(position).getmItemDetail();
        int images = modelList.get(position).getmItemPhoto();

        holder.mItemName.setText(nameofItem);
        holder.mItemDescription.setText(descriptionofItem);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    // in order to make our views responsive we can implement onclicklistener on our recyclerview

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // here we will find the views on which we will inflate our data

        TextView mItemName, mItemDescription;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.itemName);
            mItemDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            // lets get the position of the view in list and then work on it

            int position = getAdapterPosition();

            if (position == 0) {
                Intent intent = new Intent(context, Men1Activity.class);
                context.startActivity(intent);
            }

        }
    }
}
