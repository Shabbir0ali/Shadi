package com.gufran.shadi.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.connectionJ.ConnectionProvider;
import com.gufran.shadi.model.Interest;
import com.gufran.shadi.model.UserAccount;

public class UserAccountDaoImpl implements UserAccountDao {

	@Override
	public void save(UserAccount userAccount, Map<Integer, UserAccount> user) {
		user.put(userAccount.getId(), userAccount);
	}

	@Override
	public List<UserAccount> seeAllUser(Map<Integer, UserAccount> user, List<UserAccount> seeAll,
			UserAccount userAccount, Interest interest, BufferedReader br)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		seeAll.addAll(user.values());
		System.out.println(user);

		Connection con = ConnectionProvider.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM SHADIDETAIL");
		ResultSet set = stmt.executeQuery();
		System.out.println("Enter 1 to see basic data");
		System.out.println("Enter 2 to see full data");
		System.out.println("Enter 3 to want see your data only");
		byte b = Byte.parseByte(br.readLine());

		if (b == 1) {
			System.out.println("ALL APPLICATION USER DETAIL");
			while (set.next()) {
				userAccount.setId(set.getInt("id"));
				userAccount.setAge(set.getInt("AGE"));
				userAccount.setCity(set.getString("city"));
				userAccount.setUserName(set.getString("username"));
				userAccount.setEmail(set.getString("email"));
				userAccount.setGender(set.getString("gender"));
				userAccount.setPhoneNumber(set.getLong("phonenumber"));
				interest.setLike(set.getString("like11"));
				interest.setDislike(set.getString("dislike"));
				interest.setProfileUrl("looklike");
				interest.setAbout(set.getString("yourself"));
				interest.setHobbies(set.getString("hobbies"));

				System.err.println("Id :" + userAccount.getId() + "\t Age :" + userAccount.getAge() + "\t City :"
						+ userAccount.getCity() + "\t UserName :" + userAccount.getUserName() + "\t Email :"
						+ userAccount.getEmail() + "                \t Gender :" + userAccount.getGender()
						+ "            \t Phone Number :" + userAccount.getPhoneNumber());

			}
		} else if (b == 2) {
			System.out.println("ALL APPLICATION USER DETAIL");
			while (set.next()) {
				userAccount.setId(set.getInt("id"));
				userAccount.setAge(set.getInt("AGE"));
				userAccount.setCity(set.getString("city"));
				userAccount.setUserName(set.getString("username"));
				userAccount.setEmail(set.getString("email"));
				userAccount.setGender(set.getString("gender"));
				userAccount.setPhoneNumber(set.getLong("phonenumber"));
				interest.setLike(set.getString("like11"));
				interest.setDislike(set.getString("dislike"));
				interest.setProfileUrl("looklike");
				interest.setAbout(set.getString("yourself"));
				interest.setHobbies(set.getString("hobbies"));

				System.err.println("Id :" + userAccount.getId() + "\t Age :" + userAccount.getAge() + "\t City :"
						+ userAccount.getCity() + "\t UserName :" + userAccount.getUserName() + "\t Email :"
						+ userAccount.getEmail() + "                 \t Gender :" + userAccount.getGender()
						+ "       \t Phone Number :" + userAccount.getPhoneNumber() + "\t Like :" + interest.getLike()
						+ "           \t DisLike :" + interest.getDislike() + "           \t LookLike :"
						+ interest.getProfileUrl() + "        \t HimSelf :" + interest.getAbout()
						+ "            \t Hobbies :" + interest.getHobbies() + "           \t Country :"
						+ UserAccount.getCountry());

			}
		} else if (b == 3) {
			System.out.println("Enter your id you want see single data");
			int id = Integer.parseInt(br.readLine());
			PreparedStatement stm = con.prepareStatement("select * from shadidetail where id =" + id);
			ResultSet set2 = stm.executeQuery();
			while (set2.next()) {
				userAccount.setId(set2.getInt("id"));
				userAccount.setAge(set2.getInt("AGE"));
				userAccount.setCity(set2.getString("city"));
				userAccount.setUserName(set2.getString("username"));
				userAccount.setEmail(set2.getString("email"));
				userAccount.setGender(set2.getString("gender"));
				userAccount.setPhoneNumber(set2.getLong("phonenumber"));
				interest.setLike(set2.getString("like11"));
				interest.setDislike(set2.getString("dislike"));
				interest.setProfileUrl("looklike");
				interest.setAbout(set2.getString("yourself"));
				interest.setHobbies(set2.getString("hobbies"));

				System.err.println("Id :" + userAccount.getId() + "\t Age :" + userAccount.getAge() + "\t City :"
						+ userAccount.getCity() + "\t UserName :" + userAccount.getUserName() + "\t Email :"
						+ userAccount.getEmail() + "                 \t Gender :" + userAccount.getGender()
						+ "       \t Phone Number :" + userAccount.getPhoneNumber() + "\t Like :" + interest.getLike()
						+ "           \t DisLike :" + interest.getDislike() + "           \t LookLike :"
						+ interest.getProfileUrl() + "        \t HimSelf :" + interest.getAbout()
						+ "            \t Hobbies :" + interest.getHobbies() + "           \t Country :"
						+ UserAccount.getCountry());
			}
		} else {
			System.out.println("Enter a only number are given above");
		}

