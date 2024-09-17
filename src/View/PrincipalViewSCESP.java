package View;
import javax.swing.*;

import VO.UsuarioVo;

import java.awt.*;
import java.util.*;

public class PrincipalViewSCESP extends JFrame{

    ArrayList<UsuarioVo> users = new ArrayList<>();

    GridBagLayout Layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    CardLayout cardLayout = new CardLayout();
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int heigth = (int) screensize.getHeight() - 100;
    int widith = (int) screensize.getWidth() ;

    public PrincipalViewSCESP(){
        setTitle("SCESP");
        setSize(widith,heigth);
        setLocationRelativeTo(null);
        setLayout(Layout);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);

        container.add( new CadastrarPessoa(users),"CadPessoas");
        
        cardLayout.show(container,"CadPessoas");


        //config do container
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = MAXIMIZED_VERT;
        gbc.fill = GridBagConstraints.BOTH;

        add(container,gbc);
        
        JPanel container2 = new JPanel();
        container2.setLayout(new GridLayout(5,1));
        JButton btn1 = new JButton("Cadastrar Pessoa");
        container2.add(btn1);
        JButton btn2 = new JButton("botao2");
        container2.add(btn2);
        JButton btn3 = new JButton("botao3");
        container2.add(btn3);
        JButton btn4 = new JButton("botao4");
        container2.add(btn4);
        JButton btn5 = new JButton("botao5");
        container2.add(btn5);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = MAXIMIZED_VERT;
        gbc.fill = GridBagConstraints.BOTH;

        add(container2,gbc);
        

    }

}
