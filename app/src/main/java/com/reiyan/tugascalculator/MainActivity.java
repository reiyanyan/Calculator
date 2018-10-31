package com.reiyan.tugascalculator;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private EditText mAngka1, mAngka2;
    private Spinner mSpinner;
    private Button mBtnHitung;
    private int angka1, angka2;
    private ArrayAdapter<String> mAdapter;
    private String[] entriesSpinner;
    private TextView mHasil;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAngka1 = findViewById(R.id.edtAngka1);
        mAngka2 = findViewById(R.id.edtAngka2);
        mSpinner = findViewById(R.id.spinner);
        mBtnHitung = findViewById(R.id.btnHitung);
        mHasil = findViewById(R.id.textView);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavView = findViewById(R.id.navView);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        entriesSpinner = new String[]{
          "+ (Tambah)",
          "- (Kurang)",
          "x (Kali)",
          "/ (Bagi)"
        };
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, entriesSpinner);
        mSpinner.setAdapter(mAdapter);
        mBtnHitung.setOnClickListener(this);
        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        int hasil;
        float hasilBagi;
        angka1 = Integer.valueOf(mAngka1.getText().toString());
        angka2 = Integer.valueOf(mAngka2.getText().toString());
        int position = mSpinner.getSelectedItemPosition();
        switch (position){
            case 0:
                hasil = angka1 + angka2;
                mHasil.setText(String.valueOf(hasil));
                break;
            case 1:
                hasil = angka1 - angka2;
                mHasil.setText(String.valueOf(hasil));
                break;
            case 2:
                hasil = angka1 * angka2;
                mHasil.setText(String.valueOf(hasil));
                break;
            case 3:
                hasilBagi = angka1 / angka2;
                mHasil.setText(String.valueOf(hasilBagi));
                break;

        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mHasil.setText(R.string.app_name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
