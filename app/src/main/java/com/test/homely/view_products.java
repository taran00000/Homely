package com.test.homely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class view_products extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Products> list;
    products_viewholder adapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);
        db= FirebaseFirestore.getInstance();
        list=new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view_products.this, 1));
        get_products();

    }
    public void get_products(){
        db.collection("products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isComplete()){
                        String temp="";
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        Products products =documentSnapshot.toObject(Products.class);
                        list.add(products);
                        temp=documentSnapshot.getString("Name");

                    }
                    Log.i("Detectxxx",String.valueOf(list.get(0).getName()));
                    adapter = new products_viewholder(view_products.this, list);
                    recyclerView.setAdapter(adapter);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(view_products.this, e.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}