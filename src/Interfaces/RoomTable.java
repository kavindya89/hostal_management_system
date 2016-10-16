/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RoomTable.java
 *
 * Created on Sep 22, 2011, 6:46:49 PM
 */

package Interfaces;

import DatabaseAccess.HallResourcesHandler;
import entities.Room;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kavindya
 */
public class RoomTable extends javax.swing.JDialog {
        private String hall_id;
        private int size;
        private HallResourcesHandler handler;
    /** Creates new form RoomTable */
    public RoomTable(java.awt.Frame parent, boolean modal,int size,String hall_id) {

        super(parent, modal);
        this.size=size;
        this.hall_id=hall_id;
        handler=new HallResourcesHandler();
        initComponents();
        configureTable();
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void configureTable()
    {
        String col[] = {"Room number","Type","Amount"};
        DefaultTableModel model = new DefaultTableModel(null,col);
            System.out.println(size);
            for(int i=0;i<size;i++) {
                Vector<Object> v=new Vector<Object>();
                v.addElement(i+1);
                v.addElement("Single");
                v.addElement(800.00);
                model.addRow(v);
            }
            table.setModel(model);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        hallCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room number", "Type", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Enter the room details");

        hallCancelButton.setText("Save");
        hallCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(hallCancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hallCancelButton)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hallCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallCancelButtonActionPerformed
        try {
            ArrayList<Room> room = new ArrayList<Room>();
            Room temp;
            for (int i = 0; i < size; i++) {
                temp = new Room();
                temp.setHallID(hall_id);
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        Object ob = table.getModel().getValueAt(i, j);
                        temp.setRoomNumber(Integer.parseInt(ob.toString()));
                    }
                    if (j == 1) {
                        Object ob = table.getModel().getValueAt(i, j);
                        temp.setType(ob.toString());
                    }
                    if (j == 2) {
                        Object ob = table.getModel().getValueAt(i, j);
                        temp.setCost(Double.parseDouble(ob.toString()));
                    }
                }
                room.add(temp);
            }
            handler.addRooms(room);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(RoomTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hallCancelButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RoomTable dialog = new RoomTable(new javax.swing.JFrame(), true,0,"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hallCancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}