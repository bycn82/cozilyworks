package com.cozilyworks.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

public class UnblockServer{
	public static void main(String[] args){
		SocketChannel socket=null;
		try{
			Selector selector=Selector.open();
			ServerSocketChannel ssc=ServerSocketChannel.open();
			InetSocketAddress isa=new InetSocketAddress(8710);
			ssc.socket().bind(isa);
			ssc.configureBlocking(false);
			SelectionKey acceptKey=ssc.register(selector,SelectionKey.OP_ACCEPT);
			while(selector.select()>0){
				Set<SelectionKey> readyKeys=selector.selectedKeys();
				Iterator it=readyKeys.iterator();
				while(it.hasNext()){
					SelectionKey key=(SelectionKey)it.next();
					it.remove();
					if(key.isAcceptable()){
						System.out.println("Key is Acceptable");
						socket=(SocketChannel)ssc.accept();
						socket.configureBlocking(false);
						socket.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
					}
					if(key.isReadable()){
						System.out.println("Key is readable");
						socket=(SocketChannel)key.channel();
						ByteBuffer buf=ByteBuffer.allocate(1024);
						socket.read(buf);
						buf.flip();
						Charset charset=Charset.forName("us-ascii");
						CharsetDecoder decoder=charset.newDecoder();
						CharBuffer charBuffer=decoder.decode(buf);
						String result=charBuffer.toString();
						System.out.println("Receive Data:"+result);
					}
					if(key.isWritable()){
						System.out.println("Key is writable");
						String msg="Message from server";
						socket=(SocketChannel)key.channel();
						Charset set=Charset.forName("us-ascii");
						CharsetDecoder dec=set.newDecoder();
						CharBuffer charBuf=dec.decode(ByteBuffer.wrap(msg.getBytes()));
						System.out.println("Message from server:"+charBuf.toString());
						int nBytes=socket.write(ByteBuffer.wrap((charBuf.toString()).getBytes()));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}