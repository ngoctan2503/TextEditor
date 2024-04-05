package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TextEditorView extends JFrame {
    private JTextArea textArea;
    private JMenuItem openItem;
    private JMenuItem loadItem;
    private JMenuItem saveItem;

    public TextEditorView() {
        setTitle("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        ImageIcon icon = new ImageIcon("C:\\\\\\\\Users\\\\\\\\NGOC TAN\\\\\\\\NOTEPAD (2).png");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        openItem = new JMenuItem("Open");
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");

        fileMenu.add(openItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void displayText(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }

    public JMenuItem getLoadItem() {
        return loadItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }
}
