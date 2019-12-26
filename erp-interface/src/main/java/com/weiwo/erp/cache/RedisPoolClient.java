/*
package com.weiwo.erp.cache;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

*/
/**
 * <p>描述:</p>
 *//*

public class RedisPoolClient {

    private static JedisPool jedisPool;//非切片连接池
//    private static ShardedJedisPool shardedJedisPool;//切片连接池
    static ResourceBundle bundle = null;
	static {
		bundle = ResourceBundle.getBundle("properties/redis");
		if (bundle == null) {
			throw new IllegalArgumentException("[redis.properties] is not found!");
		}
		
		 initialPool(); 
//	     initialShardedPool(); 
	}
    
    
    public RedisPoolClient() 
    { 
//        initialPool(); 
//        initialShardedPool(); 
    } 
 
    */
/**
     * 初始化非切片池
     *//*

    private static void initialPool() 
    { 
    	System.out.println("===============init===pool================");
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        
        config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
		config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
        jedisPool = new JedisPool(config,bundle.getString("redis.ip").split("#")[0],Integer.valueOf(bundle.getString("redis.port").split("#")[0]));
    
    }
    
    */
/**
     * 初始化切片池 
     *//*

//    private static void initialShardedPool() 
//    { 
//        // 池基本配置 
//        JedisPoolConfig config = new JedisPoolConfig(); 
//        
//        config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
//		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
//		config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
//		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
//		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
//        
//        
//        // slave链接 
//        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
//        //shards.add(new JedisShardInfo("127.0.0.1", 6379, "master")); 
//        //shards.add(new JedisShardInfo("127.0.0.1", 6380)); 
//        
//        
//        String[] ips = bundle.getString("redis.ip").split("#");
//        String[] ports = bundle.getString("redis.port").split("#");
//        for(int i=0;i<ips.length;i++){
//        	if(i==0){
//        		shards.add(new JedisShardInfo(ips[i], Integer.valueOf(ports[i]), "master")); 
//        	}else
//        		shards.add(new JedisShardInfo(ips[i], Integer.valueOf(ports[i]))); 
//        }
//
//        // 构造池 
//        shardedJedisPool = new ShardedJedisPool(config, shards); 
//    } 
    
    public void flushDB(){
    	Jedis jedis = null;
		try{
		jedis = jedisPool.getResource(); 
    	System.out.println("清除缓存=="+jedis.flushDB()); 
		}catch(Exception e){
			closeResource(jedis,false);
		}finally{
    		closeResource(jedis,true);
		}
    }
    
    public Long flushCodeAndOrgtype(){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		Set<String> codes = jedis.keys(prefix_code+"*");
    		
    		 Iterator<String> it = codes.iterator();  
    	        while(it.hasNext()){  
    	        	String keyStr = it.next();  
    	            l = jedis.del(keyStr);  
    	        }  
   		 System.err.println("删除编码组和组织类型缓存成功");
    	}catch(Exception e){
    		closeResource(jedis,false);
    	}finally{
    		closeResource(jedis,true);
    	}
    	return l;
    }
    
    
    
    private String prefix_code ="c_";//编码前缀
    
    */
/**
     * 通过jedis 连接master 写入数据
     * @param key
     * @param field
     * @param value
     * @return
     *//*

    public Long hsetCode(String key , String field , String value){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.hset(prefix_code+key, field, value);
//    		System.err.println("保存Redis数据成功，当前组： code.key ="+prefix_code+key+"_"+field+" |  value："+value);
    	}catch(Exception e){
      		 closeResource(jedis,false);
    	}finally{
     		 closeResource(jedis,true);
    	}
    	return l;
    }
    
    
    */
/**
     * 通过dedis 连接master 写入数据
     * @param key
     * @param field
     * @param value
     * @return
     *//*

    public Long hsetSession(byte[] key,byte[] value,int seconds){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.hset(key, "shiro_redis_session".getBytes(), value);
    		jedis.expire(key, seconds);
//   		 System.err.println("保存Redis数据成功，当前session.key ="+key);
    	}catch(Exception e){
//    		 System.err.println("保存Redis数据失败，当前code.key ="+key+" 失败原因："+e.getMessage());
      		 closeResource(jedis,false);
    	}finally{
      		 closeResource(jedis,true);

    	}
    	return l;
    }
    
    */
/**
     * 删除session
     * @param key
     * @param field
     * @param value
     * @return
     *//*

    public Long hDelSession(byte[] key){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.hdel(key, "shiro_redis_session".getBytes());
//   		    System.err.println("删除Redis session 数据成功");
    	}catch(Exception e){
//    		 System.err.println("删除Redis session 数据失败,失败原因："+e.getMessage());
      		 closeResource(jedis,false);
    	}finally{
      		 closeResource(jedis,true);

    	}
    	return l;
    }
    
    */
