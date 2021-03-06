/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.xml.bind.JAXBException;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.costs.Costs;
import veloziped.ws1516.disposal.Disposal;
import veloziped.ws1516.disposal.PurchasingDisposal;
import veloziped.ws1516.generated.Input.Input;
import veloziped.ws1516.generated.Input.Item;
import veloziped.ws1516.generated.Input.Orderlist;
import veloziped.ws1516.generated.Input.Production;
import veloziped.ws1516.generated.Results.Order;
import veloziped.ws1516.generated.Results.Results;
import veloziped.ws1516.production.CalculationMode;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.production.PeriodDetail;
import veloziped.ws1516.production.ProductionPlan;
import veloziped.ws1516.util.HighlightTableCell;
import veloziped.ws1516.util.IntegerField;
import veloziped.ws1516.util.LoadHelpFile;
import veloziped.ws1516.util.TableCellListener;
import veloziped.ws1516.util.Utils;
import veloziped.ws1516.workload.WorkloadPlanning;
import veloziped.ws1516.workload.WorkloadResult;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Mihai Sava
 */
public class MainUI extends javax.swing.JFrame {

    long indexE16wl;
    long indexE17wl;
    long indexE26wl;
    long indexE16st;
    long indexE17st;
    long indexE26st;
    long indexE16;
    long indexE17;
    long indexE26;

    private JTextField IntegerField;
    private Locale locale = Locale.getDefault();
    private PeriodDetail periodDetailN1 = new PeriodDetail(0, 0, 0);
    private PeriodDetail periodDetailN2 = new PeriodDetail(0, 0, 0);
    private PeriodDetail periodDetailN3 = new PeriodDetail(0, 0, 0);
    private PeriodDetail periodDetailN4 = new PeriodDetail(0, 0, 0);

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        SetupInstance.getInstance().readWorkplaceJson();
        SetupInstance.getInstance().readArticleJson();
        initComponents();

