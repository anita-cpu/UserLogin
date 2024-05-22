/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Login;

/**
 *
 * @author elelwanianitaravhuhali
 */
import javax.swing.*;

public class RegistrationSystemMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegistrationSystem gui = new RegistrationSystem();
                gui.createAndShowGUI();
            }
        });
    }
}
