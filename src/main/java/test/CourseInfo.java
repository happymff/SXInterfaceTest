package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class CourseInfo {
    String baseGeneralURL = "http://192.168.11.197:30092";

    //首页-爱学派课程-JIAOXUE-SERVICE-API-39
    @Test
    public void getCourses() throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String pageSize = "1";
        String pageNum = "3";
        Map params = new HashMap();
        params.put("pageSize", pageSize);
        params.put("subjectId", subjectId);
        params.put("gradeId", gradeId);
        params.put("pageNum", pageNum);
        String askURL = "/course/axp-courses";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String msg = JsonResults.getJsonMsg(str);
        Assert.assertTrue("操作成功".equals(msg) || "success".equals(msg));
    }

    //获取教材列表-JIAOXUE-SERVICE-API-29
    @Test
    public void getMaterialList() throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String isIndex = "1";
        Map params = new HashMap();
        params.put("isIndex", isIndex);
        params.put("subjectId", subjectId);
        params.put("gradeId", gradeId);
        String askURL = "/course/materialList";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //保存教师选择的教材-JIAOXUE-SERVICE-API-47
    @Test
    public void postTeacherMaterial() throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String termId = "0090cf10-729d-4d8b-b402-d2d5aa172c55";
        String materialId = "487478305";
        Map params = new HashMap();
        params.put("isIndex", termId);
        params.put("subjectId", subjectId);
        params.put("gradeId", gradeId);
        params.put("materialId", materialId);
        String askURL = "/course/teacherMaterial";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页教师课程列表-JIAOXUE-SERVICE-API-22
    @Test
    public void getIndexCourses() throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String askURL = "/course/" + subjectId + "/" + gradeId + "/index-courses";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //新建课，浮层信息-JIAOXUE-SERVICE-API-33
    @Test
    public void createInfomations() throws Exception {
        String subjectId = "1";
        String gradeId = "1";
        String materialId = "1";
        String askURL = "/course/" + subjectId + "/" + gradeId + "/" + materialId + "/create-infos";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //新建课，推荐课程模糊搜索-JIAOXUE-SERVICE-API-36
    @Test
    public void recommendCourses() throws Exception {
        String subjectId = "2";
        String gradeId = "2";
        String materialId = "23434";
        String courseName = "2";
        Map params = new HashMap();
        params.put("courseName", courseName);
        String askURL = "/course/" + subjectId + "/" + gradeId + "/" + materialId + "/recommend-courses";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}