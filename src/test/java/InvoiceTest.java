import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Invoice;
import com.example.InvoiceGenerator;
import com.example.Ride;
import com.example.RideType;


public class InvoiceTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void verifyTotalCost() {
        double cost = invoiceGenerator.calculateFare(12, 25);
        assertEquals(150, cost);
    }

    @Test
    public void verifyMinimumCost() {
        double cost = invoiceGenerator.calculateFare(2, 3);
        assertEquals(5, cost);
    }

    @Test
    public void verifyMultipleRideCost() {
        Ride[] rides = { new Ride(1, 6, 12, RideType.NORMAL), new Ride(1, 11, 22, RideType.NORMAL),
                new Ride(1, 9, 16, RideType.NORMAL) };
        double totalCost = invoiceGenerator.calculateFare(rides);
        assertEquals(240, totalCost);
    }

    @Test
    public void verifyGeneratedInvoice() {
        Ride[] rides = { new Ride(1, 6, 12, RideType.NORMAL), new Ride(1, 11, 22, RideType.NORMAL),
                new Ride(1, 9, 16, RideType.NORMAL) };
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getNumRides());
        assertEquals(240, invoice.getTotalFare());
        assertEquals(80.0, invoice.getAverageFare());
    }

    @Test
    public void verifyUserInvoice() {
        new Ride(1, 6, 12, RideType.NORMAL);
        new Ride(1, 11, 22, RideType.NORMAL);
        new Ride(2, 9, 16, RideType.NORMAL);

        Invoice invoice = invoiceGenerator.generateInvoiceForUser(1);
        assertEquals(2, invoice.getNumRides());
        assertEquals(150, invoice.getTotalFare());
        assertEquals(75, invoice.getAverageFare());
    }

    @Test
    public void verifyRidesWithType() {
        Ride[] rides = { new Ride(1, 6, 12, RideType.NORMAL), new Ride(1, 11, 22, RideType.NORMAL),
                new Ride(1, 8, 15, RideType.PREMIUM) };
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getNumRides());
        assertEquals(300, invoice.getTotalFare());
        assertEquals(100, invoice.getAverageFare());
    }
}
