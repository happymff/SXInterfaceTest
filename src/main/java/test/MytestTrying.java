package test;

import util.HttpUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class MytestTrying {
    Map<String, Object> postData = new HashMap<String, Object>();
    String baseURL = "http://192.168.11.197:30091/users";
    String userHeader = "{\"enable\":1,\"password\":\"1111\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":869451,\"schoolUserRef\":\"151f5f5a-7a91-4d27-a94d-39c1edffdaee\",\"userId\":8435376,\"userIdentity\":1,\"userName\":\"爱学派MFF\"}";

    @Test
    public void userInfo() throws Exception {
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER",userHeader);
        String str = HttpUtil.get("http://192.168.11.197:30091/users", postData, headerMap,3000, 3000, "UTF-8");
        System.out.println(str);
    }
}