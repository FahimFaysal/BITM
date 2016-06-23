package com.acrophillic.listviewdemo;

import java.io.Serializable;

/**
 * Created by fahim on 6/23/2016.
 */
public class Poet  implements Serializable {

    private String name;
    private String description;

    public Poet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
