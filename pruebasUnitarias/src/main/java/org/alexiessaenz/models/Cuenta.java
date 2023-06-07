package org.alexiessaenz.models;

import org.alexiessaenz.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public class Cuenta {
    private String persona;
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
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cuenta cuenta = (Cuenta) o;
//        return Objects.equals(persona, cuenta.persona) && Objects.equals(saldo, cuenta.saldo) && Objects.equals(banco, cuenta.banco);
        if (!(o instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) o;
        if (this.persona == null|| this.saldo == null){
            return false;
        }
        return this.persona.equals((c.getPersona()) && this.saldo.equals(c.getSaldo());
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(persona, saldo, banco);
//    }

    public void debito(BigDecimal monto){
        BigDecimal nuevosaldo = this.saldo.subtract(monto);
        if (nuevosaldo.compareTo(BigDecimal.ZERO) <0){
            throw new DineroInsuficienteException("Dinero insuficiente")
        }
        this.saldo = nuevosaldo;
    }
}
