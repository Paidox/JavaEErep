package com.example.lr2_java_2;

import java.io.*;
import java.util.Locale;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "byPowerSeriesServlet", value = "/by-power-series-servlet")
public class ByPowerSeriesServlet extends HttpServlet
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
      double x = Double.parseDouble(request.getParameter("x"));
      int n = Integer.parseInt(request.getParameter("n"));
      double e1 = Double.parseDouble(request.getParameter("e1"));
      double e2 = Double.parseDouble(request.getParameter("e2"));


      if (x <= -1 || x >= 1 || n <= 0)
      {
        request.setAttribute("errorMessage", " 'x' must be > -1 and < 1, 'n' must be > 0");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
      }

      double[] res1 = service.byPowerSeries(x, n, e1);
      double[] res2 = service.byPowerSeries(x, n, e2);

      request.setAttribute("x", x);
      request.setAttribute("n", n);
      request.setAttribute("e1", e1);
      request.setAttribute("e2", e2);

      request.setAttribute("sumN1", String.format(Locale.US, "%.6f", res1[0]));
      request.setAttribute("sumN2", String.format(Locale.US, "%.6f", res2[0]));

      request.setAttribute("sumE1", String.format(Locale.US, "%.6f", res1[1]));
      request.setAttribute("sumE2", String.format(Locale.US, "%.6f", res2[1]));

      request.setAttribute("count1", (int) res1[2]);
      request.setAttribute("count2", (int) res2[2]);

      request.setAttribute("exact1", String.format(Locale.US, "%.6f", res1[3]));
      request.setAttribute("exact2", String.format(Locale.US, "%.6f", res2[3]));

      request.getRequestDispatcher("power-series.jsp").forward(request, response);
    }
    catch (NumberFormatException e)
    {
      response.sendRedirect("index.jsp");
    }
  }
}