		return null;
	}

	@Override
	public void delete(Map<Integer, UserAccount> user, BufferedReader br, UserAccount userAccount)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("ENTER A ID YOU WANT TO DELETE:\t");
		userAccount.setId(Integer.parseInt(br.readLine()));
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement stmt = con.prepareStatement("delete from shadidetail where id=?");
		stmt.setInt(1, userAccount.getId());
		int update = stmt.executeUpdate();
		if (update > 0) {
			System.out.println("Deleted succesfully");
		} else {
			System.out.println("something went wrong");
		}
	}

	@Override
	public void findMacthes(BufferedReader br, UserAccount userAccount, Interest interest) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		System.out.println("Enter your Age:");
		userAccount.setAge(Integer.parseInt(br.readLine()));
		System.out.println("Enter your City:");
		userAccount.setCity(br.readLine());
		System.out.println("Enter a Gender:");
		userAccount.setGender(br.readLine());
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from shadidetail where age=? and city=? and gender=?");
		stmt.setInt(1, userAccount.getAge());
		stmt.setString(2, userAccount.getCity());
		stmt.setString(3, userAccount.getGender());
		ResultSet set = stmt.executeQuery();
		while (set.next()) {
			userAccount.setId(set.getInt("id"));
			userAccount.setAge(set.getInt("AGE"));
			userAccount.setCity(set.getString("city"));
			userAccount.setUserName(set.getString("username"));
			userAccount.setEmail(set.getString("email"));
			userAccount.setGender(set.getString("gender"));
			userAccount.setPhoneNumber(set.getLong("phonenumber"));
			interest.setLike(set.getString("like11"));
			interest.setDislike(set.getString("dislike"));
			interest.setProfileUrl("looklike");
			interest.setAbout(set.getString("yourself"));
			interest.setHobbies(set.getString("hobbies"));

			System.err.println("Id :" + userAccount.getId() + "\t Age :" + userAccount.getAge() + "\t City :"
					+ userAccount.getCity() + "\t UserName :" + userAccount.getUserName() + "\t Email :"
					+ userAccount.getEmail() + "                 \t Gender :" + userAccount.getGender()
					+ "       \t Phone Number :" + userAccount.getPhoneNumber() + "\t Like :" + interest.getLike()
					+ "           \t DisLike :" + interest.getDislike() + "           \t LookLike :"
					+ interest.getProfileUrl() + "        \t HimSelf :" + interest.getAbout()
					+ "            \t Hobbies :" + interest.getHobbies() + "           \t Country :"
					+ UserAccount.getCountry());

		}
		
	}
}