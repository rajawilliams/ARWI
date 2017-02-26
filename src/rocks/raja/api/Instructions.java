package rocks.raja.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import rocks.raja.arwi.app.ARWI;

public class Instructions {

	public java.util.List<Method> instructions = new java.util.ArrayList<Method>();
	public java.util.Hashtable<String, Boolean> values = new java.util.Hashtable<String, Boolean>();
	
	public void invoke() {
		for (Method method : instructions) {
			try {
				method.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Instructions(Class<?> clazz, ARWI arwi) {
		for (Method method : clazz.getMethods()) {
			instructions.add(method);
		}
		for (Field object : clazz.getFields()) {
			try {
				if (object.getType() == boolean.class) {
					values.put(object.getName(), (boolean)object.get(arwi));
					System.out.println(object.getName() + " " + (boolean)object.get(arwi));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Instructions() {
	}
}
