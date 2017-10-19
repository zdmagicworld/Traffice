package com.lehjg.lenovo.traffice.Activity.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lehjg.lenovo.traffice.Activity.util.UrlBean;
import com.lehjg.lenovo.traffice.R;

/**
 * Created by lenovo on 2017/10/12.
 */

public class LoginActivity extends Activity{
    private TextView textView_title;
    private LinearLayout linearLayout_net_setting;
    private TextView textView3;
    private EditText editTextUsername;
    private EditText editTextUserpwd;
    private CheckBox checkBox_r;
    private Button buttonOk;
    UrlBean urlBean;
    private String urlHttp;
    private String urlPort="80";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
    }

    private void initview() {
    textView_title = (TextView) findViewById(R.id.textView_title);
    linearLayout_net_setting = (LinearLayout) findViewById(R.id.net_setting);
    textView3 = (TextView) findViewById(R.id.textView3);
    editTextUsername = (EditText) findViewById(R.id.editText_username);
    editTextUserpwd = (EditText) findViewById(R.id.editText_userpwd);
    checkBox_r = (CheckBox) findViewById(R.id.checkBox);
    buttonOk = (Button) findViewById(R.id.button_ok);
    buttonOk.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    });
    linearLayout_net_setting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Dialog urlsettingdialog = new Dialog(LoginActivity.this);
            urlsettingdialog.setTitle("setting");
//            urlsettingdialog.getWindow().setContentView(R.layout.login_setting);
            final EditText editSettingUrl = (EditText) urlsettingdialog.getWindow().findViewById(R.id.edit_setting_url);
            final EditText editSettingPort = (EditText) urlsettingdialog.getWindow().findViewById(R.id.edit_setting_port);
            editSettingUrl.setText(urlBean.getUrl());
            editSettingPort.setText(urlBean.getPort());
//            Button buttonSave = (Button) findViewById(R.id.button_save);
//            Button buttonCancle = (Button) findViewById(R.id.button_cancle);

        }
    });
    }
}
