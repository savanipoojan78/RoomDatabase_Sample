package com.example.roomdatabase_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.roomwordssample.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        final EditText mEditWordView = findViewById(R.id.edit_word);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reply=new Intent();
                if(TextUtils.isEmpty(mEditWordView.getText()))
                {
                    setResult(RESULT_CANCELED);

                }
                else
                {
                    String word=mEditWordView.getText().toString();
                    reply.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, reply);
                }
                finish();
            }
        });
    }
}
