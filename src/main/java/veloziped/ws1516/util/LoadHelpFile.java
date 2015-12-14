/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mihaisava
 */
public class LoadHelpFile {

    private String helpContent = null;

    public LoadHelpFile(String filename) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream valueHelpStreamStream = classLoader.getResourceAsStream(filename);
            if (valueHelpStreamStream != null) {
                helpContent = IOUtils.toString(valueHelpStreamStream, StandardCharsets.UTF_8);
            } else {
                JOptionPane.showMessageDialog(null, "File Does not Exist \n");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoadHelpFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return helpContent;
    }
}

