package test;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CourseInfo {

    //创建课程-JIAOXUE-SERVICE-API-48???????????
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void createCourse(String baseCourseURL) throws Exception {
        String paramJson = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",1);
        List classList =new ArrayList();
        classList.add(paramJson);
        Long courseId = 1000030744L;
        String courseName = "《致女儿的信》";
        String courseRemark = null;
        Integer gradeId = 1;
        Long materialId = 484011575L;
        Long moduleId = null;
        Integer subjectId = 1;
        String termId = "0090cf10-729d-4d8b-b402-d2d5aa172c55";
        Map params = new HashMap();
        params.put("classList", classList);
        params.put("courseId", courseId);
        params.put("courseName", courseName);
        params.put("courseRemark", courseRemark);
        params.put("gradeId", gradeId);
        params.put("materialId", materialId);
        params.put("moduleId", moduleId);
        params.put("subjectId", subjectId);
        params.put("termId", termId);
        String askURL = "/courses";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        try {
            Integer code = JsonResults.getJsonCode(str);
            Assert.assertTrue(code==1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //首页-爱学派课程-JIAOXUE-SERVICE-API-39
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void getCourses(String baseCourseURL) throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String pageSize = "1";
        String pageNum = "3";
        Map params = new HashMap();
        params.put("pageSize", pageSize);
        params.put("sId", subjectId);
        params.put("gId", gradeId);
        params.put("pageNum", pageNum);
        String askURL = "/courses/axp-courses";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页教师课程列表-JIAOXUE-SERVICE-API-22
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void getIndexCourses(String baseCourseURL) throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String askURL = "/courses/grades/" + gradeId+"/subjects/" + subjectId + "/index/courses";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //新建课，浮层信息-JIAOXUE-SERVICE-API-33
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void createInfomations(String baseCourseURL) throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String materialId = "1";
        String askURL = "/courses/grades/" + gradeId + "/subjects/" + subjectId + "/materials/" + materialId + "/creates-information";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //新建课，推荐课程模糊搜索-JIAOXUE-SERVICE-API-36
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void recommendCourses(String baseCourseURL) throws Exception {
        String subjectId = "2";
        String gradeId = "2";
        String materialId = "23434";
        String courseName = "2";
        Map params = new HashMap();
        params.put("courseName", courseName);
        //http://192.168.11.187:9002/courses/grades/1/subjects/1/materials/1/recommendations-courses
        String askURL = "/courses/grades/" + gradeId + "/subjects/" + subjectId + "/materials/" + materialId + "/recommendations-courses";
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