package flightreservationsystem.form;

import flightreservationsystem.features.*;
import flightreservationsystem.models.FlightStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static flightreservationsystem.constants.ControlFlightReservationTitles.*;
import static flightreservationsystem.features.Core.getInfoOfFlight;
import static flightreservationsystem.features.flightreservation.CancelReserve.calcelReservation;
import static flightreservationsystem.features.flightreservation.InsertReserve.flightReservation;
import static flightreservationsystem.features.flightreservation.UpdateReserve.updateReserve;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

public class FlightReservationControl extends JFrame {
    private JPanel mainPanel;
    private JPanel flightStatus;
    private JPanel flightBasicInformation;
    private JTable flightStatusInfo;
    private JTextPane textPaneFlightInfo;
    private JTextPane textPaneMoreFlightInfo;
    private JScrollPane scrollPaneFlightStatusInfo;
    private static final String SEPARATOR = ": ";
    private static final String NEW_LINE = "\r";
    private static final String SI = "Si";
    private static final String NO = "No";
    private static final String J_OPTION_PANE_SHOW_CONFIRM_DIALOG_ALERT_TITLE = "Flight reservation control";
    private static final int J_OPTION_PANE_SHOW_NO_OPTION = 1;

    public FlightReservationControl() throws IOException {
        setup();
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Flight reservation control");
        frame.setContentPane(new FlightReservationControl().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1100, 700);
    }

    private void setup() throws IOException{
        loadBasicFlightInfo();
        loadMoreBasicFlightInfo();
        loadFlightInfo();
        buildInsertReservationButton();
        buildCancelReservationButton();
        buildUpdateReservationButton();
    }

    private void loadBasicFlightInfo() throws IOException {
        FlightStatus[] flightStatus = getInfoOfFlight();

        String stringBuilder = TECHNICAL_CONFIGURATION_ID.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getTechnicalConfigurationId() +
                NEW_LINE +
                NEW_LINE +
                NUMBER_OF_ECONOMIC_SEATS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getNumberOfEconomicSeatClass() +
                NEW_LINE +
                PRICE_FOR_ECONOMIC_SEATS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getPriceForEconomicSeatClass() +
                NEW_LINE +
                NUMBER_OF_ECONOMIC_SEAT_FOR_SMOKERS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getNumberOfEconomicSeatClassForSmokers() +
                NEW_LINE +
                ECONOMIC_SMOKER_TAX.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getEconomicSmokerTax() +
                NEW_LINE +
                NEW_LINE +
                NUMBER_OF_PREMIUM_SEATS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getNumberOfPremiumSeatClass() +
                NEW_LINE +
                PRICE_FOR_PREMIUM_SEATS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getPriceForPremiumSeatClass() +
                NEW_LINE +
                NUMBER_OF_PREMIUM_SEAT_FOR_SMOKERS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getNumberOfPremiumSeatClassForSmokers() +
                NEW_LINE +
                PREMIUM_SMOKER_TAX.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getPremiumSmokerTax() +
                NEW_LINE +
                NEW_LINE +
                TOTAL_SEATS.getValue() +
                SEPARATOR +
                flightStatus[0].getTechnicalFlightDetails().getSeatsTotal() +
                NEW_LINE;
        textPaneFlightInfo.setText(stringBuilder);
    }

    private void loadMoreBasicFlightInfo() throws IOException {
        FlightStatus[] flightStatus = getInfoOfFlight();

        String stringBuilder = AIRPORT.getValue() +
                SEPARATOR +
                flightStatus[0].getAirport().getName() +
                NEW_LINE +
                COUNTRY.getValue() +
                SEPARATOR +
                flightStatus[0].getAirport().getCountry() +
                NEW_LINE +
                CITY.getValue() +
                SEPARATOR +
                flightStatus[0].getAirport().getCity() +
                NEW_LINE +
                ADDRESS.getValue() +
                SEPARATOR +
                flightStatus[0].getAirport().getAddress() +
                NEW_LINE +
                NEW_LINE +
                FROM_COUNTRY.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getFromCountry() +
                NEW_LINE +
                TO_COUNTRY.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getToCountry() +
                NEW_LINE +
                NEW_LINE +
                FROM_CITY.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getFromCity() +
                NEW_LINE +
                TO_CITY.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getToCity() +
                NEW_LINE +
                NEW_LINE +
                IS_LOCAL.getValue() +
                SEPARATOR +
                (flightStatus[0].getFlightInfo().isLocal() ? SI : NO) +
                NEW_LINE +
                NEW_LINE +
                FLIGHT_DATE.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getDate() +
                NEW_LINE +
                FLIGHT_TIME.getValue() +
                SEPARATOR +
                flightStatus[0].getFlightInfo().getTime() +
                NEW_LINE;
        textPaneMoreFlightInfo.setText(stringBuilder);
    }

    private void loadFlightInfo() throws IOException {
        flightStatusInfo.setModel(fillDefaultTableModel());
        flightStatusInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        flightStatusInfo.getTableHeader().setReorderingAllowed(false);
        flightStatusInfo.getTableHeader().setVisible(true);
        flightStatusInfo.setFillsViewportHeight(true);
    }

