package com.lkkn.scanner.app.WorkFlow;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.lkkn.scanner.app.Bio;
import com.lkkn.scanner.app.Branches;
import com.lkkn.scanner.app.ChatNode;
import com.lkkn.scanner.app.R;
import com.lkkn.scanner.app.TokensList;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Servicess extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    GoogleApiClient googleApiClient;
    GoogleSignInOptions gso;
    ArrayList<String> arrayList;
    private String var;
    private ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private NavigationView navigationView;
    private View header;
    private SharedPreferences shared;
    public int backscreen=0;
    private String key;
    private DataSnapshot dataSnapshots;
    private String token;
    private Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

       // setIcon();
        arrayList = new ArrayList<String>();

        addItems();
        selection();

    }



    private void addItems() {
        arrayList.add("Book1");
        arrayList.add("Book2");
        arrayList.add("Book3");
        arrayList.add("Book4");
        arrayList.add("Book5");


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.servicess, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {







            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.update) {
            android.support.v4.app.Fragment update;

            }

            // Handle the camera action
        else if (id == R.id.token) {

            }



        else if (id == R.id.service) {
            startActivity(new Intent(getApplicationContext(), Servicess.class));

        }
        else if (id==R.id.chat){
            startActivity(new Intent(getApplicationContext(),ChatNode.class));
        }
//        else if (id==R.id.reschedule) {
//            android.support.v4.app.Fragment fragment;
//            fragment = new Refresh();
//            if (fragment != null) {
//                android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                backscreen = 1;
//                //Toast.makeText(this,getFragmentManager().getBackStackEntryCount(),Toast.LENGTH_LONG).show();
//
//                ft.replace(R.id.content_main, fragment, "Select");
//                ft.addToBackStack("Select");
//                //Bundle bundle = new Bundle();
//                //fragment.setArguments(bundle);
//                ft.commit();;
//
//        }


        //} else if (id == R.id.Path) {
//                android.support.v4.app.Fragment fragment;
//                fragment = new MapActivity();
//                if (fragment != null) {
//                    android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    backscreen = 1;
//                    //Toast.makeText(this,getFragmentManager().getBackStackEntryCount(),Toast.LENGTH_LONG).show();
//
//                    ft.replace(R.id.content_main, fragment, "branch");
//                    ft.addToBackStack("branch");
//                    //Bundle bundle = new Bundle();
//                    //fragment.setArguments(bundle);
//                    ft.commit();
           // }


           else if (id == R.id.nav_share) {

            }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {








    }
    public void submit(View view){

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference rootRefs = FirebaseDatabase.getInstance().getReference().child(var);
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Log.d("p",snapshot.getKey()+"");
                if (snapshot.hasChild(var)) {

//                    Toast.makeText(Servicess.this, "hijhhhjhj", Toast.LENGTH_LONG).show();
//                    System.out.println("yes");
//                    Log.d("tag","yes");
                    rootRefs.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild("withdrawal")) {

                              //  Toast.makeText(Servicess.this, "yijhhhjhj", Toast.LENGTH_LONG).show();
                                System.out.println("yes");
                                Log.d("tag", "yes");
                            }
                            else
                            {
                                Log.d("tag","no");
                                rootRefs.child("withdrawal").child("tc").setValue(1);
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });




                    // run some code
                }
                else {

                    //Toast.makeText(Servicess.this, "hihjhj", Toast.LENGTH_LONG).show();
                    System.out.println("no");
                    Log.d("tag","no");
                    // run some code
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(authStateListener);


    }

    @Override
    protected void onResume() {
        super.onResume();

        sv.clearFocus();
    }


    public void selection(){


        sv=(SearchView)findViewById(R.id.searchView1);
        lv=(ListView) findViewById(R.id.listView1);
        sv.setIconified(false);
        sv.setQueryHint("Select Services");
        /// sv.onActionViewExpanded();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
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

                ArrayList<String> arrayList1=new ArrayList<String>();
                for (String items:arrayList){
                    if (items.toLowerCase().contains(text.toLowerCase()))
                    {
                        arrayList1.add(items);
                    }
                }
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Servicess.this, android.R.layout.simple_list_item_1,arrayList1);
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
                String book=lv.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),book,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Servicess.this,choose.class);
                intent.putExtra("book",lv.getItemAtPosition(i).toString());
                startActivity(intent);


            }
        });


    }

    private void setIcon() {
        ImageView icon;
        icon = (ImageView) header.findViewById(R.id.profile_image);
        if (!shared.getString("image", "").equals("")) {
            Picasso.with(this).load(shared.getString("image","")).into(icon);
        }
        else {
            icon.setImageResource(R.drawable.image);

        }
        SharedPreferences shared = getSharedPreferences("loginData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("fcm", token);
        editor.commit();

    }




}