package com.qp.QP.Assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestQpAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.from(QpAssessmentApplication::main).with(TestQpAssessmentApplication.class).run(args);
	}

}
