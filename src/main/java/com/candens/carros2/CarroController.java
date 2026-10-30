package com.candens.carros2;


import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Dto.Errores.PersonaNotFoundException;
import com.candens.carros2.Transactions.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // INDICA Q ES UN CONTROLADOR, AQUI SE DEFINE PARA MODO ESCUCHA(SPRIG CON RESTCONTROLLER SE COMBINAN POR SER PARTEL API REST, LOVUELVE UN API)
@RequestMapping("/api/carros") //LA DIRECCION DEL URI

@CrossOrigin(origins = "*") // ESTO SE AGREGA ESTA LÍNEA AQUÍ

public class CarroController {


    private final RegistrarTransaction registrarEnvio;
    private final BuscarTransaction buscarEnvio;

    private final ListarTransaction listaEnvio;
    private final ActualizarTransaction actualizaEnvio;
    private final BorrarTransaction borraEnvio;

    public CarroController(RegistrarTransaction registrarEnvio, BuscarTransaction buscarEnvio, ListarTransaction listaEnvio, ActualizarTransaction actualizaEnvio, BorrarTransaction borraEnvio) {
        this.registrarEnvio = registrarEnvio;
        this.buscarEnvio = buscarEnvio;
        this.listaEnvio = listaEnvio;
        this.actualizaEnvio = actualizaEnvio;
        this.borraEnvio = borraEnvio;
    }
    //BODY ES PAYLOAD(DATO IMPORTANTE A PROCESAR)
    //POST
    @PostMapping("/registrar") //ECUCHA A INTERNET A LA DIRECCION ...registrar, si ESCUCHAS ALGO HAZ
    public ResponseEntity<CarroDto> postCarro(@Valid @RequestBody CarroDto dto) {//REQUEST TRADUCE JSON A LENGUAJE JAVA Y GUARDA LOS DATOS ENVIADOS EN BRUNO A LA NUEVA VARIABLE dto DE TIPO CarroDto y lo envia A TRANSACCIONES POR EL METODO postcarro/RESPONSE ENTITY CONTENEDOR RPTAS WEB CON OBJETO TIPO CARRODTO
        if (dto == null) { // SEGUN CLASES GENERICAS SPRING NO ADMITE NULL POR LO QUE SE PUEDE DESCARTAR
            throw new IllegalArgumentException("LOS DATOS O EL CUERPO NO DEBE ESTAR VACIO amigo");
        }
        return ResponseEntity.ok(registrarEnvio.ejecutarPost(dto));
    }


    // GET ENDPOINT
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CarroDto>getCarro(@PathVariable Integer id) { //LO QUE VENGA DEL URI QUE ESTA ENTRE {} LO TOMA
        if (id == null) {
            throw new IllegalArgumentException("EL ID NO PIEDE SER NULO amigo");
        }
        // Ejecuta la transacción UNA sola vez. Si es null, lanza la excepción de inmediato.
        CarroDto carroDto = Optional.ofNullable(buscarEnvio.ejecutarGet(id))
                .orElseThrow(() -> new PersonaNotFoundException("EL CARRITO " + id + " NO SE ENCONTRO AMIGO."));

        // SI ESTA OK 200
        return ResponseEntity.ok(carroDto);
    }

    // GET LIST
    @GetMapping("/listar")
    public ResponseEntity<List<CarroDto>>listCarro() {

        return ResponseEntity.ok(listaEnvio.ejecutarList());
    }

    // PUT
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CarroDto> putCarro(@PathVariable Integer id,@Valid @RequestBody CarroDto dto) {

       /* if (dto == null || id == null) {
            throw new IllegalArgumentException("LOS datos de actualización o el ID no pueden ser nulos amigo");
        } */
        // Ejecuta la transacción UNA sola vez. Si es null, lanza la excepción de inmediato.
        CarroDto carroDto = Optional.ofNullable(actualizaEnvio.ejecutarPut(id, dto))
                .orElseThrow(() -> new PersonaNotFoundException("EL CARRITO " + id + " NO SE ENCONTRO AMIGO."));

        // ESTA OK 200
        return ResponseEntity.ok(carroDto);
    }
        // BORARA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Integer id) { //CUERPO DE PAQUETE EN RPTA SERA VACIO
        if (id == null) {
            throw new IllegalArgumentException("El ID para eliminar no puede ser nulo.");
        }

        // 1. Verificamos si el carro existe. Si devuelve null, lanza el error 404 inmediatamente.
        Optional.ofNullable(buscarEnvio.ejecutarGet(id)) //EMPAQUETA EN UN OPTIONAL, USO A EVITQR NULLPOINTEREX, Y VALIDA SI MI ENVOLTURA TIENE O NO TIENE DATOS
                .orElseThrow(() -> new PersonaNotFoundException("No se puede eliminar. El carro con ID " + id + " no existe."));

        // 2. Si existía, procedemos a borrarlo de forma segura
        borraEnvio.ejecutarDelete(id);

        return ResponseEntity.noContent().build();
    }
}

