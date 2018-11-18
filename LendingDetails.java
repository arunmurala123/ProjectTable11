package com.example.asus.bl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LendingDetails extends AppCompatActivity {

    EditText bname,aname,pname,price,cat;
    Button lend;
    String book_name,pub_name,aut_name, prices, cat_name;
    DatabaseReference fb,ref,priceref,anameref,pnameref,bnameref,catref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lending_details);

        bname=findViewById(R.id.book_name);
        aname=findViewById(R.id.author_name);
        pname=findViewById(R.id.publisher_name);
        price=findViewById(R.id.price_book);
        cat=findViewById(R.id.category);


        lend=findViewById(R.id.lend);




    }
    public void lend(View v)
    {
        book_name=bname.getText().toString();
        aut_name=aname.getText().toString();
        pub_name=pname.getText().toString();
        prices= price.getText().toString();
        cat_name=cat.getText().toString();

        fb=FirebaseDatabase.getInstance().getReference();

        ref=fb.child("lend");


        catref=ref.child(cat_name);

        bnameref=catref.child(book_name);

        priceref=bnameref.child("price");
        anameref=bnameref.child("author");
        pnameref=bnameref.child("publisher");

        priceref.setValue(prices);
        pnameref.setValue(pub_name);
        anameref.setValue(aut_name);
    }
}
