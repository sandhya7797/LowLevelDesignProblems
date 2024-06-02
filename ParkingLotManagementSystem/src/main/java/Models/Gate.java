package Models;

import Enums.GateStatusType;
import Enums.GateType;

public class Gate extends BaseModel {

    private int id;
    private int gateNum;
    private GateType gateType;
    private Operator operator;
    private GateStatusType gateStatusType;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getGateNum() {
        return gateNum;
    }

    public void setGateNum(int gateNum) {
        this.gateNum = gateNum;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatusType getGateStatusType() {
        return gateStatusType;
    }

    public void setGateStatusType(GateStatusType gateStatusType) {
        this.gateStatusType = gateStatusType;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateNum=" + gateNum +
                ", gateType=" + gateType +
                ", operator=" + operator +
                ", gateStatusType=" + gateStatusType +
                '}';
    }
}
