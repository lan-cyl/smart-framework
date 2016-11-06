package org.smart4j.framework.proxy;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.helper.DatabaseHelper;

import java.lang.reflect.Method;

/**
 * 事务管理的代理类
 *
 * Created by lan_cyl on 2016/11/4.
 */
@Aspect(Service.class)
public class TransactionProxy extends AspectProxy {
    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Override
    public boolean intercept(Class<?> targetClass, Method targetMethod, Object[] params) {
        if (FLAG_HOLDER.get() == false && targetMethod.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            return true;
        }
        return false;
    }

    @Override
    public void before(Class<?> targetClass, Method targetMethod, Object[] params) {
        DatabaseHelper.beginTransaction();
    }

    @Override
    public void after(Class<?> targetClass, Method targetMethod, Object[] params, Object result) {
        DatabaseHelper.commitTransaction();
    }

    @Override
    public void end() {
        FLAG_HOLDER.remove();
    }
}
