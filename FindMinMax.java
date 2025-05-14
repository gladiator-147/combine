class MinMax {
    int min;
    int max;

    MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class FindMinMax {

    static MinMax findMinMax(int[] arr, int low, int high) {
        if (low == high) {
            return new MinMax(arr[low], arr[low]);
        }

        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                return new MinMax(arr[low], arr[high]);
            } else {
                return new MinMax(arr[high], arr[low]);
            }
        }

        int mid = (low + high) / 2;
        MinMax left = findMinMax(arr, low, mid);
        MinMax right = findMinMax(arr, mid + 1, high);

        int finalMin = (left.min < right.min) ? left.min : right.min;
        int finalMax = (left.max > right.max) ? left.max : right.max;

        return new MinMax(finalMin, finalMax);
    }

    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        System.out.print("Enter number of elements in the list: ");
        int len = System.in.read(buffer);
        int n = Integer.parseInt(new String(buffer, 0, len).trim());

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            len = System.in.read(buffer);
            arr[i] = Integer.parseInt(new String(buffer, 0, len).trim());
        }

        MinMax result = findMinMax(arr, 0, n - 1);

        System.out.println("\nMinimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);
    }
}