    private DefaultTableModel fillDefaultTableModel() throws IOException {
        //Define column and it's name.
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        //Seat information.
        defaultTableModel.addColumn(SEAT_ID.getValue());
        defaultTableModel.addColumn(IS_SMOKING.getValue());
        defaultTableModel.addColumn(IS_PREMIUM.getValue());
        defaultTableModel.addColumn(IS_BUSY.getValue());
        //Person information.
        defaultTableModel.addColumn(PERSON_NAME.getValue());
        defaultTableModel.addColumn(PERSON_ID_TYPE.getValue());
        defaultTableModel.addColumn(PERSON_ID.getValue());
        defaultTableModel.addColumn(AGE.getValue());
        defaultTableModel.addColumn(SEX.getValue());
        defaultTableModel.addColumn(WEIGHT.getValue());
        defaultTableModel.addColumn(PHONE_NUMBER.getValue());
        defaultTableModel.addColumn(INSERT.getValue());
        defaultTableModel.addColumn(CANCEL.getValue());
        defaultTableModel.addColumn(UPDATE.getValue());
        //Get data from JSON file.
        FlightStatus[] flightStatus = getInfoOfFlight();

        //Add rows values into JTable.
        for (FlightStatus flightState : flightStatus) {
            //Columns data (The last 3 positions no mentioned here are for operations like update, edit and insert).
            Object[] data = new Object[14];

            data[0] = flightState.getSeat().getId();
            data[1] = flightState.getSeat().isSmoking() ? SI : NO;
            data[2] = flightState.getSeat().isPremium() ? SI : NO;
            data[3] = flightState.getSeat().isBusy() ? SI : NO;
            data[4] = (flightState.getPerson().getFirstName() + " " +
                    flightState.getPerson().getSecondName() + " " +
                    flightState.getPerson().getFirstSurname() + " " +
                    flightState.getPerson().getSecondSurname());
            data[5] = flightState.getPerson().getIdentificationType();
            data[6] = flightState.getPerson().getIdentification();
            data[7] = flightState.getPerson().getAge();
            data[8] = flightState.getPerson().getSex();
            data[9] = flightState.getPerson().getWeight();
            data[10] = flightState.getPerson().getPhoneNumber();

            //Add a new row.
            defaultTableModel.addRow(data);
        }

        return defaultTableModel;
    }

    private void buildInsertReservationButton(){
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    insertFlightReservation();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        flightStatusInfo.getColumn(INSERT.getValue()).setCellRenderer(new ButtonRenderer(INSERT.getValue()));
        flightStatusInfo.getColumn(INSERT.getValue()).setCellEditor(new ButtonEditor(new JCheckBox(), actionListener, INSERT.getValue()));
    }

    private void insertFlightReservation() throws IOException{
        if(showConfirmDialog(flightStatus, "Are you sure to insert Flight reservation?",
                J_OPTION_PANE_SHOW_CONFIRM_DIALOG_ALERT_TITLE, YES_NO_OPTION) == J_OPTION_PANE_SHOW_NO_OPTION)
            return;

        flightReservation();
    }

    private void buildCancelReservationButton(){
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    cancelFlightReservation();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        flightStatusInfo.getColumn(CANCEL.getValue()).setCellRenderer(new ButtonRenderer(CANCEL.getValue()));
        flightStatusInfo.getColumn(CANCEL.getValue()).setCellEditor(new ButtonEditor(new JCheckBox(), actionListener, CANCEL.getValue()));
    }

    private void cancelFlightReservation() throws IOException{
        if(showConfirmDialog(flightStatus, "Are you sure to cancel Flight reservation?",
                J_OPTION_PANE_SHOW_CONFIRM_DIALOG_ALERT_TITLE, YES_NO_OPTION) == J_OPTION_PANE_SHOW_NO_OPTION)
            return;

        calcelReservation(ofSelectedRow());
        loadFlightInfo();
        buildInsertReservationButton();
        buildCancelReservationButton();
        buildUpdateReservationButton();
        flightStatusInfo.repaint();
    }

    private String ofSelectedRow(){
        int seatColumnIndex = 0;
        return (((DefaultTableModel)flightStatusInfo.getModel()).getDataVector().get(flightStatusInfo.getSelectedRow()).toArray())[seatColumnIndex].toString();
    }

    private Object[] selectedRow(){
        return ((DefaultTableModel)flightStatusInfo.getModel()).getDataVector().get(flightStatusInfo.getSelectedRow()).toArray();
    }

    private void buildUpdateReservationButton(){
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    updateFlightReservation();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        flightStatusInfo.getColumn(UPDATE.getValue()).setCellRenderer(new ButtonRenderer(UPDATE.getValue()));
        flightStatusInfo.getColumn(UPDATE.getValue()).setCellEditor(new ButtonEditor(new JCheckBox(), actionListener, CANCEL.getValue()));
    }

    private void updateFlightReservation() throws IOException {
        if(showConfirmDialog(flightStatus, "Are you sure to update Flight reservation?",
                J_OPTION_PANE_SHOW_CONFIRM_DIALOG_ALERT_TITLE, YES_NO_OPTION) == J_OPTION_PANE_SHOW_NO_OPTION)
            return;

        updateReserve();
    }

}
