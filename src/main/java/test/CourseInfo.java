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

    //创建课程-JIAOXUE-SERVICE-API-48
    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void createCourse(String baseCourseURL) throws Exception {
        String paramJson = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",1);
        List classList =new ArrayList();
        classList.add(paramJson);
        String courseId = "1000030744";
        String courseName = "test add course";
        String courseRemark = "test";
        String gradeId = "1";
        String materialId = "484011575";
        String moduleId = null;
        String subjectId = "1";
        String termId = "d154e782-0922-11e7-9395-2fc6565cc9de";
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
        System.out.println("params:"+params);
        String askURL = "/courses";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-爱学派课程-JIAOXUE-SERVICE-API-39
    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
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

//    //获取教材列表-JIAOXUE-SERVICE-API-29
//    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
//    public void getMaterialList(String baseCourseURL) throws Exception {
//        String subjectId = "1";
//        String gradeId = "1";
//        String isIndex = "1";
//        Map params = new HashMap();
//        params.put("isIndex", isIndex);
//        params.put("subjectId", subjectId);
//        params.put("gradeId", gradeId);
//        String askURL = "/course/materialList";
//        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
//        Map headerMap = new HashMap();
//        headerMap.put("ZUUL_CURRENT_USER", userHeader);
//        String url = baseCourseURL + askURL;
//        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
//        System.out.println(str);
//        Integer code = JsonResults.getJsonCode(str);
//        Assert.assertTrue(code==1);
//    }
//
//    //保存教师选择的教材-JIAOXUE-SERVICE-API-47
//    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
//    public void postTeacherMaterial(String baseCourseURL) throws Exception {
//        String subjectId = "1";
//        String gradeId = "1";
//        String termId = "0090cf10-729d-4d8b-b402-d2d5aa172c55";
//        String materialId = "487478305";
//        Map params = new HashMap();
//        params.put("isIndex", termId);
//        params.put("subjectId", subjectId);
//        params.put("gradeId", gradeId);
//        params.put("materialId", materialId);
//        String askURL = "/course/teacherMaterial";
//        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
//        Map headerMap = new HashMap();
//        headerMap.put("ZUUL_CURRENT_USER", userHeader);
//        String url = baseCourseURL + askURL;
//        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
//        System.out.println(str);
//        Integer code = JsonResults.getJsonCode(str);
//        Assert.assertTrue(code==1);
//    }

    //首页教师课程列表-JIAOXUE-SERVICE-API-22
    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
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
    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
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
    @Test(description = "登陆成功", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
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