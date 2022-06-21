# Randomized Select
>在尚未排序的 input 中找尋第 i 小的值  
>首先呼叫 Partition 找出 i 位在哪個區間，接著遞迴呼叫 Randomized Select 縮小搜尋區間直到找出 i 
* Pseudocode：(Randomized Select)
<img width="500" alt="截圖 2022-06-21 下午2 59 15" src="https://user-images.githubusercontent.com/103521272/174736416-a9f6535d-56fb-4896-b6a5-5ae15dcffa63.png">

此演算法首先呼叫 Partition，若是 Partiton 回傳的索引值在 input 中剛好是第 i 小，則演算法執行結束，若非第 i 小，則透過比較k（回傳值在 input 中為第幾小）和 k 誰大誰小。  
如果 k 比較大，則可以確定第 i 小的數位在 pivot 之前的數列；如果 k 比較小，則可以確定第 i 小的數位在 pivot 之後的數列，接著針對子問題不斷呼叫 Randomized Select 直到找出 i 。

在 Best-case 中，可以在 O(n) 的情況下完成，也就是第一次 Partition 就找到第 i 小的數，然而在 Worst-case 中，假設要找最小的數，而每一次 Partition 都取到 input 中最大的值，則時間複雜度的遞迴式就會變成：T(n) = T(n - 1) + Θ(n)，如此一來時間複雜度就會變成 O(n^2)。

因此發展出了另一套演算法（以下稱為SELECT）使得 Randomized Select 在 Worst-case 也能在 O(n) 完成，以下是步驟：  
1. 將 input 的 n 個元素每5個分成一組，最後不滿5個數的自成一組，總共分成 n/5 （上取整）組。
2. 透過 Insertion Sort 找出每一組的中位數，計算結果會得出 n/5（上取整）個中位數。
3. 遞迴呼叫 SELECT 直到找出 n/5（上取整）個中位數中的中位數。
4. 以剛剛找出的中位數的中位數為 pivot ，執行 Partition 並且確定 pivot 為第 i 小的數
5. 如果 i = k，則傳回中位數中的中位數 ，演算法執行結束，如果 i 比 k 大，則在 pivot 之前的數列中呼叫 SELECT，如果 i 比 k 小，則在 pivot 之後的數列中呼叫 SELECT。

* Java：(SELECT)

<img width="500" alt="截圖 2022-06-21 下午11 37 15" src="https://user-images.githubusercontent.com/103521272/174840398-cde71e5d-9d52-4ae9-8984-182be515f3ba.png">

56 ~ 58行：如果 input 長度為1，則直接回傳該數。  

63 ~ 69行：將 input 進行分組並且找出每一組的中位數存入陣列中。  

71 ~ 75行：如果 input 長度不足5，則要當作 pivot 的數就是此唯一一組的中位數。  

77 ~ 79行：利用剛剛長度大於5的 input 算出的中位數陣列計算出中位數的中位數。  

 82 行：以中位數的中位數為 pivot 做 Partition。  
 
84 ~ 92行：判斷 Partition 回傳的值為第幾小的數 (i) 並且和 k（要尋找第 k 小的數） 比較，若是 k 比較小，則以 input 的頭到 pivot 前一位當作新的 input 執行 SELECT，若是 k 比較大，則以 pivot 後一位到 input 的尾當作新的 input 執行 SELECT，要注意的是此時要尋找的為第 k 減掉 i。


