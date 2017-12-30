
public class Process {

    private int processSize;
    private int processID;
    private String allocationStatus;

    public Process(int ID, int size, String allocation){
        processID = ID;
        processSize = size;
        allocationStatus = allocation;
    }

    public int getProcessSize(){
        return this.processSize;
    }

    public int getProcessID(){
        return this.processID;
    }

    public String getAllocationStatus(){
        return this.allocationStatus;
    }

    public void setAllocationStatus(String allocationStatus) {
        this.allocationStatus = allocationStatus;
    }
}
