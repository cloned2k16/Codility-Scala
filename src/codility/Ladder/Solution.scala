object Solution {
    object static {
      val cacheSz = 50000;
      val empty   = Array[Int]();
      var fibCache:    Array[Int] = new Array[Int](cacheSz);

      def fib (n:Int) :Int = { // let's add resiliency ..
        if (n<cacheSz) return fibCache(n);
        else { // not in cache!
          return ( ( fib(n-1).asInstanceOf[Long] + fib(n-2).asInstanceOf[Long] ) % ((1<<31).asInstanceOf[Long])).asInstanceOf[Int]; 
        }
      }
      
      
      fibCache(0)=0;
      fibCache(1)=1;
      
      for (i <- 2 to fibCache.length-1) {
        fibCache(i)  =   ( (fibCache(i-2).asInstanceOf[Long] + fibCache(i-1).asInstanceOf[Long]) % ((1<<31).asInstanceOf[Long])).asInstanceOf[Int];    
      }        
    }    
	
    def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
        val len=a.length;
        if (len!= b.length) return static.empty; // better safe than sorry!!
        var res : Array[Int] = new Array[Int](len);
        for (i <- 0 to len-1) res(i) = static.fib(a(i)+1) % (1 << b(i));
        return res;    
    }
}
