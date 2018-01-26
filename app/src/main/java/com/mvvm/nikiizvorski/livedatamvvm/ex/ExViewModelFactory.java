package com.mvvm.nikiizvorski.livedatamvvm.ex;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 22/11/2017.
 */
public class ExViewModelFactory implements ViewModelProvider.Factory, ExViewModelFactoryInfo {
    /**
     * The Ex repository.
     */
    @Inject
    ExRepository exRepository;

    /**
     * Instantiates a new Ex view model factory.
     *
     * @param exRepository the ex repository
     */
    @Inject
    public ExViewModelFactory(ExRepository exRepository) {
        this.exRepository = exRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ExViewModel(exRepository);
    }
}