        this.jPanel2.setVisible(true);
        this.jPanel1.setVisible(false);
        jScrollPane5.setVisible(false);
        this.loadWelcomeMessage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());


        //set Language selected
        this.setSelectedLanguage(Locale.getDefault().getLanguage());

        this.changeLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        this.setCalculationMode(CalculationMode.PESSIMISTIC);

        this.jButtonCalculate.setEnabled(
                false);
        SharedInstance.getInstance()
                .setDiscountFactor(0.1);
        SharedInstance.getInstance()
                .setBufferFactor(0.05);

        this.jSpinnerDiscountFactor.setValue(SharedInstance.getInstance().getDiscountFactor() * 100);

        this.jSpinnerBufferFactor.setValue(SharedInstance.getInstance().getBufferFactor() * 100);

        resetDirectSale();

        resetCostsFields();

        this.setEnabledTabs(
                false);

        this.addInputFieldsListener();

        this.setInHouseProductionJTextFieldsEnabled(
                false);

        this.setTableListeners();

        this.setTableEditColors();

        SharedInstance.getInstance()
                .setDefaultValues();
    }

    private void setEnabledTabs(boolean value) {
        this.jTabbedPan.setEnabledAt(1, value);
        this.jTabbedPan.setEnabledAt(2, value);
        this.jTabbedPan.setEnabledAt(3, value);
        this.jTabbedPan.setEnabledAt(4, value);
        this.jTabbedPan.setEnabledAt(6, value);
    }

    private void reSetForecast() {
        Forecast forecast = new Forecast();
        forecast.setPeriodN1(periodDetailN1);
        forecast.setPeriodN2(periodDetailN2);
        forecast.setPeriodN3(periodDetailN3);
        forecast.setPeriodN4(periodDetailN4);

        SharedInstance.getInstance().setForecast(forecast);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameHelpDialog = new javax.swing.JFrame();
        jPanelHelpDialog = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaHelpFile = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButtonCalculate = new javax.swing.JButton();
        jSpinnerBufferFactor = new javax.swing.JSpinner();
        jLabelBufferFactor = new javax.swing.JLabel();
        jSpinnerDiscountFactor = new javax.swing.JSpinner();
        jLabelDiscountFactor = new javax.swing.JLabel();
        jButtonBackToWelcome = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabbedPan = new javax.swing.JTabbedPane();
        jPanelInHouseProduction = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelKF = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelKFKinderfahrrad = new javax.swing.JLabel();
        jLabelKFSalesOrders = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelKFStockEndOfPeriod = new javax.swing.JLabel();
        jLabelKFOrdersInQueue = new javax.swing.JLabel();
        jLabelKFWorkInProgress = new javax.swing.JLabel();
        jLabelKFProductionOrders = new javax.swing.JLabel();
        jTextFieldKFP1SalesOrders = new IntegerField("0");
        jTextFieldKFE51SalesOrders = new IntegerField();
        jTextFieldKFE16SalesOrders = new IntegerField();
        jTextFieldKFE50SalesOrders = new IntegerField();
        jTextFieldKFE4SalesOrders = new IntegerField();
        jTextFieldKFE10SalesOrders = new IntegerField();
        jTextFieldKFE49SalesOrders = new IntegerField();
        jTextFieldKFE7SalesOrders = new IntegerField();
        jTextFieldKFE13SalesOrders = new IntegerField();
        jTextFieldKFE18SalesOrders = new IntegerField();
        jTextFieldKFE26StockEndOfPeriod = new IntegerField();
        jTextFieldKFP1StockEndOfPeriod = new IntegerField();
        jTextFieldKFE51StockEndOfPeriod = new IntegerField();
        jTextFieldKFE17StockEndOfPeriod = new IntegerField();
        jTextFieldKFE16StockEndOfPeriod = new IntegerField();
        jTextFieldKFE50StockEndOfPeriod = new IntegerField();
        jTextFieldKFE10StockEndOfPeriod = new IntegerField();
        jTextFieldKFE4StockEndOfPeriod = new IntegerField();
        jTextFieldKFE49StockEndOfPeriod = new IntegerField();
        jTextFieldKFE13StockEndOfPeriod = new IntegerField();
        jTextFieldKFE7StockEndOfPeriod = new IntegerField();
        jTextFieldKFE18StockEndOfPeriod = new IntegerField();
        jTextFieldKFE26OrdersInQueque = new IntegerField();
        jTextFieldKFP1OrdersInQueque = new IntegerField();
        jTextFieldKFE51OrdersInQueque = new IntegerField();
        jTextFieldKFE16OrdersInQueque = new IntegerField();
        jTextFieldKFE17OrdersInQueque = new IntegerField();
        jTextFieldKFE50OrdersInQueque = new IntegerField();
        jTextFieldKFE4OrdersInQueque = new IntegerField();
        jTextFieldKFE10OrdersInQueque = new IntegerField();
        jTextFieldKFE49OrdersInQueque = new IntegerField();
        jTextFieldKFE7OrdersInQueque = new IntegerField();
        jTextFieldKFE13OrdersInQueque = new IntegerField();
        jTextFieldKFE18OrdersInQueque = new IntegerField();
        jTextFieldKFE26WorkInProgress = new IntegerField();
        jTextFieldKFP1WorkInProgress = new IntegerField();
        jTextFieldKFE51WorkInProgress = new IntegerField();
        jTextFieldKFE16WorkInProgress = new IntegerField();
        jTextFieldKFE17WorkInProgress = new IntegerField();
        jTextFieldKFE50WorkInProgress = new IntegerField();
        jTextFieldKFE4WorkInProgress = new IntegerField();
        jTextFieldKFE10WorkInProgress = new IntegerField();
        jTextFieldKFE49WorkInProgress = new IntegerField();
        jTextFieldKFE7WorkInProgress = new IntegerField();
        jTextFieldKFE13WorkInProgress = new IntegerField();
        jTextFieldKFE18WorkInProgress = new IntegerField();
        jTextFieldKFE26ProductionOrders = new IntegerField();
        jTextFieldKFE51ProductionOrders = new IntegerField();
        jTextFieldKFP1ProductionOrders = new IntegerField();
        jTextFieldKFE16ProductionOrders = new IntegerField();
        jTextFieldKFE17ProductionOrders = new IntegerField();
        jTextFieldKFE50ProductionOrders = new IntegerField();
        jTextFieldKFE4ProductionOrders = new IntegerField();
        jTextFieldKFE10ProductionOrders = new IntegerField();
        jTextFieldKFE49ProductionOrders = new IntegerField();
        jTextFieldKFE7ProductionOrders = new IntegerField();
        jTextFieldKFE13ProductionOrders = new IntegerField();
        jTextFieldKFE18ProductionOrders = new IntegerField();
        jTextFieldKFP1PlannedStock = new IntegerField("");
        jTextFieldKFE26PlannedStock = new IntegerField();
        jTextFieldKFE51PlannedStock = new IntegerField();
        jTextFieldKFE16PlannedStock = new IntegerField();
        jTextFieldKFE17PlannedStock = new IntegerField();
        jTextFieldKFE50PlannedStock = new IntegerField();
        jTextFieldKFE4PlannedStock = new IntegerField();
        jTextFieldKFE10PlannedStock = new IntegerField();
        jTextFieldKFE49PlannedStock = new IntegerField();
        jTextFieldKFE7PlannedStock = new IntegerField();
        jTextFieldKFE13PlannedStock = new IntegerField();
        jTextFieldKFE18PlannedStock = new IntegerField();
        jLabelKFPedalCpl = new javax.swing.JLabel();
        jLabelKFFahrradOPedal = new javax.swing.JLabel();
        jLabelKFLenkerCpl = new javax.swing.JLabel();
        jLabelSattelCpl = new javax.swing.JLabel();
        jLabelKFRahmenURaeder = new javax.swing.JLabel();
        jLabelKFHinterradgruppe = new javax.swing.JLabel();
        jLabelKFASchutzblechH = new javax.swing.JLabel();
        jLabelKFVorderradCpl = new javax.swing.JLabel();
        jLabelKFVorderradgruppe = new javax.swing.JLabel();
        jLabelKFSchutzblechV = new javax.swing.JLabel();
        jLabelKFRahmen = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jTextFieldKFE26SalesOrders = new IntegerField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jTextFieldKFE17SalesOrders = new IntegerField();
        jLabelKFPlannedStock = new javax.swing.JLabel();
        jLabelKFE26OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE51OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE16OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE17OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE50OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE4OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE10OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE49OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE7OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE13OrdersInQueque = new javax.swing.JLabel();
        jLabelKFE18OrdersInQueque = new javax.swing.JLabel();
        jPanelDF = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabelDFLadiesCycle = new javax.swing.JLabel();
        jLabelDFSalesOrders = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDFStockEndOfPeriod = new javax.swing.JLabel();
        jLabelDFOrdersInQueue = new javax.swing.JLabel();
        jLabelDFWorkInProgress = new javax.swing.JLabel();
        jLabelDFProductionOrders = new javax.swing.JLabel();
        jTextFieldDFP2SalesOrders = new IntegerField("0");
        jTextFieldDFE56SalesOrders = new IntegerField();
        jTextFieldDFE16SalesOrders = new IntegerField();
        jTextFieldDFE55SalesOrders = new IntegerField();
        jTextFieldDFE5SalesOrders = new IntegerField();
        jTextFieldDFE11SalesOrders = new IntegerField();
        jTextFieldDFE54SalesOrders = new IntegerField();
        jTextFieldDFE8SalesOrders = new IntegerField();
        jTextFieldDFE14SalesOrders = new IntegerField();
        jTextFieldDFE19SalesOrders = new IntegerField();
        jTextFieldDFE26StockEndOfPeriod = new IntegerField();
        jTextFieldDFP2StockEndOfPeriod = new IntegerField();
        jTextFieldDFE56StockEndOfPeriod = new IntegerField();
        jTextFieldDFE17StockEndOfPeriod = new IntegerField();
        jTextFieldDFE16StockEndOfPeriod = new IntegerField();
        jTextFieldDFE55StockEndOfPeriod = new IntegerField();
        jTextFieldDFE11StockEndOfPeriod = new IntegerField();
        jTextFieldDFE5StockEndOfPeriod = new IntegerField();
        jTextFieldDFE54StockEndOfPeriod = new IntegerField();
        jTextFieldDFE14StockEndOfPeriod = new IntegerField();
        jTextFieldDFE8StockEndOfPeriod = new IntegerField();
        jTextFieldDFE19StockEndOfPeriod = new IntegerField();
        jTextFieldDFE26OrdersInQueque = new IntegerField();
        jTextFieldDFP2OrdersInQueque = new IntegerField();
        jTextFieldDFE56OrdersInQueque = new IntegerField();
        jTextFieldDFE16OrdersInQueque = new IntegerField();
        jTextFieldDFE17OrdersInQueque = new IntegerField();
        jTextFieldDFE55OrdersInQueque = new IntegerField();
        jTextFieldDFE5OrdersInQueque = new IntegerField();
        jTextFieldDFE11OrdersInQueque = new IntegerField();
        jTextFieldDFE54OrdersInQueque = new IntegerField();
        jTextFieldDFE8OrdersInQueque = new IntegerField();
        jTextFieldDFE14OrdersInQueque = new IntegerField();
        jTextFieldDFE19OrdersInQueque = new IntegerField();
        jTextFieldDFE26WorkInProgress = new IntegerField();
        jTextFieldDFP2WorkInProgress = new IntegerField();
        jTextFieldDFE56WorkInProgress = new IntegerField();
        jTextFieldDFE16WorkInProgress = new IntegerField();
        jTextFieldDFE17WorkInProgress = new IntegerField();
        jTextFieldDFE55WorkInProgress = new IntegerField();
        jTextFieldDFE5WorkInProgress = new IntegerField();
        jTextFieldDFE11WorkInProgress = new IntegerField();
        jTextFieldDFE54WorkInProgress = new IntegerField();
        jTextFieldDFE8WorkInProgress = new IntegerField();
        jTextFieldDFE14WorkInProgress = new IntegerField();
        jTextFieldDFE19WorkInProgress = new IntegerField();
        jTextFieldDFE26ProductionOrders = new IntegerField();
        jTextFieldDFE56ProductionOrders = new IntegerField();
        jTextFieldDFP2ProductionOrders = new IntegerField();
        jTextFieldDFE16ProductionOrders = new IntegerField();
        jTextFieldDFE17ProductionOrders = new IntegerField();
        jTextFieldDFE55ProductionOrders = new IntegerField();
        jTextFieldDFE5ProductionOrders = new IntegerField();
        jTextFieldDFE11ProductionOrders = new IntegerField();
        jTextFieldDFE54ProductionOrders = new IntegerField();
        jTextFieldDFE8ProductionOrders = new IntegerField();
        jTextFieldDFE14ProductionOrders = new IntegerField();
        jTextFieldDFE19ProductionOrders = new IntegerField();
        jTextFieldDFP2PlannedStock = new IntegerField();
        jTextFieldDFE26PlannedStock = new IntegerField();
        jTextFieldDFE56PlannedStock = new IntegerField();
        jTextFieldDFE16PlannedStock = new IntegerField();
        jTextFieldDFE17PlannedStock = new IntegerField();
        jTextFieldDFE55PlannedStock = new IntegerField();
        jTextFieldDFE5PlannedStock = new IntegerField();
        jTextFieldDFE11PlannedStock = new IntegerField();
        jTextFieldDFE54PlannedStock = new IntegerField();
        jTextFieldDFE8PlannedStock = new IntegerField();
        jTextFieldDFE14PlannedStock = new IntegerField();
        jTextFieldDFE19PlannedStock = new IntegerField();
        jLabelDFPedalCpl = new javax.swing.JLabel();
        jLabelDFFahrradOPedal = new javax.swing.JLabel();
        jLabelDFLenkerCpl = new javax.swing.JLabel();
        jLabelDFSattelCpl = new javax.swing.JLabel();
        jLabelDFRahmenURaeder = new javax.swing.JLabel();
        jLabelDFHinterradgruppe = new javax.swing.JLabel();
        jLabelDFASchutzblechH = new javax.swing.JLabel();
        jLabelDFVorderradCpl = new javax.swing.JLabel();
        jLabelDFVorderradgruppe = new javax.swing.JLabel();
        jLabelDFSchutzblechV = new javax.swing.JLabel();
        jLabelDFRahmen = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jTextFieldDFE26SalesOrders = new IntegerField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jTextFieldDFE17SalesOrders = new IntegerField();
        jLabelDFPlannedStock = new javax.swing.JLabel();
        jLabelDFE26OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE56OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE16OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE17OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE55OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE5OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE11OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE54OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE8OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE14OrdersInQueque = new javax.swing.JLabel();
        jLabelDFE19OrdersInQueque = new javax.swing.JLabel();
        jPanelHF = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelHFManCycle = new javax.swing.JLabel();
        jLabelHFSalesOrders = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelHFStockEndOfPeriod = new javax.swing.JLabel();
        jLabelHFOrdersInQueue = new javax.swing.JLabel();
        jLabelHFWorkInProgress = new javax.swing.JLabel();
        jLabelHFProductionOrders = new javax.swing.JLabel();
        jTextFieldHFP3SalesOrders = new IntegerField("0");
        jTextFieldHFE31SalesOrders = new IntegerField();
        jTextFieldHFE16SalesOrders = new IntegerField();
        jTextFieldHFE30SalesOrders = new IntegerField();
        jTextFieldHFE6SalesOrders = new IntegerField();
        jTextFieldHFE12SalesOrders = new IntegerField();
        jTextFieldHFE29SalesOrders = new IntegerField();
        jTextFieldHFE9SalesOrders = new IntegerField();
        jTextFieldHFE15SalesOrders = new IntegerField();
        jTextFieldHFE20SalesOrders = new IntegerField();
        jTextFieldHFE26StockEndOfPeriod = new IntegerField();
        jTextFieldHFP3StockEndOfPeriod = new IntegerField();
        jTextFieldHFE31StockEndOfPeriod = new IntegerField();
        jTextFieldHFE17StockEndOfPeriod = new IntegerField();
        jTextFieldHFE16StockEndOfPeriod = new IntegerField();
        jTextFieldHFE30StockEndOfPeriod = new IntegerField();
        jTextFieldHFE12StockEndOfPeriod = new IntegerField();
        jTextFieldHFE6StockEndOfPeriod = new IntegerField();
        jTextFieldHFE29StockEndOfPeriod = new IntegerField();
        jTextFieldHFE15StockEndOfPeriod = new IntegerField();
        jTextFieldHFE9StockEndOfPeriod = new IntegerField();
        jTextFieldHFE20StockEndOfPeriod = new IntegerField();
        jTextFieldHFE26OrdersInQueque = new IntegerField();
        jTextFieldHFP3OrdersInQueque = new IntegerField();
        jTextFieldHFE31OrdersInQueque = new IntegerField();
        jTextFieldHFE16OrdersInQueque = new IntegerField();
        jTextFieldHFE17OrdersInQueque = new IntegerField();
        jTextFieldHFE30OrdersInQueque = new IntegerField();
        jTextFieldHFE6OrdersInQueque = new IntegerField();
        jTextFieldHFE12OrdersInQueque = new IntegerField();
        jTextFieldHFE29OrdersInQueque = new IntegerField();
        jTextFieldHFE9OrdersInQueque = new IntegerField();
        jTextFieldHFE15OrdersInQueque = new IntegerField();
        jTextFieldHFE20OrdersInQueque = new IntegerField();
        jTextFieldHFE26WorkInProgress = new IntegerField();
        jTextFieldHFP3WorkInProgress = new IntegerField();
        jTextFieldHFE31WorkInProgress = new IntegerField();
        jTextFieldHFE16WorkInProgress = new IntegerField();
        jTextFieldHFE17WorkInProgress = new IntegerField();
        jTextFieldHFE30WorkInProgress = new IntegerField();
        jTextFieldHFE6WorkInProgress = new IntegerField();
        jTextFieldHFE12WorkInProgress = new IntegerField();
        jTextFieldHFE29WorkInProgress = new IntegerField();
        jTextFieldHFE9WorkInProgress = new IntegerField();
        jTextFieldHFE15WorkInProgress = new IntegerField();
        jTextFieldHFE20WorkInProgress = new IntegerField();
        jTextFieldHFE26ProductionOrders = new IntegerField();
        jTextFieldHFE31ProductionOrders = new IntegerField();
        jTextFieldHFP3ProductionOrders = new IntegerField();
        jTextFieldHFE16ProductionOrders = new IntegerField();
        jTextFieldHFE17ProductionOrders = new IntegerField();
        jTextFieldHFE30ProductionOrders = new IntegerField();
        jTextFieldHFE6ProductionOrders = new IntegerField();
        jTextFieldHFE12ProductionOrders = new IntegerField();
        jTextFieldHFE29ProductionOrders = new IntegerField();
        jTextFieldHFE9ProductionOrders = new IntegerField();
        jTextFieldHFE15ProductionOrders = new IntegerField();
        jTextFieldHFE20ProductionOrders = new IntegerField();
        jTextFieldHFP3PlannedStock = new IntegerField();
        jTextFieldHFE26PlannedStock = new IntegerField();
        jTextFieldHFE31PlannedStock = new IntegerField();
        jTextFieldHFE16PlannedStock = new IntegerField();
        jTextFieldHFE17PlannedStock = new IntegerField();
        jTextFieldHFE30PlannedStock = new IntegerField();
        jTextFieldHFE6PlannedStock = new IntegerField();
        jTextFieldHFE12PlannedStock = new IntegerField();
        jTextFieldHFE29PlannedStock = new IntegerField();
        jTextFieldHFE9PlannedStock = new IntegerField();
        jTextFieldHFE15PlannedStock = new IntegerField();
        jTextFieldHFE20PlannedStock = new IntegerField();
        jLabelHFPedalCpl = new javax.swing.JLabel();
        jLabelHFFahrradOPedal = new javax.swing.JLabel();
        jLabelHFLenkerCpl = new javax.swing.JLabel();
        jLabelHFSattelCpl = new javax.swing.JLabel();
        jLabelHFRahmenURaeder = new javax.swing.JLabel();
        jLabelHFHinterradgruppe = new javax.swing.JLabel();
        jLabelHFASchutzblechH = new javax.swing.JLabel();
        jLabelHFVorderradCpl = new javax.swing.JLabel();
        jLabelHFVorderradgruppe = new javax.swing.JLabel();
        jLabelHFSchutzblechV = new javax.swing.JLabel();
        jLabelHFRahmen = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jTextFieldHFE26SalesOrders = new IntegerField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jTextFieldHFE17SalesOrders = new IntegerField();
        jLabelHFPlannedStock = new javax.swing.JLabel();
        jLabelHFE26OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE31OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE16OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE17OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE30OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE6OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE12OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE29OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE9OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE15OrdersInQueque = new javax.swing.JLabel();
        jLabelHFE20OrdersInQueque = new javax.swing.JLabel();
        jPanelWorkloadPlanning = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWorkloadPlanning = new javax.swing.JTable();
        jPanelPurchasingDisposition = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePurchasingDisposition = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTablePurchasingDispositionIncoming = new javax.swing.JTable();
        jLabelPurchasingDispoOutgoing = new javax.swing.JLabel();
        jLabelPurchasingDispoIncoming = new javax.swing.JLabel();
        jPanelStockChange = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStockChange = new javax.swing.JTable();
        jPanelEProdList = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableEProdList = new javax.swing.JTable();
        jButtonMoveDown = new javax.swing.JButton();
        jButtonMoveUp = new javax.swing.JButton();
        jButtonProdListReset = new javax.swing.JButton();
        jButtonProdListApply = new javax.swing.JButton();
        jLabelProdListIterationOne = new javax.swing.JLabel();
        jLabelProdListIterationTwo = new javax.swing.JLabel();
        jTextFieldProdListIterationOne = new IntegerField("100");
        jTextFieldProdListIterationTwo = new IntegerField("150");
        jPanelSales = new javax.swing.JPanel();
        jLabelSalesChildren = new javax.swing.JLabel();
        jLabelSalesWomen = new javax.swing.JLabel();
        jLabelSalesMen = new javax.swing.JLabel();
        jTextFieldSalesKQuantity = new IntegerField("0");
        jTextFieldSalesDQuantity = new IntegerField("0");
        jTextFieldSalesHQuantity = new IntegerField("0");
        jLabelSalesQuantity = new javax.swing.JLabel();
        jLabelSalesPrice = new javax.swing.JLabel();
        jLabelSalesPenalty = new javax.swing.JLabel();
        jTextFieldSalesKPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesDPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesDPrice.setText("0");
        jTextFieldSalesHPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesHPrice.setText("0");
        jTextFieldSalesKPenalty = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesKPenalty.setText("0");
        jTextFieldSalesDPenalty = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesDPenalty.setText("0")
        ;
        jTextFieldSalesHPenalty = new JFormattedTextField(NumberFormat.getNumberInstance());
        jTextFieldSalesHPenalty.setText("0");
        jButtonSalesReset = new javax.swing.JButton();
        jPanelCosts = new javax.swing.JPanel();
        jLabelCostsTitleWarehouse = new javax.swing.JLabel();
        jLabelCostsTitleOldStockValue = new javax.swing.JLabel();
        jLabelCostsTitleEstimatedStockValue = new javax.swing.JLabel();
        jLabelCostsTitleNumberHouses = new javax.swing.JLabel();
        jLabelCostsTitleWarehouseHolding = new javax.swing.JLabel();
        jLabelCostsOldStockValue = new javax.swing.JLabel();
        jLabelCostsEstimatedStockValue = new javax.swing.JLabel();
        jLabelCostsNumberHouses = new javax.swing.JLabel();
        jLabelCostsWarehouseHoldungValue = new javax.swing.JLabel();
        jLabelCostsWarehouseHoldingPct = new javax.swing.JLabel();
        jLabelCostsNumberHousesChange = new javax.swing.JLabel();
        jLabelCostsEstimatedStockValuePct = new javax.swing.JLabel();
        jLabelCostsTitleLabor = new javax.swing.JLabel();
        jLabelCostsTitleLeerlauf = new javax.swing.JLabel();
        jLabelCostsTitleMachine = new javax.swing.JLabel();
        jLabelCostsTitleMaterial = new javax.swing.JLabel();
        jLabelCostsLaborCosts = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanelProductionForecast = new javax.swing.JPanel();
        jLabelKinderfahrradPF = new javax.swing.JLabel();
        jLabelDamenfahrradPF = new javax.swing.JLabel();
        jLabelHerrenfahrradPF = new javax.swing.JLabel();
        jLabelPeriodNPF = new javax.swing.JLabel();
        jLabelPeriodN1PF = new javax.swing.JLabel();
        jLabelPeriodN2PF = new javax.swing.JLabel();
        jLabelPeriodN3PF = new javax.swing.JLabel();
        jTextFieldPFPeriodN1KF = new IntegerField();
        jTextFieldPFPeriodN2KF = new IntegerField();
        jTextFieldPFPeriodN3KF = new IntegerField();
        jTextFieldPFPeriodN4KF = new IntegerField();
        jTextFieldPFPeriodN1DF = new IntegerField();
        jTextFieldPFPeriodN2DF = new IntegerField();
        jTextFieldPFPeriodN3DF = new IntegerField();
        jTextFieldPFPeriodN4DF = new IntegerField();
        jTextFieldPFPeriodN1HF = new IntegerField();
        jTextFieldPFPeriodN2HF = new IntegerField();
        jTextFieldPFPeriodN3HF = new IntegerField();
        jTextFieldPFPeriodN4HF = new IntegerField();
        jButtonWeiter = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaWelcome = new javax.swing.JTextArea();
        jButtonImportXML = new javax.swing.JButton();
        jLabelWelcomeImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemImportFile = new javax.swing.JMenuItem();
        jMenuItemExportFile = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jMenuLanguage = new javax.swing.JMenu();
        jCheckBoxMenuItemBulgarian = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDeutsch = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemEnglish = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemFrench = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemRomanien = new javax.swing.JCheckBoxMenuItem();
        jMenuCalculationMode = new javax.swing.JMenu();
        jCheckBoxMenuItemCalculationModePessimistic = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemCalculationModeOptimistic = new javax.swing.JCheckBoxMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemShowHelp = new javax.swing.JMenuItem();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("veloziped/ws1516/i18n/i18n"); // NOI18N
        jFrameHelpDialog.setTitle(bundle.getString("HelpDialog")); // NOI18N
        jFrameHelpDialog.setBounds(new java.awt.Rectangle(100, 23, 1000, 800));

        jTextAreaHelpFile.setColumns(20);
        jTextAreaHelpFile.setRows(5);
        jScrollPane8.setViewportView(jTextAreaHelpFile);

        javax.swing.GroupLayout jPanelHelpDialogLayout = new javax.swing.GroupLayout(jPanelHelpDialog);
        jPanelHelpDialog.setLayout(jPanelHelpDialogLayout);
        jPanelHelpDialogLayout.setHorizontalGroup(
            jPanelHelpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHelpDialogLayout.setVerticalGroup(
            jPanelHelpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jFrameHelpDialogLayout = new javax.swing.GroupLayout(jFrameHelpDialog.getContentPane());
        jFrameHelpDialog.getContentPane().setLayout(jFrameHelpDialogLayout);
        jFrameHelpDialogLayout.setHorizontalGroup(
            jFrameHelpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameHelpDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHelpDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jFrameHelpDialogLayout.setVerticalGroup(
            jFrameHelpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameHelpDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHelpDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("pps")); // NOI18N

        jButtonCalculate.setText("Calculate");
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jSpinnerBufferFactor.setModel(new javax.swing.SpinnerNumberModel(0, 0, 150, 1));
        jSpinnerBufferFactor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerBufferFactorStateChanged(evt);
            }
        });

        jLabelBufferFactor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelBufferFactor.setText("Puffer");
        jLabelBufferFactor.setToolTipText("Puffermenge für Bestellungen");

        jSpinnerDiscountFactor.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinnerDiscountFactor.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinnerDiscountFactor, ""));
        jSpinnerDiscountFactor.setRequestFocusEnabled(false);
        jSpinnerDiscountFactor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerDiscountFactorStateChanged(evt);
            }
        });

        jLabelDiscountFactor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDiscountFactor.setText("Discount");
        jLabelDiscountFactor.setToolTipText("Faktor ab wann Discount in Anspruch genommen werden soll");

        jButtonBackToWelcome.setText(bundle.getString("jButtonBack")); // NOI18N
        jButtonBackToWelcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToWelcomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBackToWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDiscountFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerDiscountFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelBufferFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerBufferFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCalculate)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDiscountFactor)
                    .addComponent(jSpinnerDiscountFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBufferFactor)
                    .addComponent(jSpinnerBufferFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBackToWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelKF.setMaximumSize(new java.awt.Dimension(16, 28));
        jPanelKF.setPreferredSize(new java.awt.Dimension(16, 28));

        jLabel12.setMaximumSize(new java.awt.Dimension(30, 14));
        jLabel12.setMinimumSize(new java.awt.Dimension(30, 14));

        jLabelKFKinderfahrrad.setText(bundle.getString("Kinderfahrrad")); // NOI18N
        jLabelKFKinderfahrrad.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFKinderfahrrad.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFKinderfahrrad.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFSalesOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFSalesOrders.setText(bundle.getString("SalesOrders")); // NOI18N

        jLabelKFStockEndOfPeriod.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFStockEndOfPeriod.setText(bundle.getString("StockEndOfPeriod")); // NOI18N

        jLabelKFOrdersInQueue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFOrdersInQueue.setText(bundle.getString("OrdersInQueue")); // NOI18N

        jLabelKFWorkInProgress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFWorkInProgress.setText(bundle.getString("WorkInProgress")); // NOI18N

        jLabelKFProductionOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFProductionOrders.setText(bundle.getString("ProductionOrders")); // NOI18N

        jTextFieldKFP1SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1SalesOrders.setEnabled(false);
        jTextFieldKFP1SalesOrders.setName("jTextFieldKFP1SalesOrders"); // NOI18N

        jTextFieldKFE51SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51SalesOrders.setEnabled(false);
        jTextFieldKFE51SalesOrders.setName("jTextFieldKFE51SalesOrders"); // NOI18N

        jTextFieldKFE16SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16SalesOrders.setEnabled(false);
        jTextFieldKFE16SalesOrders.setName("jTextFieldKFE16SalesOrders"); // NOI18N

        jTextFieldKFE50SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50SalesOrders.setEnabled(false);
        jTextFieldKFE50SalesOrders.setName("jTextFieldKFE50SalesOrders"); // NOI18N

        jTextFieldKFE4SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4SalesOrders.setEnabled(false);
        jTextFieldKFE4SalesOrders.setName("jTextFieldKFE4SalesOrders"); // NOI18N

        jTextFieldKFE10SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10SalesOrders.setEnabled(false);
        jTextFieldKFE10SalesOrders.setName("jTextFieldKFE10SalesOrders"); // NOI18N

        jTextFieldKFE49SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49SalesOrders.setEnabled(false);
        jTextFieldKFE49SalesOrders.setName("jTextFieldKFE49SalesOrders"); // NOI18N

        jTextFieldKFE7SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7SalesOrders.setEnabled(false);
        jTextFieldKFE7SalesOrders.setName("jTextFieldKFE7SalesOrders"); // NOI18N

        jTextFieldKFE13SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13SalesOrders.setEnabled(false);
        jTextFieldKFE13SalesOrders.setName("jTextFieldKFE13SalesOrders"); // NOI18N

        jTextFieldKFE18SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18SalesOrders.setEnabled(false);
        jTextFieldKFE18SalesOrders.setName("jTextFieldKFE18SalesOrders"); // NOI18N

        jTextFieldKFE26StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26StockEndOfPeriod.setName("jTextFieldKFE26StockEndOfPeriod"); // NOI18N

        jTextFieldKFP1StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1StockEndOfPeriod.setName("jTextFieldKFP1StockEndOfPeriod"); // NOI18N

        jTextFieldKFE51StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51StockEndOfPeriod.setName("jTextFieldKFE51StockEndOfPeriod"); // NOI18N

        jTextFieldKFE17StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17StockEndOfPeriod.setName("jTextFieldKFE17StockEndOfPeriod"); // NOI18N

        jTextFieldKFE16StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16StockEndOfPeriod.setName("jTextFieldKFE16StockEndOfPeriod"); // NOI18N

        jTextFieldKFE50StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50StockEndOfPeriod.setName("jTextFieldKFE50StockEndOfPeriod"); // NOI18N

        jTextFieldKFE10StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10StockEndOfPeriod.setName("jTextFieldKFE10StockEndOfPeriod"); // NOI18N

        jTextFieldKFE4StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4StockEndOfPeriod.setName("jTextFieldKFE4StockEndOfPeriod"); // NOI18N

        jTextFieldKFE49StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49StockEndOfPeriod.setName("jTextFieldKFE49StockEndOfPeriod"); // NOI18N

        jTextFieldKFE13StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13StockEndOfPeriod.setName("jTextFieldKFE13StockEndOfPeriod"); // NOI18N

        jTextFieldKFE7StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7StockEndOfPeriod.setName("jTextFieldKFE7StockEndOfPeriod"); // NOI18N

        jTextFieldKFE18StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18StockEndOfPeriod.setName("jTextFieldKFE18StockEndOfPeriod"); // NOI18N

        jTextFieldKFE26OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26OrdersInQueque.setName("jTextFieldKFE26OrdersInQueque"); // NOI18N

        jTextFieldKFP1OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1OrdersInQueque.setName("jTextFieldKFP1OrdersInQueque"); // NOI18N

        jTextFieldKFE51OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51OrdersInQueque.setName("jTextFieldKFE51OrdersInQueque"); // NOI18N

        jTextFieldKFE16OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16OrdersInQueque.setName("jTextFieldKFE16OrdersInQueque"); // NOI18N

        jTextFieldKFE17OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17OrdersInQueque.setName("jTextFieldKFE17OrdersInQueque"); // NOI18N

        jTextFieldKFE50OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50OrdersInQueque.setName("jTextFieldKFE50OrdersInQueque"); // NOI18N

        jTextFieldKFE4OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4OrdersInQueque.setName("jTextFieldKFE4OrdersInQueque"); // NOI18N

        jTextFieldKFE10OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10OrdersInQueque.setName("jTextFieldKFE10OrdersInQueque"); // NOI18N

        jTextFieldKFE49OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49OrdersInQueque.setName("jTextFieldKFE49OrdersInQueque"); // NOI18N

        jTextFieldKFE7OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7OrdersInQueque.setName("jTextFieldKFE7OrdersInQueque"); // NOI18N

        jTextFieldKFE13OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13OrdersInQueque.setName("jTextFieldKFE13OrdersInQueque"); // NOI18N

        jTextFieldKFE18OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18OrdersInQueque.setName("jTextFieldKFE18OrdersInQueque"); // NOI18N

        jTextFieldKFE26WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26WorkInProgress.setName("jTextFieldKFE26WorkInProgress"); // NOI18N

        jTextFieldKFP1WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1WorkInProgress.setName("jTextFieldKFP1WorkInProgress"); // NOI18N

        jTextFieldKFE51WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51WorkInProgress.setName("jTextFieldKFE51WorkInProgress"); // NOI18N

        jTextFieldKFE16WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16WorkInProgress.setName("jTextFieldKFE16WorkInProgress"); // NOI18N

        jTextFieldKFE17WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17WorkInProgress.setName("jTextFieldKFE17WorkInProgress"); // NOI18N

        jTextFieldKFE50WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50WorkInProgress.setName("jTextFieldKFE50WorkInProgress"); // NOI18N

        jTextFieldKFE4WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4WorkInProgress.setName("jTextFieldKFE4WorkInProgress"); // NOI18N

        jTextFieldKFE10WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10WorkInProgress.setName("jTextFieldKFE10WorkInProgress"); // NOI18N

        jTextFieldKFE49WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49WorkInProgress.setName("jTextFieldKFE49WorkInProgress"); // NOI18N

        jTextFieldKFE7WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7WorkInProgress.setName("jTextFieldKFE7WorkInProgress"); // NOI18N

        jTextFieldKFE13WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13WorkInProgress.setName("jTextFieldKFE13WorkInProgress"); // NOI18N

        jTextFieldKFE18WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18WorkInProgress.setName("jTextFieldKFE18WorkInProgress"); // NOI18N

        jTextFieldKFE26ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26ProductionOrders.setEnabled(false);
        jTextFieldKFE26ProductionOrders.setName("jTextFieldKFE26ProductionOrders"); // NOI18N

        jTextFieldKFE51ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51ProductionOrders.setEnabled(false);
        jTextFieldKFE51ProductionOrders.setName("jTextFieldKFE51ProductionOrders"); // NOI18N

        jTextFieldKFP1ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1ProductionOrders.setEnabled(false);
        jTextFieldKFP1ProductionOrders.setName("jTextFieldKFP1ProductionOrders"); // NOI18N

        jTextFieldKFE16ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16ProductionOrders.setEnabled(false);
        jTextFieldKFE16ProductionOrders.setName("jTextFieldKFE16ProductionOrders"); // NOI18N

        jTextFieldKFE17ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17ProductionOrders.setEnabled(false);
        jTextFieldKFE17ProductionOrders.setName("jTextFieldKFE17ProductionOrders"); // NOI18N

        jTextFieldKFE50ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50ProductionOrders.setEnabled(false);
        jTextFieldKFE50ProductionOrders.setName("jTextFieldKFE50ProductionOrders"); // NOI18N

        jTextFieldKFE4ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4ProductionOrders.setEnabled(false);
        jTextFieldKFE4ProductionOrders.setName("jTextFieldKFE4ProductionOrders"); // NOI18N

        jTextFieldKFE10ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10ProductionOrders.setEnabled(false);
        jTextFieldKFE10ProductionOrders.setName("jTextFieldKFE10ProductionOrders"); // NOI18N

        jTextFieldKFE49ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49ProductionOrders.setEnabled(false);
        jTextFieldKFE49ProductionOrders.setName("jTextFieldKFE49ProductionOrders"); // NOI18N

        jTextFieldKFE7ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7ProductionOrders.setEnabled(false);
        jTextFieldKFE7ProductionOrders.setName("jTextFieldKFE7ProductionOrders"); // NOI18N

        jTextFieldKFE13ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13ProductionOrders.setEnabled(false);
        jTextFieldKFE13ProductionOrders.setName("jTextFieldKFE13ProductionOrders"); // NOI18N

        jTextFieldKFE18ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18ProductionOrders.setEnabled(false);
        jTextFieldKFE18ProductionOrders.setName("jTextFieldKFE18ProductionOrders"); // NOI18N

        jTextFieldKFP1PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFP1PlannedStock.setName("jTextFieldKFP1PlannedStock"); // NOI18N
        jTextFieldKFP1PlannedStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKFP1PlannedStockActionPerformed(evt);
            }
        });

        jTextFieldKFE26PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26PlannedStock.setName("jTextFieldKFE26PlannedStock"); // NOI18N

        jTextFieldKFE51PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE51PlannedStock.setName("jTextFieldKFE51PlannedStock"); // NOI18N

        jTextFieldKFE16PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE16PlannedStock.setName("jTextFieldKFE16PlannedStock"); // NOI18N

        jTextFieldKFE17PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17PlannedStock.setName("jTextFieldKFE17PlannedStock"); // NOI18N

        jTextFieldKFE50PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE50PlannedStock.setName("jTextFieldKFE50PlannedStock"); // NOI18N

        jTextFieldKFE4PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE4PlannedStock.setName("jTextFieldKFE4PlannedStock"); // NOI18N

        jTextFieldKFE10PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE10PlannedStock.setName("jTextFieldKFE10PlannedStock"); // NOI18N

        jTextFieldKFE49PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE49PlannedStock.setName("jTextFieldKFE49PlannedStock"); // NOI18N

        jTextFieldKFE7PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE7PlannedStock.setName("jTextFieldKFE7PlannedStock"); // NOI18N

        jTextFieldKFE13PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE13PlannedStock.setName("jTextFieldKFE13PlannedStock"); // NOI18N

        jTextFieldKFE18PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE18PlannedStock.setName("jTextFieldKFE18PlannedStock"); // NOI18N

        jLabelKFPedalCpl.setText(bundle.getString("PedalCpl")); // NOI18N

        jLabelKFFahrradOPedal.setText(bundle.getString("Fahrrad o. Pedal")); // NOI18N
        jLabelKFFahrradOPedal.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFFahrradOPedal.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFFahrradOPedal.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFLenkerCpl.setText(bundle.getString("Lenker cpl.")); // NOI18N
        jLabelKFLenkerCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFLenkerCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFLenkerCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelSattelCpl.setText(bundle.getString("Sattel cpl.")); // NOI18N
        jLabelSattelCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelSattelCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelSattelCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFRahmenURaeder.setText(bundle.getString("Rahmen u. Raeder")); // NOI18N
        jLabelKFRahmenURaeder.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFRahmenURaeder.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFRahmenURaeder.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFHinterradgruppe.setText(bundle.getString("Hinterradgruppe")); // NOI18N
        jLabelKFHinterradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFHinterradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFHinterradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFASchutzblechH.setText(bundle.getString("Schutzblech h.")); // NOI18N
        jLabelKFASchutzblechH.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFASchutzblechH.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFASchutzblechH.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFVorderradCpl.setText(bundle.getString("Vorderrad cpl.")); // NOI18N
        jLabelKFVorderradCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFVorderradCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFVorderradCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFVorderradgruppe.setText(bundle.getString("Vorderradgruppe")); // NOI18N
        jLabelKFVorderradgruppe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelKFVorderradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFVorderradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFVorderradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFSchutzblechV.setText(bundle.getString("Schutzblech v.")); // NOI18N
        jLabelKFSchutzblechV.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFSchutzblechV.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFSchutzblechV.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFRahmen.setText(bundle.getString("Rahmen")); // NOI18N
        jLabelKFRahmen.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFRahmen.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFRahmen.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel81.setText("E26");
        jLabel81.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel81.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel81.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel82.setText("P1");
        jLabel82.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel82.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel82.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel83.setText("E51");
        jLabel83.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel83.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel83.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel84.setText("E16");
        jLabel84.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel84.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel84.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel85.setText("E17");
        jLabel85.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel85.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel85.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel86.setText("E50");
        jLabel86.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel86.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel86.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel87.setText("E4");
        jLabel87.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel87.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel87.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel88.setText("E10");
        jLabel88.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel88.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel88.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel89.setText("E49");
        jLabel89.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel89.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel89.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel90.setText("E7");
        jLabel90.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel90.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel90.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel91.setText("E13");
        jLabel91.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel91.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel91.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel92.setText("E18");
        jLabel92.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel92.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel92.setPreferredSize(new java.awt.Dimension(60, 16));

        jTextFieldKFE26SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE26SalesOrders.setEnabled(false);
        jTextFieldKFE26SalesOrders.setName("jTextFieldKFE26SalesOrders"); // NOI18N

        jTextFieldKFE17SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldKFE17SalesOrders.setEnabled(false);
        jTextFieldKFE17SalesOrders.setName("jTextFieldKFE17SalesOrders"); // NOI18N

        jLabelKFPlannedStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelKFPlannedStock.setText(bundle.getString("PlannedStock")); // NOI18N

        jLabelKFE26OrdersInQueque.setText("0");
        jLabelKFE26OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE26OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE26OrdersInQueque.setName("jLabelKFE26OrdersInQueque"); // NOI18N
        jLabelKFE26OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE51OrdersInQueque.setText("0");
        jLabelKFE51OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE51OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE51OrdersInQueque.setName("jLabelKFE51OrdersInQueque"); // NOI18N
        jLabelKFE51OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE16OrdersInQueque.setText("0");
        jLabelKFE16OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE16OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE16OrdersInQueque.setName("jLabelKFE16OrdersInQueque"); // NOI18N
        jLabelKFE16OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE17OrdersInQueque.setText("0");
        jLabelKFE17OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE17OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE17OrdersInQueque.setName("jLabelKFE17OrdersInQueque"); // NOI18N
        jLabelKFE17OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE50OrdersInQueque.setText("0");
        jLabelKFE50OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE50OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE50OrdersInQueque.setName("jLabelKFE50OrdersInQueque"); // NOI18N
        jLabelKFE50OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE4OrdersInQueque.setText("0");
        jLabelKFE4OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE4OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE4OrdersInQueque.setName("jLabelKFE4OrdersInQueque"); // NOI18N
        jLabelKFE4OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE10OrdersInQueque.setText("0");
        jLabelKFE10OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE10OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE10OrdersInQueque.setName("jLabelKFE10OrdersInQueque"); // NOI18N
        jLabelKFE10OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE49OrdersInQueque.setText("0");
        jLabelKFE49OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE49OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE49OrdersInQueque.setName("jLabelKFE49OrdersInQueque"); // NOI18N
        jLabelKFE49OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE7OrdersInQueque.setText("0");
        jLabelKFE7OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE7OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE7OrdersInQueque.setName("jLabelKFE7OrdersInQueque"); // NOI18N
        jLabelKFE7OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE13OrdersInQueque.setText("0");
        jLabelKFE13OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE13OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE13OrdersInQueque.setName("jLabelKFE13OrdersInQueque"); // NOI18N
        jLabelKFE13OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelKFE18OrdersInQueque.setText("0");
        jLabelKFE18OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelKFE18OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelKFE18OrdersInQueque.setName("jLabelKFE18OrdersInQueque"); // NOI18N
        jLabelKFE18OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        javax.swing.GroupLayout jPanelKFLayout = new javax.swing.GroupLayout(jPanelKF);
        jPanelKF.setLayout(jPanelKFLayout);
        jPanelKFLayout.setHorizontalGroup(
            jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanelKFLayout.createSequentialGroup()
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelKFLayout.createSequentialGroup()
                                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                                .addComponent(jLabelKFKinderfahrrad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createSequentialGroup()
                                                .addComponent(jLabelKFVorderradCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelKFPedalCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelKFFahrradOPedal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelKFLenkerCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelSattelCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelKFRahmenURaeder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelKFVorderradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelKFSchutzblechV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelKFRahmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanelKFLayout.createSequentialGroup()
                                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelKFASchutzblechH, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(jLabelKFHinterradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelKFE4OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE50OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE51OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE10OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE49OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE7OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE13OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE18OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldKFP1SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldKFE51SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldKFE26SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldKFE50SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldKFE17SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldKFE16SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldKFE49SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldKFE10SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldKFE4SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldKFE18SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldKFE13SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldKFE7SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelKFSalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addComponent(jLabelKFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldKFP1PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE51PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE26PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE50PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE17PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE49PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE10PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE4PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE18PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE13PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE7PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldKFP1StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE51StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE26StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldKFE50StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE17StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE16StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE49StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE10StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE4StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE18StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE13StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE7StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelKFStockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldKFP1OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE51OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE26OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldKFE50OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE17OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE16OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE49OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE10OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE4OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE18OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE13OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE7OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelKFOrdersInQueue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelKFLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jTextFieldKFP1WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE26WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE51WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldKFE50WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldKFE17WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jTextFieldKFE16WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE49WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE10WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldKFE4WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE18WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE13WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldKFE7WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabelKFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFP1ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE51ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE26ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldKFE50ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKFE17ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldKFE16ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE49ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE10ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE4ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldKFE18ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldKFE13ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldKFE7ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(20, 20, 20))
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
        );
        jPanelKFLayout.setVerticalGroup(
            jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelKFLayout.createSequentialGroup()
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelKFOrdersInQueue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFStockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFSalesOrders))
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKFP1StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFP1OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFP1WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFP1ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFP1PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFP1SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createSequentialGroup()
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelKFKinderfahrrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKFE26StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE26WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE26ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE26PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE26SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFPedalCpl)
                    .addComponent(jLabelKFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKFE51SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE51StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE51OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE51WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE51ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE51PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFFahrradOPedal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE51OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKFE16StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE16WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE16ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFLenkerCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldKFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldKFE16SalesOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createSequentialGroup()
                        .addComponent(jTextFieldKFE17ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKFE50SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE50StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE50OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE50WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE50ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldKFE50PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelKFLayout.createSequentialGroup()
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelKFLayout.createSequentialGroup()
                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSattelCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldKFE17PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldKFE17StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldKFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldKFE17WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createSequentialGroup()
                                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldKFE17SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelKFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))
                        .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelKFRahmenURaeder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKFE50OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldKFE4StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldKFE4OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldKFE4WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldKFE4ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldKFE4PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldKFE4SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelKFE4OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelKFHinterradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKFASchutzblechH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE10ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE10OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKFE49SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE49PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE49StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE49OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE49WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE49ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE49OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFVorderradCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKFVorderradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE7ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE7OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKFSchutzblechV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE13ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE13OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKFRahmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKFE18ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKFE18OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab(bundle.getString("Kinderfahrrad"), jPanelKF); // NOI18N

        jPanelDF.setMaximumSize(new java.awt.Dimension(16, 28));
        jPanelDF.setPreferredSize(new java.awt.Dimension(16, 28));

        jLabel13.setMaximumSize(new java.awt.Dimension(30, 14));
        jLabel13.setMinimumSize(new java.awt.Dimension(30, 14));

        jLabelDFLadiesCycle.setText(bundle.getString("Damenfahrrad")); // NOI18N
        jLabelDFLadiesCycle.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFLadiesCycle.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFLadiesCycle.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFSalesOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFSalesOrders.setText(bundle.getString("SalesOrders")); // NOI18N

        jLabelDFStockEndOfPeriod.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFStockEndOfPeriod.setText(bundle.getString("StockEndOfPeriod")); // NOI18N

        jLabelDFOrdersInQueue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFOrdersInQueue.setText(bundle.getString("OrdersInQueue")); // NOI18N

        jLabelDFWorkInProgress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFWorkInProgress.setText(bundle.getString("WorkInProgress")); // NOI18N

        jLabelDFProductionOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFProductionOrders.setText(bundle.getString("ProductionOrders")); // NOI18N

        jTextFieldDFP2SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2SalesOrders.setEnabled(false);
        jTextFieldDFP2SalesOrders.setName("jTextFieldDFP2SalesOrders"); // NOI18N

        jTextFieldDFE56SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56SalesOrders.setEnabled(false);
        jTextFieldDFE56SalesOrders.setName("jTextFieldDFE56SalesOrders"); // NOI18N

        jTextFieldDFE16SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16SalesOrders.setEnabled(false);
        jTextFieldDFE16SalesOrders.setName("jTextFieldDFE16SalesOrders"); // NOI18N

        jTextFieldDFE55SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55SalesOrders.setEnabled(false);
        jTextFieldDFE55SalesOrders.setName("jTextFieldDFE55SalesOrders"); // NOI18N

        jTextFieldDFE5SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5SalesOrders.setEnabled(false);
        jTextFieldDFE5SalesOrders.setName("jTextFieldDFE5*SalesOrders"); // NOI18N

        jTextFieldDFE11SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11SalesOrders.setEnabled(false);
        jTextFieldDFE11SalesOrders.setName("jTextFieldDFE11SalesOrders"); // NOI18N

        jTextFieldDFE54SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54SalesOrders.setEnabled(false);
        jTextFieldDFE54SalesOrders.setName("jTextFieldDFE54SalesOrders"); // NOI18N

        jTextFieldDFE8SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8SalesOrders.setEnabled(false);
        jTextFieldDFE8SalesOrders.setName("jTextFieldDFE8SalesOrders"); // NOI18N

        jTextFieldDFE14SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14SalesOrders.setEnabled(false);
        jTextFieldDFE14SalesOrders.setName("jTextFieldDFE14SalesOrders"); // NOI18N

        jTextFieldDFE19SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19SalesOrders.setEnabled(false);
        jTextFieldDFE19SalesOrders.setName("jTextFieldDFE19SalesOrders"); // NOI18N

        jTextFieldDFE26StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26StockEndOfPeriod.setName("jTextFieldDFE26StockEndOfPeriod"); // NOI18N

        jTextFieldDFP2StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2StockEndOfPeriod.setName("jTextFieldDFP2StockEndOfPeriod"); // NOI18N

        jTextFieldDFE56StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56StockEndOfPeriod.setName("jTextFieldDFE56StockEndOfPeriod"); // NOI18N

        jTextFieldDFE17StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17StockEndOfPeriod.setName("jTextFieldDFE17StockEndOfPeriod"); // NOI18N

        jTextFieldDFE16StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16StockEndOfPeriod.setName("jTextFieldDFE16StockEndOfPeriod"); // NOI18N

        jTextFieldDFE55StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55StockEndOfPeriod.setName("jTextFieldDFE55StockEndOfPeriod"); // NOI18N

        jTextFieldDFE11StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11StockEndOfPeriod.setName("jTextFieldDFE11StockEndOfPeriod"); // NOI18N

        jTextFieldDFE5StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5StockEndOfPeriod.setName("jTextFieldDFE5*StockEndOfPeriod"); // NOI18N

        jTextFieldDFE54StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54StockEndOfPeriod.setName("jTextFieldDFE54StockEndOfPeriod"); // NOI18N

        jTextFieldDFE14StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14StockEndOfPeriod.setName("jTextFieldDFE14StockEndOfPeriod"); // NOI18N

        jTextFieldDFE8StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8StockEndOfPeriod.setName("jTextFieldDFE8StockEndOfPeriod"); // NOI18N

        jTextFieldDFE19StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19StockEndOfPeriod.setName("jTextFieldDFE19StockEndOfPeriod"); // NOI18N

        jTextFieldDFE26OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26OrdersInQueque.setName("jTextFieldDFE26OrdersInQueque"); // NOI18N

        jTextFieldDFP2OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2OrdersInQueque.setName("jTextFieldDFP2OrdersInQueque"); // NOI18N

        jTextFieldDFE56OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56OrdersInQueque.setName("jTextFieldDFE56OrdersInQueque"); // NOI18N

        jTextFieldDFE16OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16OrdersInQueque.setName("jTextFieldDFE16OrdersInQueque"); // NOI18N

        jTextFieldDFE17OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17OrdersInQueque.setName("jTextFieldDFE17OrdersInQueque"); // NOI18N

        jTextFieldDFE55OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55OrdersInQueque.setName("jTextFieldDFE55OrdersInQueque"); // NOI18N

        jTextFieldDFE5OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5OrdersInQueque.setName("jTextFieldDFE5*OrdersInQueque"); // NOI18N

        jTextFieldDFE11OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11OrdersInQueque.setName("jTextFieldDFE11OrdersInQueque"); // NOI18N

        jTextFieldDFE54OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54OrdersInQueque.setName("jTextFieldDFE54OrdersInQueque"); // NOI18N

        jTextFieldDFE8OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8OrdersInQueque.setName("jTextFieldDFE8OrdersInQueque"); // NOI18N

        jTextFieldDFE14OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14OrdersInQueque.setName("jTextFieldDFE14OrdersInQueque"); // NOI18N

        jTextFieldDFE19OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19OrdersInQueque.setName("jTextFieldDFE19OrdersInQueque"); // NOI18N

        jTextFieldDFE26WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26WorkInProgress.setName("jTextFieldDFE26WorkInProgress"); // NOI18N

        jTextFieldDFP2WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2WorkInProgress.setName("jTextFieldDFP2WorkInProgress"); // NOI18N

        jTextFieldDFE56WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56WorkInProgress.setName("jTextFieldDFE56WorkInProgress"); // NOI18N

        jTextFieldDFE16WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16WorkInProgress.setName("jTextFieldDFE16WorkInProgress"); // NOI18N

        jTextFieldDFE17WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17WorkInProgress.setName("jTextFieldDFE17WorkInProgress"); // NOI18N

        jTextFieldDFE55WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55WorkInProgress.setName("jTextFieldDFE55WorkInProgress"); // NOI18N

        jTextFieldDFE5WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5WorkInProgress.setName("jTextFieldDFE5*WorkInProgress"); // NOI18N

        jTextFieldDFE11WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11WorkInProgress.setName("jTextFieldDFE11WorkInProgress"); // NOI18N

        jTextFieldDFE54WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54WorkInProgress.setName("jTextFieldDFE54WorkInProgress"); // NOI18N

        jTextFieldDFE8WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8WorkInProgress.setName("jTextFieldDFE8WorkInProgress"); // NOI18N

        jTextFieldDFE14WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14WorkInProgress.setName("jTextFieldDFE14WorkInProgress"); // NOI18N

        jTextFieldDFE19WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19WorkInProgress.setName("jTextFieldDFE19WorkInProgress"); // NOI18N

        jTextFieldDFE26ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26ProductionOrders.setEnabled(false);
        jTextFieldDFE26ProductionOrders.setName("jTextFieldDFE26ProductionOrders"); // NOI18N

        jTextFieldDFE56ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56ProductionOrders.setEnabled(false);
        jTextFieldDFE56ProductionOrders.setName("jTextFieldDFE56ProductionOrders"); // NOI18N

        jTextFieldDFP2ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2ProductionOrders.setEnabled(false);
        jTextFieldDFP2ProductionOrders.setName("jTextFieldDFP2ProductionOrders"); // NOI18N

        jTextFieldDFE16ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16ProductionOrders.setEnabled(false);
        jTextFieldDFE16ProductionOrders.setName("jTextFieldDFE16ProductionOrders"); // NOI18N

        jTextFieldDFE17ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17ProductionOrders.setEnabled(false);
        jTextFieldDFE17ProductionOrders.setName("jTextFieldDFE17ProductionOrders"); // NOI18N

        jTextFieldDFE55ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55ProductionOrders.setEnabled(false);
        jTextFieldDFE55ProductionOrders.setName("jTextFieldDFE55ProductionOrders"); // NOI18N

        jTextFieldDFE5ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5ProductionOrders.setEnabled(false);
        jTextFieldDFE5ProductionOrders.setName("jTextFieldDFE5*ProductionOrders"); // NOI18N

        jTextFieldDFE11ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11ProductionOrders.setEnabled(false);
        jTextFieldDFE11ProductionOrders.setName("jTextFieldDFE11ProductionOrders"); // NOI18N

        jTextFieldDFE54ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54ProductionOrders.setEnabled(false);
        jTextFieldDFE54ProductionOrders.setName("jTextFieldDFE54ProductionOrders"); // NOI18N

        jTextFieldDFE8ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8ProductionOrders.setEnabled(false);
        jTextFieldDFE8ProductionOrders.setName("jTextFieldDFE8ProductionOrders"); // NOI18N

        jTextFieldDFE14ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14ProductionOrders.setEnabled(false);
        jTextFieldDFE14ProductionOrders.setName("jTextFieldDFE14ProductionOrders"); // NOI18N

        jTextFieldDFE19ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19ProductionOrders.setEnabled(false);
        jTextFieldDFE19ProductionOrders.setName("jTextFieldDFE19ProductionOrders"); // NOI18N

        jTextFieldDFP2PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFP2PlannedStock.setName("jTextFieldDFP2PlannedStock"); // NOI18N

        jTextFieldDFE26PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26PlannedStock.setName("jTextFieldDFE26PlannedStock"); // NOI18N

        jTextFieldDFE56PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE56PlannedStock.setName("jTextFieldDFE56PlannedStock"); // NOI18N

        jTextFieldDFE16PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE16PlannedStock.setName("jTextFieldDFE16PlannedStock"); // NOI18N

        jTextFieldDFE17PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17PlannedStock.setName("jTextFieldDFE17PlannedStock"); // NOI18N

        jTextFieldDFE55PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE55PlannedStock.setName("jTextFieldDFE55PlannedStock"); // NOI18N

        jTextFieldDFE5PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE5PlannedStock.setName("jTextFieldDFE5*PlannedStock"); // NOI18N

        jTextFieldDFE11PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE11PlannedStock.setName("jTextFieldDFE11PlannedStock"); // NOI18N

        jTextFieldDFE54PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE54PlannedStock.setName("jTextFieldDFE54PlannedStock"); // NOI18N

        jTextFieldDFE8PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE8PlannedStock.setName("jTextFieldDFE8PlannedStock"); // NOI18N

        jTextFieldDFE14PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE14PlannedStock.setName("jTextFieldDFE14PlannedStock"); // NOI18N

        jTextFieldDFE19PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE19PlannedStock.setName("jTextFieldDFE19PlannedStock"); // NOI18N

        jLabelDFPedalCpl.setText(bundle.getString("PedalCpl")); // NOI18N

        jLabelDFFahrradOPedal.setText(bundle.getString("Fahrrad o. Pedal")); // NOI18N
        jLabelDFFahrradOPedal.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFFahrradOPedal.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFFahrradOPedal.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFLenkerCpl.setText(bundle.getString("Lenker cpl.")); // NOI18N
        jLabelDFLenkerCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFLenkerCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFLenkerCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFSattelCpl.setText(bundle.getString("Sattel cpl.")); // NOI18N
        jLabelDFSattelCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFSattelCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFSattelCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFRahmenURaeder.setText(bundle.getString("Rahmen u. Raeder")); // NOI18N
        jLabelDFRahmenURaeder.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFRahmenURaeder.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFRahmenURaeder.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFHinterradgruppe.setText(bundle.getString("Hinterradgruppe")); // NOI18N
        jLabelDFHinterradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFHinterradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFHinterradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFASchutzblechH.setText(bundle.getString("Schutzblech h.")); // NOI18N
        jLabelDFASchutzblechH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelDFASchutzblechH.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFASchutzblechH.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFASchutzblechH.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFVorderradCpl.setText(bundle.getString("Vorderrad cpl.")); // NOI18N
        jLabelDFVorderradCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFVorderradCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFVorderradCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFVorderradgruppe.setText(bundle.getString("Vorderradgruppe")); // NOI18N
        jLabelDFVorderradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFVorderradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFVorderradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFSchutzblechV.setText(bundle.getString("Schutzblech v.")); // NOI18N
        jLabelDFSchutzblechV.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFSchutzblechV.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFSchutzblechV.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFRahmen.setText(bundle.getString("Rahmen")); // NOI18N
        jLabelDFRahmen.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFRahmen.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFRahmen.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel93.setText("E26");
        jLabel93.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel93.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel93.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel94.setText("P2");
        jLabel94.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel94.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel94.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel95.setText("E56");
        jLabel95.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel95.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel95.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel96.setText("E16");
        jLabel96.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel96.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel96.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel97.setText("E17");
        jLabel97.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel97.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel97.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel98.setText("E55");
        jLabel98.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel98.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel98.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel99.setText("E5");
        jLabel99.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel99.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel99.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel100.setText("E11");
        jLabel100.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel100.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel100.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel101.setText("E54");
        jLabel101.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel101.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel101.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel102.setText("E8");
        jLabel102.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel102.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel102.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel103.setText("E14");
        jLabel103.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel103.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel103.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel104.setText("E19");
        jLabel104.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel104.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel104.setPreferredSize(new java.awt.Dimension(60, 16));

        jTextFieldDFE26SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE26SalesOrders.setEnabled(false);
        jTextFieldDFE26SalesOrders.setName("jTextFieldDFE26SalesOrders"); // NOI18N

        jTextFieldDFE17SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDFE17SalesOrders.setEnabled(false);
        jTextFieldDFE17SalesOrders.setName("jTextFieldDFE17SalesOrders"); // NOI18N

        jLabelDFPlannedStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDFPlannedStock.setText(bundle.getString("PlannedStock")); // NOI18N

        jLabelDFE26OrdersInQueque.setText("0");
        jLabelDFE26OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE26OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE26OrdersInQueque.setName("jLabelDFE26OrdersInQueque"); // NOI18N
        jLabelDFE26OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE56OrdersInQueque.setText("0");
        jLabelDFE56OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE56OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE56OrdersInQueque.setName("jLabelDFE56OrdersInQueque"); // NOI18N
        jLabelDFE56OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE16OrdersInQueque.setText("0");
        jLabelDFE16OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE16OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE16OrdersInQueque.setName("labelsOrdersInQueque.add(jLabelDFE16OrdersInQueque);"); // NOI18N
        jLabelDFE16OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE17OrdersInQueque.setText("0");
        jLabelDFE17OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE17OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE17OrdersInQueque.setName("jLabelDFE17OrdersInQueque"); // NOI18N
        jLabelDFE17OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE55OrdersInQueque.setText("0");
        jLabelDFE55OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE55OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE55OrdersInQueque.setName("jLabelDFE55OrdersInQueque"); // NOI18N
        jLabelDFE55OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE5OrdersInQueque.setText("0");
        jLabelDFE5OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE5OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE5OrdersInQueque.setName("jLabelDFE5*OrdersInQueque"); // NOI18N
        jLabelDFE5OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE11OrdersInQueque.setText("0");
        jLabelDFE11OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE11OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE11OrdersInQueque.setName("jLabelDFE11OrdersInQueque"); // NOI18N
        jLabelDFE11OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE54OrdersInQueque.setText("0");
        jLabelDFE54OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE54OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE54OrdersInQueque.setName("jLabelDFE54OrdersInQueque"); // NOI18N
        jLabelDFE54OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE8OrdersInQueque.setText("0");
        jLabelDFE8OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE8OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE8OrdersInQueque.setName("jLabelDFE8OrdersInQueque"); // NOI18N
        jLabelDFE8OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE14OrdersInQueque.setText("0");
        jLabelDFE14OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE14OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE14OrdersInQueque.setName("jLabelDFE14OrdersInQueque"); // NOI18N
        jLabelDFE14OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelDFE19OrdersInQueque.setText("0");
        jLabelDFE19OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelDFE19OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelDFE19OrdersInQueque.setName("jLabelDFE19OrdersInQueque"); // NOI18N
        jLabelDFE19OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        javax.swing.GroupLayout jPanelDFLayout = new javax.swing.GroupLayout(jPanelDF);
        jPanelDF.setLayout(jPanelDFLayout);
        jPanelDFLayout.setHorizontalGroup(
            jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addGroup(jPanelDFLayout.createSequentialGroup()
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDFLayout.createSequentialGroup()
                                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                                .addComponent(jLabelDFLadiesCycle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createSequentialGroup()
                                                .addComponent(jLabelDFVorderradCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelDFPedalCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelDFFahrradOPedal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelDFLenkerCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelDFSattelCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelDFRahmenURaeder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelDFVorderradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelDFSchutzblechV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelDFRahmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanelDFLayout.createSequentialGroup()
                                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelDFASchutzblechH, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(jLabelDFHinterradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDFE5OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE55OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE56OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE11OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE54OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE8OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE14OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE19OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDFP2SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDFE56SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldDFE26SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDFE55SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldDFE17SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldDFE16SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDFE54SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldDFE11SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldDFE5SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDFE19SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldDFE14SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldDFE8SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelDFSalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addComponent(jLabelDFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jTextFieldDFP2PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE56PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE26PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE55PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE17PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE54PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE11PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE5PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE19PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE14PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE8PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDFP2StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE56StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE26StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldDFE55StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE17StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE16StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE54StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE11StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE5StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE19StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE14StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE8StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelDFStockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDFP2OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE56OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE26OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldDFE55OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE17OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE16OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE54OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE11OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE5OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE19OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE14OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE8OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelDFOrdersInQueue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDFLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jTextFieldDFP2WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE26WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE56WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDFE55WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldDFE17WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jTextFieldDFE16WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE54WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE11WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDFE5WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE19WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE14WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDFE8WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabelDFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFP2ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE56ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE26ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldDFE55ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDFE17ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldDFE16ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE54ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE11ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE5ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldDFE19ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldDFE14ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldDFE8ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(20, 20, 20))
            .addComponent(jSeparator7)
            .addComponent(jSeparator8)
        );
        jPanelDFLayout.setVerticalGroup(
            jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDFLayout.createSequentialGroup()
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabelDFOrdersInQueue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFStockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFSalesOrders))
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDFP2StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFP2OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFP2WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFP2ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFP2PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFP2SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createSequentialGroup()
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDFLadiesCycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDFE26StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE26WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE26ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE26PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE26SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFPedalCpl)
                    .addComponent(jLabelDFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDFE56SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE56StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE56OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE56WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE56ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE56PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFFahrradOPedal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE56OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDFE16StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE16WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE16ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFLenkerCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldDFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDFE16SalesOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createSequentialGroup()
                        .addComponent(jTextFieldDFE17ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDFE55SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE55StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE55OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE55WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE55ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDFE55PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDFLayout.createSequentialGroup()
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDFLayout.createSequentialGroup()
                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDFSattelCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldDFE17PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDFE17StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDFE17WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createSequentialGroup()
                                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldDFE17SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))
                        .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDFRahmenURaeder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDFE55OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDFE5StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDFE5OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDFE5WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDFE5ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDFE5PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDFE5SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDFE5OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDFHinterradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDFASchutzblechH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE11ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE11OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDFE54SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE54PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE54StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE54OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE54WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE54ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE54OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFVorderradCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDFVorderradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE8ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE8OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDFSchutzblechV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE14ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE14OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDFRahmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDFE19ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDFE19OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab(bundle.getString("Damenfahrrad"), jPanelDF); // NOI18N

        jPanelHF.setMaximumSize(new java.awt.Dimension(16, 28));
        jPanelHF.setPreferredSize(new java.awt.Dimension(16, 28));

        jLabel14.setMaximumSize(new java.awt.Dimension(30, 14));
        jLabel14.setMinimumSize(new java.awt.Dimension(30, 14));

        jLabelHFManCycle.setText(bundle.getString("Herrenfahrrad")); // NOI18N
        jLabelHFManCycle.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFManCycle.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFManCycle.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFSalesOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFSalesOrders.setText(bundle.getString("SalesOrders")); // NOI18N

        jLabelHFStockEndOfPeriod.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFStockEndOfPeriod.setText(bundle.getString("StockEndOfPeriod")); // NOI18N

        jLabelHFOrdersInQueue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFOrdersInQueue.setText(bundle.getString("OrdersInQueue")); // NOI18N

        jLabelHFWorkInProgress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFWorkInProgress.setText(bundle.getString("WorkInProgress")); // NOI18N

        jLabelHFProductionOrders.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFProductionOrders.setText(bundle.getString("ProductionOrders")); // NOI18N

        jTextFieldHFP3SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3SalesOrders.setEnabled(false);
        jTextFieldHFP3SalesOrders.setName("jTextFieldHFP3SalesOrders"); // NOI18N

        jTextFieldHFE31SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31SalesOrders.setEnabled(false);
        jTextFieldHFE31SalesOrders.setName("jTextFieldHFE31SalesOrders"); // NOI18N

        jTextFieldHFE16SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16SalesOrders.setEnabled(false);
        jTextFieldHFE16SalesOrders.setName("jTextFieldHFE16SalesOrders"); // NOI18N

        jTextFieldHFE30SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30SalesOrders.setEnabled(false);
        jTextFieldHFE30SalesOrders.setName("jTextFieldHFE30SalesOrders"); // NOI18N

        jTextFieldHFE6SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6SalesOrders.setEnabled(false);
        jTextFieldHFE6SalesOrders.setName("jTextFieldHFE6*SalesOrders"); // NOI18N

        jTextFieldHFE12SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12SalesOrders.setEnabled(false);
        jTextFieldHFE12SalesOrders.setName("jTextFieldHFE12SalesOrders"); // NOI18N

        jTextFieldHFE29SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29SalesOrders.setEnabled(false);
        jTextFieldHFE29SalesOrders.setName("jTextFieldHFE29SalesOrders"); // NOI18N

        jTextFieldHFE9SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9SalesOrders.setEnabled(false);
        jTextFieldHFE9SalesOrders.setName("jTextFieldHFE9SalesOrders"); // NOI18N

        jTextFieldHFE15SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15SalesOrders.setEnabled(false);
        jTextFieldHFE15SalesOrders.setName("jTextFieldHFE15SalesOrders"); // NOI18N

        jTextFieldHFE20SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20SalesOrders.setEnabled(false);
        jTextFieldHFE20SalesOrders.setName("jTextFieldHFE20SalesOrders"); // NOI18N

        jTextFieldHFE26StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26StockEndOfPeriod.setName("jTextFieldHFE26StockEndOfPeriod"); // NOI18N

        jTextFieldHFP3StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3StockEndOfPeriod.setName("jTextFieldHFP3StockEndOfPeriod"); // NOI18N

        jTextFieldHFE31StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31StockEndOfPeriod.setName("jTextFieldHFE31StockEndOfPeriod"); // NOI18N

        jTextFieldHFE17StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17StockEndOfPeriod.setName("jTextFieldHFE17StockEndOfPeriod"); // NOI18N

        jTextFieldHFE16StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16StockEndOfPeriod.setName("jTextFieldHFE16StockEndOfPeriod"); // NOI18N

        jTextFieldHFE30StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30StockEndOfPeriod.setName("jTextFieldHFE30StockEndOfPeriod"); // NOI18N

        jTextFieldHFE12StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12StockEndOfPeriod.setName("jTextFieldHFE12StockEndOfPeriod"); // NOI18N

        jTextFieldHFE6StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6StockEndOfPeriod.setName("jTextFieldHFE6*StockEndOfPeriod"); // NOI18N

        jTextFieldHFE29StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29StockEndOfPeriod.setName("jTextFieldHFE29StockEndOfPeriod"); // NOI18N

        jTextFieldHFE15StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15StockEndOfPeriod.setName("jTextFieldHFE15StockEndOfPeriod"); // NOI18N

        jTextFieldHFE9StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9StockEndOfPeriod.setName("jTextFieldHFE9StockEndOfPeriod"); // NOI18N

        jTextFieldHFE20StockEndOfPeriod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20StockEndOfPeriod.setName("jTextFieldHFE20StockEndOfPeriod"); // NOI18N

        jTextFieldHFE26OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26OrdersInQueque.setName("jTextFieldHFE26OrdersInQueque"); // NOI18N

        jTextFieldHFP3OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3OrdersInQueque.setName("jTextFieldHFP3OrdersInQueque"); // NOI18N

        jTextFieldHFE31OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31OrdersInQueque.setName("jTextFieldHFE31OrdersInQueque"); // NOI18N

        jTextFieldHFE16OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16OrdersInQueque.setName("jTextFieldHFE16OrdersInQueque"); // NOI18N

        jTextFieldHFE17OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17OrdersInQueque.setName("jTextFieldHFE17OrdersInQueque"); // NOI18N

        jTextFieldHFE30OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30OrdersInQueque.setName("jTextFieldHFE30OrdersInQueque"); // NOI18N

        jTextFieldHFE6OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6OrdersInQueque.setName("jTextFieldHFE6*OrdersInQuequeOrdersInQueque"); // NOI18N

        jTextFieldHFE12OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12OrdersInQueque.setName("jTextFieldHFE12OrdersInQueque"); // NOI18N

        jTextFieldHFE29OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29OrdersInQueque.setName("jTextFieldHFE29OrdersInQueque"); // NOI18N

        jTextFieldHFE9OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9OrdersInQueque.setName("jTextFieldHFE9OrdersInQueque"); // NOI18N

        jTextFieldHFE15OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15OrdersInQueque.setName("jTextFieldHFE15OrdersInQueque"); // NOI18N

        jTextFieldHFE20OrdersInQueque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20OrdersInQueque.setName("jTextFieldHFE20OrdersInQueque"); // NOI18N

        jTextFieldHFE26WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26WorkInProgress.setName("jTextFieldHFE26WorkInProgress"); // NOI18N

        jTextFieldHFP3WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3WorkInProgress.setName("jTextFieldHFP3WorkInProgress"); // NOI18N

        jTextFieldHFE31WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31WorkInProgress.setName("jTextFieldHFE31WorkInProgress"); // NOI18N

        jTextFieldHFE16WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16WorkInProgress.setName("jTextFieldHFE16WorkInProgress"); // NOI18N

        jTextFieldHFE17WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17WorkInProgress.setName("jTextFieldHFE17WorkInProgress"); // NOI18N

        jTextFieldHFE30WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30WorkInProgress.setName("jTextFieldHFE30WorkInProgress"); // NOI18N

        jTextFieldHFE6WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6WorkInProgress.setName("jTextFieldHFE6*WorkInProgress"); // NOI18N

        jTextFieldHFE12WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12WorkInProgress.setName("jTextFieldHFE12WorkInProgress"); // NOI18N

        jTextFieldHFE29WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29WorkInProgress.setName("jTextFieldHFE29WorkInProgress"); // NOI18N

        jTextFieldHFE9WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9WorkInProgress.setName("jTextFieldHFE9WorkInProgress"); // NOI18N

        jTextFieldHFE15WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15WorkInProgress.setName("jTextFieldHFE15WorkInProgress"); // NOI18N

        jTextFieldHFE20WorkInProgress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20WorkInProgress.setName("jTextFieldHFE20WorkInProgress"); // NOI18N

        jTextFieldHFE26ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26ProductionOrders.setEnabled(false);
        jTextFieldHFE26ProductionOrders.setName("jTextFieldHFE26ProductionOrders"); // NOI18N

        jTextFieldHFE31ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31ProductionOrders.setEnabled(false);
        jTextFieldHFE31ProductionOrders.setName("jTextFieldHFE31ProductionOrders"); // NOI18N

        jTextFieldHFP3ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3ProductionOrders.setEnabled(false);
        jTextFieldHFP3ProductionOrders.setName("jTextFieldHFP3ProductionOrders"); // NOI18N

        jTextFieldHFE16ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16ProductionOrders.setEnabled(false);
        jTextFieldHFE16ProductionOrders.setName("jTextFieldHFE16ProductionOrders"); // NOI18N

        jTextFieldHFE17ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17ProductionOrders.setEnabled(false);
        jTextFieldHFE17ProductionOrders.setName("jTextFieldHFE17ProductionOrders"); // NOI18N

        jTextFieldHFE30ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30ProductionOrders.setEnabled(false);
        jTextFieldHFE30ProductionOrders.setName("jTextFieldHFE30ProductionOrders"); // NOI18N

        jTextFieldHFE6ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6ProductionOrders.setEnabled(false);
        jTextFieldHFE6ProductionOrders.setName("jTextFieldHFE6*ProductionOrders"); // NOI18N

        jTextFieldHFE12ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12ProductionOrders.setEnabled(false);
        jTextFieldHFE12ProductionOrders.setName("jTextFieldHFE12ProductionOrders"); // NOI18N

        jTextFieldHFE29ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29ProductionOrders.setEnabled(false);
        jTextFieldHFE29ProductionOrders.setName("jTextFieldHFE29ProductionOrders"); // NOI18N

        jTextFieldHFE9ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9ProductionOrders.setEnabled(false);
        jTextFieldHFE9ProductionOrders.setName("jTextFieldHFE9ProductionOrders"); // NOI18N

        jTextFieldHFE15ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15ProductionOrders.setEnabled(false);
        jTextFieldHFE15ProductionOrders.setName("jTextFieldHFE15ProductionOrders"); // NOI18N

        jTextFieldHFE20ProductionOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20ProductionOrders.setEnabled(false);
        jTextFieldHFE20ProductionOrders.setName("jTextFieldHFE20ProductionOrders"); // NOI18N

        jTextFieldHFP3PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFP3PlannedStock.setName("jTextFieldHFP3PlannedStock"); // NOI18N

        jTextFieldHFE26PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26PlannedStock.setName("jTextFieldHFE26PlannedStock"); // NOI18N

        jTextFieldHFE31PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE31PlannedStock.setName("jTextFieldHFE31PlannedStock"); // NOI18N

        jTextFieldHFE16PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE16PlannedStock.setName("jTextFieldHFE16PlannedStock"); // NOI18N

        jTextFieldHFE17PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17PlannedStock.setName("jTextFieldHFE17PlannedStock"); // NOI18N

        jTextFieldHFE30PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE30PlannedStock.setName("jTextFieldHFE30PlannedStock"); // NOI18N

        jTextFieldHFE6PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE6PlannedStock.setName("jTextFieldHFE6*PlannedStock"); // NOI18N

        jTextFieldHFE12PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE12PlannedStock.setName("jTextFieldHFE12PlannedStock"); // NOI18N

        jTextFieldHFE29PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE29PlannedStock.setName("jTextFieldHFE29PlannedStock"); // NOI18N

        jTextFieldHFE9PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE9PlannedStock.setName("jTextFieldHFE9PlannedStock"); // NOI18N

        jTextFieldHFE15PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE15PlannedStock.setName("jTextFieldHFE15PlannedStock"); // NOI18N

        jTextFieldHFE20PlannedStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE20PlannedStock.setName("jTextFieldHFE20PlannedStock"); // NOI18N

        jLabelHFPedalCpl.setText(bundle.getString("PedalCpl")); // NOI18N

        jLabelHFFahrradOPedal.setText(bundle.getString("Fahrrad o. Pedal")); // NOI18N
        jLabelHFFahrradOPedal.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFFahrradOPedal.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFFahrradOPedal.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFLenkerCpl.setText(bundle.getString("Lenker cpl.")); // NOI18N
        jLabelHFLenkerCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFLenkerCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFLenkerCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFSattelCpl.setText(bundle.getString("Sattel cpl.")); // NOI18N
        jLabelHFSattelCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFSattelCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFSattelCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFRahmenURaeder.setText(bundle.getString("Rahmen u. Raeder")); // NOI18N
        jLabelHFRahmenURaeder.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFRahmenURaeder.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFRahmenURaeder.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFHinterradgruppe.setText(bundle.getString("Hinterradgruppe")); // NOI18N
        jLabelHFHinterradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFHinterradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFHinterradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFASchutzblechH.setText(bundle.getString("Schutzblech h.")); // NOI18N
        jLabelHFASchutzblechH.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFASchutzblechH.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFASchutzblechH.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFVorderradCpl.setText(bundle.getString("Vorderrad cpl.")); // NOI18N
        jLabelHFVorderradCpl.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFVorderradCpl.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFVorderradCpl.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFVorderradgruppe.setText(bundle.getString("Vorderradgruppe")); // NOI18N
        jLabelHFVorderradgruppe.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFVorderradgruppe.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFVorderradgruppe.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFSchutzblechV.setText(bundle.getString("Schutzblech v.")); // NOI18N
        jLabelHFSchutzblechV.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFSchutzblechV.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFSchutzblechV.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFRahmen.setText(bundle.getString("Rahmen")); // NOI18N
        jLabelHFRahmen.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFRahmen.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFRahmen.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel105.setText("E26");
        jLabel105.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel105.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel105.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel106.setText("P3");
        jLabel106.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel106.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel106.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel107.setText("E31");
        jLabel107.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel107.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel107.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel108.setText("E16");
        jLabel108.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel108.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel108.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel109.setText("E17");
        jLabel109.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel109.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel109.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel110.setText("E30");
        jLabel110.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel110.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel110.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel111.setText("E6");
        jLabel111.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel111.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel111.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel112.setText("E12");
        jLabel112.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel112.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel112.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel113.setText("E29");
        jLabel113.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel113.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel113.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel114.setText("E9");
        jLabel114.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel114.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel114.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel115.setText("E15");
        jLabel115.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel115.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel115.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabel116.setText("E20");
        jLabel116.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel116.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabel116.setPreferredSize(new java.awt.Dimension(60, 16));

        jTextFieldHFE26SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE26SalesOrders.setEnabled(false);
        jTextFieldHFE26SalesOrders.setName("jTextFieldHFE26SalesOrders"); // NOI18N

        jTextFieldHFE17SalesOrders.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHFE17SalesOrders.setEnabled(false);
        jTextFieldHFE17SalesOrders.setName("jTextFieldHFE17SalesOrders"); // NOI18N

        jLabelHFPlannedStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHFPlannedStock.setText(bundle.getString("PlannedStock")); // NOI18N

        jLabelHFE26OrdersInQueque.setText("0");
        jLabelHFE26OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE26OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE26OrdersInQueque.setName("jLabelHFE26OrdersInQueque"); // NOI18N
        jLabelHFE26OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE31OrdersInQueque.setText("0");
        jLabelHFE31OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE31OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE31OrdersInQueque.setName("jLabelHFE31OrdersInQueque"); // NOI18N
        jLabelHFE31OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE16OrdersInQueque.setText("0");
        jLabelHFE16OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE16OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE16OrdersInQueque.setName("jLabelHFE16OrdersInQueque"); // NOI18N
        jLabelHFE16OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE17OrdersInQueque.setText("0");
        jLabelHFE17OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE17OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE17OrdersInQueque.setName("jLabelHFE17OrdersInQueque"); // NOI18N
        jLabelHFE17OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE30OrdersInQueque.setText("0");
        jLabelHFE30OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE30OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE30OrdersInQueque.setName("jLabelHFE30OrdersInQueque"); // NOI18N
        jLabelHFE30OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE6OrdersInQueque.setText("0");
        jLabelHFE6OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE6OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE6OrdersInQueque.setName("jLabelHFE6*OrdersInQueque"); // NOI18N
        jLabelHFE6OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE12OrdersInQueque.setText("0");
        jLabelHFE12OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE12OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE12OrdersInQueque.setName("jLabelHFE12OrdersInQueque"); // NOI18N
        jLabelHFE12OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE29OrdersInQueque.setText("0");
        jLabelHFE29OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE29OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE29OrdersInQueque.setName("jLabelHFE29OrdersInQueque"); // NOI18N
        jLabelHFE29OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE9OrdersInQueque.setText("0");
        jLabelHFE9OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE9OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE9OrdersInQueque.setName("jLabelHFE9OrdersInQueque"); // NOI18N
        jLabelHFE9OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE15OrdersInQueque.setText("0");
        jLabelHFE15OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE15OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE15OrdersInQueque.setName("jLabelHFE15OrdersInQueque"); // NOI18N
        jLabelHFE15OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        jLabelHFE20OrdersInQueque.setText("0");
        jLabelHFE20OrdersInQueque.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabelHFE20OrdersInQueque.setMinimumSize(new java.awt.Dimension(60, 16));
        jLabelHFE20OrdersInQueque.setName("jLabelHFE20OrdersInQueque"); // NOI18N
        jLabelHFE20OrdersInQueque.setPreferredSize(new java.awt.Dimension(60, 16));

        javax.swing.GroupLayout jPanelHFLayout = new javax.swing.GroupLayout(jPanelHF);
        jPanelHF.setLayout(jPanelHFLayout);
        jPanelHFLayout.setHorizontalGroup(
            jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9)
            .addComponent(jSeparator10)
            .addGroup(jPanelHFLayout.createSequentialGroup()
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelHFLayout.createSequentialGroup()
                                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                                .addComponent(jLabelHFManCycle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createSequentialGroup()
                                                .addComponent(jLabelHFVorderradCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelHFPedalCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelHFFahrradOPedal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelHFLenkerCpl, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelHFSattelCpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelHFRahmenURaeder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelHFVorderradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(jLabelHFSchutzblechV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelHFRahmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanelHFLayout.createSequentialGroup()
                                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelHFASchutzblechH, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(jLabelHFHinterradgruppe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHFE6OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE30OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE31OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE12OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE29OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE9OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE15OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE20OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldHFP3SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHFE31SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldHFE26SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHFE30SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldHFE17SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldHFE16SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHFE29SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldHFE12SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldHFE6SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHFE20SalesOrders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jTextFieldHFE15SalesOrders, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldHFE9SalesOrders, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelHFSalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addComponent(jLabelHFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jTextFieldHFP3PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE31PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE26PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE30PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE17PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE29PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE12PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE6PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE20PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE15PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE9PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldHFP3StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE31StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE26StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldHFE30StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE17StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE16StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE29StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE12StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE6StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE20StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE15StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE9StockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelHFStockEndOfPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldHFP3OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE31OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE26OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldHFE30OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE17OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE16OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE29OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE12OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE6OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE20OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE15OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE9OrdersInQueque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelHFOrdersInQueue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHFLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jTextFieldHFP3WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE26WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE31WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldHFE30WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldHFE17WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jTextFieldHFE16WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE29WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE12WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldHFE6WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE20WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE15WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldHFE9WorkInProgress, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabelHFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFP3ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE31ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE26ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldHFE30ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHFE17ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextFieldHFE16ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE29ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE12ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE6ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldHFE20ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextFieldHFE15ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldHFE9ProductionOrders, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(20, 20, 20))
            .addComponent(jSeparator11)
            .addComponent(jSeparator12)
        );
        jPanelHFLayout.setVerticalGroup(
            jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHFLayout.createSequentialGroup()
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelHFOrdersInQueue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFWorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFPlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFStockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFSalesOrders))
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldHFP3StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFP3OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFP3WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFP3ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFP3PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFP3SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createSequentialGroup()
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHFManCycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHFE26StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE26WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE26ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE26PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE26SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFPedalCpl)
                    .addComponent(jLabelHFE26OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHFE31SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE31StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE31OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE31WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE31ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE31PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFFahrradOPedal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE31OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldHFE16StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE16WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE16ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFLenkerCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE16OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldHFE16PlannedStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldHFE16SalesOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createSequentialGroup()
                        .addComponent(jTextFieldHFE17ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldHFE30SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE30StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE30OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE30WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE30ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHFE30PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelHFLayout.createSequentialGroup()
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHFLayout.createSequentialGroup()
                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelHFSattelCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldHFE17PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHFE17StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHFE17WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createSequentialGroup()
                                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldHFE17SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelHFE17OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))
                        .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHFRahmenURaeder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHFE30OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldHFE6StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldHFE6OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldHFE6WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldHFE6ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldHFE6PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldHFE6SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHFE6OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHFHinterradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHFASchutzblechH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE12ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE12OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHFE29SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE29PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE29StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE29OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE29WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE29ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE29OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFVorderradCpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHFVorderradgruppe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE9ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE9OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHFSchutzblechV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE15ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE15OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelHFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHFRahmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20SalesOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20PlannedStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20StockEndOfPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20WorkInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHFE20ProductionOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHFE20OrdersInQueque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabelHFManCycle.getAccessibleContext().setAccessibleName(bundle.getString("Herrenfahrrad")); // NOI18N

        jTabbedPane2.addTab(bundle.getString("Herrenfahrrad"), jPanelHF); // NOI18N

        jScrollPane6.setViewportView(jTabbedPane2);

        javax.swing.GroupLayout jPanelInHouseProductionLayout = new javax.swing.GroupLayout(jPanelInHouseProduction);
        jPanelInHouseProduction.setLayout(jPanelInHouseProductionLayout);
        jPanelInHouseProductionLayout.setHorizontalGroup(
            jPanelInHouseProductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInHouseProductionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanelInHouseProductionLayout.setVerticalGroup(
            jPanelInHouseProductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInHouseProductionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
        );

        jTabbedPan.addTab(bundle.getString("InHauseProduction"), jPanelInHouseProduction); // NOI18N

        jTableWorkloadPlanning.setAutoCreateRowSorter(true);
        jTableWorkloadPlanning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Workplace", "Last Cycle Times", "Capacity Needed", "Overtime p. Day", "Shifts", "Free Capacity", "Workload pct"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableWorkloadPlanning.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableWorkloadPlanning);

        javax.swing.GroupLayout jPanelWorkloadPlanningLayout = new javax.swing.GroupLayout(jPanelWorkloadPlanning);
        jPanelWorkloadPlanning.setLayout(jPanelWorkloadPlanningLayout);
        jPanelWorkloadPlanningLayout.setHorizontalGroup(
            jPanelWorkloadPlanningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1551, Short.MAX_VALUE)
            .addGroup(jPanelWorkloadPlanningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelWorkloadPlanningLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1531, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelWorkloadPlanningLayout.setVerticalGroup(
            jPanelWorkloadPlanningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(jPanelWorkloadPlanningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelWorkloadPlanningLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPan.addTab("Workload Planning", jPanelWorkloadPlanning);

        jTablePurchasingDisposition.setAutoCreateRowSorter(true);
        jTablePurchasingDisposition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Article", "Name", "Mode", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePurchasingDisposition.getTableHeader().setReorderingAllowed(false);
        jTablePurchasingDisposition.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePurchasingDispositionPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePurchasingDisposition);

        jTablePurchasingDispositionIncoming.setAutoCreateRowSorter(true);
        jTablePurchasingDispositionIncoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Article", "Name", "Mode", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePurchasingDispositionIncoming.getTableHeader().setReorderingAllowed(false);
        jTablePurchasingDispositionIncoming.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePurchasingDispositionIncomingPropertyChange(evt);
            }
        });
        jScrollPane10.setViewportView(jTablePurchasingDispositionIncoming);

        jLabelPurchasingDispoOutgoing.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPurchasingDispoOutgoing.setText("Outgoing");

        jLabelPurchasingDispoIncoming.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPurchasingDispoIncoming.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPurchasingDispoIncoming.setText("Incoming");

        javax.swing.GroupLayout jPanelPurchasingDispositionLayout = new javax.swing.GroupLayout(jPanelPurchasingDisposition);
        jPanelPurchasingDisposition.setLayout(jPanelPurchasingDispositionLayout);
        jPanelPurchasingDispositionLayout.setHorizontalGroup(
            jPanelPurchasingDispositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPurchasingDispositionLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPurchasingDispoOutgoing, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabelPurchasingDispoIncoming, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPurchasingDispositionLayout.setVerticalGroup(
            jPanelPurchasingDispositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPurchasingDispositionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelPurchasingDispositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPurchasingDispoOutgoing)
                    .addComponent(jLabelPurchasingDispoIncoming))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPurchasingDispositionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPurchasingDispositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPan.addTab("Purchasing Planning", jPanelPurchasingDisposition);

        jTableStockChange.setAutoCreateRowSorter(true);
        jTableStockChange.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Article", "Name", "Old Stock", "Old Value", "Change", "New Stock", "New Value", "Change Pct"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Double.class, java.lang.Long.class, java.lang.Long.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStockChange.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableStockChange);

        javax.swing.GroupLayout jPanelStockChangeLayout = new javax.swing.GroupLayout(jPanelStockChange);
        jPanelStockChange.setLayout(jPanelStockChangeLayout);
        jPanelStockChangeLayout.setHorizontalGroup(
            jPanelStockChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1551, Short.MAX_VALUE)
            .addGroup(jPanelStockChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelStockChangeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1531, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelStockChangeLayout.setVerticalGroup(
            jPanelStockChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(jPanelStockChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelStockChangeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPan.addTab("Stock Change", jPanelStockChange);

        jTableEProdList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Article", "Name", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEProdList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableEProdList.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableEProdList);
        if (jTableEProdList.getColumnModel().getColumnCount() > 0) {
            jTableEProdList.getColumnModel().getColumn(0).setResizable(false);
            jTableEProdList.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButtonMoveDown.setText("Down");
        jButtonMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveDownActionPerformed(evt);
            }
        });

        jButtonMoveUp.setText("Up");
        jButtonMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveUpActionPerformed(evt);
            }
        });

        jButtonProdListReset.setText("Reset");
        jButtonProdListReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdListResetActionPerformed(evt);
            }
        });

        jButtonProdListApply.setText("Apply");
        jButtonProdListApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdListApplyActionPerformed(evt);
            }
        });

        jLabelProdListIterationOne.setText("Iteration One");

        jLabelProdListIterationTwo.setText("Iteration Two");

        jTextFieldProdListIterationTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProdListIterationTwoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEProdListLayout = new javax.swing.GroupLayout(jPanelEProdList);
        jPanelEProdList.setLayout(jPanelEProdListLayout);
        jPanelEProdListLayout.setHorizontalGroup(
            jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEProdListLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonMoveDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMoveUp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProdListReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProdListApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEProdListLayout.createSequentialGroup()
                        .addComponent(jLabelProdListIterationOne, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldProdListIterationOne, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEProdListLayout.createSequentialGroup()
                        .addComponent(jLabelProdListIterationTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldProdListIterationTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(922, Short.MAX_VALUE))
            .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelEProdListLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1246, Short.MAX_VALUE)))
        );
        jPanelEProdListLayout.setVerticalGroup(
            jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEProdListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMoveUp)
                    .addComponent(jLabelProdListIterationOne)
                    .addComponent(jTextFieldProdListIterationOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMoveDown)
                    .addComponent(jLabelProdListIterationTwo)
                    .addComponent(jTextFieldProdListIterationTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProdListReset)
                    .addComponent(jButtonProdListApply))
                .addContainerGap(643, Short.MAX_VALUE))
            .addGroup(jPanelEProdListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelEProdListLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPan.addTab("Production List", jPanelEProdList);

        jLabelSalesChildren.setText("Kinder");

        jLabelSalesWomen.setText("Damen");

        jLabelSalesMen.setText("Herren");

        jTextFieldSalesKQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSalesKQuantityActionPerformed(evt);
            }
        });

        jTextFieldSalesDQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSalesDQuantityActionPerformed(evt);
            }
        });

        jLabelSalesQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSalesQuantity.setText("Quantity");
        jLabelSalesQuantity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelSalesPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSalesPrice.setText("Price");
        jLabelSalesPrice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelSalesPenalty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSalesPenalty.setText("Penalty");
        jLabelSalesPenalty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextFieldSalesKPrice.setText("0");

        jButtonSalesReset.setText("reset");
        jButtonSalesReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalesResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalesLayout = new javax.swing.GroupLayout(jPanelSales);
        jPanelSales.setLayout(jPanelSalesLayout);
        jPanelSalesLayout.setHorizontalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalesLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSalesDPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSalesLayout.createSequentialGroup()
                        .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSalesMen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelSalesWomen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSalesChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 48, Short.MAX_VALUE)
                        .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSalesQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jTextFieldSalesHQuantity)
                            .addComponent(jTextFieldSalesDQuantity)
                            .addComponent(jTextFieldSalesKQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldSalesKPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jTextFieldSalesDPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jTextFieldSalesHPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabelSalesPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSalesHPenalty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jTextFieldSalesKPenalty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabelSalesPenalty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButtonSalesReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(799, Short.MAX_VALUE))
        );
        jPanelSalesLayout.setVerticalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalesLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalesQuantity)
                    .addComponent(jLabelSalesPrice)
                    .addComponent(jLabelSalesPenalty))
                .addGap(18, 18, 18)
                .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalesChildren)
                    .addComponent(jTextFieldSalesKQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesKPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesKPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalesReset))
                .addGap(13, 13, 13)
                .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalesWomen)
                    .addComponent(jTextFieldSalesDQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesDPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesDPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalesMen)
                    .addComponent(jTextFieldSalesHQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesHPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalesHPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(533, Short.MAX_VALUE))
        );

        jTabbedPan.addTab("Sales", jPanelSales);

        jLabelCostsTitleWarehouse.setText("Warehouse");

        jLabelCostsTitleOldStockValue.setText("OldStockValue");

        jLabelCostsTitleEstimatedStockValue.setText("EstimatedStockValue");

        jLabelCostsTitleNumberHouses.setText("NumberHouses");

        jLabelCostsTitleWarehouseHolding.setText("WarehouseHolding");

        jLabelCostsOldStockValue.setText(" ");

        jLabelCostsEstimatedStockValue.setText(" ");

        jLabelCostsNumberHouses.setText(" ");

        jLabelCostsWarehouseHoldungValue.setText(" ");

        jLabelCostsWarehouseHoldingPct.setText(" ");

        jLabelCostsNumberHousesChange.setText(" ");

        jLabelCostsEstimatedStockValuePct.setText(" ");

        jLabelCostsTitleLabor.setText("Labor");

        jLabelCostsTitleLeerlauf.setText("Leerlauf");

        jLabelCostsTitleMachine.setText("Machine");

        jLabelCostsTitleMaterial.setText("Material");

        jLabelCostsLaborCosts.setText(" ");

        javax.swing.GroupLayout jPanelCostsLayout = new javax.swing.GroupLayout(jPanelCosts);
        jPanelCosts.setLayout(jPanelCostsLayout);
        jPanelCostsLayout.setHorizontalGroup(
            jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCostsLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCostsTitleEstimatedStockValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsTitleOldStockValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsTitleWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsTitleNumberHouses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsTitleWarehouseHolding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCostsOldStockValue, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabelCostsEstimatedStockValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsNumberHouses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsWarehouseHoldungValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCostsEstimatedStockValuePct, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabelCostsNumberHousesChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCostsWarehouseHoldingPct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCostsLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabelCostsTitleLabor)
                        .addGap(139, 139, 139)
                        .addComponent(jLabelCostsTitleLeerlauf)
                        .addGap(101, 101, 101)
                        .addComponent(jLabelCostsTitleMachine)
                        .addGap(112, 112, 112)
                        .addComponent(jLabelCostsTitleMaterial))
                    .addGroup(jPanelCostsLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabelCostsLaborCosts, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanelCostsLayout.setVerticalGroup(
            jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCostsLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCostsTitleLabor)
                        .addComponent(jLabelCostsTitleLeerlauf)
                        .addComponent(jLabelCostsTitleMachine)
                        .addComponent(jLabelCostsTitleMaterial))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelCostsLayout.createSequentialGroup()
                            .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCostsEstimatedStockValuePct)
                                .addComponent(jLabelCostsLaborCosts))
                            .addGap(40, 40, 40)
                            .addComponent(jLabelCostsWarehouseHoldingPct))
                        .addGroup(jPanelCostsLayout.createSequentialGroup()
                            .addComponent(jLabelCostsTitleWarehouse)
                            .addGap(18, 18, 18)
                            .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCostsTitleOldStockValue)
                                .addComponent(jLabelCostsOldStockValue))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCostsTitleEstimatedStockValue)
                                .addComponent(jLabelCostsEstimatedStockValue))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCostsTitleNumberHouses)
                                .addComponent(jLabelCostsNumberHouses)
                                .addComponent(jLabelCostsNumberHousesChange))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCostsTitleWarehouseHolding)
                                .addComponent(jLabelCostsWarehouseHoldungValue)))))
                .addContainerGap())
        );

        jTabbedPan.addTab("Costs", jPanelCosts);

        jScrollPane5.setViewportView(jTabbedPan);

        jPanelProductionForecast.setAutoscrolls(true);

        jLabelKinderfahrradPF.setText(bundle.getString("Kinderfahrrad")); // NOI18N

        jLabelDamenfahrradPF.setText(bundle.getString("Damenfahrrad")); // NOI18N

        jLabelHerrenfahrradPF.setText(bundle.getString("Herrenfahrrad")); // NOI18N

        jLabelPeriodNPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPeriodNPF.setText("Period");

        jLabelPeriodN1PF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPeriodN1PF.setText("Period");

        jLabelPeriodN2PF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPeriodN2PF.setText("Period");

        jLabelPeriodN3PF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPeriodN3PF.setText("Period");

        jTextFieldPFPeriodN1KF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN2KF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN3KF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN4KF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN1DF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN2DF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN3DF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN4DF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN1HF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN2HF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN3HF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldPFPeriodN4HF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanelProductionForecastLayout = new javax.swing.GroupLayout(jPanelProductionForecast);
        jPanelProductionForecast.setLayout(jPanelProductionForecastLayout);
        jPanelProductionForecastLayout.setHorizontalGroup(
            jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductionForecastLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelHerrenfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDamenfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKinderfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPFPeriodN1DF)
                    .addComponent(jLabelPeriodNPF, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(jTextFieldPFPeriodN1KF)
                    .addComponent(jTextFieldPFPeriodN1HF))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPFPeriodN2DF)
                    .addComponent(jLabelPeriodN1PF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldPFPeriodN2KF)
                    .addComponent(jTextFieldPFPeriodN2HF))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPFPeriodN3DF)
                    .addComponent(jLabelPeriodN2PF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldPFPeriodN3KF)
                    .addComponent(jTextFieldPFPeriodN3HF))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPeriodN3PF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldPFPeriodN4KF)
                    .addComponent(jTextFieldPFPeriodN4DF)
                    .addComponent(jTextFieldPFPeriodN4HF))
                .addGap(142, 142, 142))
        );
        jPanelProductionForecastLayout.setVerticalGroup(
            jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductionForecastLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeriodNPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPeriodN1PF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPeriodN2PF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPeriodN3PF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKinderfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN1KF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN2KF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN3KF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN4KF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDamenfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN1DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN2DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN3DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN4DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelProductionForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHerrenfahrradPF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN1HF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN2HF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN3HF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPFPeriodN4HF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        jButtonWeiter.setText(bundle.getString("jButtonWeiter")); // NOI18N
        jButtonWeiter.setEnabled(false);
        jButtonWeiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWeiterActionPerformed(evt);
            }
        });

        jTextAreaWelcome.setEditable(false);
        jTextAreaWelcome.setColumns(20);
        jTextAreaWelcome.setRows(5);
        jScrollPane7.setViewportView(jTextAreaWelcome);

        jButtonImportXML.setText(bundle.getString("ImportFile")); // NOI18N
        jButtonImportXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jButtonImportXML, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jButtonWeiter, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelWelcomeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(572, 572, 572))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelProductionForecast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabelWelcomeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonWeiter)
                    .addComponent(jButtonImportXML))
                .addGap(142, 142, 142))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelProductionForecast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane9.setViewportView(jPanel2);

        jMenuFile.setText(bundle.getString("File")); // NOI18N

        jMenuItemImportFile.setText(bundle.getString("ImportFile")); // NOI18N
        jMenuItemImportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemImportFile);

        jMenuItemExportFile.setText(bundle.getString("ExportFile")); // NOI18N
        jMenuItemExportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExportFile);

        jMenuBar1.add(jMenuFile);

        jMenuSettings.setText(bundle.getString("Settings")); // NOI18N

        jMenuLanguage.setText(bundle.getString("Language")); // NOI18N

        jCheckBoxMenuItemBulgarian.setText(bundle.getString("Bulgarian")); // NOI18N
        jCheckBoxMenuItemBulgarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemBulgarianActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemBulgarian);

        jCheckBoxMenuItemDeutsch.setText(bundle.getString("Deutsch")); // NOI18N
        jCheckBoxMenuItemDeutsch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemDeutschActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemDeutsch);

        jCheckBoxMenuItemEnglish.setText(bundle.getString("English")); // NOI18N
        jCheckBoxMenuItemEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemEnglishActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemEnglish);

        jCheckBoxMenuItemFrench.setText(bundle.getString("French")); // NOI18N
        jCheckBoxMenuItemFrench.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemFrenchActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemFrench);

        jCheckBoxMenuItemRomanien.setText(bundle.getString("Romanien")); // NOI18N
        jCheckBoxMenuItemRomanien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemRomanienActionPerformed(evt);
            }
        });
        jMenuLanguage.add(jCheckBoxMenuItemRomanien);

        jMenuSettings.add(jMenuLanguage);

        jMenuCalculationMode.setText("Calculation Mode");

        jCheckBoxMenuItemCalculationModePessimistic.setText("Pessimistic");
        jCheckBoxMenuItemCalculationModePessimistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemCalculationModePessimisticActionPerformed(evt);
            }
        });
        jMenuCalculationMode.add(jCheckBoxMenuItemCalculationModePessimistic);

        jCheckBoxMenuItemCalculationModeOptimistic.setText("Optimistic");
        jCheckBoxMenuItemCalculationModeOptimistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemCalculationModeOptimisticActionPerformed(evt);
            }
        });
        jMenuCalculationMode.add(jCheckBoxMenuItemCalculationModeOptimistic);

        jMenuSettings.add(jMenuCalculationMode);

        jMenuBar1.add(jMenuSettings);

        jMenuHelp.setText(bundle.getString("jMenuHelp")); // NOI18N

        jMenuItemShowHelp.setText(bundle.getString("ShowHelpFile")); // NOI18N
        jMenuItemShowHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShowHelpActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemShowHelp);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane5)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItemEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemEnglishActionPerformed
        locale = new Locale("en", "US");
        this.changeLanguage(locale.getLanguage(), locale.getCountry());
        this.setSelectedLanguage(locale.getLanguage());
    }//GEN-LAST:event_jCheckBoxMenuItemEnglishActionPerformed

    private void jCheckBoxMenuItemDeutschActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemDeutschActionPerformed
        locale = new Locale("de", "DE");
        this.changeLanguage(locale.getLanguage(), locale.getCountry());
        this.setSelectedLanguage(locale.getLanguage());
    }//GEN-LAST:event_jCheckBoxMenuItemDeutschActionPerformed

    private void jCheckBoxMenuItemBulgarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemBulgarianActionPerformed
        locale = new Locale("bg", "BG");
        this.changeLanguage(locale.getLanguage(), locale.getCountry());
        this.setSelectedLanguage(locale.getLanguage());
    }//GEN-LAST:event_jCheckBoxMenuItemBulgarianActionPerformed

    private void jCheckBoxMenuItemFrenchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemFrenchActionPerformed
        locale = new Locale("fr", "FR");
        this.changeLanguage(locale.getLanguage(), locale.getCountry());
        this.setSelectedLanguage(locale.getLanguage());
    }//GEN-LAST:event_jCheckBoxMenuItemFrenchActionPerformed

    private void jCheckBoxMenuItemRomanienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemRomanienActionPerformed
        locale = new Locale("ro", "RO");
        this.changeLanguage(locale.getLanguage(), locale.getCountry());
        this.setSelectedLanguage(locale.getLanguage());
    }//GEN-LAST:event_jCheckBoxMenuItemRomanienActionPerformed

    private void importXml() {
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
                "xml files (*.xml)", "xml");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(xmlfilter);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file != null && file.getAbsolutePath().endsWith(".xml")) {

                Results res;
                try {
                    res = SharedInstance.parseXmlInput(file);
                    if (res == null) {
                        return;
                    }
                    SharedInstance.getInstance().parseResults(res);

                    Map<String, ExtendedWorkplace> extWork = SetupInstance.getInstance()
                            .generateExtendedWorkplaces(SharedInstance.getInstance().getIdleTimeCosts().getWorkplace());
                    SharedInstance.getInstance().setExtendedWorkplaces(extWork);

                    Map<String, ExtendedArticle> extArt = SetupInstance.getInstance()
                            .generateExtendedArticles(SharedInstance.getInstance().getWarehouseStock().getArticle());
                    SharedInstance.getInstance().setExtendedArticles(extArt);

                    Disposal disposal = new Disposal();
                    disposal.calculateAdditionalAmountAndTime();
                    this.setPeriodLabels();
                    this.jButtonCalculate.setEnabled(true);

                    this.fillFieldsInHouseProduction();

                    resetCostsFields();
                    this.jButtonCalculate.setEnabled(true);
                    this.jButtonWeiter.setEnabled(true);

                } catch (JAXBException ex) {
                    Logger.getLogger(MainUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
                JOptionPane.showMessageDialog(this, i18n.getString("OnlyXML"), null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void fillFieldsInHouseProduction() {
        Map<String, ExtendedArticle> extArticles = SharedInstance.getInstance().getExtendedArticles();
        //Vorbelegung Damenfahrrad
        Map<JTextField, String> dfMapFieldsWithKeys = getMapFieldsWithKeys(getDFJTextFields());
        fillTextFileds(dfMapFieldsWithKeys, extArticles);
        //Vorbelegung Herrenfahrrad
        Map<JTextField, String> hfMapFieldsWithKeys = getMapFieldsWithKeys(getHFJTextFields());
        fillTextFileds(hfMapFieldsWithKeys, extArticles);
        //Vorbelegung Kinderfahrad
        Map<JTextField, String> kfMapFieldsWithKeys = getMapFieldsWithKeys(getKFJTextFields());
        fillTextFileds(kfMapFieldsWithKeys, extArticles);
    }

    /* public void fillTextFileds(Map<JTextField, String> mapFieldsWithKeys, Map<String, ExtendedArticle> extArticles) {
        for (Map.Entry<JTextField, String> entry : mapFieldsWithKeys.entrySet()) {
            if (entry.getKey().getName().endsWith("OrdersInQueque")) {
                entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAdditionalAmount()));
            }
            if (entry.getKey().getName().endsWith("StockEndOfPeriod")) {
                entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAmount()));
            }
            if (entry.getKey().getName().endsWith("WorkInProgress")) {
                entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAdditionalAmountInWork()));
            }
//            if (entry.getKey().getName().endsWith("PlannedStock")) {
//                entry.getKey().setText("50");
//            }
        }
    }*/
    public void fillTextFileds(Map<JTextField, String> mapFieldsWithKeys, Map<String, ExtendedArticle> extArticles) {
        for (Map.Entry<JTextField, String> entry : mapFieldsWithKeys.entrySet()) {
            if (entry.getKey().getName().endsWith("OrdersInQueque")) {
                ExtendedArticle tmpArticle = extArticles.get(entry.getValue());
                long artId = tmpArticle.getId();
                double additionalAmout = (double) tmpArticle.getAdditionalAmount();

                long p1 = Math.round(additionalAmout / 30) * 10;
                long p2 = Math.round((additionalAmout - p1) / 20) * 10;
                long p3 = Math.round(additionalAmout - p1 - p2);

                if (artId == 16) {
                    if (indexE16wl == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    }
                    if (indexE16wl == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    }
                    if (indexE16wl == 2) {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE16wl++;
                } else if (artId == 17) {
                    if (indexE17wl == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE17wl == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else if (indexE17wl == 2) {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE17wl++;
                } else if (artId == 26) {
                    if (indexE26wl == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE26wl == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else if (indexE26wl == 2) {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE26wl++;
                } else {
                    entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAdditionalAmount()));
                }
            }
            if (entry.getKey().getName().endsWith("StockEndOfPeriod")) {
                ExtendedArticle tmpArticle = extArticles.get(entry.getValue());
                long artId = tmpArticle.getId();
                double stock = (double) tmpArticle.getAmount();

                long p1 = Math.round(stock / 30) * 10;
                long p2 = Math.round((stock - p1) / 20) * 10;
                long p3 = Math.round(stock - p1 - p2);

                if (artId == 16) {
                    if (indexE16st == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE16st == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE16st++;
                } else if (artId == 17) {
                    if (indexE17st == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE17st == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE17st++;
                } else if (artId == 26) {
                    if (indexE26st == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE26st == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE26st++;
                } else {
                    entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAmount()));
                }
            }
            if (entry.getKey().getName().endsWith("WorkInProgress")) {
                ExtendedArticle tmpArticle = extArticles.get(entry.getValue());
                long artId = tmpArticle.getId();
                double additionalAmout = (double) tmpArticle.getAdditionalAmountInWork();

                long p1 = Math.round(additionalAmout / 30) * 10;
                long p2 = Math.round((additionalAmout - p1) / 20) * 10;
                long p3 = Math.round(additionalAmout - p1 - p2);

                if (artId == 16) {
                    if (indexE16 == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE16 == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE16++;
                } else if (artId == 17) {
                    if (indexE17 == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE17 == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE17++;
                } else if (artId == 26) {
                    if (indexE26 == 0) {
                        entry.getKey().setText(String.valueOf(p1));
                    } else if (indexE26 == 1) {
                        entry.getKey().setText(String.valueOf(p2));
                    } else {
                        entry.getKey().setText(String.valueOf(p3));
                    }
                    indexE26++;
                } else {
                    entry.getKey().setText(String.valueOf(extArticles.get(entry.getValue()).getAdditionalAmountInWork()));
                }
                //  if (entry.getKey().getName().endsWith("PlannedStock")) {
                //      entry.getKey().setText("50");
                //  }
            }
        }
    }

    private void fillPlannedWarehouseStockInHouseProduction(Map<JTextField, String> mapFieldsWithKeys) {
        for (Map.Entry<JTextField, String> entry : mapFieldsWithKeys.entrySet()) {
            if (entry.getKey().getName().endsWith("PlannedStock")) {
                entry.getKey().setText("");
            }
        }
    }

    public void setjTextFieldInHouseProductionEnabled(Map<JTextField, String> mapFieldsWithKeys, Boolean value) {
        for (Map.Entry<JTextField, String> entry : mapFieldsWithKeys.entrySet()) {
            if (entry.getKey().getName().endsWith("OrdersInQueque")) {
                entry.getKey().setEnabled(value);
            }
            if (entry.getKey().getName().endsWith("StockEndOfPeriod")) {
                entry.getKey().setEnabled(value);
            }
            if (entry.getKey().getName().endsWith("WorkInProgress")) {
                entry.getKey().setEnabled(value);
            }
        }
    }

    public void setInHouseProductionJTextFieldsEnabled(Boolean value) {
        //Kinderfahrrad
        Map<JTextField, String> kfMapFieldsWithKeys = getMapFieldsWithKeys(getKFJTextFields());
        setjTextFieldInHouseProductionEnabled(kfMapFieldsWithKeys, value);
        //Damenfahrrad
        Map<JTextField, String> dfMapFieldsWithKeys = getMapFieldsWithKeys(getDFJTextFields());
        setjTextFieldInHouseProductionEnabled(dfMapFieldsWithKeys, value);
        //Herrenfahrrad
        Map<JTextField, String> hfMapFieldsWithKeys = getMapFieldsWithKeys(getHFJTextFields());
        setjTextFieldInHouseProductionEnabled(hfMapFieldsWithKeys, value);
    }
    private void jMenuItemImportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportFileActionPerformed
        this.importXml();
    }//GEN-LAST:event_jMenuItemImportFileActionPerformed

    private void reFillWorkloadTable() {
        Collection<WorkloadResult> results = SharedInstance.getInstance().getWorkloadResults().values();
        DefaultTableModel model = (DefaultTableModel) jTableWorkloadPlanning.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (results == null || results.isEmpty()) {
            return;
        }

        List<WorkloadResult> list = new ArrayList<WorkloadResult>(results);
        Collections.sort(list);

        for (WorkloadResult result : list) {
            model.addRow(new Object[]{result.getWorkplace().getId(), result.getLastSetupCycles(), result.getTotalCapacityNeeded(),
                result.getOverTimeDay(), result.getNumberOfShifts(), result.getFreeCapacity(), result.getWorkloadPercentage()});
        }
    }

    private void reFillPurchasingDisposalTable() {
        List<Order> orders = SharedInstance.getInstance().getNewOrders();
        Locale locale = SharedInstance.getInstance().getCurrentLocale();
        ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
        DefaultTableModel model = (DefaultTableModel) jTablePurchasingDisposition.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (orders == null || orders.isEmpty()) {
            return;
        }

        Collections.sort(orders);

        for (Order order : orders) {
            ExtendedArticle article = SharedInstance.getInstance().getArticleForId(order.getArticle());
            model.addRow(new Object[]{article.getId(), i18n.getString(article.getName()), order.getMode(), order.getAmount()});
        }
    }
    
    private void reFillPurchasingDisposalIncomingTable() {
        Map<String, Order> orders = SharedInstance.getInstance().getIncomingOrdersThisPeriod();
        Locale locale = SharedInstance.getInstance().getCurrentLocale();
        ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
        DefaultTableModel model = (DefaultTableModel) jTablePurchasingDispositionIncoming.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (orders == null || orders.isEmpty()) {
            return;
        }

        List<Order> list = new ArrayList<Order>(orders.values());
        Collections.sort(list);

        for (Order order : list) {
            ExtendedArticle article = SharedInstance.getInstance().getArticleForId(order.getArticle());
            model.addRow(new Object[]{article.getId(), i18n.getString(article.getName()), order.getMode(), order.getAmount()});
        }
    }

    private void reFillStockChangeTable() {
        Map<String, ExtendedArticle> articles = SharedInstance.getInstance().getExtendedArticles();
        Locale locale = SharedInstance.getInstance().getCurrentLocale();
        ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
        DefaultTableModel model = (DefaultTableModel) jTableStockChange.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (articles == null || articles.isEmpty()) {
            return;
        }

        List<ExtendedArticle> list = new ArrayList<ExtendedArticle>(articles.values());
        Collections.sort(list);

        for (ExtendedArticle article : list) {
            model.addRow(new Object[]{article.getId(), i18n.getString(article.getName()), article.getAmount(), article.getStockvalue(),
                article.getStockChange(), article.getNewStock(), article.getNewStockValue(), article.getStockChangePct()});
        }
    }

    private void reFillEProdList() {
        List<Production> pList = SharedInstance.getInstance().getProductionListCalculated();
        Locale locale = SharedInstance.getInstance().getCurrentLocale();
        ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
        DefaultTableModel model = (DefaultTableModel) jTableEProdList.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (pList == null || pList.isEmpty()) {
            return;
        }

        for (Production p : pList) {
            ExtendedArticle article = SharedInstance.getInstance().getArticleForId(p.getArticle());
            model.addRow(new Object[]{p.getArticle(), i18n.getString(article.getName()), p.getQuantity()});
        }
    }

    private void jCheckBoxMenuItemCalculationModePessimisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemCalculationModePessimisticActionPerformed
        this.setCalculationMode(CalculationMode.PESSIMISTIC);
    }//GEN-LAST:event_jCheckBoxMenuItemCalculationModePessimisticActionPerformed

    private void jCheckBoxMenuItemCalculationModeOptimisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemCalculationModeOptimisticActionPerformed
        this.setCalculationMode(CalculationMode.OPTIMISTIC);
    }//GEN-LAST:event_jCheckBoxMenuItemCalculationModeOptimisticActionPerformed

    private void jMenuItemExportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportFileActionPerformed
        this.exportXML();
    }//GEN-LAST:event_jMenuItemExportFileActionPerformed

    private void jButtonBackToWelcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackToWelcomeActionPerformed
        this.jPanel1.setVisible(false);
        this.jScrollPane5.setVisible(false);
        this.jPanel2.setVisible(true);

        jMenuItemImportFile.setEnabled(true);
        this.setEnabledTabs(false);
        
        //reset planned stock to zero
        // only by back navigation
        Map<JTextField, String> dfMapFieldsWithKeys = getMapFieldsWithKeys(getDFJTextFields());
        Map<JTextField, String> hfMapFieldsWithKeys = getMapFieldsWithKeys(getHFJTextFields());
        Map<JTextField, String> kfMapFieldsWithKeys = getMapFieldsWithKeys(getKFJTextFields());
        fillPlannedWarehouseStockInHouseProduction(dfMapFieldsWithKeys);
        fillPlannedWarehouseStockInHouseProduction(hfMapFieldsWithKeys);
        fillPlannedWarehouseStockInHouseProduction(kfMapFieldsWithKeys);
    }//GEN-LAST:event_jButtonBackToWelcomeActionPerformed

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        // TODO add your handling code here:
        //reload workplaces to reset table

        Map<String, ExtendedWorkplace> extWork = SetupInstance.getInstance()
                .generateExtendedWorkplaces(SharedInstance.getInstance().getIdleTimeCosts().getWorkplace());
        SharedInstance.getInstance().setExtendedWorkplaces(extWork);
        
        // hier werden die timeneeded Werten befüllt
        Disposal disposal = new Disposal();
        disposal.calculateAdditionalAmountAndTime();
        
        //worklaod
        Map<String, WorkloadResult> workloadResults = WorkloadPlanning.getInstance()
                .calculateWorkload(SharedInstance.getInstance().getExtendedWorkplaces());
        SharedInstance.getInstance().setWorkloadResults(workloadResults);

        //calcualte which order arrive this period
        SharedInstance.getInstance().calcIncomingOrdersThisPeriod(
                SharedInstance.getInstance().getFutureInwardStockMovement().getOrder());

        ProductionPlan plan = new ProductionPlan();
        ExtendedArticle a1 = SharedInstance.getInstance().getArticleForId((long) 1);
        ExtendedArticle a2 = SharedInstance.getInstance().getArticleForId((long) 2);
        ExtendedArticle a3 = SharedInstance.getInstance().getArticleForId((long) 3);
        PeriodDetail n1 = new PeriodDetail(a1.getPlannedProductionAmount(),
                a2.getPlannedProductionAmount(),
                a3.getPlannedProductionAmount());
        plan.setPeriodN1(n1);
        //forecast values
        plan.setPeriodN2(periodDetailN2);
        plan.setPeriodN3(periodDetailN3);
        plan.setPeriodN4(periodDetailN4);
        SharedInstance.getInstance().setProductionPlan(plan);
        
        //purchasing disposal
        List<Order> newOrders = PurchasingDisposal.getInstance().calculateOrders(
                SharedInstance.getInstance().getExtendedArticles());
        SharedInstance.getInstance().setNewOrders(newOrders);

        //stock
        Map<String, ExtendedArticle> articles = SharedInstance.getInstance().calcNewArticleStockValue();

        //production list order
        List<Production> productionList = SharedInstance.getInstance().calculateProductionList(100, 150);

        this.reFillWorkloadTable();
        this.reFillPurchasingDisposalTable();
        this.reFillPurchasingDisposalIncomingTable();
        this.reFillStockChangeTable();
        this.reFillEProdList();

        Costs costs = new Costs();
        costs.calculateCosts();
        fillCostsLabelValues(costs);
        
        jLabelCostsTitleLabor.setVisible(false);
        jLabelCostsTitleLeerlauf.setVisible(false);
        jLabelCostsTitleMachine.setVisible(false);
        jLabelCostsTitleMaterial.setVisible(false);
        jLabelCostsLaborCosts.setVisible(false);
        
        this.setEnabledTabs(true);
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    private void jSpinnerDiscountFactorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerDiscountFactorStateChanged
        SharedInstance.getInstance().setDiscountFactor(Double.valueOf(jSpinnerDiscountFactor.getValue().toString()) / 100);
    }//GEN-LAST:event_jSpinnerDiscountFactorStateChanged

    private void jSpinnerBufferFactorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerBufferFactorStateChanged
        SharedInstance.getInstance().setBufferFactor(Double.valueOf(jSpinnerBufferFactor.getValue().toString()) / 100);
        SharedInstance in = SharedInstance.getInstance();
    }//GEN-LAST:event_jSpinnerBufferFactorStateChanged

    private void jButtonMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveUpActionPerformed
        int row = jTableEProdList.getSelectedRow();

        if (row > 0) {
            DefaultTableModel model = (DefaultTableModel) jTableEProdList.getModel();
            model.moveRow(row, row, row - 1);
            jTableEProdList.setRowSelectionInterval(row - 1, row - 1);
            SharedInstance.getInstance().swapProductionListOrder(row, row - 1);
        }
    }//GEN-LAST:event_jButtonMoveUpActionPerformed

    private void jButtonMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveDownActionPerformed
        int row = jTableEProdList.getSelectedRow();

        if (row > -1 && row < jTableEProdList.getRowCount() - 1) {
            DefaultTableModel model = (DefaultTableModel) jTableEProdList.getModel();
            model.moveRow(row, row, row + 1);
            jTableEProdList.setRowSelectionInterval(row + 1, row + 1);
            SharedInstance.getInstance().swapProductionListOrder(row, row + 1);
        }
    }//GEN-LAST:event_jButtonMoveDownActionPerformed

    private void jMenuItemShowHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShowHelpActionPerformed
        jFrameHelpDialog.setVisible(true);
        jTextAreaHelpFile.setEditable(false);
        LoadHelpFile hp = new LoadHelpFile("file/HelpFile.txt");
        jTextAreaHelpFile.setText(hp.toString());
    }//GEN-LAST:event_jMenuItemShowHelpActionPerformed

    private void jTablePurchasingDispositionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePurchasingDispositionPropertyChange

    }//GEN-LAST:event_jTablePurchasingDispositionPropertyChange

    private void jTextFieldSalesDQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSalesDQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSalesDQuantityActionPerformed

    private void jTextFieldSalesKQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSalesKQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSalesKQuantityActionPerformed

    private void jButtonSalesResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalesResetActionPerformed
        resetDirectSale();
    }//GEN-LAST:event_jButtonSalesResetActionPerformed

    private void jButtonWeiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWeiterActionPerformed
        this.jPanel2.setVisible(false);
        this.jPanel1.setVisible(true);
        this.jScrollPane5.setVisible(true);

        jMenuItemImportFile.setEnabled(false);

        indexE16wl = 0;
        indexE17wl = 0;
        indexE26wl = 0;
        indexE16st = 0;
        indexE17st = 0;
        indexE26st = 0;
        indexE16 = 0;
        indexE17 = 0;
        indexE26 = 0;

        this.fillFieldsInHouseProduction();
    }//GEN-LAST:event_jButtonWeiterActionPerformed

    private void jButtonImportXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportXMLActionPerformed
        this.importXml();

    }//GEN-LAST:event_jButtonImportXMLActionPerformed


    private void loadWelcomeMessage(String lang, String country) {
        String file = "file/Welcome.txt";
        
        if(lang.equals("en") && country.equals("US")){
            file = "file/Welcome_en_US.txt";
        }else if(lang.equals("de") && country.equals("DE")){
            file = "file/Welcome_de_DE.txt";
        }else if(lang.equals("ro") && country.equals("RO")){
            file = "file/Welcome_ro_RO.txt";
        }else if(lang.equals("fr") && country.equals("FR")){
            file = "file/Welcome_fr_FR.txt";
        }else if(lang.equals("bg") && country.equals("BG")){
            file = "file/Welcome_bg_BG.txt";
        }
        
        LoadHelpFile wel = new LoadHelpFile(file);
        jTextAreaWelcome.setText(wel.toString());
    }

    private void jButtonProdListResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdListResetActionPerformed
        SharedInstance.getInstance().resetProductionListCalculated();
        jTextFieldProdListIterationOne.setText("100");
        jTextFieldProdListIterationTwo.setText("150");
        this.reFillEProdList();
    }//GEN-LAST:event_jButtonProdListResetActionPerformed

    private void jButtonProdListApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdListApplyActionPerformed
        long it1 = Long.valueOf(jTextFieldProdListIterationOne.getText());
        long it2 = Long.valueOf(jTextFieldProdListIterationTwo.getText());
        SharedInstance.getInstance().calculateProductionList(it1, it2);
        this.reFillEProdList();
    }//GEN-LAST:event_jButtonProdListApplyActionPerformed

    private void jTextFieldProdListIterationTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdListIterationTwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdListIterationTwoActionPerformed

    private void jTextFieldKFP1PlannedStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKFP1PlannedStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKFP1PlannedStockActionPerformed

    private void jTablePurchasingDispositionIncomingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePurchasingDispositionIncomingPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePurchasingDispositionIncomingPropertyChange



    private void resetDirectSale() {
        jTextFieldSalesDPrice.setText("0");
        jTextFieldSalesHPrice.setText("0");
        jTextFieldSalesKPrice.setText("0");
        jTextFieldSalesDPenalty.setText("0");
        jTextFieldSalesHPenalty.setText("0");
        jTextFieldSalesKPenalty.setText("0");
        jTextFieldSalesHQuantity.setText("0");
        jTextFieldSalesDQuantity.setText("0");
        jTextFieldSalesKQuantity.setText("0");
    }
    Action purchasingDisposalListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener) e.getSource();

            if ((tcl.getColumn() == 2 && (Long.valueOf(tcl.getNewValue().toString()) == 4 || Long.valueOf(tcl.getNewValue().toString()) == 5))
                    || (tcl.getColumn() == 3 && Long.valueOf(tcl.getNewValue().toString()) >= 0)) {
                long id = Long.valueOf(jTablePurchasingDisposition.getModel().getValueAt(tcl.getRow(), 0).toString());
                long mode = Long.valueOf(jTablePurchasingDisposition.getModel().getValueAt(tcl.getRow(), 2).toString());
                long amount = Long.valueOf(jTablePurchasingDisposition.getModel().getValueAt(tcl.getRow(), 3).toString());

                Order order = SharedInstance.getInstance().getNewOrderById(id);
                order.setMode(mode);
                order.setAmount(amount);

                SharedInstance.getInstance().replaceNewOrder(order);
            } else {
                jTablePurchasingDisposition.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
            }
        }
    };

    Action workloadListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener) e.getSource();

            if (tcl.getColumn() == 1 && Long.valueOf(tcl.getNewValue().toString()) >= 0) {
                long id = Long.valueOf(jTableWorkloadPlanning.getModel().getValueAt(tcl.getRow(), 0).toString());

                WorkloadResult resu = SharedInstance.getInstance().getWorkloadResultForId(id);
                WorkloadPlanning.getInstance().reCalculateResultWithSetupCycles(resu, Long.valueOf(tcl.getNewValue().toString()));

                reFillWorkloadTable();
            } else if (tcl.getColumn() == 3 && Long.valueOf(tcl.getNewValue().toString()) >= 0 && Long.valueOf(tcl.getNewValue().toString()) <= WorkloadPlanning.LIMITOVERTIME) {
                long id = Long.valueOf(jTableWorkloadPlanning.getModel().getValueAt(tcl.getRow(), 0).toString());

                WorkloadResult resu = SharedInstance.getInstance().getWorkloadResultForId(id);
                WorkloadPlanning.getInstance().reCalculateResultWithOvertime(resu, Long.valueOf(tcl.getNewValue().toString()));

                reFillWorkloadTable();
            } else if (tcl.getColumn() == 3 && Long.valueOf(tcl.getNewValue().toString()) >= 0 && Long.valueOf(tcl.getNewValue().toString()) > WorkloadPlanning.LIMITOVERTIME) {
                long id = Long.valueOf(jTableWorkloadPlanning.getModel().getValueAt(tcl.getRow(), 0).toString());

                WorkloadResult resu = SharedInstance.getInstance().getWorkloadResultForId(id);
                WorkloadPlanning.getInstance().reCalculateResultWithOvertime(resu, WorkloadPlanning.LIMITOVERTIME);

                reFillWorkloadTable();
            } else {
                jTableWorkloadPlanning.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
            }
        }
    };

    private void setTableListeners() {
        TableCellListener pDispo = new TableCellListener(jTablePurchasingDisposition, purchasingDisposalListener);
        TableCellListener workload = new TableCellListener(jTableWorkloadPlanning, workloadListener);
    }

    private void exportXML() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //disable the "All files" option.
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String os = System.getProperty("os.name");
            String trennzeichen = "";
            if (os != null && os.startsWith("Windows")) {
                trennzeichen = "\\";
            } else {
                //linux | mac
                trennzeichen = "/";
            }

            File file = new File(chooser.getSelectedFile().getAbsolutePath() + trennzeichen + "input.xml");
            SharedInstance.getInstance().saveInputFile(file);
        } else {
            System.out.println("No Selection ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackToWelcome;
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonImportXML;
    private javax.swing.JButton jButtonMoveDown;
    private javax.swing.JButton jButtonMoveUp;
    private javax.swing.JButton jButtonProdListApply;
    private javax.swing.JButton jButtonProdListReset;
    private javax.swing.JButton jButtonSalesReset;
    private javax.swing.JButton jButtonWeiter;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemBulgarian;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemCalculationModeOptimistic;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemCalculationModePessimistic;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDeutsch;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemEnglish;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemFrench;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemRomanien;
    private javax.swing.JFrame jFrameHelpDialog;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelBufferFactor;
    private javax.swing.JLabel jLabelCostsEstimatedStockValue;
    private javax.swing.JLabel jLabelCostsEstimatedStockValuePct;
    private javax.swing.JLabel jLabelCostsLaborCosts;
    private javax.swing.JLabel jLabelCostsNumberHouses;
    private javax.swing.JLabel jLabelCostsNumberHousesChange;
    private javax.swing.JLabel jLabelCostsOldStockValue;
    private javax.swing.JLabel jLabelCostsTitleEstimatedStockValue;
    private javax.swing.JLabel jLabelCostsTitleLabor;
    private javax.swing.JLabel jLabelCostsTitleLeerlauf;
    private javax.swing.JLabel jLabelCostsTitleMachine;
    private javax.swing.JLabel jLabelCostsTitleMaterial;
    private javax.swing.JLabel jLabelCostsTitleNumberHouses;
    private javax.swing.JLabel jLabelCostsTitleOldStockValue;
    private javax.swing.JLabel jLabelCostsTitleWarehouse;
    private javax.swing.JLabel jLabelCostsTitleWarehouseHolding;
    private javax.swing.JLabel jLabelCostsWarehouseHoldingPct;
    private javax.swing.JLabel jLabelCostsWarehouseHoldungValue;
    private javax.swing.JLabel jLabelDFASchutzblechH;
    private javax.swing.JLabel jLabelDFE11OrdersInQueque;
    private javax.swing.JLabel jLabelDFE14OrdersInQueque;
    private javax.swing.JLabel jLabelDFE16OrdersInQueque;
    private javax.swing.JLabel jLabelDFE17OrdersInQueque;
    private javax.swing.JLabel jLabelDFE19OrdersInQueque;
    private javax.swing.JLabel jLabelDFE26OrdersInQueque;
    private javax.swing.JLabel jLabelDFE54OrdersInQueque;
    private javax.swing.JLabel jLabelDFE55OrdersInQueque;
    private javax.swing.JLabel jLabelDFE56OrdersInQueque;
    private javax.swing.JLabel jLabelDFE5OrdersInQueque;
    private javax.swing.JLabel jLabelDFE8OrdersInQueque;
    private javax.swing.JLabel jLabelDFFahrradOPedal;
    private javax.swing.JLabel jLabelDFHinterradgruppe;
    private javax.swing.JLabel jLabelDFLadiesCycle;
    private javax.swing.JLabel jLabelDFLenkerCpl;
    private javax.swing.JLabel jLabelDFOrdersInQueue;
    private javax.swing.JLabel jLabelDFPedalCpl;
    private javax.swing.JLabel jLabelDFPlannedStock;
    private javax.swing.JLabel jLabelDFProductionOrders;
    private javax.swing.JLabel jLabelDFRahmen;
    private javax.swing.JLabel jLabelDFRahmenURaeder;
    private javax.swing.JLabel jLabelDFSalesOrders;
    private javax.swing.JLabel jLabelDFSattelCpl;
    private javax.swing.JLabel jLabelDFSchutzblechV;
    private javax.swing.JLabel jLabelDFStockEndOfPeriod;
    private javax.swing.JLabel jLabelDFVorderradCpl;
    private javax.swing.JLabel jLabelDFVorderradgruppe;
    private javax.swing.JLabel jLabelDFWorkInProgress;
    private javax.swing.JLabel jLabelDamenfahrradPF;
    private javax.swing.JLabel jLabelDiscountFactor;
    private javax.swing.JLabel jLabelHFASchutzblechH;
    private javax.swing.JLabel jLabelHFE12OrdersInQueque;
    private javax.swing.JLabel jLabelHFE15OrdersInQueque;
    private javax.swing.JLabel jLabelHFE16OrdersInQueque;
    private javax.swing.JLabel jLabelHFE17OrdersInQueque;
    private javax.swing.JLabel jLabelHFE20OrdersInQueque;
    private javax.swing.JLabel jLabelHFE26OrdersInQueque;
    private javax.swing.JLabel jLabelHFE29OrdersInQueque;
    private javax.swing.JLabel jLabelHFE30OrdersInQueque;
    private javax.swing.JLabel jLabelHFE31OrdersInQueque;
    private javax.swing.JLabel jLabelHFE6OrdersInQueque;
    private javax.swing.JLabel jLabelHFE9OrdersInQueque;
    private javax.swing.JLabel jLabelHFFahrradOPedal;
    private javax.swing.JLabel jLabelHFHinterradgruppe;
    private javax.swing.JLabel jLabelHFLenkerCpl;
    private javax.swing.JLabel jLabelHFManCycle;
    private javax.swing.JLabel jLabelHFOrdersInQueue;
    private javax.swing.JLabel jLabelHFPedalCpl;
    private javax.swing.JLabel jLabelHFPlannedStock;
    private javax.swing.JLabel jLabelHFProductionOrders;
    private javax.swing.JLabel jLabelHFRahmen;
    private javax.swing.JLabel jLabelHFRahmenURaeder;
    private javax.swing.JLabel jLabelHFSalesOrders;
    private javax.swing.JLabel jLabelHFSattelCpl;
    private javax.swing.JLabel jLabelHFSchutzblechV;
    private javax.swing.JLabel jLabelHFStockEndOfPeriod;
    private javax.swing.JLabel jLabelHFVorderradCpl;
    private javax.swing.JLabel jLabelHFVorderradgruppe;
    private javax.swing.JLabel jLabelHFWorkInProgress;
    private javax.swing.JLabel jLabelHerrenfahrradPF;
    private javax.swing.JLabel jLabelKFASchutzblechH;
    private javax.swing.JLabel jLabelKFE10OrdersInQueque;
    private javax.swing.JLabel jLabelKFE13OrdersInQueque;
    private javax.swing.JLabel jLabelKFE16OrdersInQueque;
    private javax.swing.JLabel jLabelKFE17OrdersInQueque;
    private javax.swing.JLabel jLabelKFE18OrdersInQueque;
    private javax.swing.JLabel jLabelKFE26OrdersInQueque;
    private javax.swing.JLabel jLabelKFE49OrdersInQueque;
    private javax.swing.JLabel jLabelKFE4OrdersInQueque;
    private javax.swing.JLabel jLabelKFE50OrdersInQueque;
    private javax.swing.JLabel jLabelKFE51OrdersInQueque;
    private javax.swing.JLabel jLabelKFE7OrdersInQueque;
    private javax.swing.JLabel jLabelKFFahrradOPedal;
    private javax.swing.JLabel jLabelKFHinterradgruppe;
    private javax.swing.JLabel jLabelKFKinderfahrrad;
    private javax.swing.JLabel jLabelKFLenkerCpl;
    private javax.swing.JLabel jLabelKFOrdersInQueue;
    private javax.swing.JLabel jLabelKFPedalCpl;
    private javax.swing.JLabel jLabelKFPlannedStock;
    private javax.swing.JLabel jLabelKFProductionOrders;
    private javax.swing.JLabel jLabelKFRahmen;
    private javax.swing.JLabel jLabelKFRahmenURaeder;
    private javax.swing.JLabel jLabelKFSalesOrders;
    private javax.swing.JLabel jLabelKFSchutzblechV;
    private javax.swing.JLabel jLabelKFStockEndOfPeriod;
    private javax.swing.JLabel jLabelKFVorderradCpl;
    private javax.swing.JLabel jLabelKFVorderradgruppe;
    private javax.swing.JLabel jLabelKFWorkInProgress;
    private javax.swing.JLabel jLabelKinderfahrradPF;
    private javax.swing.JLabel jLabelPeriodN1PF;
    private javax.swing.JLabel jLabelPeriodN2PF;
    private javax.swing.JLabel jLabelPeriodN3PF;
    private javax.swing.JLabel jLabelPeriodNPF;
    private javax.swing.JLabel jLabelProdListIterationOne;
    private javax.swing.JLabel jLabelProdListIterationTwo;
    private javax.swing.JLabel jLabelPurchasingDispoIncoming;
    private javax.swing.JLabel jLabelPurchasingDispoOutgoing;
    private javax.swing.JLabel jLabelSalesChildren;
    private javax.swing.JLabel jLabelSalesMen;
    private javax.swing.JLabel jLabelSalesPenalty;
    private javax.swing.JLabel jLabelSalesPrice;
    private javax.swing.JLabel jLabelSalesQuantity;
    private javax.swing.JLabel jLabelSalesWomen;
    private javax.swing.JLabel jLabelSattelCpl;
    private javax.swing.JLabel jLabelWelcomeImage;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCalculationMode;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemExportFile;
    private javax.swing.JMenuItem jMenuItemImportFile;
    private javax.swing.JMenuItem jMenuItemShowHelp;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCosts;
    private javax.swing.JPanel jPanelDF;
    private javax.swing.JPanel jPanelEProdList;
    private javax.swing.JPanel jPanelHF;
    private javax.swing.JPanel jPanelHelpDialog;
    private javax.swing.JPanel jPanelInHouseProduction;
    private javax.swing.JPanel jPanelKF;
    private javax.swing.JPanel jPanelProductionForecast;
    private javax.swing.JPanel jPanelPurchasingDisposition;
    private javax.swing.JPanel jPanelSales;
    private javax.swing.JPanel jPanelStockChange;
    private javax.swing.JPanel jPanelWorkloadPlanning;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinnerBufferFactor;
    private javax.swing.JSpinner jSpinnerDiscountFactor;
    private javax.swing.JTabbedPane jTabbedPan;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableEProdList;
    private javax.swing.JTable jTablePurchasingDisposition;
    private javax.swing.JTable jTablePurchasingDispositionIncoming;
    private javax.swing.JTable jTableStockChange;
    private javax.swing.JTable jTableWorkloadPlanning;
    private javax.swing.JTextArea jTextAreaHelpFile;
    private javax.swing.JTextArea jTextAreaWelcome;
    private javax.swing.JTextField jTextFieldDFE11OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE11PlannedStock;
    private javax.swing.JTextField jTextFieldDFE11ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE11SalesOrders;
    private javax.swing.JTextField jTextFieldDFE11StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE11WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE14OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE14PlannedStock;
    private javax.swing.JTextField jTextFieldDFE14ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE14SalesOrders;
    private javax.swing.JTextField jTextFieldDFE14StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE14WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE16OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE16PlannedStock;
    private javax.swing.JTextField jTextFieldDFE16ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE16SalesOrders;
    private javax.swing.JTextField jTextFieldDFE16StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE16WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE17OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE17PlannedStock;
    private javax.swing.JTextField jTextFieldDFE17ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE17SalesOrders;
    private javax.swing.JTextField jTextFieldDFE17StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE17WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE19OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE19PlannedStock;
    private javax.swing.JTextField jTextFieldDFE19ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE19SalesOrders;
    private javax.swing.JTextField jTextFieldDFE19StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE19WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE26OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE26PlannedStock;
    private javax.swing.JTextField jTextFieldDFE26ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE26SalesOrders;
    private javax.swing.JTextField jTextFieldDFE26StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE26WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE54OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE54PlannedStock;
    private javax.swing.JTextField jTextFieldDFE54ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE54SalesOrders;
    private javax.swing.JTextField jTextFieldDFE54StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE54WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE55OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE55PlannedStock;
    private javax.swing.JTextField jTextFieldDFE55ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE55SalesOrders;
    private javax.swing.JTextField jTextFieldDFE55StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE55WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE56OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE56PlannedStock;
    private javax.swing.JTextField jTextFieldDFE56ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE56SalesOrders;
    private javax.swing.JTextField jTextFieldDFE56StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE56WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE5OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE5PlannedStock;
    private javax.swing.JTextField jTextFieldDFE5ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE5SalesOrders;
    private javax.swing.JTextField jTextFieldDFE5StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE5WorkInProgress;
    private javax.swing.JTextField jTextFieldDFE8OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFE8PlannedStock;
    private javax.swing.JTextField jTextFieldDFE8ProductionOrders;
    private javax.swing.JTextField jTextFieldDFE8SalesOrders;
    private javax.swing.JTextField jTextFieldDFE8StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFE8WorkInProgress;
    private javax.swing.JTextField jTextFieldDFP2OrdersInQueque;
    private javax.swing.JTextField jTextFieldDFP2PlannedStock;
    private javax.swing.JTextField jTextFieldDFP2ProductionOrders;
    private javax.swing.JTextField jTextFieldDFP2SalesOrders;
    private javax.swing.JTextField jTextFieldDFP2StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldDFP2WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE12OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE12PlannedStock;
    private javax.swing.JTextField jTextFieldHFE12ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE12SalesOrders;
    private javax.swing.JTextField jTextFieldHFE12StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE12WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE15OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE15PlannedStock;
    private javax.swing.JTextField jTextFieldHFE15ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE15SalesOrders;
    private javax.swing.JTextField jTextFieldHFE15StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE15WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE16OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE16PlannedStock;
    private javax.swing.JTextField jTextFieldHFE16ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE16SalesOrders;
    private javax.swing.JTextField jTextFieldHFE16StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE16WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE17OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE17PlannedStock;
    private javax.swing.JTextField jTextFieldHFE17ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE17SalesOrders;
    private javax.swing.JTextField jTextFieldHFE17StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE17WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE20OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE20PlannedStock;
    private javax.swing.JTextField jTextFieldHFE20ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE20SalesOrders;
    private javax.swing.JTextField jTextFieldHFE20StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE20WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE26OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE26PlannedStock;
    private javax.swing.JTextField jTextFieldHFE26ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE26SalesOrders;
    private javax.swing.JTextField jTextFieldHFE26StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE26WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE29OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE29PlannedStock;
    private javax.swing.JTextField jTextFieldHFE29ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE29SalesOrders;
    private javax.swing.JTextField jTextFieldHFE29StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE29WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE30OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE30PlannedStock;
    private javax.swing.JTextField jTextFieldHFE30ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE30SalesOrders;
    private javax.swing.JTextField jTextFieldHFE30StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE30WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE31OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE31PlannedStock;
    private javax.swing.JTextField jTextFieldHFE31ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE31SalesOrders;
    private javax.swing.JTextField jTextFieldHFE31StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE31WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE6OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE6PlannedStock;
    private javax.swing.JTextField jTextFieldHFE6ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE6SalesOrders;
    private javax.swing.JTextField jTextFieldHFE6StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE6WorkInProgress;
    private javax.swing.JTextField jTextFieldHFE9OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFE9PlannedStock;
    private javax.swing.JTextField jTextFieldHFE9ProductionOrders;
    private javax.swing.JTextField jTextFieldHFE9SalesOrders;
    private javax.swing.JTextField jTextFieldHFE9StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFE9WorkInProgress;
    private javax.swing.JTextField jTextFieldHFP3OrdersInQueque;
    private javax.swing.JTextField jTextFieldHFP3PlannedStock;
    private javax.swing.JTextField jTextFieldHFP3ProductionOrders;
    private javax.swing.JTextField jTextFieldHFP3SalesOrders;
    private javax.swing.JTextField jTextFieldHFP3StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldHFP3WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE10OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE10PlannedStock;
    private javax.swing.JTextField jTextFieldKFE10ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE10SalesOrders;
    private javax.swing.JTextField jTextFieldKFE10StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE10WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE13OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE13PlannedStock;
    private javax.swing.JTextField jTextFieldKFE13ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE13SalesOrders;
    private javax.swing.JTextField jTextFieldKFE13StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE13WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE16OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE16PlannedStock;
    private javax.swing.JTextField jTextFieldKFE16ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE16SalesOrders;
    private javax.swing.JTextField jTextFieldKFE16StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE16WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE17OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE17PlannedStock;
    private javax.swing.JTextField jTextFieldKFE17ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE17SalesOrders;
    private javax.swing.JTextField jTextFieldKFE17StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE17WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE18OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE18PlannedStock;
    private javax.swing.JTextField jTextFieldKFE18ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE18SalesOrders;
    private javax.swing.JTextField jTextFieldKFE18StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE18WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE26OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE26PlannedStock;
    private javax.swing.JTextField jTextFieldKFE26ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE26SalesOrders;
    private javax.swing.JTextField jTextFieldKFE26StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE26WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE49OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE49PlannedStock;
    private javax.swing.JTextField jTextFieldKFE49ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE49SalesOrders;
    private javax.swing.JTextField jTextFieldKFE49StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE49WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE4OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE4PlannedStock;
    private javax.swing.JTextField jTextFieldKFE4ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE4SalesOrders;
    private javax.swing.JTextField jTextFieldKFE4StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE4WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE50OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE50PlannedStock;
    private javax.swing.JTextField jTextFieldKFE50ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE50SalesOrders;
    private javax.swing.JTextField jTextFieldKFE50StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE50WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE51OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE51PlannedStock;
    private javax.swing.JTextField jTextFieldKFE51ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE51SalesOrders;
    private javax.swing.JTextField jTextFieldKFE51StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE51WorkInProgress;
    private javax.swing.JTextField jTextFieldKFE7OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFE7PlannedStock;
    private javax.swing.JTextField jTextFieldKFE7ProductionOrders;
    private javax.swing.JTextField jTextFieldKFE7SalesOrders;
    private javax.swing.JTextField jTextFieldKFE7StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFE7WorkInProgress;
    private javax.swing.JTextField jTextFieldKFP1OrdersInQueque;
    private javax.swing.JTextField jTextFieldKFP1PlannedStock;
    private javax.swing.JTextField jTextFieldKFP1ProductionOrders;
    private javax.swing.JTextField jTextFieldKFP1SalesOrders;
    private javax.swing.JTextField jTextFieldKFP1StockEndOfPeriod;
    private javax.swing.JTextField jTextFieldKFP1WorkInProgress;
    private javax.swing.JTextField jTextFieldPFPeriodN1DF;
    private javax.swing.JTextField jTextFieldPFPeriodN1HF;
    private javax.swing.JTextField jTextFieldPFPeriodN1KF;
    private javax.swing.JTextField jTextFieldPFPeriodN2DF;
    private javax.swing.JTextField jTextFieldPFPeriodN2HF;
    private javax.swing.JTextField jTextFieldPFPeriodN2KF;
    private javax.swing.JTextField jTextFieldPFPeriodN3DF;
    private javax.swing.JTextField jTextFieldPFPeriodN3HF;
    private javax.swing.JTextField jTextFieldPFPeriodN3KF;
    private javax.swing.JTextField jTextFieldPFPeriodN4DF;
    private javax.swing.JTextField jTextFieldPFPeriodN4HF;
    private javax.swing.JTextField jTextFieldPFPeriodN4KF;
    private javax.swing.JTextField jTextFieldProdListIterationOne;
    private javax.swing.JTextField jTextFieldProdListIterationTwo;
    private javax.swing.JTextField jTextFieldSalesDPenalty;
    private javax.swing.JTextField jTextFieldSalesDPrice;
    private javax.swing.JTextField jTextFieldSalesDQuantity;
    private javax.swing.JTextField jTextFieldSalesHPenalty;
    private javax.swing.JTextField jTextFieldSalesHPrice;
    private javax.swing.JTextField jTextFieldSalesHQuantity;
    private javax.swing.JTextField jTextFieldSalesKPenalty;
    private javax.swing.JTextField jTextFieldSalesKPrice;
    private javax.swing.JTextField jTextFieldSalesKQuantity;
    // End of variables declaration//GEN-END:variables

    //util methods
    public void changeLanguage(String lang, String country) {
        this.loadWelcomeMessage(lang, country);
        
        SharedInstance.getInstance().setCurrentLocale(new Locale(lang, country));
        ResourceBundle i18n = Utils.getResourceBundle(lang, country);

        //menu
        jMenuFile.setText(i18n.getString("File"));
        jMenuSettings.setText(i18n.getString("Settings"));
        jMenuLanguage.setText(i18n.getString("Language"));
        jMenuCalculationMode.setText(i18n.getString("CalculationMode"));
        jCheckBoxMenuItemDeutsch.setText(i18n.getString("Deutsch"));
        jCheckBoxMenuItemEnglish.setText(i18n.getString("English"));
        jCheckBoxMenuItemBulgarian.setText(i18n.getString("Bulgarisch"));
        jCheckBoxMenuItemFrench.setText(i18n.getString("Franzoesisch"));
        jCheckBoxMenuItemRomanien.setText(i18n.getString("Rumaenisch"));
        jCheckBoxMenuItemCalculationModeOptimistic.setText(i18n.getString("Optimistic"));
        jCheckBoxMenuItemCalculationModePessimistic.setText(i18n.getString("Pessimistic"));
        jMenuItemExportFile.setText(i18n.getString("ExportFile"));
        jMenuItemImportFile.setText(i18n.getString("ImportFile"));
        jMenuHelp.setText(i18n.getString("jMenuHelp"));
        jMenuItemShowHelp.setText(i18n.getString("ShowHelpFile"));
        jPanelHelpDialog.setName(i18n.getString("HelpDialog"));

        //buttons
        jButtonBackToWelcome.setText(i18n.getString("jButtonBack"));
        jButtonCalculate.setText(i18n.getString("Calculate"));
        jButtonMoveUp.setText(i18n.getString("MoveUp"));
        jButtonMoveDown.setText(i18n.getString("MoveDown"));
        jButtonSalesReset.setText(i18n.getString("Reset"));
        jButtonBackToWelcome.setText(i18n.getString("jButtonBack"));
        jButtonWeiter.setText(i18n.getString("jButtonWeiter"));
        jButtonImportXML.setText(i18n.getString("ImportFile"));
        jButtonProdListApply.setText(i18n.getString("Apply"));
        jButtonProdListReset.setText(i18n.getString("Reset"));

        //tabs
//        jTabbedPan.setTitleAt(0, i18n.getString("ProductionForecast"));
        jTabbedPan.setTitleAt(0, i18n.getString("InHauseProduction"));
        jTabbedPan.setTitleAt(1, i18n.getString("WorkloadPlanning"));
        jTabbedPan.setTitleAt(2, i18n.getString("PurchasingPlanning"));
        jTabbedPan.setTitleAt(3, i18n.getString("Stock"));
        jTabbedPan.setTitleAt(4, i18n.getString("ProductionList"));
        jTabbedPan.setTitleAt(5, i18n.getString("Sales"));
        jTabbedPan.setTitleAt(6, i18n.getString("Costs"));
        jTabbedPane2.setTitleAt(0, i18n.getString("Kinderfahrrad"));
        jTabbedPane2.setTitleAt(1, i18n.getString("Damenfahrrad"));
        jTabbedPane2.setTitleAt(2, i18n.getString("Herrenfahrrad"));

        //tables
        jTableWorkloadPlanning.getColumnModel().getColumn(0).setHeaderValue(i18n.getString("Workplace"));
        jTableWorkloadPlanning.getColumnModel().getColumn(1).setHeaderValue(i18n.getString("LastCycleTimes"));
        jTableWorkloadPlanning.getColumnModel().getColumn(2).setHeaderValue(i18n.getString("NeededCapacity"));
        jTableWorkloadPlanning.getColumnModel().getColumn(3).setHeaderValue(i18n.getString("Overtime"));
        jTableWorkloadPlanning.getColumnModel().getColumn(4).setHeaderValue(i18n.getString("Shifts"));
        jTableWorkloadPlanning.getColumnModel().getColumn(5).setHeaderValue(i18n.getString("FreeCapacity"));
        jTableWorkloadPlanning.getColumnModel().getColumn(6).setHeaderValue(i18n.getString("WorkloadPct"));
        jTablePurchasingDisposition.getColumnModel().getColumn(0).setHeaderValue(i18n.getString("Article"));
        jTablePurchasingDisposition.getColumnModel().getColumn(1).setHeaderValue(i18n.getString("Name"));
        jTablePurchasingDisposition.getColumnModel().getColumn(2).setHeaderValue(i18n.getString("Mode"));
        jTablePurchasingDisposition.getColumnModel().getColumn(3).setHeaderValue(i18n.getString("Amount"));
        jTablePurchasingDispositionIncoming.getColumnModel().getColumn(0).setHeaderValue(i18n.getString("Article"));
        jTablePurchasingDispositionIncoming.getColumnModel().getColumn(1).setHeaderValue(i18n.getString("Name"));
        jTablePurchasingDispositionIncoming.getColumnModel().getColumn(2).setHeaderValue(i18n.getString("Mode"));
        jTablePurchasingDispositionIncoming.getColumnModel().getColumn(3).setHeaderValue(i18n.getString("Amount"));
        jTableStockChange.getColumnModel().getColumn(0).setHeaderValue(i18n.getString("Article"));
        jTableStockChange.getColumnModel().getColumn(1).setHeaderValue(i18n.getString("Name"));
        jTableStockChange.getColumnModel().getColumn(2).setHeaderValue(i18n.getString("OldStock"));
        jTableStockChange.getColumnModel().getColumn(3).setHeaderValue(i18n.getString("OldValue"));
        jTableStockChange.getColumnModel().getColumn(4).setHeaderValue(i18n.getString("Change"));
        jTableStockChange.getColumnModel().getColumn(5).setHeaderValue(i18n.getString("NewStock"));
        jTableStockChange.getColumnModel().getColumn(6).setHeaderValue(i18n.getString("NewValue"));
        jTableStockChange.getColumnModel().getColumn(7).setHeaderValue(i18n.getString("StockChangePct"));
        jTableEProdList.getColumnModel().getColumn(0).setHeaderValue(i18n.getString("Article"));
        jTableEProdList.getColumnModel().getColumn(1).setHeaderValue(i18n.getString("Name"));
        jTableEProdList.getColumnModel().getColumn(2).setHeaderValue(i18n.getString("Amount"));

        this.reFillPurchasingDisposalTable();
        this.reFillPurchasingDisposalIncomingTable();
        this.reFillStockChangeTable();
        this.reFillEProdList();

        //labels
        this.setPeriodLabels();
        jLabelKinderfahrradPF.setText(i18n.getString("Kinderfahrrad"));
        jLabelDamenfahrradPF.setText(i18n.getString("Damenfahrrad"));
        jLabelHerrenfahrradPF.setText(i18n.getString("Herrenfahrrad"));
        jLabelKFSalesOrders.setText(i18n.getString("SalesOrders"));
        jLabelDFSalesOrders.setText(i18n.getString("SalesOrders"));
        jLabelHFSalesOrders.setText(i18n.getString("SalesOrders"));
        jLabelKFPlannedStock.setText(i18n.getString("PlannedStock"));
        jLabelDFPlannedStock.setText(i18n.getString("PlannedStock"));
        jLabelHFPlannedStock.setText(i18n.getString("PlannedStock"));
        jLabelKFStockEndOfPeriod.setText(i18n.getString("StockEndOfPeriod"));
        jLabelDFStockEndOfPeriod.setText(i18n.getString("StockEndOfPeriod"));
        jLabelHFStockEndOfPeriod.setText(i18n.getString("StockEndOfPeriod"));
        jLabelKFOrdersInQueue.setText(i18n.getString("OrdersInQueue"));
        jLabelDFOrdersInQueue.setText(i18n.getString("OrdersInQueue"));
        jLabelHFOrdersInQueue.setText(i18n.getString("OrdersInQueue"));
        jLabelKFWorkInProgress.setText(i18n.getString("WorkInProgress"));
        jLabelDFWorkInProgress.setText(i18n.getString("WorkInProgress"));
        jLabelHFWorkInProgress.setText(i18n.getString("WorkInProgress"));
        jLabelKFProductionOrders.setText(i18n.getString("ProductionOrders"));
        jLabelDFProductionOrders.setText(i18n.getString("ProductionOrders"));
        jLabelHFProductionOrders.setText(i18n.getString("ProductionOrders"));
        //article names
        jLabelKFKinderfahrrad.setText(i18n.getString("Kinderfahrrad"));
        jLabelKFPedalCpl.setText(i18n.getString("Pedal cpl."));
        jLabelKFFahrradOPedal.setText(i18n.getString("Fahrrad o. Pedal"));
        jLabelKFLenkerCpl.setText(i18n.getString("Lenker cpl."));
        jLabelSattelCpl.setText(i18n.getString("Sattel cpl."));
        jLabelKFRahmenURaeder.setText(i18n.getString("Rahmen u. Raeder"));
        jLabelKFHinterradgruppe.setText(i18n.getString("Hinterradgruppe"));
        jLabelKFASchutzblechH.setText(i18n.getString("Schutzblech h."));
        jLabelKFVorderradCpl.setText(i18n.getString("Vorderrad cpl."));
        jLabelKFVorderradgruppe.setText(i18n.getString("Vorderradgruppe"));
        jLabelKFSchutzblechV.setText(i18n.getString("Schutzblech v."));
        jLabelKFRahmen.setText(i18n.getString("Rahmen"));

        jLabelDFLadiesCycle.setText(i18n.getString("Damenfahrrad"));
        jLabelDFPedalCpl.setText(i18n.getString("Pedal cpl."));
        jLabelDFFahrradOPedal.setText(i18n.getString("Fahrrad o. Pedal"));
        jLabelDFLenkerCpl.setText(i18n.getString("Lenker cpl."));
        jLabelDFSattelCpl.setText(i18n.getString("Sattel cpl."));
        jLabelDFRahmenURaeder.setText(i18n.getString("Rahmen u. Raeder"));
        jLabelDFHinterradgruppe.setText(i18n.getString("Hinterradgruppe"));
        jLabelDFASchutzblechH.setText(i18n.getString("Schutzblech h."));
        jLabelDFVorderradCpl.setText(i18n.getString("Vorderrad cpl."));
        jLabelDFVorderradgruppe.setText(i18n.getString("Vorderradgruppe"));
        jLabelDFSchutzblechV.setText(i18n.getString("Schutzblech v."));
        jLabelDFRahmen.setText(i18n.getString("Rahmen"));

        jLabelHFManCycle.setText(i18n.getString("Herrenfahrrad"));
        jLabelHFPedalCpl.setText(i18n.getString("Pedal cpl."));
        jLabelHFFahrradOPedal.setText(i18n.getString("Fahrrad o. Pedal"));
        jLabelHFLenkerCpl.setText(i18n.getString("Lenker cpl."));
        jLabelHFSattelCpl.setText(i18n.getString("Sattel cpl."));
        jLabelHFRahmenURaeder.setText(i18n.getString("Rahmen u. Raeder"));
        jLabelHFHinterradgruppe.setText(i18n.getString("Hinterradgruppe"));
        jLabelHFASchutzblechH.setText(i18n.getString("Schutzblech h."));
        jLabelHFVorderradCpl.setText(i18n.getString("Vorderrad cpl."));
        jLabelHFVorderradgruppe.setText(i18n.getString("Vorderradgruppe"));
        jLabelHFSchutzblechV.setText(i18n.getString("Schutzblech v."));
        jLabelHFRahmen.setText(i18n.getString("Rahmen"));

        jLabelDiscountFactor.setText(i18n.getString("DiscountFactor"));
        jLabelBufferFactor.setText(i18n.getString("BufferFactor"));

        jLabelSalesChildren.setText(i18n.getString("Kinderfahrrad"));
        jLabelSalesWomen.setText(i18n.getString("Damenfahrrad"));
        jLabelSalesMen.setText(i18n.getString("Herrenfahrrad"));
        jLabelSalesQuantity.setText(i18n.getString("Quantity"));
        jLabelSalesPrice.setText(i18n.getString("Price"));
        jLabelSalesPenalty.setText(i18n.getString("Penalty"));

        jLabelCostsTitleEstimatedStockValue.setText(i18n.getString("EstimatedStockValue"));
        jLabelCostsTitleLabor.setText(i18n.getString("Labor"));
        jLabelCostsTitleLeerlauf.setText(i18n.getString("Leerlauf"));
        jLabelCostsTitleMachine.setText(i18n.getString("Machine"));
        jLabelCostsTitleMaterial.setText(i18n.getString("Material"));
        jLabelCostsTitleNumberHouses.setText(i18n.getString("NumberHouses"));
        jLabelCostsTitleOldStockValue.setText(i18n.getString("OldStockValue"));
        jLabelCostsTitleWarehouseHolding.setText(i18n.getString("WarehouseHolding"));
        jLabelCostsTitleWarehouse.setText(i18n.getString("Warehouse"));
        
        jLabelProdListIterationOne.setText(i18n.getString("IterationOne"));
        jLabelProdListIterationTwo.setText(i18n.getString("IterationTwo"));
        
        jLabelPurchasingDispoOutgoing.setText(i18n.getString("Outgoing"));
        jLabelPurchasingDispoIncoming.setText(i18n.getString("Incoming"));
    }

    private void setPeriodLabels() {
        //also used after xml import
        Locale locale = SharedInstance.getInstance().getCurrentLocale();
        ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
        Long period = (long) -1;
        if (SharedInstance.getInstance().getResults() != null) {
            period = SharedInstance.getInstance().getResults().getPeriod();
        }
        jLabelPeriodNPF.setText(i18n.getString("Period") + " " + ((period > -1) ? String.valueOf(period + 1) : "n"));
        jLabelPeriodN1PF.setText(i18n.getString("Period") + " " + ((period > -1) ? String.valueOf(period + 2) : "n+1"));
        jLabelPeriodN2PF.setText(i18n.getString("Period") + " " + ((period > -1) ? String.valueOf(period + 3) : "n+2"));
        jLabelPeriodN3PF.setText(i18n.getString("Period") + " " + ((period > -1) ? String.valueOf(period + 4) : "n+3"));
    }

    public void setSelectedLanguage(String language) {
        switch (language) {
            case "en":
                jCheckBoxMenuItemEnglish.setSelected(true);
                jCheckBoxMenuItemDeutsch.setSelected(false);
                jCheckBoxMenuItemBulgarian.setSelected(false);
                jCheckBoxMenuItemFrench.setSelected(false);
                jCheckBoxMenuItemRomanien.setSelected(false);
                break;
            case "de":
                jCheckBoxMenuItemEnglish.setSelected(false);
                jCheckBoxMenuItemDeutsch.setSelected(true);
                jCheckBoxMenuItemBulgarian.setSelected(false);
                jCheckBoxMenuItemFrench.setSelected(false);
                jCheckBoxMenuItemRomanien.setSelected(false);
                break;
            case "ro":
                jCheckBoxMenuItemEnglish.setSelected(false);
                jCheckBoxMenuItemDeutsch.setSelected(false);
                jCheckBoxMenuItemBulgarian.setSelected(false);
                jCheckBoxMenuItemFrench.setSelected(false);
                jCheckBoxMenuItemRomanien.setSelected(true);
                break;
            case "bg":
                jCheckBoxMenuItemEnglish.setSelected(false);
                jCheckBoxMenuItemDeutsch.setSelected(false);
                jCheckBoxMenuItemBulgarian.setSelected(true);
                jCheckBoxMenuItemFrench.setSelected(false);
                jCheckBoxMenuItemRomanien.setSelected(false);
                break;
            case "fr":
                jCheckBoxMenuItemEnglish.setSelected(false);
                jCheckBoxMenuItemDeutsch.setSelected(false);
                jCheckBoxMenuItemBulgarian.setSelected(false);
                jCheckBoxMenuItemFrench.setSelected(true);
                jCheckBoxMenuItemRomanien.setSelected(false);
                break;
            default:
                this.setSelectedLanguage("en");
        }
    }

    public final void setCalculationMode(CalculationMode mode) {
        switch (mode) {
            case PESSIMISTIC:
                jCheckBoxMenuItemCalculationModePessimistic.setSelected(true);
                jCheckBoxMenuItemCalculationModeOptimistic.setSelected(false);
                break;
            case OPTIMISTIC:
                jCheckBoxMenuItemCalculationModeOptimistic.setSelected(true);
                jCheckBoxMenuItemCalculationModePessimistic.setSelected(false);
                break;
            default:
                jCheckBoxMenuItemCalculationModePessimistic.setSelected(true);
                jCheckBoxMenuItemCalculationModeOptimistic.setSelected(false);
                break;

        }

        SharedInstance.getInstance().setCalculationMode(mode);
    }

    private void setDFDefaultPlannedWStock(String value) {
        List<JTextField> dfFields = getDFJTextFields();
        for (JTextField field : dfFields) {
            if (field.getName().endsWith("PlannedStock")) {
                field.setText(value);
            }
        }
    }

    private void jTextFieldPFPeriodN1KFChanged() {
        jTextFieldKFP1SalesOrders.setText(jTextFieldPFPeriodN1KF.getText());

        periodDetailN1.setProduct1(Utils.getNumberFromString(jTextFieldPFPeriodN1KF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN1DFChanged() {
        jTextFieldDFP2SalesOrders.setText(jTextFieldPFPeriodN1DF.getText());

        periodDetailN1.setProduct2(Utils.getNumberFromString(jTextFieldPFPeriodN1DF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN1HFChanged() {
        jTextFieldHFP3SalesOrders.setText(jTextFieldPFPeriodN1HF.getText());

        periodDetailN1.setProduct3(Utils.getNumberFromString(jTextFieldPFPeriodN1HF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN2KFChanged() {
        periodDetailN2.setProduct1(Utils.getNumberFromString(jTextFieldPFPeriodN2KF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN2DFChanged() {
        periodDetailN2.setProduct2(Utils.getNumberFromString(jTextFieldPFPeriodN2DF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN2HFChanged() {
        periodDetailN2.setProduct3(Utils.getNumberFromString(jTextFieldPFPeriodN2HF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN3KFChanged() {
        periodDetailN3.setProduct1(Utils.getNumberFromString(jTextFieldPFPeriodN3KF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN3DFChanged() {
        periodDetailN3.setProduct2(Utils.getNumberFromString(jTextFieldPFPeriodN3DF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN3HFChanged() {
        periodDetailN3.setProduct3(Utils.getNumberFromString(jTextFieldPFPeriodN3HF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN4KFChanged() {
        periodDetailN4.setProduct1(Utils.getNumberFromString(jTextFieldPFPeriodN4KF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN4DFChanged() {
        periodDetailN4.setProduct2(Utils.getNumberFromString(jTextFieldPFPeriodN4DF.getText()).longValue());
        reSetForecast();

    }

    private void jTextFieldPFPeriodN4HFChanged() {
        periodDetailN4.setProduct3(Utils.getNumberFromString(jTextFieldPFPeriodN4HF.getText()).longValue());
        reSetForecast();
    }

    private void sellDirectP1Changed() {
        Item item = new Item();
        item.setArticle(1);
        double penalty = 0.0;
        double price = 0.0;
        long quantity = 0;
        try {
            price = Double.valueOf(jTextFieldSalesKPrice.getText());
        } catch (Exception ex) {
            price = 0.0;
        }
        try {
            quantity = Long.valueOf(jTextFieldSalesKQuantity.getText());
        } catch (Exception ex) {
            quantity = 0;
        }
        try {
            penalty = Double.valueOf(jTextFieldSalesKPenalty.getText());
        } catch (Exception ex) {
            penalty = 0.0;
        }
        item.setPenalty(penalty);
        item.setPrice(price);
        item.setQuantity(quantity);
        SharedInstance.getInstance().setSellDirectForArticle(item);
    }

    private void sellDirectP2Changed() {
        Item item = new Item();
        item.setArticle(2);
        double penalty = 0.0;
        double price = 0.0;
        long quantity = 0;
        try {
            price = Double.valueOf(jTextFieldSalesDPrice.getText());
        } catch (Exception ex) {
            price = 0.0;
        }
        try {
            quantity = Long.valueOf(jTextFieldSalesDQuantity.getText());
        } catch (Exception ex) {
            quantity = 0;
        }
        try {
            penalty = Double.valueOf(jTextFieldSalesDPenalty.getText());
        } catch (Exception ex) {
            penalty = 0.0;
        }
        item.setPenalty(penalty);
        item.setPrice(price);
        item.setQuantity(quantity);

        SharedInstance.getInstance().setSellDirectForArticle(item);
    }

    private void sellDirectP3Changed() {
        Item item = new Item();
        item.setArticle(3);
        double penalty = 0.0;
        double price = 0.0;
        long quantity = 0;
        try {
            price = Double.valueOf(jTextFieldSalesHPrice.getText());
        } catch (Exception ex) {
            price = 0.0;
        }
        try {
            quantity = Long.valueOf(jTextFieldSalesHQuantity.getText());
        } catch (Exception ex) {
            quantity = 0;
        }
        try {
            penalty = Double.valueOf(jTextFieldSalesHPenalty.getText());
        } catch (Exception ex) {
            penalty = 0.0;
        }
        item.setPenalty(penalty);
        item.setPrice(price);
        item.setQuantity(quantity);
        SharedInstance.getInstance().setSellDirectForArticle(item);
    }

    final void addInputFieldsListener() {
        jTextFieldSalesKPenalty.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }
        });
        jTextFieldSalesKPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }
        });
        jTextFieldSalesKQuantity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP1Changed();
            }
        });
        jTextFieldSalesDPenalty.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }
        });
        jTextFieldSalesDPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }
        });
        jTextFieldSalesDQuantity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP2Changed();
            }
        });
        jTextFieldSalesHPenalty.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }
        });
        jTextFieldSalesHPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }
        });
        jTextFieldSalesHQuantity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sellDirectP3Changed();
            }
        });

        //Production Forecast
        //Period N1
        jTextFieldPFPeriodN1KF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1KFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1KFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1KFChanged();
            }
        });

        jTextFieldPFPeriodN1DF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1DFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1DFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1DFChanged();
            }
        });

        jTextFieldPFPeriodN1HF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1HFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1HFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN1HFChanged();
            }
        });

        //Period N2
        jTextFieldPFPeriodN2KF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2KFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2KFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2KFChanged();
            }
        });

        jTextFieldPFPeriodN2DF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2DFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2DFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2DFChanged();
            }
        });

        jTextFieldPFPeriodN2HF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2HFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2HFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN2HFChanged();
            }
        });

        //Period N3
        jTextFieldPFPeriodN3KF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3KFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3KFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3KFChanged();
            }
        });

        jTextFieldPFPeriodN3DF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3DFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3DFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3DFChanged();
            }
        });

        jTextFieldPFPeriodN3HF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3HFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3HFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN3HFChanged();
            }
        });

        //Period N4
        jTextFieldPFPeriodN4KF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4KFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4KFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4KFChanged();
            }
        });

        jTextFieldPFPeriodN4DF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4DFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4DFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4DFChanged();
            }
        });

        jTextFieldPFPeriodN4HF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4HFChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4HFChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldPFPeriodN4HFChanged();
            }
        });

        //InHouseProduction
        //Kinderfahrrad
