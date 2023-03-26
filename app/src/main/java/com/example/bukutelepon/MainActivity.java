package com.example.bukutelepon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Si A", "sia@ub.ac.id", "0811"));
        contacts.add(new Contact("Si B", "sib@ub.ac.id", "0812"));
        contacts.add(new Contact("Si C", "sic@ub.ac.id", "0813"));
        contacts.add(new Contact("Si D", "sid@ub.ac.id", "0814"));
        contacts.add(new Contact("Si E", "sie@ub.ac.id", "0815"));
        contacts.add(new Contact("Si F", "sif@ub.ac.id", "0816"));
        contacts.add(new Contact("Si G", "sig@ub.ac.id", "0817"));
        contacts.add(new Contact("Si H", "sih@ub.ac.id", "0818"));
        contacts.add(new Contact("Si I", "sii@ub.ac.id", "0819"));
        contacts.add(new Contact("Si J", "sij@ub.ac.id", "0810"));

        // Buat adapter
        ContactAdapter cAdapter = new ContactAdapter(this, contacts);

        // Ambil RecycleView dari layout
        RecyclerView rvContacts = this.findViewById(R.id.rvKontak);

        // Set layout manager
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        // Sambungkan Adapter ke RecycleView
        rvContacts.setAdapter(cAdapter);

        // Ambil objek EditText filter dari layout
        EditText editTextFilter = this.findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                cAdapter.getFilter().filter(editable.toString());
            }
        });

    }
}