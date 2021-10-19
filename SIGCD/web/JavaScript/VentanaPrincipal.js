var VentanaPrincipal =
    `<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" 
    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
    aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.html">Inicio<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tipo de ayudas</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="AyudaTemporal.html">Temporales</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="BecaMunicipal.html">Becas estudiantiles</a>
                </div>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="EstadoSolicitud.html">Ver estado de mi solicitud<span class="sr-only"></span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="app.html">Calendario<span class="sr-only"></span></a>
            </li>
            </div>
    </nav>`;

var contenido = `<div>
                    <img src = "imagenes/Header.jpg" width = "100%">
                <\div>`;

function cargarVentanaPrincipal() {
     $('body').prepend(contenido);
    $('body').prepend(VentanaPrincipal);
   
}

$(cargarVentanaPrincipal);

function ver(x){
    var menu;
    x == 1 ? (
        menu = document.getElementById("opciones"),
        menu.style.display = menu.style.display == "none" ? "block" : "none"
    ) : (
        menu = document.getElementById("opciones2"),
        menu.style.display = menu.style.display == "none" ? "block" : "none"
    );
}

function requisitos(x){
    var datos = document.getElementById("informacion");
    var txt;
    datos.style.display = datos.style.display == "none" ? "block" : "none";
    txt = "<p>Requisitos:</p>";
    datos.innerHTML = txt;
    
}


