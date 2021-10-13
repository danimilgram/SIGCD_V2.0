
//Metodos para llamar al servidor
function postJSON(datos, callback) {
    fetch(`servidor/ws/datosJSON/${datos}/`, {
        method: 'POST'
    }).then(result => {
        return result.status === 200 ? result.json() : undefined;
    }).then(resultados => {
        resultados !== undefined ? JSON.parse(resultados.map.respuesta) === 1 ? 
        callback(JSON.parse(resultados.map.id)) :  callback(-1) : console.log("Algo salio mal al llamar a post");
    });
}

function putJSON(datos) {
    fetch(`servidor/ws/datosJSON/${datos}/`, {
        method: 'PUT'
    }).then(
        alternar()
    );
}

function getJSON(peticion, callback) {
    fetch(`servidor/ws/datosJSON/${peticion}/`, { method: 'GET'
    }).then(result => {
        return result.status === 200 ? result.json() : undefined;
    }).then(resultados => {
        resultados !== undefined ? resultados.map.respuesta === 1 ? callback(1,resultados) :
                callback(-1,resultados)  : console.log("Algo salio mal en el servidor");
    });
}


