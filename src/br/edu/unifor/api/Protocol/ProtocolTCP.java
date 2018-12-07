package br.edu.unifor.api.Protocol;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolTCP implements AbstractProtocol{
	
	

	@Override
	public boolean sendMensage(Socket clientAccept,String msg, String destinationIPAddress) throws Exception{
		ObjectOutputStream io = new ObjectOutputStream(clientAccept.getOutputStream());
			

			io.writeObject(msg);
			

		return false;
	}
	
	@Override
	public String reciverMensage(Socket client)throws Exception {
			ObjectInputStream io = new ObjectInputStream(client.getInputStream());
	    	
			String msg = (String)io.readObject();
		return msg;
	}

	
	@Override
	public ServerSocket createGroup(Integer port) throws Exception {
		//INICIANDO O SERVIDOR NA PORTA SELECIONADA
		ServerSocket server = new ServerSocket(port);
		
		System.out.println(":::-> SERVIDOR INICIADO "+server.getInetAddress().getHostAddress() + ":"+port);
		return server;
	}


	@Override
	public Socket serverListener(ServerSocket server) throws Exception {
		while(true){
			System.out.println(":::: -> LISTENER SERVER <- ::::");
			//VERIFICADA SE O SERVIDOR ACEITOU UMA CONEXAO
			Socket clientAccept =	server.accept();
			System.out.println("::--> CLINTE CONECTADO: "+ clientAccept.getInetAddress().getHostAddress());
		return clientAccept;
		}
	}


	@Override
	public Socket joinGroup(String ip, Integer port) throws Exception {
		Socket client = new Socket(ip,port);
		return client;
		
	}


	

}
