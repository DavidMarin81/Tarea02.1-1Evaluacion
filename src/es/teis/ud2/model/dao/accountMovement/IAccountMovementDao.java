/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.teis.ud2.model.dao.accountMovement;

import es.teis.ud2.exceptions.InstanceNotFoundException;
import es.teis.ud2.model.AccountMovement;
import es.teis.ud2.model.dao.IGenericDao;

/**
 *
 * @author David Marín
 */
public interface IAccountMovementDao extends IGenericDao<AccountMovement>{

    @Override
    public boolean delete(int id);

    @Override
    public boolean update(AccountMovement entity);

    @Override
    public AccountMovement read(int id) throws InstanceNotFoundException;

    @Override
    public AccountMovement create(AccountMovement entity);
    
    
}
