package br.edu.unifor.controller;

import br.edu.unifor.api.Factory.FactoryClass;
import br.edu.unifor.api.Model.TypeProtocol;
import br.edu.unifor.view.PorrinhaGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class PorrinhaController {

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

            send(text);
        }
    }

    private class ApostarBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String text = textField2.getText();

            send(text);

        }
    }

    private void send(String text)
    {
        try {

            Socket client = FactoryClass.createFactory(TypeProtocol.TCP).connecProtocol().joinGroup("172.18.0.1", 1024);

            FactoryClass.createFactory(TypeProtocol.TCP).connecProtocol().sendMensage(client, text, "172.18.0.1");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
