package com.example.smscallemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sendingSms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_sms);

        Button sendMessageBtn = (Button) findViewById(R.id.sendSMS);
        final EditText messagetEt = (EditText) findViewById(R.id.message);
        final EditText mPhoneNoEt = (EditText) findViewById(R.id.phoneNumber);

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messagetEt.getText().toString();
                String phoneNo = mPhoneNoEt.getText().toString();

                Uri uri = Uri.parse("smsto:"+phoneNo);

                Intent sms = new Intent(Intent.ACTION_SENDTO, uri);

                sms.putExtra("sms_body", "The SMS text");

                startActivity(sms);
                }

        });
    }
}
