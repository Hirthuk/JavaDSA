# **Ultimate In-Depth Guide to HashMaps & Related Map Structures in Java**

## **1. Introduction to HashMaps**
A **HashMap** is a **key-value pair** data structure that provides **O(1)** average-time complexity for `get()` and `put()` operations.

### **1.1 Why Use HashMaps?**
- **Fast lookups** (O(1) average, O(n) worst-case)
- **No duplicate keys** (each key maps to one value)
- **Flexible** (keys & values can be any object type)
- **Efficient** for frequency counting, caching, memoization

### **1.2 HashMap Declaration & Initialization**
```java
import java.util.HashMap;

// Basic HashMap
HashMap<String, Integer> map = new HashMap<>();

// With Initial Capacity (optimization)
HashMap<String, Integer> mapWithCapacity = new HashMap<>(20);

// From Existing Map
HashMap<String, Integer> copiedMap = new HashMap<>(map);
```

---

## **2. Core HashMap Operations**
### **2.1 Inserting Elements (`put()`)**
```java
map.put("Alice", 25);  
map.put("Bob", 30);  
map.put("Charlie", 35);  

// Overwrites existing key
map.put("Alice", 26);  // Updates Alice's age to 26
```

### **2.2 Accessing Elements (`get()`)**
```java
int age = map.get("Bob");  // 30  

// Safe get (returns null if key doesn't exist)
Integer age = map.get("David");  // null  

// Default value if key missing
int age = map.getOrDefault("David", -1);  // -1
```

### **2.3 Checking Key/Value Existence**
```java
boolean hasAlice = map.containsKey("Alice");  // true  
boolean hasAge40 = map.containsValue(40);  // false  
```

### **2.4 Removing Elements (`remove()`)**
```java
map.remove("Bob");  // Removes Bob's entry  

// Remove only if value matches
map.remove("Alice", 25);  // Only removes if Alice's age is 25
```

### **2.5 Size & Emptiness Checks**
```java
int size = map.size();  
boolean isEmpty = map.isEmpty();  
```

---

## **3. Iterating Through HashMaps**
### **3.1 Using `keySet()` (Iterate Keys)**
```java
for (String name : map.keySet()) {
    System.out.println(name + ": " + map.get(name));
}
```

### **3.2 Using `values()` (Iterate Values)**
```java
for (int age : map.values()) {
    System.out.println(age);
}
```

### **3.3 Using `entrySet()` (Most Efficient)**
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## **4. Advanced HashMap Techniques**
### **4.1 Handling Collisions**
- Java uses **chaining** (LinkedList → Balanced Tree if buckets grow large)
- **Load Factor** (default: 0.75) triggers resizing when 75% full

### **4.2 Custom Objects as Keys**
```java
class Student {
    String name;
    int id;
    
    // MUST override hashCode() and equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.id && name.equals(other.name);
    }
}

HashMap<Student, Integer> studentGrades = new HashMap<>();
```

### **4.3 Initial Capacity & Load Factor Tuning**
```java
// Initial capacity 100, load factor 0.6
HashMap<String, Integer> tunedMap = new HashMap<>(100, 0.6f);
```

---

## **5. Related Map Structures**
### **5.1 LinkedHashMap (Maintains Insertion Order)**
```java
LinkedHashMap<String, Integer> orderedMap = new LinkedHashMap<>();
orderedMap.put("Alice", 25);
orderedMap.put("Bob", 30);  // Iteration order: Alice → Bob
```

### **5.2 TreeMap (Sorted by Keys)**
```java
TreeMap<String, Integer> sortedMap = new TreeMap<>();
sortedMap.put("Charlie", 35);
sortedMap.put("Alice", 25);  // Iteration order: Alice → Charlie
```

### **5.3 ConcurrentHashMap (Thread-Safe)**
```java
ConcurrentHashMap<String, Integer> threadSafeMap = new ConcurrentHashMap<>();
```

### **5.4 IdentityHashMap (Uses == instead of equals())**
```java
IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
```

---

## **7. Time & Space Complexity**
| Operation | Time Complexity | Space |
|-----------|----------------|-------|
| `put()`   | O(1) avg, O(n) worst | O(n) |
| `get()`   | O(1) avg, O(n) worst | O(1) |
| `remove()`| O(1) avg, O(n) worst | O(1) |
| `containsKey()` | O(1) avg | O(1) |
| Iteration | O(n) | O(1) |

---

## **8. Pro Tips for HashMap Mastery**
✅ **Always override `hashCode()` and `equals()` for custom key objects**  
✅ **Use `entrySet()` for most efficient iteration**  
✅ **Prefer `getOrDefault()` to avoid null checks**  
✅ **Tune initial capacity if you know expected size**  
✅ **Consider `ConcurrentHashMap` for thread-safe applications**  



Would you like a deep-dive on **TreeMap vs HashMap** or **advanced collision resolution**? 🚀