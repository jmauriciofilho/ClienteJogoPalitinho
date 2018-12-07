package br.edu.unifor.api.Protocol;

import java.net.ServerSocket;
import java.net.Socket;

public interface AbstractProtocol {

	public boolean sendMensage(Socket clientAccept, String msg, String destinationIPAddress) throws Exception;
	
	public String reciverMensage(Socket client) throws Exception;

	
	public ServerSocket createGroup(Integer port) throws Exception;
	
	public Socket serverListener(ServerSocket server) throws Exception;
	
	public Socket joinGroup(String ip, Integer port) throws Exception;
}
