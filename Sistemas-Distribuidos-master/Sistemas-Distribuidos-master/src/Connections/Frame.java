package Connections;

import java.nio.charset.StandardCharsets;

public class Frame {
    public final int tag;
    public final byte[] data;
    
    public Frame(int tag, byte[] data) 
    { 
        this.tag = tag;
        this.data = data;
    }

    @Override
    public String toString()
    {
        String s = new String(data, StandardCharsets.UTF_8);
        return tag + " ->" + s;
    }
}