/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.16
 * Generated at: 2017-07-20 01:02:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_005fhtml4_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1500469334622L));
    _jspx_dependants.put("jar:file:/C:/01.web_project/wokrspace/02.pcmanager_workspace_2.0.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/pcmanager.2.0.0/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

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
      out.write("<!-- jstl cofing -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>회원가입</title>\r\n");
      out.write("\r\n");
      out.write("<!-- external css : css/common.css -->\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/pcm/css/common.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- internal js -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t/* 회원아이디 포커스 초기화 */\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tdocument.getElementById(\"memberId\").focus();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 윈도우 로드시 이벤트 처리 */\r\n");
      out.write("\twindow.onload = function() {\t\r\n");
      out.write("\t\tinit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 회원가입 데이터 검증 */\r\n");
      out.write("\tfunction joinCheck() {\r\n");
      out.write("\t\t//alert('joinCheck() call');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar memberId = document.joinForm.memberId.value;\r\n");
      out.write("\t\t//alert(memberId);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar memberPw = document.getElementById(\"memberPw\").value;\r\n");
      out.write("\t\t//alert(memberPw);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar memberPwConfirm = document.getElementById(\"memberPwConfirm\").value;\r\n");
      out.write("\t\t//alert(memberPwConfirm);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar memberName = document.getElementById(\"memberName\").value;\r\n");
      out.write("\t\t//alert(memberName);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar mobile1 = document.getElementById(\"mobile1\").value;\r\n");
      out.write("\t\t//alert(mobile1);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar mobile2 = document.getElementById(\"mobile2\").value;\r\n");
      out.write("\t\t//alert(mobile2);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar mobile3 = document.getElementById(\"mobile3\").value;\r\n");
      out.write("\t\t//alert(mobile3);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar email1 = document.getElementById(\"email1\").value;\r\n");
      out.write("\t\t//alert(email1);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar email2 = document.getElementById(\"email2\").value;\r\n");
      out.write("\t\t//alert(email2);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (memberId.length < 4 || memberId.length > 20) {\r\n");
      out.write("\t\t\talert(\"아이디는 4자리 ~ 20자리 이내로 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"memberId\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (memberPw != memberPwConfirm) {\r\n");
      out.write("\t\t\talert(\"비밀번호와 비밀번호확인을 동일하게 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"memberPw\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (memberPw.length < 6 || memberPw.length > 20) {\r\n");
      out.write("\t\t\talert(\"비밀번호는 6자리 ~ 20자리 이내로 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"memberPw\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (memberName.length == 0) {\r\n");
      out.write("\t\t\talert(\"이름은 필수 입력항목입니다. 이름을 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"memberName\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (mobile2.length < 3  || \r\n");
      out.write("\t\t\t\tmobile2.length > 4 || \r\n");
      out.write("\t\t\t\tisNaN(mobile2)) {\r\n");
      out.write("\t\t\talert(\"전화번호2은 숫자3자리~4자리를 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"mobile2\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (mobile3.length < 4  || \r\n");
      out.write("\t\t\t\tisNaN(mobile3)) {\r\n");
      out.write("\t\t\talert(\"전화번호3은 숫자4자리를 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"mobile3\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar mobile = mobile1 + \"-\" + mobile2 + \"-\" + mobile3;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (email1.length == 0 ) {\r\n");
      out.write("\t\t\talert(\"이메일은 필수 입력항목입니다. 이메일을 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"email1\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (email2 == \"none\" || email2 == \"userInput\" ) {\r\n");
      out.write("\t\t\talert(\"이메일2는 필수 입력항목입니다. 이메일2를 선택 입력하세요\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar email = email1 + email2;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar joinInfo = \"회원입력 가입정보 확인\\n\";\r\n");
      out.write("\t\tjoinInfo += (memberId + \"\\n\");\r\n");
      out.write("\t\tjoinInfo += (memberPw + \"\\n\");\r\n");
      out.write("\t\tjoinInfo += (memberName + \"\\n\");\r\n");
      out.write("\t\tjoinInfo += (mobile + \"\\n\");\r\n");
      out.write("\t\tjoinInfo += (email + \"\\n\\n\");\r\n");
      out.write("\t\tjoinInfo += \"회원가입을 하시겠습니까?\";\r\n");
      out.write("\t\tvar result = confirm(joinInfo);\r\n");
      out.write("\t\tif (result) {\r\n");
      out.write("\t\t\tdocument.joinForm.action = \"/pcm/controller?action=joinSave\";\r\n");
      out.write("\t\t\t// 데이터 검증완료 로그인 요청\r\n");
      out.write("\t\t\tdocument.joinForm.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t/* 이메일 주소 자동 가져오기 */\r\n");
      out.write("\tfunction setEmail2(takeData) {\r\n");
      out.write("\t\t//alert('setEmail2() call' + takeData);\r\n");
      out.write("\t\tvar email1 = document.getElementById(\"email1\").value;\r\n");
      out.write("\t\tif (email1.length == 0) {\r\n");
      out.write("\t\t\talert(\"이메일 아이디를 먼저 입력하시기 바랍니다\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"email1\").focus();\r\n");
      out.write("\t\t\t//alert(document.joinForm.emailSelected.options.length);\r\n");
      out.write("\t\t\tdocument.joinForm.emailSelected.options[0].selected = true;\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (takeData == 'none') {\r\n");
      out.write("\t\t\talert(\"이메일을 선택하시기 바랍니다.\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").value = \"\";\r\n");
      out.write("\t\t} else if (takeData == 'userInput') {\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").readOnly = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").style=\"background-color:#ffffff;\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").focus();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").value = takeData;\r\n");
      out.write("\t\t\tdocument.getElementById(\"email2\").style=\"background-color:#F0F8FF;\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- header area -->\r\n");
      out.write("<!-- logo link -->\r\n");
      out.write("<a href=\"/pcm/index.jsp\">\r\n");
      out.write("<img src=\"/pcm/img/logo.gif\" title=\"홈페이지 이동\">\r\n");
      out.write("</a>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<!-- 로그인 전 메뉴 -->\r\n");
      out.write("<div class=\"menu_area\" style=\"text-align:right;\">\r\n");
      out.write("<a class=\"normal\" href=\"login.jsp\">로그인</a>\r\n");
      out.write("<a class=\"normal\" href=\"join_html4.jsp\">회원가입(html4)</a>\r\n");
      out.write("<a class=\"normal\" href=\"join.jsp\">회원가입(html5)</a>\r\n");
      out.write("<a class=\"normal\" href=\"memberIdAndPw.jsp\">아이디/비밀번호 찾기</a>\r\n");
      out.write("</div>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- content area -->\r\n");
      out.write("<h3>회원가입(html4)</h3>\r\n");
      out.write("<form id=\"joinForm\"  name=\"joinForm\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>아이디</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"text\" name=\"memberId\" id=\"memberId\"\r\n");
      out.write("\t\t\tvalue=\"4~8자리이내\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>비밀번호</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"password\" name=\"memberPw\" id=\"memberPw\"\r\n");
      out.write("\t\t\tvalue=\"6~8자리이내\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>비밀번호확인</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"password\" name=\"memberPwConfirm\" id=\"memberPwConfirm\"\r\n");
      out.write("\t\t\tvalue=\"6~8자리이내\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>이름</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"text\" name=\"memberName\" id=\"memberName\"\r\n");
      out.write("\t\t\tvalue=\"이름\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>연락처</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<select name=\"mobile1\" id=\"mobile1\">\r\n");
      out.write("\t\t\t<option value=\"010\">010</option>\r\n");
      out.write("\t\t\t<option value=\"011\">011</option>\r\n");
      out.write("\t\t\t<option value=\"016\">016</option>\r\n");
      out.write("\t\t\t<option value=\"017\">017</option>\r\n");
      out.write("\t\t\t<option value=\"019\">019</option>\r\n");
      out.write("\t\t</select>-\r\n");
      out.write("\t\t<input type=\"text\" name=\"mobile2\" id=\"mobile2\" maxlength=\"4\">-\r\n");
      out.write("\t\t<input type=\"text\" name=\"mobile3\" id=\"mobile3\" maxlength=\"4\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>이메일</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<input type=\"text\" name=\"email1\" id=\"email1\" >\r\n");
      out.write("\t\t<input type=\"text\" name=\"email2\" id=\"email2\" readonly\r\n");
      out.write("\t\t\tclass=\"readonly\">\r\n");
      out.write("\t\t<select name=\"emailSelected\" \r\n");
      out.write("\t\t\tonchange =\"setEmail2(this.value)\">\r\n");
      out.write("\t\t\t<option value=\"none\">선택</option>\r\n");
      out.write("\t\t\t<option value=\"@naver.com\">네이버</option>\r\n");
      out.write("\t\t\t<option value=\"@gmail.com\">구글</option>\r\n");
      out.write("\t\t\t<option value=\"@dreamwiz.com\">드림위즈</option>\r\n");
      out.write("\t\t\t<option value=\"userInput\">직접입력</option>\r\n");
      out.write("\t\t</select>-\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"회원가입\"\r\n");
      out.write("\t\t\tonclick=\"return joinCheck()\"\r\n");
      out.write("\t\t\tclass=\"btn_normal\">\r\n");
      out.write("\t\t<input type=\"reset\" value=\"취소\"\r\n");
      out.write("\t\t\tclass=\"btn_normal\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- footer area -->\r\n");
      out.write("<hr>\r\n");
      out.write("<div class=\"footer_area\" style=\"text-align:center;\">\r\n");
      out.write("COPYRIGHT 2017 WORK. ALL RIGHTS RESERVED\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
