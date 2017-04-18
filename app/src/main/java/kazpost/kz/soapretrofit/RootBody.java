package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */

@Root(name = "ns2:AuthorizeResponse", strict = false)
public class RootBody {

    @Element(name = "ns2:ResponseInfo", required = true)
    private AuthorizeResponseData authRequestData;

    public AuthorizeResponseData getAuthRequestData() {
        return authRequestData;
    }

    public void setAuthRequestData(AuthorizeResponseData authRequestData) {
        this.authRequestData = authRequestData;
    }
}
