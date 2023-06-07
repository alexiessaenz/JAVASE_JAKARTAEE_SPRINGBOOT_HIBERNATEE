package org.alexiessaenz.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String nombre;


    public Banco() {
        cuentas=new ArrayList<>();
    }
}

public void addCuenta (Cuenta cuenta){
    cuentas.add(cuenta);
    cuenta.setBanco(this);
}

public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto){
    origen.debito(monto);
    destino.credito(monto);
}