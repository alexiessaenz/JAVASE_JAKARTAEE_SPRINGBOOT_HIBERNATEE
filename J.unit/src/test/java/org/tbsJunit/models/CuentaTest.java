package org.tbsJunit.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    Cuenta cuenta;

    private TestInfo testInfo;

    private TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Iniciando el metodo.");
        testReporter.publishEntry(" ejecutando; " + testInfo.getDisplayName() +" "
                + testInfo.getTestMethod().orElse(null).getName()
                + "con las etiquetas " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("finalizando el metodo de prueba.");
    }

    @BeforeAll
    static void  beforeAll(){
        System.out.println("inicializando el test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("finalizando el test");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("probando atributos de la cuenta corriente")
    class  CuentaNombreCuenta() {
        @Test
        @DisplayName("el nombre!")
        void testNombreCuenta(){
            testReporter.publishEntry(testInfo.getTags().toString());
            if (testInfo.getTags().contains("cuenta")){
                testReporter.publishEntry("hacer algo con la etiqueta cuenta");
            }
            //cuenta.setPersona("Andres");
            String esperado = "Andres";
            String real = cuenta.getPersona();
            assertNotNull(real, ()-> "el nombre de la cuenta no es el que se esperaba; se esperaba " + esperado
            + " sin embargo fue " + real);
            assertTrue(real.equals("Andres"), ()-> "nombre de cuenta esperada debe ser igual a la real");
        }
    }

    @Test
    @DisplayName("el saldo, que no sea null, mayor que cero, valor esperado.")
    void testSaldoCuenta() {
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("testeaando referencias que sean iguales con el metodo equals.")
    void testReferenciaCuenta(){
        cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        //assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);
    }

    @Test
    void getPersona() {
    }

    @Test
    void setPersona() {
    }

    @Test
    void getSaldo() {
    }

    @Test
    void setSaldo() {
    }

    @Test
    void getBanco() {
    }

    @Test
    void setBanco() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void debito() {
    }

    @Test
    void credito() {
    }
}