package apitest;

import client.SendInvoiceClient;
import client.TokenClient;
import client.ViewInvoiceClient;
import io.restassured.response.Response;
import model.request.Invoice;
import model.request.User;
import model.response.ViewInvoiceResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileHelper;

public class CaseStudyTests {

    @Test
    public void whenUserPostTokenServiceShouldRetrieveToken()  {

        TokenClient tokenClient = new TokenClient();
        Response tokenResponse = tokenClient.createTokenRequest(new User("sedatyurt", "Test12345"));
        Assert.assertNotNull(tokenResponse.path("token"));
        Assert.assertEquals(tokenResponse.path("token").getClass(), String.class);


    }

    @Test
    public void whenUserGetViewInvoiceServiceShouldRetrieveInvoiceLink() {

        ViewInvoiceClient viewInvoiceClient = new ViewInvoiceClient();
        ViewInvoiceResponse viewInvoiceResponse = viewInvoiceClient.createViewInvoiceRequest();
        Assert.assertEquals(viewInvoiceResponse.getInvoiceLink(),"http://abc.com/invoice.pdf");
        Assert.assertEquals(viewInvoiceResponse.getResult().isSuccess(),true);

    }

    @Test
    public void whenUserPostSendInvoiceServiceShouldBeSuccess() {

        TokenClient tokenClient = new TokenClient();
        Response tokenResponse = tokenClient.createTokenRequest(new User("sedatyurt", "Test12345"));
        SendInvoiceClient sendInvoiceClient = new SendInvoiceClient();
        Response response = sendInvoiceClient.createSendInvoiceRequest(tokenResponse.path("token"), new Invoice("barcode"));
        Assert.assertEquals(response.statusCode(),200);
        FileHelper.writeResponseToFile();


    }
}
