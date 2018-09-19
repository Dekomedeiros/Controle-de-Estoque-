package almoxarifado;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public abstract class UtilMascaras {
//Classe Utility para aplicar máscaras aos JFormattedTextFields.

    public static void maskOnlyString(JFormattedTextField jtextfield) {
        try {

            MaskFormatter apenasString = new MaskFormatter("******************");
            apenasString.setInvalidCharacters("1234567890");
            apenasString.install(jtextfield);

            jtextfield.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(UtilMascaras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskOnlyString3chars(JFormattedTextField jtextfield) {
        try {

            MaskFormatter apenas3chars = new MaskFormatter("***");
            apenas3chars.setInvalidCharacters("1234567890");
            apenas3chars.install(jtextfield);

            jtextfield.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(UtilMascaras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskOnlyInt(JFormattedTextField jtextfield) {
        try {
            MaskFormatter apenasInt = new MaskFormatter("********");
            apenasInt.setValidCharacters("1234567890");
            apenasInt.install(jtextfield);

            jtextfield.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(UtilMascaras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskOnlyDouble(JFormattedTextField jtextfield) {
        try {
            MaskFormatter apenasDouble = new MaskFormatter("********");
            apenasDouble.setValidCharacters("1234567890.");
            apenasDouble.install(jtextfield);

            jtextfield.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(UtilMascaras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void maskOnlyDate(JFormattedTextField jtextfield) {
        try {
            MaskFormatter apenasData = new MaskFormatter("**/**/****");
            apenasData.setValidCharacters("1234567890.");
            apenasData.install(jtextfield);

            jtextfield.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(UtilMascaras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