//        //SalesOrders
//        //P1
//        jTextFieldKFP1SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFP1ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFP1ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFP1ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
//            }
//        });
//
//        //E26
//        jTextFieldKFE26SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE26ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE26ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE26ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
//            }
//        });
//        //E51
//        jTextFieldKFE51SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE51ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE51ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE51ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
//            }
//        });
//        //E16
//        jTextFieldKFE16SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE16ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE16ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE16ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
//            }
//        });
//        //E17
//        jTextFieldKFE17SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE17ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE17ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE17ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
//            }
//        });
//        //E50
//        jTextFieldKFE50SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE50ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE50ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE50ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
//            }
//        });
//        //E4
//        jTextFieldKFE4SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE4ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE4ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE4ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
//            }
//        });
//        //E10
//        jTextFieldKFE10SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE10ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE10ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE10ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
//            }
//        });
//        //E49
//        jTextFieldKFE49SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE49ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE49ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE49ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
//            }
//        });
//        //E7
//        jTextFieldKFE7SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE7ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE7ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE7ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
//            }
//        });
//        //E13
//        jTextFieldKFE13SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE13ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE13ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE13ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
//            }
//        });
//        //E18
//        jTextFieldKFE18SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                jTextFieldKFE18ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                jTextFieldKFE18ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                jTextFieldKFE18ProductionOrders.setText(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
//            }
//        });
        //PlannedWarehouseStock
        //P1
        jTextFieldKFP1PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
                jTextFieldKFP1ProductionOrders.setText(prodOrders);
                updateExtendetArticle("P1", prodOrders, (jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
                jTextFieldKFP1ProductionOrders.setText(prodOrders);
                updateExtendetArticle("P1", prodOrders, (jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText())));
                jTextFieldKFP1ProductionOrders.setText(prodOrders);
                updateExtendetArticle("P1", prodOrders, (jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText()));
            }
        });
        //E26
        jTextFieldKFE26PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
                jTextFieldKFE26ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E26", prodOrders, (jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
                jTextFieldKFE26ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E26", prodOrders, (jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText())));
                jTextFieldKFE26ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E26", prodOrders, (jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText()));
            }
        });
        //E51
        jTextFieldKFE51PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
                jTextFieldKFE51ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E51", prodOrders, (jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
                jTextFieldKFE51ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E51", prodOrders, (jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE51SalesOrders.getText().equals("") ? "0" : jTextFieldKFE51SalesOrders.getText())), Integer.parseInt((jLabelKFE51OrdersInQueque.getText().equals("") ? "0" : jLabelKFE51OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText())), Integer.parseInt(jTextFieldKFE51StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE51StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE51OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE51OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE51WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE51WorkInProgress.getText())));
                jTextFieldKFE51ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E51", prodOrders, (jTextFieldKFE51PlannedStock.getText().equals("") ? "0" : jTextFieldKFE51PlannedStock.getText()));
            }
        });
        //E16
        jTextFieldKFE16PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
                jTextFieldKFE16ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E16", prodOrders, (jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
                jTextFieldKFE16ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E16", prodOrders, (jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE16SalesOrders.getText().equals("") ? "0" : jTextFieldKFE16SalesOrders.getText())), Integer.parseInt((jLabelKFE16OrdersInQueque.getText().equals("") ? "0" : jLabelKFE16OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText())), Integer.parseInt(jTextFieldKFE16StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE16StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE16OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE16OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE16WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE16WorkInProgress.getText())));
                jTextFieldKFE16ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E16", prodOrders, (jTextFieldKFE16PlannedStock.getText().equals("") ? "0" : jTextFieldKFE16PlannedStock.getText()));
            }
        });
        //E17
        jTextFieldKFE17PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
                jTextFieldKFE17ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E17", prodOrders, (jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
                jTextFieldKFE17ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E17", prodOrders, (jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE17SalesOrders.getText().equals("") ? "0" : jTextFieldKFE17SalesOrders.getText())), Integer.parseInt((jLabelKFE17OrdersInQueque.getText().equals("") ? "0" : jLabelKFE17OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText())), Integer.parseInt(jTextFieldKFE17StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE17StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE17OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE17OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE17WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE17WorkInProgress.getText())));
                jTextFieldKFE17ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E17", prodOrders, (jTextFieldKFE17PlannedStock.getText().equals("") ? "0" : jTextFieldKFE17PlannedStock.getText()));
            }
        });
        //E50
        jTextFieldKFE50PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
                jTextFieldKFE50ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E50", prodOrders, (jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
                jTextFieldKFE50ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E50", prodOrders, (jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE50SalesOrders.getText().equals("") ? "0" : jTextFieldKFE50SalesOrders.getText())), Integer.parseInt((jLabelKFE50OrdersInQueque.getText().equals("") ? "0" : jLabelKFE50OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText())), Integer.parseInt(jTextFieldKFE50StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE50StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE50OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE50OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE50WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE50WorkInProgress.getText())));
                jTextFieldKFE50ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E50", prodOrders, (jTextFieldKFE50PlannedStock.getText().equals("") ? "0" : jTextFieldKFE50PlannedStock.getText()));
            }
        });
        //E4
        jTextFieldKFE4PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
                jTextFieldKFE4ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E4", prodOrders, (jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
                jTextFieldKFE4ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E4", prodOrders, (jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE4SalesOrders.getText().equals("") ? "0" : jTextFieldKFE4SalesOrders.getText())), Integer.parseInt((jLabelKFE4OrdersInQueque.getText().equals("") ? "0" : jLabelKFE4OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText())), Integer.parseInt(jTextFieldKFE4StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE4StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE4OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE4OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE4WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE4WorkInProgress.getText())));
                jTextFieldKFE4ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E4", prodOrders, (jTextFieldKFE4PlannedStock.getText().equals("") ? "0" : jTextFieldKFE4PlannedStock.getText()));
            }
        });
        //E10
        jTextFieldKFE10PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
                jTextFieldKFE10ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E10", prodOrders, (jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
                jTextFieldKFE10ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E10", prodOrders, (jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE10SalesOrders.getText().equals("") ? "0" : jTextFieldKFE10SalesOrders.getText())), Integer.parseInt((jLabelKFE10OrdersInQueque.getText().equals("") ? "0" : jLabelKFE10OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText())), Integer.parseInt(jTextFieldKFE10StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE10StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE10OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE10OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE10WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE10WorkInProgress.getText())));
                jTextFieldKFE10ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E10", prodOrders, (jTextFieldKFE10PlannedStock.getText().equals("") ? "0" : jTextFieldKFE10PlannedStock.getText()));
            }
        });
        //E49
        jTextFieldKFE49PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
                jTextFieldKFE49ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E49", prodOrders, (jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
                jTextFieldKFE49ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E49", prodOrders, (jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE49SalesOrders.getText().equals("") ? "0" : jTextFieldKFE49SalesOrders.getText())), Integer.parseInt((jLabelKFE49OrdersInQueque.getText().equals("") ? "0" : jLabelKFE49OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText())), Integer.parseInt(jTextFieldKFE49StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE49StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE49OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE49OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE49WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE49WorkInProgress.getText())));
                jTextFieldKFE49ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E49", prodOrders, (jTextFieldKFE49PlannedStock.getText().equals("") ? "0" : jTextFieldKFE49PlannedStock.getText()));
            }
        });
        //E7
        jTextFieldKFE7PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
                jTextFieldKFE7ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E7", prodOrders, (jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
                jTextFieldKFE7ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E7", prodOrders, (jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE7SalesOrders.getText().equals("") ? "0" : jTextFieldKFE7SalesOrders.getText())), Integer.parseInt((jLabelKFE7OrdersInQueque.getText().equals("") ? "0" : jLabelKFE7OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText())), Integer.parseInt(jTextFieldKFE7StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE7StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE7OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE7OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE7WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE7WorkInProgress.getText())));
                jTextFieldKFE7ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E7", prodOrders, (jTextFieldKFE7PlannedStock.getText().equals("") ? "0" : jTextFieldKFE7PlannedStock.getText()));
            }
        });
        //E13
        jTextFieldKFE13PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
                jTextFieldKFE13ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E13", prodOrders, (jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
                jTextFieldKFE13ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E13", prodOrders, (jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE13SalesOrders.getText().equals("") ? "0" : jTextFieldKFE13SalesOrders.getText())), Integer.parseInt((jLabelKFE13OrdersInQueque.getText().equals("") ? "0" : jLabelKFE13OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText())), Integer.parseInt(jTextFieldKFE13StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE13StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE13OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE13OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE13WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE13WorkInProgress.getText())));
                jTextFieldKFE13ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E13", prodOrders, (jTextFieldKFE13PlannedStock.getText().equals("") ? "0" : jTextFieldKFE13PlannedStock.getText()));
            }
        });
        //E18
        jTextFieldKFE18PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
                jTextFieldKFE18ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E18", prodOrders, (jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
                jTextFieldKFE18ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E18", prodOrders, (jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String prodOrders = String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE18SalesOrders.getText().equals("") ? "0" : jTextFieldKFE18SalesOrders.getText())), Integer.parseInt((jLabelKFE18OrdersInQueque.getText().equals("") ? "0" : jLabelKFE18OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText())), Integer.parseInt(jTextFieldKFE18StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE18StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE18OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE18OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE18WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE18WorkInProgress.getText())));
                jTextFieldKFE18ProductionOrders.setText(prodOrders);
                updateExtendetArticle("E18", prodOrders, (jTextFieldKFE18PlannedStock.getText().equals("") ? "0" : jTextFieldKFE18PlannedStock.getText()));
            }
        });

        //Damenfahrrad
