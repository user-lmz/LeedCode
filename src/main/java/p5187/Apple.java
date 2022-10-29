package p5187;

import org.junit.Test;

public class Apple {
    @Test
    public void test(){
        CollectApple collectApple = new CollectApple(1000000000);
        System.out.println(collectApple.getPerimeter());
    }
}
