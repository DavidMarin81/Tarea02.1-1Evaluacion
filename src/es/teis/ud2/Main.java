/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.ud2;

import es.teis.ud2.exceptions.InstanceNotFoundException;
import es.teis.ud2.exceptions.SaldoInsuficienteException;
import es.teis.ud2.model.AccountMovement;
import es.teis.ud2.model.dao.empleado.EmpleadoSQLServerDao;
import es.teis.ud2.services.empleado.EmpleadoService;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class Main {

    public static void main(String[] args) {

        //Método a comprobar
        AccountMovement accMovement = transferirDineroEntreEmpleados(7369, 7499, new BigDecimal(1500));
        if (accMovement != null) {
            System.out.println("Se ha creado el registro:\n" + accMovement.toString());
        } 
    }


    private static AccountMovement transferirDineroEntreEmpleados(int empnoOrigen, int empnoDestino, BigDecimal cantidad) {
        AccountMovement accMovement = null;
        try {
            //Completa para crear el servicio  y llamar a su método  transferir(int empnoOrigen, int empnoDestino, BigDecimal cantidad)
            EmpleadoSQLServerDao empleado = new EmpleadoSQLServerDao();
            EmpleadoService servicio = new EmpleadoService(empleado);
            accMovement = servicio.transferir(empnoOrigen, empnoDestino, cantidad);
        } catch (SaldoInsuficienteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstanceNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accMovement;
    }

}
