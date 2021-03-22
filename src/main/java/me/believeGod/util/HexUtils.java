package me.believeGod.util;

/**
 * @ClassName HexUtils
 * @Description 16进制数据处理的工具类
 * @Author believeGod
 * @Date 2020/11/18 7:31
 * @Version 1.0
 */
public class HexUtils {

    private HexUtils(){
        throw new IllegalStateException("工具类没有实例对象");

    }


    /**
     * 字节数组转变成可视化的16进制字符串数组
     * @param bArray
     * @return
     */
    public static String[] bytesToHexStrings(byte[] bArray,int offset,int length){

        String[] strings = new String[length];
        String sTemp;
        for (int i = 0; i <length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i+offset]);
            if (sTemp.length() < 2) {
                strings[i] = "0" + sTemp;
            } else {
                strings[i] = sTemp;
            }
        }
        return strings;
    }

    public static String[] bytesToHexStrings(byte[] bArray){

        return bytesToHexStrings(bArray, 0, bArray.length);
    }


    /**
     * 可视化16进制字符串数组转成可视化可视化16进制字符串
     * @param hexStrings
     * @return
     */
    public static String hexStrings2hexString(String[] hexStrings){
        StringBuilder builder = new StringBuilder();
        for (String hexString : hexStrings) {
            builder.append(hexString+" ");
        }
        return builder.toString();

    }

    /**
     *
     */
    public static byte[] hexStrings2bytes(String[] hexStrings){
        byte[] bytes=new byte[hexStrings.length];

        for(int i=0;i<bytes.length;i++){
            byte high=(byte)(Character.digit(hexStrings[i].charAt(0),16) & 0xff);
            byte low=(byte)(Character.digit(hexStrings[i].charAt(1),16) & 0xff);
            bytes[i]=(byte)(high<<4 | low);
        }
        return bytes;
    }

    /**
     * 小端模式
     * @param value
     * @return
     */
    public static byte[] int2Bytes(int value){
        final int Len=4;
        byte[] bytes = new byte[Len];
        for(int i=0;i<Len;i++){
            bytes[i]=(byte)(value >> 8 * i);
        }
        return bytes;
    }

    /**
     * 小端模式
     * @param value
     * @return
     */
    public static byte[] short2Bytes(short value){
        final int Len=2;
        byte[] bytes = new byte[Len];
        for(int i=0;i<Len;i++){
            bytes[i]=(byte)(value >> 8 * i);
        }
        return bytes;
    }

}
