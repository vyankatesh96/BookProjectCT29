/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.0
 * Generated at: 2021-03-15 15:03:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.book.pojo.Book;

public final class booklist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.book.pojo.Book");
    _jspx_imports_classes.add("java.util.List");
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "msgs.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\r');
      out.write('\n');

List<Book> list = (List<Book>)session.getAttribute("list");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"2\" align =\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Id</td>\r\n");
      out.write("<td>Name</td>\r\n");
      out.write("<td>Author</td>\r\n");
      out.write("<td>Price</td>\r\n");
      out.write("<td>Publisher</td>\r\n");
      out.write("<td>No. of Copies</td>\r\n");
      out.write("<td>Description</td>\t\r\n");
      out.write("<td>Rating</td>\r\n");
      out.write("<td>Category</td>\r\n");
      out.write("<td>Image</td>\r\n");
      out.write("<th colspan=\"2\">Action</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
for(Book b: list) {
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>");
      out.print( b.getBookid() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getBookname() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getAuthor() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getBookprice() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getPublisher() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getNoOfCopies() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getDescription() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getRating() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print( b.getCategory() );
      out.write("</td>\r\n");
      out.write("<td><img alt=\"\" src=\"ImageServlet?bookid=");
      out.print(b.getBookid() );
      out.write("\"height=\"100\" width=\"70\"></td>\r\n");
      out.write("<td><a href=\"BookServlet?bookid=");
      out.print(b.getBookid() );
      out.write("&process=updateBook\">Update</a></td>\r\n");
      out.write("<td><a href=\"BookServlet?bookid=");
      out.print(b.getBookid() );
      out.write("&process=deleteBook\" onclick=\"return confirm('Are you sure you want to delete ? ')\">Delete</a></td>\r\n");
      out.write("</tr>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
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