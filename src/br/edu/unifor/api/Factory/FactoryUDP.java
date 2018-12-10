package br.edu.unifor.api.Factory;

import br.edu.unifor.api.Protocol.IClient;
import br.edu.unifor.api.Protocol.IServer;
import br.edu.unifor.api.Protocol.UDPClient;
import br.edu.unifor.api.Protocol.UDPServer;

import java.io.IOException;

public class FactoryUDP extends FactoryClass {

	@Override
	public IClient clientProtocol(String serverAddress, int serverPort) throws IOException {
		return new UDPClient(serverAddress, serverPort);
	}

	@Override
	public IServer serverProtocol(int port) throws IOException {
		return new UDPServer(port);
	}
}
