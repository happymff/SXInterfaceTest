package test;

import org.testng.Assert;
import util.HttpUtil;
import org.testng.annotations.Test;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class AdministerInfo {
    String baseGeneralURL = "http://192.168.11.197:30091";

    //根据用户ID 获取用户可以管理的班级信息-JIAOXUE-SERVICE-API-25
    @Test
    public void adminClass() throws Exception {
        String askURL = "/administer/class";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291045".equals(classId));
    }

    //根据用户的ID 获取用户的班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-26
    @Test
    public void adminClassSubject() throws Exception {
        String askURL = "/administer/class/subject";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291045".equals(classId));
    }

    //根据用户的ID 获取用户的年级、班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-26
    @Test
    public void adminGradeClassSubject() throws Exception {
        String askURL = "/administer/grade/class/subject";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291045".equals(classId));
    }

    //根据用户ID获取资源的年级班级列表-JIAOXUE-SERVICE-API-28
    @Test
    public void adminGradeSubject() throws Exception {
        String askURL = "/administer/grade/grade_subject";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "gradeName");
        Assert.assertTrue("高三".equals(classId));
    }

    //根据用户的ID 获取用户的年级和班级所包含的科目信息-JIAOXUE-SERVICE-API-28
    @Test
    public void adminSubject() throws Exception {
        String askURL = "/administer/grade/subject";
        String userHeader = "{\"enable\":1,\"password\":\"lu123456\",\"roles\":[2],\"schoolId\":50043,\"schoolUserId\":873135,\"schoolUserRef\":\"2d4acfe9-4c79-4c72-8166-982a9a6762cd\",\"userId\":8439370,\"userIdentity\":1,\"userName\":\"luyueyue\"}";
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "gradeName");
        Assert.assertTrue("高二".equals(classId));
    }
}