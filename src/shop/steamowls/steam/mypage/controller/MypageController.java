package shop.steamowls.steam.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
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

@WebServlet("/mypage/*")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()).replaceAll("/mypage", "");

		ActionForward forward = null;

		if (command.equals("/")) {
			Action action = new HomeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/gotoMypage")) {
			Action action = new MyPage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/gotoMypageProc")) {
			Action action = new MyPageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Bhistory")) {
			Action action = new Bhistory();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BhistoryProc")) {
			Action action = new BhistoryProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BCancel")) {
			Action action = new BCancel();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BCancelProc")) {
			Action action = new BCancelProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BChange")) {
			Action action = new BChange();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BChangeProc")) {
			Action action = new BChangeProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BDetail")) {
			Action action = new BDetail();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BDetailProc")) {
			Action action = new BDetailProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/McheckPw")) {
			Action action = new McheckPw();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/McheckPwProc")) {
			Action action = new McheckPwProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mdetail")) {
			Action action = new Mdetail();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mmodify")) {
			Action action = new Mmodify();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mwithdraw")) {
			Action action = new Mwithdraw();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MwithdrawProc")) {
			Action action = new MwithdrawProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/question")) {
			Action action = new Question();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/question")) {
			Action action = new QuestionProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QWriting")) {
			Action action = new QWriting();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QWritingProc")) {
			Action action = new QWritingProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QDetail")) {
			Action action = new QDetail();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QDetailProc")) {
			Action action = new QDetailProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QModify")) {
			Action action = new QModify();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QModifyProc")) {
			Action action = new QModifyProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QDelete")) {
			Action action = new QDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QDeleteProc")) {
			Action action = new QDeleteProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				// �����̷�Ʈ
				response.sendRedirect(forward.getPath());
			} else {
				// ����ġ
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
