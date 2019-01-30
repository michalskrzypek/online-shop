package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;

public interface AddressDAO {

	//Addresses management
	public boolean addAddress(Address address);
	
	public Address getBillingAddress(Account account);
	public Address getBillingAddress(int accountId);
	
	public Address getAddress(int addressId);
	
	public boolean updateAddress(Address address);
	
	public boolean deleteAddress(Address address);
	
//	public List<Address> getShippingAddresses(Account account);
	public List<Address> getShippingAddresses(int accountId);
	
}
