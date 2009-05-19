package com.cozilyworks.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class TimeServer{
	public static void main(String[] args) throws Exception{
		ChannelFactory factory=new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
		ServerBootstrap bootstrap=new ServerBootstrap(factory);
		TimeServerHandler handler=new TimeServerHandler();
		ChannelPipeline pipeline=bootstrap.getPipeline();
		pipeline.addLast("handler",handler);
		bootstrap.setOption("child.tcpNoDelay",true);
		bootstrap.setOption("child.keepAlive",true);
		bootstrap.bind(new InetSocketAddress(8080));
	}
}

@ChannelPipelineCoverage("all")
class TimeServerHandler extends SimpleChannelHandler{
	@Override
	public void channelConnected(ChannelHandlerContext ctx,ChannelStateEvent e){
		System.out.println("channel connected");
		Channel ch=e.getChannel();
		ChannelBuffer time=ChannelBuffers.buffer(100);
		time.writeLong(System.currentTimeMillis()/1000);
		ChannelFuture f=ch.write(time);
	}
	@Override
	public void messageReceived(ChannelHandlerContext ctx,MessageEvent e){
		System.out.println("message received");
		Channel ch=e.getChannel();
		ch.write(e.getMessage());
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,ExceptionEvent e){
		e.getCause().printStackTrace();
		e.getChannel().close();
	}
}