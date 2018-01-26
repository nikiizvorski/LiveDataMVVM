package com.mvvm.nikiizvorski.livedatamvvm.ex;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by nikiizvorski on 22/11/2017.
 */
public class ExRepository implements ExRepositoryInfo {
    @Getter @Setter
    private String peter;

    /**
     * Instantiates a new Ex repository.
     */
    @Inject
    public ExRepository() {}
}
