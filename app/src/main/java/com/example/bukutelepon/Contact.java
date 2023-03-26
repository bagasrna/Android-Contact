package com.example.bukutelepon;

public class Contact {
    public String nama;
    public String email;
    public String telepon;

    public Contact(String n, String e, String t) {
        this.nama = n;
        this.email = e;
        this.telepon = t;
    }

    public String inisial() {
        return this.nama == null ? "-" : String.valueOf(this.nama.charAt(0));
    }
}
