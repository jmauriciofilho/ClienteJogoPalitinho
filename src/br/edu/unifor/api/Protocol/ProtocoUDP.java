package br.edu.unifor.api.Protocol;

import java.net.ServerSocket;
import java.net.Socket;

public class ProtocoUDP implements AbstractProtocol{

	@Override
	public boolean sendMensage(Socket clientAccept, String msg,
			String destinationIPAddress) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String reciverMensage(Socket client) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerSocket createGroup(Integer port) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Socket serverListener(ServerSocket server) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Socket joinGroup(String ip, Integer port) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
