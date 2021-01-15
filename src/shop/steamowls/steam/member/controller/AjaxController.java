package shop.steamowls.steam.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.steam.ajax.AjaxCheckId;
import shop.steamowls.steam.home.action.HomeAction;
import shop.steamowls.steam.mypage.action.Bhistory;
import shop.steamowls.steam.mypage.action.BhistoryProc;
import shop.steamowls.steam.mypage.action.McheckPw;
import shop.steamowls.steam.mypage.action.McheckPwProc;
import shop.steamowls.steam.mypage.action.Mmodify;
import shop.steamowls.steam.mypage.action.MdetailProc;
import shop.steamowls.steam.mypage.action.Mdetail;
import shop.steamowls.steam.mypage.action.QDetail;
import shop.steamowls.steam.mypage.action.QDetailProc;
import shop.steamowls.steam.mypage.action.QModify;
import shop.steamowls.steam.mypage.action.BCancel;
import shop.steamowls.steam.mypage.action.BCancelProc;
import shop.steamowls.steam.mypage.action.BChange;
import shop.steamowls.steam.mypage.action.BChangeProc;
import shop.steamowls.steam.mypage.action.BDetail;
import shop.steamowls.steam.mypage.action.BDetailProc;
import shop.steamowls.steam.mypage.action.MyPage;
import shop.steamowls.steam.mypage.action.MyPageProc;
import shop.steamowls.steam.mypage.action.QDelete;
import shop.steamowls.steam.mypage.action.QDeleteProc;
import shop.steamowls.steam.mypage.action.Question;
import shop.steamowls.steam.mypage.action.QuestionProc;
import shop.steamowls.steam.mypage.action.Mwithdraw;
import shop.steamowls.steam.mypage.action.MwithdrawProc;
import shop.steamowls.steam.mypage.action.QWriting;
import shop.steamowls.steam.mypage.action.QWritingProc;
import shop.steamowls.steam.mypage.action.QModifyProc;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 예외처리
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		if (command.equals("/checkId.ajax")) {
			Action action = new AjaxCheckId();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (forward != null) {

			if (forward.isRedirect()) {
				// 리다이렉트
				response.sendRedirect(forward.getPath());
			} else {
				// 디스패치
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
