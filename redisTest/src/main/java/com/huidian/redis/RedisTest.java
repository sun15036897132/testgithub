package com.huidian.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;

public class RedisTest {
    /**
     * 直接建立连接
     */
    @Test
    public void JedisCilent(){
        Jedis jedis = new Jedis("localhost",6379);
        //string 类型
        jedis.set("s1","2");
        System.out.println(jedis.get("s1"));
        jedis.set("name","sun");
        System.out.println(jedis.get("name"));
        jedis.append("name"," is good man");
        System.out.println(jedis.get("name"));
        jedis.del("s1");
        System.out.println(jedis.get("s1"));
        jedis.setnx("s1","11");
        System.out.println(jedis.get("s1"));
        System.out.println(jedis.substr("name",1,5));
        jedis.mset(new String[]{"zhangsan","123","lisi","456","wangwu","789"});
        System.out.println(jedis.mget("zhangsan","lisi","wangwu"));
        jedis.incr("zhangsan");
        jedis.incrBy("lisi",3);
        jedis.decrBy("wangwu",4);
        System.out.println(jedis.mget("zhangsan","lisi","wangwu"));
        System.out.println("====================");
        //Hash类型
        jedis.hset("user","name","zhangsan");
        System.out.println(jedis.hget("user","name"));
        HashMap<String, String> map = new HashMap<>();
        map.put("name","lisi");
        map.put("age","78");
        map.put("sax","男");
        jedis.hmset("teach",map);
        System.out.println(jedis.hmget("teach","age","name"));
        System.out.println(jedis.hgetAll("teach"));
        if(jedis.hexists("teach","age")){
            System.out.println("存在");
            jedis.hincrBy("teach","age",4);
            System.out.println(jedis.hget("teach","age"));
        }
        jedis.hset("student","age","13");
        jedis.hset("student","qq","2246920330");
        jedis.hset("student","address","beijing");
        System.out.println("student中键的个数为："+jedis.hlen("student"));
        System.out.println("student中所有的键为："+jedis.hkeys("student"));
        System.out.println("student中所有的值为："+jedis.hvals("student"));
        System.out.println("student中所有的键值对为："+jedis.hgetAll("student"));
        jedis.hdel("student",new String[]{"age","qq","address"});
        System.out.println(jedis.hgetAll("student"));
        jedis.close();
    }

    /**
     * 通过连接池 JedisPool 建立连接
     */

    @Test
    public void jedispool(){
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.select(10);
       /* jedis.lpush("books","java","python","C","C++","php");
        jedis.rpush("books","1","2","3","4","5");
        System.out.println(jedis.lrange("books",0,-1));
        System.out.println(jedis.lpop("books"));
        System.out.println(jedis.lrange("books",0,-1));
        System.out.println(jedis.rpop("books"));
        System.out.println(jedis.lrange("books",0,-1));
        */
        System.out.println(jedis.llen("books"));
        jedis.rpush("language","1","2","3","4","5","6","7","8");
        jedis.rpoplpush("books","language");
        System.out.println(jedis.lrange("books",0,-1));
        System.out.println(jedis.lrange("language",0,-1));

        jedis.close();
        jedisPool.close();
    }


}
