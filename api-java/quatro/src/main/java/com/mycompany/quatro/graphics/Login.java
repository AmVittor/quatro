package com.mycompany.quatro.graphics;

import com.mycompany.quatro.connection.ConnectionSqlServer;
import com.mycompany.quatro.log.Logs;
import com.mycompany.quatro.login.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        painelFundo = new javax.swing.JPanel();
        painelEsquerda = new javax.swing.JPanel();
        txtTituloQuatro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        painelDireita = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        separator1 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        separator2 = new javax.swing.JSeparator();
        txtX = new javax.swing.JLabel();
        painelRegistrar = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        painelEntrar = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        painelEsquerda.setBackground(new java.awt.Color(33, 30, 31));
        painelEsquerda.setForeground(new java.awt.Color(255, 255, 255));

        txtTituloQuatro.setBackground(new java.awt.Color(33, 30, 31));
        txtTituloQuatro.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        txtTituloQuatro.setForeground(new java.awt.Color(204, 204, 204));
        txtTituloQuatro.setText("Monitoramento de servidores de e-commerce");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo-quatro.png"))); // NOI18N

        javax.swing.GroupLayout painelEsquerdaLayout = new javax.swing.GroupLayout(painelEsquerda);
        painelEsquerda.setLayout(painelEsquerdaLayout);
        painelEsquerdaLayout.setHorizontalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsquerdaLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtTituloQuatro)
                .addGap(17, 17, 17))
            .addGroup(painelEsquerdaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelEsquerdaLayout.setVerticalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsquerdaLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTituloQuatro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDireita.setBackground(new java.awt.Color(253, 96, 175));
        painelDireita.setPreferredSize(new java.awt.Dimension(250, 450));

        txtUsername.setBackground(new java.awt.Color(253, 96, 175));
        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Username");
        txtUsername.setBorder(null);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        separator1.setBackground(new java.awt.Color(255, 255, 255));
        separator1.setForeground(new java.awt.Color(255, 255, 255));

        txtPassword.setBackground(new java.awt.Color(253, 96, 175));
        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("*********");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });

        separator2.setBackground(new java.awt.Color(255, 255, 255));
        separator2.setForeground(new java.awt.Color(255, 255, 255));

        txtX.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtX.setForeground(new java.awt.Color(33, 30, 31));
        txtX.setText("X");
        txtX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtXMouseClicked(evt);
            }
        });

        painelRegistrar.setBackground(new java.awt.Color(253, 96, 175));
        painelRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        painelRegistrar.setForeground(new java.awt.Color(255, 255, 255));

        btnRegistrar.setBackground(new java.awt.Color(253, 96, 175));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRegistrarLayout = new javax.swing.GroupLayout(painelRegistrar);
        painelRegistrar.setLayout(painelRegistrarLayout);
        painelRegistrarLayout.setHorizontalGroup(
            painelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );
        painelRegistrarLayout.setVerticalGroup(
            painelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        painelEntrar.setBackground(new java.awt.Color(253, 96, 175));
        painelEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        painelEntrar.setForeground(new java.awt.Color(255, 255, 255));

        btnEntrar.setBackground(new java.awt.Color(253, 96, 175));
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEntrarLayout = new javax.swing.GroupLayout(painelEntrar);
        painelEntrar.setLayout(painelEntrarLayout);
        painelEntrarLayout.setHorizontalGroup(
            painelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelEntrarLayout.setVerticalGroup(
            painelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(253, 96, 175));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Esqueceu sua senha?");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadeado.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pessoa.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(253, 96, 175));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jCheckBox1.setBackground(new java.awt.Color(253, 96, 175));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Mostrar senha");
        jCheckBox1.setBorder(null);
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setFocusPainted(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(253, 96, 175));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        btnMinimizar.setBackground(new java.awt.Color(253, 96, 175));
        btnMinimizar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(33, 30, 31));
        btnMinimizar.setText("-");
        btnMinimizar.setBorder(null);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setDefaultCapable(false);
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setFocusable(false);
        btnMinimizar.setMargin(new java.awt.Insets(3, 20, 2, 14));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(10, 24));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDireitaLayout = new javax.swing.GroupLayout(painelDireita);
        painelDireita.setLayout(painelDireitaLayout);
        painelDireitaLayout.setHorizontalGroup(
            painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitaLayout.createSequentialGroup()
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDireitaLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addGroup(painelDireitaLayout.createSequentialGroup()
                                    .addComponent(painelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(painelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createSequentialGroup()
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtX)
                        .addGap(3, 3, 3))))
        );
        painelDireitaLayout.setVerticalGroup(
            painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitaLayout.createSequentialGroup()
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addComponent(painelEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(painelDireita, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDireita, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (evt.getSource() == jCheckBox1) {
            if (jCheckBox1.isSelected()) {
                txtPassword.getPassword();
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.getPassword();
                txtPassword.setEchoChar('*');
            }
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.google.com"));
            } catch (URISyntaxException error1) {
                System.out.println(error1);
            }
        } catch (IOException error2) {
            System.out.println(error2);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(new Color(255, 0, 0));
        jButton1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton1MouseEntered

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        ConnectionSqlServer mssql = new ConnectionSqlServer();
        List<User> usersList = mssql.getMssql().query("select * from [dbo].[user];", new BeanPropertyRowMapper<>(User.class));
        Boolean userFind = false;
        Logs log = new Logs();

            for (User user: usersList) {
                if(txtUsername.getText().equals(user.getEmail()) && txtPassword.getText().equals(user.getUserPassword())) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    this.dispose();
                    new DashboardHome(user.getUserName()).setVisible(true);
                    userFind = true;

                    log.generateLoginLog(txtUsername.getText(), txtPassword.getText());
                }
            }


        if (!userFind) {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos.");
            txtUsername.setText("");
            txtPassword.setText("********");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        try {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.google.com"));
            } catch (URISyntaxException error1) {
                System.out.println(error1);
            }
        } catch (IOException error2) {
            System.out.println(error2);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtXMouseClicked

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_txtXMouseClicked

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        txtUsername.setText("");
        txtUsername.addFocusListener((FocusListener) this);
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel painelDireita;
    private javax.swing.JPanel painelEntrar;
    private javax.swing.JPanel painelEsquerda;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JPanel painelRegistrar;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtTituloQuatro;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel txtX;
    // End of variables declaration//GEN-END:variables
}
