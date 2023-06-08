package com.gufran.shadi.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectionJ.ConnectionProvider;
import com.gufran.shadi.model.Interest;
import com.gufran.shadi.model.UserAccount;

public class UserAccountDaoImplUpdateMethod {

	public void updateAllDataWithAllOption(BufferedReader br, UserAccount userAccount, Interest interest)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		Connection con = ConnectionProvider.getConnection();
		Statement stmt = con.createStatement();
		System.out.println("Enter Id you want to update");
		userAccount.setId(Integer.parseInt(br.readLine()));
		System.out.println("Ente 1 to update AGE :\t");
		System.out.println("Ente 2 to update CITY :\t");
		System.out.println("Ente 3 to update USER NAME:\t");
		System.out.println("Ente 4 to update PASSWORD :\t");
		System.out.println("Ente 5 to update EMAIL:\t");
		System.out.println("Ente 6 to update GENDER:\t");
		System.out.println("Ente 7 to update phonenumber:\t");
		System.out.println("Ente 8 to update your like:\t");
		System.out.println("Ente 9 to update your DISLIKE");
		System.out.println("Ente 10 to update your LOOKLIKE");
		System.out.println("Ente 11 to update your YOURSELF");
		System.out.println("Ente 12 to update your HOBBIES");
		int i = Integer.parseInt(br.readLine());
		switch (i) {
		case 1: {
			System.out.println("Enter new Age :\t");
			userAccount.setAge(Integer.parseInt(br.readLine()));
			stmt.executeUpdate(
					"update shadidetail set age=" + userAccount.getAge() + " where id = " + userAccount.getId());
		}
		break;
		case 2: {
			System.out.println("Enter new City :\t");
			userAccount.setCity(br.readLine());
			stmt.executeUpdate(
					"update shadidetail set city='" + userAccount.getCity() + "' where id = " + userAccount.getId());
		}
		break;
		case 3: {
			System.out.println("Enter new User Name :\t");
			userAccount.setUserName(br.readLine());
			stmt.executeUpdate("update shadidetail set username='" + userAccount.getUserName() + "' where id = "
					+ userAccount.getId());
		}
		break;
		case 4: {
			System.out.println("Enter new PASSWORD :\t");
			userAccount.setPassword(br.readLine());
			stmt.executeUpdate("update shadidetail set PASSWORD='" + userAccount.getPassword() + "'  where id = "
					+ userAccount.getId());
		}
		break;
		case 5: {
			System.out.println("Enter new EMAIL :\t");
			userAccount.setEmail(br.readLine());
			stmt.executeUpdate(
					"update shadidetail set EMAIL='" + userAccount.getEmail() + "'  where id = " + userAccount.getId());
		}
		break;
		case 6: {
			System.out.println("Enter new GENDER :\t");
			userAccount.setGender(br.readLine());
			stmt.executeUpdate(
					"update shadidetail set GENDER='" + userAccount.getGender() + "' where id = " + userAccount.getId());
		}
		break;
		case 7: {
			System.out.println("Enter new phonenumber :\t");
			userAccount.setPhoneNumber(Long.parseLong(br.readLine()));
			stmt.executeUpdate("update shadidetail set phonenumber=" + userAccount.getPhoneNumber() + " where id = "
					+ userAccount.getId());
		}
		break;
		case 8: {
			System.out.println("Enter whats your LIKE :\t");
			interest.setLike(br.readLine());
			stmt.executeUpdate("update shadidetail set like11='" + interest.getLike() + "' where id ="+ userAccount.getId());
		}
		break;
		case 9: {
			System.out.println("Enter whats your DISLIKE :\t");
			interest.setDislike(br.readLine());
			stmt.executeUpdate("update shadidetail set DISLIKE='" + interest.getDislike() + "' where id ="+ userAccount.getId());
		}
		break;
		case 10: {
			System.out.println("Enter whats your LOOKLIKE :\t");
			interest.setProfileUrl(br.readLine());
			stmt.executeUpdate("update shadidetail set LOOKLIKE='" + interest.getProfileUrl() + "' where id ="+ userAccount.getId());
		}
		break;
		case 11: {
			System.out.println("Enter whats your YOURSELF :\t");
			interest.setAbout(br.readLine());;
			stmt.executeUpdate("update shadidetail set YOURSELF='" + interest.getAbout()+ "' where id ="+ userAccount.getId());
		}
		break;
		case 12: {
			System.out.println("Enter whats your HOBBIES :\t");
			interest.setHobbies(br.readLine());;
			stmt.executeUpdate("update shadidetail set HOBBIES='" + interest.getHobbies()+ "' where id ="+ userAccount.getId());
		}
		break;
		default:{
			System.out.println("Enter only number given above");
		}
		}
	}
}
