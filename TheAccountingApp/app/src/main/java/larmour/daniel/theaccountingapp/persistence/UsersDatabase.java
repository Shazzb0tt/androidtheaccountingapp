package larmour.daniel.theaccountingapp.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

@Database(entities = {User.class}, version = 2)
public abstract class UsersDatabase extends RoomDatabase {
    private static   UsersDatabase sINSTANCE;
    public  abstract UserDao       mUserDao();

    public static UsersDatabase getInstance(Context context) {
        if(sINSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if(sINSTANCE == null) {
                    sINSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsersDatabase.class,
                            "User.db")
                            .build();
                }
            }
        }
        return sINSTANCE;
    }
}
