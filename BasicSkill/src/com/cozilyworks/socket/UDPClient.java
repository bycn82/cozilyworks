package com.cozilyworks.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class UDPClient{
	static DatagramChannel datagramChannel=null;
	static Selector selector=null;
	public static void main(String[] args){
		try{
			// TCP??SocketChannel,UDP??DatagramChannel
			datagramChannel=DatagramChannel.open();
			InetSocketAddress isa=new InetSocketAddress(InetAddress.getLocalHost(),8765);
			datagramChannel.connect(isa);
			// ??????
			datagramChannel.configureBlocking(false);
			//??Channel???????
			selector=Selector.open();
			datagramChannel.register(selector,SelectionKey.OP_READ);
			datagramChannel.write(Charset.defaultCharset().encode("Tell me your time"));
			//????
			ByteBuffer byteBuffer=ByteBuffer.allocate(100);
			//??
			while(true){
				int eventsCount=selector.select();
				if(eventsCount>0){
					Set<SelectionKey> selectedKeys=selector.selectedKeys();
					Iterator iterator=selectedKeys.iterator();
					while(iterator.hasNext()){
						SelectionKey sk=(SelectionKey)iterator.next();
						iterator.remove();
						if(sk.isAcceptable()){
							//TODO SOMETHING
						}
						if(sk.isReadable()){
							DatagramChannel datagramChannel=(DatagramChannel)sk.channel();
							datagramChannel.read(byteBuffer);
							byteBuffer.flip();
							// TODO ??????RUDP?????RUDP????????
							System.out.println(Charset.defaultCharset().decode(byteBuffer).toString());
							byteBuffer.clear();
							datagramChannel.write(Charset.defaultCharset().encode("Tell me your time"));
						}
					}
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}