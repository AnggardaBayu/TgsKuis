package com.example.tugaskuis;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    DatabaseReference reference;
//    RecyclerView recyclerView;
//    ArrayList<Profile> list;
//    MyAdapter adapter;
    ArrayList<String> nama = new ArrayList<>();
    Firebase fbs;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager( this));
//        list = new ArrayList<Profile>();
//        reference = FirebaseDatabase.getInstance().getReference().child("Profiles");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
//                    Profile p = dataSnapshot1.getValue(Profile.class);
//                    list.add(p);
//                }
//                adapter = new MyAdapter( MainActivity.this, list);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(MainActivity.this, "Errorrr", Toast.LENGTH_SHORT).show();
//            }
//        });
        Firebase.setAndroidContext(this);

        fbs = new Firebase ("https://fir-b47a5.firebaseio.com/Nama");
        lv = (ListView)findViewById(R.id.ListView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nama);

        lv.setAdapter(arrayAdapter);
        fbs.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                nama.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
