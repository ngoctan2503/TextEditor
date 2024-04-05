package Model;

import java.util.ArrayList;
import java.util.List;

public class TextEditorModel {
    private List<String> lines;

    public TextEditorModel() {
        lines = new ArrayList<>();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
