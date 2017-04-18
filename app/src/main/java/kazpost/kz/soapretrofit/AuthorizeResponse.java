package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */

@Root(name = "SOAP-ENV:Body", strict = false)
public class AuthorizeResponse {


    @Element(name = "ns2:AuthorizeResponse", required = true)
    @Namespace( prefix = "ns2", reference = "http://webservices.kazpost.kz/mobiterminal/schema")
    private AuthorizeResponseData authorizeResponseData;

    public AuthorizeResponseData getAuthorizeResponseData() {
        return authorizeResponseData;
    }

    public void setAuthorizeResponseData(AuthorizeResponseData authorizeResponseData) {
        this.authorizeResponseData = authorizeResponseData;
    }


}
