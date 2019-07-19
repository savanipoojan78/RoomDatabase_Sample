package com.example.roomdatabase_sample.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.roomdatabase_sample.Database.entity.MyWord;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepo mWordRepo;
    private LiveData<List<MyWord>> mAllWords;
    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepo=new WordRepo(application);
        mAllWords=mWordRepo.getAllWords();





    }
    public LiveData<List<MyWord>> getAllWords() { return mAllWords; }
    public void insert(MyWord Myword) { mWordRepo.insert(Myword); }
    public void deleteAll(){mWordRepo.deleteAll();}

}
