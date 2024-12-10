package LAB_4;
// Program converts temperatures.
import fig35_05_06.MenuFrame;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConvertFrame extends JFrame
{
    private JPanel fromJPanel;
    private JPanel toJPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPanel buttonPanel;
    private final JLabel USDollar;
    private final JLabel mexicanPeso;
    private final JLabel Euro;
    private final JLabel USDollar2;
    private final JLabel mexicanPeso2;
    private final JLabel Euro2;

    private JTextField tempJTextField1;
    private JTextField tempJTextField2;
    private ButtonGroup fromButtonGroup;
    private ButtonGroup toButtonGroup;
    private JRadioButton MexicanPesoToJRadioButton;
    private JRadioButton USDToJRadioButton;
    private JRadioButton EuroToJRadioButton;
    private JRadioButton MexicanPesoFromJRadioButton;
    private JRadioButton USDFromJRadioButton;
    private JRadioButton EuroFromJRadioButton;
    private JButton calcJButton;
    private JButton clearJbutton;
    //private JButton exitButton;
    private JButton exitJButton;
    private JPanel money1;
    private JPanel money2;
    //private final GridLayout moneylayout;

    // constructor sets up GUI
    public ConvertFrame()
    {
        super("Currency Conversion");
        //menu starts here
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');//altf
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A');
        JMenuItem convertItem = new JMenuItem("Convert");
        convertItem.setMnemonic('n');
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.setMnemonic('C');
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(aboutItem);
        fileMenu.add(convertItem);
        fileMenu.add(clearItem);
        aboutItem.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    @Override
                    public void actionPerformed(ActionEvent event) {    //if null here then widow pops up in middle.
                        JOptionPane.showMessageDialog(ConvertFrame.this,
                                "Currency Conversion Program \n using menus and buttons \n source: https://www.oanda.com/currency-converter/ ",
                                "About", JOptionPane.PLAIN_MESSAGE);
                    }
                });
                fileMenu.add(exitItem);

        fileMenu.add(exitItem);
        ConvertFrame.MyEventHandler covertItemHandler = new ConvertFrame.MyEventHandler();
        ConvertFrame.ClearButtonListener clearItemHandler = new ConvertFrame.ClearButtonListener();
        ConvertFrame.ExitButtonListener exitItemHandler = new ConvertFrame.ExitButtonListener();
        convertItem.addActionListener(covertItemHandler);
        clearItem.addActionListener(clearItemHandler);
        exitItem.addActionListener(exitItemHandler);
        //same thing for clear and exit

        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int r = JOptionPane.showConfirmDialog(null,
                        "Are you sure?", "Confirmation window", JOptionPane.YES_NO_OPTION);
                if(r == 0)
                    System.exit(0);
            }
        });

        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar);
        //menu ends here

        USDFromJRadioButton =
                new JRadioButton("US Dollar", true);
        MexicanPesoFromJRadioButton = new JRadioButton("Mexican Peso", false);
        EuroFromJRadioButton = new JRadioButton("Euro",   false);
        fromButtonGroup = new ButtonGroup();
        fromButtonGroup.add(USDFromJRadioButton);
        fromButtonGroup.add(MexicanPesoFromJRadioButton);
        fromButtonGroup.add(EuroFromJRadioButton);

        // create ButtonGroup for to JRadioButtons

        USDToJRadioButton =
                new JRadioButton("US Dollar", false);
        MexicanPesoToJRadioButton = new JRadioButton("Mexican Peso", true);
        EuroToJRadioButton = new JRadioButton("Euro", false);
        toButtonGroup = new ButtonGroup();
        toButtonGroup.add(USDToJRadioButton);
        toButtonGroup.add(MexicanPesoToJRadioButton);
        toButtonGroup.add(EuroToJRadioButton);


        // create from JPanel
        fromJPanel = new JPanel();
        fromJPanel.setLayout(new GridLayout(1, 3));
        fromJPanel.add(USDFromJRadioButton);
        fromJPanel.add(MexicanPesoFromJRadioButton);
        fromJPanel.add(EuroFromJRadioButton);

        // create to JPanel
        toJPanel = new JPanel();
        toJPanel.setLayout(new GridLayout(1, 3));
        toJPanel.add(USDToJRadioButton);
        toJPanel.add(MexicanPesoToJRadioButton);
        toJPanel.add(EuroToJRadioButton);
