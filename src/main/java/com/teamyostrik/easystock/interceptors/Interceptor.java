package com.teamyostrik.easystock.interceptors;

import org.hibernate.EmptyInterceptor;

public class Interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("");
        return super.onPrepareStatement(sql);
    }

}
