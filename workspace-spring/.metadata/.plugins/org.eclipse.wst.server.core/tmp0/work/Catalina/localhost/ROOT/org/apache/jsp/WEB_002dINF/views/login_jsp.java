/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2020-10-22 08:37:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>로그인</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/index_ver2.css\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        @import url('https://fonts.googleapis.com/css2?family=Lobster&display=swap');\r\n");
      out.write("        body {\r\n");
      out.write("            background : #f8f8f8;\r\n");
      out.write("        }\r\n");
      out.write("        #main-container {\r\n");
      out.write("            background : #ffffff;\r\n");
      out.write("            border: 1px solid #dddddd;\r\n");
      out.write("            width: 500px;\r\n");
      out.write("            height: 580px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            margin-top: 150px;\r\n");
      out.write("            padding-top: 50px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .int-area {\r\n");
      out.write("            top: 80px;\r\n");
      out.write("            left: 50px;\r\n");
      out.write("            width: 375px; \r\n");
      out.write("            position: relative;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            color: goldenrod;\r\n");
      out.write("            \r\n");
      out.write("            /* text-shadow: 2px 2px rgb(134, 11, 11);; */\r\n");
      out.write("        } /*텍스트창에 id/pw 글귀 넣기*/\r\n");
      out.write("        .int-area input {\r\n");
      out.write("            \r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 20px 10px 10px;    /*텍스트창 크기*/\r\n");
      out.write("            background-color: transparent;  /*input창 배경과 합치기*/\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-bottom: 1px solid #999999;\r\n");
      out.write("            font-size: 19px; \r\n");
      out.write("            color: #999999;\r\n");
      out.write("            outline: none; /*텍스트창 선택했을 때 테두리 안 나오게*/\r\n");
      out.write("        }\r\n");
      out.write("        .int-area label {\r\n");
      out.write("            position: absolute; \r\n");
      out.write("            left: 10px;\r\n");
      out.write("            top: 15px; /*텍스트창에 id/pw 글귀 위치 설정*/\r\n");
      out.write("            font-size: 14px; \r\n");
      out.write("            color: #999999;\r\n");
      out.write("            transition: all 0.5s ease;\r\n");
      out.write("        }\r\n");
      out.write("        .int-area input:focus + label, \r\n");
      out.write("        .int-area input:valid + label { /*텍스트창에 id/pw 글귀 클릭시 움직임*/\r\n");
      out.write("            top: -2px;\r\n");
      out.write("            font-size: 12px; \r\n");
      out.write("            color: #166cea;    /*텍스트창 클릭하면 색깔바뀌면서 작아짐*/\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-area {\r\n");
      out.write("            margin-top: 155px;\r\n");
      out.write("        } /*로그인버튼 꾸미기*/\r\n");
      out.write("\r\n");
      out.write("        .btn-area button {\r\n");
      out.write("            width: 50%; \r\n");
      out.write("            height: 30px;\r\n");
      out.write("            background-color: rgb(223, 179, 86);\r\n");
      out.write("            color: #999999;\r\n");
      out.write("            /* border: none; */\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("            cursor: pointer; /*마우스올리면손가락표시*/\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn-area input {\r\n");
      out.write("            width: 50%; \r\n");
      out.write("            height: 30px;\r\n");
      out.write("            background-color: rgb(223, 179, 86);\r\n");
      out.write("            color: #999999;\r\n");
      out.write("            /* border: none; */\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("            cursor: pointer; /*마우스올리면손가락표시*/\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .caption { /*캡션 꾸미기*/\r\n");
      out.write("            margin-top: 60px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        .caption a {\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("            color: #999999;\r\n");
      out.write("            /* text-decoration: none; 캡션 밑에 밑줄 */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"main-container\">\r\n");
      out.write("        <h1 class=\"logo\" style=\"font-family: 'Lobster', cursive; font-size: 60px;\">tongrami</h1>\r\n");
      out.write("        <div>\r\n");
      out.write("        <form action=\"login\" method=\"POST\">\r\n");
      out.write("            <div class=\"int-area\">\r\n");
      out.write("                <input type=\"text\" name=\"memId\" id=\"id\" autocomplete=\"off\" required>\r\n");
      out.write("                <label for=\"id\">USER NAME</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"int-area\">\r\n");
      out.write("                <input type=\"password\" name=\"memPass\" id=\"pw\" autocomplete=\"off\" required>\r\n");
      out.write("                <label for=\"pw\">PASSWORD</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"btn-area\">\r\n");
      out.write("                <input type=\"submit\" value=\"LOGIN\">\r\n");
      out.write("                <button type=\"submit\">JOIN</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"caption\">\r\n");
      out.write("            <a href=\"\">Forgot Password?</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
