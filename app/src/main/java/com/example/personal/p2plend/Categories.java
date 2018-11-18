package com.lkkn.scanner.app.WorkFlow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lkkn.scanner.app.R;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        arrayList = new ArrayList<String>();
         databaseReference= FirebaseDatabase.getInstance().getReference();


        addItems();
        selection();
    }

    private void addItems() {
        arrayList.add("category1");
        arrayList.add("category2");
        arrayList.add("category2");
        arrayList.add("category3");
        arrayList.add("category4");


    }

    public void selection() {


        sv = (SearchView) findViewById(R.id.searchView1);
        lv = (ListView) findViewById(R.id.listView1);
        sv.setIconified(false);
        sv.setQueryHint("Select Services");
        /// sv.onActionViewExpanded();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {
                // TODO Auto-generated method stub
                sv.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {

                ArrayList<String> arrayList1 = new ArrayList<String>();
                for (String items : arrayList) {
                    if (items.toLowerCase().contains(text.toLowerCase())) {
                        arrayList1.add(items);
                    }
                }
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Categories.this, android.R.layout.simple_list_item_1, arrayList1);
                lv.setAdapter(adapter1);
                adapter.getFilter().filter(text);
                return true;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                Intent intent=new Intent(Servicess.this,Book.class);
//                intent.putExtra("service",lv.getItemAtPosition(i).toString());
//                startActivity(intent);
                String book = lv.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), book, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Categories.this, Servicess.class);
                intent.putExtra("book", lv.getItemAtPosition(i).toString());
                startActivity(intent);


            }
        });


    }
}
