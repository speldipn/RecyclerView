package com.example.jyo05.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  TextView tv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    tv = findViewById(R.id.textView);

    Intent intent = getIntent();
    tv.setText(intent.getStringExtra(MainActivity.LIST_NAME));
  }
}
