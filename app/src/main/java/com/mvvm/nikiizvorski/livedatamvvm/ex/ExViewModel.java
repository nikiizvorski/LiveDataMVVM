package com.mvvm.nikiizvorski.livedatamvvm.ex;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by nikiizvorski on 22/11/2017.
 */

public class ExViewModel extends ViewModel implements ExViewModelaInfo {
    @Inject
    ExRepository exRepository;

    private MutableLiveData<String> infoName = new MutableLiveData<>();

    @Inject
    public ExViewModel(ExRepository exRepository) {
        this.exRepository = exRepository;
    }

    public LiveData<String> getInfoName() {
        infoName.setValue(exRepository.getPeter());
        return infoName;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        exRepository = null;
    }

    public void setInfoName(CharSequence charSequence) {
        exRepository.setPeter(String.valueOf(charSequence));
        infoName.setValue(exRepository.getPeter());
    }
}
