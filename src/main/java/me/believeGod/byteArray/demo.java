package me.believeGod.byteArray;

import me.believeGod.util.HexUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class demo {
    public static final int CAN_BL_BOOT = 0x55555555;
    public static void main(String[] args) throws IOException {
        CmdFrame excute_fw_cmd = new CmdFrame();
        Arrays.fill(excute_fw_cmd.data, (byte)0);

        excute_fw_cmd.header=0x55aa;
        excute_fw_cmd.canId = (short) (255 << 4 | 0x05);
        excute_fw_cmd.frameLen=CmdFrame.sizeOf;
        excute_fw_cmd.dataLen=4;
        excute_fw_cmd.data[0]=CAN_BL_BOOT>>24;
        excute_fw_cmd.data[1]=(byte)(CAN_BL_BOOT>>16);
        excute_fw_cmd.data[2]=(byte)(CAN_BL_BOOT>>8);
        excute_fw_cmd.data[3]=(byte)(CAN_BL_BOOT);
        excute_fw_cmd.tailer = (short)0xfe00;


        byte[] bytes = excute_fw_cmd.getBytes();
        String s = HexUtils.hexStrings2hexString(HexUtils.bytesToHexStrings(bytes));
        System.out.println("s = " + s);

    }
}
