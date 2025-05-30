import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;


public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel; 
    private Member currentMember;
    private GolfCourse selectedCourse;
    private boolean isDrivingRangeBooking;
    private String selectedTime;
    private List<MenuItem> orderedFoodItems = new ArrayList<>();
    private double bookingFee = 0.0;
    private double foodTotal = 0.0;
    private double finalTotalPayment = 0.0;

    // Untuk mengelola waktu yang sudah dipesan per lapangan golf
    private Map<String, Set<String>> bookingSchedule = new HashMap<>();

    // Komponen GUI yang perlu diakses lintas panel
    private JTextField nameField, emailField, dateField;
    private JRadioButton vipYes, vipNo;
    private JComboBox<GolfCourse> golfCourseComboBox;
    private JRadioButton golfOption, rangeOption;
    private JComboBox<String> timeSlotComboBox;
    private JCheckBox orderFoodCheckBox;
    private JList<MenuItem> menuList;
    private DefaultListModel<MenuItem> menuListModel;
    private JTextArea orderedItemsArea;
    private JLabel bookingFeeLabel, foodTotalLabel, finalTotalLabel;
    private JRadioButton bankTransferOption, creditCardOption;
    private JTextField creditCardNumberField, expiryDateField, cvvField;

    private List<GolfCourse> golfCourses;
    private List<MenuItem> fullMenu;

    public MainFrame() {
        setTitle("Aplikasi Pemesanan GolfKacaw");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        cardLayout = new CardLayout();
        // Inisialisasi mainPanel sebagai BackgroundPanel
        mainPanel = new BackgroundPanel("https://drive.google.com/uc?export=download&id=192M_xfSP2hcqagJ_YyqKF0G0of6Z1TY2\r\n" + //
                        "");
        mainPanel.setLayout(cardLayout);
        add(mainPanel);

        initializeData();
        createPanels();

        cardLayout.show(mainPanel, "WelcomePanel");
    }

    private void initializeData() {
        golfCourses = new ArrayList<>();

        // Add sample golf courses with hole details and driving range bay count
        GolfCourse course1 = new GolfCourse("Bintan Lagoon Golf Club", "Bintan, Kepulauan Riau", 18, 1500000, 160000,
                20);
        course1.addHole(1, 400, 4);
        course1.addHole(2, 370, 3);
        course1.addHole(3, 450, 5);
        course1.addHole(4, 350, 4);
        course1.addHole(5, 420, 4);
        course1.addHole(6, 380, 3);
        course1.addHole(7, 490, 5);
        course1.addHole(8, 430, 4);
        course1.addHole(9, 370, 3);
        course1.addHole(10, 460, 4);
        course1.addHole(11, 420, 4);
        course1.addHole(12, 380, 4);
        course1.addHole(13, 400, 4);
        course1.addHole(14, 450, 5);
        course1.addHole(15, 370, 3);
        course1.addHole(16, 440, 4);
        course1.addHole(17, 420, 4);
        course1.addHole(18, 490, 5);
        course1.addFacility("Driving Range");
        course1.addFacility("Pro Shop");
        course1.addFacility("Shower");
        course1.addFacility("Changing Room");
        course1.addFacility("Golf Cart");
        golfCourses.add(course1);

        GolfCourse course2 = new GolfCourse("Riverside Golf Club", "Bogor, Jawa Barat", 18, 1800000, 175000, 15);
        course2.addHole(1, 450, 5);
        course2.addHole(2, 380, 4);
        course2.addHole(3, 400, 4);
        course2.addHole(4, 390, 4);
        course2.addHole(5, 420, 4);
        course2.addHole(6, 370, 3);
        course2.addHole(7, 450, 5);
        course2.addHole(8, 410, 4);
        course2.addHole(9, 380, 4);
        course2.addHole(10, 460, 4);
        course2.addHole(11, 420, 4);
        course2.addHole(12, 400, 4);
        course2.addHole(13, 390, 4);
        course2.addHole(14, 470, 5);
        course2.addHole(15, 380, 3);
        course2.addHole(16, 440, 4);
        course2.addHole(17, 430, 4);
        course2.addHole(18, 490, 5);
        course2.addFacility("Caddy Service");
        course2.addFacility("Restaurant");
        course2.addFacility("Shower");
        course2.addFacility("Golf Cart");
        golfCourses.add(course2);

        GolfCourse course3 = new GolfCourse("Sunset Ridge Golf Resort", "Bandung, Jawa Barat", 18, 1700000, 150000, 12);
        course3.addHole(1, 420, 4);
        course3.addHole(2, 360, 3);
        course3.addHole(3, 480, 5);
        course3.addHole(4, 430, 4);
        course3.addHole(5, 400, 4);
        course3.addHole(6, 380, 3);
        course3.addHole(7, 500, 5);
        course3.addHole(8, 450, 4);
        course3.addHole(9, 370, 3);
        course3.addHole(10, 470, 4);
        course3.addHole(11, 440, 4);
        course3.addHole(12, 400, 4);
        course3.addHole(13, 420, 4);
        course3.addHole(14, 460, 5);
        course3.addHole(15, 380, 3);
        course3.addHole(16, 430, 4);
        course3.addHole(17, 410, 4);
        course3.addHole(18, 490, 5);
        course3.addFacility("Caddy Service");
        course3.addFacility("Restaurant");
        course3.addFacility("Changing Room");
        course3.addFacility("Shower");
        course3.addFacility("Cart");
        course3.addFacility("Driving Range");
        golfCourses.add(course3);

        fullMenu = new ArrayList<>();
        fullMenu.add(new MenuItem("Nasi Goreng", 55000));
        fullMenu.add(new MenuItem("Mie Goreng", 65000));
        fullMenu.add(new MenuItem("Nasi Hainan", 75000));
        fullMenu.add(new MenuItem("Burger", 60000));
        fullMenu.add(new MenuItem("Es Teh", 40000));
        fullMenu.add(new MenuItem("Es Jeruk", 60000));
        fullMenu.add(new MenuItem("Air Mineral", 45000));
    }

    private void createPanels() {
        JPanel welcomePanel = createWelcomePanel();
        mainPanel.add(welcomePanel, "WelcomePanel");
        JPanel courseSelectionPanel = createCourseSelectionPanel();
        mainPanel.add(courseSelectionPanel, "CourseSelectionPanel");

        JPanel bookingDetailsPanel = createBookingDetailsPanel();
        mainPanel.add(bookingDetailsPanel, "BookingDetailsPanel");
        JPanel foodOrderingPanel = createFoodOrderingPanel();
        mainPanel.add(foodOrderingPanel, "FoodOrderingPanel");
        JPanel summaryPaymentPanel = createSummaryPaymentPanel();
        mainPanel.add(summaryPaymentPanel, "SummaryPaymentPanel");
        JPanel confirmationPanel = createConfirmationPanel();
        mainPanel.add(confirmationPanel, "ConfirmationPanel");
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Selamat Datang di GolfKacaw Booking!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(25, 25, 112)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Nama Anda:", SwingConstants.RIGHT);
        nameLabel.setForeground(new Color(25, 25, 112));
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email Anda:", SwingConstants.RIGHT);
        emailLabel.setForeground(new Color(25, 25, 112));
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel vipQuestionLabel = new JLabel("Apakah Anda anggota VIP?", SwingConstants.RIGHT);
        vipQuestionLabel.setForeground(new Color(25, 25, 112));
        panel.add(vipQuestionLabel, gbc);
        gbc.gridx = 1;
        JPanel vipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vipPanel.setOpaque(false); 
        vipYes = new JRadioButton("Ya");
        vipYes.setOpaque(false); 
        vipYes.setForeground(new Color(25, 25, 112));
        vipNo = new JRadioButton("Tidak");
        vipNo.setOpaque(false); 
        vipNo.setForeground(new Color(25, 25, 112));
        ButtonGroup vipGroup = new ButtonGroup();
        vipGroup.add(vipYes);
        vipGroup.add(vipNo);
        vipNo.setSelected(true); 
        vipPanel.add(vipYes);
        vipPanel.add(vipNo);
        panel.add(vipPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton nextButton = new JButton("Lanjutkan");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(new Color(25, 25, 112)); 
        nextButton.setForeground(Color.BLACK); 
        nextButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Email tidak boleh kosong.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (vipYes.isSelected()) {
                currentMember = new VIPMember(name, email, 0.2); 
            } else {
                currentMember = new Member(name, email);
            }
            cardLayout.show(mainPanel, "CourseSelectionPanel");
        });
        panel.add(nextButton, gbc);

        return panel;
    }

    private JPanel createCourseSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false); // Penting: Buat panel transparan agar background terlihat

        JLabel title = new JLabel("Pilih Lapangan Golf", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(25, 25, 112));
        panel.add(title, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false); // Penting: Buat panel transparan
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel selectCourseLabel = new JLabel("Pilih Lapangan:");
        selectCourseLabel.setForeground(new Color(25, 25, 112));
        contentPanel.add(selectCourseLabel, gbc);

        gbc.gridx = 1;
        golfCourseComboBox = new JComboBox<>(golfCourses.toArray(new GolfCourse[0]));
        golfCourseComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPanel.add(golfCourseComboBox, gbc);

        JTextArea courseDetailsArea = new JTextArea(10, 40);
        courseDetailsArea.setEditable(false);
        courseDetailsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        courseDetailsArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        courseDetailsArea.setOpaque(false); 
        courseDetailsArea.setForeground(new Color(25, 25, 112));
        JScrollPane scrollPane = new JScrollPane(courseDetailsArea);
        scrollPane.setOpaque(false); 
        scrollPane.getViewport().setOpaque(false); 

        golfCourseComboBox.addActionListener(e -> {
            selectedCourse = (GolfCourse) golfCourseComboBox.getSelectedItem();
            if (selectedCourse != null) {
                StringBuilder details = new StringBuilder();
                details.append("Nama: ").append(selectedCourse.getName()).append("\n");
                details.append("Lokasi: ").append(selectedCourse.getLocation()).append("\n");
                details.append("Jumlah Hole: ").append(selectedCourse.getHoles()).append("\n");
                details.append("Harga Lapangan Golf: Rp")
                        .append(String.format("%,.0f", selectedCourse.getCoursePrice())).append("\n");
                details.append("Harga Driving Range: Rp")
                        .append(String.format("%,.0f", selectedCourse.getDrivingRangePrice())).append("\n");
                details.append("Jumlah Bay Driving Range: ").append(selectedCourse.getDrivingRangeBays()).append("\n");
                details.append("Fasilitas: ").append(String.join(", ", selectedCourse.getFacilities())).append("\n\n");
                details.append("Detail Hole:\n");
                for (Hole hole : selectedCourse.getHoleList()) {
                    details.append(String.format("  Hole %d: Jarak %d m, Par %d\n",
                            hole.getHoleNumber(), hole.getDistance(), hole.getPar()));
                }
                courseDetailsArea.setText(details.toString());
            } else {
                courseDetailsArea.setText("");
            }
        });
        
        if (!golfCourses.isEmpty()) {
            golfCourseComboBox.setSelectedIndex(0);
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPanel.add(scrollPane, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); 
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setForeground(Color.BLACK); 
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "WelcomePanel"));
        buttonPanel.add(backButton);

        JButton nextButton = new JButton("Lanjutkan");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(25, 25, 112));
        nextButton.setForeground(Color.BLACK); 
        nextButton.addActionListener(e -> {
            if (selectedCourse == null) {
                JOptionPane.showMessageDialog(this, "Silakan pilih lapangan golf.", "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            cardLayout.show(mainPanel, "BookingDetailsPanel");
            updateBookingDetailsPanel(); 
        });
        buttonPanel.add(nextButton);

        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookingDetailsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel title = new JLabel("Detail Pemesanan", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        JLabel activityLabel = new JLabel("Aktivitas:", SwingConstants.RIGHT);
        activityLabel.setForeground(new Color(25, 25, 112));
        panel.add(activityLabel, gbc);
        gbc.gridx = 1;
        JPanel activityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        activityPanel.setOpaque(false);
        golfOption = new JRadioButton("Turun Lapangan");
        golfOption.setOpaque(false);
        golfOption.setForeground(new Color(25, 25, 112));
        rangeOption = new JRadioButton("Driving Range");
        rangeOption.setOpaque(false);
        rangeOption.setForeground(new Color(25, 25, 112));
        ButtonGroup activityGroup = new ButtonGroup();
        activityGroup.add(golfOption);
        activityGroup.add(rangeOption);
        golfOption.setSelected(true); 
        activityPanel.add(golfOption);
        activityPanel.add(rangeOption);
        panel.add(activityPanel, gbc);

        ActionListener activityListener = e -> updateBookingFeeDisplay();
        golfOption.addActionListener(activityListener);
        rangeOption.addActionListener(activityListener);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel dateLabel = new JLabel("Tanggal (DD-MM-YYYY):", SwingConstants.RIGHT);
        dateLabel.setForeground(new Color(25, 25, 112));
        panel.add(dateLabel, gbc);
        gbc.gridx = 1;
        dateField = new JTextField(20);
        panel.add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel timeLabel = new JLabel("Pilih Waktu:", SwingConstants.RIGHT);
        timeLabel.setForeground(new Color(25, 25, 112));
        panel.add(timeLabel, gbc);
        gbc.gridx = 1;
        timeSlotComboBox = new JComboBox<>();
        timeSlotComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(timeSlotComboBox, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); 
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setForeground(Color.BLACK); 
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "CourseSelectionPanel"));
        buttonPanel.add(backButton);

        JButton nextButton = new JButton("Lanjutkan");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(25, 25, 112));
        nextButton.setForeground(Color.BLACK); 
        nextButton.addActionListener(e -> {
            if (dateField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (timeSlotComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Silakan pilih waktu booking.", "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            selectedTime = (String) timeSlotComboBox.getSelectedItem();
            isDrivingRangeBooking = rangeOption.isSelected();

            //Waktu pesan
            bookingSchedule.computeIfAbsent(selectedCourse.getName(), k -> new HashSet<>()).add(selectedTime);

            cardLayout.show(mainPanel, "FoodOrderingPanel");
            updateFoodOrderingPanel();
        });
        buttonPanel.add(nextButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        return panel;
    }

    private void updateBookingDetailsPanel() {
        timeSlotComboBox.removeAllItems();
        String[] timeSlots = { "07:00", "08:30", "10:00", "11:30", "13:00", "14:30" };
        Set<String> bookedTimesForCourse = bookingSchedule.getOrDefault(selectedCourse.getName(), new HashSet<>());

        for (String slot : timeSlots) {
            if (!bookedTimesForCourse.contains(slot)) {
                timeSlotComboBox.addItem(slot);
            }
        }

        if (timeSlotComboBox.getItemCount() == 0) {
            timeSlotComboBox.addItem("Tidak ada waktu tersedia");
            timeSlotComboBox.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Maaf, tidak ada waktu booking yang tersedia untuk lapangan ini.",
                    "Penuh", JOptionPane.INFORMATION_MESSAGE);
        } else {
            timeSlotComboBox.setEnabled(true);
        }

        updateBookingFeeDisplay();
    }

    private void updateBookingFeeDisplay() {
        if (selectedCourse != null) {
            if (golfOption.isSelected()) {
                bookingFee = selectedCourse.getCoursePrice();
            } else {
                bookingFee = selectedCourse.getDrivingRangePrice();
            }
        }
    }

    private JPanel createFoodOrderingPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false); 

        JLabel title = new JLabel("Pesan Makanan & Minuman", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(25, 25, 112));
        panel.add(title, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        orderFoodCheckBox = new JCheckBox("Saya ingin memesan makanan/minuman");
        orderFoodCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
        orderFoodCheckBox.setOpaque(false); 
        orderFoodCheckBox.setForeground(new Color(25, 25, 112));
        contentPanel.add(orderFoodCheckBox, gbc);

        gbc.gridy++;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        menuListModel = new DefaultListModel<>();
        for (MenuItem item : fullMenu) {
            menuListModel.addElement(item);
        }
        menuList = new JList<>(menuListModel);
        menuList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        menuList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        menuList.setOpaque(false); 
        menuList.setForeground(new Color(25, 25, 112));
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        menuScrollPane.setPreferredSize(new Dimension(300, 200));
        menuScrollPane.setOpaque(false); 
        menuScrollPane.getViewport().setOpaque(false); 
        contentPanel.add(menuScrollPane, gbc);

        gbc.gridy++;
        JButton addFoodButton = new JButton("Tambahkan ke Pesanan");
        addFoodButton.setFont(new Font("Arial", Font.BOLD, 14));
        addFoodButton.setBackground(new Color(25, 25, 112));
        addFoodButton.setForeground(Color.BLACK); 
        addFoodButton.addActionListener(e -> {
            List<MenuItem> selected = menuList.getSelectedValuesList();
            if (selected.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih item yang ingin ditambahkan.", "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            for (MenuItem item : selected) {
                orderedFoodItems.add(item);
            }
            updateOrderedItemsDisplay();
        });
        contentPanel.add(addFoodButton, gbc);

        gbc.gridy++;
        JLabel orderedItemsLabel = new JLabel("Pesanan Anda:");
        orderedItemsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        orderedItemsLabel.setForeground(new Color(25, 25, 112));
        contentPanel.add(orderedItemsLabel, gbc);

        gbc.gridy++;
        orderedItemsArea = new JTextArea(5, 30);
        orderedItemsArea.setEditable(false);
        orderedItemsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        orderedItemsArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        orderedItemsArea.setOpaque(false); 
        orderedItemsArea.setForeground(new Color(25, 25, 112));
        JScrollPane orderedItemsScrollPane = new JScrollPane(orderedItemsArea);
        orderedItemsScrollPane.setOpaque(false); 
        orderedItemsScrollPane.getViewport().setOpaque(false); 
        contentPanel.add(orderedItemsScrollPane, gbc);

        // Enable/disable menu list
        orderFoodCheckBox.addActionListener(e -> {
            boolean selected = orderFoodCheckBox.isSelected();
            menuList.setEnabled(selected);
            addFoodButton.setEnabled(selected);
            if (!selected) {
                orderedFoodItems.clear();
                updateOrderedItemsDisplay();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); 
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setForeground(Color.BLACK); 
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "BookingDetailsPanel"));
        buttonPanel.add(backButton);

        JButton nextButton = new JButton("Lanjutkan ke Pembayaran");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(25, 25, 112));
        nextButton.setForeground(Color.BLACK); 
        nextButton.addActionListener(e -> {
            calculateFoodTotal();
            cardLayout.show(mainPanel, "SummaryPaymentPanel");
            updateSummaryPaymentPanel();
        });
        buttonPanel.add(nextButton);

        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void updateFoodOrderingPanel() {
        orderFoodCheckBox.setSelected(false);
        menuList.setEnabled(false);
        orderedFoodItems.clear();
        updateOrderedItemsDisplay();
    }

    private void updateOrderedItemsDisplay() {
        StringBuilder sb = new StringBuilder();
        foodTotal = 0.0;
        if (orderedFoodItems.isEmpty()) {
            sb.append("Belum ada item yang dipesan.");
        } else {
            for (MenuItem item : orderedFoodItems) {
                sb.append("- ").append(item.getName()).append(" (Rp").append(String.format("%,.0f", item.getPrice()))
                        .append(")\n");
                foodTotal += item.getPrice();
            }
        }
        orderedItemsArea.setText(sb.toString());
    }

    private void calculateFoodTotal() {
        foodTotal = 0.0;
        if (orderFoodCheckBox.isSelected()) {
            for (MenuItem item : orderedFoodItems) {
                foodTotal += item.getPrice();
            }
        }
    }

    private JPanel createSummaryPaymentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel title = new JLabel("Ringkasan & Pembayaran", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Summary
        gbc.gridy++;
        JLabel summaryTitle = new JLabel("Ringkasan Pesanan Anda:", SwingConstants.LEFT);
        summaryTitle.setFont(new Font("Arial", Font.BOLD, 18));
        summaryTitle.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
         gbc.gridwidth = 2; // Agar judul tetap lebar penuh
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(summaryTitle, gbc);

         gbc.gridwidth = 1; // Kembali ke 1 kolom untuk label dan nilai
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        gbc.gridy++;
        JLabel courseLabel = new JLabel("Lapangan Golf:", SwingConstants.RIGHT);
        courseLabel.setForeground(new Color(25, 25, 112));
        panel.add(courseLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        JLabel courseNameLabel = new JLabel();
        courseNameLabel.setForeground(new Color(25, 25, 112));
        panel.add(courseNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        JLabel activityLabel = new JLabel("Aktivitas:", SwingConstants.RIGHT);
        activityLabel.setForeground(new Color(25, 25, 112));
        panel.add(activityLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        JLabel activityValueLabel = new JLabel();
        activityValueLabel.setForeground(new Color(25, 25, 112));
        panel.add(activityValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        JLabel timeBookingLabel = new JLabel("Waktu Booking:", SwingConstants.RIGHT);
        timeBookingLabel.setForeground(new Color(25, 25, 112));
        panel.add(timeBookingLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        JLabel timeValueLabel = new JLabel();
        timeValueLabel.setForeground(new Color(25, 25, 112));
        panel.add(timeValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        JLabel bookingFeeTextLabel = new JLabel("Biaya Booking:", SwingConstants.RIGHT);
        bookingFeeTextLabel.setForeground(new Color(25, 25, 112));
        panel.add(bookingFeeTextLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        bookingFeeLabel = new JLabel();
        bookingFeeLabel.setForeground(new Color(25, 25, 112));
        panel.add(bookingFeeLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        JLabel foodTotalTextLabel = new JLabel("Total Makanan/Minuman:", SwingConstants.RIGHT);
        foodTotalTextLabel.setForeground(new Color(25, 25, 112));
        panel.add(foodTotalTextLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        foodTotalLabel = new JLabel();
        foodTotalLabel.setForeground(new Color(25, 25, 112));
        panel.add(foodTotalLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
         gbc.anchor = GridBagConstraints.EAST; // Label rata kanan
        JLabel finalTotalTextLabel = new JLabel("Total Pembayaran:", SwingConstants.RIGHT);
        finalTotalTextLabel.setForeground(new Color(25, 25, 112));
        panel.add(finalTotalTextLabel, gbc);
        gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST; // Nilai rata kiri
        finalTotalLabel = new JLabel();
        finalTotalLabel.setFont(new Font("Arial", Font.BOLD, 16));
         finalTotalLabel.setForeground(new Color(0, 128, 0)); // Dark Green
        panel.add(finalTotalLabel, gbc);

        // Payment Method Section
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel paymentTitle = new JLabel("Pilih Metode Pembayaran:", SwingConstants.LEFT);
        paymentTitle.setFont(new Font("Arial", Font.BOLD, 18));
        paymentTitle.setForeground(new Color(25, 25, 112));
        panel.add(paymentTitle, gbc);

        gbc.gridy++;
        JPanel paymentMethodPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentMethodPanel.setOpaque(false); 
        bankTransferOption = new JRadioButton("Bank Transfer");
        bankTransferOption.setOpaque(false);
        bankTransferOption.setForeground(new Color(25, 25, 112));
        creditCardOption = new JRadioButton("Credit Card");
        creditCardOption.setOpaque(false);
        creditCardOption.setForeground(new Color(25, 25, 112));
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(bankTransferOption);
        paymentGroup.add(creditCardOption);
        bankTransferOption.setSelected(true); 
        paymentMethodPanel.add(bankTransferOption);
        paymentMethodPanel.add(creditCardOption);
        panel.add(paymentMethodPanel, gbc);

        // Credit Card Details
        JPanel creditCardDetailsPanel = new JPanel(new GridBagLayout());
        creditCardDetailsPanel.setOpaque(false); 
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(creditCardDetailsPanel, gbc); 

        GridBagConstraints ccGbc = new GridBagConstraints();
        ccGbc.insets = new Insets(5, 5, 5, 5);
        ccGbc.fill = GridBagConstraints.HORIZONTAL;
        ccGbc.anchor = GridBagConstraints.WEST;

        ccGbc.gridx = 0;
        ccGbc.gridy = 0;
        JLabel ccNumberLabel = new JLabel("Nomor Kartu Kredit:");
        ccNumberLabel.setForeground(new Color(25, 25, 112));
        creditCardDetailsPanel.add(ccNumberLabel, ccGbc);
        ccGbc.gridx = 1;
        creditCardNumberField = new JTextField(20);
        creditCardNumberField.setEditable(true);
        creditCardNumberField.setFocusable(true);
        creditCardDetailsPanel.add(creditCardNumberField, ccGbc);

        ccGbc.gridx = 0;
        ccGbc.gridy = 1;
        JLabel expiryLabel = new JLabel("Tanggal Kadaluarsa (MM/YY):");
        expiryLabel.setForeground(new Color(25, 25, 112));
        creditCardDetailsPanel.add(expiryLabel, ccGbc);
        ccGbc.gridx = 1;
        expiryDateField = new JTextField(10);
        expiryDateField.setEditable(true); 
        expiryDateField.setFocusable(true); 
        creditCardDetailsPanel.add(expiryDateField, ccGbc);

        ccGbc.gridx = 0;
        ccGbc.gridy = 2;
        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setForeground(new Color(25, 25, 112));
        creditCardDetailsPanel.add(cvvLabel, ccGbc);
        ccGbc.gridx = 1;
        cvvField = new JPasswordField(5); 
        cvvField.setEditable(true); 
        cvvField.setFocusable(true);
        creditCardDetailsPanel.add(cvvField, ccGbc);

        creditCardDetailsPanel.setVisible(false); 

        ActionListener paymentMethodListener = e -> {
            creditCardDetailsPanel.setVisible(creditCardOption.isSelected());
            if (creditCardOption.isSelected()) {
                SwingUtilities.invokeLater(() -> { 
                    creditCardNumberField.requestFocusInWindow();
                });
            }
            panel.revalidate(); 
            panel.repaint(); 
        };
        bankTransferOption.addActionListener(paymentMethodListener);
        creditCardOption.addActionListener(paymentMethodListener);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); 
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setForeground(Color.BLACK); 
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "FoodOrderingPanel"));
        buttonPanel.add(backButton);

        JButton payButton = new JButton("Bayar Sekarang");
        payButton.setFont(new Font("Arial", Font.BOLD, 14));
        payButton.setBackground(new Color(25, 25, 112)); 
        payButton.setForeground(Color.BLACK); 
        payButton.addActionListener(e -> processPayment());
        buttonPanel.add(payButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        return panel;
    }

    private void updateSummaryPaymentPanel() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setMinimumFractionDigits(0); 

        finalTotalPayment = bookingFee + foodTotal;
        if (currentMember instanceof VIPMember) {
            double originalTotal = finalTotalPayment;
            finalTotalPayment = currentMember.calculateTotal(originalTotal);
            JOptionPane.showMessageDialog(this,
                    String.format(
                            "Anda adalah anggota VIP! Diskon 20%% diterapkan.\nTotal Awal: %s\nTotal Setelah Diskon: %s",
                            currencyFormat.format(originalTotal), currencyFormat.format(finalTotalPayment)),
                    "Diskon VIP", JOptionPane.INFORMATION_MESSAGE);
        }

        ((JLabel) ((JPanel) mainPanel.getComponent(4)).getComponent(3)).setText(selectedCourse.getName());
        ((JLabel) ((JPanel) mainPanel.getComponent(4)).getComponent(5))
                .setText(isDrivingRangeBooking ? "Driving Range" : "Bermain Golf"); 
        ((JLabel) ((JPanel) mainPanel.getComponent(4)).getComponent(7)).setText(selectedTime); 
        bookingFeeLabel.setText(currencyFormat.format(bookingFee));
        foodTotalLabel.setText(currencyFormat.format(foodTotal));
        finalTotalLabel.setText(currencyFormat.format(finalTotalPayment));
    }

    private void processPayment() {
        PaymentMethod payment;
        if (bankTransferOption.isSelected()) {
            payment = new BankTransferPayment("7380870481"); 
            payment.pay(finalTotalPayment);
            JOptionPane.showMessageDialog(this,
                    "Pembayaran berhasil diproses melalui Bank Transfer.\n" +
                            "Silakan transfer jumlah ke rekening:\n" +
                            "Bank: Bank Central Asia (BCA)\n" +
                            "Nomor Rekening: 7380870481\n" +
                            "Nama Rekening: PT GolfKacaw\n\n" +
                            "Pembayaran akan otomatis terkonfirmasi setelah Anda melakukan pembayaran!",
                    "Pembayaran Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } else if (creditCardOption.isSelected()) {
            String cardNumber = creditCardNumberField.getText().trim();
            String expiry = expiryDateField.getText().trim();
            String cvv = cvvField.getText().trim();

            if (cardNumber.isEmpty() || expiry.isEmpty() || cvv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mohon lengkapi detail kartu kredit.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            //validation
            if (!cardNumber.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(this, "Nomor Kartu Kredit tidak valid (harus 16 digit angka).",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!expiry.matches("\\d{2}/\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Format Tanggal Kadaluarsa tidak valid (MM/YY).", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!cvv.matches("\\d{3,4}")) {
                JOptionPane.showMessageDialog(this, "CVV tidak valid (3 atau 4 digit angka).", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            payment = new CreditCardPayment(cardNumber);
            payment.pay(finalTotalPayment);
            JOptionPane.showMessageDialog(this,
                    "Pembayaran berhasil diproses melalui Kartu Kredit.",
                    "Pembayaran Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih metode pembayaran.", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // After successful payment
        cardLayout.show(mainPanel, "ConfirmationPanel");
        updateConfirmationPanel();
    }

    private JPanel createConfirmationPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel thankYouLabel = new JLabel("Terima Kasih atas Pemesanan Anda!", SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 28));
        thankYouLabel.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(thankYouLabel, gbc);

        gbc.gridy++;
        JLabel memberNameConfirmation = new JLabel("", SwingConstants.CENTER);
        memberNameConfirmation.setFont(new Font("Arial", Font.PLAIN, 18));
        memberNameConfirmation.setForeground(new Color(25, 25, 112));
        panel.add(memberNameConfirmation, gbc);

        gbc.gridy++;
        JLabel bookingDetailsConfirmation = new JLabel("", SwingConstants.CENTER);
        bookingDetailsConfirmation.setFont(new Font("Arial", Font.PLAIN, 16));
        bookingDetailsConfirmation.setForeground(new Color(25, 25, 112));
        panel.add(bookingDetailsConfirmation, gbc);

        gbc.gridy++;
        JLabel totalPaidConfirmation = new JLabel("", SwingConstants.CENTER);
        totalPaidConfirmation.setFont(new Font("Arial", Font.BOLD, 20));
        totalPaidConfirmation.setForeground(new Color(25, 25, 112));
        panel.add(totalPaidConfirmation, gbc);

        gbc.gridy++;
        JButton newBookingButton = new JButton("Buat Pemesanan Baru");
        newBookingButton.setFont(new Font("Arial", Font.BOLD, 16));
        newBookingButton.setBackground(new Color(60, 179, 113));
        newBookingButton.setForeground(Color.RED); 
        newBookingButton.addActionListener(e -> resetApplication());
        panel.add(newBookingButton, gbc);

        return panel;
    }

    private void updateConfirmationPanel() {
        JLabel memberNameConfirmation = (JLabel) ((JPanel) mainPanel.getComponent(5)).getComponent(1);
        JLabel bookingDetailsConfirmation = (JLabel) ((JPanel) mainPanel.getComponent(5)).getComponent(2);
        JLabel totalPaidConfirmation = (JLabel) ((JPanel) mainPanel.getComponent(5)).getComponent(3);

        memberNameConfirmation.setText("Mr/Ms " + currentMember.getName());
        bookingDetailsConfirmation.setText(String.format("Anda telah memesan %s untuk %s pada pukul %s.",
                isDrivingRangeBooking ? "Driving Range" : selectedCourse.getName(),
                dateField.getText(), selectedTime));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setMinimumFractionDigits(0);
        totalPaidConfirmation.setText("Total Pembayaran: " + currencyFormat.format(finalTotalPayment));
    }

    private void resetApplication() {
        nameField.setText("");
        emailField.setText("");
        vipNo.setSelected(true);
        golfCourseComboBox.setSelectedIndex(0);
        golfOption.setSelected(true);
        dateField.setText("27-05-2025"); 
        timeSlotComboBox.removeAllItems(); 
        orderFoodCheckBox.setSelected(false);
        orderedFoodItems.clear();
        orderedItemsArea.setText("Belum ada item yang dipesan.");
        bankTransferOption.setSelected(true);
        creditCardNumberField.setText("");
        expiryDateField.setText("");
        cvvField.setText("");
        ((JPanel) mainPanel.getComponent(4)).getComponent(10).setVisible(false); // Hide CC details
        bookingSchedule.clear(); 

        cardLayout.show(mainPanel, "WelcomePanel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
