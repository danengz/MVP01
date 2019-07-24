package com.yu.mvpdemo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yu.mvpdemo_01.model.UserBean;
import com.yu.mvpdemo_01.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.VP {

    private EditText et_username;
    private EditText et_pwd;
    private Button button;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
        button = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBean userBean = new UserBean();
                userBean.setUserName(et_username.getText().toString());
                userBean.setPwd(et_pwd.getText().toString());
                requireLogin(userBean);
            }
        });

    }


    @Override
    public void requireLogin(UserBean userBean) {
        if (userBean != null) {
            loginPresenter.requireLogin(userBean);
        }
    }

    @Override
    public void requireLoginResult(boolean isSuccess, UserBean userBean) {
        Toast.makeText(this, isSuccess ? "登成功：" + userBean.getNickName() : "录登失败", Toast.LENGTH_LONG).show();
    }
}
