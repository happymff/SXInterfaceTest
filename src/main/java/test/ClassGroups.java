package test;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class ClassGroups {
    String baseGeneralURL = "http://192.168.11.197:30091";

    //据班级的ID获取班级的所有老师信息-JIAOXUE-SERVICE-API-38
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getTeachers() throws Exception {
        String classId = "1291044";
        String askURL = "/class/teacher/"+classId;
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //学生重置密码的时候获取用户的信息-JIAOXUE-SERVICE-API-40
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getUserInfoRepPWD() throws Exception {
        String studentId = "790252";
        String askURL = "/class/student/"+studentId;
        String userHeader = ReadJsonFile.readFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFile.json");
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //获取班级分组详情-JIAOXUE-SERVICE-API-41
    @Test(description = "登陆成功", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getMaterialList() throws Exception {
        String classId = "1291044";
        String yearTerm = "2017~2018";
        String subjectId = "1";
        String askURL = "/class/yearTerm/"+classId+"/"+yearTerm+"/"+subjectId;
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