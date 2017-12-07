package test;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class Users {

    //获取用户个人信息-JIAOXUE-SERVICE-API-01
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getAllModules(String baseCourseURL) throws Exception {
        String askURL = "/users";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-上传用户头像-JIAOXUE-SERVICE-API-02?????????????????
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void updateMaterials(String baseCourseURL) throws Exception {
        String  file = "1";
        Map params = new HashMap();
        params.put("file", file);
        String askURL = "/users/photos.do";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

}