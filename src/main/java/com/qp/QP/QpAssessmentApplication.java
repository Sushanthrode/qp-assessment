package com.qp.QP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
@Author Sushanth Rode
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.qp.QP")
public class QpAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(QpAssessmentApplication.class, args);
	}

}
