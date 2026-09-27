<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Practical Work 2 - Main Page</title>
    <link rel="stylesheet" href="css/indexStyle.css">
</head>
<body>

    <h1>Practical Work 2</h1>

    <c:if test="${not empty errorMessage}">
        <div class ="error-massage">
            ${errorMessage}
        </div>
    </c:if>

    <div class="wrapper">
        <div class="card">
            <h3>Power Series Calculation</h3>
            <form action="by-power-series-servlet" method="GET">
                <div class="inputs-container">
                    <div class="input-group">
                        <label>x:</label>
                        <input type="text" name="x" required>
                    </div>
                    <div class="input-group">
                        <label>n:</label>
                        <input type="text" name="n" required>
                    </div>
                    <div class="input-row">
                        <div class="input-group">
                            <label>e1:</label>
                            <input type="text" name="e1" required>
                        </div>
                        <div class="input-group">
                            <label>e2:</label>
                            <input type="text" name="e2" required>
                        </div>
                    </div>
                </div>
                <button type="submit">Run Calculation</button>
            </form>
        </div>

        <div class="card">
            <h3>Function Tabulation</h3>
            <form action="tabulation-servlet" method="GET">
                <div class="inputs-container">
                    <div class="input-group">
                        <label>a:</label>
                        <input type="text" name="a" required>
                    </div>
                    <div class="input-group">
                        <label>b:</label>
                        <input type="text" name="b" required>
                    </div>
                    <div class="input-group">
                        <label>h:</label>
                        <input type="text" name="h" required>
                    </div>
                </div>
                <button type="submit">Run Tabulation</button>
            </form>
        </div>
    </div>

</body>
</html>