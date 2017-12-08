package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class Statistics {

    //首页-任务列表接口-JIAOXUE-SERVICE-API-37
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void getAllTask(String baseCourseURL) throws Exception {
        String  classId = "1291044";
        String  gradeId = "1";
        String  subjectId = "1";
        Map params = new HashMap();
        params.put("classId", classId);
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        String askURL = "/statistics/task-distributes";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-教学统计-JIAOXUE-SERVICE-API-15
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void getAllTeacherTask(String baseCourseURL) throws Exception {
        String  classId = "1291044";
        String  gradeId = "1";
        String  subjectId = "1";
        Map params = new HashMap();
        params.put("classId", classId);
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        String askURL = "/statistics/teach-statistics";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-资源上传榜/首页-校内资源共享榜-JIAOXUE-SERVICE-API-14
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void getUploadRanks(String baseCourseURL) throws Exception {
        String askURL = "/statistics/upload-ranks";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-资源统计-JIAOXUE-SERVICE-API-16
    @Test(description = "baseURL-Resource", dataProvider = "baseURL-Resource", dataProviderClass = DataProvid.class)
    public void getUploadTendency(String baseCourseURL) throws Exception {
        String  gradeId = "1";
        String  subjectId = "0";
        Map params = new HashMap();
        params.put("gradeId", gradeId);
        params.put("subjectId", subjectId);
        String askURL = "/statistics/upload-tendencies";
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