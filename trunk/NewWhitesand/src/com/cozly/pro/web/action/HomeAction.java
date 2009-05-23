package com.cozly.pro.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Cozilyworks.FormName;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.cozly.util.Globals;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class HomeAction extends BaseAction{
	@FormName("homeForm")
	public ActionForward index(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
				return mapping.findForward(OKAY);
	}
	public ActionForward getpic(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		BufferedImage image=new BufferedImage(100,20,ColorSpace.TYPE_RGB); // �õ�һ��bufferedImage
		Graphics g=image.getGraphics(); // �õ�graphics
		g.setColor(Color.WHITE); // setColor
		g.setFont(new Font("System",Font.ITALIC,15)); // setFont
		g.fillRect(0,0,100,20); // fill
		// g.setColor(Color.GRAY); // ߅���ɫ
		// g.draw3DRect(0,0,99,19,true); // Ԓ߅��
		g.setColor(Color.BLACK); // ID���ɫ
		g.drawString(this.getRandom(request)+"=?",10,15);
		// out.clearBuffer();
		response.setHeader("Cache-Control","no-store");
		response.setDateHeader("Expires",0);
		response.setContentType("image/jpeg");
		OutputStream os=response.getOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
		os.flush();
		os.close();
		return null;
	}
	@FormName("redirectForm")
	public ActionForward change(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String backUrl=request.getContextPath()+"/index.coz";
		String actionMsg="Edit your open question";
		return redirectAfterPost(mapping,actionMsg,backUrl);
	}
	@FormName("CozlyForm")
	public ActionForward test(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		super._("int",(Integer)super.$$("int0"));
		System.out.println("/test");
		return mapping.findForward(OKAY);
	}
	public String getRandom(HttpServletRequest request){
		Random ran=new Random();
		int i=ran.nextInt(10);
		int j=ran.nextInt(10);
		int k=ran.nextInt(10);
		request.getSession().setAttribute(Globals.REGIST_USER_SESSON_TOKEN,i+j+k);
		return i+"+"+j+"+"+k;
	}
}
