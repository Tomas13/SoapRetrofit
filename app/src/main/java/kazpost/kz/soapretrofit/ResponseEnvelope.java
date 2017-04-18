package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */


@Root(name = "SOAP-ENV:Envelope", strict = false)
@Namespace( prefix = "SOAP-ENV", reference = "http://schemas.xmlsoap.org/soap/envelope/")
public class ResponseEnvelope {

    @Element(name = "SOAP-ENV:Header", required = false)
    private String header = "";

    @Element(name = "SOAP-ENV:Body", required = false)
    private AuthorizeResponseBody authorizeResponseBody;


    public AuthorizeResponseBody getAuthorizeResponse() {
        return authorizeResponseBody;
    }
}
