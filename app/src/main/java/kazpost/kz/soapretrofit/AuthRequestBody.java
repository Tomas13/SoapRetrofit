package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */

@Root(name = "soapenv:Body", strict = false)
class AuthRequestBody {

    @Element(name = "sch:AuthorizeRequest", required = true)
    private AuthRequestData authRequestData;

    public AuthRequestData getAuthRequestData() {
        return authRequestData;
    }

    public void setAuthRequestData(AuthRequestData authRequestData) {
        this.authRequestData = authRequestData;
    }
}
