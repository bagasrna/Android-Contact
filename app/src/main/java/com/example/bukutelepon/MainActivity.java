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
        contacts.add(new Contact("Bagas", "bagas@ub.ac.id", "081156784595", R.drawable.av1, "Malang"));
        contacts.add(new Contact("Raditya", "raditya@ub.ac.id", "081236747539", R.drawable.av2, "Madiun"));
        contacts.add(new Contact("Nafi", "nafi@ub.ac.id", "081337639643", R.drawable.av3, "Kediri"));
        contacts.add(new Contact("Ahmad", "ahmad@ub.ac.id", "081405416753", R.drawable.av4, "Lamongan"));
        contacts.add(new Contact("Fathoni", "fathoni@ub.ac.id", "081586375654", R.drawable.av5, "Solo"));
        contacts.add(new Contact("Meganata", "meganatas@ub.ac.id", "081676546789", R.drawable.av6, "Pacitan"));
        contacts.add(new Contact("Akbar", "akbar@ub.ac.id", "081734873789", R.drawable.av7, "Lumajang"));
        contacts.add(new Contact("Budi", "budi@ub.ac.id", "081856107534", R.drawable.av8, "Bekasi"));
        contacts.add(new Contact("Mahda", "mahda@ub.ac.id", "081917896578", R.drawable.av9, "Tangerang"));
        contacts.add(new Contact("Aldy", "aldy@ub.ac.id", "081034890266", R.drawable.av10, "Medan"));

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