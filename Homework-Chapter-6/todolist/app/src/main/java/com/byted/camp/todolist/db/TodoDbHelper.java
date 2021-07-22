package com.byted.camp.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "todo.db";
    private static final int DB_VERSION = 2;

    public TodoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO: 2021/7/19 3. 这里执行创建数据库操作
        db.execSQL(TodoContract.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: 2021/7/19 4. 这里执行升级数据库操作
        for(int version = oldVersion; version < newVersion; version++){
            if(version == 1){
                try {
                    db.execSQL(TodoContract.ADD_PRIORITY_COLUMN_SQL);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
