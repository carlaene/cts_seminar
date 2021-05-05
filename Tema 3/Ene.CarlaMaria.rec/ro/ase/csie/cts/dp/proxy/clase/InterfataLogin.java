package ro.ase.csie.cts.dp.proxy.clase;

public interface InterfataLogin {
	public boolean accountAccess(String clientName, String pin);
	public boolean verifyStatus();
}
