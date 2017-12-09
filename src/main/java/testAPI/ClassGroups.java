package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class ClassGroups {

    //据班级的ID获取班级的所有老师信息-JIAOXUE-SERVICE-API-38
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getTeachers(String baseGeneralURL ) throws Exception {
        String classId = "1291044";
        String askURL = "/classes/teachers/class-ids/"+classId;
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //学生重置密码的时候获取用户的信息-JIAOXUE-SERVICE-API-40
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getUserInfoRepPWD(String baseGeneralURL ) throws Exception {
        String studentId = "790252";
        String askURL = "/classes/students/"+studentId;
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //获取班级分组详情-JIAOXUE-SERVICE-API-41
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getMaterialList(String baseGeneralURL ) throws Exception {
        String classId = "1291044";
        String yearTerm = "2017~2018";
        String subjectId = "1";
        String askURL = "/classes/groups/class-ids/"+classId+"/years/"+yearTerm+"/subject-ids/"+subjectId;
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //更新班组的信息-JIAOXUE-SERVICE-API-44
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void changeGroup(String baseGeneralURL ) throws Exception {
        Long groupId = 3623600558639L;
        String groupName = "变成我的班级";
        String askURL = "/classes/groups";
        Map params = new HashMap();
        params.put("groupId", "-"+groupId);
        params.put("groupName", groupName);
        System.out.println(params);
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //更新班组的信息-JIAOXUE-SERVICE-API-44????????????
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void changeGroupPost(String baseGeneralURL ) throws Exception {
        String groupId = "-3623600558639";
        String groupName = "变成我的班级";
        String askURL = "/classes/groups";
        Map params = new HashMap();
        params.put("groupId", groupId);
        params.put("groupName", groupName);
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
    //改变学生所属的分组-JIAOXUE-SERVICE-API-46
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void changeStudentGroup(String baseGeneralURL ) throws Exception {
        String oldGroupId = "1";
        String newGroupId = "2";
        String[] studentIds=null;
        String classId="45435";
        String askURL = "/classes/groups/students";
        Map params = new HashMap();
        params.put("oldGroupId", oldGroupId);
        params.put("newGroupId", newGroupId);
        params.put("studentIds", studentIds);
        params.put("classId", classId);
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseGeneralURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}