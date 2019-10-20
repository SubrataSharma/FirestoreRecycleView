package com.example.mudrahomeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DataActivity extends AppCompatActivity {
    EditText name ,age;
    Button button;


    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        name=findViewById(R.id.edit_text1);
        age=findViewById(R.id.edit_text2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg1 = name.getText().toString();
                String msg2 = age.getText().toString();
                if (!msg1.equals("") && !msg2.equals("") ) {
                    sendMessage(msg1,msg2);
                    startActivity(new Intent(DataActivity.this,MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(DataActivity.this, "You can't send empty message", Toast.LENGTH_SHORT).show();
                }


            }

        });

    }
    private void sendMessage(String name,String age){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Name", name);
        hashMap.put("Age", age);


        reference.child("User").push().setValue(hashMap);
    }
}
