package com.example.roomdatabase_sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase_sample.Database.entity.MyWord;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    final LayoutInflater layoutInflater;
   private List<MyWord> mWord;
   public  WordListAdapter(Context context) { layoutInflater = LayoutInflater.from(context); }

   @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=layoutInflater.inflate(R.layout.recycleview_item,viewGroup,false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {
        if(mWord!=null)
        {
            MyWord current=mWord.get(i);
            wordViewHolder.mTextView.setText(current.getMyWord());
        }
        else
        {
            wordViewHolder.mTextView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(mWord!=null)
            return mWord.size();
        return 0;
    }
    class WordViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView mTextView;
         WordViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
    void setWords(List<MyWord> words){
        mWord = words;
        notifyDataSetChanged();
    }
}
