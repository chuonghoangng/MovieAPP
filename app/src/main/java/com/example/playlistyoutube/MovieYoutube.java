package com.example.playlistyoutube;

public class MovieYoutube {
    private String  title;
    private String thumbnail;

    private String idvieo;
    private String description;


    public MovieYoutube() {
    }



    public MovieYoutube(String title, String thumbnail, String idvieo) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.idvieo = idvieo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIdvieo() {
        return idvieo;
    }

    public void setIdvieo(String idvieo) {
        this.idvieo = idvieo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
