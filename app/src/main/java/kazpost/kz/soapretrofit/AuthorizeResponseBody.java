package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */

@Root(name = "SOAP-ENV:Body", strict = false)
public class AuthorizeResponseBody {

    @Element(name = "ns2:AuthorizeResponse", required = true)
    @Namespace( prefix = "ns2", reference = "http://webservices.kazpost.kz/mobiterminal/schema")
    private RootBody rootBody;

    public RootBody getRootBody() {
        return rootBody;
    }

    public void setRootBody(RootBody rootBody) {
        this.rootBody = rootBody;
    }

}
