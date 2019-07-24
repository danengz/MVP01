package com.yu.mvpdemo_01.engine;

import com.yu.mvpdemo_01.LoginContract;
import com.yu.mvpdemo_01.model.UserBean;
import com.yu.mvpdemo_01.presenter.LoginPresenter;

public class LoginEngine implements LoginContract.M {

    private LoginPresenter loginPresenter;

    public LoginEngine(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void requireLogin(UserBean userBean) {
        if ("yu".equals(userBean.getUserName()) && "123".equals(userBean.getPwd())){
            userBean.setNickName("宇");
            loginPresenter.requireLoginResult(true, userBean);
        }else {
            loginPresenter.requireLoginResult(false, null);
        }
    }
}
