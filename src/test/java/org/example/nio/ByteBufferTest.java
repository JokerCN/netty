package org.example.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    @Test
    public void byteBuffer(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        describeBuffer(buffer);
        printBuffer(buffer);

        buffer.putChar('a');
        describeBuffer(buffer);
        printBuffer(buffer);

        buffer.putChar('啊');
        describeBuffer(buffer);
        printBuffer(buffer);

        buffer.flip();
        describeBuffer(buffer);
        printBuffer(buffer);

        buffer.position(1);
        buffer.compact();
        describeBuffer(buffer);
        printBuffer(buffer);
    }

    private void describeBuffer(ByteBuffer buffer){
        System.out.println("=======describe buffer==========");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

    }

    private void printBuffer(ByteBuffer buffer){
        System.out.println("========print buffer===========");
        int position = buffer.position();
        buffer.position(0);
        for(int i = 0; i < buffer.limit(); i++){
            byte b = buffer.get();
            System.out.print(Integer.toHexString(b));
        }

        buffer.position(position);
        System.out.println();
    }
}
