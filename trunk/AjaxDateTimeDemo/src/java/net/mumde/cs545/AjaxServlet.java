/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mumde.cs545;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashish
 */
@WebServlet(name="AjaxServlet", urlPatterns={"*.ajax"})
public class AjaxServlet extends HttpServlet {
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
  {
    // Four ways to determine whether to handle date or temperature
    String s;
    // 1. Read the content
    //BufferedReader br = request.getReader();
    //s = br.readLine();
    // 2. Look at the servlet path (e.g., date.ajax return date, temp.ajax return temperature
    //s = request.getServletPath();
    // 3. Use getParameter by setting parameters in xhr.open
    // Can add name/value pairs to the url argument of xhr.open
    // xhr.open("POST", url+"?"+params, …
   // 4. Use getParameter.
    // Hint: you will need to add the following to start.jsp. Put it after the xhr.open(...);
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // xhreq.send("figure1=5&figure2=6"); -- except use appropriate name/value pairs

    try {
        Thread.sleep(5000);
    }
    catch (InterruptedException e) {
        
    }
    response.setContentType("text/plain");
    response.setHeader("Cache-Control", "no-cache");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().write(((new java.util.Date()).toString()));
  }
}
