import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {


    }

    public static int scoreDiff(List<List<Integer>> board) {
        int tomScore = 0;
        int jerryScore = 0;
        int nCol = board.get(0).size();
        List<Integer> colmn = new ArrayList<>();
        List<Integer> maxValuesColumn = new ArrayList<>();
        for (int c = 0; c < nCol; c++) {
            for(List<Integer> row : board){
                colmn.add(row.get(c));
                maxValuesColumn.add(colmn.stream().max(Integer::compareTo).get());
            }
        }

        boolean tomTurn = true;
        maxValuesColumn.sort(Comparator.reverseOrder());

        for(Integer maxValue: maxValuesColumn){
            if(tomTurn){
                tomScore+=maxValue;
                tomTurn = false;
            }
            else{
                jerryScore+=maxValue;
                tomTurn = true;
            }
        }
        return tomScore-jerryScore;
    }
}
