package larmour.daniel.theaccountingapp.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Shazzb0t on 7/29/2017.
 */

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "userid")
    private String mId;

    @ColumnInfo(name = "username")
    private String mUserName;

    @ColumnInfo(name = "ird_number")
    private String mIrdNumber;

    @Ignore
    public User(String userName) {
        mId = UUID.randomUUID().toString();
        mUserName = userName;
        mIrdNumber = "" + new Random().nextInt(999);
        for(int i = 0; i < 2; i++) {
            mIrdNumber += " - " + new Random().nextInt(999);
        }
    }

    @Ignore
    public User(String id, String userName) {
        mId = id;
        mUserName = userName;
        mIrdNumber = "" + new Random().nextInt(999);
        for(int i = 0; i < 2; i++) {
            mIrdNumber += " - " + new Random().nextInt(999);
        }
    }

    public User(String id, String userName, String irdNumber) {
        mId = id;
        mUserName = userName;
        mIrdNumber = irdNumber;
    }

    public String getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getIrdNumber() {
        return mIrdNumber;
    }
}