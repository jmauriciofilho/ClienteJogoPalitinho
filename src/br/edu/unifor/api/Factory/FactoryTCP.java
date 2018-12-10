package br.edu.unifor.api.Factory;

import br.edu.unifor.api.Protocol.IClient;
import br.edu.unifor.api.Protocol.IServer;
import br.edu.unifor.api.Protocol.TCPClient;
import br.edu.unifor.api.Protocol.TCPServer;

import java.io.IOException;

public class FactoryTCP extends FactoryClass {
	@Override
	public IClient clientProtocol(String serverAddress, int serverPort) throws IOException {
		return new TCPClient(serverAddress, serverPort);
	}

	@Override
	public IServer serverProtocol(int port) throws IOException {
		return new TCPServer(port);
	}
}
