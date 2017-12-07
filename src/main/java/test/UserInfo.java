package test;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class UserInfo {

    //分页查找用户个人动态-JIAOXUE-SERVICE-API-07
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getAllModules(String baseCourseURL) throws Exception {
        String  pageNum = "1";
        String  pageSize = "1";
        Map params = new HashMap();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        String askURL = "/dynamics/personal-dynamics";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //分页查找用户任务动态-JIAOXUE-SERVICE-API-18
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void updateMaterials(String baseCourseURL) throws Exception {
        String  pageNum = "1";
        String  pageSize = "1";
        String  classId = "1";
        Map params = new HashMap();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("classId", classId);
        String askURL = "/dynamics/task-dynamics";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

}