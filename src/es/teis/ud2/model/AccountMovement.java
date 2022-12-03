/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.ud2.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author David Marín
 */
public class AccountMovement {
    private int accountOriginId;
    private int accountDestId;
    private BigDecimal amount;
    //De tipo DateTime
    private Date datetime;
    //De tipo Date
    private Date fecha;

    public AccountMovement(int accountOriginId, int accountDestId, BigDecimal amount, Date datetime, Date fecha) {
        this.accountOriginId = accountOriginId;
        this.accountDestId = accountDestId;
        this.amount = amount;
        this.datetime = datetime;
        this.fecha = fecha;
    }
    
    public AccountMovement() {
    }

    public int getAccountOriginId() {
        return accountOriginId;
    }

    public void setAccountOriginId(int accountOriginId) {
        this.accountOriginId = accountOriginId;
    }

    public int getAccountDestId() {
        return accountDestId;
    }

    public void setAccountDestId(int accountDestId) {
        this.accountDestId = accountDestId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
    
    
    
}
