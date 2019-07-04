package com.rs.selenium.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.rs.selenium.analyzer.RetryAnalyzer;

public class CustomAnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
