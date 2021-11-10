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
    link.href = "https://www.filemail.com/d/gqziwaosasvjoti";
    link.click();
}

//Secciones formulario

function Seccion(seccion){
    var vector = [document.getElementById("estudiante"),document.getElementById("direccion"),
        document.getElementById("madre"),document.getElementById("padre")];
    vector.map(x => x.style.display = "none");
    vector[seccion-1].style.display ="block";
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

//Crear solicitud BecaMunicipal
function direccion(){
    var direccion = new Object();
    direccion.distrito = document.getElementById("distritoSelect").value;
    direccion.barrio = document.getElementById("barrioSelect").value; 
    direccion.direccionExacta = document.getElementById("direccionInput").value;
    return direccion;
}

function Madre(){
    var persona = new Object();
    persona.cedula = document.getElementById("mCedula").value;
    persona.nombre = document.getElementById("mNombre").value;
    persona.primerApellido = document.getElementById("mpApellido").value;
    persona.segundoApellido = document.getElementById("msApellido").value;
    persona.telefonoHabitacion = document.getElementById("mtHabitacion").value;
    persona.telefonoCelular = document.getElementById("mtCelular").value;
    persona.direccion = direccion();
    return persona;
}

function Padre(){
    var persona = new Object();
    persona.cedula = document.getElementById("pCedula").value;
    persona.nombre = document.getElementById("pNombre").value;
    persona.primerApellido = document.getElementById("ppApellido").value;
    persona.segundoApellido = document.getElementById("psApellido").value;
    persona.telefonoHabitacion = document.getElementById("ptHabitacion").value;
    persona.telefonoCelular = document.getElementById("ptCelular").value;
    persona.direccion = direccion();
    return persona;
}

function Estudiante(){
    var persona = new Object();
    persona.cedula = document.getElementById("cedula").value;
    persona.nombre = document.getElementById("nombre").value;
    persona.primerApellido = document.getElementById("pApellido").value;
    persona.segundoApellido = document.getElementById("sApellido").value;
    persona.telefonoHabitacion = document.getElementById("tHabitacion").value;
    persona.telefonoCelular = document.getElementById("tCelular").value;
    persona.edad = document.getElementById("edad").value;
    persona.gradoAcademico = document.getElementById("gAcademico").value;
    persona.fechaNacimiento = document.getElementById("fNacimiento").value;
    persona.madre = Madre();
    persona.padre = Padre();
    persona.direccion = direccion();
    return persona;
}

function solicitud(){
    var solicitud = new Object();
    solicitud.estudiante = Estudiante();
    solicitud.estado = 1;
    solicitud.IdFormulario = solicitud.estudiante.telefonoCelular *(Math.floor(Math.random() * 11)+2);
    solicitud.fechaCreacion = new Date();
    return solicitud;
}

//validaciones

function validaciones(){
    var bandera = true;
    document.getElementById("distritoSelect").value === "" ? bandera = false: undefined;
    document.getElementById("barrioSelect").value === "" ? bandera = false: undefined; 
    document.getElementById("direccionInput").value === "" ? bandera = false: undefined;
    document.getElementById("mCedula").value === "" ? bandera = false: undefined;
    document.getElementById("mNombre").value === "" ? bandera = false: undefined;
    document.getElementById("mpApellido").value === "" ? bandera = false: undefined;
    document.getElementById("msApellido").value === "" ? bandera = false: undefined;
    document.getElementById("mtCelular").value === "" ? bandera = false: undefined;
    document.getElementById("pCedula").value === "" ? bandera = false: undefined;
    document.getElementById("pNombre").value === "" ? bandera = false: undefined;
    document.getElementById("ppApellido").value === "" ? bandera = false: undefined;
    document.getElementById("psApellido").value === "" ? bandera = false: undefined;
    document.getElementById("ptCelular").value === "" ? bandera = false: undefined;
    document.getElementById("cedula").value === "" ? bandera = false: undefined;
    document.getElementById("nombre").value === "" ? bandera = false: undefined;
    document.getElementById("pApellido").value === "" ? bandera = false: undefined;
    document.getElementById("sApellido").value === "" ? bandera = false: undefined;
    document.getElementById("tCelular").value === "" ? bandera = false: undefined;
    document.getElementById("edad").value === "" ? bandera = false: undefined;
    document.getElementById("gAcademico").value === "" ? bandera = false: undefined;
    document.getElementById("fNacimiento").value === "" ? bandera = false: undefined;
    return bandera;
}

//Guardar datos
function guardar(){
    var mascara = document.getElementById("mask");
    var ayuda;
    validaciones() ? (
        ayuda = JSON.stringify(solicitud()),
        document.getElementById("formulario").reset(),
        mascara.style.display = "block",
        postJSON(`2/${ayuda}`,mensaje)
    ) : console.log("Faltan Datos");
}

function mensaje(dato){
    mostrar();
    var mensaje = document.getElementById("resultados");
    var mascara = document.getElementById("mask");
    var txt;
    dato !== -1 ? txt = `<p><b>Solicitud #${dato} Guarde este dato para consultar estado</b><p>` : 
            txt = "<p><b>Error al enviar formulario por favor vuelva a intentarlo o descargue el formulario</b><p>";
    mensaje.innerHTML = txt;
    mascara.style.display = "none";
}