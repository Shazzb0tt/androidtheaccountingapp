package larmour.daniel.theaccountingapp.ui;

import android.arch.lifecycle.ViewModel;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import larmour.daniel.theaccountingapp.UserDataSource;
import larmour.daniel.theaccountingapp.persistence.User;

/**
 * Created by Daniel Larmour on 7/29/2017.
 * email at daniellarmour@hotmail.com
 */

public class UserViewModel extends ViewModel {
    private final UserDataSource mDataSource;
    private       User           mUser;

    public UserViewModel(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    public Flowable<String> getUserName() {
        return mDataSource.getUser()
                            .map(new Function<User, String>() {
                                @Override
                                public String apply(@NonNull User user) throws Exception {
                                    return user.getUserName();
                                }
                            });
    }

    public Completable updateUserName(final String userName) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                mUser = mUser == null
                        ? new User(userName)
                        : new User(mUser.getId(), userName);

                mDataSource.insertOrUpdateUser(mUser);
            }
        });
    }
}
