package week3;

import org.junit.*;
import static org.junit.Assert.*;

public class Week3Test {

    // TODO: Viết 5 testcase cho phương thức max()
    @Test
    public void testMax1(){
        int a = Week3.max(4,3);
        assertEquals(4,a);
    }

    @Test
    public void testMax2(){
        int a = Week3.max(4,-3);
        assertEquals(4,a);
    }

    @Test
    public void testMax3(){
        int a = Week3.max(-4,-3);
        assertEquals(-3,a);
    }

    @Test
    public void testMax4(){
        int a = Week3.max(4,0);
        assertEquals(4,a);
    }

    @Test
    public void testMax5(){
        int a = Week3.max(-4,0);
        assertEquals(0,a);
    }


    // TODO: Viết 5 testcase cho phương thức minOfArray()
    @Test
    public void testMin1() {
        int[] arr1 = {0,1,2,3,4,6};
        int a = Week3.MinArr(arr1);
        assertEquals(0,a);
    }
    @Test
    public void testMin2() {
        int[] arr2 = {5,6,7,9,12,-4,-5};
        int b = Week3.MinArr(arr2);
        assertEquals(-5,b);
    }
    @Test
    public void testMin3() {
        int[] arr3 = {-4,5,1,-4,10,6,0};
        int c = Week3.MinArr(arr3);
        assertEquals(-4,c);
    }
    @Test
    public void testMin4() {
        int[] arr4 = {-10,-14,-20,0,13,24};
        int d = Week3.MinArr(arr4);
        assertEquals(-20,d);
    }
    @Test
    public void testMin5() {
        int[] arr5 = {0,1,3,5,7,9,-9,-7,0};
        int e = Week3.MinArr(arr5);
        assertEquals(-9,e);
    }

    // TODO: Viết 5 testcase cho phương thức calculateBMI()
    @Test
    public void testBMI1() {
        String a = Week3.calculateBMI(46.2,1.68);
        assertEquals("Thiếu cân",a);
    }
    @Test
    public void testBMI2() {
        String b = Week3.calculateBMI(51.2,1.6);
        assertEquals("Bình thường",b);
    }
    @Test
    public void testBMI3() {
        String c = Week3.calculateBMI(55.0,1.5);
        assertEquals("Thừa cân",c);
    }
    @Test
    public void testBMI4() {
        String d = Week3.calculateBMI(89.8,1.7);
        assertEquals("Béo phì",d);
    }
    @Test
    public void testBMI5() {
        String e = Week3.calculateBMI(70,1.8);
        assertEquals("Bình thường",e);
    }
}
