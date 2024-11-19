fun linearSearch(arr: Array<Int>, target: Int){
    for(i in arr.indices){
        if(arr[i]==target){
            println("position of the target is $i")
            return
        }
        
    }
    println("target not found")
    
}
fun main(){
    var arr=arrayOf(2,4,3,6,5,8,1)
    var target= 4
    linearSearch(arr, target)
}