package ui;

import catalogs.CarCatalogue;
import catalogs.OwnerCatalog;
import catalogs.ServiceCatalog;
import models.Car;
import models.Owner;
import models.ServiceRecord;
import org.apache.commons.io.FileUtils;
import utils.RegexValidationPattern;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class CarGUI extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel mainJPanel;
    private JPanel createCarPanelView;
    private JPanel createOwnerPanelView;
    private JPanel viewCarPanelView;
    private JPanel viewOwnersPanelView;
    private JPanel serviceRecordsPanelView;
    private JTextField brandFieldTextField;
    private JTextField modelTextField;
    private JTextField engineNumberTextField;
    private JTextField seatsNumberTextField;
    private JTextField colourTextField;
    private JTextField licensePlateTextField;
    private JTextField ownerNameTextField;
    private JTextField mobileNumber1TextField;
    private JTextField driverLicenseTextField;
    private JTextField emailAddressTextField;
    private JTextField ssnTextField;
    private JButton submitButton;
    private JButton clearButtonField;
    private JTable ownersListTable;
    private JTextField textField13;
    private JButton searchByModel;
    private JLabel ownerNameField;
    private JTextField mobileNumber2TextField;
    private JLabel driversLicenseLabel;
    private JLabel ssnLabel;
    private JLabel emailAddressLabel;
    private JLabel addressLabel;
    private JTextField addressTextField;
    private JTable carTable;
    private JLabel brandLabelField;
    private JLabel modelFieldLabel;
    private JLabel engineNumberLabel;
    private JLabel seatsNumberLabel;
    private JLabel colorLabelField;
    private JLabel recentLicensePlateLabel;
    private JLabel ownerLabelField;
    private JComboBox<String> ownerComboBoxField;
    private JLabel yarFieldLabel;
    private JTextField yearTextField;
    private JLabel recentServiceRecordLabelField;
    private JLabel warrantyYearsLabelField;
    private JFormattedTextField warrantyYearsTextField;
    private JButton attachImageButton;
    private JButton saveButtonField;
    private JButton cancelButtonField;
    private JPanel jPanelImageView;
    private JLabel imageLabel;
    private JTable carsListTable;
    private JScrollPane carTableScrollPane;
    private JPanel createServiceRecordsPanel;
    private JTextField serviceRecordModelTextField;
    private JTextField ownerNameServiceRecordTextField;
    private JTextField engineNumberServiceRecordTextField;
    private JTextField licenseNumberServiceRecordTextField;
    private JTextField searchEngineServiceRecordTextField;
    private JLabel searchLabelField;
    private JLabel carServiceModelLabel;
    private JLabel carEngineNumberServiceLabel;
    private JLabel serviceRecordsOwnerNameLabel;
    private JLabel carLicenseNumberServiceRecordLabel;
    private JLabel servieRecordDateLabel;
    private JLabel serviceCoveredServiceRecordLabel;
    private JTextArea serviceCoveredServiceRecordTextArea;
    private JButton saveServiceRecordButton;
    private JButton serviceRecordsClearButton;
    private JButton serviceRecordSearchButton;
    private JButton searchEngineClearbutton;
    private JTextField currentDateServiceRecordTextField;
    private JTable viewServiceRecordsTable;
    private JButton getAllServiceRecordsButton;
    private JButton viewServiceRecordsButton;

    private final JFileChooser openFileChooser;
    private BufferedImage originalBI;

    private RegexValidationPattern regexValidationPattern = new RegexValidationPattern();
    private static OwnerCatalog ownerCatalog;
    private static CarCatalogue carCatalogue;
    private static ServiceCatalog serviceCatalog;

    private String imageFilePath;
    private String privateImageFileCompletePath;


    public CarGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainJPanel);
        this.pack();
        ownerCatalog = new OwnerCatalog();
        carCatalogue = new CarCatalogue();
        serviceCatalog = new ServiceCatalog();

        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File(""));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("JPG images", "jpg"));


        createTable();


        createCarPanelView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);

                getOwnersComboBox();

            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Owner owner = new Owner();


                String ownerName = ownerNameTextField.getText();
                Long driversLicense = Long.valueOf(driverLicenseTextField.getText());
                Long ssn = Long.valueOf(ssnTextField.getText());
                String emailAddress = emailAddressTextField.getText();
                String address = addressTextField.getText();
                String mobileNumber1 = mobileNumber1TextField.getText();
                String mobileNumber2 = mobileNumber2TextField.getText();
                List<Long> mobileNumbers = new ArrayList<Long>();




