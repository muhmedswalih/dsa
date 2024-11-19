fun Bubblesort(arr: IntArray){
    var n = arr.size;
    for(i in 0 until n-1){
        for(j in 0 until n-i-1){
            if (arr[j] > arr[j+1]){
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
    }
}

}

fun main(){
    val arr = intArrayOf(3,6,1,8,4)
    println("Unsorted: ${arr.joinToString(",")}")
    Bubblesort(arr)
    println("Sorted: ${arr.joinToString(",")}")
}