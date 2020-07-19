package com.example.tablayout_fragments_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class PersonalChatWindow extends AppCompatActivity {
    ImageView personalChatImage;
    TextView personalChatName;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_chat_window);

        //TOOLBAR
        toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        personalChatImage = findViewById(R.id.personalChatImage);
        personalChatName = findViewById(R.id.personalChatName);
        personalChatImage.setImageResource(getIntent().getIntExtra("chatImage",00));
        personalChatName.setText(getIntent().getStringExtra("chatName"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
