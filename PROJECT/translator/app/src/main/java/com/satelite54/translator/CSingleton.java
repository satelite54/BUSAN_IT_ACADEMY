package com.satelite54.translator;

public class CSingleton {
    public static String text = "";
    public static CSingleton Singleton = null;

    public static CSingleton getInstance() {
        if(Singleton == null) {
            Singleton = new CSingleton();
            return Singleton;
        }
        else {
            return Singleton;
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
