package haui.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import haui.ConnectionPool;
import haui.objects.UserObject;

@WebServlet("/adv/user/login")
public class UserLogin
    extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//khai bao kieu noi dung tra ve trinh duyet
  private static final String CONTENT_TYPE = "text/html; charset=UTF-8"; 

  //Process the HTTP Get request
  //doGet: thuong tap trung trinh bay cac cau truc HTML->thg cung cap 1 giao dien
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException {

    //xac dinh kieu noi dung tra ve trinh duyet(trinh duyet la 1 phan cua trinh khach)
    //xac dinh kieu noi dung xuat ve trinh khach(bao ham tra ve trinh duyet)
    response.setContentType(CONTENT_TYPE);

    //tao doi tuong thuc thi nhiem vu xuat noi dung
    PrintWriter out = response.getWriter();

    //tim tham so bao loi xem co khong
    String error= request.getParameter("err");
    String message="";
    if(error!=null){
      if(error.equalsIgnoreCase("param")){
        message="Lỗi không chính xác tham số";
      }else if(error.equalsIgnoreCase("value")){
          message="Lỗi không tồn tại giá trị";
      }else if(error.equalsIgnoreCase("notok")){
        message="Không thành công";
      }else{
        message="Không thành công, tài khoản có thể chưa tồn tại.";
      }
    }


    //cac dong lenh thuc hien xuat
    out.print("<html>");
    out.print("<head>");
    out.print("<title>Đăng nhập</title>");
    out.print("<link href=\"/adv/adcss/login.css\" rel=\"stylesheet\" type=\"text/css\"/>");
    out.print("<script language=\"JavaScript\" src=\"/adv/adjs/login.js\"></script>");
    out.print("</head>");

    out.print("<body>");
    out.print("<div id=\"loginview\">");
    out.print("<form name=\"frmLogin\" action=\"\" method=\"\">");
    out.print("<table cellspacing=0>");

    if(!message.equalsIgnoreCase("")){
      out.print("<tr><td colspan=2 align=\"center\">");
      out.print("<h1 style=\"color:red;\">"+message+"</h1>");
      out.print("</td></tr>");

    }

    out.print("<tr><th colspan=2>Đăng nhập</th></tr>");
    out.print("<tr>");
    out.print("<td class=\"lc\"><img src=\"/adv/imgs/icons/user.png\" class=\"icon\"/>Tên đăng nhập</td>");
    out.print("<td><input type=\"text\" name=\"txtUserName\"/></td>");
    out.print("</tr>");
    out.print("<tr>");
    out.print("<td class=\"lc\"><img src=\"/adv/imgs/icons/password.png\" class=\"icon\"/>Mật khẩu</td>");
    out.print("<td><input type=\"password\" name=\"txtUserPass\"/></td>");
    out.print("</tr>");
    out.print("<tr>");
    out.print("<td class=\"lc\"><input type=\"checkbox\" name=\"chkSave\" id=\"chkSave\"/></td>");
    out.print("<td><label for=\"chkSave\">Bạn có muốn lưu thông tin tài khoản?</label></td>");
    out.print("</tr>");

    out.print("<tr>");
    out.print("<td colspan=2 align=\"center\">");
    out.print("<input type=\"button\" value=\"Đăng nhập\" onClick=\"login(this.form);\" />");
    out.print("<input type=\"button\" value=\"Thoát\" onClick=\"window.close()\"/>");
    out.print("</td>");
    out.print("</tr>");

    out.print("<tr>");
    out.print("<td colspan=2 align=\"right\">");
    out.print("<a href=\"#\">English</a>");
    out.print("</td>");
    out.print("</tr>");
    out.print("</table>");
    out.print("</form>");
    out.print("</div>");

    out.print("</body>");
    out.print("</html>");
    //dong luong xuat
    out.close();
  }

  //Process the HTTP Post request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException {

    //lay du lieu tu doGet truyen toi
    String username= request.getParameter("txtUserName");
    String userpass= request.getParameter("txtUserPass");

    //kiem tra su ton tai cua tham so
    if(username!=null && userpass!=null){
      //cat khoang trong vo nghia
      username=username.trim();
      userpass=userpass.trim();

      //kiem tra su ton tai cua gia tri
      if(!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")){
        //tham chieu ngu canh ung dung cua Servlet, ngu canh lam viec chi co 1
        ServletContext application = getServletConfig().getServletContext();//trong ngu canh chua cac doi tuong Servlet

        //tham chieu bo quan ly ket noi
        ConnectionPool cp= (ConnectionPool)application.getAttribute("c_pool");


        //tao doi tuong thuc thi chuc nang
        UserControl uc= new UserControl(cp);
        if(cp==null){
          application.setAttribute("c_pool",uc.getConnectionPool());//chia se bo quan ly ket noi
        }

        //thuc hien dang nhap
        UserObject user= uc.getUserObject(username,userpass);

        //tra ve ket noi ngay
        uc.releaseConnection();

        //kiem tra dang nhap co thanh cong khong
        if(user!=null){
          //tham chieu phien lam viec, 1 ngu canh lam viec chua nhieu phien lam viec
          HttpSession session= request.getSession(true);//thanh phan dang nhap thi tao moi phien lam viec
          //tao phien lam viec moi: nhuoc diem la 1 tai khoan dang nhap dk nhieu noi

          //dua thong tin dang nhap vao phien lam viec
          session.setAttribute("userLogined",user);

          //tro ve giao dien chinh
          response.sendRedirect("/adv/statistic/view");

        }else{
          response.sendRedirect("/adv/user/login?err=notok");
        }

      }else{
        response.sendRedirect("/adv/user/login?err=value");//loi ve gia tri
      }

    }else{
      //doGet(request,response);//tro ve giao dien ->cach nay ko dung nua
      response.sendRedirect("/adv/user/login?err=param");//loi ve tham so
    }
  } 
}
