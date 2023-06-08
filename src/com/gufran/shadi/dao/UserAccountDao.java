package com.gufran.shadi.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gufran.shadi.model.Interest;
import com.gufran.shadi.model.UserAccount;

public interface UserAccountDao {

	public void save(UserAccount userAccount, Map<Integer, UserAccount> user);
	public List<UserAccount> seeAllUser(Map<Integer, UserAccount> user, List<UserAccount> seeAll, UserAccount userAccount, Interest interest, BufferedReader br) throws ClassNotFoundException, SQLException, NumberFormatException, IOException;
	void delete(Map<Integer, UserAccount> user, BufferedReader br, UserAccount userAccount) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
	public void findMacthes(BufferedReader br, UserAccount userAccount, Interest interest) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
}