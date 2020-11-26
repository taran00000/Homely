package com.test.homely;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class products_viewholder extends RecyclerView.Adapter<products_viewholder.products>{

    Context context;
    ArrayList <Products> _products;
    public  static  String ph;
    public  static  String id;

    public products_viewholder(Context c , ArrayList<Products> p)
    {
        context = c;
        _products = p;
    }


    @NonNull
    @Override
    public products onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new products(LayoutInflater.from(context).inflate(R.layout.card_layout,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final products holder, final int position) {

        holder.Name.setText("Product name - "+ _products.get(position).getName());
        holder.Price.setText("Qty - "+_products.get(position).getQty());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return _products.size();
    }

    class products extends RecyclerView.ViewHolder{
        TextView Id;
        TextView Name;
        TextView Price;
        CardView cardView;

        public products(View itemView){
            super(itemView);
            Id  = (TextView) itemView.findViewById(R.id._id);
            Name  = (TextView) itemView.findViewById(R.id.name);
            Price  = (TextView) itemView.findViewById(R.id.qty);
            cardView = (CardView)itemView.findViewById(R.id.cardview);
        }
    }








}
