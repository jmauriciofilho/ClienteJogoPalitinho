package br.edu.unifor.api.Factory;

import br.edu.unifor.api.Model.TypeProtocol;
import br.edu.unifor.api.Protocol.AbstractProtocol;

public abstract class FactoryClass {

	public abstract AbstractProtocol connecProtocol();
	
	
	public static FactoryClass createFactory( final String tipo) throws Exception{
		if(tipo.equals(TypeProtocol.TCP)){
			return new FactoryTCP();
		}else if(tipo.equals(TypeProtocol.UDP)){
			return new FactoryUDP();
		}else{
			return null;
		}
	}
}
