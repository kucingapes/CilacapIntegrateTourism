package com.kucingapes.utsman.cilacaptourism;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        web = (TextView) findViewById(R.id.web);
        web.setText(Html.fromHtml(getString(R.string.web)));
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("http://uhamka.ac.id"));
                startActivity(browser);
            }
        });
    }
}
