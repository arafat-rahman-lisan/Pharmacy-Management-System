import frames.*;
import javax.swing.SwingUtilities;
public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { PharmaUI.init(); new EntryFrame().setVisible(true); });
    }
}
