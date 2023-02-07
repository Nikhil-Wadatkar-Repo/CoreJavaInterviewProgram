package com.ps.intru;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ps.functionalInterface.Employee;

public class Test08_SecondHighestSalary {

	public static void main(String[] args) {
		List<Employee> employees = Employee.getEmployees();

		Employee employee1 = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(employee1.getSalary());

		Double employee2 = employees.stream().reduce((a, b) -> {
			if (a.getSalary() > b.getSalary())
				return a;
			else
				return b;
		}).map(emp -> emp.getSalary()).get();
		System.out.println(employee2);

		List<Employee> list2 = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(list2.get(list2.size() - 1).getSalary());
	}
}
