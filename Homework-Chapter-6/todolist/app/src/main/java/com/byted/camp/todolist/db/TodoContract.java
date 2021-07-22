package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

import java.net.ContentHandler;

public final class TodoContract {

    // TODO 1. 定义创建数据库以及升级的操作
    public static  final  String CREATE_SQL =
            "CREATE TABLE"+TodoNote.Name+"(("+TodoNote._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +TodoNote.Date+" INTEGER, "
                    +TodoNote.State+" INTEGER, "
                    +TodoNote.Content+" TEXT, "
                    +TodoNote.Priority+" INTEGER)";
    public static final String ADD_PRIORITY_COLUMN_SQL =
            "ALTER TABLE " + TodoNote.Name + " ADD " + TodoNote.Priority + " INTEGER";
    private TodoContract() {

    }

    public static class TodoNote implements BaseColumns {
        // TODO 2.此处定义表名以及列明
        public  static  final  String Name="note";
        public static  final  String Date="date";
        public  static  final  String State="state";
        public static  final String Content="content";
        public  static  final  String Priority="priority";
    }

}
