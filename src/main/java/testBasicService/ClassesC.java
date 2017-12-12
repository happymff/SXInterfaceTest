package testBasicService;

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


public class ClassesC {

    //根据classId和schoolYear获取班级的信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getClassByClassIDSchoolID(String baseCourseURL) throws Exception {
        String classId = "1291044";
        String schoolYear = "2017~2018";
        String askURL = "/classes/"+classId+"/years/"+schoolYear+"/class";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String pattern = JsonResults.getJsonStr(str,"pattern");
        Assert.assertTrue("行政班".equals(pattern));
    }

    //根据classId获取班级信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getClassByClassID(String baseCourseURL) throws Exception {
        String classId = "1291044";
        String askURL = "/classes/"+classId+"/class";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classGrade = JsonResults.getJsonStr(str,"classGrade");
        Assert.assertTrue("高三".equals(classGrade));
    }

    //根据一组classId获取班级信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getClassByClassIDs(String baseCourseURL) throws Exception {
        String classId = "1291044";
        String askURL = "/classes/"+classId+"/classes";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classGrade = JsonResults.getJsonStrInArray(str,"classGrade",0);
        Assert.assertTrue("高三".equals(classGrade));
    }

    //根据学校Id 和 学年 获取班级的信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getClassBYearSchoolID(String baseCourseURL) throws Exception {
        String classIds = "1291044";
        String year = "2017~2018";
        String askURL = "/classes/"+classIds+"/years/"+year+"/classes";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String classGrade = JsonResults.getJsonStrInArray(str,"classGrade",0);
        Assert.assertTrue("高三".equals(classGrade));
    }


    //根据一组classId获取班级信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getClassBySchoolID(String baseCourseURL) throws Exception {
        String schoolId = "50043";
        String year = "2017~2018";
        String askURL = "/classes/schools/"+schoolId+"/years/"+year+"/classes";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(str.contains("高三"));
    }

    //根据班级人员信息获取班级列表-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getAllClasses(String baseCourseURL) throws Exception {
        String paramJson = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",2);
        System.out.println(paramJson);
        List classList =new ArrayList();
        classList.add(paramJson);
        Long courseId = 1000030744L;
        String courseName = "test add course1";
        String courseRemark = "test";
        Integer gradeId = 1;
        Long materialId = 484011575L;
        Long moduleId = null;
        Integer subjectId = 1;
        String termId = "d154e782-0922-11e7-9395-2fc6565cc9de";
        Map params = new HashMap();
        params.put("classList", classList);
        params.put("courseId", courseId);
        params.put("courseName", courseName);
        params.put("courseRemark", courseRemark);
        params.put("gradeId", gradeId);
        params.put("materialId", materialId);
        params.put("moduleId", moduleId);
        params.put("subjectId", subjectId);
        params.put("termId", termId);
        System.out.println(params);
        String askURL = "/classes/teachers/classes";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        try {
            Integer code = JsonResults.getJsonCode(str);
            Assert.assertTrue(code==1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}