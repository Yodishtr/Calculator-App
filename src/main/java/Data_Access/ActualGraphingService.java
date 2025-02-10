package Data_Access;




import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ActualGraphingService implements GraphingService {
    private JFrame frame;


    @Override
    public void OpenGraphingCalculator(){
        frame = new JFrame("Desmos graphing calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(900, 700);

        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel, BorderLayout.CENTER);


        Platform.runLater(() -> {
            WebView webview = new WebView();
            webview.getEngine().load("https://www.desmos.com/calculator");
            jfxPanel.setScene(new Scene(webview));
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();

        });
        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
