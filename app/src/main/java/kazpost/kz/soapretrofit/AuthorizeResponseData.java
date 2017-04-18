package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by root on 4/17/17.
 */

@Root(name = "ns2:ResponseInfo", strict = false)
class AuthorizeResponseData {

    @Element(name = "ns2:ResponseGenTime", required = true)
    private String ResponseGenTime;

    @Element(name = "ns2:ResponseCode", required = true)
    private String ResponseCode;

    @Element(name = "ns2:ResponseText", required = true)
    private String ResponseText;


    public String getResponseGenTime() {
        return ResponseGenTime;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public String getResponseText() {
        return ResponseText;
    }
}
