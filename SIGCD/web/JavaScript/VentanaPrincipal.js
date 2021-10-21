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

function requisitos1(){
    var datos = document.getElementById("informacion");
    var datos2 = document.getElementById("informacion2");
    var txt;
    datos2.style.display = "none";
    datos.style.display = datos.style.display == "none" ? "block" : "none";
    txt = "<p><b>Requisitos:</b></p>";
    txt+="<p>-La municipalidad otorga ayudas temporales ayudas temporales \n\
                a vecinos del canton en situaciones comprobadas de desgracia o infortunio</p>";
    txt +="<p>-Desgracia o infortunio: Aconteciminetos inesperados que amenazan de gravedad la integridad\n\
                fisica y emocional de una persona como hechos porvocados por la naturaleza como terremotos, inudaciones\n\
                derrumbes o bien por hechos derivados de condiciones socieconomicas como muerte, enfermedad,indigencia\n\
                y desempleo, que afecte directamente al solicitante.</p>";
    datos.innerHTML = txt; 
}

function requisitos2(){
    var datos = document.getElementById("informacion2");
    var datos2 = document.getElementById("informacion");
    var txt;
    datos2.style.display = "none";
    datos.style.display = datos.style.display == "none" ? "block" : "none";
    txt = "<p><b>Requisitos:</b></p>";
    txt += "<p>-Solo se recibira la informacion en la fecha indicada</p>";
    txt += "<p>-Si el estudiante tiene beca del programa avncemos o alguna otra no puede optar por una beca municipal</p>";
    txt += "<p>-Una vez aprobada la beca es obligatorio presentar las notas trimestrales a un maximo de \n\
                15 dias despues de haber recibido las notas. Caso contrario se expondra a la anulacion de la beca</p>";
    txt += "<p>-<b>Fechas :</b></p> <p>Distrito San Pablo: Lunes 8 y martes 9 de febrero</p>";
    txt += "<p>Distrito Rincon de Sabanilla: Miercoles 10 y jueves 11 de febrero</p>";
    datos.innerHTML = txt; 
}
