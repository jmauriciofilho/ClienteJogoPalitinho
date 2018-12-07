package br.edu.unifor.api.Factory;

import br.edu.unifor.api.Protocol.AbstractProtocol;
import br.edu.unifor.api.Protocol.ProtocoUDP;

public class FactoryUDP extends FactoryClass {

	@Override
	public AbstractProtocol connecProtocol() {
		return new ProtocoUDP();
	}

}
