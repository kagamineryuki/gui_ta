import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class converter_suhu extends JFrame {
    private JPanel
            temperature_card,
            length_card,
            weight_card,
            currency_card,
            cards;

    private JTextField
            weight_val,
            weight_res,
            temps_val,
            temps_res,
            curr_val,
            curr_res,
            length_val,
            length_res;

    private JButton
            proc_weight,
            proc_temps,
            proc_length,
            proc_curr;

    private JLabel
            status_temp,
            temp_val_label,
            temp_val_res,
            status_weight,
            weight_val_label,
            weight_val_res,
            status_length,
            length_val_label,
            length_val_res,
            status_curr,
            curr_val_label,
            curr_val_res;

    private JComboBox
            temp_from,
            temp_to,
            curr_from,
            curr_to,
            length_from,
            length_to,
            weight_from,
            weight_to;

    private JMenuBar
            menu;

    private JMenu
            modes,
            colors;

    private JMenuItem
            sub_modes_length,
            sub_modes_weight,
            sub_modes_currency,
            sub_modes_temperature;

    private JMenuItem
            sub_colors_crimson,
            sub_colors_default,
            sub_colors_night;


    private String
            temp_combo_vals[] = {"Reamure","Kelvin","Fahrenheit","Celcius"},
            curr_combo_vals[] = {"USD","IDR","SGD","AUD"},
            length_combo_vals[] = {"M","CM","MM","Mile","Yard","Foot","Inch"},
            weight_combo_vals[] = {"Tonne","Kg","g","Mg","Pound","Ounce"};

    private Container mainUI_cont;

    private static Color
            DEFAULT_COLOR = UIManager.getColor("Panel.background"),
            CRIMSON_COLOR = new Color(220,20,60),
            NIGHT_COLOR = new Color(46,68,130);

    Weight weight;

    public converter_suhu(){
         weight = new Weight();

        MainUI();

        setTitle("Convertion Software");
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void MainUI(){
        mainUI_cont = getContentPane();

        MenuBar();
        Temperature_panel();
        Length_panel();
        Currency_panel();
        Weight_panel();

        cards = new JPanel(new CardLayout());
        cards.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cards.add(temperature_card, "Temperature");
        cards.add(length_card,"Length");
        cards.add(currency_card,"Currency");
        cards.add(weight_card,"Weight");

        mainUI_cont.add(cards);
        pack();
    }

//  UI Elements

    public void MenuBar(){
//      Menu bar only
        menu = new JMenuBar();

//      Menu bar items
        modes = new JMenu("Modes");
        colors = new JMenu("BG Colors");

//      Modes menus of menu of menu bar items
        sub_modes_length = new JMenuItem("Length");
        sub_modes_weight = new JMenuItem("Weight");
        sub_modes_currency = new JMenuItem("Currency");
        sub_modes_temperature = new JMenuItem("Temparature");

//      Colors menus of menu of menu bar items
        sub_colors_crimson = new JMenuItem("Crimson");
        sub_colors_default = new JMenuItem("Default");
        sub_colors_night = new JMenuItem("Night");

//      Add menu items to respective menus
//      Modes
        modes.add(sub_modes_length);
        modes.add(sub_modes_weight);
        modes.add(sub_modes_currency);
        modes.add(sub_modes_temperature);

//      Colors
        colors.add(sub_colors_default);
        colors.add(sub_colors_crimson);
        colors.add(sub_colors_night);

//      Add menu to menubar
        menu.add(modes);
        menu.add(colors);

        setJMenuBar(menu);
        sub_modes_temperature.addActionListener(new action_temp_menu());
        sub_modes_length.addActionListener(new action_length_menu());
        sub_modes_currency.addActionListener(new action_curr_menu());
        sub_modes_weight.addActionListener(new action_weight_menu());

        sub_colors_default.addActionListener(new action_colors_default_menu());
        sub_colors_crimson.addActionListener(new action_colors_crimson_menu());
        sub_colors_night.addActionListener(new action_colors_night_menu());
    }

    public void Temperature_panel(){
        temperature_card = new JPanel();
        temperature_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        temperature_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        temps_res = new JTextField();
        temps_val = new JTextField();
        status_temp = new JLabel("Temp. Mode");
        status_temp.setFont(new Font(status_temp.getFont().getName(),Font.BOLD,20));
        temp_val_label = new JLabel("Value");
        temp_val_res = new JLabel("Result");
        proc_temps = new JButton("Process");
        temp_from = new JComboBox(temp_combo_vals);
        temp_to = new JComboBox(temp_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        temperature_card.add(status_temp,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10,0,0,0);
        temperature_card.add(temp_val_label,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        temperature_card.add(temp_from,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        temperature_card.add(temps_val,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10,0,0,0);
        temperature_card.add(temp_val_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        temperature_card.add(temp_to,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        temperature_card.add(temps_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        temperature_card.add(proc_temps,gbConst);
    }

    public void Length_panel(){
        length_card = new JPanel();
        length_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        length_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        length_res = new JTextField();
        length_val = new JTextField();
        status_length = new JLabel("Length Mode");
        status_length.setFont(new Font(status_temp.getFont().getName(),Font.BOLD,20));
        length_val_label = new JLabel("Value");
        length_val_res = new JLabel("Result");
        proc_length = new JButton("Process");
        length_from = new JComboBox(length_combo_vals);
        length_to = new JComboBox(length_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        length_card.add(status_length,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10,0,0,0);
        length_card.add(length_val_label,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        length_card.add(length_from,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        length_card.add(length_val,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10,0,0,0);
        length_card.add(length_val_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        length_card.add(length_to,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        length_card.add(length_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        length_card.add(proc_length,gbConst);
    }

    public void Currency_panel(){
        currency_card = new JPanel();
        currency_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        currency_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        curr_res = new JTextField();
        curr_val = new JTextField();
        status_curr = new JLabel("Currency Mode");
        status_curr.setFont(new Font(status_temp.getFont().getName(),Font.BOLD,20));
        curr_val_label = new JLabel("Value");
        curr_val_res = new JLabel("Result");
        proc_curr = new JButton("Process");
        curr_from = new JComboBox(curr_combo_vals);
        curr_to = new JComboBox(curr_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        currency_card.add(status_curr,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10,0,0,0);
        currency_card.add(curr_val_label,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        currency_card.add(curr_from,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        currency_card.add(curr_val,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10,0,0,0);
        currency_card.add(curr_val_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        currency_card.add(curr_to,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        currency_card.add(curr_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        currency_card.add(proc_curr,gbConst);
    }

    public void Weight_panel(){
        weight_card = new JPanel();
        weight_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        weight_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        weight_res = new JTextField();
        weight_res.setEditable(false);
        weight_val = new JTextField();
        status_weight = new JLabel("Weight Mode");
        status_weight.setFont(new Font(status_temp.getFont().getName(),Font.BOLD,20));
        weight_val_label = new JLabel("Value");
        weight_val_res = new JLabel("Result");
        proc_weight = new JButton("Process");
        weight_from = new JComboBox(weight_combo_vals);
        weight_to = new JComboBox(weight_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        weight_card.add(status_weight,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10,0,0,0);
        weight_card.add(weight_val_label,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        weight_card.add(weight_from,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        weight_card.add(weight_val,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10,0,0,0);
        weight_card.add(weight_val_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        weight_card.add(weight_to,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        weight_card.add(weight_res,gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        weight_card.add(proc_weight,gbConst);

        proc_weight.addActionListener(new action_weight_convert());
    }

//  Action listeners

    class action_temp_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards,"Temperature");
        }
    }

    class action_length_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards,"Length");
        }
    }

    class action_curr_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards,"Currency");
        }
    }

    class action_weight_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards,"Weight");
        }
    }

    class action_colors_default_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            cards.setBackground(DEFAULT_COLOR);
        }
    }

    class action_colors_crimson_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            cards.setBackground(CRIMSON_COLOR);
        }
    }

    class action_colors_night_menu implements ActionListener{
        public void actionPerformed(ActionEvent e){
            cards.setBackground(NIGHT_COLOR);
        }
    }

    class action_weight_convert implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String from_text = weight_from.getSelectedItem().toString();
            String to_text = weight_to.getSelectedItem().toString();
            Double from_number = Double.parseDouble(weight_val.getText());
            Double to_number = 0.0;
            String mode = from_text.concat(" "+to_text);

            switch(mode){
                case "Tonne Tonne":
                    weight_res.setText(from_number.toString());
                    break;
                case "Tonne Kg":
                    to_number = weight.tonne_to_kg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Tonne g":
                    to_number = weight.tonne_to_g(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Tonne Mg":
                    to_number = weight.tonne_to_mg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Tonne Pound":
                    to_number = weight.tonne_to_pound(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Tonne Ounce":
                    to_number = weight.tonne_to_ounce(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Kg Kg":
                    weight_res.setText(from_number.toString());
                    break;
                case "Kg Tonne":
                    to_number = weight.kg_to_tonne(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Kg g":
                    to_number = weight.kg_to_g(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Kg Mg":
                    to_number = weight.kg_to_mg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Kg Pound":
                    to_number = weight.kg_to_pound(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Kg Ounce":
                    to_number = weight.kg_to_ounce(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "g g":
                    weight_res.setText(from_number.toString());
                    break;
                case "g Tonne":
                    to_number = weight.g_to_tonne(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "g Kg":
                    to_number = weight.g_to_kg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "g Mg":
                    to_number = weight.g_to_mg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "g Pound":
                    to_number = weight.g_to_pound(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "g Ounce":
                    to_number = weight.g_to_ounce(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Mg Mg":
                    weight_res.setText(from_number.toString());
                    break;
                case "Mg Tonne":
                    to_number = weight.mg_to_tonne(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Mg Kg":
                    to_number = weight.mg_to_kg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Mg g":
                    to_number = weight.mg_to_g(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Mg Pound":
                    to_number = weight.mg_to_pound(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Mg Ounce":
                    to_number = weight.mg_to_ounce(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Pound Tonne":
                    to_number = weight.pound_to_tonne(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Pound Kg":
                    to_number = weight.pound_to_kg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Pound g":
                    to_number = weight.pound_to_g(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Pound Mg":
                    to_number = weight.pound_to_mg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Pound Pound":
                    weight_res.setText(from_number.toString());
                    break;
                case "Pound Ounce":
                    to_number = weight.pound_to_ounce(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce Tonne":
                    to_number = weight.ounce_to_tonne(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce Kg":
                    to_number = weight.ounce_to_kg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce g":
                    to_number = weight.ounce_to_g(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce Mg":
                    to_number = weight.ounce_to_mg(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce Pound":
                    to_number = weight.ounce_to_pound(from_number);
                    weight_res.setText(to_number.toString());
                    break;
                case "Ounce Ounce":
                    weight_res.setText(from_number.toString());
                    break;
            }

        }
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new converter_suhu();
            }
        });
    }
}
