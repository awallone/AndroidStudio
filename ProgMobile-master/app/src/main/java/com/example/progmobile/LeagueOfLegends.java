package com.example.progmobile;

import android.graphics.Picture;
import android.media.Image;
import android.net.LinkAddress;
import android.widget.ImageView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class LeagueOfLegends {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("ville")
    @Expose
    private String ville;
    @SerializedName("image")
    @Expose
    private String image;

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }

    public String getVille(){
        return ville;
    }
    public void setVille(String ville){
        this.ville=ville;
    }
}

