package com.example.like.config;

public class UserService {

    public String saveUser() {
        redisUtils.redis.opsForValue().set("name","zhangsan1+wangkun");
        String str = new String("保存成功");
        return str;
    }

    public String getUser() {
        Object object = redisUtils.redis.opsForValue().get("name");
        if(object != null){
            return object.toString();
        }else{
            return "数据不存在+我喜欢！";
        }
    }



}
