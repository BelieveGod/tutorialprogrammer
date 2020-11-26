package me.believeGod.convert;

import me.believeGod.util.HexUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * 测试字节数组转字符串
 * 理解在 java 内存中 字符都是unicode 编码，理解内码（internal encoding）和外码（external encoding）
 */
public class Demo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] data = new byte[]{(byte)0xc4, (byte)0xe3, (byte)0xba, (byte)0xc3};
        String str="你好";

        byte[] bytes = str.getBytes("gbk");
        for (byte aByte : bytes) {
            int i = (int) aByte & 0xFF;
            System.out.print(Integer.toHexString(i));
        }
        System.out.println();
        for (byte aByte : bytes) {
            int i1 = Byte.toUnsignedInt(aByte);
            System.out.print(Integer.toHexString((i1)));
        }
        System.out.println();
        String s = new String(data,"GBK");
        System.out.println("s = " + s);


    }


    @Test
    public void test(){
        int digit = Character.digit('B', 16);
        System.out.println("digit = " + digit);
    }


    @Test
    public void test2(){
        byte[] data = new byte[]{(byte)0xc4, (byte)0xe3, (byte)0xba, (byte)0xc3};
        String[] hexStrings = HexUtils.bytesToHexStrings(data,0,2);
        String s = HexUtils.hexStrings2hexString(hexStrings);
        System.out.println("s = " + s);

        byte[] bytes = HexUtils.hexStrings2bytes(hexStrings);

        Assert.assertArrayEquals("字节相等",data,bytes);

        for (int i = 0; i < bytes.length; i++) {
            System.out.println("bytes:"+bytes[i]+"   " +" data:" + data[i]);
        }
    }
}
