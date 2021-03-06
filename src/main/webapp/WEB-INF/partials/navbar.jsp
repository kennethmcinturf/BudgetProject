<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>

                <c:when test="${user != null}">
                    <li><a href="/budgets/create">Create Budget</a></li>
                    <li><a href="/budgets">Your Budgets</a></li>
                    <li><a href="/profile">User Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>

            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
