package org.tbsJunit.models;

import org.tbsJunit.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private  String persona;
    private BigDecimal saldo;
    private Banco banco;

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuenta cuenta = (Cuenta) o;

        if (!persona.equals(cuenta.persona)) return false;
        if (!saldo.equals(cuenta.saldo)) return false;
        return banco.equals(cuenta.banco);*/

        if(!(o instanceof  Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) o;
        if (this.persona == null || this.saldo == null){
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }

    //@Override
   /* public int hashCode() {
        int result = persona.hashCode();
        result = 31 * result + saldo.hashCode();
        result = 31 * result + banco.hashCode();
        return result;
    }*/

    public void debito(BigDecimal monto){
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero Insuficiente");
        }
        this.saldo = nuevoSaldo;
    }

    public void credito(BigDecimal monto){ this.saldo= this.saldo.add(monto);

    }
}
