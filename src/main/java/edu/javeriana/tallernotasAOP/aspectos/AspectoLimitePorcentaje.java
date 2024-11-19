package edu.javeriana.tallernotasAOP.aspectos;
import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import edu.javeriana.tallernotasAOP.modelo.Estudiante;
import edu.javeriana.tallernotasAOP.modelo.Nota;
import jakarta.servlet.http.HttpServletResponse;

@Aspect
public class AspectoLimitePorcentaje {
    @Before("execution(public * edu.javeriana.tallernotasAOP.servicios.ServiciosNota.save())")
    public void validarPorcentajeAntes(ProceedingJoinPoint joinpoint) throws IOException{
        Estudiante estudiante_nuevo = (Estudiante) joinpoint.getArgs()[0];
        int suma_notas = 0;
        for(Nota nota : estudiante_nuevo.getNotas()){
            suma_notas += nota.getValor();
        }

        if(suma_notas >= 100){
            System.out.println("Una vez en 100% no se puede añadir más");
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                HttpServletResponse response = attrs.getResponse();
                if (response != null) {
                    response.sendRedirect("/error_porcentaje");
                }
            }
        }

    }
}