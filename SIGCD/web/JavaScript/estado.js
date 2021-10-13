function consultar(){
    var id = document.getElementById("numeroSolicitudInput").value;
    id !== "" ? getJSON(id,mostrar) : undefined;
}

function mostrar(err,dato){
  var ehtml = document.getElementById("estadoSolicitudLabel");
  var txt;
  var solicitud;
  err !== -1 ? (
    solicitud = JSON.parse(dato.map.solicitud),
    solicitud.estado === 1 ? txt = "En proceso" : solicitud.estado === 2 ? 
            txt = "Aprobada" : txt = "Rechazada"
    ) : txt = "No se encontro solicitud con ese id";
  ehtml.innerHTML = txt;
}