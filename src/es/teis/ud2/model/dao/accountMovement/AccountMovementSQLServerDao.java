/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.ud2.model.dao.accountMovement;

import es.teis.ud2.data.DBCPDataSourceFactory;
import es.teis.ud2.exceptions.InstanceNotFoundException;
import es.teis.ud2.model.AccountMovement;
import es.teis.ud2.model.Departamento;
import es.teis.ud2.model.dao.AbstractGenericDao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author David Marín
 */
public class AccountMovementSQLServerDao extends AbstractGenericDao<AccountMovement> implements IAccountMovementDao {

    private DataSource dataSource;

    public AccountMovementSQLServerDao() {
        this.dataSource = DBCPDataSourceFactory.getDataSource();
    }

    @Override
    public AccountMovement create(AccountMovement entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AccountMovement read(int id) throws InstanceNotFoundException {
        //Implementar el método read
        int identificador;
        int accountOriginId;
        int accountDestId;
        BigDecimal amount;
        Date datetime;
        Date fecha;
        AccountMovement movimiento = null;
        int contador = 0;
        
        try (
                 Connection conexion = this.dataSource.getConnection();  PreparedStatement sentencia
                = conexion.prepareStatement("SELECT [ACCOUNT_MOV_ID]\n"
                        + "      ,[ACCOUNT_ORIGIN_ID]\n"
                        + "      ,[ACCOUNT_DEST_ID]\n"
                        + "      ,[AMOUNT]\n"
                        + "      ,[DATETIME]\n"
                        + "      ,[FECHA]\n"
                        + "  FROM [empresa].[dbo].[ACC_MOVEMENT] WHERE [ACCOUNT_MOV_ID] = ?");) {
            sentencia.setInt(1, id);
            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                contador = 0;
                identificador = result.getInt(++contador);
                accountOriginId = result.getInt(++contador);
                accountDestId = result.getInt(++contador);
                amount = result.getBigDecimal(++contador);
                datetime = result.getDate(++contador);
                fecha = result.getDate(++contador);

                movimiento = new AccountMovement(accountOriginId, accountDestId, amount, datetime, fecha);

            } else {
                throw new InstanceNotFoundException(id, getEntityClass());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        }
        return movimiento;

    }

    @Override
    public boolean update(AccountMovement entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
