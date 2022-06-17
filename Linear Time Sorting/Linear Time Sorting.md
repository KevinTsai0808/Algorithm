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

<img width="500" alt="截圖 2022-06-17 下午4 25 02" src="https://user-images.githubusercontent.com/103521272/174258579-da72c899-2bd5-446d-a405-d02e2b3ca175.png">

<img width="500" alt="截圖 2022-06-17 下午4 24 43" src="https://user-images.githubusercontent.com/103521272/174258643-abdfb339-6dbf-44e7-9b82-6dbbd4267d89.png">

# Radix Sort：O(d(n + k))
>對input的每一位數進行排序，而每一次的排序都使用 stable 的演算法，通常使用 Counting Sort
- Pseudocode：（Radix Sort）

<img width="500" alt="截圖 2022-06-17 下午4 58 06" src="https://user-images.githubusercontent.com/103521272/174264831-a8006f57-0a81-47de-bae2-af17ccb8b0c6.png">

- Java：（Radix Sort）

<img width="500" alt="截圖 2022-06-17 下午5 03 02" src="https://user-images.githubusercontent.com/103521272/174265761-588fff6f-3305-4225-964b-acc2b54dc3cf.png">

從 Pseudocode 可以看到 Radix Sort的參數中除了 input 還有 d ，d 代表的是位數，每一個位數都屌表要進行一次排序，為了找出 d 是多少，我們首先利用 findmax 找出 input 中最大的數，並且取的該值總共有幾位數，而 exp 變數是為了取得每一位數的值，會在 Counting Sort 中用到。

找出 d 之後，接著從1（個位數）開始到 d ，對每一位數進行 Counting Sort，而每次迴圈傳入 Counting Sort 的參數會是前一次排好之後的陣列。

<img width="500" alt="截圖 2022-06-17 下午5 36 27" src="https://user-images.githubusercontent.com/103521272/174271899-e8d63f1e-b0db-4ac3-9202-53dddaee7e36.png">

由於上面已經介紹了 Counting Sort 這邊就不贅述，不太一樣的是由於每一位數的值為0~9，因此 c 陣列的長度為10，而在 c 陣列中，可以看到儲存的值為(arr[i]/exp)%10，在第一次迴圈時，exp傳入的值為1，arr[i] % 10可以得到個位數的值，而第二次迴圈時，exp傳入的值為10，arr[i]/10 % 10可以得到十位數的值，依此類推。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-06-17 下午6 16 24" src="https://user-images.githubusercontent.com/103521272/174278967-fc8386f0-8d5e-4fc4-a9ae-59e4c44b27dc.png">

<img width="500" alt="截圖 2022-06-17 下午6 16 44" src="https://user-images.githubusercontent.com/103521272/174279023-021d5633-4c72-4300-bf3e-1f4c60f3ec2a.png">

# Bucket Sort：Worst:O(n^2) Best:O(n)
>此演算法假設 input 為隨機分佈在[0,1)區間內的的浮點數  
>根據 input 大小建立相對應數量的桶子，每一個桶子代表一個 LinkedList  
>待 input 每一個元素加入到桶子後，由於可能存在多個元素於一個桶子的情況，因此對每一個 LinkedList 進行排序  
>最後將每一個 LinkedList 進行串接
- Pseudocode：（Radix Sort）





