def len[T](xs: Seq[T]): Int = xs.foldLeft(0)((count, _) => count + 1)
def len2(xs: Seq[?]): Int = xs.foldLeft(0)((count, _) => count + 1)

def multiply[T : Numeric](xs: Seq[T]): T = 
  xs.reduceLeft((x1,x2) => summon[Numeric[T]].times(x1,x2))

val ints = Seq(1,2,3,4,5)
val doubles = ints.map(_ * 1.1)

len(ints)
len(doubles)
multiply(ints)
multiply(doubles)
