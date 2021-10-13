var SanPablo = ["Las Cruces", "Las Joyas", "María Auxiliadora", "La Puebla", "Las Quintanas", "Uriche", "La Amelia", "Las Pastoras"];
var RinconSabanilla = ["Rincón de Ricardo", "Miraflores", "Calle Cordero", "Rinconada"];
var distrito = ["San Pablo", "Rincon Sabanilla"];


//ver formulario o descargar
function mostrar(){
    var principal = document.getElementById("principal");
    var botones = document.getElementById("opciones");
    var resultado = document.getElementById("resultados");
    principal.style.display === "block" ? (
        principal.style.display = "none", 
        botones.style.display = "block",
        resultado.style.display = "block"
    ) : (
        botones.style.display = "none",
        principal.style.display = "block",
        cargar_Distritos(),
        resultado.style.display = "none"
    );
}

function descarga() {
    var link = document.createElement("a");
    link.download = "Formulario_Ayuda_Temporal.pdf";
    link.href = "https://www.filemail.com/d/zdalsebgwkwyayt";
    link.click();
}

//Select de direccion
function cargar_Distritos() {
    var opciones = document.getElementById("distritoSelect");
    var text = "";
    distrito.forEach(d => {text += `<option>${d}</option>`;});
    opciones.innerHTML = text;
}

function cargar_Barrios() {
    var dis = document.getElementById("distritoSelect").value.replace(/ /g, "");
    var barrios = document.getElementById("barrioSelect");
    var text = "";
    dis === 'SanPablo' ? 
        SanPablo.forEach(b => {text += `<option>${b}</option>`;}):
        RinconSabanilla.forEach(b => {text += `<option>${b}</option>`;});        
    barrios.innerHTML = text;
}

//Crear objeto Ayuda Temporal
function direccion(){
    var direccion = new Object();
    direccion.distrito = document.getElementById("distritoSelect").value;
    direccion.barrio = document.getElementById("barrioSelect").value; 
    direccion.direccionExacta = document.getElementById("direccionInput").value;
    return direccion;
}

function Persona(){
    var persona = new Object();
    persona.cedula = document.getElementById("cedula").value;
    persona.nombre = document.getElementById("nombre").value;
    persona.primerApellido = document.getElementById("pApellido").value;
    persona.segundoApellido = document.getElementById("sApellido").value;
    persona.telefonoHabitacion = document.getElementById("tHabitacion").value;
    persona.telefonoCelular = document.getElementById("tCelular").value;
    persona.direccion = direccion();
    return persona;
}

function solicitud(){
    var solicitud = new Object();
    solicitud.motivoAyuda = document.getElementById("mAyuda").value;
    solicitud.solicitante = Persona();
    solicitud.estado = 1;
    solicitud.IdFormulario = solicitud.solicitante.telefonoCelular *(Math.floor(Math.random() * 11)+2);
    solicitud.fechaCreacion = new Date();
    return solicitud;
}

//Validaciones
function validaciones(){
    var bandera = true;
    document.getElementById("distritoSelect").value == "" ? bandera = false : undefined;
    document.getElementById("barrioSelect").value == "" ? bandera = false : undefined;
    document.getElementById("direccionInput").value == "" ? bandera = false : undefined;
    document.getElementById("cedula").value == "" ? bandera = false : undefined;
    document.getElementById("nombre").value == "" ? bandera = false : undefined;
    document.getElementById("pApellido").value == "" ? bandera = false : undefined;
    document.getElementById("sApellido").value == "" ? bandera = false : undefined;
    document.getElementById("tCelular").value == "" ? bandera = false : undefined;
    document.getElementById("mAyuda").value == "" ? bandera = false : undefined;
    return bandera;
}


//Guardar datos
function guardar(){
    var ayuda;
    var formulario = document.getElementById("formulario"); 
    validaciones() ? (
        ayuda = JSON.stringify(solicitud()),
        formulario.reset(),
        postJSON(`1/${ayuda}`,mensaje)
    ) : console.log("Faltan Datos");
}

function mensaje(dato){
    mostrar();
    var mensaje = document.getElementById("resultados");
    var txt;
    dato !== -1 ? txt = `<p><b>Solicitud #${dato} guarde este dato para consultar estado</b><p>` : 
            txt = "<p><b>Error al enviar formulario por favor vuelva a intentarlo o descargue el formulario</b><p>";
    mensaje.innerHTML = txt;
}