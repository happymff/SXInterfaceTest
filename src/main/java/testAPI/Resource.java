package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class Resource {

    //首页-资源管理列表-JIAOXUE-SERVICE-API-10
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void getResources(String baseCourseURL) throws Exception {
        String  pageNum = "1";
        String  pageSize = "1";
        String  offset = "0";
        Map params = new HashMap();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("offset", offset);
        String askURL = "/resources";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //查找用户-JIAOXUE-SERVICE-API-？？？？？？？？？？？？？？
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void findUser(String baseCourseURL) throws Exception {
        String  id = "1";
        String askURL = "/resources"+id;
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