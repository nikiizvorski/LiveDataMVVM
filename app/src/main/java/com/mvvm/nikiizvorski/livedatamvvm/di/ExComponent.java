package com.mvvm.nikiizvorski.livedatamvvm.di;

import com.mvvm.nikiizvorski.livedatamvvm.MainActivity;
import com.mvvm.nikiizvorski.livedatamvvm.scope.CustomScope;

import dagger.Component;

/**
 * Created by nikiizvorski on 22/11/2017.
 */

@CustomScope
@Component(modules = ExModule.class)
public interface ExComponent {

    /**
     * Inject.
     *
     * @param mapActivity the landing screen
     */
    void inject(MainActivity mapActivity);
}