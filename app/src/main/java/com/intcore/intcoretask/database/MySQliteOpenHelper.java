package com.intcore.intcoretask.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.intcore.intcoretask.database.DatabaseConst.DATABASE_NAME;
import static com.intcore.intcoretask.database.DatabaseConst.DATABASE_VERSION;

public class MySQliteOpenHelper extends SQLiteOpenHelper {

    private static MySQliteOpenHelper mInstance = null;

    public static MySQliteOpenHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new MySQliteOpenHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    private MySQliteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseConst.FOLLOWER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseConst.FOLLOWER_DROP);
        onCreate(db);
    }


}
