package com.example.sociofix;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sociofix.retrofit.ButtonApi;
import com.example.sociofix.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    TextView indiSignUp;
    EditText mail;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.login_button);

        RetrofitService rs = new RetrofitService();
        ButtonApi buttonPer = rs.getRetrofit().create(ButtonApi.class);
        login.setOnClickListener(view -> {
            String strMail = mail.getText().toString();
            String strPassword = password.getText().toString();
            Person person = new Person(strMail, strPassword);
            Toast.makeText(MainActivity.this, "button clicked" + person.email + person.password, Toast.LENGTH_SHORT).show();
            buttonPer.write(person)
                    .enqueue(new Callback<Person>() {
                        @Override
                        public void onResponse(Call<Person> call, Response<Person> response) {
                            Toast.makeText(MainActivity.this, "Save Success", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Person> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });
    }
}
