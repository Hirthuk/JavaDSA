# **Ultimate In-Depth Guide to Strings in Java for DSA**

## **1. String Fundamentals in Java**

### **1.1 What is a String?**
- A sequence of characters (`char`) in Java
- **Immutable** (cannot be changed after creation)
- Stored in the **String Pool** (for memory optimization)
- Implements `CharSequence`, `Serializable`, and `Comparable`

### **1.2 String Creation**
```java
// Literal (stored in String Pool)
String s1 = "Hello";  

// Using new (creates new object in heap)
String s2 = new String("Hello");  

// From char array
char[] chars = {'H', 'e', 'l', 'l', 'o'};
String s3 = new String(chars);
```

### **1.3 Important String Properties**
```java
String str = "Java";

// Length
int len = str.length();  // 4

// Empty check
boolean isEmpty = str.isEmpty();  // false

// Character access
char firstChar = str.charAt(0);  // 'J'
```

## **2. String Operations & Methods**

### **2.1 Comparison Methods**
```java
String a = "apple";
String b = "Apple";

// Case-sensitive
boolean equals = a.equals(b);  // false

// Case-insensitive
boolean equalsIgnoreCase = a.equalsIgnoreCase(b);  // true

// Lexicographical comparison
int compare = a.compareTo(b);  // > 0 (ASCII difference)

// Reference comparison
boolean sameRef = (a == b);  // false (checks memory address)
```

### **2.2 Searching in Strings**
```java
String text = "Hello World";

// Contains substring
boolean hasHello = text.contains("Hello");  // true

// Index of first occurrence
int firstO = text.indexOf('o');  // 4

// Index of last occurrence
int lastO = text.lastIndexOf('o');  // 7

// Starts/Ends with
boolean starts = text.startsWith("He");  // true
boolean ends = text.endsWith("ld");  // true
```

### **2.3 String Manipulation**
```java
String original = "  Java DSA  ";

// Trimming whitespace
String trimmed = original.trim();  // "Java DSA"

// Case conversion
String upper = original.toUpperCase();  // "  JAVA DSA  "
String lower = original.toLowerCase();  // "  java dsa  "

// Replacement
String replaced = original.replace('a', 'x');  // "  Jxvx DSA  "
String regexReplaced = original.replaceAll("\\s+", "-");  // "--Java-DSA--"

// Substring
String sub = original.substring(2, 6);  // "Java"
```

### **2.4 Splitting & Joining**
```java
String csv = "apple,orange,banana";

// Splitting
String[] fruits = csv.split(",");  // ["apple", "orange", "banana"]

// Joining (Java 8+)
String joined = String.join("; ", fruits);  // "apple; orange; banana"
```

## **3. String Conversion & Parsing**

### **3.1 Primitive ↔ String Conversion**
```java
// Number to String
String numStr = String.valueOf(42);  // "42"

// String to Number
int num = Integer.parseInt("42");
double d = Double.parseDouble("3.14");

// Character array conversion
char[] chars = "hello".toCharArray();
String fromChars = new String(chars);
```

### **3.2 StringBuilder & StringBuffer**
```java
// StringBuilder (faster, not thread-safe)
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();  // "Hello World"

// StringBuffer (thread-safe, slightly slower)
StringBuffer sbf = new StringBuffer();
sbf.append("Safe");
sbf.append(" ");
sbf.append("String");
String safeResult = sbf.toString();
```

## **4. Advanced String Techniques**

### **4.1 String Pool & Interning**
```java
String a = "hello";  // String Pool
String b = "hello";  // Reuses from Pool
String c = new String("hello");  // New object in heap

System.out.println(a == b);  // true (same reference)
System.out.println(a == c);  // false (different references)

// Manual interning
String d = c.intern();  // Returns pooled version
System.out.println(a == d);  // true
```

### **4.2 Regular Expressions**
```java
String text = "Email: test@example.com, Phone: 123-456-7890";

// Pattern matching
boolean hasEmail = text.matches(".*@.*");  // true

// Extract matches
Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());  // "123-456-7890"
}
```

### **4.3 String Formatting**
```java
// Classic printf-style
String formatted = String.format("Name: %s, Age: %d", "Alice", 25);

// Java 15+ Text Blocks
String json = """
    {
        "name": "Alice",
        "age": 25
    }
    """;
```

## **5. Common String Problems (Neetcode 150)**

char[] charArray = str.charArray() convert the String to array of character in the string of Java

### **Easy Problems**
1. **Valid Palindrome** (Two Pointers)
2. **Reverse String** (In-place Array Manipulation)
3. **Valid Anagram** (Frequency Counting)
4. **First Unique Character** (HashMap Approach)

### **Medium Problems**
5. **Longest Substring Without Repeating Characters** (Sliding Window)
6. **Longest Palindromic Substring** (Expand Around Center)
7. **String to Integer (atoi)** (Edge Case Handling)
8. **Group Anagrams** (HashMap + Sorting)

### **Hard Problems**
9. **Minimum Window Substring** (Sliding Window + HashMap)
10. **Regular Expression Matching** (DP Solution)
11. **Word Break** (Memoization/DP)

## **6. Time & Space Complexity**

| Operation | Time Complexity | Space |
|-----------|----------------|-------|
| length() | O(1) | O(1) |
| charAt() | O(1) | O(1) |
| substring() | O(1)* | O(n) |
| concat() | O(n) | O(n) |
| compareTo() | O(n) | O(1) |
| indexOf() | O(nm) | O(1) |
| replace() | O(n) | O(n) |
| split() | O(n) | O(n) |

*Substring was O(1) in older Java versions, now typically O(n)

## **7. Pro Tips for String Mastery**

✅ **Prefer `StringBuilder` for concatenation in loops**  
✅ **Understand immutability implications for performance**  
✅ **Master sliding window techniques for substring problems**  
✅ **Practice pattern matching with regular expressions**  
✅ **Learn trie data structure for advanced string problems**  

## **8. Next Steps**

1. Solve **all Neetcode string problems**  
2. Implement **common string algorithms**:
   - KMP (Pattern Matching)
   - Rabin-Karp (Rolling Hash)
   - Manacher's (Palindrome)  
3. Explore **Tries (Prefix Trees)** for word problems  

Would you like a deep-dive on **string encoding (Unicode/UTF-8)** or **advanced pattern matching algorithms**? 🚀