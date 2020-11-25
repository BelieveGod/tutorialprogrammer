package me.believeGod.convert;

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

}
