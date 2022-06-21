# Randomized Select
>在尚未排序的 input 中找尋第 i 小的值  
>首先呼叫 Partition 找出 i 位在哪個區間，接著遞迴呼叫 Partiton 縮小搜尋區間直到找出 i 
* Pseudocode：(Randomized Select)
* 
<img width="500" alt="截圖 2022-06-21 下午2 59 15" src="https://user-images.githubusercontent.com/103521272/174736416-a9f6535d-56fb-4896-b6a5-5ae15dcffa63.png">

此演算法首先呼叫 Partition，若是 Partiton 回傳的索引值在 input 中剛好是第 i 小，則演算法執行結束，若非第 i 小，則透過比較k（回傳值在 input 中為第幾小）和 k 誰大誰小。  
如果 k 比較大，則可以確定第 i 小的數位在 pivot 之前的數列；如果 k 比較小，則可以確定第 i 小的數位在 pivot 之後的數列。

在 Best-case 中，可以在 O(n) 的情況下完成，也就是第一次 Partition 就找到第 i 小的數，然而在 Worst-case 中，假設要找最小的數，而每一次 Partition 都取到 input 中最大的值，則時間複雜度的遞迴式就會變成：T(n) = T(n - 1) + Θ(n)，如此一來時間複雜度就會變成 O(n^2)。
