import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMain {


    @Before
    public void beforTest(){
        //redisClient =RedisClient.create("redis://localhost");
        System.out.println("11111");
    }

    @Test
    public void test(){
       // connect = redisClient.connect();


        System.out.println("xxx");
    }

    @After
    public void afterTest(){
        System.out.println("2222");
    }
}
