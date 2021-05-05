package ro.ase.csie.cts.dp.proxy.clase;

public class ModulLogin implements InterfataLogin {
String ipServer;
	
	public ModulLogin(String ipServer) {
		super();
		this.ipServer = ipServer;
	}

	@Override
	public boolean accountAccess(String user, String pin) {
		if(user.equals("admin") && pin.equals("1234"))
			return true;
		else
			return false;
	}

	@Override
	public boolean verifyStatus() {
		return true;
	}
}
