package Com.BaseUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestInfoTransformer implements IAnnotationTransformer{
	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		if(testMethod!=null && testMethod.isAnnotationPresent(TestInfo.class)) {
			
			List<String> tags = Arrays.asList(testMethod.getAnnotation(TestInfo.class).tags()).stream().map(tag -> tag.name()).collect(Collectors.toList());
			String tcId=testMethod.getAnnotation(TestInfo.class).Feature().toString();
			String feature =testMethod.getAnnotation(TestInfo.class).TCId().toString();
			
			System.out.println("***Processing method: " + testMethod.getName());
			ArrayList<String> groups=new ArrayList<String>();
			
			groups.addAll(tags);
			groups.add(feature);
			groups.add(tcId);
			
			 
	         annotation.setGroups(groups.toArray(new String[0]));
			 System.out.println("***Renamed method to: " + groups);
		}
	}
	
	

}
