package kazpost.kz.soapretrofit;

import com.facebook.stetho.json.annotation.JsonValue;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import pt.joaocruz04.lib.annotations.JSoapAttribute;
import pt.joaocruz04.lib.annotations.JSoapClass;
import pt.joaocruz04.lib.annotations.JSoapResField;
import pt.joaocruz04.lib.misc.SOAPDeserializable;

/**
 * Created by root on 4/18/17.
 */

@Root(name = "AuthorizeResponse")
public class Reply extends SOAPDeserializable{


    @Element(name = "ResponseGenTime")
    private String ResponseGenTime;

    @Element(name = "ResponseCode")
    private String ResponseCode;

    public String getResponseGenTime() {
        return ResponseGenTime;
    }

    public String getResponseCode() {
        return ResponseCode;
    }
}
