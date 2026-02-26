<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<div class="container">
    <h1>Modifier le client</h1>

    <form method="post" action="<%= request.getContextPath()%>/clients">

        <input type="hidden" name="idClt"
               value="<%= request.getParameter("id") %>">

        <label>Nom</label>
        <input type="text" name="nomClt"
               value="<%= request.getParameter("nomClt") %>" required>

        <label>Ville</label>
        <input type="text" name="villeClt"
               value="<%= request.getParameter("villeClt") %>" required>

        <div class="form-actions">
            <button class="btn btn-warning" type="submit"
                    name="action" value="update">
                Update
            </button>

            <a href="<%= request.getContextPath()%>/clients">Annuler</a>
        </div>
    </form>
</div>