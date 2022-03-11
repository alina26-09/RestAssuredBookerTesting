package Test;
import Initialization.SignIn;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Booking;
import utils.RestApiRequests;

import java.util.logging.Logger;

public class CreateBookingTest {
    String id;
    String token;

    private static final Logger logger  = Logger.getLogger(CreateBookingTest.class.getName());

    RestApiRequests req = new RestApiRequests();
    @Test(priority = 1)
    // test to see if get method works
    public void getBookingByIdTest() {
        String idNeeded = "1";
        Response booking = req.getBookingById(idNeeded);
        logger.info(booking.asString());
    }

    @Test(priority = 2)
    // post a booking and check if the name I want is now on the list
    public void postBookingTest() {
        Booking booking = new Booking("Ana", "Maria",
                300, true,
                "2022-01-02", "2023-01-01",
                "spa");
        Response addedBook = req.postBooking(booking.getJsonString());
        logger.info(addedBook.asString());
        id = addedBook.jsonPath().getString("bookingid");
        Assert.assertEquals(addedBook.jsonPath().getString("booking.firstname"), "Ana");
    }

    @Test(priority = 3)
    // verify after post if the name I posted is in the list, getting it by id
    public void getTest() {
        Response booking = req.getBookingById(id);
        Assert.assertEquals(booking.jsonPath().getString("lastname"), "Maria");
    }


    @Test(priority = 4)
    // update booking by id
    public void updateTest() {
        SignIn signIn = new SignIn();
        token = signIn.auth();
        Booking booking = new Booking("aaaa", "Maria",
                300, true,
                "2022-01-02", "2023-01-01",
                "spa");
        Response updatedBooking = req.updateBooking(booking.getJsonString(), id, token);
        logger.info(updatedBooking.asString());
    }

    @Test(priority = 5)
    // delete the last book I added
    public void deleteBookTest() {
        Response deletedBook = req.deleteBooking(id, token);
        logger.info(String.valueOf(deletedBook.getStatusCode()));
    }
}
