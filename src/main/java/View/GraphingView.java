package View;

import Data_Access.GraphingService;

import javax.swing.*;
import java.awt.*;

public class GraphingView extends JFrame {
    private final GraphingService graphingService;

    public GraphingView(GraphingService graphingService) {
        this.graphingService = graphingService;
        setupUI();
    }

    private void setupUI() {
        setTitle("Graphing View");
        setSize(900, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openGraphButton = new JButton("Open Graph");
        openGraphButton.addActionListener(e -> graphingService.OpenGraphingCalculator());
        add(openGraphButton, BorderLayout.SOUTH);
    }
}
