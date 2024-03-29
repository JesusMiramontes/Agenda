/**
 * INSTITUTO NACIONAL DE MÉXICO
 * INSTITUTO TECNOLÓGICO DE LA LAGUNA
 * TÓPICOS AVANZADOS DE PROGRAMACIÓN
 * ENE-AGO 2017
 * PROFESOR: ING. LUIS FERNANDO GIL VAZQUEZ
 * ALUMNO: JOSÉ DE JESÚS MIRAMONTES GÓMEZ
 * MATRICULA: 15131349
 */
package agendadecontactos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author USER
 */
public class SlashScreen extends javax.swing.JFrame {
    private ActionListener al;
    Timer t;
    /**
     * Creates new form SlashScreen
     */
    public SlashScreen() {
        
        
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jProgressBar1.getValue() < 100){
                    jProgressBar1.setValue(jProgressBar1.getValue()+5);
                }else{
                    t.stop();
                    MostrarVentana();
                }
            }
        };
        
        t = new Timer(80, al);
        
        initComponents();
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setBackground(new Color(60,63,65));
        jProgressBar1.setForeground(new Color(60,63,65));
        t.start();
    }

    private void MostrarVentana(){
        GUI g = new GUI();
        g.setLocationRelativeTo(null);
        g.setVisible(true);
        this.dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(772, 301));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notepad.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 290, 270);

        jProgressBar1.setForeground(new java.awt.Color(60, 63, 65));
        jProgressBar1.setFocusable(false);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(-4, 272, 850, 10);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agenda de contactos");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(318, 20, 494, 57);

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("v1.0");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(320, 70, 52, 29);

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("José de Jesús Miramontes Gómez");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 130, 330, 24);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 284);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
