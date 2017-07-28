package larmour.daniel.theaccountingapp.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users LIMIT 1")
    Flowable<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("DELETE FROM Users")
    void deleteAllUsers();
}
