object Solution {

  def solution(N: Int): Int = {
    var mask        :Int    =   0x80000000
    var gap         :Int    =   0
    var currGap     :Int    =  -1
    var i           :Int    =   0
    
   while ( i < 32 && !(0 ==(N & ~mask))) {
        var hit :Int      = N &  mask;
        if (0 == hit) {
            if (currGap >= 0) currGap+=1;
        }
        else{
            if (currGap > gap) gap = currGap;
                currGap=0;  
        }
        mask >>>=1;
        i+=1;
    }
    return gap;
  }
}
