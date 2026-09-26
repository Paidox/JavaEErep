package com.example.lr2_java_2;

public class Service
{
  public double[] byPowerSeries(double x, int n, double e)
  {
    double result = 0;
    double resultSum = 0;
    double powTemp;
    int nSum = 0;

    if (n > 0)
    {
      result = 1.0;
      powTemp = -x;
    }
    else
    {
      powTemp = 1.0;
    }

    for (int i = 1; i < n; i++)
    {
      result += (i + 1) * powTemp;
      powTemp *= -x;
    }

    powTemp = -x;
    double currentTerm = 1.0;
    int iTerm = 1;

    if (Math.abs(currentTerm) > e)
    {
      resultSum += currentTerm;
    }

    while (true) {
      currentTerm = (iTerm + 1) * powTemp;
      if (Math.abs(currentTerm) <= e)
      {
        break;
      }
      resultSum += currentTerm;
      powTemp *= -x;
      iTerm++;
      nSum++;
    }

    double fx = 1.0 / Math.pow((1.0 + x), 2);

    return new double[] { result, resultSum, nSum, fx };
  }

  public double fun(double x)
  {
    return Math.pow(x, 0.3);
  }

  public int countStep(double start, double finish, double step)
  {
    return (int) ((finish - start) / step) + 1;
  }

  public double[] generateXArray(double start, double finish, double step)
  {
    int n = countStep(start, finish, step);
    double[] xArray = new double[n];

    for (int i = 0; i < n; i++)
    {
      xArray[i] = start + i * step;
    }
    return xArray;
  }

  public double[] generateYArray(double[] xArray)
  {
    double[] yArray = new double[xArray.length];

    for (int i = 0; i < xArray.length; i++)
    {
      yArray[i] = fun(xArray[i]);
    }
    return yArray;
  }
}