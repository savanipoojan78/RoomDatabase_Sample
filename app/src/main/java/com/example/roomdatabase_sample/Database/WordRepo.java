package com.example.roomdatabase_sample.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.roomdatabase_sample.Database.dao.MyWordDao;
import com.example.roomdatabase_sample.Database.entity.MyWord;

import java.util.List;

public class WordRepo {
    public MyWordDao myWordDao;
    public LiveData<List<MyWord>> mAllWords;
    public WordRepo(Application application)
    {
        WordRoomDatabase db=WordRoomDatabase.getDatabase(application);
        myWordDao=db.MywordDao();
        mAllWords=myWordDao.getAllWords();
    }
    LiveData<List<MyWord>> getAllWords() {
        return mAllWords;
    }
    public void insert (MyWord Myword) {
        new insertAsyncTask(myWordDao).execute(Myword);
    }
    public void deleteAll()
    {
        new DeleteAsycTask(myWordDao).execute();
    }

    private class insertAsyncTask extends AsyncTask<MyWord ,Void,Void> {
        private MyWordDao mAsyncTaskDao;

        public insertAsyncTask(MyWordDao myWordDao) {
            mAsyncTaskDao=myWordDao;
        }


        @Override
        protected Void doInBackground(MyWord... myWords) {
            mAsyncTaskDao.insert(myWords[0]);
            return null;
        }
    }
    private class DeleteAsycTask extends AsyncTask<MyWord ,Void,Void>{
        private MyWordDao mAsycDao;
        public DeleteAsycTask(MyWordDao mAsycDao)
        {
            this.mAsycDao=mAsycDao;
        }
        @Override
        protected Void doInBackground(MyWord... myWords) {
            mAsycDao.deleteAll();
            return null;
        }
    }
}
