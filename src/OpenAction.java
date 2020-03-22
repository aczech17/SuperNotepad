import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenAction implements ActionListener
{
    JTextArea textArea;
    JButton button;
    public OpenAction(JTextArea textArea, JButton button)
    {
        this.textArea = textArea;
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String text = textArea.getText();
        StringBuffer buffer = new StringBuffer();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Otwórz plik tekstowy");
        int selectedOption = fileChooser.showOpenDialog(button);
        if(selectedOption == JFileChooser.APPROVE_OPTION)
        {
            File textFile = fileChooser.getSelectedFile();
            FileReader fileReader = null;
            try
            {
                fileReader = new FileReader(textFile);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            int i = 1;
            while(true)
            {
                try
                {
                    assert fileReader != null;
                    i = fileReader.read();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                if(i == -1)
                    break;
                char ch = (char)i;
                buffer.append(ch);
            }//while
            textArea.setText(buffer.toString());
        }//if
    }//actionPerformed
}
