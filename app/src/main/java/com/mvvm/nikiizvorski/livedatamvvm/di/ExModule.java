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

    /**
     * Instantiates a new Ex module.
     *
     * @param context the context
     */
    public ExModule(Context context) {
        this.context = context;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    @Provides
    @CustomScope
    public Context getContext() {
        return context;
    }

    /**
     * Ex repository ex repository.
     *
     * @return the ex repository
     */
    @Provides
    @CustomScope
    ExRepository exRepository(){
        return new ExRepository();
    }

    /**
     * Ex view model factory info ex view model factory.
     *
     * @param exRepository the ex repository
     * @return the ex view model factory
     */
    @Provides
    @CustomScope
    ExViewModelFactory exViewModelFactoryInfo(ExRepository exRepository){
        return new ExViewModelFactory(exRepository);
    }

    /**
     * Ex view modela info ex view model.
     *
     * @param context            the context
     * @param exViewModelFactory the ex view model factory
     * @return the ex view model
     */
    @Provides
    @CustomScope
    ExViewModel exViewModelaInfo(Context context, ExViewModelFactory exViewModelFactory){
        return ViewModelProviders.of((FragmentActivity) context, exViewModelFactory).get(ExViewModel.class);
    }

}
