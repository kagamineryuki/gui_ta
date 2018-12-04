import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class converter_gui extends JFrame {
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
            temp_combo_vals[] = {"Reamure", "Kelvin", "Fahrenheit", "Celcius"},
            curr_combo_vals[] = {"USD", "IDR", "SGD", "AUD"},
            length_combo_vals[] = {"M", "CM", "MM", "Mile", "Yard", "Foot", "Inch"},
            weight_combo_vals[] = {"Tonne", "Kg", "g", "Mg", "Pound", "Ounce"};

    private Container mainUI_cont;

    private static Color
            DEFAULT_COLOR = UIManager.getColor("Panel.background"),
            CRIMSON_COLOR = new Color(220, 20, 60),
            NIGHT_COLOR = new Color(46, 68, 130);

    private Weight weight;
    private Metric length;
    private suhu temps;
    private Currency curr;

    public converter_gui() {
        weight = new Weight();
        length = new Metric();
        temps = new suhu();
        curr = new Currency();

        MainUI();

        setTitle("Convertion Software");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void MainUI() {
        mainUI_cont = getContentPane();

        MenuBar();
        Temperature_panel();
        Length_panel();
        Currency_panel();
        Weight_panel();

        cards = new JPanel(new CardLayout());
        cards.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cards.add(temperature_card, "Temperature");
        cards.add(length_card, "Length");
        cards.add(currency_card, "Currency");
        cards.add(weight_card, "Weight");

        mainUI_cont.add(cards);
        pack();
    }

//  UI Elements

    public void MenuBar() {
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

    public void Temperature_panel() {
        temperature_card = new JPanel();
        temperature_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        temperature_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        temps_res = new JTextField();
        temps_res.setEditable(false);
        temps_val = new JTextField();
        status_temp = new JLabel("Temp. Mode");
        status_temp.setFont(new Font(status_temp.getFont().getName(), Font.BOLD, 20));
        temp_val_label = new JLabel("Value");
        temp_val_res = new JLabel("Result");
        proc_temps = new JButton("Process");
        temp_from = new JComboBox(temp_combo_vals);
        temp_to = new JComboBox(temp_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        temperature_card.add(status_temp, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0, 0, 0);
        temperature_card.add(temp_val_label, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        temperature_card.add(temp_from, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        temperature_card.add(temps_val, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10, 0, 0, 0);
        temperature_card.add(temp_val_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        temperature_card.add(temp_to, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        temperature_card.add(temps_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        temperature_card.add(proc_temps, gbConst);

        proc_temps.addActionListener(new action_temp_convert());
    }

    public void Length_panel() {
        length_card = new JPanel();
        length_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        length_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        length_res = new JTextField();
        length_res.setEditable(false);
        length_val = new JTextField();
        status_length = new JLabel("Length Mode");
        status_length.setFont(new Font(status_temp.getFont().getName(), Font.BOLD, 20));
        length_val_label = new JLabel("Value");
        length_val_res = new JLabel("Result");
        proc_length = new JButton("Process");
        length_from = new JComboBox(length_combo_vals);
        length_to = new JComboBox(length_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        length_card.add(status_length, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0, 0, 0);
        length_card.add(length_val_label, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        length_card.add(length_from, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        length_card.add(length_val, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10, 0, 0, 0);
        length_card.add(length_val_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        length_card.add(length_to, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        length_card.add(length_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        length_card.add(proc_length, gbConst);

        proc_length.addActionListener(new action_length_convert());
    }

    public void Currency_panel() {
        currency_card = new JPanel();
        currency_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        currency_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        curr_res = new JTextField();
        curr_res.setEditable(false);
        curr_val = new JTextField();
        status_curr = new JLabel("Currency Mode");
        status_curr.setFont(new Font(status_temp.getFont().getName(), Font.BOLD, 20));
        curr_val_label = new JLabel("Value");
        curr_val_res = new JLabel("Result");
        proc_curr = new JButton("Process");
        curr_from = new JComboBox(curr_combo_vals);
        curr_to = new JComboBox(curr_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        currency_card.add(status_curr, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0, 0, 0);
        currency_card.add(curr_val_label, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        currency_card.add(curr_from, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        currency_card.add(curr_val, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10, 0, 0, 0);
        currency_card.add(curr_val_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        currency_card.add(curr_to, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        currency_card.add(curr_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        currency_card.add(proc_curr, gbConst);

        proc_curr.addActionListener(new action_curr_convert());
    }

    public void Weight_panel() {
        weight_card = new JPanel();
        weight_card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        weight_card.setLayout(new GridBagLayout());
        GridBagConstraints gbConst = new GridBagConstraints();
        gbConst.fill = GridBagConstraints.HORIZONTAL;

        weight_res = new JTextField();
        weight_res.setEditable(false);
        weight_val = new JTextField();
        status_weight = new JLabel("Weight Mode");
        status_weight.setFont(new Font(status_temp.getFont().getName(), Font.BOLD, 20));
        weight_val_label = new JLabel("Value");
        weight_val_res = new JLabel("Result");
        proc_weight = new JButton("Process");
        weight_from = new JComboBox(weight_combo_vals);
        weight_to = new JComboBox(weight_combo_vals);

        gbConst.weightx = 0.5;
        gbConst.gridx = 0;
        gbConst.gridy = 0;
        weight_card.add(status_weight, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 1;
        gbConst.insets = new Insets(10, 0, 0, 0);
        weight_card.add(weight_val_label, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 2;
        weight_card.add(weight_from, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 3;
        weight_card.add(weight_val, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 4;
        gbConst.insets = new Insets(10, 0, 0, 0);
        weight_card.add(weight_val_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 5;
        weight_card.add(weight_to, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 6;
        weight_card.add(weight_res, gbConst);

        gbConst.gridx = 0;
        gbConst.gridy = 7;
        weight_card.add(proc_weight, gbConst);

        proc_weight.addActionListener(new action_weight_convert());
    }

//  Action listeners

    //    Menu bar items action listener
    class action_temp_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Temperature");
        }
    }

    class action_length_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Length");
        }
    }

    class action_curr_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Currency");
        }
    }

    class action_weight_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Weight");
        }
    }

    class action_colors_default_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cards.setBackground(DEFAULT_COLOR);
        }
    }

    class action_colors_crimson_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cards.setBackground(CRIMSON_COLOR);
        }
    }

    class action_colors_night_menu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cards.setBackground(NIGHT_COLOR);
        }
    }

    //    Weight button action listener
    class action_weight_convert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from_text = weight_from.getSelectedItem().toString();
            String to_text = weight_to.getSelectedItem().toString();
            Double from_number = Double.parseDouble(weight_val.getText());
            Double to_number = 0.0;
            String mode = from_text.concat(" " + to_text);

            switch (mode) {
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

    //    Length button action listener
    class action_length_convert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from_text = length_from.getSelectedItem().toString();
            String to_text = length_to.getSelectedItem().toString();
            Double from_number = Double.parseDouble(length_val.getText());
            Double to_number = 0.0;
            String mode = from_text.concat(" " + to_text);

            switch (mode) {
//                Meter
                case "M M":
                    to_number = length.m_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M CM":
                    to_number = length.m_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M MM":
                    to_number = length.m_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M Mile":
                    to_number = length.m_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M Yard":
                    to_number = length.m_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M Foot":
                    to_number = length.m_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "M Inch":
                    to_number = length.m_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//                CM
                case "CM M":
                    to_number = length.cm_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM CM":
                    to_number = length.cm_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM MM":
                    to_number = length.cm_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM Mile":
                    to_number = length.cm_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM Yard":
                    to_number = length.cm_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM Foot":
                    to_number = length.cm_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "CM Inch":
                    to_number = length.cm_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//                MM
                case "MM M":
                    to_number = length.mm_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM CM":
                    to_number = length.mm_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM MM":
                    to_number = length.mm_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM Mile":
                    to_number = length.mm_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM Yard":
                    to_number = length.mm_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM Foot":
                    to_number = length.mm_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "MM Inch":
                    to_number = length.mm_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//               Mile
                case "Mile M":
                    to_number = length.mile_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile CM":
                    to_number = length.mile_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile MM":
                    to_number = length.mile_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile Mile":
                    to_number = length.mile_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile Yard":
                    to_number = length.mile_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile Foot":
                    to_number = length.mile_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Mile Inch":
                    to_number = length.mile_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//               Yard
                case "Yard M":
                    to_number = length.yard_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard CM":
                    to_number = length.yard_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard MM":
                    to_number = length.yard_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard Mile":
                    to_number = length.yard_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard Yard":
                    to_number = length.yard_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard Foot":
                    to_number = length.yard_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Yard Inch":
                    to_number = length.yard_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//               Foot
                case "Foot M":
                    to_number = length.ft_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot CM":
                    to_number = length.ft_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot MM":
                    to_number = length.ft_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot Mile":
                    to_number = length.ft_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot Yard":
                    to_number = length.ft_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot Foot":
                    to_number = length.ft_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Foot Inch":
                    to_number = length.ft_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
//               Inch
                case "Inch M":
                    to_number = length.in_to_m(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch CM":
                    to_number = length.in_to_cm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch MM":
                    to_number = length.in_to_mm(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch Mile":
                    to_number = length.in_to_mile(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch Yard":
                    to_number = length.in_to_yard(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch Foot":
                    to_number = length.in_to_ft(from_number);
                    length_res.setText(to_number.toString());
                    break;
                case "Inch Inch":
                    to_number = length.in_to_in(from_number);
                    length_res.setText(to_number.toString());
                    break;
            }
        }
    }

    //    Temp button action listener
    class action_temp_convert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from_text = temp_from.getSelectedItem().toString();
            String to_text = temp_to.getSelectedItem().toString();
            Double from_number = Double.parseDouble(temps_val.getText());
            Double to_number = 0.0;
            String mode = from_text.concat(" " + to_text);

            switch (mode) {
//                Reamure
                case "Reamure Reamure":
                    temps_res.setText(from_number.toString());
                    break;
                case "Reamure Kelvin":
                    to_number = temps.reamur_to_kelvin(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Reamure Fahrenheit":
                    to_number = temps.reamur_to_fahrenheit(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Reamure Celcius":
                    to_number = temps.reamur_to_celcius(from_number);
                    temps_res.setText(to_number.toString());
                    break;
//                Kelvin
                case "Kelvin Reamure":
                    to_number = temps.kelvin_to_reamur(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Kelvin Kelvin":
                    temps_res.setText(from_number.toString());
                    break;
                case "Kelvin Fahrenheit":
                    to_number = temps.kelvin_to_fahrenheit(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Kelvin Celcius":
                    to_number = temps.kelvin_to_celcius(from_number);
                    temps_res.setText(to_number.toString());
                    break;
//                Fahrenheit
                case "Fahrenheit Reamure":
                    to_number = temps.fahrenheit_to_reamur(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Fahrenheit Kelvin":
                    to_number = temps.fahrenheit_to_kelvin(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Fahrenheit Fahrenheit":
                    temps_res.setText(from_number.toString());
                    break;
                case "Fahrenheit Celcius":
                    to_number = temps.fahrenheit_to_celcius(from_number);
                    temps_res.setText(to_number.toString());
                    break;
//                Celcius
                case "Celcius Reamure":
                    to_number = temps.celcius_to_reamur(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Celcius Kelvin":
                    to_number = temps.celcius_to_kelvin(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Celcius Fahrenheit":
                    to_number = temps.celcius_to_fahrenheit(from_number);
                    temps_res.setText(to_number.toString());
                    break;
                case "Celcius Celcius":
                    temps_res.setText(from_number.toString());
                    break;
            }

        }
    }

    //    Curr button action listener
    class action_curr_convert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from_text = curr_from.getSelectedItem().toString();
            String to_text = curr_to.getSelectedItem().toString();
            Double from_number = Double.parseDouble(curr_val.getText());
            Double to_number = 0.0;
            String mode = from_text.concat(" " + to_text);

            switch (mode) {
//                USD
                case "USD USD":
                    curr_res.setText(from_number.toString());
                    break;
                case "USD IDR":
                    to_number = curr.usd_to_idr(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "USD AUD":
                    to_number = curr.usd_to_aud(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "USD SGD":
                    to_number = curr.usd_to_sgd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
//                AUD
                case "AUD USD":
                    to_number = curr.aud_to_usd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "AUD IDR":
                    to_number = curr.aud_to_idr(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "AUD AUD":
                    curr_res.setText(from_number.toString());
                    break;
                case "AUD SGD":
                    to_number = curr.aud_to_sgd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
//               IDR
                case "IDR USD":
                    to_number = curr.idr_to_usd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "IDR IDR":
                    curr_res.setText(from_number.toString());
                    break;
                case "IDR AUD":
                    to_number = curr.idr_to_aud(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "IDR SGD":
                    to_number = curr.idr_to_sgd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
//               SGD
                case "SGD USD":
                    to_number = curr.sgd_to_usd(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "SGD IDR":
                    to_number = curr.sgd_to_idr(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "SGD AUD":
                    to_number = curr.sgd_to_aud(from_number);
                    curr_res.setText(to_number.toString());
                    break;
                case "SGD SGD":
                    curr_res.setText(from_number.toString());
                    break;
            }
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new converter_gui();
            }
        });
    }
}
