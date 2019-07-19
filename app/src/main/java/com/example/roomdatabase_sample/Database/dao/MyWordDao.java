package com.example.roomdatabase_sample.Database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.roomdatabase_sample.Database.entity.MyWord;

import java.util.List;

@Dao
public interface MyWordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MyWord myWord);

    @Query("DELETE FROM WORD")
    void deleteAll();

    @Query("SELECT * from WORD ORDER BY word DESC")
    LiveData<List<MyWord>> getAllWords();
}
