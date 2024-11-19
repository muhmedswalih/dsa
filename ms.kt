fun MS(arr:IntArray):IntArray{
    if(arr.size <=1) return arr
    
    var mid =arr.size/2
    var left =arr.sliceArray(0 until mid)
    var right =arr.sliceArray(mid until arr.size)
    
    val LeftSort =MS(left)
    val RightSort=MS(right)
    
    return merge(LeftSort,RightSort)
    
}

fun merge(left:IntArray,right:IntArray):IntArray{
    val merged =IntArray(left.size+right.size)
    var i =0
    var j =0
    var k =0
    
    while(i < left.size && j < right.size){
        if(left[i] <= right[j]){
            merged[k++]=left[i++]
        }else{
            merged[k++]=right[j++]
        }
    }
    while(i<left.size){
        merged[k++]=left[i++]
    }
    
    while(j<right.size){
        merged[k++]=right[j++]
    }
    return merged
}

fun main(){
    val arr=intArrayOf(4,2,5,1,9,3)
    println("unsorted: ${arr.joinToString(", ")}")
    val sort =MS(arr)
    println("sorted: ${sort.joinToString(", ")}")

}