package com.clientaddressmapping.app;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clientaddressmapping.app.entity.cayenne.Department;

//@SpringBootApplication
public class ClientAddressApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ClientAddressApplication.class, args);

		crudOperationCaynne();
	}

	private static void crudOperationCaynne() {
		ServerRuntime cayenneRuntime = ServerRuntime.builder()
				.addConfig("cayenne-project.xml")
				.build();
		ObjectContext context = cayenneRuntime.newContext();

		performDbOperations(context);
	}

	private static void performDbOperations(ObjectContext context) {
		var tech = context.newObject(Department.class);
		tech.setDepName("Technology");

		var hr = context.newObject(Department.class);
		hr.setDepName("Human Resource");

		var accounts = context.newObject(Department.class);
		accounts.setDepName("Accounts");

		context.commitChanges();
	}

}
