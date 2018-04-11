// elegant but inefficiency solution!


  object Solution {
   object static {
       val empty = Array[Int]();
       lazy val fib : Stream[Int] = 0#::
                                    1#::
                                     fib.zip(fib.tail).map(n => {
                                        ((n._1.asInstanceOf[Long] + n._2.asInstanceOf[Long]) % (1<<31)).asInstanceOf[Int];
                                     });
       val last=fib(50000); // force precomputing of all range used here!
   };

   def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
    val len=a.length;
    if (len != b.length) return static.empty;
   
    var i: Int =0;
    b.map( b=> { a(i)= (static.fib(a(i)+1) % (1 << b)); i+=1; });
   
    return a;
   }
  };