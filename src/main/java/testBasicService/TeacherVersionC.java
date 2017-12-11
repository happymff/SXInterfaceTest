package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class TeacherVersionC {

    ///teach-versions/all-lists-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllList(String baseCourseURL) throws Exception {
        String askURL = "/teach-versions/all-lists";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }

    //根据一组versionId获取版本信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllVersions(String baseCourseURL) throws Exception {
        String versionIds = "1";
        Map params = new HashMap();
        params.put("versionIds", versionIds);
        String askURL = "/teach-versions/version-lists";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}