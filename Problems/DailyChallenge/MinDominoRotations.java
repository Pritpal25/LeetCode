package DailyChallenge;

class MinDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int[] aCount = new int[6];
        int[] bCount = new int[6];

        int aMaxCount = 0;
        int bMaxCount = 0;
        int aMaxIndex = Integer.MIN_VALUE;
        int bMaxIndex = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            aCount[A[i]-1] = aCount[A[i]-1] + 1;

            if (aCount[A[i]-1] > aMaxCount) {
                aMaxCount = aCount[A[i]-1];
                aMaxIndex = A[i]-1;
            }

            bCount[B[i]-1] = bCount[B[i]-1] + 1;

            if (bCount[B[i]-1] > bMaxCount) {
                bMaxCount = bCount[B[i]-1];
                bMaxIndex = B[i]-1;
            }
        }

        if (aMaxCount > bMaxCount) {
            return checkArray(B, A, aMaxIndex+1) ? A.length - aMaxCount : -1;
        }
        else if (aMaxCount < bMaxCount) {
            return checkArray(A, B, bMaxIndex+1) ? B.length - bMaxCount : -1;
        }
        else {
            return checkArray(B, A, aMaxIndex+1) ? (A.length - aMaxCount) : (checkArray(A, B, bMaxIndex+1) ? (B.length - bMaxCount) : -1);
        }
    }

    private boolean checkArray(int[] toCheck, int[] fromCheck, int value) {
        for (int i = 0; i < fromCheck.length; i++) {
            if (fromCheck[i] != value && toCheck[i] != value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[] {2,3,2,3,2,2};
        int[] B = new int[] {3,3,3,2,3,3};

        System.out.println(new MinDominoRotations().minDominoRotations(A, B));
    }
}