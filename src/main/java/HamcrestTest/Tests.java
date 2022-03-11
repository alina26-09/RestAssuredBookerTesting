package HamcrestTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.RestApiRequests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

    RestApiRequests req = new RestApiRequests();
    Response idsList;

    @Test
    public void getOneBook() {
        Response booking = req.getBookingById("1");
        System.out.println(booking.asString());
    }

    @Test(priority = 1)
    public void getAllBooksTest() {
        Response resp = req.getAllBooks();
        System.out.println(resp.asString());
        idsList = resp;
        assertThat(resp, notNullValue());
    }
}
