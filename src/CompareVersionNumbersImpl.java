public class CompareVersionNumbersImpl implements TakeTwoStringRtnIntSolutionService{
    @Override
    public int returnAns(String first, String second) {
        return compareVersion(first,second);
    }

    private int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int readHeadOne = 0, readHeadTwo = 0;
        while(readHeadOne<version1s.length && readHeadTwo<version2s.length){
            Integer currVersion1 = Integer.valueOf(version1s[readHeadOne]);
            Integer currVersion2 = Integer.valueOf(version2s[readHeadTwo]);
            if(currVersion1.equals(currVersion2)){
                readHeadOne++;
                readHeadTwo++;
                continue;
            }
            if(currVersion1>currVersion2){
                return 1;
            }else{
                return -1;
            }
        }
        while(readHeadOne<version1s.length){
            if(Integer.parseInt(version1s[readHeadOne])>0){
                return 1;
            }else{
                readHeadOne++;
            }
        }
        while(readHeadTwo<version2s.length){
            if(Integer.parseInt(version2s[readHeadTwo])>0){
                return -1;
            }else{
                readHeadTwo++;
            }
        }
        return 0;
    }
}
