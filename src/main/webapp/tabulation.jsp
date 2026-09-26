<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result of Tabulation</title>
    <link rel="stylesheet" href="css/tabulationStyle.css">
</head>
<body>
    <h2>Graph of a function</h2>

    <div style='width: 600px; background: white; padding: 15px; border: 1px solid #ccc; border-radius: 4px;'>
        <canvas id='tabulationChart'></canvas>
    </div>

    <script src='https://cdn.jsdelivr.net/npm/chart.js'></script>
    <script>
        const ctx = document.getElementById('tabulationChart').getContext('2d');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: ${xJson},
                datasets: [{
                    label: 'y = x^0.3',
                    data: ${yJson},
                    borderColor: 'blue',
                    backgroundColor: 'blue',
                    fill: false,
                    tension: 0.1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    x: { title: { display: true, text: 'X' } },
                    y: { title: { display: true, text: 'Y' } }
                }
            }
        });
    </script>

    <h3>Tabulation value</h3>

    <table>
        <tr>
            <th>x</th>
            <th>y</th>
        </tr>
        <c:forEach var="i" begin="0" end="${xArray.length - 1}">
            <tr>
                <td><fmt:formatNumber value="${xArray[i]}" pattern="0.0000" /></td>
                <td><fmt:formatNumber value="${yArray[i]}" pattern="0.0000" /></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href='index.jsp'>Back to Main Page</a>

</body>
</html>