//          Mobile Regex Check
                if(mobileNumber1.length() > 0 && regexValidationPattern.validatePhoneNumber(mobileNumber1)){
                    mobileNumbers.add(Long.valueOf(mobileNumber1));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Faulty Mobile Number 1");
                    throw new RuntimeException("Faulty Mobile Number 1");
                }

                if(mobileNumber2.length() > 0){
                    if(regexValidationPattern.validatePhoneNumber(mobileNumber2)){
                        mobileNumbers.add(Long.valueOf(mobileNumber2));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Give valid 2nd phone number");
                        throw new RuntimeException("Faulty Mobile Number 2");
                    }
                }

                if(!regexValidationPattern.validateEmail(emailAddress)){
                    JOptionPane.showMessageDialog(null, "Give valid email address");
                    throw new RuntimeException("Faulty Regex");
                }

                owner.setName(ownerName);
                owner.setLicenceNumber(driversLicense);
                owner.setEmailAddress(emailAddress);
                owner.setSocialSecurityNumber(ssn);
                owner.setAddress(address);
                owner.setTelephoneNumbers(mobileNumbers);

                ownerCatalog.addOwner(owner);
                getOwnersComboBox();

            }
        });
        clearButtonField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ownerNameTextField.setText("");
                driverLicenseTextField.setText("");
                ssnTextField.setText("");