//        //SalesOrders
//        //P2
//        jTextFieldDFP2SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("P2");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("P2");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("P2");
//            }
//        });
//        //E26
//        jTextFieldDFE26SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E26");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E26");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E26");
//            }
//        });
//        //E56
//        jTextFieldDFE56SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E56");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E56");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E56");
//            }
//        });
//        //E16
//        jTextFieldDFE16SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E16");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E16");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E16");
//            }
//        });
//        //E17
//        jTextFieldDFE17SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E17");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E17");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E17");
//            }
//        });
//        //E55
//        jTextFieldDFE55SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E55");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E55");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E55");
//            }
//        });
//        //E5*
//        jTextFieldDFE5SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E5*");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E5*");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E5*");
//            }
//        });
//        //E11
//        jTextFieldDFE11SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E11");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E11");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E11");
//            }
//        });
//        //E54
//        jTextFieldDFE54SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E54");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E54");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E54");
//            }
//        });
//        //E8
//        jTextFieldDFE8SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E8");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E8");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E8");
//            }
//        });
//        //E14
//        jTextFieldDFE14SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E14");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E14");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E14");
//            }
//        });
//        //E19
//        jTextFieldDFE19SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E19");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E19");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldDFChanged("E19");
//            }
//        });
        //PlannedStock
        //P2
        jTextFieldDFP2PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("P2");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("P2");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("P2");
            }
        });
        //E26
        jTextFieldDFE26PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E26");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E26");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E26");
            }
        });
        //E56
        jTextFieldDFE56PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E56");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E56");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E56");
            }
        });
        //E16
        jTextFieldDFE16PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E16");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E16");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E16");
            }
        });
        //E17
        jTextFieldDFE17PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E17");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E17");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E17");
            }
        });
        //E55
        jTextFieldDFE55PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E55");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E55");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E55");
            }
        });
        //E5*
        jTextFieldDFE5PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E5*");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E5*");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E5*");
            }
        });
        //E11
        jTextFieldDFE11PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E11");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E11");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E11");
            }
        });
        //E54
        jTextFieldDFE54PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E54");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E54");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E54");
            }
        });
        //E8
        jTextFieldDFE8PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E8");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E8");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E8");
            }
        });
        //E14
        jTextFieldDFE14PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E14");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E14");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E14");
            }
        });
        //E19
        jTextFieldDFE19PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldDFChanged("E19");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldDFChanged("E19");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldDFChanged("E19");
            }
        });
        //Herrenfahrrad
