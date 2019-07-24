package com.yu.mvpdemo_01;

import com.yu.mvpdemo_01.model.UserBean;

public interface LoginContract {

    interface M {
        void requireLogin(UserBean userBean);
    }


    interface VP {
        void requireLogin(UserBean userBean);

        void requireLoginResult(boolean isSuccess, UserBean userBean);
    }

}
