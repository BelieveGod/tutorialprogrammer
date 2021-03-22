package me.believeGod.byteArray;

import me.believeGod.util.HexUtils;

import java.io.Serializable;

public class CmdFrame implements Serializable {
    public short header;
    public short canId;
    public byte frameLen;
    public byte dataLen;
    public byte[] data=new byte[32];
    public short tailer;

    public static final byte sizeOf = (byte)(2+2+1+1+32+2);

    public byte[] getBytes(){
        byte[] bytes = new byte[sizeOf];
        int length=0;
        byte[] bytes1 = HexUtils.short2Bytes(header);
        System.arraycopy(bytes1,0,bytes,length, bytes1.length);
        length+=bytes1.length;

        byte[] bytes2 = HexUtils.short2Bytes(canId);
        System.arraycopy(bytes2,0,bytes,length, bytes2.length);
        length+=bytes2.length;

        bytes[length]=frameLen;
        length++;

        bytes[length]=dataLen;
        length++;

        System.arraycopy(data,0,bytes,length,data.length);
        length+=data.length;

        byte[] bytes6 = HexUtils.short2Bytes(tailer);
        System.arraycopy(bytes6,0,bytes,length, bytes6.length);

        return bytes;
    }
}
