package com.example.assignment9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText userName;
    private EditText password;
    private TextView result;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userName = (EditText) findViewById(R.id.userNameTextBox);
        this.password = (EditText) findViewById(R.id.passwordTextBox);
        this.result = (TextView) findViewById(R.id.resultText);
    }

    public void handleClick(View view){
        if (view.getId()==R.id.loginButton){
            String userNameString = this.userName.getText().toString();
            String passwordString = this.password.getText().toString();
            boolean loginSuccess = false;

            if(userNameString.equals("owenp")&&passwordString.equals("123")){
                loginSuccess = true;
            }
            if(loginSuccess){
                this.result.setText("Success!");
                Intent intent = new Intent(this, informationpage.class);
                startActivity(intent);


            }
            else{
                this.result.setText("haha no");
            }
        }
    }


}