package com.candens.carros2.Library;

public class Suma {

     int c=3;

    public int sumar(int x, int y){

       if (x>y){
           c=10;

       } else{
           c=5;
       }
       System.out.println("respuesta= "+c);
        return c;
    }

}

/*

----------PARA WEBFLUX------------------

--------LIBRERIAS A IMPORTAR---------------
        import reactor.core.publisher.Flux;
        import reactor.core.publisher.Mono;

-------DEPENDENCIAS PARA EL POM-------
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>


 */
