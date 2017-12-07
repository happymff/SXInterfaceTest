package test;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class Index {

    //首页-获取用户可配置的所有模块-JIAOXUE-SERVICE-API-04
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getAllModules(String baseCourseURL) throws Exception {
        String askURL = "/indexes/all-modules";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-获取用户配置的首页-JIAOXUE-SERVICE-API-03
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void updateMaterials(String baseCourseURL) throws Exception {
        String askURL = "/indexes/modules";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-头部导航-JIAOXUE-SERVICE-API-03
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getNavigations(String baseCourseURL) throws Exception {
        String askURL = "/indexes/navigations";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}