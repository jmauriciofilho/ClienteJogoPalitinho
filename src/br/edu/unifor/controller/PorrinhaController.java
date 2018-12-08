package br.edu.unifor.controller;

import br.edu.unifor.api.Factory.FactoryClass;
import br.edu.unifor.api.Model.TypeProtocol;
import br.edu.unifor.view.PorrinhaGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

public class PorrinhaController {

    private static final String IP = "172.18.0.1";

    private PorrinhaGame porrinhaGame;
    private JTextField textField1;
    private JTextField textField2;
    private JButton apostarButton;
    private JButton colocarButton;
    private JLabel resultGame;
    private JLabel autorizeAposta;

    public PorrinhaController(){
        initComponents();
        initListener();
        initPessoa();
    }

    private void initPessoa() {
        send("novo;"+IP);
    }

    public void showWindow(){
        porrinhaGame.setVisible(true);
    }

    private void initComponents(){
        porrinhaGame = new PorrinhaGame();

        textField1 = porrinhaGame.getTextField1();
        textField2 = porrinhaGame.getTextField2();

        apostarButton = porrinhaGame.getApostarButton();
        colocarButton = porrinhaGame.getColocarButton();

        resultGame = porrinhaGame.getResultGame();
        autorizeAposta = porrinhaGame.getAutorizeAposta();
    }

    private void initListener() {

        colocarButton.addActionListener(new ColocarBtnListener());
        apostarButton.addActionListener(new ApostarBtnListener());

    }

    private class ColocarBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String text = textField1.getText();

            send("qtd;"+IP+";"+text);
        }
    }

    private class ApostarBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String text = textField2.getText();

            send("palpite;"+IP+";"+text);

        }
    }

    private void send(String text)
    {
        try {

            ServerSocket server = FactoryClass.createFactory(TypeProtocol.TCP).connecProtocol().createGroup(1024);

            Socket socket = FactoryClass.createFactory(TypeProtocol.TCP).connecProtocol().serverListener(server);

            FactoryClass.createFactory(TypeProtocol.TCP).connecProtocol().sendMensage(socket, text, "172.18.0.1");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
