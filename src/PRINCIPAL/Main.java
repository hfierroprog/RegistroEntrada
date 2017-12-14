package PRINCIPAL;

import VISTAS.LOGIN;

public class Main {
    public static void main(String[] args){
        LOGIN log = new LOGIN();
        
        log.setVisible(true);
        log.setTitle("Login");
        log.setLocationRelativeTo(null);
        log.setResizable(false);
        
        System.out.println("SESION INICIADA");
        
    }
}
