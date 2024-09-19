package View;

import javax.swing.*;

import VO.UsuarioVo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ListarPessoasView extends JPanel {

    private DefaultListModel<String> listModel;
    private JList<String> userlist;

    public ListarPessoasView(PrincipalViewSCESP PVSCESP) {
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

     
        listModel = new DefaultListModel<>();
        userlist = new JList<>(listModel);
        

        atualizarLista(PVSCESP.getUsers());

      
        JScrollPane listScrollPane = new JScrollPane(userlist);
        listScrollPane.setPreferredSize(new Dimension(350, 500));
        listScrollPane.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(listScrollPane, gbc);

       
        JButton atualizar = new JButton("Atualizar");
        atualizar.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(atualizar, gbc);

      
        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                atualizarLista(PVSCESP.getUsers());
            }
        });
    }

   
    private void atualizarLista(ArrayList<UsuarioVo> users) {
        listModel.clear(); 
        for (UsuarioVo u : users) {
            listModel.addElement("Nome: " + u.getNome() + " | Idade: " + u.getIdade()+ " | Ocupação: " + u.getOcupação() + " | Gênero: " + u.getGenero() + " | Hora de entrada: " + u.getHoradeentrada());
        }
    }
}
