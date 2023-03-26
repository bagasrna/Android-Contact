package com.example.bukutelepon;

public class Contact {
    public String nama;
    public String email;
    public String telepon;
    public int avatarId;
    public String alamat;

    public Contact(String n, String e, String t, int aid, String a) {
        this.nama = n;
        this.email = e;
        this.telepon = t;
        this.avatarId = aid;
        this.alamat = a;
    }

    public String inisial() {
        return this.nama == null ? "-" : String.valueOf(this.nama.charAt(0));
    }
}
