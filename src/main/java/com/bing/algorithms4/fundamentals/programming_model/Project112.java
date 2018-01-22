package com.bing.algorithms4.fundamentals.programming_model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaobing on 2018/1/22
 */
public class Project112 {

    public static void main(String[] args) {
        Map<String,Object> objs = new HashMap<String,Object>(){{
            put("o0",((1+2.236)/2));
            put("o1",(1+2+3+4.0));
            put("o2",(4.1>=4));
            put("o3",(1+2+"3"));
        }
        };
        for(int i = 0;i<objs.size();i++){
            Object obj = objs.get("o"+i);
            System.out.printf("the type is:%s,the value is:%s\n",obj.getClass().getName(),obj.toString());
        }

    }
}
