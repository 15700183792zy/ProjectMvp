package www.zhouyan.project.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhouyan json解析到javabean
 */
public class ToolGson {

    /**
     * @param result
     * @return t 解析json到bean
     */
    public static <T> T jsonToBean(String result, Class<T> clazz) {
        Gson gson = new Gson();
        T t=null;
        try {
            t = gson.fromJson(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 对象转换成json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * 转成list
     * 解决泛型问题
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static  <T> ArrayList<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        ArrayList<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }


    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        Gson gson = new Gson();
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Gson gson = new Gson();
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

//
//	/**
//	 * @param result
//	 * @return t 解析json到bean
//	 */
//	public static <T> T jsonToBeanFast(String result, Class<T> clazz) {
//		return JSON.parseObject(result, clazz);
//	}
//
//    /**
//     * 对象转换成json字符串
//     * @param obj
//     * @return
//     */
//    public static String toJsonFast(Object obj) {
//    	return JSON.toJSONString(obj);
//    }

}