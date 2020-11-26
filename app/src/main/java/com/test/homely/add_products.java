package com.test.homely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_products extends AppCompatActivity {

    EditText txt_product_name,txt_product_quantity;
    Button btn_add;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
        firebaseFirestore= FirebaseFirestore.getInstance();

        txt_product_name=findViewById(R.id.txt_p_name);
        txt_product_quantity=findViewById(R.id.txt_p_quantity);
        btn_add=findViewById(R.id.btn_add_product);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            add_product(txt_product_name.getText().toString(),txt_product_quantity.getText().toString());
            }
        });

    }

    public void add_product(String product_name,String quantity){
        Map<String, Object> product_entry = new HashMap<>();
        product_entry.put("Name", product_name);
        product_entry.put("Qty", quantity);

        firebaseFirestore.collection("products")
                .add(product_entry)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(add_products.this, "Product Successfully added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Error", e.getMessage());
                    }
                });
    }
}