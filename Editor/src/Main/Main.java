package Main;

import Controller.TextEditorController;
import Model.TextEditorModel;
import View.TextEditorView;

public class Main {
	public static void main(String[] args) {
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView();
        TextEditorController controller = new TextEditorController(model, view);
        
        
        
    }
}