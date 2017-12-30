
public class MemorySlot {

    private int start;
    private int end;
    private String status;

    public MemorySlot(int start1, int end1, String status1){

        start = start1;
        end = end1;
        status = status1;

    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }

    public String getStatus(){
        return this.status;
    }

    public int getSize(){
        return (this.end-this.start);
    }

    public void setStart(int processSize){
        this.start+=processSize;
    }

    public void setStatus(String s){
        this.status = s;
    }
}
