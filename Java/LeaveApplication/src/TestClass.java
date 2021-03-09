public void getLocks(Object a, Object b)
{
 synchronized(a)
 {
  synchronized(b)
  {
    //do something
  }
 }
}
and the following instantiations: 
Object obj1 = new Object();
Object obj2 = new Object();
