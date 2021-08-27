
 package com.suft.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Fetch Bank account balances")
class BankTest {
	
	private final Bank bank = new Bank();
	
	@Test
	@DisplayName("No Account number given")
	void testWithEmptyAccountNumber() {
		assertEquals("", bank.fetchBalance(""));
	}
	
	@Test
	@DisplayName("Account number given is 1234567")
	void testWithValidAccountNumber() {
		assertEquals("389.67", bank.fetchBalance("1234567"));
	}
}