/**
     * 删除session
     * @param field
     * @param value
     * @return
     *//*

    public Set<byte[]> keys(byte[] pattern){
    	Set<byte[]> l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.keys(pattern);
//   		 System.err.println("获取pattern session 数据成功");
    	}catch(Exception e){
//    		 System.err.println("获取pattern session 数据失败,失败原因："+e.getMessage());
       		 closeResource(jedis,false);

    	}finally{
    		 closeResource(jedis,true);
    	}
    	return l;
    }
    
    
    */
/**
     * 获取session
     * @param key
     * @param field
     * @return
     *//*

    public byte[] hgetSession(byte[] key){
    	byte[] result = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		 result = jedis.hget(key, "shiro_redis_session".getBytes());
//    		 System.err.println("获取Redis session 数据成功，当前session ="+key+" result："+result);
    	 }catch(Exception e){
//    		 System.err.println("获取Redis session数据失败，当前session ="+key+" 失败原因："+e.getMessage());
    		 e.printStackTrace();
       		 closeResource(jedis,false);

    	 }finally{
         	closeResource(jedis,true);

    	 }
    	 return result;
    }
    
    
    */
/**
     * 获取session
     * @param key
     * @param field
     * @return
     *//*

    public byte[] hgetCache(byte[] key){
    	byte[] result = null;
    	Jedis jedis=null;
    	 try{
    		 jedis = jedisPool.getResource(); 
    		 result = jedis.hget(key, "shiro_redis_cache".getBytes());
    	 }catch(Exception e){
    		 System.err.println("获取权限缓存失败");
    		 e.printStackTrace();
       		 closeResource(jedis,false);
    	 }finally{
        	closeResource(jedis,true);
    	 }
    	 return result;
    }
    
    */
/**
     * 通过dedis 连接master 写入数据
     * @param key
     * @param field
     * @param value
     * @return
     *//*

    public Long hsetCache(byte[] key,byte[] value,int seconds){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.hset(key, "shiro_redis_cache".getBytes(), value);
    		jedis.expire(key, seconds);
   		 System.err.println("保存权限缓存成功");
    	}catch(Exception e){
      		 System.err.println("保存权限缓存失败,失败原因："+e.getMessage());
      		closeResource(jedis,false);

    	}finally{
      		closeResource(jedis,true);
    	}
    	return l;
    }
    
    public Long hDelCache(byte[] key){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		l=jedis.hdel(key, "shiro_redis_cache".getBytes());
   		 System.err.println("删除权限缓存成功");
    	}catch(Exception e){
    		 System.err.println("删除限缓存失败,失败原因："+e.getMessage());
     		closeResource(jedis,false);
    	}finally{
     		closeResource(jedis,true);
    	}
    	return l;
    }
    
    public Long flushCache(){
    	Long l = null;
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource(); 
    		Set<byte[]> caches = this.keys("shiro_redis_cache*".getBytes());
    		 Iterator<byte[]> it = caches.iterator();  
    	        while(it.hasNext()){  
    	        	byte[] keyStr = it.next();  
    	            l = jedis.del(keyStr);  
    	        }  
   		 System.err.println("删除权限缓存成功");
    	}catch(Exception e){
    		closeResource(jedis,false);
    	}finally{
    		closeResource(jedis,true);
    	}
    	return l;
    }
    
    
    
    
    
    */
/**
     * 通过共享池获取数据
     * @param key
     * @param field
     * @return
     *//*

    public String hgetCode(String key , String field){
    	 String result = null;
    	 Jedis jedis=null;
    	 try{
    		 jedis = jedisPool.getResource(); 
    		 result = jedis.hget(prefix_code+key, field);
    	 }catch(Exception e){
    		 closeResource(jedis,false);
    	 }finally{
    		 closeResource(jedis,true);
    	 }
    	 return result;
    }

    public void closeResource(Jedis jedis, boolean isOK) {  
        if (null != jedis) {  
            if(!isOK){  
                jedisPool.returnBrokenResource(jedis);  
            }else{  
                jedisPool.returnResource(jedis);  
            }   
        }  
    }
//    public void closeResource(ShardedJedis jedis, boolean isOK) {  
//        if (null != jedis) {  
//            if(!isOK){  
//            	shardedJedisPool.returnBrokenResource(jedis);  
//            }else{  
//            	shardedJedisPool.returnResource(jedis);  
//            }   
//        }  
//    }  
    
    
}*/
