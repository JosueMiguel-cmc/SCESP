package View;

import javax.swing.*;

import VO.UsuarioVo;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class CadastrarPessoa extends JPanel {

    public CadastrarPessoa(PrincipalViewSCESP PVSCESP)  {
        // Configurações gerais (so se quiser kkkk) @Josue
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setVisible(true);

        // Painel de cadastro @Josue
        JPanel areacadastro = new JPanel();
        areacadastro.setBackground(Color.LIGHT_GRAY);
        areacadastro.setPreferredSize(new Dimension(350, 500)); // Tamanho do painel interno
        areacadastro.setLayout(new GridBagLayout()); // Usando GridBagLayout no painel interno

        JLabel nometelaLabel = new JLabel("Cadastro");
        Font fonte = new Font("Arial",Font.PLAIN,21);
        nometelaLabel.setFont(fonte);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        areacadastro.add(nometelaLabel,gbc);

        // Label e Campo de Nome @Josue
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        areacadastro.add(nomeLabel, gbc);

        gbc.gridx = 1;
        areacadastro.add(nomeField, gbc);

        // Label e Campo de Idade @Josue
        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField(5);

        gbc.gridx = 0;
        gbc.gridy = 3;
        areacadastro.add(idadeLabel, gbc);

        gbc.gridx = 1;
        areacadastro.add(idadeField, gbc);

        // Label e Campo de Gênero @ Josue
        JLabel generoLabel = new JLabel("Gênero:");
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> generoCombo = new JComboBox<>(generos);

        gbc.gridx = 0;
        gbc.gridy = 4;
        areacadastro.add(generoLabel, gbc);

        gbc.gridx = 1;
        areacadastro.add(generoCombo, gbc);

        // Label e Campo de Ocupação
        JLabel ocupacaoLabel = new JLabel("Ocupação:");
        String[] ocupaçoes = {"Influencer digital","Funcionario","Jornalista","analista","convidado"};
        JComboBox<String> ocupaçaoCombo = new JComboBox<>(ocupaçoes);
        gbc.gridx = 0;
        gbc.gridy = 5;
        areacadastro.add(ocupacaoLabel, gbc);

        gbc.gridx = 1;
        areacadastro.add(ocupaçaoCombo, gbc);

        // Botão de Salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.setBackground(Color.WHITE);

        salvarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //area onde vamos atribuir os dados do usuario
                String nome = null;
                int idade = 0;
                String genero = (String) generoCombo.getSelectedItem();
                String ocupaçao = (String) ocupaçaoCombo.getSelectedItem();
                LocalDateTime horariodeentrada = LocalDateTime.now();

                //local de vereficaçoes e finalizaçoes

                if (PVSCESP.getUsers().size() >= 19) {
                    JOptionPane.showMessageDialog(null, "limite de pessoas excedidas");
                }else{
                    if (idadeField.getText().isEmpty() || nomeField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "por favor preencha todos os campos");
                    }else{
                            idade = Integer.parseInt(idadeField.getText());
                            nome = nomeField.getText().toString();
                    }
                    if (idade >= 18) {
                    
                        if (ocupaçao.equals("Funcionario")) {
                                String senha = JOptionPane.showInputDialog(null,"Insira a senha");
                                if (senha.equals("123456")) {
                                    System.out.println("salvo com sucesso");
                                    PVSCESP.getUsers().add(new UsuarioVo(nome, ocupaçao, genero, idade, horariodeentrada, null));
                                    JOptionPane.showMessageDialog(null, "Funcionario registrado com sucesso");
                                    nomeField.setText(null);
                                    idadeField.setText(null);
                                }
                            } else{
                                System.out.println("salvo com sucesso");
                                    PVSCESP.getUsers().add(new UsuarioVo(nome, ocupaçao, genero, idade, horariodeentrada, null));
                                    JOptionPane.showMessageDialog(null, "convidado registrado com sucesso"); 
                                    nomeField.setText(null);
                                    idadeField.setText(null);
                                }
                    }else {
                        JOptionPane.showMessageDialog(null, "o convidado deve ser maior de 18 anos");
                        
                    }
                }

            }
            
        });
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        areacadastro.add(salvarButton, gbc);

        // Adicionando o painel centralizado ao painel principal @Josue
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(areacadastro, gbc);
    }

  
}
