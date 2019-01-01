package com.ljheee.dubbo.provider;

/**
 * Created by lijianhua04 on 2018/12/30.
 */
public class UserServiceImpl implements UserService {
    public String getUser(String name) {
        return name + "2019";
    }
}
