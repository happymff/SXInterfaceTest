package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class TeacherC {

    //根据userRef获取教师-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getTeacher(String baseCourseURL) throws Exception {
        String userRef = "2d4acfe9-4c79-4c72-8166-982a9a6762cd";
        String askURL = "/teachers/"+userRef;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String teacherName = JsonResults.getJsonStr(str, "teacherName");
        Assert.assertTrue("卢跃跃".equals(teacherName));
    }

    //getTeacherInfo-JIAOXUE-SERVICE-API-?????????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllTeachers(String baseCourseURL) throws Exception {
        String userRef = "3";
        Map params = new HashMap();
        params.put("userRef",userRef);
        String askURL = "/teachers/user-refs";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}