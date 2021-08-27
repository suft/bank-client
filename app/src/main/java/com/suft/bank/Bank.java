/**
 * 
 */
package com.suft.bank;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

/**
 * A Web Service Client for a Bank
 * 
 * @author Sufien Tout
 * @version 1.0
 *
 */
public class Bank {

	private class BankAccount {
		@SuppressWarnings("unused")
		public String accountNumber;
		public String balance;
		@SuppressWarnings("unused")
		public String email;
		@SuppressWarnings("unused")
		public String phoneNumber;

	}
	
	/**
	 * The Base URL for the REST Web Service
	 */
	private static final String BASE_API_URL = "http://localhost:8080";
	
	/**
	 * A successful HTTP response status
	 */
	private static final int STATUS_SUCCESS = 200;
	
	
	/**
	 * Fetches the balance of a given account from the bank rest api
	 * 
	 * @param accountNumber the number associated with a bank account
	 * @return the balance of an account
	 */
	public String fetchBalance(String accountNumber) {
		HttpClient client = HttpClient.newHttpClient();
		
		// Build the query string
		StringBuilder builder = new StringBuilder("/balance?acctnum=");
		String query = builder.append(accountNumber).toString();
		
		// Build a GET request
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(BASE_API_URL).resolve(query))
				.build();
		
		try {
			// Send a synchronous request
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			if (response.statusCode() == STATUS_SUCCESS) {
				Gson gson = new Gson();

				// Deserialize the JSON response as a BankAccount instance
				BankAccount account = gson.fromJson(response.body(), BankAccount.class);
				return account.balance;
			}
		} catch (IOException | InterruptedException e) {
			// An I/O error occurs when sending or receiving
		    // Or the operation is interrupted
			e.printStackTrace();
		}

		// Status code other than 200 return empty string
		return "";
	}
	
}
