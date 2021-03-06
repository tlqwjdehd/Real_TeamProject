package com.sist.member.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.member.*;
import com.sist.member.MemberDAO;
import com.sist.member.MemberVO;

import javafx.scene.control.Alert;



public class MemberModel {
	public void memberJoin(HttpServletRequest request)
	  {
		  request.setAttribute("asdfasdf", "join.jsp");
	  }
	
	  public void memberIdCheck(HttpServletRequest request)
	  {
		  String mem_id=request.getParameter("mem_id");
		  MemberDAO dao=new MemberDAO();
		  int count=dao.memberIdcheck(mem_id);
		  request.setAttribute("count", count);
	  }
	  
	  public void mainContent(HttpServletRequest request) {
		  request.setAttribute("asdfasdf", "main_content.jsp");
	  }
	  
	  public void isLogin(HttpServletRequest request) {
		  request.setAttribute("asdfasdf", "login.jsp");
	  }
	  public void memberLogin(HttpServletRequest request) {
		  String id=request.getParameter("id");
		  String pwd=request.getParameter("pwd");
		  
		  // DB 연동
		  MemberDAO dao=new MemberDAO();
		  MemberVO vo=dao.isLogin(id, pwd);
		  
		  
		  
		  if(vo.getMsg().equals("OK")) {
			  HttpSession session=request.getSession(); //session 생성
			  // session,cookie => request로 생성
			  session.setAttribute("id", vo.getMem_id());
			  session.setAttribute("name", vo.getMem_name());
			  session.setAttribute("admin", vo.getMem_type());
			  session.setAttribute("birth", vo.getMem_birth());
			  
			  
			  
			  
			  
		  }
		  request.setAttribute("res", vo.getMsg());
	  }
	  
	  public void memberJoinOk(MemberVO vo,HttpServletResponse response) {
		  MemberDAO dao=new MemberDAO();
		  dao.memberInsert(vo);
		  try {
			  response.sendRedirect("project.jsp");
		  }catch(Exception ex) {
			  System.out.println(ex.getMessage());
		  }
		  
	  }
	  public void memberUpdate(HttpServletRequest request) {
		   request.setAttribute("asdfasdf", "infoUpdate.jsp");
		 }
	  public void memberUpdateOk(MemberVO vo,HttpServletResponse response) {
		  MemberDAO dao=new MemberDAO();
		  
		dao.MemberUpdate(vo);
		  
		  try {
			  
			  response.sendRedirect("project.jsp");
		  }catch(Exception ex) {
			  System.out.println(ex.getMessage());
		  }
	  }
}
