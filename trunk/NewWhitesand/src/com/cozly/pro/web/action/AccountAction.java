package com.cozly.pro.web.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Cozilyworks.FormName;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import com.cozly.pro.entity.Account;
import com.cozly.util.Globals;

public class AccountAction extends BaseAction{
	@FormName("AccountRegistForm")
	public ActionForward regist(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String userName=super.$("userName");
		String email=super.$("email");
		String password1=super.$("password1");
		String password2=super.$("password2");
		int token1=(Integer)super.$$("token");
		int token2=(Integer)request.getSession().getAttribute(Globals.REGIST_USER_SESSON_TOKEN);
		if(token1==token2){
			Account user=new Account();
			if(password1.equalsIgnoreCase(password2)){
				Account account=this.userservice.findByUserNameAndEmail(userName,email);
				if(account==null){
					user.setUsername(userName);
					user.setPassword(password1);
					user.setEmail(email);
					user.setCreatedat(new Date());
					user.setRegistedip(request.getRemoteAddr());
					user.setCozid(this.cozidgenerator.generateCozid());
					this.userservice.create(user);
					super._("result","ok");
				}
			}
		}else{
			System.out.println("did not get the same token");
		}
		return mapping.findForward(OKAY);
	}
	@FormName("ABCDForm")
	public ActionForward logon(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
			
			String saveDirectory="c:\\";
			FormFile file=(FormFile)$o("file1");
			InputStream stream1=file.getInputStream();
			ServletInputStream stream=request.getInputStream();
			// 建立输出流
			OutputStream bos=new FileOutputStream(saveDirectory+"/"+file.getFileName());
			// 将文件写入网站根目录下
			int bytesRead=0;
			byte[] buffer=new byte[8192*8192];
			while((bytesRead=stream.read(buffer,0,8192*8192))!=-1){
				bos.write(buffer,0,bytesRead);
			}
			bos.close();
			stream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.userservice.delete(null);
		String wii="";
		
		wii=super.$("userName");
		System.out.println(wii);
		String backUrl=request.getContextPath()+"/index.coz";
		backUrl=response.encodeURL(backUrl);
		String actionMsg="Edit your open question";
		return redirectAfterPost(mapping,actionMsg,backUrl);
	}
}
