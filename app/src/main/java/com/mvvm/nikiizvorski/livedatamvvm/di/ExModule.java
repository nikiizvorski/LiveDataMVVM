package com.mvvm.nikiizvorski.livedatamvvm.di;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import dagger.Module;
import dagger.Provides;

import com.mvvm.nikiizvorski.livedatamvvm.ex.ExRepository;
import com.mvvm.nikiizvorski.livedatamvvm.ex.ExViewModel;
import com.mvvm.nikiizvorski.livedatamvvm.ex.ExViewModelFactory;
import com.mvvm.nikiizvorski.livedatamvvm.scope.CustomScope;

/**
 * Created by nikiizvorski on 22/11/2017.
 */

@Module
public class ExModule {
    private Context context;

    public ExModule(Context context) {
        this.context = context;
    }

    @Provides
    @CustomScope
    public Context getContext() {
        return context;
    }

    @Provides
    @CustomScope
    ExRepository exRepository(){
        return new ExRepository();
    }

    @Provides
    @CustomScope
    ExViewModelFactory exViewModelFactoryInfo(ExRepository exRepository){
        return new ExViewModelFactory(exRepository);
    }

    @Provides
    @CustomScope
    ExViewModel exViewModelaInfo(Context context, ExViewModelFactory exViewModelFactory){
        return ViewModelProviders.of((FragmentActivity) context, exViewModelFactory).get(ExViewModel.class);
    }

}
