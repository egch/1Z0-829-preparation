# Collections
## contains
it's `Object`, not the type of the Collection!
```java
boolean contains(Object o)
```
## Immutable Collections
```java
List<String> list = List.of("a", "b");
Set<String> set = Set.of("a", "b");  //accepts a vararg
List<String> listCopyOf = List.copyOf(list);  //accepts a Collection
List<String> listCopyOfSet = List.copyOf(set);
Set<String> setCopyOf = Set.copyOf(set);
Set<String> setCopyOfList = Set.copyOf(list);
```
### Sorting an immutable collection
```java
List<Integer> list = List.of(5, 3, 1);
//I cannot sort an immutable collection!
//Exception in thread "main" java.lang.UnsupportedOperationException
//	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
Collections.sort(list);
```
## TreeSet
````java
Comparator<Integer> comparator = (n1,n2)->n1-n2;
TreeSet<Integer> set1 = new TreeSet<>(comparator);
TreeSet<Integer> set2 = new TreeSet<>(Set.of(1, 2, 3));
````

## List
remove - mind the overloading of `remove()`
```java
//this remove the element at index 2, because here we call remove(int index)
list.remove(2); //[5,3,1]
//this removes element 1 as here we call remove(Object obj)
list.remove(Integer.valueOf(1)); //[5, 3]
```
[Overloading of remove](../src/main/java/org/enricogiurin/ocp17/book/ch9/RemoveFromList.java)
### Creating a List with Factory
[List Factory](../src/main/java/org/enricogiurin/ocp17/book/ch9/CreatingListWithFactory.java)
## Comparator
package: java.util
```java
int compare(T o1, T o2);
```
### reversed
```java
Comparator<T> reversed()
```
Returns a comparator that imposes the reverse ordering of this comparator.

## Comparable
package: java.lang
```java
int compareTo(T o1);
```

## Queue
![Methods of Queue.png](images/Queue.png)
### Main methods of Queue
The following **throw an exception** if something go wrong:
```java
public boolean add(E e);
public E element(); //equivalent to peek()
public E remove();
```

The following **do not throw an exception** if something go wrong:
```java
public boolean offer(E e);
public E peek();
public E poll();
```

## Deque

![Deque](images/Deque.png)
### Main methods of Deque
The following **throw an exception** if something go wrong:
```java
public void addFirst(E e);
public void addLast(E e);
public E getFirst();  //element not removed
public E getLast();  //element not removed
public E removeFirst();
public E removeLast();
```
The following **do not throw an exception** if something go wrong:
```java
public boolean offerFirst(E e);
public boolean offerLast(E e);
public E peekFirst();
public E peekLast();
public E pollFirst();
public E pollLast();
```


[Example Deque](../src/main/java/org/enricogiurin/ocp17/book/ch9/UsageOfDeque.java)

```java
//The offer() method inserts an element at the end of the queue
Deque<String> q = new ArrayDeque<>();
q.offer("dog"); // [dog]
q.offer("cat"); // [dog, cat]
q.offer("bunny"); // [dog, cat, bunny]
System.out.print(q.peek() + " " + q.size()); // dog 3
```

```java
public interface Deque<E> extends Queue<E> {/**/}
```
#### pop() vs poll()
When Deque is empty:
- `pop() throws java.util.NoSuchElementException`
- `poll()` returns null
```java
Deque<String> stack = new LinkedList<>();  //empty deque
String result = stack.poll();  //this returns null
System.out.println(result); //null
//Exception in thread "main" java.util.NoSuchElementException
String pop = stack.pop();
```
[DequeAsAStack](../src/main/java/org/enricogiurin/ocp17/book/ch9/DequeAsAStack.java)
### Stack
![Stack](images/Deque-Stack.png)



## Map
### foreach
```java
    Map<Integer, String> map = buildMap();
    BiConsumer<Integer, String> biConsumer =
        (key, value)-> System.out.println("key: %s - value: %s".formatted(key, value));
    //NOTE! it uses a BIConsumer, not a consumer!
    map.forEach(biConsumer);
```



 - LinkedList implements Deque
 - ArrayDeque implements Deque
## Collections and null values
- `ArrayList`: allows null
- `LinkedList`: allows null
- `HashSet`: allows null
- `TreeSet`: **DOES NOT** allow null
```java
Set<Integer> set = new TreeSet<>();
//Exception java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null
set.add(null);
```
