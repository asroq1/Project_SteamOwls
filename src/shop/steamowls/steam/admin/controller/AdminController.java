package shop.steamowls.steam.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.steamowls.common.Action;
import shop.steamowls.common.ActionForward;
import shop.steamowls.steam.admin.action.Alogin;
import shop.steamowls.steam.admin.action.AloginProc;
import shop.steamowls.steam.admin.action.Qanswer;
import shop.steamowls.steam.admin.action.QanswerProc;
import shop.steamowls.steam.admin.action.Bcancel;
import shop.steamowls.steam.admin.action.Bmanage;
import shop.steamowls.steam.admin.action.BmanageProc;
import shop.steamowls.steam.admin.action.GotoAdmin;
import shop.steamowls.steam.admin.action.Mmanage;
import shop.steamowls.steam.admin.action.MmanageProc;
import shop.steamowls.steam.admin.action.Padd;
import shop.steamowls.steam.admin.action.PaddProc;
import shop.steamowls.steam.admin.action.Pdelete;
import shop.steamowls.steam.admin.action.PdeleteProc;
import shop.steamowls.steam.admin.action.Plist;
import shop.steamowls.steam.admin.action.PlistProc;
import shop.steamowls.steam.admin.action.Pmanage;
import shop.steamowls.steam.admin.action.PmanageProc;
import shop.steamowls.steam.admin.action.PsellingButton;
import shop.steamowls.steam.admin.action.PstopButton;
import shop.steamowls.steam.admin.action.Qmanage;
import shop.steamowls.steam.admin.action.QmanageProc;
import shop.steamowls.steam.admin.action.Smanage;
import shop.steamowls.steam.admin.action.SmanageProc;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()).replaceAll("/admin", "");

		ActionForward forward = null;

		if (command.equals("")) {
			Action action = new Alogin();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/AloginProc")) {
			Action action = new AloginProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/gotoAdmin")) {
			Action action = new GotoAdmin();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Pmanage")) {
			Action action = new Pmanage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PmanageProc")) {
			Action action = new PmanageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Padd")) {
			Action action = new Padd();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PaddProc")) {
			Action action = new PaddProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Pdelete")) {
			Action action = new Pdelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PdeleteProc")) {
			Action action = new PdeleteProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Plist")) {
			Action action = new Plist();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PlistProc")) {
			Action action = new PlistProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if (command.equals("/PsellingButton")) {
			Action action = new PsellingButton();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}   else if (command.equals("/PstopButton")) {
			Action action = new PstopButton();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Bmanage")) {
			Action action = new Bmanage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BmanageProc")) {
			Action action = new BmanageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Bcancel")) {
			Action action = new Bcancel();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Smanage")) {
			Action action = new Smanage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/SmanageProc")) {
			Action action = new SmanageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QManage")) {
			Action action = new Qmanage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QmanageProc")) {
			Action action = new QmanageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Qanswer")) {
			Action action = new Qanswer();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/QanswerProc")) {
			Action action = new QanswerProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mmanage")) {
			Action action = new Mmanage();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MmanageProc")) {
			Action action = new MmanageProc();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
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
