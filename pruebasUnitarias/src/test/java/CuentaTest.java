import jdk.jfr.Enabled;
import org.alexiessaenz.exceptions.DineroInsuficienteException;
import org.alexiessaenz.models.Banco;
import org.alexiessaenz.models.Cuenta;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CuentaTest {
    private TestInfo testInfo;
    private TestReporter testRepoter;

    void initMetodoTesst(TestInfo testInfo, TestReporter testRepoter){
        this.cuenta = new Cuenta("Andres", new BigDecimal("100.12345"))
    }

    void tearDown(){
        System.out.println();
    }
}

@Tag("Cuenta")
@Nested
@DisplayName("prando atributos de la cuenta corriente")
public class CuentaTestNombreSaldo {

    @Test
    @DisplayName("el nombre")
    void testNombreCuenta(){
        testRepoter.publishEntry(testInfo.getTags().toString());
        if(testInfo.getTags().contains("cuenta")){
            testReporter.publishEntry("hacer algo con la etiqueta cuenta");
        }
        cuenta.setPersona("Andres");
        String esperado = "andres";
        String real = cuenta.getPersona();
        assertNotNull(real, ()->"elnombre de la duenta no es el que se esperaba: " +
                "se esperaba "+ esperado + "sin embargo fue " + real);
        assertTrue (real.equals("Andres"), () -> "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("el saldo, que no sea null, mayor que cero, valor esperado")
    void testSaldoCuenta(){
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345,cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("teseando referencias que sean iguales con el metodo equals")
    void testReferenciaCuenta(){
        cuenta = new cuenta("John Doe", new BigDecimal("8900.997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.997"));
//        assertNotEquals(cuenta2,cuenta);
        assertEquals(cuenta2,cuenta);
    }

    @Nested
    class CuentaoperacinesTest{
        @Tag("Cuenta")
        @Test
        void testDebitoCuenta(){
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo().intValue());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("Cuenta")
        @Test
        void testCreditoCuenta(){
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSAldo());
            assertEquals(1100,cuenta.getSaldo().toPlainString());
        }

        @Tag("Cuenta")
        @Tag("Banco")
        @Test
        void testTransferirDineroCuentas(){
            Cuenta cuenta1 = new Cuenta("Jhon Doe",new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Andres",new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2,cuenta1, new BigDecimal(500));
            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());


        }
        @Tag("Cuenta")
        @Tag("error")
        @Test
        void testDineroInsuficienteExceptionCuenta(){
            Exception exception = assertThrows(DineroInsuficienteException.class , ()-> {
                cuenta.debito(new BigDecimal(1500));
            });
            String actual = exception.getMessage();
            String esperado = "Dinero Insuficiente";
            assertEquals(esperando,actual);
        }
        @Tag("Cuenta")
        @Tag("Banco")
        @Test
        @DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
        void testRelacionBancoCuentas(){
            Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));
            Banco banco = new Banco();
            banco.addCuenta(cuenta1);
            banco.addCuenta(cuenta2);

            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertAll(()-> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                    ()-> "el valor del saldo de la cuenta2 no es el esperando."),
                    ()->assertEquals("3000",cuenta1.getSaldo().toPlainString(),
                    ()-> "el valor del saldo de la cuenta1 no es el esperando."),
                    ()->assertEquals("Banco del Estado", cuenta1.getBanco().getNombre(),
                            ()-> assertEquals("Andres", banco.getCuentas().stream()
                                    .filter(c->c.getPersona().equals("Andres"))))
            )
        }


        @Nested
        class sistemaOperativoTest{
            @Test
            @EnabledOnOs(OS.WINDOWS)
            void testSoloWindows(){

            }

            @Test
            @EnabledOnOs({OS.LINUX,OS.MAC})
            void testSoloLinuxMac(){

            }

            @Test
            @DisabledOnOs(OS.WINDOWS)
            void testNoWindows(){

            }

            @Nested
            class JavaVersionTest{
                @Test
                @EnabledOnJre(JRE.JAVA_8)
                void soloJdk8(){

                }

                @Test
                @DisabledOnJre(JRE.JAVA_15)
                void
            }

            @Nested
            class sistemaPropertiesTest{
                @Test
                void imprimirSystemProperties(){
                    Properties properties = System.getProperties();
                    properties.forEach((k,v)-> System.out.println(k+" : " + v));
                }

                @Test
                @EnabledIfSystemProperty(named="java.version", matches = ".*15.*")
                void testJavaVersion(){

                }

                @Test
                @DisabledIfSystemProperty(named="os.arch", matches = ".*32.*")
                void testSolo64(){

                }

                @Test
                @EnabledIfSystemProperty(named="os.arch",matches = ".*32.*")
                void testN064(){

                }

                @Test
                @EnabledIfSystemProperty(named="user.name",matches = ".*32.*")
                void sdfsdf(){

                }
            }

            @Nested
            class VariableAmbienteTest{
                @Test
                void imprimirVariablesAmbiente(){
                    Map<String,String> gentev = System.getenv();
                    gentev.forEach((k,v)-> System.out.println(k+" = " + v));
                }

                @Test
                @EnabledIfEnvironmentVariable(named="JAVA_HOME", matches=".*jdk-15.0.1.*")
                void testJavaHome(){

                }

                @Test
                @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
                void testEnv(){

                }

                @Test
                @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "prod")
                void testEnvProdDisabled(){

                }

                @Test
                @DisplayName("test saldo Cuenta Dev")
                void testSaldoCuentaDev(){
                    boolean esDev = "dev".equals(System.getProperty("ENV"));
                    assumeTrue(esDev);
                    assertNotNull(cuenta.getSaldo());
//                    assertEquals
                }

                @Test
                @DisplayName("Test Saldo Cuenta dev 2")
                void testSaldocuentaDev2(){
                    boolean esDev = "dev".equals(System.getProperty("ENV"));
                    assumingThat(esDev,()->{
                        assertNotNull(cuenta.getSaldo());
                        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
                    });
                    assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
                    assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
                }

                @DisplayName("Probando Debido Cuenta Repetir!")
                @RepeatedTest(value = 5,name="{displayName} - Repeticion numero {currentRepetition" +
                        "de {totalRepetitions")
                void testDebitoCuentaRepetir(RepetitionInfo info){
                    if(info.getCurrentRepetition() == 3){
                        System.out.println("Estamos en la repeticion "+info.getCurrentRepetition());
                    }
                    cuenta.debito(new BigDecimal(100));
                    assertNotNull(cuenta.getSaldo());
                    assertEquals(900,cuenta.getSaldo().intValue());
                    assertEquals("900.12345",cuenta.getSaldo().toPlainString());
                }
            }

            @Nested
            @Tag("param")
            class PruebasParametrizadasTest{
                @ParameterizedTest(name="numero{index} ejecutando con valor {0} -{argumentsWithNames}")
                @ValueSource(Strings = {"100","200","300","500","700","1000.12345"})
                void testDebitoCuentaValueSource(String monto){
                    cuenta.debito(new BigDecimal(monto));
                    assertNotNull(cuenta.getSaldo());
                    assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
                }
            }
        }

    }
}
