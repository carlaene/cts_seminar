package ro.ase.csie.cts.dp.proxy.clase;

import java.util.HashMap;
import java.util.Map;

public class ProxyLogin implements InterfataLogin{
	InterfataLogin modulOficial;
	public static int MAXIMUM_INVERSIONS = 3;
	Map<String, Integer> clients = new HashMap<>();
	
	
	public ProxyLogin(InterfataLogin modulOficial) {
		super();
		this.modulOficial = modulOficial;
	}

	@Override
	public boolean accountAccess(String client, String pin) {
		Integer noOfInversions = clients.get(client);
		if(noOfInversions == null) {
			clients.put(client, 0);
			noOfInversions = 0;
		}
		
		if(noOfInversions >= MAXIMUM_INVERSIONS) {
			return false;
		}
		
		if(modulOficial.accountAccess(client, pin)) {
			clients.put(client, 0);
			return true;
		}
		else
		{
			noOfInversions += 1;
			clients.put(client, noOfInversions);
			if(noOfInversions == MAXIMUM_INVERSIONS) {
				System.out.println("Block account");
			}
			return false;
		}
		
	}

	@Override
	public boolean verifyStatus() {
		return modulOficial.verifyStatus(); 
	}
}
