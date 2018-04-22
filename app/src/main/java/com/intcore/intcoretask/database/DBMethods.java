package com.intcore.intcoretask.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBMethods {


    public static int countRecords(SQLiteOpenHelper database, String table_name, boolean isDistinct, String condition) {
        int count = 0;
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            String sql;
            if (condition == null || condition.equals("")) {

                sql = isDistinct ? ("select distinct * from " + table_name) : "select * from " + table_name;
            } else
                sql = isDistinct ? ("select distinct * from " + table_name + " " + condition)
                        : ("select * from " + table_name + " " + condition);
            Cursor c = db.rawQuery(sql, null);
            if (c != null) {
                if (c.getCount() > 0) {
                    count = c.getCount();
                }
            }
            return count;
        } catch (
                Exception e) {

        }
        return count;
    }

    public static Cursor selectByTable(SQLiteOpenHelper database, String table_name, boolean isDistinct, String limit) {
        Cursor c;
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            String query = isDistinct ? ("select distinct * from " + table_name + ((limit.equals("") || limit == null) ? "" : " limit " + limit))
                    : ("select * from " + table_name + ((limit.equals("") || limit == null) ? "" : " limit " + limit));
            c = db.rawQuery(query, null);
            if (c != null) {
                if (c.getCount() > 0) {
                    return c;
                }
            }
            return null;
        } catch (
                Exception e) {

        }
        return null;
    }

    public static Cursor selectByConditions(SQLiteOpenHelper database, String table_name, boolean isDistinct, String condition, String limit) {
        Cursor c;
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            String query = "";
            if (null == condition || "".equals(condition))
                query = isDistinct ? ("select distinct * from " + table_name + ((limit.equals("") || limit == null) ? "" : " limit " + limit)) : ("select * from " + table_name + ((limit.equals("") || limit == null) ? "" : "limit " + limit));
            else
                query = isDistinct ? ("select distinct * from " + table_name + " Where " + condition + ((limit.equals("") || limit == null) ? "" : " limit " + limit)) : ("select * from " + table_name + " Where " + condition + ((limit.equals("") || limit == null) ? "" : " limit " + limit));
            c = db.rawQuery(query, null);
            if (c != null) {
                if (c.getCount() > 0) {
                    return c;
                }
            }
            return null;
        } catch (
                Exception e) {

        }
        return null;
    }

    public static Cursor selectByConditions(SQLiteOpenHelper database, String table_name,
                                            boolean isDistinct, String[] columns, String[] conditionColumns, String[] conditionValues,
                                            String groupBy, String having, String orderBy, String sortOrder, String limit) {
        Cursor c;
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            String selection = conditionColumns[0] + "=?";
            int length = conditionColumns.length;
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (i > 0)
                        selection = selection + " AND " + conditionColumns[i] + "=?";
                }
            }
            String ordering = null;
            if (orderBy != null && !orderBy.trim().equals("")) {
                if (sortOrder != null && !sortOrder.trim().equals(""))
                    ordering = orderBy + " " + sortOrder;
                else
                    ordering = orderBy;
            } else {
                ordering = null;
            }
            c = db.query(isDistinct, table_name, columns, selection,
                    conditionValues,
                    groupBy,
                    having,
                    ordering, limit);
            if (c != null) {
                if (c.getCount() > 0) {
                    return c;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cursor selectByJoins(SQLiteOpenHelper database, boolean isDistinct, String columns, String joins,
                                       String conditions, String groupBy, String having, String orderBy,
                                       String sortOrder, String limit) {
        Cursor c;
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            String ordering = "";
            String grouping = "";
            String having_ = "";
            if (!orderBy.equals("") && orderBy != null)
                ordering = "order by " + orderBy;
            if (!groupBy.equals("") && groupBy != null)
                grouping = "group by " + groupBy;
            if (!having.equals("") && having != null)
                having_ = "having " + having;

            String query = "select " + (isDistinct ? "distinct" : "") + columns + " from " + joins + " " + conditions + " " + grouping + " "
                    + having_ + " " + ordering + " " + sortOrder+ ((limit.equals("") || limit == null) ? "" : " limit " + limit);
            c = db.rawQuery(query, null);
            if (c != null) {
                if (c.getCount() > 0) {
                    return c;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("", e.getMessage());
        }
        return null;
    }

    public static boolean delete(SQLiteOpenHelper database, String tableName, String condition) {

        try {
            SQLiteDatabase db = database.getWritableDatabase();
            String sql;

            if (condition == null || condition.equals(""))
                sql = "delete from " + tableName;
            else
                sql = "delete from " + tableName + " where " + condition;
            db.execSQL(sql);
            return true;
        } catch (Exception e) {
            e.getCause();
        }
        return false;
    }

    public static long update(SQLiteOpenHelper database, String TableName, ContentValues cv, String whereClause, String[] whereArgs) {

        try {
            SQLiteDatabase db = database.getWritableDatabase();
            try {
                int update = db.update(TableName, cv, whereClause, whereArgs);
                return update;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static boolean update(SQLiteOpenHelper database, String TableName, String setValues, String whereClause) {

        try {
            SQLiteDatabase db = database.getWritableDatabase();
            try {
                String updateQuery = "UPDATE " + TableName + " SET " + setValues + " WHERE " + whereClause;
                db.execSQL(updateQuery, null);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean exists(SQLiteOpenHelper database, String tableName, boolean isDistinct, String condition) {
        int count = countRecords(database, tableName, isDistinct, condition);
        return count > 0;
    }

    public static long insert(SQLiteOpenHelper database, String tableName, ContentValues cv) {//
        SQLiteDatabase db = database.getWritableDatabase();
        try {
            long check = db.insert(tableName, null, cv);
            return check;
        } catch (Exception e) {
            return 0;
        }
    }



}
