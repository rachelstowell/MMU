
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MMU {

    public static void main(String[] args) throws IOException {

        Scanner inFile = new Scanner(new File("Minput.data"));
        int numOfSlots = inFile.nextInt();
        MemorySlot[] MSA1 = new MemorySlot[numOfSlots];
        MemorySlot[] MSA2 = new MemorySlot[numOfSlots];
        MemorySlot[] MSA3 = new MemorySlot[numOfSlots];
        for (int i = 0; i < MSA1.length; i++) {
            int a = inFile.nextInt();
            int b = inFile.nextInt();
            MSA1[i] = new MemorySlot(a, b, "Empty");
            MSA2[i] = new MemorySlot(a, b, "Empty");
            MSA3[i] = new MemorySlot(a, b, "Empty");
        }

        int numOfProcesses = inFile.nextInt();
        Process[] PA1 = new Process[numOfProcesses];
        Process[] PA2 = new Process[numOfProcesses];
        Process[] PA3 = new Process[numOfProcesses];
        for (int i = 0; i < PA1.length; i++) {
            int c = inFile.nextInt();
            int d = inFile.nextInt();
            PA1[i] = new Process(c, d, "Not Allocated");
            PA2[i] = new Process(c, d, "Not Allocated");
            PA3[i] = new Process(c, d, "Not Allocated");
        }


        FirstFit(MSA1, PA1);
        BestFit(MSA2, PA2);
        WorstFit(MSA3, PA3);


    }

    public static void FirstFit(MemorySlot[] MSA1, Process[] PA1) throws IOException {
        FileWriter fileWriter = new FileWriter("FFoutput.data");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        ArrayList<Integer> notAllocated = new ArrayList<Integer>();


        for (int i = 0; i < PA1.length; i++) {
            for (int j = 0; j < MSA1.length; j++) {
                if (MSA1[j].getSize() >= PA1[i].getProcessSize()) {
                    printWriter.println(MSA1[j].getStart() + " " + (MSA1[j].getStart() + PA1[i].getProcessSize()) + " " + PA1[i].getProcessID());
                    MSA1[j].setStart(PA1[i].getProcessSize());
                    MSA1[j].setStatus("Occupied");
                    PA1[i].setAllocationStatus("Allocated");
                    break;
                    //print start end and ID of process
                    //put the process here
                    //update the memoryslot start and status
                    //mark process status as allocated
                    //break out of loop, stop looking at other memory slots
                } else if (j == MSA1.length - 1) {
                    notAllocated.add(PA1[i].getProcessID());
                    //failed to allocate this process
                    //add it to the list of processes that were not allocated
                }
            }
        }

        printWriter.print("-");
        if(notAllocated.size()>0){
            for (int n = 0; n < notAllocated.size(); n++) {
                printWriter.print(notAllocated.get(n) + ", ");
            }
        }
        else{
            printWriter.print(0);
        }


        printWriter.close();

    }


    public static void BestFit(MemorySlot[] MSA1, Process[] PA1) throws IOException {
        FileWriter fileWriter = new FileWriter("BFoutput.data");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        ArrayList<Integer> notAllocated = new ArrayList<Integer>();


        for (int i = 0; i < PA1.length; i++) {
            int indexOfMin = -1;
            int minSizeDifference = 10000;

            for (int j = 0; j < MSA1.length; j++) {
                //find min size difference
                if(PA1[i].getProcessSize() <= MSA1[j].getSize()){
                    if((MSA1[j].getSize() - PA1[i].getProcessSize()) < minSizeDifference){
                        indexOfMin = j;
                        minSizeDifference = (MSA1[j].getSize() - PA1[i].getProcessSize());
                    }
                }

            }

            if(indexOfMin == -1){
                notAllocated.add(PA1[i].getProcessID());
            }
            else{
                //put process into MSA1[indexOfMin]
                printWriter.println(MSA1[indexOfMin].getStart() + " " + (MSA1[indexOfMin].getStart() + PA1[i].getProcessSize()) + " " + PA1[i].getProcessID());
                MSA1[indexOfMin].setStart(PA1[i].getProcessSize());
                MSA1[indexOfMin].setStatus("Occupied");
                PA1[i].setAllocationStatus("Allocated");
            }



        }

        printWriter.print("-");
        if(notAllocated.size()>0){
            for (int n = 0; n < notAllocated.size(); n++) {
                printWriter.print(notAllocated.get(n) + ", ");
            }
        }
        else{
            printWriter.print(0);
        }


        printWriter.close();
    }

    public static void WorstFit(MemorySlot[] MSA1, Process[] PA1) throws IOException {
        FileWriter fileWriter = new FileWriter("WFoutput.data");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        ArrayList<Integer> notAllocated = new ArrayList<Integer>();

        for (int i = 0; i < PA1.length; i++) {
            int indexOfMax = -1;
            int maxSizeDifference = 0;

            for (int j = 0; j < MSA1.length; j++) {
                //find max size difference
                if(PA1[i].getProcessSize() <= MSA1[j].getSize()){
                    if((MSA1[j].getSize() - PA1[i].getProcessSize()) >= maxSizeDifference){
                        indexOfMax = j;
                        maxSizeDifference = (MSA1[j].getSize() - PA1[i].getProcessSize());
                    }
                }

            }

            if(indexOfMax == -1){
                notAllocated.add(PA1[i].getProcessID());
            }
            else{
                //put process into MSA1[indexOfMin]
                printWriter.println(MSA1[indexOfMax].getStart() + " " + (MSA1[indexOfMax].getStart() + PA1[i].getProcessSize()) + " " + PA1[i].getProcessID());
                MSA1[indexOfMax].setStart(PA1[i].getProcessSize());
                MSA1[indexOfMax].setStatus("Occupied");
                PA1[i].setAllocationStatus("Allocated");
            }



        }

        printWriter.print("-");
        if(notAllocated.size()>0){
            for (int n = 0; n < notAllocated.size(); n++) {
                printWriter.print(notAllocated.get(n) + ", ");
            }
        }
        else{
            printWriter.print(0);
        }


        printWriter.close();
    }




}

