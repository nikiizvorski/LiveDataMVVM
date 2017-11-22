package com.mvvm.nikiizvorski.livedatamvvm.db;

import io.realm.RealmModel;

/**
 * Created by nikiizvorski on 22/11/2017.
 */

public class ExUser implements RealmModel{
    String name;
    String age;

    public ExUser() {
    }

    public ExUser(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
