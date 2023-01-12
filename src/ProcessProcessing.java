public class ProcessProcessing {
    private int inTime;
    private int outTime;
    private int processId;
    private int priority;

    private int burstTime;

    private int prosesStatus;

    public ProcessProcessing(int inTime, int outTime, int processId,int priority,int burstTime) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.processId = processId;
        this.priority=priority;
        this.burstTime=burstTime;
    }
    @Override
    public String toString() {

        String result="";
        if(outTime-inTime==1 && burstTime !=1)
        {
            result= inTime + " sn  " + "Process Start" + "   (id:"+processId+ "  Priority:"+ (priority-1) + "  Remainder:"+ (burstTime) +")"+"\n";
            result+=(inTime+1) + " sn  " + "Process Waiting" + " (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ (burstTime-1) +")"+"\n";
            return result;
        }
        else if (outTime-inTime==1 && burstTime == 1) 
        {
            result= inTime + " sn  " + "Process Start" + "   (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ (burstTime )+")"+"\n";
            result+=(inTime+1) + " sn  " + "Process Finish" + "  (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ (burstTime-1) +")"+"\n";
            return result;
        }
        else if (outTime-inTime==burstTime)
        {
            result=inTime + " sn  " + "Process Start" + "   (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ burstTime +")"+"\n";
            for(int i=1;i<burstTime;i++)
            {
                result+=(inTime+i) + " sn  " + "Process Going" + "   (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ (burstTime-i )+")"+"\n";
            }
            result+=outTime + " sn  " + "Process Finish" + "  (id:"+processId+ "  Priority:"+ priority + "  Remainder:"+ 0 +")"+"\n";
            return result;
        }

        return result;
    }
}
