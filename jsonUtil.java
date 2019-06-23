package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonUtil {
  private static ObjectMapper objMapper=new ObjectMapper();
   public static String getJsonString(Object obj){
	   try {
		return objMapper.writeValueAsString(obj);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
		return null;
	}
   }
   
   public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
       return objMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
   }
   
   public static List getListObjects(String json,Class pojoClass){
	   JavaType type=getCollectionType(ArrayList.class, pojoClass);
	   try {
		return objMapper.readValue(json,type);
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
   }
}
