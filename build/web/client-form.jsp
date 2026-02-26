<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<div class="container">
    <h1>Ajouter un client</h1>

    <form method="post" action="<%= request.getContextPath() %>/clients">
        <label>Nom</label>
        <input type="text" name="nomClt" required>

        <label>Ville</label>
        <input type="text" name="villeClt" required>

        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Ajouter</button>
            <a href="<%= request.getContextPath() %>/clients">Annuler</a>
        </div>
    </form>
</div>