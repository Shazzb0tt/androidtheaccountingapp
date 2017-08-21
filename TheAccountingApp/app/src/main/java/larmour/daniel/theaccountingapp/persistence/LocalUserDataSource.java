package larmour.daniel.theaccountingapp.persistence;

import io.reactivex.Flowable;
import larmour.daniel.theaccountingapp.UserDataSource;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

public class LocalUserDataSource implements UserDataSource {

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public Flowable<User> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public void insertOrUpdateUser(User user) {
        mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
