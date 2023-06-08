package com.gufran.shadi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connectionJ.ConnectionProvider;
import com.gufran.shadi.dao.UserAccountDao;
import com.gufran.shadi.dao.UserAccountDaoImpl;
import com.gufran.shadi.dao.UserAccountDaoImplUpdateMethod;
import com.gufran.shadi.model.Interest;
import com.gufran.shadi.model.UserAccount;
	
public class UserAccountController {

	public static void main(String[] args) throws NumberFormatException, IOException {
		UserAccountController userAccountController = new UserAccountController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserAccount userAccount = new UserAccount();
		UserAccountDao userAccountDaoImpl = new UserAccountDaoImpl();
		Interest interest = new Interest();
		Map<Integer, UserAccount> user = new HashMap<>();
		List<UserAccount> seeAll = new ArrayList<>();
		UserAccountDaoImplUpdateMethod update = new UserAccountDaoImplUpdateMethod();
		while (true) {

			System.out.println("Enter 1 to register");
			System.out.println("Enter 2 to costum view user");
			System.out.println("Enter 3 to delete user");
			System.out.println("Enter 4 to find Your matches");
			System.out.println("Enter 5 to update all data");
			System.out.println("Enter 6 to Exit Application");
			byte a = Byte.parseByte(br.readLine());
			if (a == 1) {
				try {
					userAccountController.registerUser(br, userAccount, userAccountDaoImpl, interest, user, seeAll);
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			} else if (a == 2) {
				try {
					userAccountDaoImpl.seeAllUser(user, seeAll, userAccount, interest, br);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}

			else if (a == 3) {
				try {
					userAccountDaoImpl.delete(user, br,userAccount);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			else if(a==4) {
				try {
					userAccountDaoImpl.findMacthes(br,userAccount,interest);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} 
			}
			else if(a==5) {
				try {
					update.updateAllDataWithAllOption(br,userAccount,interest);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} 
			}
			else if (a == 6) {
				break;
			}
			else {
				System.out.println("System.out.println(\"Enter a only number are given above\");");
			}
		}
	}

	public void registerUser(BufferedReader br, UserAccount userAccount, UserAccountDao userAccountDaoImpl,
			Interest interest, Map<Integer, UserAccount> user, List<UserAccount> seeAll)
			throws NumberFormatException, IOException {

		System.out.println("ENTER YOUR ID:\t");
		userAccount.setId(Integer.parseInt(br.readLine()));
		System.out.println("ENTER YOUR AGE:\t");
		userAccount.setAge(Integer.parseInt(br.readLine()));
		System.out.println("ENTER YOUR CITY:\t");
		userAccount.setCity(br.readLine());
		System.out.println("ENTER YOUR USERNAME:\t");
		userAccount.setUserName(br.readLine());
		System.out.println("ENTER YOUR PASSWORD:\t");
		userAccount.setPassword(br.readLine());
		System.out.println("ENTER YOUR EMAIL:\t");
		userAccount.setEmail(br.readLine());
		System.out.println("ENTER YOUR GENDER:\t");
		userAccount.setGender(br.readLine());
		System.out.println("ENTER YOUR PHONE NUMBER:\t");
		userAccount.setPhoneNumber(Long.parseLong(br.readLine()));
		// userAccount.setInterest(interest);

		interest.setId(userAccount.getId());
		System.out.println("WRITE ABOUT WHAT DO YOU LIKE:\t");
		interest.setLike(br.readLine());
		System.out.println("WRITE ABOUT WHAT DO YOU DISLIKE:\t");
		interest.setDislike(br.readLine());
		System.out.println("WRITE WHAT YOUR HOBBIES:\t");
		interest.setHobbies(br.readLine());
		System.out.println("HOW DO YOU LOOK LIKE:\t");
		interest.setProfileUrl(br.readLine());
		System.out.println("WRITE ABOUT YOURSELF:\t");
		interest.setAbout(br.readLine());
		System.out.println(userAccount);
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("insert into shadidetail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");// userAccount.getId()+","+userAccount.getAge()+",'"+userAccount.getCity()+"','"+userAccount.getUserName()+"','"+
																										// userAccount.getPassword()+"','"+userAccount.getEmail()+"','"+userAccount.getGender()+"',"+userAccount.getPhoneNumber()+",'"+interest.getLike()+"','"+interest.getDislike()+"','"+interest.getProfileUrl()+"','"+interest.getAbout()+"','"+interest.getHobbies()+"','"+UserAccount.getCountry()+"')");
			
			stmt.setInt(1, userAccount.getId());
			stmt.setInt(2, userAccount.getAge());
			stmt.setString(3, userAccount.getCity());
			stmt.setString(4, userAccount.getUserName());
			stmt.setString(5, userAccount.getPassword());
			stmt.setString(6, userAccount.getEmail());
			stmt.setString(7, userAccount.getGender());
			stmt.setLong(8, userAccount.getPhoneNumber());
			stmt.setString(9, interest.getLike());
			stmt.setString(10, interest.getDislike());
			stmt.setString(11, interest.getProfileUrl());
			stmt.setString(12, interest.getAbout());
			stmt.setString(13, interest.getHobbies());
			stmt.setString(14, UserAccount.getCountry());

			int update = stmt.executeUpdate();
			if (update > 0) {
				System.out.println("All data inserted ");
			} else {
				System.out.println("someting went wrong");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}