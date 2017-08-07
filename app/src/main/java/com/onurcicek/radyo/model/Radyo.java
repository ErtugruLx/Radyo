package com.onurcicek.radyo.model;

/**
 * Created by plox on 10.12.2016.
 */

/**
 * Created by plox on 10.12.2016.
 */

public class Radyo{
    private String radyoid,radyoismi,radyourl,radyofotograf;


    public Radyo() {
    }

    public Radyo(String radyoid,String radyoismi,String radyourl,String radyofotograf) {
        this.radyoid=radyoid;
        this.radyoismi = radyoismi;
        this.radyourl=radyourl;
        this.radyofotograf=radyofotograf;
    }

    public String getRadyoid() {
        return radyoid;
    }

    public void setRadyoid(String radyoid) {
        this.radyoid = radyoid;
    }

    public String getRadyoismi() {
        return radyoismi;
    }

    public void setRadyoismi(String radyoismi) {
        this.radyoismi = radyoismi;
    }

    public String getRadyourl() {
        return radyourl;
    }

    public void setRadyourl(String radyourl) {
        this.radyourl = radyourl;
    }

    public String getRadyofotograf() {
        return radyofotograf;
    }

    public void setRadyofotograf(String radyofotograf) {
        this.radyofotograf = radyofotograf;
    }
}
