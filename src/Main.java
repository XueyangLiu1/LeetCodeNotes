
public class Main {

    public static void main(String[] args){
//        TakeIntRtnIntSolutionService solution = new StudentAttendanceRecordImpl();
//        System.out.println(solution.returnAns(10101));
        TakeTwoStringRtnIntSolutionService solution = new LongestCommonSubsequenceImpl();
        System.out.println(solution.returnAns("",""));
        System.out.println(solution.returnAns("abcde","abd"));
        System.out.println(solution.returnAns("fhdjksfjks","fs"));
        System.out.println(solution.returnAns("dsfhjksd","i"));
        System.out.println(solution.returnAns("a",""));


    }
}
