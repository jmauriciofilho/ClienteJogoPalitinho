package br.edu.unifor.api.Factory;

import br.edu.unifor.api.Protocol.AbstractProtocol;
import br.edu.unifor.api.Protocol.ProtocolTCP;

public class FactoryTCP extends FactoryClass {

	@Override
	public AbstractProtocol connecProtocol() {
		return new ProtocolTCP();
	}

}
