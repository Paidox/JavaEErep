package com.example.lr2_java_2;

import java.io.*;
import java.util.Locale;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "tabulationServlet", value = "/tabulation-servlet")
public class TabulationServlet extends HttpServlet
{
  private Service service;

  public void init()
  {
    service = new Service();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    try
    {
      double a = Double.parseDouble(request.getParameter("a"));
      double b = Double.parseDouble(request.getParameter("b"));
      double h = Double.parseDouble(request.getParameter("h"));

      double[] xArray = service.generateXArray(a, b, h);
      double[] yArray = service.generateYArray(xArray);

      StringBuilder xJson = new StringBuilder("[");
      StringBuilder yJson = new StringBuilder("[");

      for (int i = 0; i < xArray.length; i++)
      {
        xJson.append(String.format(Locale.US, "%.4f", xArray[i]));
        yJson.append(String.format(Locale.US, "%.4f", yArray[i]));
        if (i < xArray.length - 1)
        {
          xJson.append(", ");
          yJson.append(", ");
        }
      }
      xJson.append("]");
      yJson.append("]");

      request.setAttribute("xArray", xArray);
      request.setAttribute("yArray", yArray);
      request.setAttribute("xJson", xJson.toString());
      request.setAttribute("yJson", yJson.toString());

      request.getRequestDispatcher("tabulation.jsp").forward(request, response);
    }
    catch (NumberFormatException e)
    {
      response.sendRedirect("index.jsp");
    }
  }
}