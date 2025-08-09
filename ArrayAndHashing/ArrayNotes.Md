# **Ultimate In-Depth Guide to Arrays in Java for DSA**  

Arrays are the **most fundamental** data structure in programming. Mastering them is crucial before moving to complex topics like HashMaps, Linked Lists, or Trees.  

This guide covers **everything** about Arrays in Java—from basic operations to advanced techniques used in competitive programming and interviews.  

---

## **1. Array Fundamentals in Java**  
### **1.1 What is an Array?**  
- A **fixed-size**, **contiguous memory block** storing elements of the **same type**.  
- **Index-based access** (starts at `0`).  
- **Static** (size cannot change after creation).  

### **1.2 Array Declaration & Initialization**  
#### **Syntax:**  
```java
// Declaration
dataType[] arrayName;  

// Initialization (with size)
arrayName = new dataType[size];  

// Declaration + Initialization
dataType[] arrayName = {val1, val2, val3, ...};  
```  

#### **Examples:**  
```java
int[] numbers = new int[5];  // [0, 0, 0, 0, 0]
String[] names = {"Alice", "Bob", "Charlie"};  
boolean[] flags = new boolean[3];  // [false, false, false]
```  

### **1.3 Accessing & Modifying Elements**  
```java
int[] arr = {10, 20, 30, 40, 50};  

// Accessing
int first = arr[0];  // 10  
int last = arr[arr.length - 1];  // 50  

// Modifying
arr[1] = 25;  // [10, 25, 30, 40, 50]  
```  

### **1.4 Array Length Property**  
```java
int[] nums = {5, 10, 15};  
System.out.println(nums.length);  // 3  
```  
⚠️ **Note:** `length` is a **property**, not a method (unlike `String.length()`).  

---

## **2. Array Operations & Common Methods**  
### **2.1 Iterating Through an Array**  
#### **Using For Loop:**  
```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```  
#### **Using Enhanced For Loop (For-Each):**  
```java
for (int num : arr) {
    System.out.print(num + " ");
}
```  

### **2.2 Copying Arrays**  
#### **Method 1: `Arrays.copyOf()`**  
```java
import java.util.Arrays;

int[] original = {1, 2, 3};  
int[] copy = Arrays.copyOf(original, original.length);  
```  

#### **Method 2: `System.arraycopy()`**  
```java
int[] newArr = new int[original.length];  
System.arraycopy(original, 0, newArr, 0, original.length);  
```  

### **2.3 Sorting Arrays**  
#### **Ascending Order:**  
```java
int[] nums = {5, 2, 9, 1, 5};  
Arrays.sort(nums);  // [1, 2, 5, 5, 9]  
```  

#### **Descending Order:**  
```java
Integer[] nums = {5, 2, 9, 1, 5};  // Must use Integer, not int  
Arrays.sort(nums, Collections.reverseOrder());  // [9, 5, 5, 2, 1]  
```  

### **2.4 Searching in Arrays**  
#### **Linear Search (O(n)):**  
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;  // Not found
}
```  

#### **Binary Search (O(log n)):**  
```java
int[] sortedArr = {1, 3, 5, 7, 9};  
int index = Arrays.binarySearch(sortedArr, 5);  // Returns 2  
```  
⚠️ **Requires sorted array!**  

### **2.5 Comparing Arrays**  
```java
int[] arr1 = {1, 2, 3};  
int[] arr2 = {1, 2, 3};  

boolean isEqual = Arrays.equals(arr1, arr2);  // true  
```  

---

## **3. Multi-Dimensional Arrays (2D, 3D, etc.)**  
### **3.1 2D Array Declaration & Initialization**  
```java
int[][] matrix = new int[3][3];  // 3x3 grid (all 0s)  

// Manual initialization  
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};  
```  

### **3.2 Accessing & Modifying 2D Arrays**  
```java
int val = grid[1][2];  // 6  
grid[0][1] = 10;  // Changes 2 → 10  
```  

### **3.3 Iterating Through 2D Arrays**  
```java
for (int i = 0; i < grid.length; i++) {  
    for (int j = 0; j < grid[i].length; j++) {  
        System.out.print(grid[i][j] + " ");  
    }  
    System.out.println();  
}  
```  

---

## **4. Dynamic Arrays (ArrayList)**  
Since Java arrays are **fixed-size**, we use `ArrayList` for dynamic resizing.  

### **4.1 ArrayList Basics**  
```java
import java.util.ArrayList;  

ArrayList<Integer> list = new ArrayList<>();  

// Adding elements  
list.add(10);  
list.add(20);  
list.add(30);  

// Accessing elements  
int first = list.get(0);  // 10  

// Modifying elements  
list.set(1, 25);  // Changes 20 → 25  

// Removing elements  
list.remove(0);  // Removes 10  

// Size  
int size = list.size();  // 2  

// Iterating  
for (int num : list) {  
    System.out.println(num);  
}  
```  

### **4.2 ArrayList vs. Array**  
| Feature        | Array | ArrayList |
|---------------|-------|-----------|
| **Size**      | Fixed | Dynamic   |
| **Performance** | Faster | Slightly slower |
| **Methods**   | Basic | More utility methods (`add()`, `remove()`, etc.) |
| **Primitives** | Supports `int`, `char`, etc. | Only objects (`Integer`, `String`) |


---

## **6. Time & Space Complexity Cheatsheet**  
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Access (`arr[i]`) | **O(1)** | O(1) |
| Search (Linear) | **O(n)** | O(1) |
| Search (Binary) | **O(log n)** | O(1) |
| Insertion (At End) | **O(1)** | O(1) |
| Insertion (At Start/Middle) | **O(n)** (Shifting) | O(1) |
| Deletion | **O(n)** (Shifting) | O(1) |
| Sorting (`Arrays.sort()`) | **O(n log n)** | O(1) (In-place) |
