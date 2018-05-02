package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.action.AnswerAction;
import com.project.action.AnswerInertSaveAction;
import com.project.action.BoardBodyAction;
import com.project.action.BoardInsertViewAction;
import com.project.action.BoardListAction;
import com.project.action.CommentListAction;
import com.project.action.ConstractAction;
import com.project.action.DownLoadAction;
import com.project.action.IdolapckAction;
import com.project.action.IndexAction;
import com.project.action.LoginAction;
import com.project.action.LoginCkAction;
import com.project.action.LoginOutAction;
import com.project.action.MemAjaxAction;
import com.project.action.MembeinsertAction;
import com.project.action.MemberDeleteAction;
import com.project.action.MemberUpdateAction;
import com.project.action.ModifyAction;
import com.project.action.ModifyDeleteAction;
import com.project.action.ModifyUpdateAction;
import com.project.action.PasswordChangeAction;
import com.project.action.PasswordCheckAction;
import com.project.action.PasswordUpdateAction;
import com.project.action.PersonalAction;
import com.project.action.ReplyAddAction;
import com.project.action.ReplyDelAction;
import com.project.action.SearchAction;
import com.project.action.SweetAddAction;
import com.project.action.SweetCountAction;
import com.project.action.boardinertsaveAction;
import com.project.action.memberAction;

/**
 * Servlet implementation class ProjectFrontController
 */
@WebServlet("/ProjectFrontController")
public class ProjectFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// 인터페이스
		Action action = null;
		// 페이지 이동방법 결정(Forward , sendRedirect)
		ActionForward forward = null;
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length()); //uri에서 ctx를 빼면 내가 원하는 소스만 출력 가능
		
		System.out.println("uri ===> " + uri);
		System.out.println("ctx ===> " + ctx);
		System.out.println("command ===> " + command);
		
		// ===== 액션 매핑 ===== //
		// 실제로 동작하는 곳 , 하나의 Servlet에서 URL을 읽어 해당 기능을 구현
		
		if(command.equals("/index.bizpoll")) {
			
			action = new IndexAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/login.bizpoll")) {
			
			action = new LoginAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/member.bizpoll")) {
			
			action = new memberAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/constract.bizpoll")) {
			
			action = new ConstractAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/id_olap_ck.bizpoll")) {
			
			action = new IdolapckAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/memberinsert.bizpoll")) {
			
			action = new MembeinsertAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/memajax.bizpoll")) {
			
			action = new MemAjaxAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/loginck.bizpoll")) {
			
			action = new LoginCkAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/logout.bizpoll")) {
			
			action = new LoginOutAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/boardlist.bizpoll")) {
			
			action = new BoardListAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/boardInsertView.bizpoll")) {
			
			action = new BoardInsertViewAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/boardinertsave.bizpoll")) {
			
			action = new boardinertsaveAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/boardbody.bizpoll")) {
			
			action = new BoardBodyAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/modify.bizpoll")) {
			
			action = new ModifyAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/modifyupdate.bizpoll")) {
			
			action = new ModifyUpdateAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
			
		}else if(command.equals("/modifydelete.bizpoll")) {
			
			action = new ModifyDeleteAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/sweetadd.bizpoll")) {
			
			action = new SweetAddAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/search.bizpoll")) {
			
			action = new SearchAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/replyadd.bizpoll")) {
			
			action = new ReplyAddAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/replydel.bizpoll")) {
			
			action = new ReplyDelAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/commentlist.bizpoll")) {
			
			action = new CommentListAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/passwordcheck.bizpoll")) {
			
			action = new PasswordCheckAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/personal.bizpoll")) {
			
			action = new PersonalAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/passwordchange.bizpoll")) {
			
			action = new PasswordChangeAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/passwordupdate.bizpoll")) {
			
			action = new PasswordUpdateAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/memupdate.bizpoll")) {
			
			action = new MemberUpdateAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/memdelete.bizpoll")) {
			
			action = new MemberDeleteAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/sweetcount.bizpoll")) {
			
			action = new SweetCountAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/download.bizpoll")) {
			
			action = new DownLoadAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/answer.bizpoll")) {
			
			action = new AnswerAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}else if(command.equals("/answerinertsave.bizpoll")) {
			
			action = new AnswerInertSaveAction();//action은 인터페이스: 다형성을 이용해서 해당 액션기능을 action에 넣는다
			forward = action.excute(request, response); // 공통 분기작업에 보낼 forward
			
		}
		
	
	}

}
