
public class ArrayOps {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        int[] array1 = {1, 2, 1, 1, 2}; //defines array
        int[] array2= {1, 2, 3, 4};

        System.out.println(findMissingInt(array));
        System.out.println(secondMaxValue(array));
        System.out.println(containsTheSameElements(array1, array2));
        System.out.println(isSorted(array));

        }

    public static int findMissingInt (int [] array) 
    {
        int[] newArr = new int[array.length + 1]; //defines new array length + 1

        for (int i = 0; i < newArr.length; i++)
        {
            newArr[i] = i; //inserts values 0 - newArray length  0 1 2 3 4
        }

        int missing_Int = 0;
        boolean missing;
        for (int i = 0; i < newArr.length; i++)
        {
            missing = true;
            for (int j = 0; j < array.length; j++)
            {
                if (newArr[i] == array [j]) 
                {
                    missing = false;
                }
            }
            if (missing == true)
            {
                missing_Int = i;
            }
        }
        return missing_Int;
    }

    public static int secondMaxValue(int [] array)
    {
        int[] secondMax = maxSorted(array);
        return secondMax[1];
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) //if both arrays have same integers returns true
    {
        boolean flag = false;
        boolean numcheck = true;
        for (int i = 0; i < array1.length; i++) //checks array1 compared to array2
        {
            flag = false;
            for (int j = 0; j < array2.length; j++)
            {
                if (array1[i] == array2[j]) 
                {
                    flag = true;
                }
            }
            if (flag == false) numcheck = false; 
        }
        for (int i = 0; i < array2.length; i++) //checks array2 compared to array1
        {
            flag = false;
            for (int j = 0; j < array1.length; j++)
            {
                if (array2[i] == array1[j]) 
                {
                    flag = true;
                }
            }
            if (flag == false) numcheck = false;
        }
        return numcheck;
    }

    public static boolean isSorted(int [] array) 
    {
        boolean flag = true;
        int[] maxSorted = maxSorted(array);
        int maxInt = maxSorted[0];
        if(array[0] == maxInt)
        {
            for(int i = 0; i < array.length - 1; i++)
            {
                if (array[i] < array[i+1])
                {
                    flag = false;
                }
            }
        }
        else
        {
            for(int j = 0 ; j < array.length - 1; j++)
            {
                if (array[j] > array[j+1])
                {
                    flag = false;
                }
            }
        }
        return flag;

    }
    public static int[] maxSorted(int[] array) 
    {
        int[] sortedArray = new int[array.length];
        
        // Duplicates the original array to not run over it
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (int i = 0; i < sortedArray.length; i++) 
        {
            for (int j = i + 1; j < sortedArray.length; j++) 
            {
                if (sortedArray[i] < sortedArray[j]) {
                    // Swaps elements to sort in descending order
                    int temp = sortedArray[i]; //saves int in i
                    sortedArray[i] = sortedArray[j]; //swaps 
                    sortedArray[j] = temp; //puts second max in the next spot after first max
                }
            }
        }

        return sortedArray;
    }
}
