package com.mvvm.nikiizvorski.livedatamvvm.ex;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 22/11/2017.
 */
public class ExViewModel extends ViewModel implements ExViewModelaInfo {
    /**
     * The Ex repository.
     */
    @Inject
    ExRepository exRepository;

    private MutableLiveData<String> infoName = new MutableLiveData<>();

    /**
     * Instantiates a new Ex view model.
     *
     * @param exRepository the ex repository
     */
    @Inject
    public ExViewModel(ExRepository exRepository) {
        this.exRepository = exRepository;
    }

    @Override
    public LiveData<String> getInfoName() {
        infoName.setValue(exRepository.getPeter());
        return infoName;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        exRepository = null;
    }

    @Override
    public void setInfoName(CharSequence charSequence) {
        exRepository.setPeter(String.valueOf(charSequence));
        infoName.setValue(exRepository.getPeter());
    }
}
