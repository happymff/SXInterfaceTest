package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class TeacherMaterialSortC {

    //根据一组materialId获取教材排序-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllVersions(String baseCourseURL) throws Exception {
        String materialIds = "484011575";
        Map params = new HashMap();
        params.put("materialIds", materialIds);
        String askURL = "/teaching-material-sorts/material-lists";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}