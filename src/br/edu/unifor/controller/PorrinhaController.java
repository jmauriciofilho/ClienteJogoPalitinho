package br.edu.unifor.controller;

import br.edu.unifor.view.PorrinhaGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PorrinhaController {

    private PorrinhaGame porrinhaGame;
    private JTextField textField1;
    private JTextField textField2;
    private JButton apostarButton;
    private JButton colocarButton;

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
    }

    private void initListener() {

        apostarButton.addActionListener(new ApostarBtnListener());

    }

    private class ApostarBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            textField1.setText("Teste de certo");
        }
    }

}
