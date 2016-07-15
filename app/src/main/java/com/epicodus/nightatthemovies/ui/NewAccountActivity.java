package com.epicodus.nightatthemovies.ui;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.epicodus.nightatthemovies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewAccountActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    @Bind(R.id.usernameEditText) EditText mUserNameEntry;
    @Bind(R.id.emailEditText) EditText mEmailEntry;
    @Bind(R.id.passwordEditText) EditText mPasswordEntry;
    @Bind(R.id.confirmPasswordEditText) EditText mConfirmPasswordEntry;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {

    }
}
