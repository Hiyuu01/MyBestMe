package com.osmany.mybestme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class SelectioActivity extends AppCompatActivity {

    private TextView tokenTextView;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectio);
        tokenTextView = findViewById(R.id.token_TextView);
        Intent intent = getIntent();
        token = intent.getStringExtra("TOKEN");
        Log.d("TOKENNNN",token);
        tokenTextView.setText(token);

        if(AccessToken.getCurrentAccessToken()==null){
            goLoginScreen();

        }
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logOut(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
        finish();
    }


}
