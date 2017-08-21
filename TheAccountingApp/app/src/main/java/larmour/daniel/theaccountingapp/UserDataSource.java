package larmour.daniel.theaccountingapp;

import io.reactivex.Flowable;
import larmour.daniel.theaccountingapp.persistence.User;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

public interface UserDataSource {

    Flowable<User> getUser();

    void insertOrUpdateUser(User user);

    void deleteAllUsers();
}
