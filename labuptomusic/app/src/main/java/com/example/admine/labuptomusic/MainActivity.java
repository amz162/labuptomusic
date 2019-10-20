package com.example.admine.labuptomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name, password, c_password;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGui();
        initListeners();
    }

    private void initGui() {
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.cnfrmpassword);
        Submit = (Button) findViewById(R.id.submit);
    }

    private void initListeners() {

        Submit.setOnClickListener(this);
    }

    private void validateFields() {
        if (name.getText().toString().equals("")) {
            name.requestFocus();
            name.setError(getResources().getString(R.string.empty_error));
            return;
        }

        if (password.getText().toString().equals("")) {
            password.requestFocus();
            password.setError(getResources().getString(R.string.empty_error));
            return;
        }

        if (c_password.getText().toString().equals("")) {
            c_password.requestFocus();
            c_password.setError(getResources().getString(R.string.empty_error));
            return;
        }

        if (!password.getText().toString().equals(c_password.getText().toString())) {
            c_password.requestFocus();
            c_password.setError(getResources().getString(R.string.match));
            return;
        }

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                validateFields();
                break;
        }
    }
}