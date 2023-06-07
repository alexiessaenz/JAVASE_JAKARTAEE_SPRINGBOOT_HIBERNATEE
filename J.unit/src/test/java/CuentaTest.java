import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.tbsJunit.models.Cuenta;

import java.math.BigDecimal;

public class CuentaTest {
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


}
