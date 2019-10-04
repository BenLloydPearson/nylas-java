package com.nylas.examples;

import java.util.List;
import java.util.Properties;

import com.nylas.Account;
import com.nylas.AccountQuery;
import com.nylas.Accounts;
import com.nylas.Application;
import com.nylas.NylasClient;
import com.nylas.TokenInfo;

public class AccountsExample {

	public static void main(String[] args) throws Exception {
		Properties props = Examples.loadExampleProperties();
		NylasClient client = new NylasClient();
		Application application = client.application(props.getProperty("nylas.client.id"),
				props.getProperty("nylas.client.secret"));
		Accounts accounts = application.accounts();
		AccountQuery query = new AccountQuery()
				.limit(2)
				//.offset(10)
				;
		List<Account> accountList = accounts.list(query);
		for (Account account : accountList) {
			System.out.println(account);
		}
		
		Account first = accounts.get(accountList.get(0).getId());
		System.out.println("first: " + first);
		
		String accessToken = props.getProperty("access.token");
		TokenInfo tokenInfo = accounts.tokenInfo(first.getId(), accessToken);
		System.out.println("token info: " + tokenInfo);
		
		accounts.downgrade(first.getId());
		first = accounts.get(accountList.get(0).getId());
		System.out.println("after downgrade: " + first);
		
		accounts.upgrade(first.getId());
		first = accounts.get(accountList.get(0).getId());
		System.out.println("after upgrade: " + first);
		
		accounts.revokeAllTokensForAccount(first.getId(), "blahblah");
	}

}
