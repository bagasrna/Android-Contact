package com.example.bukutelepon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContactAdapter extends RecyclerView.Adapter implements Filterable {

    private final Context ctx;
    private List<Contact> contacts;
    private List<Contact> contactsFilter;

    // digunakan untuk memasukan context ke dataset ke dalam Adapter
    public ContactAdapter(Context ctx, List<Contact> contacts) {
        this.ctx = ctx;
        this.contacts = contacts;
        this.contactsFilter = contacts;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence search) {
                FilterResults results = new FilterResults();
                if (search.length() == 0) {
                    contactsFilter = contacts;
                    results.count = contactsFilter.size();
                    results.values = contactsFilter;
                } else {
                    contactsFilter = new ArrayList<>();
                    for(Contact c : contacts) {
                        if (c.nama.toLowerCase().contains(search)
                                || c.telepon.toLowerCase().contains(search)
                                || c.email.toLowerCase().contains(search)) {
                            contactsFilter.add(c);
                        }
                        results.count = contactsFilter.size();
                        results.values = contactsFilter;
                    }
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                contactsFilter = (List<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class VHContact extends RecyclerView.ViewHolder {
        public TextView tvInisial;
        public TextView tvNama;
        public TextView tvEmail;
        public TextView tvTelepon;

        public ImageView ivAvatar;

        public VHContact(View rowView) {
            super(rowView);
            this.tvInisial = rowView.findViewById(R.id.tvInisial);
            this.tvNama = rowView.findViewById(R.id.tvNama);
            this.tvEmail = rowView.findViewById(R.id.tvEmail);
            this.tvTelepon = rowView.findViewById(R.id.tvTelepon);
            this.ivAvatar = rowView.findViewById(R.id.ivAvatar);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VHContact(
          LayoutInflater.from(this.ctx).inflate(R.layout.row_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact c = this.contactsFilter.get(position);
        VHContact vh = (VHContact) holder;
        vh.tvInisial.setText(c.inisial());
        vh.tvNama.setText(c.nama);
        vh.tvEmail.setText(c.email);
        vh.tvTelepon.setText(c.telepon);
    }

    @Override
    public int getItemCount() {
        return this.contactsFilter.size();
    }
}
