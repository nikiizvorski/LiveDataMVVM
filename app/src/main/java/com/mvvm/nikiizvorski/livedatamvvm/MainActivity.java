package com.mvvm.nikiizvorski.livedatamvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.mvvm.nikiizvorski.livedatamvvm.di.DaggerExComponent;
import com.mvvm.nikiizvorski.livedatamvvm.di.ExModule;
import com.mvvm.nikiizvorski.livedatamvvm.ex.ExRepository;
import com.mvvm.nikiizvorski.livedatamvvm.ex.ExViewModel;
import com.mvvm.nikiizvorski.livedatamvvm.ex.ExViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @Inject ExViewModel exViewModel;
    @BindView(R.id.textViewa)
    TextView textView;
    @BindView(R.id.editText)
    EditText nameEdit;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        DaggerExComponent.builder().exModule(new ExModule(this)).build().inject(this);
        subscribe();
        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    exViewModel.setInfoName(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void subscribe() {
        final Observer<String> elapsedTimeObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String aLong) {
                if (aLong != null) {
                    textView.setText(String.valueOf(aLong));
                }
            }
        };

        exViewModel.getInfoName().observe(this, elapsedTimeObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
