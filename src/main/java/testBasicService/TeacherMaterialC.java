package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class TeacherMaterialC {

    //查找一组gradeId和subjectId获取教材信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getMaterials(String baseCourseURL) throws Exception {
        String gradeIds = "1";
        String subjectId = "1";
        Map params = new HashMap();
        params.put("gradeIds", gradeIds);
        params.put("subjectId",subjectId);
        String askURL = "/teaching-materials/material-lists";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }

    //根据年级Id、学科Id、教材Id获取教材信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllVersions(String baseCourseURL) throws Exception {
        String gradeId = "3";
        String subjectId = "1";
        String materialId = "484011575";
        Map params = new HashMap();
        params.put("gradeId", gradeId);
        params.put("subjectId",subjectId);
        params.put("materialId",materialId);
        String askURL = "/teaching-materials/materials";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}