import quicksort.QuickSort;

public class Main {

    public static void main(String[] args) {

        //System.out.println(ReversedStrings.solution5("Timon"));
        QuickSort.sortDesc(412347894);
        int[] array = {1048576, 32, 214748364, 1048576, 214748364, 32, 1024, 2048, 4096, 32, 1024, 65536, 32768, 32768, 65536, 2048, 4096, 1048576, 1024, 512, 256, 256, 512};

        for (int i : array)
            QuickSort.sortDesc(i);
    }
}