//                seatNumbersTextField.setText("");
                addressTextField.setText("");
                mobileNumber1TextField.setText("");
                mobileNumber2TextField.setText("");
                emailAddressTextField.setText("");

            }
        });
        viewOwnersPanelView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                createTable();
            }
        });

        attachImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openFileButtonActionPerformed(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
//        After clicking save button, save the image to some location
        saveButtonField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saveCarField(e);

            }
        });
        viewCarPanelView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                createCarTable();
            }
        });

        createCarPanelView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });

        serviceRecordSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getEngineNumber = searchEngineServiceRecordTextField.getText();

                Car car = carCatalogue.searchCarFromList(Long.valueOf(getEngineNumber));

                if(car==null){
                    throw new RuntimeException("Car not found!!");
                }

                String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

                serviceRecordModelTextField.setText(car.getModel());
                engineNumberServiceRecordTextField.setText(car.getEngineNumber()+"");
                ownerNameServiceRecordTextField.setText(car.getOwner().getName());
                licenseNumberServiceRecordTextField.setText(car.getLicensePlate());
                currentDateServiceRecordTextField.setText(currentDate);



            }
        });
        searchEngineClearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEngineServiceRecordTextField.setText("");
            }
        });
        saveServiceRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String engineNumber = engineNumberServiceRecordTextField.getText();

                Car car = carCatalogue.searchCarFromList(Long.valueOf(engineNumber));

                if(car==null){
                    throw new RuntimeException("Car not found!!");
                }

                String description = serviceCoveredServiceRecordTextArea.getText();
                String currentDate = currentDateServiceRecordTextField.getText();

                ServiceRecord serviceRecord = new ServiceRecord();

                serviceRecord.setCar(car);
                serviceRecord.setTime(currentDate);
                serviceRecord.setDescription(description);

                serviceCatalog.addServiceRecordLabel(serviceRecord);


            }
        });
        serviceRecordsClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviceRecordModelTextField.setText("");
                engineNumberServiceRecordTextField.setText("");
                ownerNameServiceRecordTextField.setText("");
                licenseNumberServiceRecordTextField.setText("");
                currentDateServiceRecordTextField.setText("");
                serviceRecordsClearButton.setText("");
            }
        });
        getAllServiceRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllServiceRecords();
            }
        });
    }

    public void getAllServiceRecords(){
        String[][] theData = getAllServiceRecordsData();
        DefaultTableModel defaultTableModel = new DefaultTableModel(theData, new String[]{"Car Modal", "Car Engine Number", "Car Owner", "Date", "Description"});
        viewServiceRecordsTable.setModel(defaultTableModel);
    }

    public String[][] getAllServiceRecordsData(){
        List<ServiceRecord> serviceRecordsList = serviceCatalog.getAllServiceRecords();
        String[][] serviceRecords = new String[serviceRecordsList.size()][5];
        for(int i = 0; i < serviceRecordsList.size(); i++){
            ServiceRecord serviceRecord = serviceRecordsList.get(i);
            String[] eachService = {serviceRecord.getCar().getModel(), serviceRecord.getCar().getEngineNumber()+"", serviceRecord.getCar().getOwner().getName(), serviceRecord.getTime(), serviceRecord.getDescription()};
            serviceRecords[i] = eachService;
        }
        return serviceRecords;
    }

    public void getOwnersComboBox(){
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();

        List<Owner> theOwnersList = ownerCatalog.getAllOwnersList();

        for(Owner o: theOwnersList){
            defaultComboBoxModel.addElement(o.getName());
        }
        ownerComboBoxField.setModel(defaultComboBoxModel);
    }

    public void saveCarField(ActionEvent e){

        Car car = new Car();
        String brand = brandFieldTextField.getText();
        String model = modelTextField.getText();
        String colour = colourTextField.getText();
        String seatsNumber = seatsNumberTextField.getText();
        String licensePlate = licensePlateTextField.getText();
        String year = yearTextField.getText();
        String warrantyYears = warrantyYearsTextField.getText();
        String engineNumber = engineNumberTextField.getText();
        String ownerString = ownerComboBoxField.getSelectedItem().toString();

        Owner foundOwner = ownerCatalog.searchOwner(ownerString);

        if(foundOwner == null){
            throw new RuntimeException("Owner Not found");
        }



        String imageFilePath = this.privateImageFileCompletePath;

        car.setBrand(brand);
        car.setModel(model);
        car.setColour(colour);
        car.setSeatsNumber(Integer.parseInt(seatsNumber));
        car.setLicensePlate(licensePlate);
        car.setYear(year);
        car.setWarrantyYears(Integer.parseInt(warrantyYears));
        car.setImageFilePathUrl(imageFilePath);
        car.setEngineNumber(Long.valueOf(engineNumber));
        car.setOwner(foundOwner);

        carCatalogue.createCar(car);


    }

    public void createTable(){
        String[][] theData = getOwnersData();
        ownersListTable.setModel(new DefaultTableModel(theData, new String[]{"Owner Name", "Email", "Address", "Driver's License Number", "Telephone Numbers"}));
    }

    public void createCarTable(){

        ImageIcon imageIcon = new ImageIcon(privateImageFileCompletePath);
        Image theImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(theImage);

//        Object[][] theData = {{newImageIcon, "Honda", "City", "Black", "2015", "123123123123", "MASS123", "4", "2"}};

        Object[][] theData = getCarsList();

//        Method to display image
        DefaultTableModel model = new DefaultTableModel(theData, new String[]{"Car Image","Owner Name", "Brand", "Model", "Colour", "Year", "Engine Number", "License Number", "Seats Number", "Warranty"}){
            @Override
            public Class<?> getColumnClass(int column){
                if(column == 0) return ImageIcon.class;
                return Object.class;
            }
        };

        carsListTable.setModel(model);
        carsListTable.setRowHeight(100);

//        carsListTable.setModel(new DefaultTableModel(theData, new String[]{"Car Image", "Brand", "Model", "Colour", "Year", "Engine Number", "License Number", "Seats Number", "Warranty"}));
//        DefaultTableModel defaultTableModel = new DefaultTableModel(theData, new String[]{"Car Image", "Brand", "Model", "Colour", "Year", "Engine Number", "License Number", "Seats Number", "Warranty"});
//        JTable jTable = new JTable(defaultTableModel){
//            public Class getColumnClass(int column){
//                return (column == 0) ? Icon.class : Object.class;
//            }
//        };
//
//        carTableScrollPane = new JScrollPane(jTable);
//        getContentPane().add(carTableScrollPane);
    }

    public Object[][] getCarsList(){
        List<Car> carsList = carCatalogue.getAllCarsList();
        Object[][] carsCatalogToTable = new Object[carsList.size()][10];
        for(int i = 0; i < carsList.size(); i++){
            Car car = carsList.get(i);
            System.out.println(car);
            ImageIcon imageIcon = new ImageIcon(car.getImageFilePathUrl());
            Image theImage = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            ImageIcon newImageIcon = new ImageIcon(theImage);

            Object[] eachCar = {newImageIcon, car.getOwner().getName(), car.getBrand(), car.getModel(), car.getColour(), car.getYear(), car.getEngineNumber().toString(), car.getLicensePlate(), String.valueOf(car.getSeatsNumber()), String.valueOf(car.getWarrantyYears())};
            carsCatalogToTable[i] = eachCar;
        }
        return carsCatalogToTable;

    }

    private void openFileButtonActionPerformed(ActionEvent event) throws IOException {
        int returnedValue = openFileChooser.showOpenDialog(this);

        if(returnedValue == JFileChooser.APPROVE_OPTION){

            File theImageFile = openFileChooser.getSelectedFile();

            originalBI = ImageIO.read(theImageFile);

            ImageIcon imageIcon = new ImageIcon(originalBI);
            Image newImg = imageIcon.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(newImg));

            imageFilePath = new File("").getAbsolutePath()+"/src/main/resources/images/";
            saveImageToCertainLocation(imageFilePath, theImageFile);

        }
        else{
            System.out.println("No File Choosen");
        }

    }

    public void saveImageToCertainLocation(String filePath, File imageFile) throws IOException {
        File directory = new File(filePath);
        if(!directory.exists()){
            directory.mkdirs();
        }
        String fileNamePath = imageFile.getAbsolutePath();

        File sourceFile = null;
        File destinationFile = null;

//        String extension = fileNamePath.substring(fileNamePath.lastIndexOf('.') + 1);
        sourceFile = new File(fileNamePath);
        destinationFile = new File(filePath+sourceFile.getAbsoluteFile().getName());
        Files.copy(sourceFile.toPath(), destinationFile.toPath());

        System.out.println("File saved at "+destinationFile.toString());

        privateImageFileCompletePath = destinationFile.toString();


//        System.out.println(new File("").getAbsolutePath());

    }


    public String[][] getOwnersData(){
        List<Owner> ownersCatalog = ownerCatalog.getAllOwnersList();
        String[][] ownersCatalogToTable = new String[ownersCatalog.size()][5];
        for(int i = 0; i < ownersCatalog.size(); i++){
            Owner o = ownersCatalog.get(i);
            System.out.println(o);
            String[] eachOwner = {o.getName(), o.getEmailAddress(), o.getAddress(), o.getLicenceNumber().toString(), o.getTelephoneNumbers().toString()};
            ownersCatalogToTable[i] = eachOwner;
        }
        return ownersCatalogToTable;
    }


    public static void main(String[] args) {

        JFrame jframe = new CarGUI("Car GUI");
        jframe.setVisible(true);


    }


}
