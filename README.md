# Algorithm
在這邊會簡單介紹不同的演算法並利用Python實作，主要就是紀錄上課所學的內容

演算法就是將 input 透過一系列明確定義的計算步驟產生 output，input可能是空集合或是數值的集合，一個演算法的好壞取決於時間複雜度以及空間複雜度。

時間複雜度：在電腦上執行計算演算法的時間

空間複雜度：在電腦上執行計算演算法所佔用的記憶體資源

# Insertion sort：O(n^2)
將原始資料，也就是input中的每一筆未排序資料加入已排序好的資料中，接著和前面的資料做比較並插入合適的位置

Pseudocode:

![8_a](https://user-images.githubusercontent.com/103521272/163130955-3e006dc0-5c7b-4272-9c26-005bc3a7b826.gif)

Python:

<img width="638" alt="截圖 2022-04-13 下午4 16 52" src="https://user-images.githubusercontent.com/103521272/163131935-06c0c3ba-424b-4c15-a26e-913097872227.png">

# Merge sort：O(nlogn)
利用Divide-and-conquer完成排序，會將input原始資料分割成左半部分和右半部分，分割後的兩筆資料再接著往下分割直到資料內剩一個元素，接著只剩一個元素的左半資料和右半資料進行合併，合併的過程會藉由比較左半、右半資料內元素來進行排序，最後形成完整的排序資料

Pseudocode (Merge) :

<img width="336" alt="Owtfo" src="https://user-images.githubusercontent.com/103521272/163158082-e47366ad-3624-4729-a3e9-f269dedbc511.png">

Pseudocode (Merge sort) :

<img width="225" alt="wk49i" src="https://user-images.githubusercontent.com/103521272/163158251-2cf4fbae-dd29-4f11-8d28-3266af364866.png">

Python:

<img width="473" alt="截圖 2022-04-13 下午6 05 26" src="https://user-images.githubusercontent.com/103521272/163158307-0d9bf62e-38d0-4463-8c46-b9234dbc885d.png">





