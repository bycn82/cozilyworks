package com.cozilyworks.socket;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class UDPServer extends Thread {
  int port;
  DatagramChannel datagramChannel = null;
  Selector selector = null;

  public UDPServer(int port) {
    this.port = port;
  }

  public void run() {
    try {
      // ?????
      selector = Selector.open();
      // ??channel???????
      datagramChannel = DatagramChannel.open();
      InetSocketAddress isa = new InetSocketAddress(port);
      datagramChannel.socket().bind(isa);
      datagramChannel.configureBlocking(false);
      // ??Channel
      datagramChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
      // ????
      ByteBuffer byteBuffer = ByteBuffer.allocate(65536);
      while (true) {
        int eventsCount = selector.select();
        if (eventsCount > 0) {
          Set<SelectionKey> selectedKeys = selector.selectedKeys();
          Iterator iterator = selectedKeys.iterator();
          while (iterator.hasNext()) {
            SelectionKey sk = (SelectionKey) iterator.next();
            iterator.remove();
            if (sk.isReadable()) {
              DatagramChannel datagramChannelTemp = (DatagramChannel) sk
                  .channel();
              SocketAddress sa = datagramChannelTemp
                  .receive(byteBuffer);
              byteBuffer.flip();

              // ?????????ByteBuffer????????????CharBuffer ???
              CharBuffer charBuffer = Charset.defaultCharset()
                  .decode(byteBuffer);
              System.out.println("receive message:"
                  + charBuffer.toString());
              byteBuffer.clear();
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    int currentPort = 8765;
    new UDPServer(currentPort).start();

  }
}