package larmour.daniel.theaccountingapp;

import android.content.Context;

import larmour.daniel.theaccountingapp.persistence.LocalUserDataSource;
import larmour.daniel.theaccountingapp.persistence.UsersDatabase;
import larmour.daniel.theaccountingapp.ui.ViewModelFactory;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

public class Injection {
    public static UserDataSource providedUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.mUserDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = providedUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
