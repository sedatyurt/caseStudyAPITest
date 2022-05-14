package client;

import model.response.ViewInvoiceResponse;

import static io.restassured.RestAssured.given;

public class ViewInvoiceClient extends Base {

    public ViewInvoiceResponse createViewInvoiceRequest(){
        return given(requestSpecification)
                .when()
                .log().all()
                .param("barcode","barcode")
                .get("https://6eb09d60-49ab-4b68-a285-4d0ae49f85c2.mock.pstmn.io/viewInvoice")
                .then().log().all()
                .extract()
                .response()
                .jsonPath().getObject("",ViewInvoiceResponse.class);
    }
}
