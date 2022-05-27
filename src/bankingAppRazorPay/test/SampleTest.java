package bankingAppRazorPay.test;

import static org.junit.Assert.*;

import java.util.List;

import bankingAppRazorPay.src.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SampleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorsAndGetters() {
		
		HeadOffice headOffice = new HeadOffice();
		Branch branch = headOffice.createBranch();
		try {
			assertEquals(headOffice.getBranchById(branch.getId()),branch);
		} catch (Exception e) {
			fail();
		}
		String panNumber = "TESTPAN123123";
		String type1 = "Current";
		String type2 = "Saving";
		double balanceInvalid = 500.0;
		double balanceValid =  25000.0;
		BankAccount currentAccount = null;
		BankAccount savingAccount = null;
		try {
			currentAccount = branch.createBankAccount(panNumber, type1, balanceValid);
			savingAccount = branch.createBankAccount(panNumber, type2, balanceValid);
		} catch(Exception e) {
			fail();
		}
		
		assertEquals(currentAccount.getType(), type1);
		assertEquals(savingAccount.getType(), type2);
		
		assertEquals(currentAccount.getMinimumBalance(), 20000.0, 1e-6);
		assertEquals(savingAccount.getMinimumBalance(), 10000.0, 1e-6);
		
		assertEquals(currentAccount.getCurrentBalance(), balanceValid, 1e-6);
		assertEquals(savingAccount.getCurrentBalance(), balanceValid, 1e-6);
		
		
		try{
			branch.createBankAccount(panNumber, type1, balanceInvalid);
			fail();
		} catch(Exception e) {
			//
		}
		try {
			branch.createBankAccount(panNumber, type2, balanceInvalid);
			fail();
		} catch(Exception e) {
			//
		}
		try {
			assertEquals(headOffice.getBranchById(branch.getId()),branch);
		} catch(Exception e) {
			fail();
		}
		
		assertEquals(headOffice.getAllBranches().get(0),branch);
		assertEquals(headOffice.getAllBranches().size(),1);
		Customer customer = null;
		
		try {
			customer = branch.getCustomerByPan(panNumber);
		} catch(Exception e){
			fail();
		}
		
		assertEquals(customer.getPanNumber(),panNumber);
		
		List<BankAccount> bankAccount = customer.getBankAccounts();
		
		assertEquals(bankAccount.size(), 2);
		
		BankAccount firstAccount = bankAccount.get(0);
		BankAccount secondAccount = bankAccount.get(1);
		
		//System.out.println(firstAccount.getType());
		//System.out.println(secondAccount.getType());
		
		
		assertTrue( (firstAccount.getType().equals(type1) && secondAccount.getType().equals(type2))  || (firstAccount.getType().equals(type2) && secondAccount.getType().equals(type1))  );
		
		try {
			assertEquals(branch.getAccountByAccountNumber(firstAccount.getAccountNumber()),firstAccount);
			assertEquals(branch.getAccountByAccountNumber(secondAccount.getAccountNumber()), secondAccount);
		} catch(Exception e) {
			fail();
		}
	}

}
