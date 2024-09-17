package Main;

import View.PrincipalViewSCESP;
import javax.swing.*;;

public class Main {
public static void main(String[]args){
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            PrincipalViewSCESP PVS = new PrincipalViewSCESP();
        PVS.setVisible(true);
        }

    });
    
}
}
