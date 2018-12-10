package br.edu.unifor.api.Protocol;

import br.edu.unifor.api.Model.Message;

import java.io.IOException;

public interface IServer {
    void sendMessage(Message message) throws IOException;
    Message receiveMessage() throws IOException, ClassNotFoundException;
}
