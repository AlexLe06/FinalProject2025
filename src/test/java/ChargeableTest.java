import org.example.Customer;
import org.example.Driver;
import org.example.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChargeableTest {

    @Test
    public void chargeTest() {
        Worker worker = new Worker("Dylan");
        Customer customer = new Customer("Bob", 1000);
        double amount = 200;

        worker.charge(customer, amount);

        double expected = 800;
        double result = customer.getAccountBalance();

        Assertions.assertEquals(expected, result);
    }
}
