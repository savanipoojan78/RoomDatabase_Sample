package com.example.roomdatabase_sample.Database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "WORD")
public class MyWord {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String myWord;

    public String getMyWord() {
        return myWord;
    }

    public MyWord(@NonNull String myWord)
    {
        this.myWord=myWord;
    }
}
