package com.mobiledev.rpm.androidtemplate.main.features.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mobiledev.rpm.androidtemplate.R;
import com.mobiledev.rpm.androidtemplate.main.AndroidTemplateApp;
import com.mobiledev.rpm.androidtemplate.main.data.model.Users;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaggerMainComponent.builder()
                .netComponent(AndroidTemplateApp.getInstance().getNetComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainPresenter.loadUserList();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoadUserError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadUserComplete() {
        Toast.makeText(this, "complete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadUser(List<Users> usersList) {
        Toast.makeText(this, usersList.get(0).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        mainPresenter.cancelNetworkRequests();
        super.onDestroy();
    }
}
