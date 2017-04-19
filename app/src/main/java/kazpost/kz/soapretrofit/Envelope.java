package kazpost.kz.soapretrofit;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.net.URL;
import java.util.List;

@Root(name="Envelope")
public class Envelope {

    @Element(name="Header", required=false)
    String header;

    @Element(name="Body", required=false)
    Body body;

    public String getHeader() {return this.header;}
    public void setHeader(String value) {this.header = value;}

    public Body getBody() {return this.body;}
    public void setBody(Body value) {this.body = value;}

    public static class ResponseInfo {

        @Element(name="ResponseCode", required=false)
        String responseCode;

        @Element(name="ResponseGenTime", required=false)
        String responseGenTime;

        public String getResponseCode() {return this.responseCode;}
        public void setResponseCode(String value) {this.responseCode = value;}

        public String getResponseGenTime() {return this.responseGenTime;}
        public void setResponseGenTime(String value) {this.responseGenTime = value;}

    }

    public static class AuthorizeResponse {

        @Element(name="ResponseInfo", required=false)
        ResponseInfo responseInfo;

        @Element(name="SessionId", required=false)
        String sessionId;

        public ResponseInfo getResponseInfo() {return this.responseInfo;}
        public void setResponseInfo(ResponseInfo value) {this.responseInfo = value;}

        public String getSessionId() {return this.sessionId;}
        public void setSessionId(String value) {this.sessionId = value;}

    }

    public static class Body {

        @Element(name="AuthorizeResponse", required=false)
        AuthorizeResponse authorizeResponse;

        public AuthorizeResponse getAuthorizeResponse() {return this.authorizeResponse;}
        public void setAuthorizeResponse(AuthorizeResponse value) {this.authorizeResponse = value;}

    }

}