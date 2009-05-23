package com.cozly.pro.web.action.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Cozilyworks.FormName;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class HomeAction extends BaseAdminAction{
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		return mapping.findForward(OKAY);
	}
	@SuppressWarnings("deprecation")
	@FormName("adminUploadForm")
	public ActionForward upload(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		@SuppressWarnings("unused")
		String userName=super.$("userName");
		FormFile file=(FormFile)super.$$("file");
		try{
			InputStream stream=file.getInputStream();// ���ļ�����
			String filePath=request.getRealPath("/");// ȡ��ǰϵͳ·��
			OutputStream bos=new FileOutputStream(filePath+"/"+file.getFileName());// ��bһ���ϴ��ļ��������
			System.out.println(filePath+"/"+file.getFileName());
			int bytesRead=0;
			byte[] buffer=new byte[8192];
			while((bytesRead=stream.read(buffer,0,8192))!=-1){
				bos.write(buffer,0,bytesRead);// ���ļ�д�������
			}
			bos.close();
			stream.close();
		}catch(Exception e){
			System.err.print(e);
		}
		String backUrl=request.getContextPath()+"/admin/list."+EXT;
		String actionMsg="upload";
		return this.redirectAfterPost(mapping,actionMsg,backUrl);
	}
}
