package com.mvvm.nikiizvorski.livedatamvvm.db;

import io.realm.RealmModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by nikiizvorski on 22/11/2017
 */
@NoArgsConstructor
public class ExUser implements RealmModel{
    @Getter @Setter
    String name;
    @Getter @Setter
    String age;
}
