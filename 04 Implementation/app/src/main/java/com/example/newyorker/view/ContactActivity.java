package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newyorker.R;

public class ContactActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("URL");

        webView = findViewById(R.id.webViewer);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URL);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.webviewtoolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.arrowBack) {

            finish();

        }
        return super.onOptionsItemSelected(item);
    }


    }
















