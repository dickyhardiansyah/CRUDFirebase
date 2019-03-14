package me.dicky.crudfirebase.Model;

public class Request {
    private String nama;
    private String email;
    private String desk;

    private String key;

    public Request(){

    }

    public Request(String nama, String email, String desk) {
        this.nama = nama;
        this.email = email;
        this.desk = desk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString(){
        return " "+nama+"\n"+
                " "+email+"\n"+
                " "+desk;
    }
}
