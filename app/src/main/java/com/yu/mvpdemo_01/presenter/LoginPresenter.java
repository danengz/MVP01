package com.yu.mvpdemo_01.presenter;

import android.view.View;

import com.yu.mvpdemo_01.LoginContract;
import com.yu.mvpdemo_01.MainActivity;
import com.yu.mvpdemo_01.engine.LoginEngine;
import com.yu.mvpdemo_01.model.UserBean;

public class LoginPresenter implements LoginContract.VP {

    private MainActivity view;
    private LoginEngine loginEngine;

    public LoginPresenter(MainActivity view) {
        this.view = view;
        loginEngine = new LoginEngine(this);
    }

    @Override
    public void requireLogin(UserBean userBean) {
//        if ("yu".equals(userBean.getUserName()) && "123".equals(userBean.getPwd())){
//            userBean.setNickName("宇");
//            requireLoginResult(true, userBean);
//        }else {
//            requireLoginResult(false, null);
//        }
        // Presenter可以自己处理需求，也可以交给别人处理
        loginEngine.requireLogin(userBean);
    }

    @Override
    public void requireLoginResult(boolean isSuccess, UserBean userBean) {
        view.requireLoginResult(isSuccess, userBean);
    }
}
