package com.classroom.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

public class BeanUtil extends BeanUtils {
	static public void copyProperties(Object source, Object target) {
		if(source == null || target == null) {
			return;
		}
		
		try {
			PropertyUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	static public void copyProperties(Object source, Object target, String... availableProperties) {
		try {
			for (String string : availableProperties) {
				PropertyUtils.setProperty(target, string, getProperty(source, string));
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取bean.propertyName的值
	 * @param bean
	 * @param propertyName
	 * @return
	 */
	static public Object getProperty(Object bean, String propertyName) {
		try {
			return PropertyUtils.getProperty(bean, propertyName);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
