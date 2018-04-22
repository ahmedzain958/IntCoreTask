package com.intcore.intcoretask.database;

public class DatabaseConst {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "FollowersDatabase";


    public static final String FOLLOWER = "Follower";
    public static final String NAME = "name";
    public static final String BIO = "bio";
    public static final String IMAGE_URL = "image_url";


    public static final String FOLLOWER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            FOLLOWER + "(ID INTEGER,"
            + NAME + " TEXT,"
            + BIO + " TEXT,"
            + IMAGE_URL + " INTEGER )";

    public static final String FOLLOWER_DROP = "DROP TABLE IF EXISTS " + FOLLOWER;
}