//maybe panel for the pictures, nvm
        // create labels
        label1 = new JLabel("Convert from:");
        label2 = new JLabel("Convert to:");
        label3 = new JLabel("Enter Currency: ");
        label4 = new JLabel("Comparable Currency is: ");


        // create JTextField for getting temperature to be converted
        tempJTextField1 = new JTextField(10);
        tempJTextField1.setText("0.0");


        // event handling using inner class (Style 1)
        ConvertFrame.MyEventHandler handler = new ConvertFrame.MyEventHandler();//create object
        tempJTextField1.addActionListener(handler);//register ActionEvent to text field

        // JTextField to display temperature after conversion
        tempJTextField2 = new JTextField(10);
        tempJTextField2.setEditable(false);
        tempJTextField2.setBackground(Color.GRAY);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        calcJButton = new JButton("Convert");
        calcJButton.addActionListener(new ConvertFrame.MyEventHandler());
        clearJbutton = new JButton("CLear");
        clearJbutton.addActionListener(new ConvertFrame.ClearButtonListener());
        exitJButton = new JButton("Exit");
        exitJButton.addActionListener(new ConvertFrame.ExitButtonListener());

        buttonPanel.add(calcJButton);
        buttonPanel.add(clearJbutton);
        buttonPanel.add(exitJButton);

        //images
        money1 = new JPanel();
        money1.setLayout(new GridLayout(1,3));
        Icon dollar = new ImageIcon(getClass().getResource("dollar.jpg"));
        USDollar = new JLabel(dollar);
        Icon peso = new ImageIcon(getClass().getResource("peso.jpg"));
        mexicanPeso = new JLabel(peso);
        Icon euro = new ImageIcon(getClass().getResource("euro.jpg"));
        Euro = new JLabel(euro);
        money1.add(USDollar);
        money1.add(mexicanPeso);
        money1.add(Euro);

        //second set of images
        money2 = new JPanel();
        money2.setLayout(new GridLayout(1,3));
        Icon dollar2 = new ImageIcon(getClass().getResource("dollar.jpg"));
        USDollar2 = new JLabel(dollar2);
        Icon peso2 = new ImageIcon(getClass().getResource("peso.jpg"));
        mexicanPeso2 = new JLabel(peso2);
        Icon euro2 = new ImageIcon(getClass().getResource("euro.jpg"));
        Euro2 = new JLabel(euro2);
        money2.add(USDollar2);
        money2.add(mexicanPeso2);
        money2.add(Euro2);

        //money.setBorder(BorderFactory.createTitledBorder(""));


//use setbackground of text field to gray or green whatever i want.
        // add components to GUI
        setLayout(new GridLayout(11, 1));//switch to 11,1 to be able to add the pictures
        add(label1);
        add(money1);
        //add the row to be able to add the pictures.
        add(fromJPanel);
        add(label3);
        add(tempJTextField1);
        add(label2);
        add(money2);
        add(toJPanel);
        add(label4);
        add(tempJTextField2);
        add(buttonPanel);
        pack(); // no need for JFrame setSize()
    }

    //inner class
    private class MyEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            float convertCurrency = 0.0F, currency;
            String result = ""; // for Pop up window

            //getting the value from the text field
            currency = Float.parseFloat(tempJTextField1.getText());

            // USD to Peso
            if (USDFromJRadioButton.isSelected() &&
                    MexicanPesoToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 16.34);
                tempJTextField2.setText(
                        String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "US Dollar to Mexican Peso";
            }
            // USD TO EURO
            else if (USDFromJRadioButton.isSelected() &&
                    EuroToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 0.92);
                tempJTextField2.setText(
                        String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "US Dollar to Euro";
            }
            // peso to usd
            else if (MexicanPesoFromJRadioButton.isSelected() &&
                    USDToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 0.06);
                tempJTextField2.setText(
                        String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "Mexican Peso to US Dollar";
            }
            // peso to euro
            else if (MexicanPesoFromJRadioButton.isSelected() &&
                    EuroToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 0.056);
                tempJTextField2.setText(
                        String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "Mexican Peso To Euro";
            }
            // euro to peso
            else if (EuroFromJRadioButton.isSelected() &&
                    MexicanPesoToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 17.94);
                tempJTextField2.setText(
                        String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "Euro to Mexican Peso";
            }
            // euro to usd
            else if (EuroFromJRadioButton.isSelected() &&
                    USDToJRadioButton.isSelected()) {
                convertCurrency = (float) (currency * 1.09);
                tempJTextField2.setText(String.valueOf(convertCurrency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "Euro to US Dollar";
            }
            // source and destination are the same; just copy value
            else {
                tempJTextField2.setText(String.valueOf(currency));
                tempJTextField2.setBackground(Color.GREEN);
                result = "No conversion selected";
            }

            result += "\n" + currency + "  is equivalent to \t  " + convertCurrency + "";

            JOptionPane.showMessageDialog(ConvertFrame.this, result, "Converted Currency", JOptionPane.INFORMATION_MESSAGE);
        }// end method actionPerformed
    }
    //clear button listener and doer.
    private class ClearButtonListener implements ActionListener{
              public void actionPerformed(ActionEvent a){
                  tempJTextField2.setText("");
                  tempJTextField1.setText("0.0");
              }

             }private class ExitButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e)
            {
                int r = JOptionPane.showConfirmDialog(null,
                        "Are you sure?", "Confirmation window", JOptionPane.YES_NO_OPTION);
                if(r == 0)
                    System.exit(0);
            }}
    //end of inner class

} // end class ConvertFrame