//        //SalesOrders
//        //P3
//        jTextFieldHFP3SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("P3");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("P3");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("P3");
//            }
//        });
//        //E26
//        jTextFieldHFE26SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E26");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E26");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E26");
//            }
//        });
//        //E31
//        jTextFieldHFE31SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E31");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E31");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E31");
//            }
//        });
//        //E16
//        jTextFieldHFE16SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E16");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E16");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E16");
//            }
//        });
//        //E17
//        jTextFieldHFE17SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E17");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E17");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E17");
//            }
//        });
//        //E30
//        jTextFieldHFE30SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E30");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E30");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E30");
//            }
//        });
//        //E6*
//        jTextFieldHFE6SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E6*");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E6*");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E6*");
//            }
//        });
//        //E12
//        jTextFieldHFE12SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E12");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E12");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E12");
//            }
//        });
//        //E29
//        jTextFieldHFE29SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E29");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E29");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E29");
//            }
//        });
//        //E9
//        jTextFieldHFE9SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E9");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E9");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E9");
//            }
//        });
//        //E15
//        jTextFieldHFE15SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E15");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E15");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E15");
//            }
//        });
//        //E20
//        jTextFieldHFE20SalesOrders.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E20");
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E20");
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                inputFieldHFChanged("E20");
//            }
//        });
        //PlannedStock
        //P3
        jTextFieldHFP3PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("P3");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("P3");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("P3");
            }
        });
        //E26
        jTextFieldHFE26PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E26");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E26");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E26");
            }
        });
        //E31
        jTextFieldHFE31PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E31");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E31");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E31");
            }
        });
        //E16
        jTextFieldHFE16PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E16");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E16");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E16");
            }
        });
        //E17
        jTextFieldHFE17PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E17");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E17");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E17");
            }
        });
        //E30
        jTextFieldHFE30PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E30");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E30");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E30");
            }
        });
        //E6*
        jTextFieldHFE6PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E6*");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E6*");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E6*");
            }
        });
        //E12
        jTextFieldHFE12PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E12");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E12");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E12");
            }
        });
        //E29
        jTextFieldHFE29PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E29");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E29");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E29");
            }
        });
        //E9
        jTextFieldHFE9PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E9");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E9");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E9");
            }
        });
        //E15
        jTextFieldHFE15PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E15");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E15");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E15");
            }
        });
        //E20
        jTextFieldHFE20PlannedStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                inputFieldHFChanged("E20");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                inputFieldHFChanged("E20");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                inputFieldHFChanged("E20");
            }
        });

        //StockEndOfPeriod
        //P1
        jTextFieldKFP1StockEndOfPeriod.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }
        });
        //E26
        jTextFieldKFE26StockEndOfPeriod.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }
        });

        //OrdersInQueque
        //Kinderfahrrad
        //P1
        jTextFieldKFP1OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
                jLabelKFE26OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
                jLabelKFE51OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
                jLabelKFE26OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
                jLabelKFE51OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
                jLabelKFE26OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
                jLabelKFE51OrdersInQueque.setText(jTextFieldKFP1OrdersInQueque.getText());
            }
        });
        //E26
        jTextFieldKFE26OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }
        });
        //E51
        jTextFieldKFE51OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelKFE16OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE17OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE50OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelKFE16OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE17OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE50OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelKFE16OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE17OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
                jLabelKFE50OrdersInQueque.setText(jTextFieldKFE51OrdersInQueque.getText());
            }
        });
        //E50
        jTextFieldKFE50OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelKFE4OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE10OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE49OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelKFE4OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE10OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE49OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelKFE4OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE10OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
                jLabelKFE49OrdersInQueque.setText(jTextFieldKFE50OrdersInQueque.getText());
            }
        });
        //E49
        jTextFieldKFE49OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelKFE7OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE13OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE18OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelKFE7OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE13OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE18OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelKFE7OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE13OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
                jLabelKFE18OrdersInQueque.setText(jTextFieldKFE49OrdersInQueque.getText());
            }
        });
        //Damenfahrrad
        //P2
        jTextFieldDFP2OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelDFE26OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
                jLabelDFE56OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelDFE26OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
                jLabelDFE56OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelDFE26OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
                jLabelDFE56OrdersInQueque.setText(jTextFieldDFP2OrdersInQueque.getText());
            }
        });
        //E56
        jTextFieldDFE56OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelDFE16OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE17OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE55OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelDFE16OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE17OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE55OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelDFE16OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE17OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
                jLabelDFE55OrdersInQueque.setText(jTextFieldDFE56OrdersInQueque.getText());
            }
        });
        //E55
        jTextFieldDFE55OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelDFE5OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE11OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE54OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelDFE5OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE11OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE54OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelDFE5OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE11OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
                jLabelDFE54OrdersInQueque.setText(jTextFieldDFE55OrdersInQueque.getText());
            }
        });
        //E54
        jTextFieldDFE54OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelDFE8OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE14OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE19OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelDFE8OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE14OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE19OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelDFE8OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE14OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
                jLabelDFE19OrdersInQueque.setText(jTextFieldDFE54OrdersInQueque.getText());
            }
        });
        //Herrenfahrrad
        //P3
        jTextFieldHFP3OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelHFE26OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
                jLabelHFE31OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelHFE26OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
                jLabelHFE31OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelHFE26OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
                jLabelHFE31OrdersInQueque.setText(jTextFieldHFP3OrdersInQueque.getText());
            }
        });
        //E31
        jTextFieldHFE31OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelHFE16OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE17OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE30OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelHFE16OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE17OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE30OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelHFE16OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE17OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
                jLabelHFE30OrdersInQueque.setText(jTextFieldHFE31OrdersInQueque.getText());
            }
        });
        //30
        jTextFieldHFE30OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelHFE6OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE12OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE29OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelHFE6OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE12OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE29OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelHFE6OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE12OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
                jLabelHFE29OrdersInQueque.setText(jTextFieldHFE30OrdersInQueque.getText());
            }
        });
        //E29
        jTextFieldHFE29OrdersInQueque.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jLabelHFE9OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE15OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE20OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jLabelHFE9OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE15OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE20OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jLabelHFE9OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE15OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
                jLabelHFE20OrdersInQueque.setText(jTextFieldHFE29OrdersInQueque.getText());
            }
        });

        //WorkInProgress
        //P1
        jTextFieldKFP1WorkInProgress.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFP1ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFP1SalesOrders.getText().equals("") ? "0" : jTextFieldKFP1SalesOrders.getText())), 0, Integer.parseInt((jTextFieldKFP1PlannedStock.getText().equals("") ? "0" : jTextFieldKFP1PlannedStock.getText())), Integer.parseInt(jTextFieldKFP1StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFP1StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFP1OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFP1OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFP1WorkInProgress.getText().equals("") ? "0" : jTextFieldKFP1WorkInProgress.getText()))));
            }
        });
        //E26
        jTextFieldKFE26WorkInProgress.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE26ProductionOrders.setText(String.valueOf(calculateProductionOrders(Integer.parseInt((jTextFieldKFE26SalesOrders.getText().equals("") ? "0" : jTextFieldKFE26SalesOrders.getText())), Integer.parseInt((jLabelKFE26OrdersInQueque.getText().equals("") ? "0" : jLabelKFE26OrdersInQueque.getText())), Integer.parseInt((jTextFieldKFE26PlannedStock.getText().equals("") ? "0" : jTextFieldKFE26PlannedStock.getText())), Integer.parseInt(jTextFieldKFE26StockEndOfPeriod.getText().equals("") ? "0" : jTextFieldKFE26StockEndOfPeriod.getText()), Integer.parseInt(jTextFieldKFE26OrdersInQueque.getText().equals("") ? "0" : jTextFieldKFE26OrdersInQueque.getText()), Integer.parseInt(jTextFieldKFE26WorkInProgress.getText().equals("") ? "0" : jTextFieldKFE26WorkInProgress.getText()))));
            }
        });

        //Production Orders
        //Kinderfahrrad
        //P1
        jTextFieldKFP1ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE26SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
                jTextFieldKFE51SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE26SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
                jTextFieldKFE51SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE26SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
                jTextFieldKFE51SalesOrders.setText(jTextFieldKFP1ProductionOrders.getText());
            }
        });
        //E51
        jTextFieldKFE51ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE16SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE17SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE50SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE16SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE17SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE50SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE16SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE17SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
                jTextFieldKFE50SalesOrders.setText(jTextFieldKFE51ProductionOrders.getText());
            }
        });
        //E50
        jTextFieldKFE50ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE4SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE10SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE49SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE4SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE10SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE49SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE4SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE10SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
                jTextFieldKFE49SalesOrders.setText(jTextFieldKFE50ProductionOrders.getText());
            }
        });
        //E49
        jTextFieldKFE49ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldKFE7SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE13SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE18SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldKFE7SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE13SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE18SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldKFE7SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE13SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
                jTextFieldKFE18SalesOrders.setText(jTextFieldKFE49ProductionOrders.getText());
            }
        });

        //Damenfahrrad
        //P2
        jTextFieldDFP2ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldDFE26SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
                jTextFieldDFE56SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldDFE26SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
                jTextFieldDFE56SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldDFE26SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
                jTextFieldDFE56SalesOrders.setText(jTextFieldDFP2ProductionOrders.getText());
            }
        });
        //E56
        jTextFieldDFE56ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldDFE16SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE17SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE55SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldDFE16SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE17SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE55SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldDFE16SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE17SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
                jTextFieldDFE55SalesOrders.setText(jTextFieldDFE56ProductionOrders.getText());
            }
        });
        //E55
        jTextFieldDFE55ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldDFE5SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE11SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE54SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldDFE5SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE11SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE54SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldDFE5SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE11SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
                jTextFieldDFE54SalesOrders.setText(jTextFieldDFE55ProductionOrders.getText());
            }
        });
        //E54
        jTextFieldDFE54ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldDFE8SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE14SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE19SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldDFE8SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE14SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE19SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldDFE8SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE14SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
                jTextFieldDFE19SalesOrders.setText(jTextFieldDFE54ProductionOrders.getText());
            }
        });
        //Herrenfahrrad
        //P3
        jTextFieldHFP3ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldHFE26SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
                jTextFieldHFE31SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldHFE26SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
                jTextFieldHFE31SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldHFE26SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
                jTextFieldHFE31SalesOrders.setText(jTextFieldHFP3ProductionOrders.getText());
            }
        });
        //E31
        jTextFieldHFE31ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldHFE16SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE17SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE30SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldHFE16SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE17SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE30SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldHFE16SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE17SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
                jTextFieldHFE30SalesOrders.setText(jTextFieldHFE31ProductionOrders.getText());
            }
        });
        //E30
        jTextFieldHFE30ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldHFE6SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE12SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE29SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldHFE6SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE12SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE29SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldHFE6SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE12SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
                jTextFieldHFE29SalesOrders.setText(jTextFieldHFE30ProductionOrders.getText());
            }
        });
        //E29
        jTextFieldHFE29ProductionOrders.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldHFE9SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE15SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE20SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldHFE9SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE15SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE20SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextFieldHFE9SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE15SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
                jTextFieldHFE20SalesOrders.setText(jTextFieldHFE29ProductionOrders.getText());
            }
        });
    }

    Integer calculateProductionOrders(int salesOrder, int secondCollumn, int plannedStock, int stockEndOfPeriod, int ordersInQueQue, int workInProgress) {
        int result = salesOrder + secondCollumn + plannedStock - stockEndOfPeriod - ordersInQueQue - workInProgress;
        if (result < 0) {
            result = 0;
        }
//        return String.valueOf(result);
        return result;
    }

    void inputFieldDFChanged(String product) {
        List<JTextField> dfFields = getDFAllJTextFieldsByProduct(product);
        List<JTextField> hfFields = getHFAllJTextFieldsByProduct(product);
        List<JTextField> kfFields = getKFAllJTextFieldsByProduct(product);
        String hfOrdersInQueque = getHFJLabelOrdersInQuequeByProduct(product).getText();
        String dfOrdersInQueque = getDFJLabelOrdersInQuequeByProduct(product).getText();
        String kfOrdersInQueque = getKFJLabelOrdersInQuequeByProduct(product).getText();
//        String prodOrders = calculateProductionOrders(
//                Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
//                Integer.parseInt(ordersInQueque.equals("") ? "0" : ordersInQueque),
//                Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
//                Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
//                Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
//                Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
//        );
//        getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(prodOrders);
        String productId = product.replaceAll("[\\D]", "");
        
        int prodOrders = 0;
        long safety = 0;
        int id = Integer.valueOf(productId);
        switch(id) {
            case 26:
                safety = Long.valueOf((jTextFieldKFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE26PlannedStock.getText());
                
                int prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                int prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                int prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(String.valueOf(prodOrdDF));
                break;
            case 16:
                safety = Long.valueOf((jTextFieldKFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE16PlannedStock.getText());
                
                prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(String.valueOf(prodOrdDF));
                break;
            case 17:
                safety = Long.valueOf((jTextFieldKFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE17PlannedStock.getText());
                
                prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(String.valueOf(prodOrdDF));
                break;
            default :
                safety = Long.valueOf(getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText());
                
                prodOrders = calculateProductionOrders(
                        Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                        Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                        Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                        Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(String.valueOf(prodOrders));
        }
        
//        getDFJTextFieldByProduct(dfFields, "ProductionOrders").setText(String.valueOf(prodOrders));
        
        ExtendedArticle article = SharedInstance.getInstance().getArticleForId(Long.valueOf(productId));
        article.setPlannedProductionAmount(Long.valueOf(prodOrders));
        article.setSafetyStock(safety);
        SharedInstance.getInstance().setExtendedArticleForId(article.getId(), article);
    }

    private void updateExtendetArticle(String articleID, String productionOrders, String safetyStock) {
        List<JTextField> hfFields = getHFAllJTextFieldsByProduct(articleID);
        List<JTextField> dfFields = getDFAllJTextFieldsByProduct(articleID);
        List<JTextField> kfFields = getKFAllJTextFieldsByProduct(articleID);
        String hfOrdersInQueque = getHFJLabelOrdersInQuequeByProduct(articleID).getText();
        String dfOrdersInQueque = getDFJLabelOrdersInQuequeByProduct(articleID).getText();
        String kfOrdersInQueque = getKFJLabelOrdersInQuequeByProduct(articleID).getText();
        
        String productId = articleID.replaceAll("[\\D]", "");
        ExtendedArticle article = SharedInstance.getInstance().getArticleForId(Long.valueOf(productId));
        
        int prodOrders = 0;
        long safety = 0;
        int id = Integer.valueOf(productId);
        switch(id) {
            case 26:
                safety = Long.valueOf((jTextFieldKFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE26PlannedStock.getText());
                
                prodOrders = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText()
                            ));
                break;
            case 16:
                safety = Long.valueOf((jTextFieldKFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE16PlannedStock.getText());
                prodOrders = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText()
                            ));
                break;
            case 17:
                safety = Long.valueOf((jTextFieldKFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE17PlannedStock.getText());
                prodOrders = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    ) +
                        calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText()
                            ));
                break;
            default :
                safety = Long.valueOf(safetyStock);
                prodOrders = Integer.parseInt(productionOrders);
        }
        article.setSafetyStock(safety);
        article.setPlannedProductionAmount(Long.valueOf(prodOrders));
        SharedInstance.getInstance().setExtendedArticleForId(article.getId(), article);
    }

    JTextField getDFJTextFieldByProduct(List<JTextField> dfFields, String product) {
        JTextField field = new JTextField();
        for (JTextField jtf : dfFields) {
            if (jtf.getName().contains(product)) {
                field = jtf;
            }
        }
        return field;
    }

    public List<JTextField> getDFAllJTextFieldsByProduct(String product) {
        List<JTextField> dfFields = getDFJTextFields();
        List<JTextField> fields = new ArrayList<JTextField>();
        for (JTextField jtf : dfFields) {
            if (jtf.getName().contains(product)) {
                fields.add(jtf);
            }
        }
        return fields;
    }

    public List<JTextField> getDFJTextFields() {
        List<JTextField> fields = new ArrayList<JTextField>();
        fields.add(jTextFieldDFP2SalesOrders);
        fields.add(jTextFieldDFE26SalesOrders);
        fields.add(jTextFieldDFE56SalesOrders);
        fields.add(jTextFieldDFE16SalesOrders);
        fields.add(jTextFieldDFE17SalesOrders);
        fields.add(jTextFieldDFE55SalesOrders);
        fields.add(jTextFieldDFE5SalesOrders);
        fields.add(jTextFieldDFE11SalesOrders);
        fields.add(jTextFieldDFE54SalesOrders);
        fields.add(jTextFieldDFE8SalesOrders);
        fields.add(jTextFieldDFE14SalesOrders);
        fields.add(jTextFieldDFE19SalesOrders);

        fields.add(jTextFieldDFP2PlannedStock);
        fields.add(jTextFieldDFE26PlannedStock);
        fields.add(jTextFieldDFE56PlannedStock);
        fields.add(jTextFieldDFE16PlannedStock);
        fields.add(jTextFieldDFE17PlannedStock);
        fields.add(jTextFieldDFE55PlannedStock);
        fields.add(jTextFieldDFE5PlannedStock);
        fields.add(jTextFieldDFE11PlannedStock);
        fields.add(jTextFieldDFE54PlannedStock);
        fields.add(jTextFieldDFE8PlannedStock);
        fields.add(jTextFieldDFE14PlannedStock);
        fields.add(jTextFieldDFE19PlannedStock);

        fields.add(jTextFieldDFP2StockEndOfPeriod);
        fields.add(jTextFieldDFE26StockEndOfPeriod);
        fields.add(jTextFieldDFE56StockEndOfPeriod);
        fields.add(jTextFieldDFE16StockEndOfPeriod);
        fields.add(jTextFieldDFE17StockEndOfPeriod);
        fields.add(jTextFieldDFE55StockEndOfPeriod);
        fields.add(jTextFieldDFE5StockEndOfPeriod);
        fields.add(jTextFieldDFE11StockEndOfPeriod);
        fields.add(jTextFieldDFE54StockEndOfPeriod);
        fields.add(jTextFieldDFE8StockEndOfPeriod);
        fields.add(jTextFieldDFE14StockEndOfPeriod);
        fields.add(jTextFieldDFE19StockEndOfPeriod);

        fields.add(jTextFieldDFP2OrdersInQueque);
        fields.add(jTextFieldDFE26OrdersInQueque);
        fields.add(jTextFieldDFE56OrdersInQueque);
        fields.add(jTextFieldDFE16OrdersInQueque);
        fields.add(jTextFieldDFE17OrdersInQueque);
        fields.add(jTextFieldDFE55OrdersInQueque);
        fields.add(jTextFieldDFE5OrdersInQueque);
        fields.add(jTextFieldDFE11OrdersInQueque);
        fields.add(jTextFieldDFE54OrdersInQueque);
        fields.add(jTextFieldDFE8OrdersInQueque);
        fields.add(jTextFieldDFE14OrdersInQueque);
        fields.add(jTextFieldDFE19OrdersInQueque);

        fields.add(jTextFieldDFP2WorkInProgress);
        fields.add(jTextFieldDFE26WorkInProgress);
        fields.add(jTextFieldDFE56WorkInProgress);
        fields.add(jTextFieldDFE16WorkInProgress);
        fields.add(jTextFieldDFE17WorkInProgress);
        fields.add(jTextFieldDFE55WorkInProgress);
        fields.add(jTextFieldDFE5WorkInProgress);
        fields.add(jTextFieldDFE11WorkInProgress);
        fields.add(jTextFieldDFE54WorkInProgress);
        fields.add(jTextFieldDFE8WorkInProgress);
        fields.add(jTextFieldDFE14WorkInProgress);
        fields.add(jTextFieldDFE19WorkInProgress);

        fields.add(jTextFieldDFP2ProductionOrders);
        fields.add(jTextFieldDFE26ProductionOrders);
        fields.add(jTextFieldDFE56ProductionOrders);
        fields.add(jTextFieldDFE16ProductionOrders);
        fields.add(jTextFieldDFE17ProductionOrders);
        fields.add(jTextFieldDFE55ProductionOrders);
        fields.add(jTextFieldDFE5ProductionOrders);
        fields.add(jTextFieldDFE11ProductionOrders);
        fields.add(jTextFieldDFE54ProductionOrders);
        fields.add(jTextFieldDFE8ProductionOrders);
        fields.add(jTextFieldDFE14ProductionOrders);
        fields.add(jTextFieldDFE19ProductionOrders);
        return fields;
    }

    public Map<JTextField, String> getMapFieldsWithKeys(List<JTextField> fields) {
        Map<JTextField, String> fieldsWithKeys = new HashMap<>();
        for (JTextField field : fields) {
            String prodNumber = field.getName().replaceAll("[^0-9]+", "");
            fieldsWithKeys.put(field, prodNumber);
        }
        return fieldsWithKeys;
    }

    public List<JLabel> getDFJLablesOrdersInQueque() {
        List<JLabel> labelsOrdersInQueque = new ArrayList<>();
        labelsOrdersInQueque.add(jLabelDFE26OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE56OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE16OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE17OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE55OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE5OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE11OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE54OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE8OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE14OrdersInQueque);
        labelsOrdersInQueque.add(jLabelDFE19OrdersInQueque);
        return labelsOrdersInQueque;
    }
    
    public List<JLabel> getKFJLablesOrdersInQueque() {
        List<JLabel> labelsOrdersInQueque = new ArrayList<>();
        labelsOrdersInQueque.add(jLabelKFE26OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE51OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE16OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE17OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE50OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE4OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE10OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE49OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE7OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE13OrdersInQueque);
        labelsOrdersInQueque.add(jLabelKFE18OrdersInQueque);
        return labelsOrdersInQueque;
    }

    JLabel getDFJLabelOrdersInQuequeByProduct(String product) {
        JLabel label = new JLabel("");
        List<JLabel> labelsOrdersInQueque = getDFJLablesOrdersInQueque();
        for (JLabel lbl : labelsOrdersInQueque) {
            if (lbl.getName().contains(product)) {
                label = lbl;
            }
        }
        return label;
    }
    
    JLabel getKFJLabelOrdersInQuequeByProduct(String product) {
        JLabel label = new JLabel("");
        List<JLabel> labelsOrdersInQueque = getKFJLablesOrdersInQueque();
        for (JLabel lbl : labelsOrdersInQueque) {
            if (lbl.getName().contains(product)) {
                label = lbl;
            }
        }
        return label;
    }

    public List<JTextField> getHFJTextFields() {
        List<JTextField> fields = new ArrayList<JTextField>();
        fields.add(jTextFieldHFP3SalesOrders);
        fields.add(jTextFieldHFE26SalesOrders);
        fields.add(jTextFieldHFE31SalesOrders);
        fields.add(jTextFieldHFE16SalesOrders);
        fields.add(jTextFieldHFE17SalesOrders);
        fields.add(jTextFieldHFE30SalesOrders);
        fields.add(jTextFieldHFE6SalesOrders);
        fields.add(jTextFieldHFE12SalesOrders);
        fields.add(jTextFieldHFE29SalesOrders);
        fields.add(jTextFieldHFE9SalesOrders);
        fields.add(jTextFieldHFE15SalesOrders);
        fields.add(jTextFieldHFE20SalesOrders);

        fields.add(jTextFieldHFP3PlannedStock);
        fields.add(jTextFieldHFE26PlannedStock);
        fields.add(jTextFieldHFE31PlannedStock);
        fields.add(jTextFieldHFE16PlannedStock);
        fields.add(jTextFieldHFE17PlannedStock);
        fields.add(jTextFieldHFE30PlannedStock);
        fields.add(jTextFieldHFE6PlannedStock);
        fields.add(jTextFieldHFE12PlannedStock);
        fields.add(jTextFieldHFE29PlannedStock);
        fields.add(jTextFieldHFE9PlannedStock);
        fields.add(jTextFieldHFE15PlannedStock);
        fields.add(jTextFieldHFE20PlannedStock);

        fields.add(jTextFieldHFP3StockEndOfPeriod);
        fields.add(jTextFieldHFE26StockEndOfPeriod);
        fields.add(jTextFieldHFE31StockEndOfPeriod);
        fields.add(jTextFieldHFE16StockEndOfPeriod);
        fields.add(jTextFieldHFE17StockEndOfPeriod);
        fields.add(jTextFieldHFE30StockEndOfPeriod);
        fields.add(jTextFieldHFE6StockEndOfPeriod);
        fields.add(jTextFieldHFE12StockEndOfPeriod);
        fields.add(jTextFieldHFE29StockEndOfPeriod);
        fields.add(jTextFieldHFE9StockEndOfPeriod);
        fields.add(jTextFieldHFE15StockEndOfPeriod);
        fields.add(jTextFieldHFE20StockEndOfPeriod);

        fields.add(jTextFieldHFP3OrdersInQueque);
        fields.add(jTextFieldHFE26OrdersInQueque);
        fields.add(jTextFieldHFE31OrdersInQueque);
        fields.add(jTextFieldHFE16OrdersInQueque);
        fields.add(jTextFieldHFE17OrdersInQueque);
        fields.add(jTextFieldHFE30OrdersInQueque);
        fields.add(jTextFieldHFE6OrdersInQueque);
        fields.add(jTextFieldHFE12OrdersInQueque);
        fields.add(jTextFieldHFE29OrdersInQueque);
        fields.add(jTextFieldHFE9OrdersInQueque);
        fields.add(jTextFieldHFE15OrdersInQueque);
        fields.add(jTextFieldHFE20OrdersInQueque);

        fields.add(jTextFieldHFP3WorkInProgress);
        fields.add(jTextFieldHFE26WorkInProgress);
        fields.add(jTextFieldHFE31WorkInProgress);
        fields.add(jTextFieldHFE16WorkInProgress);
        fields.add(jTextFieldHFE17WorkInProgress);
        fields.add(jTextFieldHFE30WorkInProgress);
        fields.add(jTextFieldHFE6WorkInProgress);
        fields.add(jTextFieldHFE12WorkInProgress);
        fields.add(jTextFieldHFE29WorkInProgress);
        fields.add(jTextFieldHFE9WorkInProgress);
        fields.add(jTextFieldHFE15WorkInProgress);
        fields.add(jTextFieldHFE20WorkInProgress);

        fields.add(jTextFieldHFP3ProductionOrders);
        fields.add(jTextFieldHFE26ProductionOrders);
        fields.add(jTextFieldHFE31ProductionOrders);
        fields.add(jTextFieldHFE16ProductionOrders);
        fields.add(jTextFieldHFE17ProductionOrders);
        fields.add(jTextFieldHFE30ProductionOrders);
        fields.add(jTextFieldHFE6ProductionOrders);
        fields.add(jTextFieldHFE12ProductionOrders);
        fields.add(jTextFieldHFE29ProductionOrders);
        fields.add(jTextFieldHFE9ProductionOrders);
        fields.add(jTextFieldHFE15ProductionOrders);
        fields.add(jTextFieldHFE20ProductionOrders);
        return fields;
    }

    public List<JLabel> getHFJLablesOrdersInQueque() {
        List<JLabel> labelsOrdersInQueque = new ArrayList<>();
        labelsOrdersInQueque.add(jLabelHFE26OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE31OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE16OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE17OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE30OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE6OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE12OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE29OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE9OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE15OrdersInQueque);
        labelsOrdersInQueque.add(jLabelHFE20OrdersInQueque);
        return labelsOrdersInQueque;
    }

    public List<JTextField> getKFJTextFields() {
        List<JTextField> fields = new ArrayList<JTextField>();
        fields.add(jTextFieldKFP1SalesOrders);
        fields.add(jTextFieldKFE26SalesOrders);
        fields.add(jTextFieldKFE51SalesOrders);
        fields.add(jTextFieldKFE16SalesOrders);
        fields.add(jTextFieldKFE17SalesOrders);
        fields.add(jTextFieldKFE50SalesOrders);
        fields.add(jTextFieldKFE4SalesOrders);
        fields.add(jTextFieldKFE10SalesOrders);
        fields.add(jTextFieldKFE49SalesOrders);
        fields.add(jTextFieldKFE7SalesOrders);
        fields.add(jTextFieldKFE13SalesOrders);
        fields.add(jTextFieldKFE18SalesOrders);

        fields.add(jTextFieldKFP1PlannedStock);
        fields.add(jTextFieldKFE26PlannedStock);
        fields.add(jTextFieldKFE51PlannedStock);
        fields.add(jTextFieldKFE16PlannedStock);
        fields.add(jTextFieldKFE17PlannedStock);
        fields.add(jTextFieldKFE50PlannedStock);
        fields.add(jTextFieldKFE4PlannedStock);
        fields.add(jTextFieldKFE10PlannedStock);
        fields.add(jTextFieldKFE49PlannedStock);
        fields.add(jTextFieldKFE7PlannedStock);
        fields.add(jTextFieldKFE13PlannedStock);
        fields.add(jTextFieldKFE18PlannedStock);

        fields.add(jTextFieldKFP1StockEndOfPeriod);
        fields.add(jTextFieldKFE26StockEndOfPeriod);
        fields.add(jTextFieldKFE51StockEndOfPeriod);
        fields.add(jTextFieldKFE16StockEndOfPeriod);
        fields.add(jTextFieldKFE17StockEndOfPeriod);
        fields.add(jTextFieldKFE50StockEndOfPeriod);
        fields.add(jTextFieldKFE4StockEndOfPeriod);
        fields.add(jTextFieldKFE10StockEndOfPeriod);
        fields.add(jTextFieldKFE49StockEndOfPeriod);
        fields.add(jTextFieldKFE7StockEndOfPeriod);
        fields.add(jTextFieldKFE13StockEndOfPeriod);
        fields.add(jTextFieldKFE18StockEndOfPeriod);

        fields.add(jTextFieldKFP1OrdersInQueque);
        fields.add(jTextFieldKFE26OrdersInQueque);
        fields.add(jTextFieldKFE51OrdersInQueque);
        fields.add(jTextFieldKFE16OrdersInQueque);
        fields.add(jTextFieldKFE17OrdersInQueque);
        fields.add(jTextFieldKFE50OrdersInQueque);
        fields.add(jTextFieldKFE4OrdersInQueque);
        fields.add(jTextFieldKFE10OrdersInQueque);
        fields.add(jTextFieldKFE49OrdersInQueque);
        fields.add(jTextFieldKFE7OrdersInQueque);
        fields.add(jTextFieldKFE13OrdersInQueque);
        fields.add(jTextFieldKFE18OrdersInQueque);

        fields.add(jTextFieldKFP1WorkInProgress);
        fields.add(jTextFieldKFE26WorkInProgress);
        fields.add(jTextFieldKFE51WorkInProgress);
        fields.add(jTextFieldKFE16WorkInProgress);
        fields.add(jTextFieldKFE17WorkInProgress);
        fields.add(jTextFieldKFE50WorkInProgress);
        fields.add(jTextFieldKFE4WorkInProgress);
        fields.add(jTextFieldKFE10WorkInProgress);
        fields.add(jTextFieldKFE49WorkInProgress);
        fields.add(jTextFieldKFE7WorkInProgress);
        fields.add(jTextFieldKFE13WorkInProgress);
        fields.add(jTextFieldKFE18WorkInProgress);

        fields.add(jTextFieldKFP1ProductionOrders);
        fields.add(jTextFieldKFE26ProductionOrders);
        fields.add(jTextFieldKFE51ProductionOrders);
        fields.add(jTextFieldKFE16ProductionOrders);
        fields.add(jTextFieldKFE17ProductionOrders);
        fields.add(jTextFieldKFE50ProductionOrders);
        fields.add(jTextFieldKFE4ProductionOrders);
        fields.add(jTextFieldKFE10ProductionOrders);
        fields.add(jTextFieldKFE49ProductionOrders);
        fields.add(jTextFieldKFE7ProductionOrders);
        fields.add(jTextFieldKFE13ProductionOrders);
        fields.add(jTextFieldKFE18ProductionOrders);

        return fields;
    }

    JLabel getHFJLabelOrdersInQuequeByProduct(String product) {
        JLabel label = new JLabel("");
        List<JLabel> labelsOrdersInQueque = getHFJLablesOrdersInQueque();
        for (JLabel lbl : labelsOrdersInQueque) {
            if (lbl.getName().contains(product)) {
                label = lbl;
            }
        }
        return label;
    }

    void inputFieldHFChanged(String product) {
        List<JTextField> hfFields = getHFAllJTextFieldsByProduct(product);
        List<JTextField> dfFields = getDFAllJTextFieldsByProduct(product);
        List<JTextField> kfFields = getKFAllJTextFieldsByProduct(product);
        String hfOrdersInQueque = getHFJLabelOrdersInQuequeByProduct(product).getText();
        String dfOrdersInQueque = getDFJLabelOrdersInQuequeByProduct(product).getText();
        String kfOrdersInQueque = getKFJLabelOrdersInQuequeByProduct(product).getText();
//        String prodOrders = calculateProductionOrders(
//                Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
//                Integer.parseInt(ordersInQueque.equals("") ? "0" : ordersInQueque),
//                Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
//                Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
//                Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
//                Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
//        );
//        getHFJTextFieldByProduct(hfFields, "ProductionOrders").setText(prodOrders);
        String productId = product.replaceAll("[\\D]", "");
        
        int prodOrders = 0;
        long safety = 0;
        int id = Integer.valueOf(productId);
        switch(id) {
            case 26:
                safety = Long.valueOf((jTextFieldKFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE26PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE26PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE26PlannedStock.getText());
                
                int prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                int prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                int prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getHFJTextFieldByProduct(hfFields, "ProductionOrders").setText(String.valueOf(prodOrdHF));
                break;
            case 16:
                safety = Long.valueOf((jTextFieldKFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE16PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE16PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE16PlannedStock.getText());
                
                prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getHFJTextFieldByProduct(hfFields, "ProductionOrders").setText(String.valueOf(prodOrdHF));
                break;
            case 17:
                safety = Long.valueOf((jTextFieldKFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldKFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldDFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldDFE17PlannedStock.getText())
                + Long.valueOf((jTextFieldHFE17PlannedStock.getText().isEmpty())? "0" : jTextFieldHFE17PlannedStock.getText());
                
                prodOrdHF = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                prodOrdDF = calculateProductionOrders(
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "SalesOrders").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "SalesOrders").getText())),
                            Integer.parseInt(dfOrdersInQueque.equals("") ? "0" : dfOrdersInQueque),
                            Integer.parseInt((getDFJTextFieldByProduct(dfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "PlannedStock").getText())),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText().equals("") ? "0" : getDFJTextFieldByProduct(dfFields, "WorkInProgress").getText())
                    );
                prodOrdKF = calculateProductionOrders(
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "SalesOrders").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "SalesOrders").getText())),
                            Integer.parseInt(kfOrdersInQueque.equals("") ? "0" : kfOrdersInQueque),
                            Integer.parseInt((getKFJTextFieldByProduct(kfFields, "PlannedStock").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "PlannedStock").getText())),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "StockEndOfPeriod").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "OrdersInQueque").getText()),
                            Integer.parseInt(getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText().equals("") ? "0" : getKFJTextFieldByProduct(kfFields, "WorkInProgress").getText())
                            );
                prodOrders = prodOrdHF + prodOrdDF + prodOrdKF;
                getHFJTextFieldByProduct(hfFields, "ProductionOrders").setText(String.valueOf(prodOrdHF));
                break;
            default :
                safety = Long.valueOf(getDFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getDFJTextFieldByProduct(hfFields, "PlannedStock").getText());
                prodOrders = calculateProductionOrders(
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "SalesOrders").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "SalesOrders").getText())),
                        Integer.parseInt(hfOrdersInQueque.equals("") ? "0" : hfOrdersInQueque),
                        Integer.parseInt((getHFJTextFieldByProduct(hfFields, "PlannedStock").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "PlannedStock").getText())),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "StockEndOfPeriod").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "OrdersInQueque").getText()),
                        Integer.parseInt(getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText().equals("") ? "0" : getHFJTextFieldByProduct(hfFields, "WorkInProgress").getText())
                    );
                getHFJTextFieldByProduct(hfFields, "ProductionOrders").setText(String.valueOf(prodOrders));
        }
        
        
        
        ExtendedArticle article = SharedInstance.getInstance().getArticleForId(Long.valueOf(productId));
        article.setPlannedProductionAmount(Long.valueOf(prodOrders));
        article.setSafetyStock(safety);
        SharedInstance.getInstance().setExtendedArticleForId(article.getId(), article);
    }

    JTextField getHFJTextFieldByProduct(List<JTextField> hfFields, String product) {
        JTextField field = new JTextField();
        for (JTextField jtf : hfFields) {
            if (jtf.getName().contains(product)) {
                field = jtf;
            }
        }
        return field;
    }

    public List<JTextField> getHFAllJTextFieldsByProduct(String product) {
        List<JTextField> hfFields = getHFJTextFields();
        List<JTextField> fields = new ArrayList<JTextField>();
        for (JTextField jtf : hfFields) {
            if (jtf.getName().contains(product)) {
                fields.add(jtf);
            }
        }
        return fields;
    }
    
    JTextField getKFJTextFieldByProduct(List<JTextField> kfFields, String product) {
        JTextField field = new JTextField();
        for (JTextField jtf : kfFields) {
            if (jtf.getName().contains(product)) {
                field = jtf;
            }
        }
        return field;
    }
    
    public List<JTextField> getKFAllJTextFieldsByProduct(String product) {
        List<JTextField> kfFields = getKFJTextFields();
        List<JTextField> fields = new ArrayList<JTextField>();
        for (JTextField jtf : kfFields) {
            if (jtf.getName().contains(product)) {
                fields.add(jtf);
            }
        }
        return fields;
    }

    private void fillCostsLabelValues(Costs costs) {
        jLabelCostsOldStockValue.setText(String.valueOf(costs.getOldStockValue()));
        jLabelCostsEstimatedStockValue.setText(String.valueOf(costs.getEstimatedStockValue()));
        jLabelCostsNumberHouses.setText(String.valueOf(costs.getCountOfWarehouses()));
        jLabelCostsWarehouseHoldungValue.setText(String.valueOf(costs.getWarehouseHoldingCosts()));
        jLabelCostsWarehouseHoldingPct.setText(String.valueOf(costs.getWarehouseHoldingPctChange()) + " %");
        jLabelCostsNumberHousesChange.setText(String.valueOf(costs.getCountWarehouseChange()));
        jLabelCostsEstimatedStockValuePct.setText(String.valueOf(costs.getStockChangePct()) + " %");

        jLabelCostsLaborCosts.setText(String.valueOf(costs.getLaborCosts()));
    }

    private void resetCostsFields() {
        jLabelCostsOldStockValue.setText("0");
        jLabelCostsEstimatedStockValue.setText("0");
        jLabelCostsNumberHouses.setText("0");
        jLabelCostsWarehouseHoldungValue.setText("0");
        jLabelCostsWarehouseHoldingPct.setText("0");
        jLabelCostsNumberHousesChange.setText("0");
        jLabelCostsEstimatedStockValuePct.setText("0");

        jLabelCostsLaborCosts.setText("0");
    }

    private void setTableEditColors() {
        jTableWorkloadPlanning.getColumnModel().getColumn(1).setCellRenderer(new HighlightTableCell());
        jTableWorkloadPlanning.getColumnModel().getColumn(3).setCellRenderer(new HighlightTableCell());
        jTablePurchasingDisposition.getColumnModel().getColumn(2).setCellRenderer(new HighlightTableCell());
        jTablePurchasingDisposition.getColumnModel().getColumn(3).setCellRenderer(new HighlightTableCell());
    }

}
