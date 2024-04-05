package Controller;

import java.awt.event.ActionEvent;
import javax.swing.*;

import Model.TextEditorModel;
import View.TextEditorView;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextEditorController {
    private TextEditorModel model;
    private TextEditorView view;
    private File currentFile;

    public TextEditorController(TextEditorModel model, TextEditorView view) {
        this.model = model;
        this.view = view;

        view.displayText(model.getLines());

        setupEventListeners();
    }

    private void setupEventListeners() {
        view.getOpenItem().addActionListener(this::openFile);
        view.getLoadItem().addActionListener(this::loadFile);
        view.getSaveItem().addActionListener(this::saveFile);
    }

    private void openFile(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(view);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (Stream<String> stream = Files.lines(currentFile.toPath())) {
                List<String> lines = stream.collect(Collectors.toList());
                model.setLines(lines);
                view.displayText(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFile(ActionEvent event) {
        if (currentFile != null) {
            try (FileWriter fw = new FileWriter(currentFile, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(view.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(view);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (PrintWriter out = new PrintWriter(currentFile)) {
                out.println(view.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    
}
