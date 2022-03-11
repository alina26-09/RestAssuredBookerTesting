package utils;

import com.github.javafaker.Bool;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

public class Booking {
    public String firstname;
    public String lastname;
    public Integer totalprice;
    public boolean depositpaid;
    public String checkin;
    public String checkout;
    public String additionalneeds;

    public  Booking(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
                        String checkin, String checkout, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalneeds = additionalneeds;
    }

    public String getJsonString() {
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);
        booking.put("firstname", firstname);
        booking.put("lastname", lastname);
        booking.put("totalprice", totalprice);
        booking.put("depositpaid", depositpaid);
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", additionalneeds);
        return booking.toJSONString();
    }
}
