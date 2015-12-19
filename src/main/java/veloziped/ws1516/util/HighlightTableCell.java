/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Martin
 */
public class HighlightTableCell extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        //Cells are by default rendered as a JLabel.
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        Color cLight = new Color(255, 255, 178);
        Color cDark = new Color(255, 255, 127);

        if (row % 2 == 0) {
            l.setBackground(cLight);
        } else {
            l.setBackground(cDark);
        }
        
        if(isSelected) {
            l.setBackground(table.getSelectionBackground());
        }
        
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        
        //Return the JLabel which renders the cell.
        return l;
    }
}
