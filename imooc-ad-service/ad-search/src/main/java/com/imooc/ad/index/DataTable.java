package com.imooc.ad.index;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 23:12
 * 数据表
 */
@Component
public class DataTable implements ApplicationContextAware, PriorityOrdered {

    private static ApplicationContext applicationContext;

    //存放class(类型) - Object(对应的类）
    public static final Map<Class, Object> dataTableMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataTable.applicationContext = applicationContext; //上下文
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE; //最高优先级（因为需要保存索引等信息，所以需要提早加载）
    }

    //得到类对应的bean（实现类）
    public static <T> T of(Class<T> clazz) {
        T instance = (T) dataTableMap.get(clazz);
        if (null != instance) {
            return instance;
        }
        dataTableMap.put(clazz, bean(clazz));

        return (T) dataTableMap.get(clazz);
    }

    //通过名字得到bean
    private static <T> T bean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    //通过class类型得到bean
    private static <T> T bean(Class clazz) {
        return (T) applicationContext.getBean(clazz);
    }
}
