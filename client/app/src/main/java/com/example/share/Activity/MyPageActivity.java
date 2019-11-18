package com.example.share.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.share.R;

import org.w3c.dom.Text;

public class MyPageActivity extends AppCompatActivity {

    private ImageButton sharing_button;
    private ImageButton borrow_button;
    private ImageButton review_button;
    private TextView user_email;
    private TextView user_name;

    private String UserEmail;
    private String UserName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        sharing_button = (ImageButton)findViewById(R.id.share1);
        borrow_button = (ImageButton)findViewById(R.id.share2);
        review_button = (ImageButton)findViewById(R.id.share3);

        user_email = (TextView)findViewById(R.id.mypage_user_email) ;
        user_name = (TextView)findViewById(R.id.mypage_user_name);

        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        UserEmail = pref.getString("user_email",null);
        UserName =pref.getString("user_name",null);

        user_name.setText(UserName);
        user_email.setText(UserEmail);

        sharing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, ShareListActivity.class);
                intent.putExtra("list_kind","sharing");
                startActivity(intent);
            }
        });
        borrow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, BorrowListActivity.class);
                intent.putExtra("list_kind","borrow");
                startActivity(intent);
            }
        });
        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

    }
}