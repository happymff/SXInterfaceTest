package dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class DataProvid {

    @DataProvider(name = "baseURL-General")
    public static Object[][] baseURLGeneral() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:9001"}
        };
    }

    @DataProvider(name = "baseURL-Course")
    public static Object[][] baseURLCourse() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:9002"}
        };
    }

    @DataProvider(name = "baseURL-Resource")
    public static Object[][] baseURLResource() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:9003"}
        };
    }


    @DataProvider(name = "baseURL-GeneralB")
    public static Object[][] baseURLGeneralB() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:8001"}
        };
    }

    @DataProvider(name = "baseURL-CourseB")
    public static Object[][] baseURLCourseB() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:8002"}
        };
    }

    @DataProvider(name = "baseURL-ResourceB")
    public static Object[][] baseURLResourceB() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:8003"}
        };
    }

    @DataProvider(name = "baseURL-PageB")
    public static Object[][] baseURLPageB() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:8005"}
        };
    }

    @DataProvider(name = "baseURL-B")
    public static Object[][] baseURLDiscussB() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:8004"}
        };
    }


    @DataProvider(name = "baseURL-GeneralC")
    public static Object[][] baseURLGeneralC() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:7001"}
        };
    }

    @DataProvider(name = "baseURL-CourseC")
    public static Object[][] baseURLCourseC() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:7002"}
        };
    }

    @DataProvider(name = "baseURL-ResourceC")
    public static Object[][] baseURLResourceC() {
        return new Object[][]{
                new Object[]{"http://192.168.11.187:7003"}
        };
    }

}
