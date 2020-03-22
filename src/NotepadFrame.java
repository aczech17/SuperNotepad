import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotepadFrame extends JFrame
{
    private JTextArea textArea;

    public JTextArea getTextArea()
    {
        return textArea;
    }
    public NotepadFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final int width = 1440;
        final int height = 900;
        setSize(width, height);
        setLayout(new FlowLayout(0,0,0));

        JPanel textPanel = new JPanel ();
        textPanel.setBorder ( new TitledBorder ( new EtchedBorder ()));

        textArea = new JTextArea(45, 151);
        //textArea.setSize(new Dimension(width, height));
        JScrollPane scroll = new JScrollPane ( textArea );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        textPanel.add ( scroll );
        textPanel.setSize(new Dimension(width, height));

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(new SaveAction(textArea, saveButton));

        add(saveButton);
        add ( textPanel );
        pack ();
        setLocationRelativeTo ( null );
        setVisible ( true );
    }
}
