import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAction implements ActionListener
{
    JTextArea textArea;
    JButton button;
    public SaveAction(JTextArea textArea, JButton button)
    {
        this.textArea = textArea;
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String text = textArea.getText();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Zapisz plik tekstowy.");
        int selectedOption = fileChooser.showSaveDialog(button);
        if(selectedOption == JFileChooser.APPROVE_OPTION)
        {
            File textFile = fileChooser.getSelectedFile();
            textFile = new File(textFile.getParentFile(), textFile.getName());
            try
            {
                FileWriter fileWriter = new FileWriter(textFile);
                fileWriter.write(text);
                fileWriter.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
