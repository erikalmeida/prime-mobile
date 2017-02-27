package com.si.servialdana.prime.sql.modelo;

/**
 * Created by ealmeida on 2/14/2017.
 */

public class servicio {

    private String name;
    private int numOfSongs;
    private int thumbnail;

    public servicio() {
    }

    public servicio(String name, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
