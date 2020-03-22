import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new NotepadFrame("Super Notepad");
            }//run
        });//new runnable
    }//main
}//Main
