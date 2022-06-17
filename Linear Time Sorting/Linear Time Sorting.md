# Linear Time Sorting
前面實作的幾種排序演算法中，時間複雜度最快的為Merge Sort，在Worst case情況下可以達到O(nlogn)，事實上，在需要兩兩比較大小的排序演算法中，O(nlogn)為此種演算法的下界。也就是說，當一個排序演算法需要進行比較大小的步驟，此演算法的時間複雜度無法比O(nlogn)還快，詳細證明會放在medium，這邊就先略過。

這邊要介紹的三種演算法，由於沒有兩兩比較大小的步驟，因此時間複雜度最快都可以達到O(n)，也就是linear Time Sorting。
# Counting Sort：O(n + k)
>利用一個長度為k的陣列紀錄input中每一個數出現的次數，接著陣列中每一個索引會加上前一個索引的值，也就是計算小於等於這個數的input有多少，最後根據此陣列將input的值放入output
- Pseudocode：（Counting Sort）
<img width="500" alt="截圖 2022-06-17 下午3 14 55" src="https://user-images.githubusercontent.com/103521272/174245855-43207ab6-b321-46e8-9e57-7aadca9e6750.png">
- Java：（Counting Sort）
<img width="500" alt="截圖 2022-06-17 下午3 22 59" src="https://user-images.githubusercontent.com/103521272/174247206-4bfac1a0-9242-4d3d-9b4c-74fb3d651483.png">

