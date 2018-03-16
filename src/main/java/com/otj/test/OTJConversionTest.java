package com.otj.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.otj.model.Address;
import com.otj.model.Employee;

public class OTJConversionTest {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Employee employee=createEmployee();
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(stringEmp, employee);
		System.out.println("Employee JSON is\n"+stringEmp);
		
	}

	private static Employee createEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ram");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Team Lead");

		Address add = new Address();
		add.setCity("Pune");
		add.setStreet("MK COLONY");
		add.setZipcode(560100);
		emp.setAddress(add);

		List cities = new ArrayList();
		cities.add("Delhi");
		cities.add("Hyderabad");
		emp.setCities(cities);

		Map props = new HashMap();
		props.put("salary", "1000 RS");
		props.put("age", "24 years");
		emp.setProperties(props);

		return emp;
		
	}

}
