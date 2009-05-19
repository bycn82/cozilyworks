package com.cozilyworks.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

public class TimeClient{
	public static void main(String[] args) throws Exception{
		String host="127.0.0.1";
		int port=Integer.parseInt("8080");
		ChannelFactory factory=new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
		ClientBootstrap bootstrap=new ClientBootstrap(factory);
		TimeClientHandler handler=new TimeClientHandler();
		bootstrap.getPipeline().addLast("handler",handler);
		bootstrap.setOption("tcpNoDelay",true);
		bootstrap.setOption("keepAlive",true);
		ChannelFuture f=bootstrap.connect(new InetSocketAddress(host,port));
		while(true){
			Thread.sleep(3000);
			f.getChannel().write(ChannelBuffers.copiedBuffer("abc","utf-8"));
		}
	}
}

@ChannelPipelineCoverage("all")
class TimeClientHandler extends SimpleChannelHandler{
	@Override
	public void messageReceived(ChannelHandlerContext ctx,MessageEvent e){
		System.out.println("message received"+e.getMessage());
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,ExceptionEvent e){
		e.getCause().printStackTrace();
		e.getChannel().close();
	}
}