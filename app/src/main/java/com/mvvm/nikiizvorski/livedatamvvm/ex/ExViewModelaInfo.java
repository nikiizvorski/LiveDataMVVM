package com.mvvm.nikiizvorski.livedatamvvm.ex;

import android.arch.lifecycle.LiveData;

/**
 * Created by nikiizvorski on 22/11/2017.
 */
public interface ExViewModelaInfo {
    /**
     * Gets info name.
     *
     * @return the info name
     */
    LiveData<String> getInfoName();

    /**
     * Sets info name.
     *
     * @param charSequence the char sequence
     */
    void setInfoName(CharSequence charSequence);
}
