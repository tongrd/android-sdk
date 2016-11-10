package com.tongdao.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tongdao.sdk.TongDao;


public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setIcon(R.drawable.ic_launcher);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.getSupportActionBar().setTitle(" Sign test");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setBackgroundDrawable(this.getResources().getDrawable(R.drawable.bar));
        setContentView(R.layout.activity_log_in);
        this.findViewById(R.id.user1_longin).setOnClickListener(this);
        this.findViewById(R.id.user2_longin).setOnClickListener(this);
        this.findViewById(R.id.logout).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == android.R.id.home){
            finish();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v) {
        TongDao tongDao = ((TongDaoShowApplication)getApplication()).getTongDao();
        switch (v.getId()) {
            case R.id.user1_longin:
                tongDao.login(LogInActivity.this, "John");
                break;
            case R.id.user2_longin:
                tongDao.login(LogInActivity.this, "Adrien");
                break;
            case R.id.logout:
                tongDao.logout(LogInActivity.this);
                break;
        }
    }
}
