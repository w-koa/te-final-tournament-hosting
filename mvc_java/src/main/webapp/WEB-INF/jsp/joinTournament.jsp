<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div id="dashboardHeader">
	<c:choose>
		<c:when test="${empty currentUser}">
			<c:url var="loginHref" value="/login" />
			<a href="${loginHref}"><button class="btn btn-primary">Log
					In</button></a>
		</c:when>
		<c:when test="${currentUser.role != 2}">
			<h2>You must be an team captain to join a tournament!</h2>
			<c:url var="newUserHref" value="/users/new" />
			<a href="${newUserHref}"><button class="btn btn-primary">Register</button></a>
		</c:when>
	</c:choose>
</div>
<div>
	<h1>Team Captain Dashboard</h1>
	<h2>
		<c:out value="Welcome, ${currentUser.userName}!" />
	</h2>

</div>
<div class="col-md-8">

	<div>
		<h1>Join Tournament</h1>
	</div>

	<div class="form-group">
		<c:url var="joinTournamentURL" value="/tournaments/join" />
		<form method="POST" action="${joinTournamentURL}" id="joinTournament">
			<div>
				<label for="name">Tournament Name: </label> <select
					id="tournamentSelect" class="form-control" name="tournamentId">
					<c:forEach var="tournament" items="${allTournaments}">
						<option value="${tournament.id}">${tournament.name} - ${tournament.game}</option>
					</c:forEach>

				</select>
				<input type="hidden" value="${userTeam.id}" name="teamId">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">Join
					Tournament</button>
			</div>
		</form>
	</div>

</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />