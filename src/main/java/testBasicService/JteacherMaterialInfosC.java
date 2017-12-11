package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class JteacherMaterialInfosC {

    //根据用户Id 和当前学期的Id查询 用户年级科目指定的教材-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getJTeacherMaterials(String baseCourseURL) throws Exception {
        String userId = "873135";
        String termId= "1";
        String askURL = "/j-teacher-material-infos/user-id/"+userId+"/term-id/"+termId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonCode(str));
    }

    //根据用户Id 和当前学期的Id查询 用户年级科目指定的教材-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void updateJTeacherMaterials(String baseCourseURL) throws Exception {
        String userId = "873135";
        String subjectId = "1";
        String gradeId= "3";
        String materialId ="1";
        String termId ="1";
        Map params = new HashMap();
        params.put("subjectId",subjectId);
        params.put("userId",userId);
        params.put("gradeId",gradeId);
        params.put("materialId",materialId);
        params.put("termId",termId);
        String askURL = "/j-teacher-material-infos";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonCode(str));
    }

}