package jp.android.myapp.hotelmapsapplicaitions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AwajiFumio on 2015/07/21.
 */
public class MyDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "myDatabase.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "myData";

    static final String ID = "id";

    static final String NAME = "Name";

    static final String ADD_NAME = "AddrName";

    static final String TELL = "Tell";

    static final String MONEY = "Money";

    static final String PARKING_LOT = "ParkingLot";

    public MyDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+ TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME + " TEXT," +
                ADD_NAME + " TEXT," +
                TELL + " TEXT," +
                MONEY + " TEXT," +
                PARKING_LOT + " TEXT);";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

}
