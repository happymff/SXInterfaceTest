package test;

import com.alibaba.fastjson.JSON;
import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import util.HttpUtil;
import org.testng.annotations.Test;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class AdministerInfo {
    //String baseGeneralURL = "http://192.168.11.197:30091";

    //根据用户ID 获取用户可以管理的班级信息-JIAOXUE-SERVICE-API-25
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void adminClass(String baseGeneralURL) throws Exception {
        String askURL = "/administers/classes";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291045".equals(classId));
    }

    //根据用户的ID 获取用户的班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-26
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void adminClassSubject(String baseGeneralURL) throws Exception {
        System.out.println(baseGeneralURL);
        String askURL = "/administer/class/subject";
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //根据用户的ID 获取用户的年级、班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-26
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void adminGradeClassSubject(String baseGeneralURL) throws Exception {
        String askURL = "/administer/grade/class/subject";
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //根据用户ID获取资源的年级班级列表-JIAOXUE-SERVICE-API-28
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void adminGradeSubject(String baseGeneralURL) throws Exception {
        String askURL = "/administer/grade/grade_subject";
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //根据用户的ID 获取用户的年级和班级所包含的科目信息-JIAOXUE-SERVICE-API-28
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void adminSubject(String baseGeneralURL) throws Exception {
        String askURL = "/administer/grade/subject";
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}