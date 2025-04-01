package com.Info.services;

import java.sql.*;

import com.Info.Dao.DeleteOperation;
import com.Info.Dao.ReadOperation;
import com.Info.Dao.UpdateOperation;
import com.Info.Dao.CreateOperation;
import com.Info.Dao.Database;
public class Menu {
	public static void showDeleteOptions() throws SQLException {

		System.out.println();
		while (true) {

			System.out.println("Choose one of these options:");
			System.out.println("1. Drop table");
			System.out.println("2. Truncate table");
			System.out.println("3. Drop column");
			System.out.println("4. Delete row ");
			System.out.println("5. Exit");

			int result;
			System.out.println();

			try {
				result = Input.getDecision();

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 5.");
				continue;
			}

			if (result < 1 || result > 5) {
				System.out.println("Oops... wrong option. Please choose between 1 to 5.");
				continue;
			}
			switch (result) {
			case 1 -> DeleteOperation.delete().dropTable();
			case 2 -> DeleteOperation.delete().truncateTable();
			case 3 -> DeleteOperation.delete().dropColumn();
			case 4 -> DeleteOperation.delete().deleteRow();
			case 5 -> showTableOperationOptions();

			}
		}
	}

	public static void showTableOperationOptions() throws SQLException {
		System.out.println();

		while (true) {

			System.out.println("Choose one of these options:");
			System.out.println("1. Print table");
			System.out.println("2. Insert data");
			System.out.println("3. Delete Operation");
			System.out.println("4. Change database");
			System.out.println("5. Main Menu");
			System.out.println("6. Exit");
			int result;
			System.out.println();

			try {
				result = Input.getDecision();

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 6.");
				continue;
			}

			if (result < 1 || result > 6) {
				System.out.println("Oops... wrong option. Please choose between 1 to 6.");
				continue;
			}
			switch (result) {

			case 1 -> {
				ResultSet rs = ReadOperation.Read().getAllDetail(Database.database().getTableName());
				Print.print().printTable(rs);
			}
			case 2 -> {
				boolean flag ;
				do{
					flag= UpdateOperation.update().insertData(Database.database().getConnection(),Database.database().getTableName());
				}while(!flag);
			}
			case 3 -> showDeleteOptions();
			case 4 -> {

				showChooseDatabaseOption();

				System.out.println("Database changed successfully");
			}
			case 5 -> showMainOptions();
			case 6 -> {
				System.out.println("Exiting the options menu.");
		        System.exit(0);
			}
			default -> System.out.println("Wrong option");
			}
		}
	}
	public static void showTablesOption() {
		try {
			 Print.print().printTable(Database.database().getTables());
			 System.out.println("Enter the table Name : ");
			 String tableName = Input.getEntrie();
			 if(Database.database().selectTable(tableName)) {
				System.out.println(tableName + " selected");
				showTableOperationOptions();
			 }else {
				showTablesOption();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}

	}
    public static void showChooseDatabaseOption() throws SQLException {
       Print.print().printTable(Database.database().getDatabases());	
       System.out.println("choose one of these databases");
       String databaseName = Input.getEntrie();
      if( Database.database().selectDatabase(databaseName)) {
    	  System.out.println(databaseName + " Selected ");
    	  showMainOptions();
      }else {
    	  showChooseDatabaseOption();
      }
    }
    
	public static void showMainOptions() throws SQLException {
		System.out.println();
		try {
			while (true) {

				System.out.println("Choose one of these options:");
				System.out.println("1. Create table");
				System.out.println("2. select table");
				System.out.println("3. Change database");
				System.out.println("4. exit");
				int result;
				System.out.println();

				try {
					result = Input.getDecision();
					System.out.println(result);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number between 1 and 4.");
					continue;
				}

				if (result < 1 || result > 4) {
					System.err.println("Invalid input. Please enter a number between 1 and 4.");
					continue;
				}
				
				switch (result) {

				case 1 -> {
					System.out.println("1. createTablewithFixedfield");
					System.out.println("2. createTablewithQuery");
					result = Input.getDecision();
					boolean flag;
					if(result==1) {
						flag = CreateOperation.create().createTablewithFixedfield();
						
					}else {
						flag = CreateOperation.create().createTablewithQuery(); 
					}
				}
				case 2 ->{
					showTablesOption();
				
				}

				case 3 -> {
					showChooseDatabaseOption();
					System.out.println("Database changed successfully");
				}
				case 4 -> {
					System.out.println("Exiting the options menu.");
					return;
				}
				default -> System.out.println("Wrong option");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
	      	e.printStackTrace();
			showMainOptions();
		}
	}
}