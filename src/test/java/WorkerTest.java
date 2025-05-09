import org.example.Customer;
import org.example.User;
import org.example.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkerTest {

    @Test
    public void displayInfoTest() {
        User worker = new Worker("Bob",  18, User.Gender.MALE,1);
        String expected = "Name: Bob, Gender: Male, Age: 18, WorkerId: 1";
        String result = worker.displayInfo();

        Assertions.assertEquals(expected, result);
    }


    @Test
    public void refundTest() {
        Customer customer = new Customer("Bob", 1000);
        User worker = new Worker("Bob",  18, User.Gender.MALE,1);
        double amount = 200;

        worker.refund(customer);

        double expected = 1200;
        double result = customer.getAccountBalance();

        Assertions.assertEquals(expected, result);
    }
}
