package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.request.User;

import static io.restassured.RestAssured.given;

public class TokenClient extends Base {

    public Response createTokenRequest(User user){
        return given(requestSpecification)
                .when()
                .header("username", user.getUsername())
                .header("password", user.getPassword())
                .log().all()
                .post("https://6eb09d60-49ab-4b68-a285-4d0ae49f85c2.mock.pstmn.io/token")
                .then().log().all()
                .extract()
                .response();
    }
}
