object Solution {
    object static {
        var fib: Array[Int] = new Array[Int](65536); // just in case (will be filled up just once anyway
        val empty = Array[Int]();
        
        fib(0)=0;
        fib(1)=1;
        
        for (i <- 2 to fib.length-1){
            fib(i) = ((fib(i-2).asInstanceOf[Long]+fib(i-1).asInstanceOf[Long]) % (1<<31)).asInstanceOf[Int];
            if (fib(i) < 0) println("ERROR at: "+i);
            
        }
        
        //println("fib10: "+fib(10)); // 55
    }
    
    def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
        val len=a.length;
        if (len!= b.length) return static.empty; // better safe than sorry!!
        var res : Array[Int] = new Array[Int](len);
        for (i <- 0 to len-1) res(i) = static.fib(a(i)+1) % (1 << b(i));
        return res;    
    }
}
