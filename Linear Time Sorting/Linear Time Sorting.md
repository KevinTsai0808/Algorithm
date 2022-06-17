# Linear Time Sorting
前面實作的幾種排序演算法中，時間複雜度最快的為 Merge Sort，在Worst case情況下可以達到 O(nlogn)，事實上，在需要兩兩比較大小的排序演算法中，O(nlogn) 為此種演算法的下界。也就是說，當一個排序演算法需要進行比較大小的步驟，此演算法的時間複雜度無法比 O(nlogn) 還快，詳細證明會放在 medium，這邊就先略過。

這邊要介紹的三種演算法，由於沒有兩兩比較大小的步驟，因此時間複雜度最快都可以達到 O(n)，也就是 linear Time Sorting。
# Counting Sort：O(n + k)
>此演算法用來進行整數的排序，且所有的 input 會介於1到 k  
>利用一個長度為k的陣列紀錄 input 中每一個數出現的次數，接著陣列中每一個索引會加上前一個索引的值，也就是計算小於等於這個數的 input 有多少，最後根據此陣列將 input 的值放入 output 
- Pseudocode：（Counting Sort）
<img width="500" alt="截圖 2022-06-17 下午3 14 55" src="https://user-images.githubusercontent.com/103521272/174245855-43207ab6-b321-46e8-9e57-7aadca9e6750.png">
- Java：（Counting Sort）
<img width="500" alt="截圖 2022-06-17 下午3 22 59" src="https://user-images.githubusercontent.com/103521272/174247206-4bfac1a0-9242-4d3d-9b4c-74fb3d651483.png">

Counting Sort 的參數有三個，第一個就是 input 陣列，第二個是最後輸出的 output 陣列，第三個參數 k 則表示所有的 input 會小於等於 k 。 

首先要先建立長度為 k 的 c 陣列，接著去讀取 input 中每一個數放入 c 中。舉例而言，若是目前讀取的數為20，則會被放入 c[19]，讀取完 input 中所有數後，此時 c 陣列就存取了1~k 中每個數字出現的次數。

接著在24~26行，c 陣列中每一個元素會加上前一個元素的值，舉例來說，假設 c[1] = 1、c[2] = 0、c[3] = 1，那麼執行完後的 c[1] = 1、c[2] = 1、c[3] = 2，代表小於等於1的數有一個、小於等於2的數有一個、小於等於3的數有兩個

在29~33的迴圈中，由於 c 陣列目前儲存是小於等於此數的 input 有多少，因此可以發現 c 陣列中的每一個值就是該數字應該放入的位置加一。舉剛剛的例子，c[1] = 1、c[2] = 1、c[3] = 2，因此我們走訪 input 每一個數，當碰到 3 時，則去尋找 c[3] 的值，發現是 2 代表 3 在 output 中應該放在從前面數來第二個位置，也就是索引1。比較特別的是當我們走訪 input 時，是由最後一筆尋訪到第一筆，而不是從第一筆開始，由最後一筆開始可以保證 Counting Sort 為 stable 的演算法，也就是說，假設今天 input 存在兩個10，他們在 input 的前後順序是有意義的，而 stable 的演算法可以保證在排序之後兩個10的前後順序仍然和 input 相同。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-06-17 下午4 20 42" src="https://user-images.githubusercontent.com/103521272/174257853-f58f7f09-4c39-426d-999f-043f584d9ff7.png">
<img width="500" alt="截圖 2022-06-17 下午4 21 59" src="https://user-images.githubusercontent.com/103521272/174258062-eb2c1910-6731-42b5-a26a-ea648e2f5dad.png">







