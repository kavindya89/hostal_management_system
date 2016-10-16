/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * roomAvailabilityTable.java
 *
 * Created on Sep 23, 2011, 11:03:19 AM
 */

package Interfaces;

import Models.RoomAvailability;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jayendra
 */
public class roomAvailabilityTable extends javax.swing.JFrame {
    ArrayList<RoomAvailability> ral;
    /** Creates new form roomAvailabilityTable */
    public roomAvailabilityTable() {
        initComponents();
    }

    roomAvailabilityTable(ArrayList<RoomAvailability> ra) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        updatetable(ra);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomAvailabilityjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        roomAvailabilityjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(roomAvailabilityjTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new roomAvailabilityTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomAvailabilityjTable;
    // End of variables declaration//GEN-END:variables

    private void updatetable(ArrayList<RoomAvailability> ra) {
        roomAvailabilityjTable.removeAll();
        DefaultTableModel mode=new DefaultTableModel();
        roomAvailabilityjTable.setModel(mode);
        String headers[] = new String[4];
        headers[0]="Room Number";
        //headers[1]="Capacity";
        headers[1]= "Type";
        headers[2]= "Status";
        headers[3] = "Cost";
        mode.setColumnIdentifiers(headers);

        System.out.println(ra.size());
            for(int i=0;i<ra.size();i++){

                    mode.insertRow(i,new Object[]{ra.get(i).getRoomNumber(),ra.get(i).getType(),ra.get(i).getFull(),ra.get(i).getCost()});
            }
    }


    
}