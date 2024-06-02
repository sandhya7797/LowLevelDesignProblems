package Models;

public class Operator extends BaseModel {
    private int empId;
    private String operatorName;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "empId=" + empId +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
