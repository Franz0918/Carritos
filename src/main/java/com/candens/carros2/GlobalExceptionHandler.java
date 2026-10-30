
package com.candens.carros2;

import com.candens.carros2.Dto.Errores.ErrorFranz;
import com.candens.carros2.Dto.Errores.PersonaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //LE DICE A SPRING QUE ESTE ES E LUGAR DONDE SE MANEJA EXEPCIONES/PONGO ERRORES (AQUI BUSCA)
public class GlobalExceptionHandler {

    // CAPTURA CUANDO EL BODY DE BRUNO VIENE TOTALMENTE VACÍO
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorFranz> handleEmptyBody(HttpMessageNotReadableException ex) {
        ErrorFranz respuesta = new ErrorFranz(
                "Petición incorrecta",
                "No puedes enviar la petición sin datos. El cuerpo (Body JSON) es obligatorio.",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    // CAPTURA CUANDO NO SE ENCUENTRA UN RECURSO
    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<ErrorFranz> handlePersonaNotFound(PersonaNotFoundException ex) {
        ErrorFranz respuesta = new ErrorFranz(
                "Recurso no encontrado",
                ex.getMessage(), // Aquí viaja tu texto: "EL CARRO CON ID..."
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    // PARA DATOS NULOS E INVALIDOS
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorFranz> handleBadRequest(IllegalArgumentException ex) {
        ErrorFranz respuesta = new ErrorFranz(
                "Petición mal echa",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    // AQUI SE EXTRAE LOS MENSAJES DE CRRODTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorFranz> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // AQUÍ SE EXTRAEN LOS MENSAJES DE CARRODTO
        String mensajeError = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("Error en validación en los argumentos.");

        ErrorFranz respuesta = new ErrorFranz(
                "VALIDACION FALLO",
                mensajeError,
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}



/*package com.candens.carros2;

import com.candens.carros2.Dto.Errores.PersonaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // CAPTURA CUANDO EL BODY DE BRUNO VIENE TOTALMENTE VACÍO
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyBody(HttpMessageNotReadableException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "Petición incorrecta");
        respuesta.put("mensajito", "No puedes enviar la petición sin datos. El cuerpo (Body JSON) es obligatorio.");
        respuesta.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    //
    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePersonaNotFound(PersonaNotFoundException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "Recurso no encontrado");
        respuesta.put("mensajito", ex.getMessage()); // Aquí viaja tu texto: "EL CARRO CON ID..."
        respuesta.put("status", HttpStatus.NOT_FOUND.value()); //  404

        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    // PARA DATOS NULOS I INVALIDOS
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "Petición incorrecta");
        respuesta.put("mensajito", ex.getMessage());
        respuesta.put("status", HttpStatus.BAD_REQUEST.value()); //  400

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "VALIDACION FALLO");
        respuesta.put("status", HttpStatus.BAD_REQUEST.value());

        // AQUI SE EXTRAE LOS MENSAJES DE CRRODTO
        String mensajeError = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("Error en validación en los arguentos.");

        respuesta.put("mensajito", mensajeError);

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}

 */