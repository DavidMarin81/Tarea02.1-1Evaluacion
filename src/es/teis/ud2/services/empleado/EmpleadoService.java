/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.ud2.services.empleado;

import es.teis.ud2.exceptions.InstanceNotFoundException;
import es.teis.ud2.exceptions.SaldoInsuficienteException;
import es.teis.ud2.model.Account;
import es.teis.ud2.model.AccountMovement;
import es.teis.ud2.model.Empleado;
import es.teis.ud2.model.dao.account.AccountSQLServerDao;
import es.teis.ud2.model.dao.accountMovement.AccountMovementSQLServerDao;
import es.teis.ud2.model.dao.empleado.IEmpleadoDao;
import java.math.BigDecimal;

/**
 *
 * @author maria
 */
public class EmpleadoService implements IEmpleadoServicio {

    private IEmpleadoDao empleadoDao;

    public EmpleadoService(IEmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;

    }

    @Override
    public Empleado create(Empleado empleado) {

        return this.empleadoDao.create(empleado);
    }

    @Override
    public AccountMovement transferir(int empnoOrigen, int empnoDestino, BigDecimal cantidad) throws SaldoInsuficienteException, InstanceNotFoundException, UnsupportedOperationException {
        //A) Se crea un nuevo BigDecimal para hacer la comparacion
        //Si da 0 -> el valor es igual al valor comparado
        //Si da 1 -> el valor es mayor al valor comparado
        //Si da -1 -> el valor es menor al valor comparado
        BigDecimal minimo = new BigDecimal(0);
        if (cantidad.compareTo(minimo) <= 0) {
            throw new UnsupportedOperationException();
        }
        
        
        //Recuperar dato
        AccountMovement movimiento = new AccountMovement();
        Account cuentaEmpleadoOrigen = new Account();
        Account cuentaEmpleadoDestino = new Account();
        AccountSQLServerDao accountSQL = new AccountSQLServerDao();
        AccountMovementSQLServerDao mov = new AccountMovementSQLServerDao();
        
        cuentaEmpleadoOrigen = accountSQL.read(empnoOrigen);
        
        if (cuentaEmpleadoOrigen != null) {
            BigDecimal dineroOrigen = cuentaEmpleadoOrigen.getMontante();
            if (dineroOrigen.compareTo(cantidad) <= 0){
                throw new SaldoInsuficienteException("No hay saldo suficiente", dineroOrigen, cantidad);
            } else {
                cuentaEmpleadoDestino = accountSQL.read(empnoDestino);
                int idMov = accountSQL.transferir(cuentaEmpleadoOrigen.getAccountId(), cuentaEmpleadoDestino.getAccountId(), cantidad);
                
                movimiento = mov.read(idMov);
                
                if (movimiento == null){
                    throw new InstanceNotFoundException(movimiento, "Movimiento");
                }
            }
        } else {
            movimiento = null;
        }
        
        return movimiento;
    }
    
    

}
