package testBusiness;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class AdministerInfoB {

    //根据用户的ID 获取用户的班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAdminClassSubjectsByUserID(String baseGeneralURL) throws Exception {
        String userId ="935751";
        String askURL = "/administers/classes-subjects/users/"+userId;
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291054".equals(classId));
    }

    //根据用户ID 获取用户可以管理的班级信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAdminClassByUserID(String baseGeneralURL) throws Exception {
        String userId ="935751";
        String askURL = "/administers/classes/users/"+userId;
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291054".equals(classId));
    }

    //根据用户的ID 获取用户的年级、班级和班级所包含的科目信息-JIAOXUE-SERVICE-API-???????
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAdminGradeClassSubjectsByUserID(String baseGeneralURL) throws Exception {
        String userId ="935751";
        String askURL = "/administers/grades-classes-subjects/users/"+userId;
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291054".equals(classId));
    }

    //根据用户ID获取资源的年级科目列表-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAdminGradeSubjectsByUserID(String baseGeneralURL) throws Exception {
        String userId ="935751";
        String askURL = "/administers/grades-subjects/users/"+userId;
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291054".equals(classId));
    }

    //根据用户的ID 获取用户的年级和班级所包含的科目信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAdminClassSubjectsByUserIDExtend(String baseGeneralURL) throws Exception {
        Boolean needExtend =true;
        String userId ="935751";
        String askURL = "/administers/grades-subjects/users/"+userId+"/extend/"+needExtend;
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classId = JsonResults.getJsonDataInArray(str, "data", "classId");
        Assert.assertTrue("1291054".equals(classId));
    }

    //获取当前的学年信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getTerms(String baseGeneralURL) throws Exception {
        String askURL = "/administers/terms";
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(1==code);
    }
}