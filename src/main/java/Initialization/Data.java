package Initialization;

import java.util.Base64;

public class Data {
    public  String username = "YWRtaW4=";
    public  String password = "cGFzc3dvcmQxMjM=";

    public String getUser() {
        byte[] decodedBytes = Base64.getDecoder().decode(this.username);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public String getPassword() {
        byte[] decodedBytes = Base64.getDecoder().decode(this.password);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
