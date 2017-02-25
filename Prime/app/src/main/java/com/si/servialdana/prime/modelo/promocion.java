package com.si.servialdana.prime.modelo;

/**
 * Created by ealmeida on 2/25/2017.
 */

public class promocion {
    private String name;
    private int thumbnail;

    public promocion() {
    }

    public promocion(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
