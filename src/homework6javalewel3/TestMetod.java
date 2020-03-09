package homework6javalewel3;

import org.junit.Assert;
import org.junit.Test;



public class TestMetod {
    @Test
    public void testmetodd(){
        int[] b = new int[]{1,7};
        int[] a = metod.metodd(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        Assert.assertArrayEquals(a,b);
    }
    @Test(expected = RuntimeException.class)
    public void testmetodd2() throws RuntimeException{
        int[] a = metod.metodd(new int[]{1, 2, 7});
    }
    @Test
    public void testmetodd3(){
        int[] b = new int[]{};
        int[] a = metod.metodd(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4});
        Assert.assertArrayEquals(a,b);
    }


    @Test
    public void  testmetod2(){
        Assert.assertEquals(false,metod.metod2(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }
    @Test
    public void  testmetod21(){
        Assert.assertEquals(true,metod.metod2(new int[]{1, 4, 1, 4, 1, 1}));
    }
    @Test
    public void  testmetod22(){
        Assert.assertEquals(false,metod.metod2(new int[]{1,1,1,1}));
    }
}
