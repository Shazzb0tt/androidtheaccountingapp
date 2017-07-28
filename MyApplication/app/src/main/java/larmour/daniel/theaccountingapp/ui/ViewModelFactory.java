package larmour.daniel.theaccountingapp.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import larmour.daniel.theaccountingapp.UserDataSource;

/**
 * Created by Daniel Larmour on 7/29/2017.
 * email at daniellarmour@hotmail.com
 */

public class ViewModelFactory implements ViewModelProvider.Factory{

    private final UserDataSource mDataSource;

    public ViewModelFactory(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
