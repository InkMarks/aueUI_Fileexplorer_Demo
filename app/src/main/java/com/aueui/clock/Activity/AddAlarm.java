package com.aueui.clock.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aueui.clock.R;

public class AddAlarm extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_exit, btn_confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);
        initView();
    }

    private void initView() {
        btn_exit = findViewById(R.id.btn_exit);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_exit.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exit:
                finish();
                break;
            case R.id.btn_confirm:
                finish();
                break;
        }
    }
}
