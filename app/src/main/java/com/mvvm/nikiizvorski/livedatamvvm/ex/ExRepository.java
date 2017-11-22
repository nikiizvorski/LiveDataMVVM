package com.mvvm.nikiizvorski.livedatamvvm.ex;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 22/11/2017.
 */

public class ExRepository implements ExRepositoryInfo {
    private String peter;

    @Inject
    public ExRepository() {}

    public String getPeter() {
        return peter;
    }

    public void setPeter(String peter) {
        this.peter = peter;
    }
}
