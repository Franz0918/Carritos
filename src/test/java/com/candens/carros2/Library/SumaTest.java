package com.candens.carros2.Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

 @Test
 public void xmayory(){
    Suma abc = new Suma();
    int x =abc.sumar(2,3);
    assertEquals(5,x);
 }

 @Test
 public void xmenory(){
    Suma abc = new Suma();
    int y= abc.sumar(3,2);
    assertEquals(10,y);
  }

}

/*
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Inicializa las anotaciones de Mockito
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repositoryMock; // 1. Creamos el clon falso

    @InjectMocks
    private UsuarioService usuarioService; // 2. Java inyecta el clon falso dentro de este servicio real

    @Test
    public void testObtenerNombreUsuario() {
        // 3. ENTRENAMOS al clon: Cuando pidan el ID 5, devuelve este usuario de juguete
        Usuario usuarioFalso = new Usuario(5, "Carlos");
        Mockito.when(repositoryMock.findById(5)).thenReturn(usuarioFalso);

        // 4. EJECUTAMOS nuestra lógica real
        String nombre = usuarioService.obtenerNombreDeUsuario(5);

        // 5. COMPROBAMOS el resultado
        assertEquals("Carlos", nombre);

        // 6. VERIFICAMOS: ¿El repositorio falso fue consultado?
        Mockito.verify(repositoryMock).findById(5);
    }
}

 */