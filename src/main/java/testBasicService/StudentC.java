package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class StudentC {

    //根据userRef获取学生-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getStudent(String baseCourseURL) throws Exception {
        String userRef = "18ad05ae-434e-4ab4-998e-3efdfb981308";
        String askURL = "/students/"+userRef;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String stuName = JsonResults.getJsonStr(str, "stuName");
        Assert.assertTrue("AXPC10".equals(stuName));
    }

    //根据学生的stuIds 获取学生信息-JIAOXUE-SERVICE-API-?????????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllStudentByStuIds(String baseCourseURL) throws Exception {
        String stuIds = "3";
        Map params = new HashMap();
        params.put("stuIds",stuIds);
        String askURL = "/students/student-ids";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }

    //根据学生的userIds 获取学生信息-JIAOXUE-SERVICE-API-?????????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllStudentByUserID(String baseCourseURL) throws Exception {
        String userIds = "3";
        Map params = new HashMap();
        params.put("userIds",userIds);
        String askURL = "/students/user-ids";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }

    //根据学生的userIds 获取学生信息-JIAOXUE-SERVICE-API-?????????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void updateStudentPWD(String baseCourseURL) throws Exception {
        String userRef = "2d4acfe9-4c79-4c72-8166-982a9a6762cd";
        String askURL = "/students/passwords"+userRef;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.put(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}