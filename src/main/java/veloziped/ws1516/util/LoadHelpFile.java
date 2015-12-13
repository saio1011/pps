/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author mihaisava
 */
public class LoadHelpFile {

    private String helpContent = null;

    public LoadHelpFile(String filename) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            if (file.exists()) {
                helpContent = FileUtils.readFileToString(file);
            } else {
                JOptionPane.showMessageDialog(null, "File Does not Exist \n" + file.getPath() + "\n" + file.toString());
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

