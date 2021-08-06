package Arrays_Lists;

public class GasStation {
    public static int canCompleteCircuitOne(int[] gas, int[] cost) {
        int nodesNumber = gas.length; //same as cost length
        int overallBudget = 0;
        int res = 0;

        for(int i=0; i<nodesNumber; i++) {
            overallBudget = gas[i];
            for(int j=0; j<nodesNumber; j++) {
                if(overallBudget<cost[(i+j)%nodesNumber]) {
                    overallBudget = -1;
                    break;
                }
                overallBudget = overallBudget - cost[(i+j)%nodesNumber] + gas[(i+j)%nodesNumber];

            }
            if(overallBudget<0)
                res = -1;
            else
                res = i;
        }
        return res;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalBalance = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        int currGas = gas[leftPtr] - cost[leftPtr];


        int nodeLength = gas.length;
        while(rightPtr > (leftPtr%nodeLength)) {
            totalBalance += gas[rightPtr] - cost[rightPtr];
            if(totalBalance<0) {
                leftPtr = (rightPtr+1)%nodeLength;
                totalBalance = 0;
            }
            rightPtr++;
        }
        return totalBalance > 0 ? leftPtr : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
//        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }
}
