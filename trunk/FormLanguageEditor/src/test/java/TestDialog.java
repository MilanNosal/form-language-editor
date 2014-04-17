/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JDialog;
import javax.swing.UIManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yajco.fle.panels.ConceptDialog;

/**
 *
 * @author DeeL
 */
public class TestDialog {

    public TestDialog() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void runWindow() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConceptDialog cd = new ConceptDialog(null, new generated.ModelPanel());
        //cd.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        cd.showDialog();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
