package client;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import model.request.Invoice;
import model.request.User;

import static io.restassured.RestAssured.given;

public class SendInvoiceClient extends Base{

    public Response createSendInvoiceRequest(String token, Invoice invoice){
        return given(requestSpecification)
                .when()
                .header("token", token)
                .body(invoice)
                .log().all()
                .post("https://6eb09d60-49ab-4b68-a285-4d0ae49f85c2.mock.pstmn.io/sendInvoice")
                .then().log().all()
                .extract()
                .response();
    }
}
