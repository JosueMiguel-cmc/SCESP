package View;
import javax.swing.*;

import VO.UsuarioVo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PrincipalViewSCESP extends JFrame{

    private ArrayList<UsuarioVo> users;

    GridBagLayout Layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    CardLayout cardLayout = new CardLayout();
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int heigth = (int) screensize.getHeight() - 100;
    int widith = (int) screensize.getWidth() ;

        

    public ArrayList<UsuarioVo> getUsers() {
        return users;
    }



    public void setUsers(ArrayList<UsuarioVo> users) {
        this.users = users;
    }



    public PrincipalViewSCESP(){
        users = new ArrayList<>();
        setTitle("SCESP");
        setSize(widith,heigth);
        setLocationRelativeTo(null);
        setLayout(Layout);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);

        container.add( new CadastrarPessoa(this),"CadPessoas");
        container.add(new ListarPessoasView(this),"ListPessoas");
        container.add(new SaidaPessoasView(this),"ExitePessoas");
        
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
        container2.setBackground(Color.BLACK);


        JButton btn1 = new JButton("Registrar Convidado");
        btn1.setBackground(Color.WHITE);
        container2.add(btn1);
        btn1.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               cardLayout.show(container, "CadPessoas");
            }
            
        });
        JButton btn2 = new JButton("Listar Convidados");
        btn2.setBackground(Color.WHITE);
        container2.add(btn2);
        btn2.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "ListPessoas");
            }
            
        });
        JButton btn3 = new JButton("Pesquisar / Liberar Pessoa");
        btn3.setBackground(Color.WHITE);
        container2.add(btn3);
        btn3.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               cardLayout.show(container,"ExitePessoas");
            }
            
        });

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = MAXIMIZED_VERT;
        gbc.fill = GridBagConstraints.BOTH;

        add(container2,gbc);
        

    }

}
