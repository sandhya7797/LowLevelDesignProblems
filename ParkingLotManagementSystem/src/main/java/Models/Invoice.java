package Models;

import Enums.InvoiceStatusType;
import Strategies.FeeCalculationStrategy.FeeCalculationStrategy;

import java.sql.Time;
import java.util.List;

public class Invoice extends BaseModel {
    private int id;
    private InvoiceStatusType invoiceStatusType;
    private Ticket token;
    private List<Payment> paymentList;
    private double amount;
    private Operator operator;
    private Gate gate;
    private FeeCalculationStrategy feeCalculationStrategy;
    private Time exitTime;

}
