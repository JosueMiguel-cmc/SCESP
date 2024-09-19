package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.*;

import VO.UsuarioVo;

public class SaidaPessoasView extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> userlist;
    GridBagConstraints areapanelgbc;

    public SaidaPessoasView(PrincipalViewSCESP PVSCESP){
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

     
        listModel = new DefaultListModel<>();
        userlist = new JList<>(listModel);

      
        JScrollPane listScrollPane = new JScrollPane(userlist);
        listScrollPane.setPreferredSize(new Dimension(350, 500));
        listScrollPane.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(listScrollPane, gbc);

        JPanel areacontrolePane = new JPanel();
        areacontrolePane.setLayout(new GridBagLayout());
        areacontrolePane.setPreferredSize(new Dimension(350,500));
        areacontrolePane.setBackground(Color.LIGHT_GRAY);
        areapanelgbc = new GridBagConstraints();
        areapanelgbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(areacontrolePane, gbc);
	
	    JTextField pesquisaField = new JTextField();
        pesquisaField.setPreferredSize(new Dimension(250, 30));

        areapanelgbc.gridx = 0;
        areapanelgbc.gridy = 0;
        areapanelgbc.anchor = GridBagConstraints.WEST;
        areacontrolePane.add(pesquisaField,areapanelgbc);

        JButton pesquisarbtn = new JButton("Pesquisar");
        pesquisarbtn.setBackground(Color.WHITE);
        pesquisarbtn.setPreferredSize(new Dimension(100,30));

        areapanelgbc.gridx = 0;
        areapanelgbc.gridy = 1;
        areapanelgbc.anchor = GridBagConstraints.WEST;
        areacontrolePane.add(pesquisarbtn,areapanelgbc);

        JButton liberarPessoa = new JButton("Liberar");
        liberarPessoa.setBackground(Color.WHITE);
        liberarPessoa.setPreferredSize(new Dimension(100,30));

        areapanelgbc.gridx = 0;
        areapanelgbc.gridy = 2;
        areapanelgbc.anchor = GridBagConstraints.WEST;

        areacontrolePane.add(liberarPessoa,areapanelgbc);
        liberarPessoa.addActionListener( new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                    int indexselecionado = userlist.getSelectedIndex();
                    if(indexselecionado > -1){
                        PVSCESP.getUsers().remove(indexselecionado);
                    }else{
                        JOptionPane.showMessageDialog(null, "selecione um usuario para liberar");
                    }
                    
                    }
                    
                });

        pesquisarbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
                if (pesquisaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "por favor preencha o campo para realizar a pesquisar");
                }else{
                    String pesquisa = pesquisaField.getText().toString();
                    pesquisarpessoa(PVSCESP.getUsers(),pesquisa);
                }    
            }
            
        });
       

        
        
    }
    public void pesquisarpessoa(ArrayList<UsuarioVo> user ,String nome){

        for(UsuarioVo u : user){
            
            if (u.getNome().equalsIgnoreCase(nome)) {
                listModel.addElement("Nome: " + u.getNome() + " | Idade: " + u.getIdade()+ " | Ocupação: " + u.getOcupação() + " | Gênero: " + u.getGenero() + " | Hora de entrada: " + u.getHoradeentrada());
            }
        }
    }
}
