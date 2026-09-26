<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Power Series Results</title>
    <link rel="stylesheet" href="css/byPowerSeriesStyle.css">
</head>
<body>

    <h2>Calculation Results (Power Series)</h2>

    <p><b>Input parameters:</b> x = ${x}, n = ${n}, e1 = ${e1}, e2 = ${e2}</p>

    <table>
        <tr>
            <th>Parameter</th>
            <th>Value (for e1)</th>
            <th>Value (for e2)</th>
        </tr>
        <tr>
            <td>Sum of n terms</td>
            <td>${sumN1}</td>
            <td>${sumN2}</td>
        </tr>
        <tr>
            <td>Sum by precision (e)</td>
            <td>${sumE1}</td>
            <td>${sumE2}</td>
        </tr>
        <tr>
            <td>Terms count (nSum)</td>
            <td>${count1}</td>
            <td>${count2}</td>
        </tr>
        <tr>
            <td>Exact value f(x)</td>
            <td>${exact1}</td>
            <td>${exact2}</td>
        </tr>
    </table>

    <br>
    <a href='index.jsp'>Back to Main Page</a>

</body>
</html>