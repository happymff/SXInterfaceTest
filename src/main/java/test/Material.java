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


public class Material {

    //获取教材列表-JIAOXUE-SERVICE-API-34
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getMaterials(String baseCourseURL) throws Exception {
        Integer subjectId = 1;
        Integer gradeId = 1;
        Integer isIndex = 1;
        Map params = new HashMap();
        params.put("isIndex", isIndex);
        params.put("sId", subjectId);
        params.put("gId", gradeId);
        String askURL = "/materials/material-lists";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //保存教师选择的教材-JIAOXUE-SERVICE-API-47
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void updateMaterials(String baseCourseURL) throws Exception {
        Integer subjectId = 1;
        Integer gradeId = 1;
        Long mId = 143256L;
        String termId = "1";
        Map params = new HashMap();
        params.put("mId", mId);
        params.put("sId", subjectId);
        params.put("gId", gradeId);
        params.put("termId",termId);
        String askURL = "/materials/teacher-materials";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}