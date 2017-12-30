# MMU

Description of Scheduling Algorithm:
The pre-emptive priority high scheduling algorithm is an algorithm that allows for context switches during process execution. This can be a useful algorithm to prevent the starvation of high priority processes. 

Description of Implementation:
The implementation of this algorithm starts by reading in processes from a text file, and creating a PCB object for each process. Each PCB object (process control block) contains the process state, arrival time, process ID, CPU burst time, and priority of each process. These PCBs are updating during context switches. 
At each second, the scheduler checks to see if a process arrives. If a process arrives, the scheduler checks to see if the CPU is available. If it is available, the scheduler allows the process to enter the CPU. If not, the scheduler will compare the priority of the new process with the current process in execution, and switch the context of the CPU to contain the higher priority process. When a process terminates, the scheduler looks through any processes that are in the waiting state, and picks the waiting process with the highest priority to have next access to CPU.
At each context switch and termination, the scheduler writes the results to the output file. 
