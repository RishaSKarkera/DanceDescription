package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class DanceDetails implements Serializable{
    public String nam,ori,att,gen,nab,imageName,largeName;
    public DanceDetails(String name,String origin,String attire,String gener,String namedby,String imageName,String largeName)
    {
        this.nam=name;
        this.ori=origin;
        this.att=attire;
        this.gen=gener;
        this.nab=namedby;
        this.imageName=largeName;
    }
}
