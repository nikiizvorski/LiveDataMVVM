package com.mvvm.nikiizvorski.livedatamvvm.util;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by nikiizvorski on 22/11/2017.
 *
 * @param <T> the type parameter
 */
public class RealmLiveData<T extends RealmModel> extends LiveData<RealmResults<T>> {
    private RealmResults<T> results;
    private final RealmChangeListener<RealmResults<T>> listener =
            new RealmChangeListener<RealmResults<T>>() {
                @Override
                public void onChange(@NonNull RealmResults<T> results) {
                    setValue(results);
                }
            };

    /**
     * Instantiates a new Realm live data.
     *
     * @param realmResults the realm results
     */
    public RealmLiveData(RealmResults<T> realmResults) {
        results = realmResults;
    }
    @Override
    protected void onActive() {
        results.addChangeListener(listener);
    }
    @Override
    protected void onInactive() {
        results.removeChangeListener(listener);
    }
}
