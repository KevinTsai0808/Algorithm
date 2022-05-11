
# Heap sort：O(nlogn)
>先將原始資料透過遞迴比較方法形成樹的結構，也就是達成 Heap ，這個樹的特性是父節點會大於（小於）子節點<br>接著透過交換方法取得每一次迭代中樹的最大值（最小值）並放入陣列，最後得到完整排序資料

- Pseudocode：（Max-Heapify）
<img width="500" alt="截圖 2022-05-09 下午5 45 18" src="https://user-images.githubusercontent.com/103521272/167384664-93ee0cc7-e3a7-4e2c-b5c3-2e2e8b396778.png">

建立 Max-Heap 有兩個重點(這邊以由小到大的排列為例），首先是 Max-Heapify ，這個方法會定義目前元素在樹中的位置。<br>

+ Java：（Max-Heapify）
<img width="500" alt="截圖 2022-05-09 下午5 56 50" src="https://user-images.githubusercontent.com/103521272/167386625-1c2e9be9-0404-46e9-bf6d-e33f677165c5.png">

Max-Heapify 的參數分別是一個陣列以及陣列的 index ，首先存取 i 的子節點位置，接著定義樹的大小為 heap-size，也就是樹的節點數量，由於後面執行 sort 的時候 heap-size 並不會總是等於陣列長度，因此只有當 heap-size 尚未被前面敘述定義時才會等於陣列長度。<br><br>

<img width="426" alt="截圖 2022-05-09 下午6 04 22" src="https://user-images.githubusercontent.com/103521272/167388016-cb5f1558-9572-4583-935d-272f98181ac6.png">
然後是父節點和子節點之間的比較，首先比較左邊子節點和父節點，較大的再和右邊子節點比較。<br><br>

<img width="337" alt="截圖 2022-05-09 下午6 11 34" src="https://user-images.githubusercontent.com/103521272/167389293-fbc6b6cf-e782-4210-b57c-efb2dcbd1099.png">
最後若目前的父節點不是三個中最大的，那麼就將最大的那個節點和父節點交換，交換以後原本的父節點再繼續和最大的那個節點的子節點進行比較，也就是重新執行 Max-Heap 。<br><br>
執行之後原本的父節點就會被排列在樹中適當的位置，也就是大於等於底下兩個分支並且小於目前位置的父節點。

***

- Pseudocode：（Build-Max-Heap） <br>
<img width="500" alt="截圖 2022-05-10 上午12 14 07" src="https://user-images.githubusercontent.com/103521272/167452611-1d239c8f-1c45-40a9-9c59-38bc43a19f06.png">

第二個重點是該從做幾次 Max-Heapify 來達到 Max-Heap，因此使用 Build-Max-Heap 。

+ Java：（Build-Max-Heap）<br>
<img width="407" alt="截圖 2022-05-10 上午12 44 44" src="https://user-images.githubusercontent.com/103521272/167457794-2f118efc-1bad-4514-a9ef-fb7c101cdd08.png">

同樣的只有當 heap-size 尚未被前面敘述定義時才會等於陣列長度。<br>
然後從最後一個父節點開始往上做 Max-Heapify，之所以由下往上是因為只要做完一次 Max-Heapify 就可以保證該節點以下都是 Max-Heap 。<br>

當 Build-Max-Heap 執行完後，每一個父節點都會比子節點還要大，然而這個條件並不足以完成排序，像是 [16, 3, 6, 1, 2, 5] 就是符合樹的條件但沒有排序完成的例子，因此我們要進行下一個步驟。

***

- Pseudocode：（Heapsort） <br>
<img width="500" alt="截圖 2022-05-10 上午10 48 28" src="https://user-images.githubusercontent.com/103521272/167532831-80cda8c0-906d-4b84-9817-8b76ba38235a.png">

Heapsort 函數利用前面定義的函數先建立 Max-Heap(Min-Heap)，接著進行最後的排序。

+ Java：（Heapsort）<br>
<img width="500" alt="截圖 2022-05-10 上午10 54 01" src="https://user-images.githubusercontent.com/103521272/167533460-e6bcb3f5-531d-4bc2-b7a1-f863bee89715.png">

Heapsort 的參數只有 input 陣列，首先就是利用前面定義的 Build-Max-Heap 建立好樹的結構，接著利用 for 迴圈每次取出第一個節點，也就是最大的節點。取出的方式是藉由交換第一個和最後一個節點，交換以後再將整個樹的大小減一。那麼原本的第一個節點就會被取出，並且樹目前除了第一個節點（原本的最後一個節點）其他都呈現 Heap 狀態，因此要對第一個節點進行 Max-Heapify。<br><br>
迴圈執行完後整個陣列就完成由小到大的排列了！




#  Quick sort：O(nlogn)
>先透過分割找出比基準點小的元素和比基準點大的元素<br>再針對兩個陣列繼續往下分割，最後得到完整排序資料。

- Pseudocode (Partition) :<br>

<img width="500" alt="截圖 2022-05-10 下午12 05 24" src="https://user-images.githubusercontent.com/103521272/167540527-5d9adbe5-c21e-482d-8890-f178c449272b.png">

這個函式是整個 Quicksort 的核心，我們會決定出一個基準點並分出比基準點小的元素和比基準點大的元素。
<br>這邊是用陣列最後一個元素當作基準點。還有其他方法像是取隨機和隨機三個數的中位數，這邊就先不加以介紹。
- Java (Partition) :<br>

<img width="500" alt="截圖 2022-05-10 下午2 54 37" src="https://user-images.githubusercontent.com/103521272/167566583-15bf42ce-c773-48df-98de-6f1f4b605a18.png">

首先設定最後一個元素為 pivot（基準點），接著將每一個元素和 pivot 做比較，j 變數代表目前做比較的數，i 變數代表了目前比 pivot 小的數的最後一個位置。<br>
假設要比較的數小於或是等於 pivot ，就會讓 i + 1（小於 pivot的數列 +1）然後 j 和 i 交換；假設要比較的數大於 pivot ，則 i 不變並進行下一個數的比較。<br>
比較完除了 pivot 的數後，最後將 i+1 位置的數和 pivot做交換，執行後 pivot 左邊的數代表小於等於 pivot ，而 pivot 右邊則是代表大於 pivot 的數。

***

- Pseudocode：（Quick sort） <br>


+ Java：（Quick sort）<br>
<img width="859" alt="截圖 2022-05-11 上午11 32 10" src="https://user-images.githubusercontent.com/103521272/167763716-f44b6676-9501-4fb6-8520-14da0840d41d.png">



<img width="500" alt="截圖 2022-05-11 上午9 44 31" src="https://user-images.githubusercontent.com/103521272/167752056-ca3e1791-2164-4d7c-a6b6-8d98ae651ab9.png">





















 





