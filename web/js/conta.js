function editar() {
    var todos = document.querySelectorAll('#todos-inputs input[type="text"], input[type="email"], input[type="date"]');
    for (var i = 0; i < todos.length; i++) {
        todos[i] = todos[i].disabled = false;
    }

    var editar = document.querySelector('#editarPerfil');
    editar.hidden = true;
    var enviar = document.querySelector('#enviar');
    enviar.hidden = false;
    var foto = document.querySelector('#fotoPerfil');
    foto.hidden = false;
};